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
package it.cnr.isti.zigbee.hc.zcl.library.api;

import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;

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
public interface ProtocolTunnel11073 extends ZCLCluster {
    public static final short ID = 0x000F;
    public static final String NAME = "11073 Protocol Tunnel";
    public static final String DESCRIPTION = "The 11073 Protocol Tunnel cluster provides the commands and attributes required to tunnel the "
            + "11073 protocol";

    public static final byte TRANSFER_APDU = 0x00;
    public static final byte CONNECT_REQUEST = 0x01;
    public static final byte DISCONNECT_REQUEST = 0x02;
    public static final byte CONNECT_STATUS_NOTIFICATION = 0x03;

    public enum ConnectStatus{

        DISCONNECTED(0x00,"Indicates that this agent device has been disconnected from the tunnel"),

        CONNECTED(0x01,"Indicates that this agent device has been connected to the tunnel"),

        NOT_AUTHORIZED(0x02,"Indicates that a request to disconnect the tunnel is not authorized from this "
                + "requester at this time"),

        RECONNECT_REQUEST(0x03,"Indicates that the agent device wishes the Data Management device "
                + "to reconnect the tunnel" ),

        ALREADY_CONNECTED(0x04,"Indicates that the request to connect this tunnel has failed as "
                + "the agent device is already connected");

        public final int id;
        public final String description;
        private static ConnectStatus[] map;

        private ConnectStatus(int  id, String description){
            this.id = id;
            this.description = description;
            getMap()[id & 0xFF] = this;
        }

        public static ConnectStatus getStatus(byte b){
            return map[b & 0xFF];
        }

        private static ConnectStatus[] getMap(){
            if( map == null ){
                map = new ConnectStatus[5];
            }
            return map;
        }
    }

    public Attribute getAttributeDeviceIDList();

    public Attribute getAttributeManagerTarget();

    public Attribute getAttributeManagerEndPoint();

    public Attribute getAttributeConnected();

    public Attribute getAttributePreemptible();

    public Attribute getAttributeIdleTimeout();

    public Response transferAPDU(String apdu);

    public Response connectRequest(boolean preemptible, int idleTimeout, byte[] targetIEEE, byte ep);

    public Response disconnectRequest(byte[] targetIEEE);

    public Response connectStatusNotification(ConnectStatus status);
}
