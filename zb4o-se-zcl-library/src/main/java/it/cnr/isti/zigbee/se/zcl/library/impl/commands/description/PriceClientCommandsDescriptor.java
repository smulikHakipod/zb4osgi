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
public class PriceClientCommandsDescriptor {
	// PUBLISH_PRICE
	public static int PROVIDER_ID_INDEX = 0;
	public static int RATE_LABEL_INDEX = 1;
	public static int ISSUER_EVENT_ID_INDEX = 2;
	public static int CURRENT_TIME_INDEX = 3;
	public static int UNIT_OF_MEASURE_INDEX = 4;
	public static int CURRENCY_INDEX = 5;
	public static int PRICE_TRAILING_DIGIT_AND_PRICE_TIER_INDEX = 6;
	public static int NUMBER_OF_PRICE_TIERS_AND_REGISTER_TIER_INDEX = 7;
	public static int START_TIME_INDEX = 8;
	public static int DURATION_IN_MINUTES_INDEX = 9;
	public static int PRICE_INDEX = 10;
	public static int PRICE_RATIO_INDEX = 11;
	public static int GENERATION_PRICE_INDEX = 12;
	public static int GENERATION_PRICE_RATIO_INDEX = 13;
	public static int ALTERNATE_COST_DELIVERED_INDEX = 14;
	public static int ALTERNATE_COST_UNIT_INDEX = 15;
	public static int ALTERNATE_COST_TRAILING_DIGIT_INDEX = 16;
	public static int NUMBER_OF_BLOCK_THRESHOLDS_INDEX = 17;
	public static int PRICE_CONTROL_INDEX = 18;

	// PUBLISH_BLOCK_PERIOD
	public static int PUBLISH_BLOCK_PERIOD_PROVIDER_ID_INDEX = 0;
	public static int PUBLISH_BLOCK_PERIOD_ISSUER_EVENT_ID_INDEX = 1;
	public static int BLOCK_PERIOD_START_TIME_INDEX = 2;
	public static int BLOCK_PERIOD_DURATION_IN_MINUTES_INDEX = 3;
	public static int NUMBER_OF_PRICE_TIERS_AND_NUMBER_OF_BLOCK_THRESHOLD_INDEX = 4;
	public static int BLOCK_PERIOD_CONTROL_INDEX = 5;

	public static CommandDescription PUBLISH_BLOCK_PERIOD = new CommandDescription(
			Price.PUBLISH_BLOCK_PERIOD_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									PUBLISH_BLOCK_PERIOD_PROVIDER_ID_INDEX)
							.setName("Publish block period provider")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									PUBLISH_BLOCK_PERIOD_ISSUER_EVENT_ID_INDEX)
							.setName("Publish block period issuer event id")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(BLOCK_PERIOD_START_TIME_INDEX)
							.setName("Block period start time")
							.setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									BLOCK_PERIOD_DURATION_IN_MINUTES_INDEX)
							.setName("Block period duration in minutes")
							.setZigBeeType(ZigBeeType.UnsignedInteger24bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									NUMBER_OF_PRICE_TIERS_AND_NUMBER_OF_BLOCK_THRESHOLD_INDEX)
							.setName(
									"Number of price tiers and number of block threshold")
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(BLOCK_PERIOD_CONTROL_INDEX)
							.setName("Block period control")
							.setZigBeeType(ZigBeeType.Bitmap8bit))

	;

	public static CommandDescription PUBLISH_PRICE = new CommandDescription(
			Price.PUBLISH_PRICE_ID)
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(PROVIDER_ID_INDEX)
							.setName("Provider ID")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor().setFieldIndex(RATE_LABEL_INDEX)
							.setName("Rate Label")
							.setZigBeeType(ZigBeeType.OctectString))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ISSUER_EVENT_ID_INDEX)
							.setName("Issuer Event ID")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(CURRENT_TIME_INDEX)
							.setName("Current Time")
							.setZigBeeType(ZigBeeType.UTCTime))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(UNIT_OF_MEASURE_INDEX)
							.setName("Unit Of Measure")
							.setZigBeeType(ZigBeeType.Enumeration8bit))
			.addField(
					new SimpleFieldDescriptor().setFieldIndex(CURRENCY_INDEX)
							.setName("Currency")
							.setZigBeeType(ZigBeeType.UnsignedInteger16bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									PRICE_TRAILING_DIGIT_AND_PRICE_TIER_INDEX)
							.setName("Price Trailing Digit And Price Tier")
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(
									NUMBER_OF_PRICE_TIERS_AND_REGISTER_TIER_INDEX)
							.setName("Number Of Price Tiers And Register Tier")
							.setZigBeeType(ZigBeeType.Bitmap8bit))
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
					new SimpleFieldDescriptor().setFieldIndex(PRICE_INDEX)
							.setName("Price")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(PRICE_RATIO_INDEX)
							.setName("Price Ratio")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(GENERATION_PRICE_INDEX)
							.setName("Generation Price")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(GENERATION_PRICE_RATIO_INDEX)
							.setName("Generation Price Ratio")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ALTERNATE_COST_DELIVERED_INDEX)
							.setName("Alternate Cost Delivered")
							.setZigBeeType(ZigBeeType.UnsignedInteger32bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ALTERNATE_COST_UNIT_INDEX)
							.setName("Alternate Cost Unit")
							.setZigBeeType(ZigBeeType.Enumeration8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(ALTERNATE_COST_TRAILING_DIGIT_INDEX)
							.setName("Alternate Cost Trailing Digit")
							.setZigBeeType(ZigBeeType.Bitmap8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(NUMBER_OF_BLOCK_THRESHOLDS_INDEX)
							.setName("Number Of Block Thresholds")
							.setZigBeeType(ZigBeeType.UnsignedInteger8bit))
			.addField(
					new SimpleFieldDescriptor()
							.setFieldIndex(PRICE_CONTROL_INDEX)
							.setName("Price Control")
							.setZigBeeType(ZigBeeType.Bitmap8bit));

}
