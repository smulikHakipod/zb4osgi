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

package it.cnr.isti.zigbee.zcl.library.impl.commands.description;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.api.general.Partition;
import it.cnr.isti.zigbee.zcl.library.impl.core.CommandDescription;
import it.cnr.isti.zigbee.zcl.library.impl.field.BitmaskDependency;
import it.cnr.isti.zigbee.zcl.library.impl.field.FieldType;
import it.cnr.isti.zigbee.zcl.library.impl.field.ListFieldDescriptor;
import it.cnr.isti.zigbee.zcl.library.impl.field.MatchType;
import it.cnr.isti.zigbee.zcl.library.impl.field.SimpleFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 */
public class PartitionCommandsDescriptor {

	public static int FRAGMENTATION_OPTIONS_INDEX = 0;

	public static int PARTITION_INDICATOR_INDEX = 1;

	public static int PARTITIONED_FRAME_INDEX = 2;

	public static int PARTITIONED_CLUSTER_ID_INDEX = 0;

	public static int ATTRIBUTE_IDENTIFIER_INDEX = 1;

	public static int WRITE_ATTRIBUTE_RECORD_INDEX = 1;

	public static BitmaskDependency partitionIndicatorDependency = new BitmaskDependency()
			.dependFromField(FRAGMENTATION_OPTIONS_INDEX)
			.matchType(MatchType.SINGLE_BIT).matchPositions(1);

	public static CommandDescription TRANSFER_PARTITIONED_FRAME = new CommandDescription(
			Partition.TRANSFER_PARTITIONED_FRAME_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setName("Fragmentation Options")
							.setFieldIndex(FRAGMENTATION_OPTIONS_INDEX)
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor().setName("Partition Indicator")
							.setFieldIndex(PARTITION_INDICATOR_INDEX)
							.setFieldType(FieldType.LIST)
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit)
							.setDependency(partitionIndicatorDependency))
			.addField(
					new SimpleFieldDescriptor().setName("Partitioned Frame")
							.setFieldIndex(PARTITIONED_FRAME_INDEX)
							.setZigBeeType(ZigBeeType.OctectString));

	public static CommandDescription READ_HANDSHAKE_PARAM = new CommandDescription(
			Partition.READ_HANDSHAKE_PARAM_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setName("Partitioned ClusterID")
							.setFieldIndex(PARTITIONED_CLUSTER_ID_INDEX)
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))
			.addField(
					new ListFieldDescriptor()
							.setName("Attribute Identifier")
							.setFieldIndex(ATTRIBUTE_IDENTIFIER_INDEX)
							.setElementDescriptor(
									new SimpleFieldDescriptor()
											.setZigBeeType(ZigBeeType.UnsignedInteger16bit))

			);

	public static CommandDescription WRITE_HANDSHAKE_PARAM = new CommandDescription(
			Partition.WRITE_HANDSHAKE_PARAM_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setName("Partitioned ClusterID")
							.setFieldIndex(PARTITIONED_CLUSTER_ID_INDEX)
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))
			.addField(
					new ListFieldDescriptor()
							.setName("Write Attribute Record")
							.setFieldIndex(WRITE_ATTRIBUTE_RECORD_INDEX)
							.setElementDescriptor(
									new SimpleFieldDescriptor()
											.setZigBeeType(ZigBeeType.UnsignedInteger16bit)));

}
