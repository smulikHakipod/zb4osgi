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
public class MessagingServerCommandsDescriptor {

	public static int MESSAGE_ID_INDEX = 0;

	public static int CONFIRMATION_TIME_INDEX = 1;

	public static CommandDescription GET_LAST_MESSAGE = new CommandDescription(
			Messaging.GET_LAST_MESSAGE_ID);

	public static CommandDescription MESSAGE_CONFIRMATION = new CommandDescription(
			Messaging.MESSAGE_CONFIRMATION_ID)

	.addField(
			new SimpleFieldDescriptor().setName("Message Id")
					.setFieldIndex(MESSAGE_ID_INDEX)
					.setZigBeeType(ZigBeeType.UnsignedInteger32bit)).addField(
			new SimpleFieldDescriptor().setName("Confirmation Time")
					.setFieldIndex(CONFIRMATION_TIME_INDEX)
					.setZigBeeType(ZigBeeType.UTCTime));

}
