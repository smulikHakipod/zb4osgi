/*
   Copyright 2013-2013 CNR-ISTI, http://isti.cnr.it
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
package it.cnr.isti.zigbee.zhccl.library.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;
import it.cnr.isti.zigbee.zhccl.library.api.ProtocolTunnel11073;

/**
 * This class represent the <b>11073 Protocol Tunnel</b> Cluster as defined by
 * the document:<br>
 * <i>ZigBee Health Care Profile 1.0 </i>public release version 075360r15
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ProtocolTunnel11073Cluster extends ZCLClusterBase implements ProtocolTunnel11073 {

    public ProtocolTunnel11073Cluster(ZigBeeDevice zbDevice) {
        super(zbDevice);
        // TODO Auto-generated constructor stub
    }

    public Attribute getAttributeDeviceIDList() {
        // TODO Auto-generated method stub
        return null;
    }

    public Attribute getAttributeManagerTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    public Attribute getAttributeManagerEndPoint() {
        // TODO Auto-generated method stub
        return null;
    }

    public Attribute getAttributeConnected() {
        // TODO Auto-generated method stub
        return null;
    }

    public Attribute getAttributePreemptible() {
        // TODO Auto-generated method stub
        return null;
    }

    public Attribute getAttributeIdleTimeout() {
        // TODO Auto-generated method stub
        return null;
    }

    public Response transferAPDU(String apdu) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response connectRequest(boolean preemptible, int idleTimeout,
            byte[] targetIEEE, byte ep) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response disconnectRequest(byte[] targetIEEE) {
        // TODO Auto-generated method stub
        return null;
    }

    public Response connectStatusNotification(ConnectStatus status) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public short getId() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Attribute[] getStandardAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

}
