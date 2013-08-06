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
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_REQ;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class DeviceBuilderThreadTest {

    private static final Logger logger = LoggerFactory.getLogger( DeviceBuilderThreadTest.class );

    
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
        
        expect(stub.getFirstFreeEndPoint())
            .andReturn( new Integer(2) )
            .anyTimes();
        
        expect(stub.getDeviceInspectionPeriod())
            .andReturn( new Long(250) )
            .anyTimes();
        
        expect(stub.getMessageRetryCount())
            .andReturn( new Integer(1) )
            .anyTimes();
        
        expect(stub.getMessageRetryDelay())
            .andReturn( new Integer(100) )
            .anyTimes();
        
        expect(stub.getPanId())
            .andReturn( new Short( (short) 13531 ) )
            .anyTimes();
        
        replay(stub);
        
        return stub;
    }

    @Test
    public void testDuplicateDeviceCreation(){
        SimpleDriver driver = createMock(SimpleDriver.class);
        expect( driver.sendZDOActiveEndPointRequest( isA( ZDO_ACTIVE_EP_REQ.class ) ) )
            .andReturn( null ).times( 2 );
        replay( driver );
        ImportingQueue queue = new ImportingQueue();
        queue.push( new ZToolAddress16( 0x00, 0x01 ), new ZToolAddress64( "00 12 4B 00 00 03 15 AD" ) );
        DeviceBuilderThread builder = new DeviceBuilderThread( queue, driver );
        Thread thread = new Thread( builder, DeviceBuilderThread.class.getName() );
        thread.start();
        
        ThreadUtils.waitNonPreemptive(1 * 1000);
        builder.end();
        queue.push( new ZToolAddress16( 0x14, 0x3E ), new ZToolAddress64( "00 12 4B 00 00 03 15 AD" ) );
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
        
        assertEquals( 0, builder.getPendingNodes() );
        assertEquals( 0, builder.getPendingDevices() );
        
    }
}
