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
package it.cnr.isti.cc2480.zic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.cnr.isti.cc2480.high.AsynchrounsCommandListener;
import it.cnr.isti.cc2480.high.HWHighLevelDriver;

import com.itaca.ztool.api.ZToolPacket;

/**
*
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
* @version $LastChangedRevision$ ($LastChangedDate$)
* @since 0.9.0
*
*/
public class WaitForCommand implements AsynchrounsCommandListener {

    private final static Logger logger = LoggerFactory.getLogger(WaitForCommand.class);
	
    final ZToolPacket[] result = new ZToolPacket[]{null};
    final int waitFor;
    final HWHighLevelDriver driver;

    public WaitForCommand(int waitFor, HWHighLevelDriver driver) {
        this.waitFor = waitFor;
        this.driver = driver;
        driver.addAsynchrounsCommandListener(this);
    }

    public void receivedAsynchrounsCommand(ZToolPacket packet) {
        logger.info("Received a packet {} and waiting for {}", packet.getCMD(), waitFor);
        logger.debug("Received {} {}", packet.getClass(), packet.toString());
        
        if (packet.isError()){
            logger.debug("SKIPPED ZToolPacket: it was error packet");            	
            return;
        }
        
        final int cmdId = packet.getCMD().get16BitValue();
        if (cmdId != waitFor) {
            logger.debug("SKIPPED ZToolPacket: it was error unmatching command {} != {} ", waitFor, cmdId);            	
            return;
        }
        
        synchronized (result) {
            result[0] = packet;
            logger.info("Received the packet that we were waiting for");
            cleanup();
        }
    }

    public ZToolPacket getCommand(final long timeout) {
        synchronized (result) {
            final long wakeUpTime = System.currentTimeMillis() + timeout;
            while (result[0] == null
                    && wakeUpTime > System.currentTimeMillis()) {
                try {
                    result.wait(wakeUpTime - System.currentTimeMillis());
                } catch (InterruptedException ignored) {
                }

            }
        }
        if (result[0] == null) {
            logger.warn(
                    "Timeout {} expired and no packet with {} received",
                    timeout, waitFor);
        }
        cleanup();
        return result[0];
    }

    public void cleanup() {
        synchronized (result) {
            driver.removeAsynchrounsCommandListener(this);
            result.notify();
        }
    }
}