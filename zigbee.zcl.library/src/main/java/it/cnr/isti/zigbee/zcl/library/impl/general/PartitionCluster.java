/*
 * Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
 * Institute of Information Science and Technologies
 * of the Italian National Research Council
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package it.cnr.isti.zigbee.zcl.library.impl.general;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.general.Partition;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AttributesPartition;
import it.cnr.isti.zigbee.zcl.library.impl.commands.description.PartitionCommandsDescriptor;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.GenericCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;
import it.cnr.isti.zigbee.zcl.library.impl.general.partition.ReadHandshakeParamResponseImpl;
import it.cnr.isti.zigbee.zcl.library.impl.general.partition.TransferPartitionedFrameResponseImpl;
import it.cnr.isti.zigbee.zcl.library.impl.general.partition.WriteHandshakeParamResponseImpl;

/**
 * This class represent the <b>Partition</b> Cluster as defined by the document:<br>
 * <i>TELECOM APPLICATIONS PROFILE SPECIFICATION</i> public release version
 * 075307r07 *
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */
public class PartitionCluster extends ZCLClusterBase implements Partition {
	private final AttributeImpl maximumIncomingTransferSize;
	private final AttributeImpl outgoingTransferSize;
	private final AttributeImpl partitionedFrameSize;
	private final AttributeImpl largeFrameSize;
	private final AttributeImpl numberOfACKFrame;
	private final AttributeImpl nACKTimeout;
	private final AttributeImpl interframeDelay;
	private final AttributeImpl numberOfSendRetries;
	private final AttributeImpl senderTimeout;
	private final AttributeImpl receiverTimeout;
	private final Attribute[] attributes;

	public PartitionCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);
		maximumIncomingTransferSize = new AttributeImpl(zbDevice, this,
				AttributesPartition.MAXIMUM_INCOMING_TRANSFER_SIZE);
		outgoingTransferSize = new AttributeImpl(zbDevice, this,
				AttributesPartition.OUTGOING_TRANSFER_SIZE);
		partitionedFrameSize = new AttributeImpl(zbDevice, this,
				AttributesPartition.PARTITIONED_FRAME_SIZE);
		largeFrameSize = new AttributeImpl(zbDevice, this,
				AttributesPartition.LARGE_FRAME_SIZE);
		numberOfACKFrame = new AttributeImpl(zbDevice, this,
				AttributesPartition.NUMBER_OF_ACK_FRAME);
		nACKTimeout = new AttributeImpl(zbDevice, this,
				AttributesPartition.NACK_TIMEOUT);
		interframeDelay = new AttributeImpl(zbDevice, this,
				AttributesPartition.INTERFRAME_DELAY);
		numberOfSendRetries = new AttributeImpl(zbDevice, this,
				AttributesPartition.NUMBER_OF_SEND_RETRIES);
		senderTimeout = new AttributeImpl(zbDevice, this,
				AttributesPartition.SENDER_TIMEOUT);
		receiverTimeout = new AttributeImpl(zbDevice, this,
				AttributesPartition.RECEIVER_TIMEOUT);
		attributes = new Attribute[] { maximumIncomingTransferSize,
				outgoingTransferSize, partitionedFrameSize, largeFrameSize,
				numberOfACKFrame, nACKTimeout, interframeDelay,
				numberOfSendRetries, senderTimeout, receiverTimeout };
	}

	public Attribute getAttributeMaximumIncomingTransferSize() {
		return maximumIncomingTransferSize;
	}

	public Attribute getAttributeOutgoingTransferSize() {
		return outgoingTransferSize;
	}

	public Attribute getAttributePartitionedFrameSize() {
		return partitionedFrameSize;
	}

	public Attribute getAttributeLargeFrameSize() {
		return largeFrameSize;
	}

	public Attribute getAttributeNumberOfACKFrame() {
		return numberOfACKFrame;
	}

	public Attribute getAttributeNACKTimeout() {
		return nACKTimeout;
	}

	public Attribute getAttributeInterframeDelay() {
		return interframeDelay;
	}

	public Attribute getAttributeNumberOfSendRetries() {
		return numberOfSendRetries;
	}

	public Attribute getAttributeSenderTimeout() {
		return senderTimeout;
	}

	public Attribute getAttributeReceiverTimeout() {
		return receiverTimeout;
	}

	@Override
	public short getId() {
		return Partition.ID;
	}

	@Override
	public String getName() {
		return Partition.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Response Prova(int a, int[] b) throws ZigBeeClusterException 
	{
		return null;
	//	GenericCommand prova = PartitionCommandsDescriptor.PROVA.createCommand();
	//	prova.setFieldValue(a,0);
	//	prova.setFieldValue(b,1);
	//	Response response = invoke(prova);		
	//	return new ReadHandshakeParamResponseImpl(response);
	}
	
	public Response readHandshakeParam(int PartitionedClusterIDValue,
			int[] attributeIDsValues) throws ZigBeeClusterException {
		GenericCommand readHandshakeParamCmd = PartitionCommandsDescriptor.READ_HANDSHAKE_PARAM.createCommand();
		readHandshakeParamCmd.setFieldValue(PartitionedClusterIDValue,readHandshakeParamCmd.getFieldDescription(PartitionCommandsDescriptor.PARTITIONED_CLUSTER_ID_INDEX));
		readHandshakeParamCmd.setFieldValue(attributeIDsValues,readHandshakeParamCmd.getFieldDescription(PartitionCommandsDescriptor.ATTRIBUTE_IDENTIFIER_INDEX));
		Response response = invoke(readHandshakeParamCmd);
		return new ReadHandshakeParamResponseImpl(response);
	}

	public Response writeHandshakeParam(int PartitionedClusterIDValue,
			int[] writeAttributeRecordValues) throws ZigBeeClusterException {
		GenericCommand writeHandshakeParamCmd = PartitionCommandsDescriptor.WRITE_HANDSHAKE_PARAM.createCommand();
		writeHandshakeParamCmd.setFieldValue(PartitionedClusterIDValue,writeHandshakeParamCmd.getFieldDescription(PartitionCommandsDescriptor.PARTITIONED_CLUSTER_ID_INDEX));
		writeHandshakeParamCmd.setFieldValue(writeAttributeRecordValues,writeHandshakeParamCmd.getFieldDescription(PartitionCommandsDescriptor.WRITE_ATTRIBUTE_RECORD_INDEX));
		Response response = invoke(writeHandshakeParamCmd);
		return new WriteHandshakeParamResponseImpl(response);
	}

	public Response transferPartitionedFrame(byte fragmentationOptionsValue,
			int partitionIndicatorValue, byte[] partitionedFrameValue)
			throws ZigBeeClusterException {
		GenericCommand transferPartitionedFrame = PartitionCommandsDescriptor.TRANSFER_PARTITIONED_FRAME.createCommand();
		transferPartitionedFrame.setFieldValue(fragmentationOptionsValue,transferPartitionedFrame.getFieldDescription(PartitionCommandsDescriptor.FRAGMENTATION_OPTIONS_INDEX));
		transferPartitionedFrame.setFieldValue(partitionIndicatorValue,transferPartitionedFrame.getFieldDescription(PartitionCommandsDescriptor.PARTITION_INDICATOR_INDEX));
		transferPartitionedFrame.setFieldValue(partitionedFrameValue,transferPartitionedFrame.getFieldDescription(PartitionCommandsDescriptor.PARTITIONED_FRAME_INDEX));
		Response response = invoke(transferPartitionedFrame);
		return new TransferPartitionedFrameResponseImpl(response);
	}
}
