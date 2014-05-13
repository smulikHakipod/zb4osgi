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

package it.cnr.isti.zigbee.hc.cluster.glue.general;

import it.cnr.isti.zigbee.hc.cluster.glue.Cluster;
import it.cnr.isti.zigbee.hc.zcl.library.api.ProtocolTunnel11073.ConnectStatus;
/**
 * PLACEHOLDER TO IMPLEMENT
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public interface ProtocolTunnel11073 extends Cluster {

    public int[] getDeviceIDList();
    public long getManagerTarget();
    public int getManagerEndPoint();
    public boolean isConnected();
    public boolean isPreemptible();
    public int getIdleTimeout();


    public void transferAPDU(String apdu);

    public ConnectStatus connectRequest(boolean preemptible, int idleTimeout, long targetIEEE, int ep);

    public ConnectStatus disconnectRequest(long targetIEEE);

    public ConnectStatus connectStatusNotification(ConnectStatus status);

}


