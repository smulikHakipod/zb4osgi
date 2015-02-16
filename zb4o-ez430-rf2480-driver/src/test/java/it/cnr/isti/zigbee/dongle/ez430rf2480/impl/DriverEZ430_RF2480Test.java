/*
   Copyright 2015-2015 CNR-ISTI, http://isti.cnr.it
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

import static org.junit.Assert.*;

import org.junit.Test;

/**
*
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
* @version $LastChangedRevision$ ($LastChangedDate$)
* @since 0.8.0
*
*/
public class DriverEZ430_RF2480Test {

    @Test
    public void testIsResendOnlyOnException() {
        DriverEZ430_RF2480 d = null;
        try {

            assertNull(System.getProperty(DriverEZ430_RF2480.RESEND_ONLY_EXCEPTION_KEY));
            d = new DriverEZ430_RF2480("COMX", 115200);
            assertTrue(d.isResendOnlyOnException());

            System.setProperty(DriverEZ430_RF2480.RESEND_ONLY_EXCEPTION_KEY, "pippo");
            d = new DriverEZ430_RF2480("COMX", 115200);
            assertFalse(d.isResendOnlyOnException());

            System.setProperty(DriverEZ430_RF2480.RESEND_ONLY_EXCEPTION_KEY, "");
            d = new DriverEZ430_RF2480("COMX", 115200);
            assertFalse(d.isResendOnlyOnException());

            System.setProperty(DriverEZ430_RF2480.RESEND_ONLY_EXCEPTION_KEY, "tRue");
            d = new DriverEZ430_RF2480("COMX", 115200);
            assertTrue(d.isResendOnlyOnException());

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception thrown");
        }
    }

}
