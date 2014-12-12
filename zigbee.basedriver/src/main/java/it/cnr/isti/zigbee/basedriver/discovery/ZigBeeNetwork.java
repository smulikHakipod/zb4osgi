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

package it.cnr.isti.zigbee.basedriver.discovery;

import gnu.trove.TIntObjectHashMap;
import gnu.trove.TShortObjectHashMap;
import gnu.trove.TShortObjectIterator;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;
import it.cnr.isti.zigbee.basedriver.api.impl.ZigBeeNodeImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 *         * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo
 *         Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 *
 */
public class ZigBeeNetwork {

    private static final Logger logger = LoggerFactory
            .getLogger(ZigBeeNetwork.class);

    private final Hashtable<String, ZigBeeNodeImpl> nodes = new Hashtable<String, ZigBeeNodeImpl>();
    private final Hashtable<ZigBeeNode, TShortObjectHashMap<ZigBeeDevice>> devices = new Hashtable<ZigBeeNode, TShortObjectHashMap<ZigBeeDevice>>();

    private final TIntObjectHashMap<ArrayList<ZigBeeDevice>> profiles = new TIntObjectHashMap<ArrayList<ZigBeeDevice>>();

    /**
     *
     * <b>NOT IN USE, the Driver does not define a logic for unregister
     * devices</b><br>
     * This method is require for implementing issues:
     * <ul>
     * <li><a href="http://zb4osgi.aaloa.org/redmine/issues/35">Blacklisting of
     * device (#35)</a></li>
     * <li><a href="http://zb4osgi.aaloa.org/redmine/issues/64">Base Driver
     * should monitor the health status of device (#64)</a></li>
     * </ul>
     *
     *
     * @param node
     * @return
     */
    public synchronized boolean removeNode(ZigBeeNode node) {
        final String ieee = node.getIEEEAddress();

        if (!nodes.containsKey(ieee)) {
            return false;
        }
        TShortObjectHashMap<ZigBeeDevice> toRemove = devices.get(node);
        if (toRemove != null) {
            TShortObjectIterator<ZigBeeDevice> i = toRemove.iterator();
            while (i.hasNext()) {
                i.advance();
                if (i.value() != null) {
                    ZigBeeDevice device = i.value();
                    i.remove();
                    removeDeviceFromProfiles(device);
                }
            }
        }
        nodes.remove(ieee);
        return true;
    }

    public synchronized boolean addNode(ZigBeeNodeImpl node) {
        final String ieee = node.getIEEEAddress();

        if (nodes.containsKey(ieee)) {
            logger.debug("Node {} already present on the network", node);
            return false;
        }

        logger.debug("Adding node {} to the network", node);
        nodes.put(ieee, node);
        devices.put(node, new TShortObjectHashMap<ZigBeeDevice>());
        return true;
    }

    public synchronized boolean removeDevice(ZigBeeDevice device) {
        final String ieee = device.getPhysicalNode().getIEEEAddress();

        ZigBeeNode node = null;
        node = nodes.get(ieee);
        if (node == null) {
            logger.error(
                    "Trying to remove a device but containing node {} does not exists",
                    node);
            return false;
        }

        final TShortObjectHashMap<ZigBeeDevice> endPoints = devices.get(node);
        endPoints.remove(device.getId());
        removeDeviceFromProfiles(device);

        return true;
    }

    public synchronized boolean addDevice(ZigBeeDevice device) {

        final ZigBeeNode deviceNode = device.getPhysicalNode();
        final String ieee = deviceNode.getIEEEAddress();
        final short endPoint = device.getId();
        logger.debug("Adding device {} on node {} the network", endPoint,
                device.getPhysicalNode());
        final ZigBeeNode node = nodes.get(ieee);
        if (node == null) {
            logger.debug("No node {} found");
            return false;
        }
/*		switch (duplicateMacPolicy) {
        case Ignore:
            if (node.getNetworkAddress() != deviceNode.getNetworkAddress()) {
                logger.debug(
                        "Node ieee collision, stored is {} and new one is {}",
                        node, deviceNode);

            }
            return false;

        case Update:
            if (node.getNetworkAddress() != deviceNode.getNetworkAddress()) {
                logger.debug(
                        "Node ieee collision, stored is {} and new one is {}, Updating with new node Address",
                        node, deviceNode);
                ((ZigBeeNodeImpl) node).setNetworkAddress(deviceNode
                        .getNetworkAddress());
                logger.debug(
                        "Updated stored node address {} with new address {}",
                        node, deviceNode);
            }
            return false;

        case Register:
            if (node.getNetworkAddress() != deviceNode.getNetworkAddress()) {
                logger.debug(
                        "Node ieee collision, stored is {} and new one is {}, De-registering old service and registering new one",
                        node, deviceNode);
                removeDevice(device);
                logger.debug(
                        "Removed stored ZigBee service, updating with fresh new service {}",
                        node);

            }
            break;

        default:
            break;

        }*/

        TShortObjectHashMap<ZigBeeDevice> endPoints = devices.get(node);
        if (endPoints.containsKey(endPoint)) {
            logger.debug("Device {} on node {} already registered", endPoint,
                    node);
            return false;
        }
        endPoints.put(endPoint, device);

        final int profileId = device.getProfileId();
        ArrayList<ZigBeeDevice> list;
        list = profiles.get(profileId);
        if (list == null) {
            list = new ArrayList<ZigBeeDevice>();
            profiles.put(profileId, list);
        }
        list.add(device);

        return true;
    }

    private synchronized boolean removeDeviceFromProfiles(
            final ZigBeeDevice device) {

        final int profileId = device.getProfileId();
        ArrayList<ZigBeeDevice> list = profiles.get(profileId);
        if (list == null) {
            logger.error("Trying to remove a device from a given profile but the profile doesn't exist");
            // XXX It should never happen, we should throw an
            // IllegalStateException
            return true;
        }
        // XXX It following method must always return true, otherwise we should
        // throw an IllegalStateException
        if (list.remove(device) == false) {
            logger.error("Device to remove not found in the given profile");
        }

        return true;

    }

    public synchronized Collection<ZigBeeDevice> getDevices(int profileId) {
        final ArrayList<ZigBeeDevice> result = new ArrayList<ZigBeeDevice>();
        final ArrayList<ZigBeeDevice> values = profiles.get(profileId);
        if (values == null) {
            logger.warn("No devices found implenting the profile={}", profileId);
        } else {
            logger.error("We found {} implementing the profile={}",
                    values.size(), profileId);
            result.addAll(values);
        }
        return result;
    }

    public boolean containsDevice(String ieee, short endPoint) {
        final ZigBeeNode node = nodes.get(ieee);
        if (node == null) {
            return false;
        }
        /*
         * If node is not null it means that we found the same network node
         * because IEEE address must be unique for each network node
         */
        final TShortObjectHashMap<ZigBeeDevice> endPoints = devices.get(node);
        if (endPoints == null) {
            return false;
        }
        return endPoints.containsKey(endPoint);
    }

    public ZigBeeNodeImpl containsNode(String ieeeAddress) {
        return nodes.get(ieeeAddress);
    }

    /*public boolean updateService(ZigBeeDevice device) {
        final ZigBeeNode deviceNode = device.getPhysicalNode();
        final String ieee = deviceNode.getIEEEAddress();
        final short endPoint = device.getId();
        logger.debug("Adding device {} on node {} the network", endPoint,
                device.getPhysicalNode());
        final ZigBeeNode node = nodes.get(ieee);
        if (node == null) {
            logger.debug("No node {} found");
            return false;
        }
        if (node.getNetworkAddress() != deviceNode.getNetworkAddress()) {
            logger.debug(
                    "Node ieee collision, stored is {} and new one is {}, Updating with new node Address",
                    node, deviceNode);
            try {
                ((ZigBeeNodeImpl) node).setNetworkAddress(deviceNode
                        .getNetworkAddress());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            logger.debug("Updated stored node address {} with new address {}",
                    node, deviceNode);


        }
        return true;

    }*/

    public boolean removeDevice(ZigBeeNode node, byte ep) {

        if (node == null) {
            logger.error(
                    "Trying to remove a device but containing node {} does not exists",
                    node);
            return false;
        }

        final TShortObjectHashMap<ZigBeeDevice> endPoints = devices.get(node);
        removeDeviceFromProfiles(endPoints.get(ep) );
        endPoints.remove(ep);

        return true;
    }

    /*public boolean updateDevice(ZigBeeNode node, byte ep) {
        final TShortObjectHashMap<ZigBeeDevice> endPoints = devices.get(node);
        ZigBeeDevice toUpdateDevice = endPoints.get(ep);

        try {

            ((ZigBeeNodeImpl) toUpdateDevice.getPhysicalNode()).setNetworkAddress(node.getNetworkAddress());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return false;
    }*/
}
