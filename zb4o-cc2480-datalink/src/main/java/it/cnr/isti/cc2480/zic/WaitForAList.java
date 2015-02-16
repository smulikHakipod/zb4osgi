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

import it.cnr.isti.cc2480.low.HWLowLevelDriver;
import it.cnr.isti.cc2480.low.PacketListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolPacket;

/**
*
* @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
* @version $LastChangedRevision$ ($LastChangedDate$)
* @since 0.9.0
*
*/
public class WaitForAList implements PacketListener {

    private final static Logger logger = LoggerFactory.getLogger(WaitForAList.class);
	
	
    final int[] waitingList;
    final ZToolPacket[] packetHistory;
    final HWLowLevelDriver hwDriver;
    int idx = 0;
    
    /**
     * This constructor uses the {@link WaitForAList#WaitForAList(int[], ZToolPacket[], HWLowLevelDriver) constructor<br>
     * with the following parameters <code>WaitForAList(list,null,null)</code>
     *
     * @see WaitForAList#WaitForAList(int[], ZToolPacket[], HWLowLevelDriver)
     * @param list
     */
	public WaitForAList(final int[] list) {
		this(list, null, null);
	}

    /**
     * Create a {@link WaitForAList} that wait for a specified list<br>
     * of packet to be received. Furthermore, the {@link WaitForAList}<br>
     * while record all the matching packet received, and it will handle<br>
     * by itself the registration and unregistration as
     * {@link PacketListener}<br>
     * to the specified {@link HWLowLevelDriver}.<br>
     * <br>
     * <b>NOTE:</b>If the {@link ZToolPacket} array is null no packet will
     * be recorded<br>
     * <b>NOTE:</b>If the {@link HWLowLevelDriver} array is null
     * registration and unregistration as<br>
     * {@link PacketListener} must be handled by the invoker<br>
     *
     * @param list
     *            the array of <code>int</code> to listen to
     * @param packets
     *            {@link ZToolPacket} the array of the same size as
     *            <code>list</code> to record the received packet
     * @param lowDriver
     *            {@link HWLowLevelDriver} to register to, if
     *            <code>null</code> to handle registration/unregistration
     *            manually
     */
    public WaitForAList(final int[] list, final ZToolPacket[] packets,
            final HWLowLevelDriver lowDriver) {
        this.waitingList = list;
        this.packetHistory = packets;
        this.hwDriver = lowDriver;
        if (hwDriver != null) {
            hwDriver.addPacketListener(this);
        }
    }

    public void waitForAll(long timeout) {
        long wakeUpTime = System.currentTimeMillis() + timeout;
        synchronized (waitingList) {
            while (idx < waitingList.length
                    && wakeUpTime > System.currentTimeMillis()) {
                try {
                    waitingList.wait(wakeUpTime
                            - System.currentTimeMillis());
                } catch (InterruptedException ignored) {
                }
            }
        }
    }

    public void packetReceived(ZToolPacket packet) {
        if (packet.isError())
            return;
        if ((packet.getCommandId() & 0xFFFF) == waitingList[idx]) {
            logger.info("Received packet that was waiting for increasing waitingList");
            synchronized (waitingList) {
                if (packetHistory != null) {
                    packetHistory[idx] = packet;
                }
                idx = idx + 1;
                if (idx == waitingList.length) {
                    if (hwDriver != null) {
                        hwDriver.removePacketListener(this);
                    }
                    waitingList.notifyAll();
                    return;
                }
            }
        }
    }
}
