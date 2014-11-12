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

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;
import it.cnr.isti.zigbee.basedriver.api.test.ZigBeeBaseDriverTestUnitBase;

import org.junit.*;


import com.itaca.ztool.api.ZToolAddress64;

public class ZigBeeNodeImplTest extends ZigBeeBaseDriverTestUnitBase {
    
    /**
     * This test verify that any negative value assigned as network address is translated 
     * to complement-to-2 positive value, so that we avoid signing issues due to implicit
     * casts of Java. For example: -25 is translated to 65511
     * 
     * @see redmine issue #271
     */
	@Test
	public void testZigBeeNodeImplIntStringShort() {
		ZigBeeNodeImpl node =  null;
		final int NEGATIVE_NWK_ADDR = -25;
		final int NORMALIZED_NWK_ADDR = NEGATIVE_NWK_ADDR & 0xFFFF;
		final int EXPECTED_NWK_ADDR = 65511;
		assertEquals("Normalized value matches", NORMALIZED_NWK_ADDR, EXPECTED_NWK_ADDR);
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, "01:02:03:04:05:06", (short) 40);
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, "01:02:03:04:05:06");
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node = new ZigBeeNodeImpl(NEGATIVE_NWK_ADDR, new ZToolAddress64(0x010203040506L) );
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
		node.setNetworkAddress(NEGATIVE_NWK_ADDR);
		assertEquals("Checking negative network address", EXPECTED_NWK_ADDR, node.getNetworkAddress() );
	}

}
