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

package it.cnr.isti.zigbee.basedriver.communication;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.api.impl.ClusterImpl;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeDeviceImpl;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeNodeImpl;
import it.cnr.isti.zigbee.basedriver.api.test.ZigBeeBaseDriverTestUnitBase;
import it.cnr.isti.zigbee.basedriver.configuration.ConfigurationService;
import it.cnr.isti.zigbee.dongle.api.AFMessageListner;
import it.cnr.isti.zigbee.dongle.api.ConfigurationProperties;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import org.easymock.IAnswer;
import org.junit.Test;
import org.osgi.service.cm.ConfigurationException;

import com.itaca.ztool.api.af.AF_DATA_CONFIRM;
import com.itaca.ztool.api.af.AF_DATA_REQUEST;
import com.itaca.ztool.api.af.AF_REGISTER;
import com.itaca.ztool.api.af.AF_REGISTER_SRSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_REQ;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_RSP;


/**
 * This test unit verify that<ul>
 * <li> no {@link NullPointerException} is thrown
 * <li> on failure of {@link SimpleDriver#sendAFRegister(AF_REGISTER)} method, the methods is invoked again
 * to n-times where n is defined by the {@link ConfigurationService#getAutomaticFreeEndPointRetry()}
 * </ul>
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @see <a href="http://zb4o.aaloa.org/redmine/issues/270>See redmine issue #270</a>
 *
 */
public class AFLayerTest_Issue_270 extends ZigBeeBaseDriverTestUnitBase {

	@Test
	public void testRetryingTransmision() {
		ZigBeeNodeImpl node = null;
		ZigBeeDeviceImpl device = null;
		super.setBundleContextProperty( ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY, "5" );
		try {
			Activator.getCurrentConfiguration().updated(super.getBundleContextProperties());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			fail("Exception");
		}
		final int maxRetry = Activator.getCurrentConfiguration().getAutomaticFreeEndPointRetry();
		try {
			SimpleDriver drv = createMock(SimpleDriver.class);
			ZDO_SIMPLE_DESC_RSP dsc = new ZDO_SIMPLE_DESC_RSP(new int[]{
					0x9C, 0x40,										//16-bit Source Address
					0x00,											//Status
					0x9C, 0x40,										//16-bit Network Address
					0x00,											//Length
					0xC8,											//End Point Address
					0x04, 0x01,										//Profile Id
					0x02, 0x01,										//Device Id
					0x00,											//Device Version
					0x04,											//Input Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Input Cluster List				
					0x04,											//Output Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Output Cluster List				
			});		
			AF_REGISTER_SRSP successRegister = new AF_REGISTER_SRSP(new int[]{0});
			expect(drv.sendZDOSimpleDescriptionRequest(anyObject(ZDO_SIMPLE_DESC_REQ.class))).andReturn(dsc).anyTimes();
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andAnswer(new IAnswer<AF_REGISTER_SRSP>() {

				int invoked = -1;
				int SUCCESS_IDX = 2;
				AF_REGISTER_SRSP[] results = new AF_REGISTER_SRSP[]{
						null,
						new AF_REGISTER_SRSP(new int[]{AF_REGISTER_SRSP.AF_STATUS.FAILED}),
						new AF_REGISTER_SRSP(new int[]{AF_REGISTER_SRSP.AF_STATUS.SUCCESS})
				};
				
				public AF_REGISTER_SRSP answer() throws Throwable {
					invoked++;
					return results[invoked];
				}
			}).times(2, maxRetry);
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andReturn(new AF_DATA_CONFIRM(0,0,0)).anyTimes();			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			replay(drv);
			node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			device.send(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
		}catch(Exception ex){
			ex.printStackTrace();
			fail("Unexpected Exception "+ex);
		}	
	}
	

	@Test
	public void testMaxRetryTransmision() {
		ZigBeeNodeImpl node = null;
		ZigBeeDeviceImpl device = null;
		super.setBundleContextProperty( ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY, "5" );
		try {
			Activator.getCurrentConfiguration().updated(super.getBundleContextProperties());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			fail("Exception");
		}
		final int maxRetry = Activator.getCurrentConfiguration().getAutomaticFreeEndPointRetry();
		try {
			SimpleDriver drv = createMock(SimpleDriver.class);
			ZDO_SIMPLE_DESC_RSP dsc = new ZDO_SIMPLE_DESC_RSP(new int[]{
					0x9C, 0x40,										//16-bit Source Address
					0x00,											//Status
					0x9C, 0x40,										//16-bit Network Address
					0x00,											//Length
					0xC8,											//End Point Address
					0x04, 0x01,										//Profile Id
					0x02, 0x01,										//Device Id
					0x00,											//Device Version
					0x04,											//Input Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Input Cluster List				
					0x04,											//Output Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Output Cluster List				
			});		
			expect(drv.sendZDOSimpleDescriptionRequest(anyObject(ZDO_SIMPLE_DESC_REQ.class))).andReturn(dsc).anyTimes();
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(null).times(maxRetry + 1);
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andReturn(new AF_DATA_CONFIRM(0,0,0)).anyTimes();			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			replay(drv);
			node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			device.send(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
		}catch(Exception ex){
			/*
			 * DO NOTHING -> We expected exception because the AF_REGISTER_SRSP is always null
			 */
		}	
	}
	
	
	@Test
	public void testNullPointerException() {
		ZigBeeNodeImpl node = null;
		ZigBeeDeviceImpl device = null;
		try {
			SimpleDriver drv = createMock(SimpleDriver.class);
			ZDO_SIMPLE_DESC_RSP dsc = new ZDO_SIMPLE_DESC_RSP(new int[]{
					0x9C, 0x40,										//16-bit Source Address
					0x00,											//Status
					0x9C, 0x40,										//16-bit Network Address
					0x00,											//Length
					0xC8,											//End Point Address
					0x04, 0x01,										//Profile Id
					0x02, 0x01,										//Device Id
					0x00,											//Device Version
					0x04,											//Input Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Input Cluster List				
					0x04,											//Output Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Output Cluster List				
			});		
			expect(drv.sendZDOSimpleDescriptionRequest(anyObject(ZDO_SIMPLE_DESC_REQ.class))).andReturn(dsc).anyTimes();
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(null).anyTimes();
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andReturn(new AF_DATA_CONFIRM(0,0,0)).anyTimes();			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andReturn(true).anyTimes();
			replay(drv);
			node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			device.send(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
		}catch(IllegalStateException expected){
			/*
			 * DOING NOTHING BECAUSE -> The exception was expected
			 */
		}catch(Exception ex){
			ex.printStackTrace();
			assertEquals("Unexpected Exception ",IllegalStateException.class.getName(),ex.getClass().getName());				
		}		
	}
}
