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
package it.cnr.isti.zigbee.dongle.ez430rf2480.impl;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import it.cnr.isti.zigbee.dongle.api.AFMessageListner;
import it.cnr.isti.zigbee.dongle.api.AnnunceListner;
import it.cnr.isti.zigbee.dongle.api.ConfigurationProperties;
import it.cnr.isti.zigbee.dongle.api.NetworkMode;

import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.ZToolAddress64;
import com.itaca.ztool.api.ZToolCMD;
import com.itaca.ztool.api.af.AF_DATA_CONFIRM;
import com.itaca.ztool.api.af.AF_DATA_REQUEST;
import com.itaca.ztool.api.af.AF_INCOMING_MSG;
import com.itaca.ztool.api.af.AF_REGISTER;
import com.itaca.ztool.api.af.AF_REGISTER_SRSP;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_REQ;
import com.itaca.ztool.api.zdo.ZDO_ACTIVE_EP_RSP;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_REQ;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_RSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_REQ;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_RSP;



/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.6.0
 *
 */
public class SimpleDriverTest {
	/**
	 * The test can be run with the following option
	 *  - Driver: tests the hardware driver hence it requires the hardware connected
	 */
	public static final String TEST_OPTION = DriverEZ430_RF2480.class.getName();
	
	public static DriverEZ430_RF2480 sd = null; 
	public AFMessageListner afMsgList = null;
	public AnnunceListner announcelist = null;
	
	private static final Properties config = System.getProperties(); 
	
	
	@Before
	public void setUp() throws Exception {
		if ( ! "DRIVER".equalsIgnoreCase( System.getProperty( TEST_OPTION ) ) ) {
			System.out.print("Driver creation disable because "+ConfigurationProperties.COM_NAME_KEY+" is not set");
			return ;
		}
		if(sd == null){			
			//config.updateFromSystemProperties();
			String com = "COM12";
			if( ! "auto".equalsIgnoreCase( config.getProperty(ConfigurationProperties.COM_NAME_KEY) ) ){
				com = config.getProperty(ConfigurationProperties.COM_NAME_KEY);
			}
				
			System.out.print("Driver creation on "+com);
			sd = new DriverEZ430_RF2480(com,
					Integer.parseInt(config.getProperty(ConfigurationProperties.COM_BOUDRATE_KEY)),
					NetworkMode.valueOf(config.getProperty(ConfigurationProperties.NETWORK_MODE_KEY)),
					Integer.parseInt(config.getProperty(ConfigurationProperties.PAN_ID_KEY)),
					Integer.parseInt(config.getProperty(ConfigurationProperties.CHANNEL_ID_KEY))
			);		
			testDongleSetChannel();
			testDongleSetPanId();
		}
		if (afMsgList == null){
			afMsgList = new AFMessageListner(){
				public void notify(AF_INCOMING_MSG msg){
					System.out.println(msg.getClusterId());
				}
			};
		}
		if (announcelist == null){
			announcelist = new AnnunceListner()
			{
				public void notify(ZToolAddress16 senderAddress, ZToolAddress64 ieeeAddress,
					ZToolAddress16 networkAddress, int capabilitiesBitmask){
					System.out.println("Announce received from " + networkAddress);
				}
			};
		}
		
	}
	
	/*
	@AfterClass
	public static void setDown() {
		if ( sd != null ){
			sd.close();
			String com = "COM12";
			if( ! "auto".equalsIgnoreCase( config.getSerialPortName() ) ){
				com = config.getSerialPortName();
			}			
			try {
				sd = new SimpleDriver(com,config.getSerialBoudRate(),
						config.getNetworkMode(),
						config.getPanId(), config.getChannelId(), true
				);
				testDongleClearState();
			} catch (ZToolException e) {
			}		
		}
	}
	*/
	
	@Test
	public void testSendZDOIEEEAddressRequestSingle() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		//SINGLE DEVICE
		ZDO_IEEE_ADDR_RSP zdoIeeeRspSingle = sd.sendZDOIEEEAddressRequest(
				new ZDO_IEEE_ADDR_REQ((short) 0,
				ZDO_IEEE_ADDR_REQ.REQ_TYPE.SINGLE_DEVICE_RESPONSE, (byte) 0));
		System.out.println("Status simple " + zdoIeeeRspSingle.Status);
		assertEquals(ZToolCMD.ZDO_IEEE_ADDR_RSP,zdoIeeeRspSingle.getCMD().get16BitValue());
		assertEquals(ZDO_IEEE_ADDR_RSP.CMD_STATUS.SUCCESS, zdoIeeeRspSingle.Status);
		assertEquals(0, zdoIeeeRspSingle.getAssociatedDeviceCount());
		//assertEquals(zdoIeeeRspSingle.IEEEAddr,new ZToolAddress64("0x00124B00000BCC8D"));
			
	}
	
	@Test
	public void testSendZDOIEEEAddressRequestExtended() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		// EXTENDED DEVICE
		ZDO_IEEE_ADDR_RSP zdoIeeeRspExtended = sd.sendZDOIEEEAddressRequest(new ZDO_IEEE_ADDR_REQ((short)0,
				ZDO_IEEE_ADDR_REQ.REQ_TYPE.EXTENDED,(byte)0));
		System.out.println("Status extended " + zdoIeeeRspExtended.Status);
		assertEquals(ZToolCMD.ZDO_IEEE_ADDR_RSP,zdoIeeeRspExtended.getCMD().get16BitValue());
		assertEquals(3, zdoIeeeRspExtended.Status);
		assertEquals(1, zdoIeeeRspExtended.getAssociatedDeviceCount());
		assertEquals(zdoIeeeRspExtended.getAssociatedDeviceList()[0], 0x001);
		assertEquals(zdoIeeeRspExtended.nwkAddr,new ZToolAddress16(0,0));
		for (int i=0; (i<zdoIeeeRspExtended.NumAssocDev); i++)
		{
			System.out.println("Node List: " + zdoIeeeRspExtended.AssocDevList[i]);
		}
	}

	
	
	@Test
	public void testSendZDONodeDescriptionRequest() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		/*
		ZDO_NODE_DESC_RSP zdoNodeDesc = sd.sendZDONodeDescriptionRequest(new ZDO_NODE_DESC_REQ(new ZToolAddress16(0,0),new ZToolAddress16(0,0)));
		assertEquals(ZToolCMD.ZDO_NODE_DESC_RSP,zdoNodeDesc.getCMD().get16BitValue());
		assertEquals(ZDO_NODE_DESC_RSP.CMD_STATUS.SUCCESS,zdoNodeDesc.Status);
		*/
	}

	@Test
	public void testSendZDOActiveEndPointRequest() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		ZDO_ACTIVE_EP_RSP zdoActiveEP = sd.sendZDOActiveEndPointRequest(new ZDO_ACTIVE_EP_REQ(1));
		assertTrue("No answer from #1 for ZDO_ACTIVE_EP_REQ", zdoActiveEP != null);
		assertEquals(ZDO_ACTIVE_EP_RSP.CMD_STATUS.SUCCESS, zdoActiveEP.Status);
		assertEquals(2,zdoActiveEP.getActiveEndPointList().length);
		assertArrayEquals(new byte[]{0x13, 0x13},zdoActiveEP.getActiveEndPointList());
	}

	@Test
	public void testSendZDOSimpleDescriptionRequest() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		ZDO_SIMPLE_DESC_RSP zdoSimpleDesc = sd.sendZDOSimpleDescriptionRequest(new ZDO_SIMPLE_DESC_REQ(
				new ZToolAddress16(0,0x1), new ZToolAddress16(0,0x1), 0x13)
		);
		assertEquals(ZDO_SIMPLE_DESC_RSP.CMD_STATUS.SUCCESS,zdoSimpleDesc.Status);
		System.out.println("In Cluster Count " + zdoSimpleDesc.getInputClustersCount());
		assertEquals( 0x9, zdoSimpleDesc.getInputClustersCount());
		assertEquals( 0x104, zdoSimpleDesc.getProfileId());
		assertEquals( 0x0, zdoSimpleDesc.getInputClustersList()[0]);
	}

	@Test
	public void testAddRemoveAnnunceListener() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		boolean condition = sd.addAnnunceListener(announcelist);
		assertTrue(condition);
		condition = sd.removeAnnunceListener(announcelist);
		assertTrue(condition);		
	}

	@Test
	public void testSendAFRegister() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		byte endPoint = (byte) 0x3;
		short profileId = (short) 0x104;
		short deviceId = (short) 0x0;
		byte deviceVersion = (byte) 0x0;
		short[] inputs = {};
		short[] outputs = {(short)0xfc03};
		AF_REGISTER_SRSP afRegRsp = sd.sendAFRegister(new AF_REGISTER(endPoint, profileId, 
				deviceId, deviceVersion, inputs ,  outputs));
		System.out.println("AfReg Status " + afRegRsp.Status);
		assertEquals(0, afRegRsp.Status);
		
	}
	
	@Test
	public void testAddRemoveAFMessageListener() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		boolean condition = sd.addAFMessageListner(afMsgList);
		assertTrue(condition);
		condition = sd.removeAFMessageListener(afMsgList);
		assertTrue(condition);
	}

	private void testDongleSetPanId() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}

		assertEquals(
				Integer.parseInt(config.getProperty(ConfigurationProperties.PAN_ID_KEY)), 
				sd.getCurrentPanId()
		);
	}

	
	private void testDongleSetChannel() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}

		assertEquals(
				Integer.parseInt(config.getProperty(ConfigurationProperties.CHANNEL_ID_KEY)), 
				sd.getCurrentChannel()
		);
	}

	@Test
	public void testSendAFDataRequest() {
		if( sd == null ){
			System.out.println("Test skipped");
			return;
		}
		short nwkDstAddress = (short) 0x1;
		byte dstEndPoint = (byte) 0x13;
		byte srcEndPoint = (byte) 0x3;
		short clusterId = (short) 0xfc03;
		byte transId = (byte) 0x0;
		byte bitmapOpt = (byte) 0x20;
		byte radius = (byte) 0x1;
		byte[] msg = new byte[]{0x00, 0x00, 0x00, 0x00};
		
		AF_DATA_CONFIRM afDataConf = sd.sendAFDataRequest(new AF_DATA_REQUEST(nwkDstAddress, 
				dstEndPoint, srcEndPoint, clusterId, transId, bitmapOpt, 
				radius, msg));
		System.out.println("AfDataConfirm Status " + afDataConf.Status);
		assertEquals(0, afDataConf.Status);
		
	}

	@Test
	public void testBuildChannelMask() {
		
		int[] ids = new int[]{0x14, 0x0B, 0x13, 0x16}; 
		int[][] values = new int[][]{
				{0x00, 0x00, 0x10, 0x00},
				{0x00, 0x08, 0x00, 0x00},
				{0x00, 0x00, 0x08, 0x00},				
				{0x00, 0x00, 0x40, 0x00},
		};
		for (int i = 0; i < ids.length; i++) {
			int[] result = DriverEZ430_RF2480.buildChannelMask(ids[i]);
			for (int j = 0; j < values[i].length; j++) {
				assertEquals("Testing case "+i+"-nth failed on "+j+"-th element",values[i][j],result[j]);
			}
		}
		
	}
}
