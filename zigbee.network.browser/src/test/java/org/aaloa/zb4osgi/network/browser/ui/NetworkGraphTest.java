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
package org.aaloa.zb4osgi.network.browser.ui;
import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ClusterListner;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverException;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;

import java.util.Dictionary;
import java.util.HashMap;

import org.aaloa.zb4osgi.api.monitor.impl.ZigBeeDiscoveryMonitorImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class NetworkGraphTest {

	private static final Logger logger = LoggerFactory.getLogger(NetworkGraphTest.class);

	private class ZigBeeDeviceLocal implements ZigBeeDevice {

		private short id;
		private short version;
		private int device;
		private int profile;
		private ZigBeeNode node;
		
		
		public ZigBeeDeviceLocal(int id, int version, int device, int profile, ZigBeeNode node) {
			this.id = (short) id;
			this.version = (short) version;
			this.device = device;
			this.profile = profile;
			this.node = node;
		}

		public boolean addClusterListener(ClusterListner listener) {
			return false;
		}

		public boolean bind(int clusterId) throws ZigBeeBasedriverException {
			return false;
		}

		public boolean bindTo(ZigBeeDevice device, int clusterId)
				throws ZigBeeBasedriverException {
			return false;
		}

		public Dictionary getDescription() {
			return null;
		}

		public int getDeviceId() {
			return device;
		}

		public short getDeviceVersion() {
			return version;
		}

		public short getId() {
			return id;
		}

		public int[] getInputClusters() {
			return null;
		}

		public int[] getOutputClusters() {
			return null;
		}

		public ZigBeeNode getPhysicalNode() {
			return node;
		}

		public int getProfileId() {
			return profile;
		}

		public String getUniqueIdenfier() {
			StringBuffer sb_uuid = new StringBuffer()
				.append(profile).append(":")
				.append(device).append(":")
				.append(version).append("@")
				.append(node.getIEEEAddress()).append(":")
				.append(id);
			
			return sb_uuid.toString();
		}

		public Cluster invoke(Cluster input) throws ZigBeeBasedriverException {
			return null;
		}

		public boolean providesInputCluster(int id) {
			return false;
		}

		public boolean providesOutputCluster(int id) {
			return false;
		}

		public boolean removeClusterListener(ClusterListner listener) {
			return false;
		}

		public void send(Cluster input) throws ZigBeeBasedriverException {			
		}

		public boolean unbind(int clusterId) throws ZigBeeBasedriverException {
			return false;
		}

		public boolean unbindFrom(ZigBeeDevice device, int clusterId)
				throws ZigBeeBasedriverException {
			return false;
		}
		
	}
	
    private class ZigBeeNodeLocal implements ZigBeeNode {

        private int nwk;
        private String ieee;                
        
        public ZigBeeNodeLocal( int nwk, String ieee ) {
            this.nwk = nwk;
            this.ieee = ieee;
        }

        public Dictionary getDescription() {
            return null;
        }

        public String getIEEEAddress() {
            return ieee;
        }

        public int getNetworkAddress() {
            return nwk;
        }

        public String toString(){
            return nwk + "/" + getIEEEAddress();
        }
        
        public boolean equals( Object obj ){
            final ZigBeeNode n = (ZigBeeNode) obj;
            return n.getNetworkAddress()==nwk && n.getIEEEAddress().equals( ieee );
        }
        
        public int hashCode(){
            return toString().hashCode();
        }
        
    }

	private HashMap<Integer, ZigBeeNode> nodes = new HashMap<Integer, ZigBeeNode>();
	private HashMap<ZigBeeNode, ZigBeeDevice> devices = new HashMap<ZigBeeNode, ZigBeeDevice>();
	private ZigBeeDiscoveryMonitorImpl service;
	private NetworkGraph gui;	
	
    private void initZigBeeNodes() {
        nodes.put( 2468, new ZigBeeNodeLocal( 2468, "0x0011223344556677") );
        nodes.put(    0, new ZigBeeNodeLocal(    0, "0x7766554433221100") );
        initZigBeeDevices( nodes.get(0) );
        nodes.put( 1357, new ZigBeeNodeLocal( 1357, "0x0011223377665544") );
        nodes.put( 3825, new ZigBeeNodeLocal( 3825, "0x7766554400112233") );           
    }

	private void initZigBeeDevices(ZigBeeNode node) {
		devices.put( node,  new ZigBeeDeviceLocal(5, 1, 13, 104, node) );
		devices.put( node,  new ZigBeeDeviceLocal(7, 1, 13, 104, node) );
		devices.put( node,  new ZigBeeDeviceLocal(14, 1, 13, 104, node) );
	}

	private void addEdge(ZigBeeNode from, ZigBeeNode to) {
    	service.browsedNode( from, to );
    
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
		
    }
    
	private void exec() {
		initZigBeeNodes();
    	gui = new NetworkGraph();
    	service = new ZigBeeDiscoveryMonitorImpl(gui.getGraph());

    	addEdge( nodes.get(    0 ), nodes.get( 2468 ) );
    	addEdge( nodes.get(    0 ), nodes.get( 1357 ) );
    	addEdge( nodes.get( 1357 ), nodes.get( 3825 ) );
    	addEdge( nodes.get( 2468 ), nodes.get( 3825 ) );
	}	
	
	public static void main(String[] args){
		new NetworkGraphTest().exec();
    }

}
