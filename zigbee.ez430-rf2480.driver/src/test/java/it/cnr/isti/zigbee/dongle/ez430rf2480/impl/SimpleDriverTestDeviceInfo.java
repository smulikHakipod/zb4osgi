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
package it.cnr.isti.zigbee.dongle.ez430rf2480.impl;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.itaca.ztool.api.ZToolException;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 *
 */
public class SimpleDriverTestDeviceInfo {

	private static DriverEZ430_RF2480 driver;
	
	@BeforeClass
	public static void loadDriver() {
		try {
			driver = new DriverEZ430_RF2480("auto", 38400);
		} catch (ZToolException e) {
			driver = null;
			System.out.println("All the test inside " 
					+ SimpleDriverTestDeviceInfo.class.getName() 
					+ " will be skipped beacuse no dongle found");
		}
	}
	
	@Test
	public void testGetExtendedPanId() {
	}

	@Test
	public void testGetIEEEAddress() {

		if( driver == null ) return;
		
		//Test reading from the dongle
		assertEquals(0x00124B00000BCC8DL,driver.getIEEEAddress());
		
		//Test the cache
		assertEquals(0x00124B00000BCC8DL,driver.getIEEEAddress());
	}

	@Test
	public void testGetCurrentPanId() {
	}

	@Test
	public void testGetCurrentChannel() {
	}

	@Test
	public void testGetCurrentState() {
	}

}
