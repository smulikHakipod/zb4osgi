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

package it.cnr.isti.zigbee.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.itaca.ztool.api.ZToolAddress64;
/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class IEEEAddressTest {

	@Test
	public void testFromToColonNotation() {
		Object[][] cases = new Object[][]{
				{ new Long(0x1020304050607080L), "10:20:30:40:50:60:70:80" },
				{ new Long(0x10FF304050607080L), "10:FF:30:40:50:60:70:80" },				
				{ new Long(0xFF20304050607080L), "FF:20:30:40:50:60:70:80" },
				{ new Long(0x00FF00FF00FF00FFL), "00:FF:00:FF:00:FF:00:FF" },
				{ new Long(0xFF00FF00FF00FF00L), "FF:00:FF:00:FF:00:FF:00" }
		};
		
		for (int i = 0; i < cases.length; i++) {
			assertEquals( 					
					"Trying to convert "+cases[i][0]+" into Colon Notation",
					( String ) cases[i][1] , 
					IEEEAddress.toColonNotation( ( (Long) cases[i][0] ).longValue() )
			);
			
			assertEquals( 					
					"Trying to convert "+cases[i][1]+" into long",
					( ( Long ) cases[i][0] ).longValue(), 
					IEEEAddress.fromColonNotation( (String) cases[i][1] )
			);
		}
	}
			
	@Test
	public void testToColonNotation() {
		long lIEEE;
		lIEEE = 0x1020304050607080L;
		assertEquals("10:20:30:40:50:60:70:80", IEEEAddress.toColonNotation(lIEEE));
	}

	@Test
	public void testToHexString() {
		ZToolAddress64 zIEEE;
		long lIEEE;
		zIEEE = new ZToolAddress64(
				(byte) 0x10, (byte) 0x20, (byte) 0x30, (byte) 0x40, 
				(byte) 0x50, (byte) 0x60, (byte) 0x70, (byte) 0x80
		);
		lIEEE = 0x1020304050607080L;
		assertEquals(zIEEE.toString(), IEEEAddress.toHexString(lIEEE));
		
		zIEEE = new ZToolAddress64(new byte[]{
				0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, (byte) 0x80
		});
		assertEquals(zIEEE.toString(), IEEEAddress.toHexString(lIEEE));
	}
}
