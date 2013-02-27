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

package it.cnr.isti.zigbee.basedriver.discovery;

import gnu.trove.TShortObjectHashMap;
import it.cnr.isti.primitvetypes.util.Integers;
import it.cnr.isti.thread.Stoppable;
import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.api.ZigBeeNode;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeNodeImpl;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.util.ArrayList;
import java.util.List;

import org.aaloa.zb4osgi.api.monitor.ZigBeeDiscoveryMonitor;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_REQ;
import com.itaca.ztool.api.zdo.ZDO_IEEE_ADDR_RSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LQI_REQ;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LQI_RSP;
import com.itaca.ztool.api.zdo.ZDO_MGMT_LQI_RSP.NeighborLqiListItemClass;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 * @version $LastChangedRevision: 67 $ ($LastChangedDate: 2010-10-01 04:08:24 +0200 (ven, 01 ott 2010) $)
 * @since 0.7.0
 *
 */
public class LQINetworkBrowserThread implements Stoppable {

	private static final Logger logger = LoggerFactory.getLogger(LQINetworkBrowserThread.class);

	private static final short COORDINATOR_NWK_ADDRESS = 0;
	private static final short LQI_START_INDEX = 0;

	private final ImportingQueue queue;
	final SimpleDriver driver;
	private boolean end = false;

	final ArrayList<NetworkAddressNodeItem> toInspect = new ArrayList<NetworkAddressNodeItem>();
	final TShortObjectHashMap<NetworkAddressNodeItem> alreadyInspected = new TShortObjectHashMap<NetworkAddressNodeItem>();
	private List<NetworkAddressNodeItem> connectedNodesFound = new ArrayList<NetworkAddressNodeItem>();

	//private GraphThread gt;

	private class NetworkAddressNodeItem {
		final NetworkAddressNodeItem parent;
		final short address;
		ZigBeeNodeImpl node = null;

		NetworkAddressNodeItem(NetworkAddressNodeItem addressTreeParent, short networkAddress){
			parent = addressTreeParent;
			address = networkAddress;
		}

		public String toString(){
			if ( parent != null ) {
				return "<" + parent.address + " / " + parent.node + "," + address + " / " + node + ">";
			} else {
				return "< NULL ," + address + " / " + node + ">";
			}
		}
	}

	public LQINetworkBrowserThread(ImportingQueue queue, SimpleDriver driver) {
		this.queue = queue;
		this.driver = driver;
	}

	private NetworkAddressNodeItem getIEEEAddress(short nwkAddress){

		NetworkAddressNodeItem node = new NetworkAddressNodeItem(null, nwkAddress);

		ZDO_IEEE_ADDR_RSP ieee_addr_resp = driver.sendZDOIEEEAddressRequest(
				new ZDO_IEEE_ADDR_REQ(nwkAddress, ZDO_IEEE_ADDR_REQ.REQ_TYPE.SINGLE_DEVICE_RESPONSE,(byte) 0)
				);

		if( ieee_addr_resp == null) {
			logger.debug("No ZDO_IEEE_ADDR_RSP from #{}", nwkAddress);
			return null;
		}
		else {
			logger.debug(
					"ZDO_IEEE_ADDR_RSP from {} with {} associated",
					ieee_addr_resp.getIEEEAddress(), ieee_addr_resp.getAssociatedDeviceCount()
					);

			node.node = new ZigBeeNodeImpl(node.address, ieee_addr_resp.getIEEEAddress());

			ZToolAddress16 nwk = new ZToolAddress16(
					Integers.getByteAsInteger(node.address, 1),
					Integers.getByteAsInteger(node.address, 0)
					);

			queue.push(nwk, ieee_addr_resp.getIEEEAddress());
			announceNode(node);

			return node;
		}
	}

	private void announceNodes(List<NetworkAddressNodeItem> nodes){

		if(nodes != null)
			for(int i = 0; i < nodes.size(); i++)
				announceNode(nodes.get(i));
	}

	private void announceNode(NetworkAddressNodeItem node){

		if(node != null){
			notifyBrowsedNode(node);
		}
	}

	private List<NetworkAddressNodeItem> lqiRequestToNode(NetworkAddressNodeItem node, int index){

		if(alreadyInspected.get(node.address) == null){

			if(index == 0)
				connectedNodesFound.clear();

			short nwk = node.address;
			ZToolAddress16 nwk16 = new ZToolAddress16(
					Integers.getByteAsInteger(node.address, 1),
					Integers.getByteAsInteger(node.address, 0)
					);

			logger.debug("ZDO_MGMT_LQI_REQ to {} from index {}", node.address, index);
			ZDO_MGMT_LQI_RSP lqi_resp = driver.sendLQIRequest(new ZDO_MGMT_LQI_REQ(nwk16, index));

			if( lqi_resp == null) {
				logger.debug("No LQI answer from #{}", nwk);
				return null;
			}
			else {
				logger.debug(
						"Found {} neighbors on node {}",
						lqi_resp.getNeighborLQICount(), node.address);

				NeighborLqiListItemClass[] neighbors = (NeighborLqiListItemClass[]) lqi_resp.getNeighborLqiList();

				if(neighbors != null){
					for(int i = 0; i < neighbors.length; i++){
						NeighborLqiListItemClass neighbor = (NeighborLqiListItemClass) neighbors[i];

						logger.info("Node #{} visible from node #{} with LQI value {}", new Object[]{neighbor.NetworkAddress.get16BitValue(), nwk, neighbor.RxLQI});

						NetworkAddressNodeItem result = getIEEEAddress((short)neighbor.NetworkAddress.get16BitValue());
						NetworkAddressNodeItem newNode;
						if(result != null){
							newNode = new NetworkAddressNodeItem(node, result.address);
							connectedNodesFound.add(newNode);
						}
						else{
							newNode = new NetworkAddressNodeItem(node, (short)neighbor.NetworkAddress.get16BitValue());
							connectedNodesFound.add(newNode);
							logger.info("No response to ZDO_IEEE_ADDR_REQ from node {}", neighbor.NetworkAddress.get16BitValue());
						}

						//GraphItem n = (gt).new GraphItem(node.address, neighbor.NetworkAddress.get16BitValue(), neighbor.Depth, neighbor.RxLQI);
						//gt.graph.add(n);
					}
				}

				// NeighborLQICount: neighbors IN THIS RESPONSE
				// NeighborLQIEntries: all available neighbors
				if(lqi_resp.getNeighborLQIEntries() > (lqi_resp.getNeighborLQICount()+index+1)){
					logger.debug("ZDO_MGMT_LQI_REQ new request to {} because of too many entries for a single request," +
							" restarting from index {}", node.address, lqi_resp.getNeighborLQICount()+index+1);
					lqiRequestToNode(node, lqi_resp.getNeighborLQICount()+index+1);
				}

				alreadyInspected.put(node.address, node);

				return connectedNodesFound;
			}
		}
		else{
			logger.debug("Node {} inspected few seconds ago, request delayed", node.address);
			return null;
		}
	}

	private void inspectQueue(ArrayList<NetworkAddressNodeItem> toInspectTemp){

		for(int i = 0; i < toInspect.size(); i++){
			List<NetworkAddressNodeItem> children = new ArrayList<NetworkAddressNodeItem>();
			NetworkAddressNodeItem node = toInspect.get(i);
			if(node != null){
				children = lqiRequestToNode(node, LQI_START_INDEX);
				if(children != null){
					toInspectTemp.addAll(children);
					announceNodes(children);
				}
			}
		}
	}

	public void run(){

		final String threadName = Thread.currentThread().getName();

		logger.info("{} STARTED Succesfully", threadName);

		while(!isEnd()){
			cleanUpWalkingTree();

			logger.info("Inspecting ZigBee network for new nodes");

			try{
				NetworkAddressNodeItem coordinator = getIEEEAddress(COORDINATOR_NWK_ADDRESS);
				if(coordinator != null){

					//gt = new GraphThread();

					List<NetworkAddressNodeItem> coordinatorChildren = lqiRequestToNode(coordinator, LQI_START_INDEX);
					if(coordinatorChildren != null)
						toInspect.addAll(coordinatorChildren);

					ArrayList<NetworkAddressNodeItem> toInspectTemp = new ArrayList<NetworkAddressNodeItem>();

					while(!toInspect.isEmpty()){
						inspectQueue(toInspectTemp);

						toInspect.clear();
						if(!toInspectTemp.isEmpty())
							for(int i = 0; i < toInspectTemp.size(); i++)
								toInspect.add(toInspectTemp.get(i));
						toInspectTemp.clear();
					}
					toInspect.clear();
				}

				long wakeUpTime = System.currentTimeMillis() + Activator.getCurrentConfiguration().getNetworkBrowsingPeriod();
				ThreadUtils.waitingUntil( wakeUpTime );
				logger.info("Network browsing completed, waiting until {}", wakeUpTime);
				//gt.run();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}

		//gt.end();
		logger.info("{} TERMINATED Succesfully", threadName);
	}

	private void cleanUpWalkingTree() {
		alreadyInspected.clear();
		toInspect.clear();
	}
	/*
	private ArrayList<NetworkAddressNodeItem> addChildrenNodesToInspectingQueue(NetworkAddressNodeItem inspecting, ZDO_IEEE_ADDR_RSP result) {
		int start = 0;
		final ArrayList<NetworkAddressNodeItem> adding = new ArrayList<NetworkAddressNodeItem>();
		do{

			short[] toAdd = result.getAssociatedDeviceList();
			for (int i = 0; i < toAdd.length; i++) {
				logger.info("Found node #{} associated to node #{}",toAdd[i],inspecting.address);
				final NetworkAddressNodeItem next = new NetworkAddressNodeItem(inspecting, toAdd[i]);
				final NetworkAddressNodeItem found = alreadyInspected.get(toAdd[i]);
				if( found != null ) {
					//NOTE Logging this wrong behavior but doing nothing
					logger.error(
							"BROKEN ZIGBEE UNDERSTANDING (while walking address-tree): " +
									"found twice the same node with network address {} ", toAdd[i]
							);
					logger.debug("Previus node data was {} while current has parent {}", found, inspecting);
				} else {
					adding.add(next);
				}
			}
			if( toAdd.length + result.getStartIndex() >= result.getAssociatedDeviceCount() ) {
				//NOTE No more node connected to inspecting
				return adding;
			}
			start += toAdd.length;

			logger.info(
					"Node #{} as many too many device connected to it received only {} out of {}, " +
							"we need to inspect it once more", new Object[]{
							inspecting.address, toAdd.length, result.getAssociatedDeviceCount()
					});
			result = driver.sendZDOIEEEAddressRequest(
					new ZDO_IEEE_ADDR_REQ(inspecting.address,ZDO_IEEE_ADDR_REQ.REQ_TYPE.EXTENDED,(byte) start )
					);
			if ( result == null ){
				logger.error("Faild to further inspect connected device to node #{}", inspecting.address);
			}
		}while(result != null);

		return adding;
	}

	private ArrayList<NetworkAddressNodeItem> addChildrenNodesToInspectingQueue(NetworkAddressNodeItem inspecting, ZDO_MGMT_LQI_RSP result) {
		//int start = 0;
		final ArrayList<NetworkAddressNodeItem> adding = new ArrayList<NetworkAddressNodeItem>();
		//do{

		NeighborLqiListItemClass[] list = (NeighborLqiListItemClass[]) result.getNeighborLqiList();
		List<ZToolAddress16> toAdd = new ArrayList<ZToolAddress16>();
		for(int i = 0; i < list.length; i++)
			toAdd.add(list[i].NetworkAddress);

		//List<ZToolAddress16> toAdd = result.getNeighborAddressList();
		for (int i = 0; i < toAdd.size(); i++) {
			logger.info("Found node #{} associated to node #{}", toAdd.get(i), inspecting.address);
			final NetworkAddressNodeItem next = new NetworkAddressNodeItem(inspecting, (short)toAdd.get(i).get16BitValue());
			final NetworkAddressNodeItem found = alreadyInspected.get((short)toAdd.get(i).get16BitValue());
			if( found != null ) {
				//NOTE Logging this wrong behavior but doing nothing
				logger.error(
						"BROKEN ZIGBEE UNDERSTANDING (while walking address-tree): " +
								"found twice the same node with network address {} ", (short)toAdd.get(i).get16BitValue()
						);
				logger.debug("Previus node data was {} while current has parent {}", found, inspecting);
			} else {
				adding.add(next);
			}
		}
		//if( toAdd.size() + result.getStartIndex() >= result.getAssociatedDeviceCount() ) {
		//NOTE No more node connected to inspecting
		return adding;
//		}
//			start += toAdd.length;
//
//			logger.info(
//					"Node #{} as many too many device connected to it received only {} out of {}, " +
//							"we need to inspect it once more", new Object[]{
//							inspecting.address, toAdd.length, result.getAssociatedDeviceCount()
//					});
//			result = driver.sendZDOIEEEAddressRequest(
//					new ZDO_IEEE_ADDR_REQ(inspecting.address,ZDO_IEEE_ADDR_REQ.REQ_TYPE.EXTENDED,(byte) start )
//					);
//			if ( result == null ){
//				logger.error("Faild to further inspect connected device to node #{}", inspecting.address);
//			}
//		}while(result != null);
//
//		return adding;
	}
	 */
	private void notifyBrowsedNode(NetworkAddressNodeItem item) {
		ServiceReference[] refs = null;
		try {
			refs = Activator.getBundleContext().getServiceReferences(ZigBeeDiscoveryMonitor.class.getName(), null);
		} catch (InvalidSyntaxException ex) {
			logger.error( "CODE BROKEN we need to recompile and fix", ex );
		}
		if ( refs == null ){
			return ;
		}

		final ZigBeeNode child = item.node;
		final ZigBeeNode parent;
		if ( item.parent == null ){
			//Notifying the root node
			parent = null;
		}else if( item.parent.node == null ){
			//This should not happen
			logger.error("BROKEN CODE: Found a parent node that is null, but it has a parent");
			parent = null;
		}else{
			parent = item.parent.node;
		}
		for (int i = 0; i < refs.length; i++) {
			final ZigBeeDiscoveryMonitor listener;
			try{
				listener = (ZigBeeDiscoveryMonitor) Activator.getBundleContext().getService(refs[i]);
				listener.browsedNode( parent, child );
			}catch(Exception ex) {
				logger.error("Handled excepetion during notification", ex);
			}
		}
	}

	private synchronized boolean isEnd() {
		return end;
	}

	public synchronized void end() {
		end = true;
	}
}