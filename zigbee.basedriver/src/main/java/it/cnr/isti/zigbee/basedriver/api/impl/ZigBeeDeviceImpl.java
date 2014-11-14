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

package it.cnr.isti.zigbee.basedriver.api.impl;

import gnu.trove.TIntHashSet;
import it.cnr.isti.thread.ThreadUtils;
import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ClusterFilter;
import it.cnr.isti.zigbee.api.ClusterListner;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverException;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverTimeOutException;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.communication.AFLayer;
import it.cnr.isti.zigbee.dongle.api.AFMessageListner;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;
import it.cnr.isti.zigbee.util.IEEEAddress;
import it.cnr.isti.zigbee.util.NetworkAddress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Properties;

import org.osgi.service.device.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itaca.ztool.api.ZToolAddress16;
import com.itaca.ztool.api.af.AF_DATA_CONFIRM;
import com.itaca.ztool.api.af.AF_DATA_REQUEST;
import com.itaca.ztool.api.af.AF_INCOMING_MSG;
import com.itaca.ztool.api.zdo.ZDO_BIND_REQ;
import com.itaca.ztool.api.zdo.ZDO_BIND_RSP;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_REQ;
import com.itaca.ztool.api.zdo.ZDO_SIMPLE_DESC_RSP;
import com.itaca.ztool.api.zdo.ZDO_UNBIND_REQ;
import com.itaca.ztool.api.zdo.ZDO_UNBIND_RSP;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-10-09 16:27:35
 *          +0200(mer, 09 ott 2013) $)
 * @since 0.1.0
 *
 */
public class ZigBeeDeviceImpl implements ZigBeeDevice, AFMessageListner, AFMessageProducer {

    private static long TIMEOUT;
    private static final long DEFAULT_TIMEOUT = 5000;
    private static final Logger logger = LoggerFactory.getLogger(ZigBeeDeviceImpl.class);

    private final int[] inputs;
    private final int[] outputs;
    private final short deviceId;
    private final short profileId;
    private final byte deviceVersion;

    private ZigBeeNode node = null;
    private final Properties properties = new Properties();
    private final SimpleDriver driver;
    private final byte endPointAddress;

    private final TIntHashSet boundCluster = new TIntHashSet();
    private final HashSet<ClusterListner> listeners = new HashSet<ClusterListner>();
    private final HashSet<AFMessageConsumer> consumers = new HashSet<AFMessageConsumer>();
    private String uuid = null;

    public ZigBeeDeviceImpl(final SimpleDriver drv, final ZigBeeNode n, byte ep)
            throws ZigBeeBasedriverException {
        if (drv == null || n == null) {
            logger.error("Creating {} with some nulls parameters {}",
                    new Object[]{ZigBeeDevice.class, drv, n, ep});
            throw new NullPointerException(
                    "Cannot create a device with a null SimpleDriver or a null ZigBeeNode");
        }
        driver = drv;
        endPointAddress = ep;

        final ZDO_SIMPLE_DESC_RSP result = doRetrieveSimpleDescription(n);
        short[] ins = result.getInputClustersList();
        inputs = new int[ins.length];
        for (int i = 0; i < ins.length; i++) {
            inputs[i] = ins[i];
        }
        Arrays.sort(inputs);
        short[] outs = result.getOutputClustersList();
        outputs = new int[outs.length];
        for (int i = 0; i < outs.length; i++) {
            outputs[i] = outs[i];
        }
        Arrays.sort(outputs);

        deviceId = result.getDeviceId();
        profileId = result.getProfileId();
        deviceVersion = result.getDeviceVersion();

        setPhysicalNode(n);

        properties.put(ZigBeeDevice.PROFILE_ID, Integer.toString((profileId & 0xFFFF)));
        properties.put(ZigBeeDevice.DEVICE_ID, Integer.toString((deviceId & 0xFFFF)));
        properties.put(ZigBeeDevice.DEVICE_VERSION, Integer.toString((deviceVersion & 0xFF)));
        properties.put(ZigBeeDevice.ENDPOINT, Integer.toString((endPointAddress & 0xFF)));
        properties.put(ZigBeeDevice.CLUSTERS_INPUT_ID, inputs);
        properties.put(ZigBeeDevice.CLUSTERS_OUTPUT_ID, outputs);
        properties.put(ZigBeeDevice.ZIGBEE_IMPORT, drv.getClass());
        properties.put(ZigBeeDevice.IEEE_ADDRESS, node.getIEEEAddress());

        properties.put(Constants.DEVICE_CATEGORY, new String[]{ZigBeeDevice.DEVICE_CATEGORY});

        try {
            TIMEOUT = Long.parseLong(Activator.getBundleContext().getProperty(
                    "org.aaloa.zb4osgi.zigbee.basedriver.timeout"));
        } catch (Exception ex) {
            TIMEOUT = DEFAULT_TIMEOUT;
            logger.debug(
                    "Unable to read org.aaloa.zb4osgi.zigbee.basedriver.timeout - setting to default value {}ms",
                    DEFAULT_TIMEOUT);
        }
    }

    /**
     * Generates the UUID from the actual value of the variables
     */
    private String generateUUID() {
		StringBuffer sb_uuid = new StringBuffer().append(profileId & 0xFFFF)
				.append(":").append(deviceId & 0xFFFF).append(":")
				.append(deviceVersion & 0xFF).append("@")
				.append(node.getIEEEAddress()).append(":")
				.append(endPointAddress & 0xFF);
		return sb_uuid.toString();
    }

    /**
     * This method set the ZigBeeNode for the device, it updates the linked
     * variable as need.<br>
     * It updates the node only if it differs from the old node.
     *
     * @param n
     *            the new {@link ZigBeeNode} for the device
     * @return <code>true</code> if and only if the {@link ZigBeeNode} has been
     *         updated
     * @since 0.6.0 - Revision 72
     *
     */
    public boolean setPhysicalNode(ZigBeeNode n) {
        if (node == null && n != null || node != n && node.equals(n) == false) {
            logger.debug("Initializing physicanl node info to {} ", n);
            node = n;
            uuid = generateUUID();
            properties.put(ZigBeeNode.IEEE_ADDRESS, node.getIEEEAddress());
            properties.put(ZigBeeNode.NWK_ADDRESS, node.getNetworkAddress());
            properties.put(ZigBeeDevice.UUID, uuid);

            properties.put(Constants.DEVICE_SERIAL, uuid);
            return true;
        } else if (node == n || node != null && node.equals(n)) {
            logger.debug("New physical data is identical to the old one, doing nothing");
            return false;
        } else if (node != null
                && !node.getIEEEAddress().equals(n.getIEEEAddress())) {
            logger.debug("Updating IEEE address of node {} to ", node, n.getIEEEAddress());
            node = n;
            uuid = generateUUID();
            properties.put(ZigBeeNode.IEEE_ADDRESS, node.getIEEEAddress());
            properties.put(ZigBeeDevice.UUID, uuid);

            properties.put(Constants.DEVICE_SERIAL, uuid);
            return true;
        } else if (node != null
                && node.getNetworkAddress() != n.getNetworkAddress()) {
            logger.debug("Updating network address of node {} to ", node, n.getNetworkAddress());
            node = n;
            properties.put(ZigBeeNode.NWK_ADDRESS, node.getNetworkAddress());
            return true;
        }
        return false;
    }

    private ZDO_SIMPLE_DESC_RSP doRetrieveSimpleDescription(ZigBeeNode n)
            throws ZigBeeBasedriverException {
        // TODO Move into SimpleDriver?!?!?
        final short nwk = (short) n.getNetworkAddress();
        int i = 1;
        final String nwkAddress = NetworkAddress.toString(nwk);
        ZDO_SIMPLE_DESC_RSP result = null;

        while (i <= Activator.getCurrentConfiguration().getMessageRetryCount()) {
            logger.info("Inspecting ZigBee EndPoint <{},{}>", nwkAddress, endPointAddress);
            result = driver.sendZDOSimpleDescriptionRequest(new ZDO_SIMPLE_DESC_REQ(nwk, endPointAddress));
            if (result == null) {
                // long waiting = (long) (Math.random() * (double)
                // Activator.getCurrentConfiguration().getMessageRetryDelay())
                final long waiting = Activator.getCurrentConfiguration().getMessageRetryDelay();
                ThreadUtils.waitNonPreemptive(waiting);
                i++;
                logger.debug("Inspecting ZigBee EndPoint <{},{}> failed during it {}-th attempts. "
                		+ "Waiting for {}ms before retrying", 
                		new Object[]{nwkAddress, endPointAddress, i, waiting}
        		);
            } else {
                break;
            }
        }

        if (result == null) {
            logger.error("Unable to receive a ZDO_SIMPLE_DESC_RSP for endpoint {} on node {}",
            		NetworkAddress.toString(nwk), endPointAddress);
            throw new ZigBeeBasedriverException("Unable to receive a ZDO_SIMPLE_DESC_RSP from endpoint");
        }

        return result;
    }

    public Dictionary getDescription() {
        return properties;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public short getDeviceVersion() {
        return deviceVersion;
    }

    public String getUniqueIdenfier() {
        return uuid;
    }

    public short getId() {
        return endPointAddress;
    }

    public int[] getInputClusters() {
        return inputs;
    }

    public int[] getOutputClusters() {
        return outputs;
    }

    public int getProfileId() {
        return profileId;
    }

    public ZigBeeNode getPhysicalNode() {
        return node;
    }

    public void send(Cluster input) throws ZigBeeBasedriverException {
        final AFLayer af = AFLayer.getAFLayer(driver);
        final byte sender = af.getSendingEndpoint(this, input);
        final byte transaction = af.getNextTransactionId(sender);
        final byte[] msg = input.getClusterMsg();

        // TODO Create radius and options according to the current configuration
        AF_DATA_CONFIRM response = driver
                .sendAFDataRequest(new AF_DATA_REQUEST((short) node
                        .getNetworkAddress(), (byte) endPointAddress, sender,
                        input.getId(), transaction, (byte) 0 /* options */,
                        (byte) 0 /* radius */, msg));

        if (response == null) {
            throw new ZigBeeBasedriverException(
                    "Unable to send cluster on the ZigBee network due to general error");
        } else if (response.getStatus() != 0) {
            throw new ZigBeeBasedriverException(
                    "Unable to send cluster on the ZigBee network:"
                            + response.getErrorMsg());
        }
    }

    public Cluster invoke(Cluster input) throws ZigBeeBasedriverException {
        final AFLayer af = AFLayer.getAFLayer(driver);
        final byte sender = af.getSendingEndpoint(this, input);
        /*
         * //FIX Removed because transaction is always 0 for the response due to a bug of CC2480 
         * 
         * final byte transaction = af.getNextTransactionId(sender); 
         * the next line is a workaround for the problem
         */
        final byte transaction = 0;
        final byte[] msg = input.getClusterMsg();

        m_addAFMessageListener();

        //Registering the waiter before sending the message, so that they will be captured
        WaitForClusterResponse waiter = new WaitForClusterResponse(transaction, input.getId(), TIMEOUT);
        addAFMessageConsumer(waiter);

        //TODO Create radius and options according to the current configuration
        AF_DATA_CONFIRM response = driver.sendAFDataRequest( new AF_DATA_REQUEST(
				(short) node.getNetworkAddress(), 
				(byte) endPointAddress, 
				sender,
	            input.getId(), 
	            transaction, 
	            (byte) 0 /* options */,
	            (byte) 0 /* radius */, 
	            msg
		) );
        
        if (response == null) {
        	removeAFMessageConsumer(waiter);
            m_removeAFMessageListener();
            throw new ZigBeeBasedriverException(
            		"Unable to send cluster on the ZigBee network due to general error - is the device sleeping?"
    		);
        } else if (response.getStatus() != 0) {
        	removeAFMessageConsumer(waiter);
            m_removeAFMessageListener();
            throw new ZigBeeBasedriverException(
            		"Unable to send cluster on the ZigBee network:" + response.getErrorMsg()
    		);
        } else {
            //FIX Can't be singleton because only a the invoke method can be invoked by multiple-thread
            //FIX Can't be singleton because the invoke method can be invoked by multiple-thread
            AF_INCOMING_MSG incoming = waiter.getResponse();
        	removeAFMessageConsumer(waiter);
            m_removeAFMessageListener();
            if (incoming == null) {
                throw new ZigBeeBasedriverTimeOutException();
            }
            Cluster result = new ClusterImpl(incoming.getData(), incoming.getClusterId());
            return result;
        }
    }

    public boolean providesInputCluster(int id) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == id)
                return true;
        }
        return false;
    }

    public boolean providesOutputCluster(int id) {
        for (int i = 0; i < outputs.length; i++) {
            if (outputs[i] == id)
                return true;
        }
        return false;
    }

    public boolean bindTo(ZigBeeDevice device, int clusterId)
            throws ZigBeeBasedriverException {
        logger.debug("Binding from device {} to {} for cluster {}",
                new Object[]{getUniqueIdenfier(), device.getUniqueIdenfier(),
                        new Integer(clusterId)});

        /*
         * //THINK Should you we deny the possibility to have duplicate entry
         * inside the binding table? The ZigBee specification see page 63, seems
         * to allow duplicate entry inside the binding table.
         */

        final ZDO_BIND_RSP response = driver.sendZDOBind(new ZDO_BIND_REQ(
                (short) getPhysicalNode().getNetworkAddress(),
                (short) clusterId, IEEEAddress
                        .fromColonNotation(getPhysicalNode().getIEEEAddress()),
                (byte) endPointAddress, IEEEAddress.fromColonNotation(device
                        .getPhysicalNode().getIEEEAddress()), (byte) device
                        .getDeviceId()));
        if (response == null || response.Status != 0) {
            logger.debug(
                    "ZDO_BIND_REQ failed, unable to bind from device {} to {} for cluster {}",
                    new Object[]{getUniqueIdenfier(),
                            device.getUniqueIdenfier(), new Integer(clusterId)});
            return false;
        }
        return true;
    }

    public boolean unbindFrom(ZigBeeDevice device, int clusterId)
            throws ZigBeeBasedriverException {
        logger.debug("Un-binding from device {} to {} for cluster {}",
                new Object[]{getUniqueIdenfier(), device.getUniqueIdenfier(),
                        new Integer(clusterId)});

        final ZDO_UNBIND_RSP response = driver
                .sendZDOUnbind(new ZDO_UNBIND_REQ((short) getPhysicalNode()
                        .getNetworkAddress(), (short) clusterId, IEEEAddress
                        .fromColonNotation(getPhysicalNode().getIEEEAddress()),
                        (byte) endPointAddress, IEEEAddress
                                .fromColonNotation(device.getPhysicalNode()
                                        .getIEEEAddress()), (byte) device
                                .getDeviceId()));
        if (response == null || response.Status != 0) {
            logger.debug( "ZDO_UNBIND_REQ failed, unable to un-bind from device {} to {} for cluster {}",
                    new Object[]{ getUniqueIdenfier(), device.getUniqueIdenfier(), new Integer(clusterId)} );
            return false;
        }
        return true;
    }

    public boolean bind(int clusterId) throws ZigBeeBasedriverException {
        logger.debug("Binding from cluster {} of device {}", clusterId, getUniqueIdenfier());
        if (boundCluster.contains(clusterId)) {
            logger.debug("Cluster already bound");
            return true;
        }

        byte dstEP = AFLayer.getAFLayer(driver).getSendingEndpoint(this,
                clusterId);
        final ZDO_BIND_RSP response = driver.sendZDOBind(new ZDO_BIND_REQ(
                (short) getPhysicalNode().getNetworkAddress(),
                (short) clusterId, IEEEAddress
                        .fromColonNotation(getPhysicalNode().getIEEEAddress()),
                (byte) endPointAddress, driver.getIEEEAddress(), (byte) dstEP));
        if (response == null || response.Status != 0) {
            logger.debug("ZDO_BIND_REQ failed, unable to bind");
            return false;
        }
        boundCluster.add(clusterId);
        return true;
    }

    public boolean unbind(int clusterId) throws ZigBeeBasedriverException {
        logger.debug("Unbinding from cluster {} of device {}", clusterId, getUniqueIdenfier());
        if (!boundCluster.contains(clusterId)) {
        	/*
        	 * //XXX Think that we may want to send ZDO_UNBIND_REQ and expect ZDO_UNBIND_RSP.ZDO_STATUS.ZDP_NO_ENTRY
        	 *  to ensure that eventual left-over binding are removed. Left-over binding may happen in the following
        	 *  scenario: the application bind to this device and later the whole ZB4O is restart, due to the lack of
        	 *  persistence the ZigBee Base Driver is not aware of existing binding 
        	 *  
        	 *  //TODO Provide a Test Unit for binding disalignment
        	 */
            logger.debug("No cluster bound");
            return true;
        }

        byte dstEP = AFLayer.getAFLayer(driver).getSendingEndpoint(this, clusterId);

        final ZDO_UNBIND_RSP response = driver.sendZDOUnbind(
        		new ZDO_UNBIND_REQ(
    				(short) getPhysicalNode().getNetworkAddress(), (short) clusterId, 
    				IEEEAddress.fromColonNotation(getPhysicalNode().getIEEEAddress()),
                    (byte) endPointAddress, driver.getIEEEAddress(), (byte) dstEP
        		)
		);
        if (response == null || response.Status != 0 ) {
        	if ( response.Status == ZDO_UNBIND_RSP.ZDO_STATUS.ZDP_NO_ENTRY ) {
        		/*
        		 * This scenario may happen by restarting the remote ZigBee device, if the device does not store the
        		 * binding table among rebooting. This is quite rare scenario because if the device is recognized as
        		 * new device then a new ZigBeeDevice service will be created
        		 */
        		logger.debug("ZDO_UNBIND_REQ failed due to a misaligment between device status and base driver,"
        				+ " no bound for cluster {} so RECOVERING by considering the unbind as SUCCEED", clusterId);
        	} else {
        		logger.debug("ZDO_UNBIND_REQ failed, unable to unbind");
                return false;
        	}
        }
        boundCluster.remove(clusterId);
        return true;
    }

    private void m_addAFMessageListener() {
        if (listeners.isEmpty() && consumers.size() == 0) {
            logger.debug("Registered {} as {}", this,
                    AFMessageListner.class.getName());
            driver.addAFMessageListner(this);
        } else {
            logger.debug("Skipped to registered {} as {}", this,
                    AFMessageListner.class.getName());
            logger.trace(
                    "Skipped registration due to: listeners.isEmpty() = {}  or consumers.size() = {}",
                    listeners.isEmpty(), consumers.size());
        }
    }

    private void m_removeAFMessageListener() {
        if (listeners.isEmpty() && consumers.size() == 0) {
            logger.debug("Unregistered {} as {}", this,
                    AFMessageListner.class.getName());
            driver.removeAFMessageListener(this);
        } else {
            logger.debug("Skipped unregistration of {} as {}", this,
                    AFMessageListner.class.getName());
            logger.trace(
                    "Skipped unregistration due to: listeners.isEmpty() = {}  or consumers.size() = {}",
                    listeners.isEmpty(), consumers.size());
        }
    }

    public boolean addClusterListener(ClusterListner listener) {
        m_addAFMessageListener();

        return listeners.add(listener);
    }

    public boolean removeClusterListener(ClusterListner listener) {
        boolean result = listeners.remove(listener);
        m_removeAFMessageListener();
        return result;
    }

    private void notifyClusterListner(Cluster c) {
        ArrayList<ClusterListner> localCopy;
        synchronized (listeners) {
            localCopy = new ArrayList<ClusterListner>(listeners);
        }
        if (localCopy.size() > 0) {
            logger.debug("Notifying {} ClusterListner of {}", localCopy.size(),
                    c.getClusterMsg());

            for (ClusterListner listner : localCopy) {
                try {
                    final ClusterFilter filter = listner.getClusterFilter();
                    if (filter == null) {
                        listner.handleCluster(this, c);
                    } else if (filter.match(c) == true) {
                        listner.handleCluster(this, c);
                    }
                } catch (Throwable t) {
                    logger.error("Error during dispatching of Cluster <{},{}>",
                            c.getId(), c.getClusterMsg());
                    logger.error("Error caused by:", t);
                }
            }
        }
    }

    public void notify(AF_INCOMING_MSG msg) {
        // THINK Do the notification in a separated Thread?
        if (msg.isError()) {
        	logger.debug("AF_INCOMING_MSG arrived but it is an error packet so IGNORING it");
            return;        	
        }
        
        if ( ( msg.getSrcAddr() & 0xFFFF ) != node.getNetworkAddress() ) {
        	/*
        	 * The source address must always match the node.getNetworkAddress() regardless if the message is sent
        	 * as unicast, groupcast, or broadcast. In fact, in case of broadcast and groupcast message, only the
        	 * destination Network Address would not match the Network Address of the dongle
        	 */
        	logger.debug("AF_INCOMING_MSG arrived but NETWORK ADDRESS does not match so IGNORING it: "
        			+ "recieved {} but expecting {} ", msg.getSrcAddr() & 0xFFFF, node.getNetworkAddress());
            return;
        }
        
        if (msg.getSrcEndpoint() != endPointAddress) {
        	logger.debug("AF_INCOMING_MSG arrived ENDPOINT does not match so IGNORING it: "
        			+ "received {} but expecting {}", msg.getSrcEndpoint(), endPointAddress);
			return;
		}
        
        logger.debug("AF_INCOMING_MSG arrived for {} message is {}", uuid, msg);
        ArrayList<AFMessageConsumer> localConsumers = null;
        synchronized (consumers) {
            localConsumers = new ArrayList<AFMessageConsumer>(consumers);
        }
        logger.debug("Notifying {} AFMessageConsumer", localConsumers.size());
        for (AFMessageConsumer consumer : localConsumers) {
            if (consumer.consume(msg)) {
                logger.debug("AF_INCOMING_MSG Consumed by {}", consumer.getClass().getName());
                return;
            } else {
                logger.debug("AF_INCOMING_MSG Ignored by {}", consumer.getClass().getName());
            }
        }

        logger.debug("Notifying cluster listener for received by {}", uuid);
        notifyClusterListner(new ClusterImpl(msg.getData(), msg.getClusterId()));
    }

    public boolean addAFMessageConsumer(AFMessageConsumer consumer) {
        synchronized (consumers) {
            return consumers.add(consumer);
        }
    }
    
    /**
     * This method is only for test unit purpose
     * 
     * @return the copy of the current list of {@link AFMessageConsumer}
     * @since 0.8.0
     */
    ArrayList<AFMessageConsumer> getAFConsumers(){
    	synchronized (consumers) {
    		return new ArrayList<AFMessageConsumer>(consumers);
		}
    }

    public boolean removeAFMessageConsumer(AFMessageConsumer consumer) {
        synchronized (consumers) {
            return consumers.remove(consumer);
        }
    }

    /**
     * @since 0.4.0
     */
    public String toString() {
        return getUniqueIdenfier();
    }

}
