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

import it.cnr.isti.zigbee.se.zcl.library.api.DemandResponseAndLoadControlClient;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.core.CommandDescription;
import it.cnr.isti.zigbee.zcl.library.impl.field.SimpleFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 */
public class DemandResponseAndLoadControlClientCommandsDescriptor {
	// REPORT_EVENT_STATUS
	public static int ISSUER_EVENT_ID_INDEX = 0;
	public static int EVENT_STATUS_INDEX = 1;
	public static int EVENT_STATUS_TIME_INDEX = 2;
	public static int CRITICALITY_LEVEL_APPLIED_INDEX = 3;
	public static int COOLING_TEMPERATURE_SET_POINT_APPLIED_INDEX = 4;
	public static int HEATING_TEMPERATURE_SET_POINT_APPLIED_INDEX = 5;
	public static int AVERAGE_LOAD_ADJUSTMENT_PERCENTAGE_APPLIED_INDEX = 6;
	public static int DUTY_CYCLE_APPLIED_INDEX = 7;
	public static int EVENT_CONTROL_INDEX = 8;
	public static int SIGNATURE_TYPE_INDEX = 9;
	public static int SIGNATURE_INDEX = 10;
	// GET_SCHEDULED_EVENTS
	public static int START_TIME_INDEX = 0;
	public static int NUMBER_OF_EVENTS = 1;

	
	public static CommandDescription GET_SCHEDULED_EVENTS = new CommandDescription(
			DemandResponseAndLoadControlClient.GET_SCHEDULED_EVENTS_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(START_TIME_INDEX)
							.setName("Start Time")
							.setZigBeeType(ZigBeeType.UTCTime))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(NUMBER_OF_EVENTS)
							.setName("Number Of Events")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit));
	
	public static CommandDescription REPORT_EVENT_STATUS = new CommandDescription(
			DemandResponseAndLoadControlClient.REPORT_EVENT_STATUS_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ISSUER_EVENT_ID_INDEX)
							.setName("Issuer Event Id")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(EVENT_STATUS_INDEX)
							.setName("Event Status")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(EVENT_STATUS_TIME_INDEX)
							.setName("Event Status Time")
							.setZigBeeType(ZigBeeType.UTCTime))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(CRITICALITY_LEVEL_APPLIED_INDEX)
							.setName("Criticality Level Applied")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									COOLING_TEMPERATURE_SET_POINT_APPLIED_INDEX)
							.setName("Cooling Temperature Set Point Applied")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									HEATING_TEMPERATURE_SET_POINT_APPLIED_INDEX)
							.setName("Heating Temperature Set Point Applied")
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									AVERAGE_LOAD_ADJUSTMENT_PERCENTAGE_APPLIED_INDEX)
							.setName("Average Load Adjustment Percentage Applied")
							.setZigBeeType(ZigBeeType.SignedInteger8bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(DUTY_CYCLE_APPLIED_INDEX)
							.setName("Duty Cycle Applied")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(EVENT_CONTROL_INDEX)
							.setName("Event Control")
							.setZigBeeType(ZigBeeType.Bitmap8bit))

			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(SIGNATURE_TYPE_INDEX)
							.setName("Signature Type")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))

			.addField(
					new SimpleFieldDescriptor().setFieldIndex(SIGNATURE_INDEX)
							.setName("Signature")
							.setZigBeeType(ZigBeeType.Signature));

}
