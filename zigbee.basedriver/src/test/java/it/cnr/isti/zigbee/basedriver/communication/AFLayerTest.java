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

package it.cnr.isti.zigbee.basedriver.communication;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.junit.Assert.*;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.communication.AFLayer.SenderIdentifier;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;

import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class AFLayerTest {

    private ConfigurationService cs = null;
    
    @Before
    public void createActivatorStub() {
        cs = createConfigurationServiceStub();
        Activator.setStubObjectes(cs, null);
    }
    
    public ConfigurationService createConfigurationServiceStub() {      
        ConfigurationService stub = createMock(ConfigurationService.class);
        
        expect(stub.getFirstFreeEndPoint())
            .andReturn( new Integer(2) )
            .anyTimes();
        
        replay(stub);
        
        return stub;
    }
    
    
	@Test
	public void getSendingEndpointZigBeeDeviceCluster(){
		AFLayer layer = AFLayer.getAFLayer(null);
		SenderIdentifier first = layer.new SenderIdentifier( (short) 0x0104, (short) 0x0000);
		SenderIdentifier second  = layer.new SenderIdentifier( (short) 0x0104, (short) 0x0000);
		SenderIdentifier third  = layer.new SenderIdentifier( (short) 0x0104, (short) 0x0010);
		
		layer.sender2EndPoint.put(first, new Byte((byte) 0x10) );
		
		assertTrue("Already stored as first",layer.sender2EndPoint.containsKey(second));
		assertFalse("Not inserted at all",layer.sender2EndPoint.containsKey(third));
		/*
		ZigBeeNetwork network = Activator.getZigBeeNetwork();
		ZigBeeNode nodeAlpha = createMock(ZigBeeNode.class);
		expect(nodeAlpha.getIEEEAddress()).andReturn("01:02:03:04:05:06:07:08");

		ZigBeeDevice deviceAlpha = createMock(ZigBeeDevice.class);
		expect(deviceAlpha.getPhysicalNode()).andReturn(nodeAlpha);
		expect(nodeAlpha.getIEEEAddress()).andReturn("01:02:03:04:05:06:07:08");
		expect(deviceAlpha.getId()).andReturn((short)0x20);
		expect(deviceAlpha.getProfileId()).andReturn(0x104);

		AFLayer layer = AFLayer.getAFLayer();		
		layer.getSendingEndpoint(deviceAlpha, 0x20);
		*/
	}
	
}
