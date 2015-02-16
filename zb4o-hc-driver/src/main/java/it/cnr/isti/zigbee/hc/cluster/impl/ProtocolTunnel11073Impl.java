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

package it.cnr.isti.zigbee.hc.cluster.impl;

import it.cnr.isti.zigbee.hc.cluster.glue.general.ProtocolTunnel11073;
import it.cnr.isti.zigbee.hc.zcl.library.api.ProtocolTunnel11073.ConnectStatus;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
/**
 * PLACEHOLDER TO IMPLEMENT
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ProtocolTunnel11073Impl implements ProtocolTunnel11073 {

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Subscription[] getActiveSubscriptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Attribute[] getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Attribute getAttribute(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int[] getDeviceIDList() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getManagerTarget() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getManagerEndPoint() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPreemptible() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getIdleTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void transferAPDU(String apdu) {
		// TODO Auto-generated method stub
		
	}

	public ConnectStatus connectRequest(boolean preemptible, int idleTimeout,
			long targetIEEE, int ep) {
		// TODO Auto-generated method stub
		return null;
	}

	public ConnectStatus disconnectRequest(long targetIEEE) {
		// TODO Auto-generated method stub
		return null;
	}

	public ConnectStatus connectStatusNotification(ConnectStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

    

}
