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

package it.cnr.isti.zigbee.zcl.library.api.general;

import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;

/**
 * This class represent the <b>Partition</b> Cluster as defined by the document:<br>
 * <i>TELECOM APPLICATIONS PROFILE SPECIFICATION</i> public release version
 * 075307r07 *
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * 
 */
public interface Partition extends ZCLCluster {

	static final short ID = 0x0016;
	static final String NAME = "Partition";
	static final String DESCRIPTION = "Provides commands and attributes for enabling partitioning of large frame to be carried from other clusters of ZigBee devices.";

	static final byte TRANSFER_PARTITIONED_FRAME_ID = 0x00;
	static final byte READ_HANDSHAKE_PARAM_ID = 0x01;
	static final byte WRITE_HANDSHAKE_PARAM_ID = 0x02;

	public Attribute getAttributeMaximumIncomingTransferSize();

	public Attribute getAttributeOutgoingTransferSize();

	public Attribute getAttributePartitionedFrameSize();

	public Attribute getAttributeLargeFrameSize();

	public Attribute getAttributeNumberOfACKFrame();

	public Attribute getAttributeNACKTimeout();

	public Attribute getAttributeInterframeDelay();

	public Attribute getAttributeNumberOfSendRetries();

	public Attribute getAttributeSenderTimeout();

	public Attribute getAttributeReceiverTimeout();

	public Response transferPartitionedFrame(byte bitmap, int b, byte[] c)
			throws ZigBeeClusterException;

	public Response readHandshakeParam( int PartitionedClusterIDValue, int[] attributeIDsValues
			)
			throws ZigBeeClusterException;

	public Response writeHandshakeParam( int PartitionedClusterIDValue, int[] attributeIDsValues
			)
			throws ZigBeeClusterException;

}
