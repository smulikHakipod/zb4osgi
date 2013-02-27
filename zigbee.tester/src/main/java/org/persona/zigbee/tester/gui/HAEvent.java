/*

   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
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

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
package org.persona.zigbee.tester.gui;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;

import org.persona.zigbee.tester.Activator;
import org.persona.zigbee.tester.event.api.HAListenerFactoryService;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 */
public class HAEvent {
	
	private String name;
	private Cluster cluster;
	
	public HAEvent(Cluster c, String n){
		cluster = c;
		name = n;
	}
		
	public String getName() {
		return name;
	}
	
	public boolean isSubscribable() {
		HAListenerFactoryService[] list = Activator.tracker.getHAListenerFactoryService();
		for (int i = 0; i < list.length; i++) {
			if ( list[i].handleCluster(cluster) ) return true;
		}
		return false;
	}
	
	public HAListenerFactoryService getHAListenerFactoryService() {
		HAListenerFactoryService[] list = Activator.tracker.getHAListenerFactoryService();
		for (int i = 0; i < list.length; i++) {
			if ( list[i].handleCluster(cluster) ) return list[i];
		}
		return null;
	}
	
	public String toString() {
		return name;
	}

	public Cluster getCluster() {
		return cluster;
	}
	
}
