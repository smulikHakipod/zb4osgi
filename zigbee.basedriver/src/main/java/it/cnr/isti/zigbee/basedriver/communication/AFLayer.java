/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.basedriver.communication;

import gnu.trove.TByteByteHashMap;
import gnu.trove.TObjectByteHashMap;
import gnu.trove.TShortArrayList;
import gnu.trove.TShortHashSet;
import gnu.trove.TShortObjectHashMap;
import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.discovery.ZigBeeNetwork;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.util.Collection;

import javax.naming.spi.DirStateFactory.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.af.AF_REGISTER;
import com.itaca.ztool.api.af.AF_REGISTER_SRSP;

/**
 * This class is a <i>singelton</i> aimed at share the <b>the Application Framework Layer</b><br>
 * status of the <b>ZigBee Base Drier</b> among all the {@link ZigBeeDevice} register by it.<br>
 * <br>
 * In particular, this class tracks the <i>Transaction Id</i> and the <i>Active End Point</i><br>
 * on the hardware providing access to <i>ZigBee Network</i> (currently the <b>Texas Instrument CC2480</b>)<br>
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class AFLayer {

	private final static Object LOCK = new Object();
	private final static Logger logger = LoggerFactory.getLogger(AFLayer.class);
	
	class SenderIdentifier{
		short profileId;
		short clusterId;
		
		public SenderIdentifier(short profileId, short clusterId) {
			this.profileId = profileId;
			this.clusterId = clusterId;
		}

		@Override
		public int hashCode() {
			return ( profileId << 16 ) + clusterId;
		}

		public boolean equals(Object o){
			if (o instanceof SenderIdentifier) {
				SenderIdentifier si = (SenderIdentifier) o;
				return si.profileId == profileId && si.clusterId == clusterId;
			}else{
				return false;
			}
		}
	}
	
	private static AFLayer singelton;
	
	final TObjectByteHashMap<SenderIdentifier> sender2EndPoint = new TObjectByteHashMap<SenderIdentifier>();
	final TShortObjectHashMap<TShortArrayList> profile2Cluster = new TShortObjectHashMap<TShortArrayList>();
	final TByteByteHashMap endPoint2Transaction = new TByteByteHashMap();
	
	private final SimpleDriver driver;
	private final ZigBeeNetwork network;
	
	private byte firstFreeEndPoint;

	
	private AFLayer(SimpleDriver driver){
		this.driver = driver;
		firstFreeEndPoint = (byte) Activator.getCurrentConfiguration().getFirstFreeEndPoint();
		network = new ZigBeeNetwork();
	}
		
	public static AFLayer getAFLayer(SimpleDriver driver){
		synchronized (LOCK) {
			if( singelton == null ){
				singelton = new AFLayer(driver);
			}else if ( singelton.driver != driver ){
				/*
				 * It means that the service implementing the driver has been changed 
				 * so we have to create a new AFLayer
				 */
				singelton = new AFLayer(driver);
			}
			return singelton;
		}
	}
	
	
	public byte getSendingEndpoint(ZigBeeDevice device, int clusterId) {
		SenderIdentifier si = new SenderIdentifier(
				(short) device.getProfileId(), (short) clusterId
		);		
		logger.info("Looking for a registered enpoint among {}", sender2EndPoint.size());
		synchronized (sender2EndPoint) {
			if(sender2EndPoint.containsKey(si)){
				logger.debug("An enpoint already registered for <profileId,clusterId>=<{},{}>", si.profileId, si.clusterId);
				return sender2EndPoint.get(si);
			}else {
				logger.debug("NO endpoint registered for <profileId,clusterId>=<{},{}>", si.profileId, si.clusterId);
				final byte ep = createEndPoint(si);
				return ep;
			}
		}
	}
	
	public byte getSendingEndpoint(ZigBeeDevice device, Cluster input) {
		return getSendingEndpoint(device, input.getId());
	}

	private byte createEndPoint(SenderIdentifier si) {
		byte endPoint = getFreeEndPoint();
		logger.debug("Registering a new endpoint for <profileId,clusterId>  <{},{}>", si.profileId, si.clusterId);		
		
		short[] clusters = collectClusterForProfile(si.profileId);
		
		/*
		 * //XXX Registering clusters only as input or output would increase the number of controllable clusters  
		 * It could be possible that the device doesn't take into account if the cluster is registered as input
		 * or as output so we could double the capacity of the dongle by distinguish between input and outpu
		 */
		//TODO We should use also output cluster in order to achieve 66 registration for each End Point
		if(clusters.length > 33){
			logger.warn(
					"We found too many cluster to implement for a single endpoint " +
					"(maxium is 32), so we are filtering out the extra {}", clusters 
			);
			/*
			 * Too many cluster to implement for this profile we must use the first 31
			 * plus the cluster that we are trying to create as 32nd value 
			 */
			short[] values = new short[33];
			values[0] = si.clusterId;
			for (int i = 1; i < values.length; i++) {
				values[i] = clusters[i];
			}
			logger.warn( "Following the list of filtered cluster that we are going to register: {} ", clusters );
		} 
		AF_REGISTER_SRSP result = null;
		int retry = 0;
		do {
			result = driver.sendAFRegister(new AF_REGISTER(
				endPoint, si.profileId, (short)0, (byte)0,
				clusters,clusters						
			));
			//FIX We should retry only when Status != 0xb8  ( ZApsDuplicateEntry )
			if( result.getStatus() != 0 ){
				if ( retry < Activator.getCurrentConfiguration().getAutomaticFreeEndPointRetry() ) {
					endPoint = getFreeEndPoint();
				} else {
					/*
					 * //TODO We should provide a workaround for the maximum number of registered EndPoint
					 * For example, with the CC2480 we could reset the dongle
					 */			
					throw new IllegalStateException("Unable create a new Endpoint. AF_REGISTER command failed with "+result.getStatus()+":"+result.getErrorMsg());			
				}
			} else {
				break;
			}
		} while( true );
		logger.debug("Registered endpoint {} with clusters: {}", endPoint, clusters);
		final TShortArrayList list;
		synchronized (profile2Cluster) {
			if( profile2Cluster.containsKey(si.profileId)){
				list = profile2Cluster.get(si.profileId);
			}else{
				list = new TShortArrayList();
				profile2Cluster.put(si.profileId, list);
			}
		}
		synchronized (sender2EndPoint) {
			for (int i = 0; i < clusters.length; i++) {
				list.add(clusters[i]);
				SenderIdentifier adding = new SenderIdentifier(si.profileId,clusters[i]);
				if( sender2EndPoint.contains(adding) ) {
					logger.warn("Overriding a valid <profileId,clusterId> endpoint with this {}",adding);
				}
				logger.debug("Adding <profileId,clusterId> <{},{}> to sender2EndPoint hashtable", adding.profileId, adding.clusterId);
				sender2EndPoint.put(adding, endPoint);
			}
		}
		return endPoint;
	}

	private short[] collectClusterForProfile(short profileId) {
		final TShortHashSet clusters = new TShortHashSet();
		final Collection<ZigBeeDevice> devices = network.getDevices(profileId);
		logger.debug("Found {} devices belonging to profile {}", devices.size(), profileId);
		for (ZigBeeDevice device : devices) {
			int[] ids;
			ids =  device.getInputClusters();
			logger.debug(
					"Device {} provides the following cluster as input {}", 
					device.getUniqueIdenfier(), ids
			);
			for (int i = 0; i < ids.length; i++) {
				clusters.add((short) ids[i]);
			}
			ids = device.getOutputClusters();
			logger.debug(
					"Device {} provides the following cluster as input {}", 
					device.getUniqueIdenfier(), ids
			);
			for (int i = 0; i < ids.length; i++) {
				clusters.add((short) ids[i]);
			}
		}
		
		final TShortArrayList implementedCluster = profile2Cluster.get(profileId);
		if (implementedCluster != null){
			final short[] implemented = implementedCluster.toNativeArray();
			logger.debug("List of clusters of profile {} already provided by some registered endpoint {}", profileId, implemented);
			clusters.removeAll(implemented);
		}else{
			logger.debug("No previus clusters registered on any endpoint of the dongle for the profile {}", profileId);
		}
		
		return clusters.toArray();
	}

	public ZigBeeNetwork getZigBeeNetwork() {
		return network;
	}

	public byte getNextTransactionId(byte endPoint){
		if(endPoint2Transaction.containsKey(endPoint)){
			byte value = endPoint2Transaction.get(endPoint);
			switch (value) {
				case 127:{
					endPoint2Transaction.put(endPoint, (byte) -128);
					return 127;
				}
				default:{
					endPoint2Transaction.put(endPoint, (byte) (value + 1) );
					return value;				
				}
			}
		}else{
			endPoint2Transaction.put(endPoint, (byte) 0 );
			return 0;
		}
		
	}
	
	private byte getFreeEndPoint() {
		switch (firstFreeEndPoint){
			case 127:{
				firstFreeEndPoint = -128;
				return 127;
			}
			case -15:{
				throw new IllegalStateException("No more end point free");
			}
			default:{
				firstFreeEndPoint+=1;
				return (byte) (firstFreeEndPoint - 1);				
			}				
		}
	}

}
