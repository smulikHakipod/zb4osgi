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

package it.cnr.isti.zigbee.zcl.library.impl.attribute;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48 +0100 (gio, 30 gen 2014) $)
 */
public class AttributesPartition  {
   

	public static final AttributeDescriptor MAXIMUM_INCOMING_TRANSFER_SIZE = new AbstractAttribute()
    .setId(0x0000)
    .setName("MaximumIncomingTransferSize")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);
	
	public static final AttributeDescriptor OUTGOING_TRANSFER_SIZE = new AbstractAttribute()
    .setId(0x0001)
    .setName("OutgoingTransferSize")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);
	  
	public static final AttributeDescriptor PARTITIONED_FRAME_SIZE = new AbstractAttribute()
    .setId(0x0002)
    .setName("PartitionedFrameSize")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(true);
	
	public static final AttributeDescriptor LARGE_FRAME_SIZE = new AbstractAttribute()
    .setId(0x0003)
    .setName("LargeFrameSize")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(true);
	
	public static final AttributeDescriptor NUMBER_OF_ACK_FRAME = new AbstractAttribute()
    .setId(0x0004)
    .setName("NumberOfACKFrame")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(true);
	
	public static final AttributeDescriptor NACK_TIMEOUT = new AbstractAttribute()
    .setId(0x0005)
    .setName("NACKTimeout")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);
	
	public static final AttributeDescriptor INTERFRAME_DELAY = new AbstractAttribute()
    .setId(0x0006)
    .setName("InterframeDelay")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(true);
	
	public static final AttributeDescriptor NUMBER_OF_SEND_RETRIES = new AbstractAttribute()
    .setId(0x0007)
    .setName("NumberOfSendRetries")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
	
	public static final AttributeDescriptor SENDER_TIMEOUT = new AbstractAttribute()
    .setId(0x0008)
    .setName("SenderTimeout")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor RECEIVER_TIMEOUT = new AbstractAttribute()
    .setId(0x0009)
    .setName("ReceiverTimeout")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)    
    .setWritable(false);
	
}
