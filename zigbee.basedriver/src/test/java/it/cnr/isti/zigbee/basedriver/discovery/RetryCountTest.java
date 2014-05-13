/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
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

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertNull;
import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.DuplicateMacPolicy;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.lang.Thread.UncaughtExceptionHandler;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_REQ;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * 
 */
public class RetryCountTest {

	private static final Logger logger = LoggerFactory
			.getLogger(RetryCountTest.class);

	private ConfigurationService cs = null;
	private BundleContext bc = null;

	private int[] retryValue = new int[]{4,10};
	private int[] retryInvokation = new int[]{retryValue[0]+1,retryValue[1]+1};

	private BundleContext stub;

	private ConfigurationService csStub;

	private Throwable testResult = null;

	
	
	@Before
	public void createActivatorStub() {
		cs = createConfigurationServiceStub();
		bc = createBundleContextStub();
		Activator.setStubObjectes(cs, bc);
	}

	public BundleContext createBundleContextStub() {
		stub = createStrictMock(BundleContext.class);

		try {
			expect(
					stub.getServiceReferences((String) anyObject(),
							(String) anyObject())).andReturn(null).anyTimes();
		} catch (InvalidSyntaxException ex) {
		}
		replay(stub);

		return stub;
	}

	public ConfigurationService createConfigurationServiceStub() {
		csStub = createMock(ConfigurationService.class);

		expect(csStub.getFirstFreeEndPoint()).andReturn(new Integer(2))
				.anyTimes();

		expect(csStub.getDeviceInspectionPeriod()).andReturn(new Long(250))
				.anyTimes();

		
		
		expect(csStub.getMessageRetryCount()).andReturn(retryValue[0])
				.times(retryInvokation[0]).andReturn(retryValue[1])
				.times(retryInvokation[1]);
		

		expect(csStub.getMessageRetryDelay()).andReturn(new Integer(100))
				.anyTimes();

		expect(csStub.getPanId()).andReturn(new Short((short) 13531)).anyTimes();

		expect(csStub.getDiscoveryDuplicateMacPolicy()).andReturn(DuplicateMacPolicy.Ignore).anyTimes();

		replay(csStub);

		return csStub;
	}

	@Test
	public void testRetryCount() {		
	
		SimpleDriver driver = createStrictMock(SimpleDriver.class);
		expect(
				driver.sendZDOActiveEndPointRequest(isA(ZDO_ACTIVE_EP_REQ.class)))
				.andReturn(null).anyTimes();
		replay(driver);

		ImportingQueue queue = new ImportingQueue();
		queue.push(new ZToolAddress16(0x00, 0x01), new ZToolAddress64(
				"00 12 4B 00 00 03 15 AD"));
		DeviceBuilderThread builder = new DeviceBuilderThread(queue, driver);
		Thread thread = new Thread(builder, DeviceBuilderThread.class.getName());
		thread.start();
		ThreadUtils.waitNonPreemptive(2000);
		builder.end();
		thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable e) {
				testResult = e;
			}
		});
		queue.push(new ZToolAddress16(0x00, 0x01), new ZToolAddress64(
				"00 12 4B 00 00 03 15 AD"));
		try {
			thread.join();
		} catch (InterruptedException e) {
		}
		
		assertNull("Failed due to exception " + testResult, testResult);

	}

}
