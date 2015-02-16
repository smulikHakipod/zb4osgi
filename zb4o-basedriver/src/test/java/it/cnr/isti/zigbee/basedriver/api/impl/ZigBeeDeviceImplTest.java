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
package it.cnr.isti.zigbee.basedriver.api.impl;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.getCurrentArguments;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ClusterFilter;
import it.cnr.isti.zigbee.api.ClusterListner;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverException;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverTimeOutException;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.basedriver.api.test.ZigBeeBaseDriverTestUnitBase;
import it.cnr.isti.zigbee.dongle.api.AFMessageListner;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.util.ArrayList;
import java.util.HashSet;

import org.easymock.IAnswer;
import org.junit.Test;

import com.itaca.ztool.api.af.AF_DATA_CONFIRM;
import com.itaca.ztool.api.af.AF_DATA_REQUEST;
import com.itaca.ztool.api.af.AF_INCOMING_MSG;
import com.itaca.ztool.api.af.AF_REGISTER;
import com.itaca.ztool.api.af.AF_REGISTER_SRSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_REQ;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_RSP;
import com.itaca.ztool.util.ByteUtils;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$ )
 *
 */
public class ZigBeeDeviceImplTest extends ZigBeeBaseDriverTestUnitBase {

    /**
     * This test verify if any pending {@link AFMessageConsumer} also known as {@link WaitForClusterResponse} is left 
     * when the invoke fails
     * @See <a href="http://zb4o.aaloa.org/redmine/issues/273">Redmine issue #273</a>
     */
	@Test
	public void testFailedInvoked() {
		final HashSet<AFMessageListner> listeners = new HashSet<AFMessageListner>();
		final ArrayList<ZigBeeDeviceImpl> network = new ArrayList<ZigBeeDeviceImpl>();
		ZigBeeNodeImpl node = null;
		ZigBeeDeviceImpl device = null;
		Cluster response = null;
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
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(successRegister).anyTimes();
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andAnswer(new IAnswer<AF_DATA_CONFIRM>() {

				final String FIRST_TEST = "Test AF_DATA_CONFIRM with a faiulre status code";
				final String SECOND_TEST = "Test no AF_DATA_CONFIRM";
				final String THIRD_TEST = "Test AF_DATA_CONFIRM with a succes status code but no AF_INCOMING_DATA";
				String[] scenarios = new String[]{FIRST_TEST,SECOND_TEST,THIRD_TEST};
				int currentScanario = 0;
				public AF_DATA_CONFIRM answer() throws Throwable {
					if ( scenarios[currentScanario] == FIRST_TEST ){
						currentScanario++;
						return new AF_DATA_CONFIRM(AF_DATA_CONFIRM.AF_STATUS.FAILED, 0, 0);
					}
					if ( scenarios[currentScanario] == SECOND_TEST ){
						currentScanario++;
						return null;
					}
					if ( scenarios[currentScanario] == THIRD_TEST){
						currentScanario++;
						return new AF_DATA_CONFIRM(0, 0, 0);
					}
					fail("Too many test and no scenario defined");
					return null;
				}
			}).anyTimes();
			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.add( (AFMessageListner) getCurrentArguments()[0] );
				}
			}).anyTimes();
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.remove((AFMessageListner) getCurrentArguments()[0] );
				}
			}).anyTimes();
			replay(drv);
			node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			network.add(device);
			response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
			fail("We were expecting a failure exception");
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			assertTrue("We were expecting a failure exception", ex instanceof ZigBeeBasedriverException);
		}
		assertEquals("Expecting no pending consumers", 0, device.getAFConsumers().size() );

		try {
			response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
			fail("We were expecting a failure exception");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertTrue("We were expecting a failure exception", ex instanceof ZigBeeBasedriverException);
		}
		assertEquals("Expecting no pending consumers", 0, device.getAFConsumers().size() );
		
		try {
			response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
			fail("We were expecting a failure exception");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			assertTrue("We were expecting a timeout exception", ex instanceof ZigBeeBasedriverTimeOutException);
		}
		assertEquals("Expecting no pending consumers", 0, device.getAFConsumers().size() );
		
	}

	
    /**
     * This verify that @
     * @See <a href="http://zb4o.aaloa.org/redmine/issues/273">Redmine issue #273</a>
     */
	@Test
	public void testRegisteringAFMessageListener() {
		final HashSet<AFMessageListner> listeners = new HashSet<AFMessageListner>();
		final ArrayList<ZigBeeDeviceImpl> network = new ArrayList<ZigBeeDeviceImpl>();
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
			AF_REGISTER_SRSP successRegister = new AF_REGISTER_SRSP(new int[]{0});
			expect(drv.sendZDOSimpleDescriptionRequest(anyObject(ZDO_SIMPLE_DESC_REQ.class))).andReturn(dsc).anyTimes();
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(successRegister).anyTimes();
			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.add( (AFMessageListner) getCurrentArguments()[0] );
				}
			}).once();
			replay(drv);
			node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			device.addClusterListener(new ClusterListner() {
				
				public void setClusterFilter(ClusterFilter filter) {
				}
				
				public void handleCluster(ZigBeeDevice device, Cluster cluster) {
				}
				
				public ClusterFilter getClusterFilter() {
					return null;
				}
			});
			device.addClusterListener(new ClusterListner() {
				
				public void setClusterFilter(ClusterFilter filter) {
				}
				
				public void handleCluster(ZigBeeDevice device, Cluster cluster) {
				}
				
				public ClusterFilter getClusterFilter() {
					return null;
				}
			});
			verify(drv);
			//response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
    
    /**
     * This test verify the dispatching of response from the network to OSGi service that proxying 
     * it (the {@link ZigBeeDevice} ) when the {@link ZigBeeDevice} has network address greater then 32767
     * and a end point address greater then 127
     * 
     * @See <a href="http://zb4o.aaloa.org/redmine/issues/264">Redmine issue #264</a>
     */
	@Test
	public void testInvokeOnNegativeNwkAddress() {
		final HashSet<AFMessageListner> listeners = new HashSet<AFMessageListner>();
		final ArrayList<ZigBeeDeviceImpl> network = new ArrayList<ZigBeeDeviceImpl>();
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
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(successRegister).anyTimes();
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andAnswer(new IAnswer<AF_DATA_CONFIRM>() {

				public AF_DATA_CONFIRM answer() throws Throwable {
					//pushResponse(getCurrentArguments()[0]);
					/*
					String answer = "0xfe " //SOF
							+ "0x19 " //LEN
							+ "0x44 0x81 " //CMD
							+ "0x00 0x00 " //GroupId
							+ "0x00 0x01 " //ClusterId
							+ "0x9c 0x40 " //Source Network Address
							+ "0xc8 0x01 " //Source & Destination End Point
							+ "0x00 0x46 0x00 " //Broadcast, Link, Security flags
							+ "0xc5 0x9f 0x04 0x00 " //Timestamp
							+ "0x00 " //Transaction Sequence Number
							+ "0x08 " //Payload Length
							+ "0x08 0x00 0x01 0x00 0x00 0x00 0x20 0x02 " //Payload
							+ "0x47"; //FCS
					*/
					String answer = ""
							+ "0x00 0x00 " //GroupId
							+ "0x00 0x01 " //ClusterId
							+ "0x40 0x9c " //Source Network Address
							+ "0xc8 0x01 " //Source & Destination End Point
							+ "0x00 0x46 0x00 " //Broadcast, Link, Security flags
							+ "0xc5 0x9f 0x04 0x00 " //Timestamp
							+ "0x00 " //Transaction Sequence Number
							+ "0x08 " //Payload Length
							+ "0x08 0x00 0x01 0x00 0x00 0x00 0x20 0x02 " //Payload
					;
					int[] packet = ByteUtils.fromBase16toIntArray(answer);
					AF_INCOMING_MSG response = new AF_INCOMING_MSG(packet);
					//ZToolPacket response = ZToolPacketStream.parsePacket(packet);
					for (ZigBeeDeviceImpl dev : network) {
						dev.notify((AF_INCOMING_MSG) response);
					}
					AF_DATA_CONFIRM dataSuccess = new AF_DATA_CONFIRM(0,0,0);
					return dataSuccess;
				}
			});
			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.add( (AFMessageListner) getCurrentArguments()[0] );
				}
			});
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.remove((AFMessageListner) getCurrentArguments()[0] );
				}
			});
			replay(drv);
			ZigBeeNodeImpl node = new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1);
			ZigBeeDeviceImpl device = new ZigBeeDeviceImpl(drv, node, (byte) 200);
			network.add(device);
			Cluster response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
		}catch(Exception ex){
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}

	
    /**
     * This test verify the dispatching to multiple {@link ZigBeeDevice} of response from the network and 
     * it verify that messages are consumed only by the expected {@link ZigBeeDevice}
     * 
     * @See <a href="http://zb4o.aaloa.org/redmine/issues/264">Redmine issue #264</a>
     */
	@Test
	public void testInvokeOnMultipleDevice() {
		final HashSet<AFMessageListner> listeners = new HashSet<AFMessageListner>();
		final ArrayList<ZigBeeDeviceImpl> network = new ArrayList<ZigBeeDeviceImpl>();
		final ArrayList<ZDO_SIMPLE_DESC_RSP> devices = new ArrayList<ZDO_SIMPLE_DESC_RSP>();
		final ArrayList<AF_INCOMING_MSG> responses = new ArrayList<AF_INCOMING_MSG>();
		try {
			SimpleDriver drv = createMock(SimpleDriver.class);
			final int[] descriptionRequest = new int[]{-1};
			devices.add(new ZDO_SIMPLE_DESC_RSP(new int[]{
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
			}));		
			devices.add(new ZDO_SIMPLE_DESC_RSP(new int[]{
					0x00, 0x40,										//16-bit Source Address
					0x00,											//Status
					0x00, 0x40,										//16-bit Network Address
					0x00,											//Length
					0x28,											//End Point Address
					0x04, 0x01,										//Profile Id
					0x00, 0x01,										//Device Id
					0x00,											//Device Version
					0x04,											//Input Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Input Cluster List				
					0x04,											//Output Cluster Count
					0x00, 0x10, 0x10, 0x00, 0x00, 0x80, 0xF0, 0xFA, //Output Cluster List				
			}));		
			AF_REGISTER_SRSP successRegister = new AF_REGISTER_SRSP(new int[]{0});
			expect(drv.sendZDOSimpleDescriptionRequest(anyObject(ZDO_SIMPLE_DESC_REQ.class))).andAnswer(
					new IAnswer<ZDO_SIMPLE_DESC_RSP>() {
						public ZDO_SIMPLE_DESC_RSP answer() throws Throwable {
							int idx = ( descriptionRequest[0] + 1 ) % devices.size();
							descriptionRequest[0] = idx;
							return devices.get(idx);
						}
					}
			).anyTimes();
			expect(drv.sendAFRegister(anyObject(AF_REGISTER.class))).andReturn(successRegister).anyTimes();
			expect(drv.sendAFDataRequest(anyObject(AF_DATA_REQUEST.class))).andAnswer(new IAnswer<AF_DATA_CONFIRM>() {

				public AF_DATA_CONFIRM answer() throws Throwable {
					//pushResponse(getCurrentArguments()[0]);
					/*
					String answer = "0xfe " //SOF
							+ "0x19 " //LEN
							+ "0x44 0x81 " //CMD
							+ "0x00 0x00 " //GroupId
							+ "0x00 0x01 " //ClusterId
							+ "0x9c 0x40 " //Source Network Address
							+ "0xc8 0x01 " //Source & Destination End Point
							+ "0x00 0x46 0x00 " //Broadcast, Link, Security flags
							+ "0xc5 0x9f 0x04 0x00 " //Timestamp
							+ "0x00 " //Transaction Sequence Number
							+ "0x08 " //Payload Length
							+ "0x08 0x00 0x01 0x00 0x00 0x00 0x20 0x02 " //Payload
							+ "0x47"; //FCS
					*/
					AF_DATA_REQUEST request = (AF_DATA_REQUEST) getCurrentArguments()[0];
					short dstNwk = request.getDstAddress();
					byte dstEP = request.getDstEndpoint();
					short cluster = request.getClusterId();
					String answer = ""
							+ "0x00 0x00 " //GroupId
							+ ByteUtils.toBase16(cluster & 0xFF) + " " + ByteUtils.toBase16((cluster >> 8 ) & 0xFF) + " "//ClusterId
							+ ByteUtils.toBase16(dstNwk & 0xFF) + " " + ByteUtils.toBase16((dstNwk >> 8 ) & 0xFF) + " " //Source Network Address
							+ ByteUtils.toBase16(dstEP) + " 0x01 " //Source & Destination End Point
							+ "0x00 0x46 0x00 " //Broadcast, Link, Security flags
							+ "0xc5 0x9f 0x04 0x00 " //Timestamp
							+ "0x00 " //Transaction Sequence Number
							+ "0x08 " //Payload Length
							+ "0x08 0x00 0x01 0x00 0x00 0x00 0x20 0x02 " //Payload
					;
					int[] packet = ByteUtils.fromBase16toIntArray(answer);
					AF_INCOMING_MSG currentResponse = new AF_INCOMING_MSG(packet);
					responses.add(currentResponse);
					for (ZigBeeDeviceImpl dev : network) {
						for (AF_INCOMING_MSG response : responses) {
							dev.notify(response);							
						}
					}
					AF_DATA_CONFIRM dataSuccess = new AF_DATA_CONFIRM(0,0,0);
					return dataSuccess;
				}
			}).anyTimes();
			
			expect(drv.addAFMessageListner(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.add( (AFMessageListner) getCurrentArguments()[0] );
				}
			}).anyTimes();
			expect(drv.removeAFMessageListener(anyObject(AFMessageListner.class))).andAnswer(new IAnswer<Boolean>() {

				public Boolean answer() throws Throwable {
					return listeners.remove((AFMessageListner) getCurrentArguments()[0] );
				}
			}).anyTimes();
			replay(drv);
			ZigBeeDeviceImpl dimmable = new ZigBeeDeviceImpl(drv, new ZigBeeNodeImpl(40000, "00:00:00:00:00:AA", (short) 1), (byte) 200);
			ZigBeeDeviceImpl onOff = new ZigBeeDeviceImpl(drv, new ZigBeeNodeImpl(4096, "11:00:00:00:00:11", (short) 1), (byte) 96);
			network.add(dimmable);
			network.add(onOff);
			for (ZigBeeDeviceImpl device : network) {
				Cluster response = device.invoke(new ClusterImpl(new byte[]{0x00,0x01,0x0a,0x20},(short) 0x100));
			}
		}catch(Exception ex){
			ex.printStackTrace();
			fail(ex.getMessage());
		}
	}
	
}
