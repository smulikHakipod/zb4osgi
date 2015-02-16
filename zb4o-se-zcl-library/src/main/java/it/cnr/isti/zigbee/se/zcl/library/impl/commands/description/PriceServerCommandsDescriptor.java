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

import it.cnr.isti.zigbee.se.zcl.library.api.Price;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.core.CommandDescription;
import it.cnr.isti.zigbee.zcl.library.impl.field.SimpleFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 */
public class PriceServerCommandsDescriptor {
	// GET_CURRENT_PRICE
	public static int COMMAND_OPTIONS_INDEX = 0;
	// GET_SCHEDULED_PRICES + GET_BLOCK_PERIOD
	public static int START_TIME_INDEX = 0;
	public static int NUMBER_OF_EVENTS_INDEX = 1;
	// PRICE_ACKNOWLEDGEMENT
	public static int PROVIDER_ID_INDEX = 0;
	public static int ISSUER_EVENT_ID_INDEX = 1;
	public static int PRICE_ACK_TIME_INDEX = 2;
	public static int CONTROL_INDEX = 3;

	public static CommandDescription GET_CURRENT_PRICE = new CommandDescription(
			Price.GET_CURRENT_PRICE_ID).addField(new SimpleFieldDescriptor()
			.setFieldIndex(COMMAND_OPTIONS_INDEX).setName("Command Options")
			.setZigBeeType(ZigBeeType.UnsignedInteger8bit));

	public static CommandDescription GET_SCHEDULED_PRICES = new CommandDescription(
			Price.GET_SCHEDULED_PRICES_ID).addField(
			new SimpleFieldDescriptor().setFieldIndex(START_TIME_INDEX)
					.setName("Start Time").setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(NUMBER_OF_EVENTS_INDEX)
							.setName("Number Of Events")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit));

	public static CommandDescription PRICE_ACKNOWLEDGEMENT = new CommandDescription(
			Price.PRICE_ACKNOWLEDGEMENT_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(PROVIDER_ID_INDEX)
							.setName("Provider ID")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ISSUER_EVENT_ID_INDEX)
							.setName("Issuer Event ID")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(PRICE_ACK_TIME_INDEX)
							.setName("Price Ack Time")
							.setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor().setFieldIndex(CONTROL_INDEX)
							.setName("Control Index")
							.setZigBeeType(ZigBeeType.Bitmap8bit));

	public static CommandDescription GET_BLOCK_PERIOD = new CommandDescription(
			Price.GET_BLOCK_PERIOD_ID).addField(
			new SimpleFieldDescriptor().setFieldIndex(START_TIME_INDEX)
					.setName("Start Time").setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(NUMBER_OF_EVENTS_INDEX)
							.setName("Number Of Events")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit));

}
