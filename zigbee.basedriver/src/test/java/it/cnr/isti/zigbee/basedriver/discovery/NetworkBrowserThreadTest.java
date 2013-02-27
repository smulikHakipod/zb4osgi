/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package it.cnr.isti.zigbee.basedriver.discovery;
import static org.easymock.classextension.EasyMock.*;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.api.ZigBeeNode;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolPacketStream;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_REQ;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_RSP;
import com.itaca.ztool.util.ByteUtils;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.6.0 - Revision 60
 *
 */
public class NetworkBrowserThreadTest {

	private static final Logger logger = LoggerFactory.getLogger(NetworkBrowserThreadTest.class);

	private ConfigurationService cs = null;
	private BundleContext bc = null;
	
	@Before
	public void createActivatorStub() {
		cs = createConfigurationServiceStub();
		bc = createBundleContextStub();
		Activator.setStubObjectes(cs, bc);
	}
	
	public BundleContext createBundleContextStub() {		
		BundleContext strub = createMock(BundleContext.class);
		
		try {
			expect(strub.getServiceReferences( (String) anyObject(), (String) anyObject() ) )
				.andReturn( null )
				.anyTimes();
		} catch (InvalidSyntaxException ex) {
		}
		replay(strub);
		
		return strub;
	}
	
	public ConfigurationService createConfigurationServiceStub() {		
		ConfigurationService stub = createMock(ConfigurationService.class);
		
		expect(stub.getNetworkBrowsingPeriod())
			.andReturn( new Long(5 * 1000) )
			.anyTimes();
		
		expect(stub.getPanId())
			.andReturn( new Short( (short) 13531 ) )
			.anyTimes();
		
		replay(stub);
		
		return stub;
	}
	
	/**
	 * Testing a network with the dongle and 7 devices connected to it that do not answer
	 * 
	 * Test method for {@link it.cnr.isti.zigbee.basedriver.discovery.NetworkBrowserThread#run()}.
	 */
	@Test
	public void testNetwork_7d() {
		SimpleDriver driver = createMock(SimpleDriver.class);
		
		expect( driver.sendZDOIEEEAddressRequest( EasyMock.isA(ZDO_IEEE_ADDR_REQ.class) ) )
			.andReturn( new ZDO_IEEE_ADDR_RSP( ByteUtils.fromBase16toIntArray(				
						"0x00 0xfa 0x6b 0x25 0x01 0x00 0x4b 0x12 0x00 0x00 0x00 0x00 0x07 0xb8 0x3c 0x32 0x65 0x6f 0x79 0x01 0x00 0x70 0x79 0x3e 0x14 0x7b 0x28"
			) ) ); 
		
		expect(driver.sendZDOIEEEAddressRequest( EasyMock.isA(ZDO_IEEE_ADDR_REQ.class) ) )
			.andReturn( null )
			.times( 7 );
		replay(driver);
		
		ImportingQueue queue = new ImportingQueue();
		NetworkBrowserThread browser = new NetworkBrowserThread( queue, driver );
		Thread thread = new Thread(browser,NetworkBrowserThread.class.getName());
		thread.start();
		
		ThreadUtils.waitNonPreemptive(1 * 1000);
		browser.end();
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
		
		final int SIZE = 1;
		for (int i = 0; i < SIZE; i++) {
			queue.pop();
		}
		assertTrue("queue had more than "+SIZE+" element", queue.isEmpty() );
	}


	/**
	 * Testing a network with the dongle and 19 devices connected to it that do not answer
	 * 
	 * Test method for {@link it.cnr.isti.zigbee.basedriver.discovery.NetworkBrowserThread#run()}.
	 */
	@Test
	public void testNetwork_19d() {
		SimpleDriver driver = createMock(SimpleDriver.class);
		int DEVICES_COUNT = 0;
		String[] packets = new String[]{
		    "0xfe 0x1b 0x45 0x81 0x00 0xfa 0x6b 0x25 0x01 0x00 " +
		        "0x4b 0x12 0x00 0x00 0x00 0x00 0x07 0x01 0x00 0x3e " +
		        "0x14 0x7b 0x28 0xb8 0x3c 0xf5 0x50 0x32 0x65 0x6f " +
		        "0x79 0x2c", /* 0 */
		    null, /* 31087 */
		    null, /* 25906 */
		    "0xfe 0x11 0x45 0x81 0x00 0x9d 0x0f 0x03 0x00 0x00 " +
		        "0x4b 0x12 0x00 0xf5 0x50 0x00 0x02 0x24 0x65 0xf6 " +
		        "0x50 0x5d", /* 20725 */
		    null, /* 20726 */
		    null, /* 25892 */
		    "0xfe 0x11 0x45 0x81 0x00 0xac 0x0b 0x03 0x00 0x00 " +
		        "0x4b 0x12 0x00 0xb8 0x3c 0x00 0x02 0xe7 0x50 0xb9 " +
		        "0x3c 0x9c" /* 15544 */,
		    null, /* 15545 */
		    null, /* 20711 */
		    "0xfe 0x15 0x45 0x81 0x00 0xad 0x15 0x03 0x00 0x00 " +
		        "0x4b 0x12 0x00 0x7b 0x28 0x00 0x04 0x7c 0x28 0xd9 " +
		        "0x2b 0x36 0x2f 0x93 0x32 0x7a" /* 10363 */,
		    null, /* 12947 */
		    null, /* 12086 */		    
		    "0xfe 0x0d 0x45 0x81 0x00 0xac 0x15 0x03 0x00 0x00 " +
		        "0x4b 0x12 0x00 0xd9 0x2b 0x02 0x00 0xda", /* 11225 */
		    "0xfe 0x0d 0x45 0x81 0x00 0x1b 0x0e 0x03 0x00 0x00 " +
		        "0x4b 0x12 0x00 0x7c 0x28 0x28 0x00 0xfa", /* 10364 */
		    "0xfe 0x13 0x45 0x81 0x00 0xf8 0x0d 0x03 0x00 0x00 " +
    		    "0x4b 0x12 0x00 0x3e 0x14 0x00 0x03 0x3f 0x14 0x9c " +
    		    "0x17 0xf9 0x1a 0x12", /* 5182 */
		    null, /* 6905 */
	        "0xfe 0x0d 0x45 0x81 0x00 0x6e 0x0f 0x03 0x00 0x00 0x4b " +
	            "0x12 0x00 0x9c 0x17 0x00 0x00 0x79", /* 6044 */
            "0xfe 0x0d 0x45 0x81 0x00 0x69 0x16 0x03 0x00 0x00 0x4b " +
                "0x12 0x00 0x3f 0x14 0xff 0x00 0x38", /* 5183 */
            "0xfe 0x0d 0x45 0x81 0x00 0xae 0x0b 0x03 0x00 0x00 0x4b " +
                "0x12 0x00 0x01 0x00 0x00 0x00 0x37", /* 1 */
		};
		
		String[] payloads = new String[]{
				"0x00 0xfa 0x6b 0x25 0x01 0x00 0x4b 0x12 0x00 0x00 0x00 0x00 0x07 0x01 0x00 0x3e 0x14 0x7b 0x28 0xb8 0x3c 0xf5 0x50 0x32 0x65 0x6f 0x79",					
				null,
				null,
				"0x00 0x9d 0x0f 0x03 0x00 0x00 0x4b 0x12 0x00 0xf5 0x50 0x00 0x02 0x24 0x65 0xf6 0x50",
				null,
				"0x00 0xac 0x0b 0x03 0x00 0x00 0x4b 0x12 0x00 0xb8 0x3c 0x00 0x02 0xe7 0x50 0xb9 0x3c"	
		};
		
		String[] answers = packets;
		for (int i = 0; i < answers.length; i++) {
			if ( answers[i] == null ) {
				expect( driver.sendZDOIEEEAddressRequest( EasyMock.isA(ZDO_IEEE_ADDR_REQ.class) ) )
					.andReturn( null ); 
				continue;
			}
			DEVICES_COUNT++;
			expect( driver.sendZDOIEEEAddressRequest( EasyMock.isA(ZDO_IEEE_ADDR_REQ.class) ) )
				.andReturn( (ZDO_IEEE_ADDR_RSP) ZToolPacketStream.parsePacket( 
						ByteUtils.fromBase16toIntArray( answers[i] )
				) ); 
		}
		
		replay(driver);
		
		ImportingQueue queue = new ImportingQueue();
		NetworkBrowserThread browser = new NetworkBrowserThread( queue, driver );
		Thread thread = new Thread(browser,NetworkBrowserThread.class.getName());
		thread.start();
		
		ThreadUtils.waitNonPreemptive(1 * 1000);
		browser.end();
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
		assertEquals( "The number of device discovered differs", DEVICES_COUNT, queue.size() );
	}

}
