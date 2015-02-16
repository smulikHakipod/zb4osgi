/*
   Copyright 2013-2014 CNR-ISTI, http://isti.cnr.it
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

package com.itaca.ztool.api.zdo;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolCMD;
import com.itaca.ztool.api.ZToolPacket;
import com.itaca.ztool.util.DoubleByte;

/**
 * Response for requesting the network to switch channel or change PAN ID.
 *
 * @author <a href="mailto:tommmi.s.e.laukkanen@gmail.com">Tommi S.E. Laukkanen</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano Lenzi</a>
 * @since 0.9.0
 */
public class ZDO_MGMT_NWK_UPDATE_REQ_SRSP extends ZToolPacket {
    /** The logger. */
    private final static Logger logger = LoggerFactory.getLogger(ZDO_MGMT_NWK_UPDATE_REQ_SRSP.class);

    public int status;

    public ZDO_MGMT_NWK_UPDATE_REQ_SRSP(int[] framedata) {
        this.status = framedata[0];
        super.buildPacket(new DoubleByte(ZToolCMD.ZDO_MGMT_NWK_UPDATE_REQ_SRSP), framedata);
    }

    @Override
    public String toString() {
        return "ZDO_MGMT_NWK_UPDATE_REQ_SRSP{" +
                "status=" + Status.getStatus(status) +
                '}';
    }

    public enum Status
    {
        UNKNOWN(-1),
        FAILED(1),
        SUCCESS(0);

        private static Map<Integer, Status> mapping= new HashMap<Integer, Status>();
        private int value;
        private Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Status getStatus(int value) {
            if (!mapping.containsKey(value)) {
                logger.warn("Uknown status {}.", value);
                return UNKNOWN;
            }
            return mapping.get(value);
        }

        static {
            for (Status status : Status.values()) {
                mapping.put(status.value, status);
            }
        }
    }
}
