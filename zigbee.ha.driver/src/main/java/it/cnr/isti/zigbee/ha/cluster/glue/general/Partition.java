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

package it.cnr.isti.zigbee.ha.cluster.glue.general;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.ReadHandshakeParamResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.TransferPartitionedFrameResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.WriteHandshakeParamResponse;

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
public interface Partition extends Cluster {
	public TransferPartitionedFrameResponse TransferPartitionedFrame(
			byte fragmentationOptions, int partitionIndicator,
			byte[] partitionedFrame) throws ZigBeeHAException;

	public ReadHandshakeParamResponse ReadHandshakeParam(int PartitionedClusterIDValue, int[] attributeIDsValues)
			throws ZigBeeHAException;

	public WriteHandshakeParamResponse WriteHandshakeParam(int PartitionedClusterIDValue, int[] attributeIDsValues)
			throws ZigBeeHAException;

	public int getMaximumIncomingTransferSize() throws ZigBeeHAException;

	public int getOutgoingTransferSize() throws ZigBeeHAException;

	public int getPartitionedFrameSize() throws ZigBeeHAException;

	public int getLargeFrameSize() throws ZigBeeHAException;

	public int getNumberOfACKFrame() throws ZigBeeHAException;

	public int getNACKTimeout() throws ZigBeeHAException;

	public int getInterframeDelay() throws ZigBeeHAException;

	public int getNumberOfSendRetries() throws ZigBeeHAException;

	public int getSenderTimeout() throws ZigBeeHAException;

	public int getReceiverTimeout() throws ZigBeeHAException;
}
