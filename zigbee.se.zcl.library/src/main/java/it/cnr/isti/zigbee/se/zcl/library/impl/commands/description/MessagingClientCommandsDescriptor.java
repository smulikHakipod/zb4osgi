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

package it.cnr.isti.zigbee.se.zcl.library.impl.commands.description;

import it.cnr.isti.zigbee.se.zcl.library.api.Messaging;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.core.CommandDescription;
import it.cnr.isti.zigbee.zcl.library.impl.field.SimpleFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 */
public class MessagingClientCommandsDescriptor {

	public static int MESSAGE_ID_INDEX = 0;

	public static int MESSAGE_CONTROL_INDEX = 1;

	public static int START_TIME_INDEX = 2;

	public static int DURATION_IN_MINUTES_INDEX = 3;

	public static int MESSAGE_INDEX = 4;

	public static CommandDescription DISPLAY_MESSAGE = new CommandDescription(
			Messaging.DISPLAY_MESSAGE_ID)
			.addField(
					new SimpleFieldDescriptor().setName("Message Id")
							.setFieldIndex(MESSAGE_ID_INDEX)
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor().setName("Message Control")
							.setFieldIndex(MESSAGE_CONTROL_INDEX)
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor().setName("Start Time")
							.setFieldIndex(START_TIME_INDEX)
							.setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor().setName("Duration In Minutes")
							.setFieldIndex(DURATION_IN_MINUTES_INDEX)
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))
			.addField(
					new SimpleFieldDescriptor().setName("Messages")
							.setFieldIndex(MESSAGE_INDEX)
							.setZigBeeType(ZigBeeType.CharacterString));

	public static CommandDescription CANCEL_MESSAGE = new CommandDescription(
			Messaging.CANCEL_MESSAGE_ID).addField(
			new SimpleFieldDescriptor().setName("Message Id")
					.setFieldIndex(MESSAGE_ID_INDEX)
					.setZigBeeType(ZigBeeType.UnsignedInteger32bit)).addField(
			new SimpleFieldDescriptor().setName("Message Control")
					.setFieldIndex(MESSAGE_CONTROL_INDEX)
					.setZigBeeType(ZigBeeType.Bitmap8bit))

	;

}
