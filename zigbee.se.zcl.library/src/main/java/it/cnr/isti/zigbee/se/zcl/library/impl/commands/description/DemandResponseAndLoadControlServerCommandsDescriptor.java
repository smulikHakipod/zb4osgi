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

import it.cnr.isti.zigbee.se.zcl.library.api.DemandResponseAndLoadControlServer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.core.CommandDescription;
import it.cnr.isti.zigbee.zcl.library.impl.field.SimpleFieldDescriptor;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 */
public class DemandResponseAndLoadControlServerCommandsDescriptor {
	// LOAD_CONTROL_EVENT
	public static int ISSUER_EVENT_ID_INDEX = 0;
	public static int DEVICE_CLASS_INDEX = 1;
	public static int UTILITY_ENROLMENT_GROUP_INDEX = 2;
	public static int START_TIME_INDEX = 3;
	public static int DURATION_IN_MINUTES_INDEX = 4;
	public static int CRITICALITY_LEVEL_INDEX = 5;
	public static int COOLING_TEMPERATURE_OFFSET_INDEX = 6;
	public static int HEATING_TEMPERATURE_OFFSET_INDEX = 7;
	public static int COOLING_TEMPERATURE_SET_POINT_INDEX = 8;
	public static int HEATING_TEMPERATURE_SET_POINT_INDEX = 9;
	public static int AVERAGE_LOAD_ADJUSTMENT_PERCENTAGE_INDEX = 10;
	public static int DUTY_CYCLE_INDEX = 11;
	public static int EVENT_CONTROL_INDEX = 12;
	// CANCEL_LOAD_CONTROL_EVENT
	public static int CANCEL_CONTROL_INDEX = 3;
	public static int EFFECTIVE_TIME_INDEX = 4;
	// CANCEL_ALL_LOAD_CONTROL_EVENTS
	public static int CANCEL_ALL_LOAD_CONTROL_EVENTS_CANCEL_CONTROL_INDEX = 0;

	public static CommandDescription CANCEL_ALL_LOAD_CONTROL_EVENTS = new CommandDescription(
			DemandResponseAndLoadControlServer.CANCEL_ALL_LOAD_CONTROL_EVENTS_ID)
			.addField(new SimpleFieldDescriptor()
					.setFieldIndex(CANCEL_ALL_LOAD_CONTROL_EVENTS_CANCEL_CONTROL_INDEX)
					.setName("Cancel Control")
					.setZigBeeType(ZigBeeType.Bitmap8bit));

	public static CommandDescription CANCEL_LOAD_CONTROL_EVENT = new CommandDescription(
			DemandResponseAndLoadControlServer.CANCEL_LOAD_CONTROL_EVENT_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ISSUER_EVENT_ID_INDEX)
							.setName("Load Issuer Event Id")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(DEVICE_CLASS_INDEX)
							.setName("Device Class")
							.setZigBeeType(ZigBeeType.Bitmap16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(UTILITY_ENROLMENT_GROUP_INDEX)
							.setName("Utility Enrolment Group")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(CANCEL_CONTROL_INDEX)
							.setName("Cancel Control")
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(EFFECTIVE_TIME_INDEX)
							.setName("Effective Time")
							.setZigBeeType(ZigBeeType.UTCTime));

	public static CommandDescription LOAD_CONTROL_EVENT = new CommandDescription(
			DemandResponseAndLoadControlServer.LOAD_CONTROL_EVENT_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ISSUER_EVENT_ID_INDEX)
							.setName("Load Issuer Event Id")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(DEVICE_CLASS_INDEX)
							.setName("Device Class")
							.setZigBeeType(ZigBeeType.Bitmap16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(UTILITY_ENROLMENT_GROUP_INDEX)
							.setName("Utility Enrolment Group")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor().setFieldIndex(START_TIME_INDEX)
							.setName("Start Time")
							.setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(DURATION_IN_MINUTES_INDEX)
							.setName("Duration In Minutes")
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(CRITICALITY_LEVEL_INDEX)
							.setName("Criticality Level")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(COOLING_TEMPERATURE_OFFSET_INDEX)
							.setName("Cooling Temperature Offset")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(HEATING_TEMPERATURE_OFFSET_INDEX)
							.setName("Heating Temperature Offset")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(COOLING_TEMPERATURE_SET_POINT_INDEX)
							.setName("Cooling Temperature Set Point")
							.setZigBeeType(ZigBeeType.SignedInteger16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(HEATING_TEMPERATURE_SET_POINT_INDEX)
							.setName("Heating Temperature Set Point")
							.setZigBeeType(ZigBeeType.SignedInteger16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									AVERAGE_LOAD_ADJUSTMENT_PERCENTAGE_INDEX)
							.setName("Average Load Adjustment Percentage")
							.setZigBeeType(ZigBeeType.SignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor().setFieldIndex(DUTY_CYCLE_INDEX)
							.setName("Duty Cycle")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(EVENT_CONTROL_INDEX)
							.setName("Event Control")
							.setZigBeeType(ZigBeeType.Bitmap8bit));

}
