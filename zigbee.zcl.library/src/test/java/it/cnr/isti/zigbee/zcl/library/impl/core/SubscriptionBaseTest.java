/*
   Copyright 2014-2014 CNR-ISTI, http://isti.cnr.it
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
package it.cnr.isti.zigbee.zcl.library.impl.core;

import static org.easymock.EasyMock.anyInt;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import it.cnr.isti.zigbee.api.ClusterListner;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverException;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ReportListener;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;

import java.util.Dictionary;

import org.junit.Test;

/**
*
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>

* @version $LastChangedRevision$ ($LastChangedDate$)
* @since 0.9.0
*
*/
public class SubscriptionBaseTest {

	private class SubTest extends SubscriptionBase {

		int countDoConfigureServer = 0;
		
		public SubTest(ZigBeeDevice zb, ZCLCluster c, Attribute attrib) {
			super(zb, c, attrib);
		}

		@Override
		protected boolean doConfigureServer() throws ZigBeeClusterException {
			countDoConfigureServer++;
			return true;
		}
		
	}
	
	@Test
	public void testIsActive() {
		boolean result = false;
		
		ZigBeeDevice device = createMock(ZigBeeDevice.class);
		try {
			expect(device.bind(anyInt())).andReturn(true).once();
			expect(device.addClusterListener(anyObject(ClusterListner.class))).andReturn(true).once();
			expect(device.unbind(anyInt())).andReturn(true).once();
			replay(device);
		} catch (ZigBeeBasedriverException e) {
			/*
			 * IGNORED BECAUSE IT IS A MOCK AND NO EXCEPTION CAN BE THROWN
			 */
		}
		
		ZCLCluster cluster = createMock(ZCLCluster.class);
		expect(cluster.getId()).andReturn(new Short((short) 5)).anyTimes();
		replay(cluster);
		
		Attribute attribute = createMock(Attribute.class);
		
		
		SubTest subObject = new SubTest(device, cluster, attribute);
		//assertFalse("Subscriprion should not be active by default", test.isActive());
		result = subObject.addReportListener(new ReportListener() {
			public void receivedReport(Dictionary<Attribute, Object> reports) {
			}
		});
		assertTrue("Unable to a RerpotListener", result);
		assertEquals("After adding a Report Listener the subscription should be active", 
				true, subObject.isActive());		
		
		/*
		 * The following lines checks that only one binding is created when multiple ReportListener
		 * are registered for the same Cluster
		 */
		result = subObject.addReportListener(new ReportListener() {
			public void receivedReport(Dictionary<Attribute, Object> reports) {
			}
		});
		assertTrue("Unable to a RerpotListener", result);
		assertEquals("After adding a Report Listener the subscription should be active", 
				true, subObject.isActive() );		

		subObject.updateConfiguration();
		final int INVOKED_UPDATE_CONFIGURATION_TIMES = 2;
		assertEquals("Configuration is updated because it is active", 
				INVOKED_UPDATE_CONFIGURATION_TIMES, subObject.countDoConfigureServer);
		
		subObject.clear();
		assertFalse("After cleaning isActive() should return false", subObject.isActive());
		
		/*
		 * We expect that no updateConfiguration is invoked because there is no active subcription 
		 */
		subObject.updateConfiguration();
		assertEquals("Configuration is updated because it is active", 
				INVOKED_UPDATE_CONFIGURATION_TIMES, subObject.countDoConfigureServer);
	}

}
