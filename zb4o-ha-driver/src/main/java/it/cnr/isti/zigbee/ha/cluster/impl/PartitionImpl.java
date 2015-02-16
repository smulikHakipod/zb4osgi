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

package it.cnr.isti.zigbee.ha.cluster.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Partition;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.ReadHandshakeParamResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.TransferPartitionedFrameResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.WriteHandshakeParamResponse;
import it.cnr.isti.zigbee.zcl.library.impl.general.PartitionCluster;

/**
 * This class represent the <b>Partition</b> Cluster as defined by the document:<br>
 * <i>TELECOM APPLICATIONS PROFILE SPECIFICATION</i> public release version
 * 075307r07 *
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 * 
 */
public class PartitionImpl implements Partition {

	private PartitionCluster partitionCluster;

	public PartitionImpl(ZigBeeDevice zbDevice) {

		partitionCluster = new PartitionCluster(zbDevice);
	}

	public int getId() {
		return partitionCluster.getId();
	}

	public String getName() {
		return partitionCluster.getName();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = partitionCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}

	public Attribute[] getAttributes() {
		return partitionCluster.getAvailableAttributes();
	}

	public Subscription[] getActiveSubscriptions() {
		return partitionCluster.getActiveSubscriptions();
	}

	public int getMaximumIncomingTransferSize() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeMaximumIncomingTransferSize()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getOutgoingTransferSize() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeOutgoingTransferSize()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getPartitionedFrameSize() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributePartitionedFrameSize()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getLargeFrameSize() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeLargeFrameSize()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNumberOfACKFrame() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeNumberOfACKFrame()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNACKTimeout() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeNACKTimeout()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getInterframeDelay() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeInterframeDelay()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNumberOfSendRetries() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeNumberOfSendRetries()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getSenderTimeout() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeSenderTimeout()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getReceiverTimeout() throws ZigBeeHAException {
		try {
			return (Integer) partitionCluster.getAttributeReceiverTimeout()
												.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public ReadHandshakeParamResponse ReadHandshakeParam(
			int PartitionedClusterIDValue, int[] attributeIDsValues)
			throws ZigBeeHAException {
		try {
			ReadHandshakeParamResponse response = (ReadHandshakeParamResponse) partitionCluster.readHandshakeParam(
					PartitionedClusterIDValue, attributeIDsValues);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public WriteHandshakeParamResponse WriteHandshakeParam(
			int PartitionedClusterIDValue, int[] writeAttributeRecordValues)
			throws ZigBeeHAException {
		try {
			WriteHandshakeParamResponse response = (WriteHandshakeParamResponse) partitionCluster.writeHandshakeParam(
					PartitionedClusterIDValue, writeAttributeRecordValues);

			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public TransferPartitionedFrameResponse TransferPartitionedFrame(
			byte fragmentationOptions, int partitionIndicator,
			byte[] partitionedFrame) throws ZigBeeHAException {
		try {
			TransferPartitionedFrameResponse response = (TransferPartitionedFrameResponse) partitionCluster.transferPartitionedFrame(
					fragmentationOptions, partitionIndicator, partitionedFrame);
			return response;
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

}
