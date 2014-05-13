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

package it.cnr.isti.zigbee.zcl.library.impl.general.partition;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.api.general.partition.TransferPartitionedFrameResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

import com.itaca.ztool.util.ByteUtils;

/**
 * This class represent the <b>Partition</b> Cluster as defined by the document:<br>
 * <i>TELECOM APPLICATIONS PROFILE SPECIFICATION</i> public release version
 * 075307r07 *
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * 
 */

public class TransferPartitionedFrameResponseImpl extends ResponseImpl
		implements TransferPartitionedFrameResponse {

	private byte fragmentationOptions;
	private int partitionIndicator;
	private byte[] partitionedFrame;

	public TransferPartitionedFrameResponseImpl(Response response)
			throws ZigBeeClusterException {
		super(response);
		ResponseImpl.checkSpecificCommandFrame(response,
				TransferPartitionedFrameResponse.ID);
		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(), 0);
		fragmentationOptions = (Byte) deserializer
				.readZigBeeType(ZigBeeType.Bitmap8bit);
		if (ByteUtils.getNthBitFromByte(fragmentationOptions, 2)) {
			partitionIndicator = (Integer) deserializer
					.readZigBeeType(ZigBeeType.UnsignedInteger8bit);
		} else {
			partitionIndicator = (Integer) deserializer
					.readZigBeeType(ZigBeeType.UnsignedInteger16bit);
		}

		partitionedFrame = (byte[]) deserializer
				.readZigBeeType(ZigBeeType.OctectString);

	}

	public byte getFragmentationOptions() {
		return fragmentationOptions;
	}

	public int getPartitionIndicator() {
		return partitionIndicator;
	}

	public byte[] getPartitionedFrame() {
		return partitionedFrame;
	}

}
