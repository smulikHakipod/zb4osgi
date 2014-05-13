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

package it.cnr.isti.zigbee.se.zcl.library.impl.attribute;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AbstractAttribute;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AttributeDescriptor;
/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48 +0100 (gio, 30 gen 2014) $)
 */
public class AttributesMetering  {    

	public static final AttributeDescriptor CURRENT_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0000)
    .setName("CurrentSummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0001)
    .setName("CurrentSummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_MAX_DEMAND_DELIVERED = new AbstractAttribute()
    .setId(0x0002)
    .setName("CurrentMaxDemandDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	
	public static final AttributeDescriptor CURRENT_MAX_DEMAND_RECEIVED = new AbstractAttribute()
    .setId(0x0003)
    .setName("CurrentMaxDemandReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	

	public static final AttributeDescriptor DFT_SUMMATION = new AbstractAttribute()
    .setId(0x0004)
    .setName("DTF_Summation")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor DAILY_FREEZE_TIME = new AbstractAttribute()
    .setId(0x0005)
    .setName("DailyFreezeTime")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);
	
	public static final AttributeDescriptor POWER_FACTOR = new AbstractAttribute()
    .setId(0x0006)
    .setName("PowerFactor")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger8bit)
    .setWritable(false);
	
	public static final AttributeDescriptor READING_SNAP_SHOT_TIME = new AbstractAttribute()
    .setId(0x0007)
    .setName("ReadingSnapShotTime")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UTCTime)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_MAX_DEMAND_DELIVERED_TIME = new AbstractAttribute()
    .setId(0x0008)
    .setName("CurrentMaxDemandDeliveredTime")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UTCTime)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_MAX_DEMAND_RECEIVED_TIME = new AbstractAttribute()
    .setId(0x0009)
    .setName("CurrentMaxDemandReceivedTime")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UTCTime)
    .setWritable(false);

	
	public static final AttributeDescriptor DEFAULT_UPDATE_PERIOD = new AbstractAttribute()
    .setId(0x000A)
    .setName("DefaultUpdatePeriod")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor FAST_POLL_UPDATE_PERIOD = new AbstractAttribute()
    .setId(0x000B)
    .setName("FastPollUpdatePeriod")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);



	public static final AttributeDescriptor CURRENT_BLOCK_PERIOD_CONSUMPTION_DELIVERED = new AbstractAttribute()
    .setId(0x000C)
    .setName("CurrentBlockPeriodConsumptionDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor DAILY_CONSUMPTION_TARGET = new AbstractAttribute()
    .setId(0x000D)
    .setName("DailyConsumptionTarget")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	
	
	public static final AttributeDescriptor CURRENT_BLOCK = new AbstractAttribute()
    .setId(0x000E)
    .setName("CurrentBlock")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Enumeration8bit)
    .setWritable(false);

	public static final AttributeDescriptor PROFILE_INTERVAL_PERIOD = new AbstractAttribute()
    .setId(0x000F)
    .setName("ProfileIntervalPeriod")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Enumeration8bit)
    .setWritable(false);

	public static final AttributeDescriptor INTERVAL_READ_REPORTING_PERIOD = new AbstractAttribute()
    .setId(0x0010)
    .setName("IntervalReadReportingPeriod")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);

	public static final AttributeDescriptor PRESET_READING_TIME = new AbstractAttribute()
    .setId(0x0011)
    .setName("PresetReadingTime")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);

	public static final AttributeDescriptor VOLUME_PER_REPORT = new AbstractAttribute()
    .setId(0x0012)
    .setName("VolumePerReport")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
    .setWritable(false);

	public static final AttributeDescriptor FLOW_RESTRICTION = new AbstractAttribute()
    .setId(0x0013)
    .setName("FlowRestriction")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);

	public static final AttributeDescriptor SUPPLY_STATUS = new AbstractAttribute()
    .setId(0x0014)
    .setName("SupplyStatus")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_INLET_ENERGY_CARRIER_SUMMATION = new AbstractAttribute()
    .setId(0x00015)
    .setName("CurrentInletEnergyCarrierSummation")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);


	public static final AttributeDescriptor CURRENT_OUTLET_ENERGY_CARRIER_SUMMATION = new AbstractAttribute()
    .setId(0x00016)
    .setName("CurrentOutletEnergyCarrierSummation")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor INLET_TEMPERATURE = new AbstractAttribute()
    .setId(0x0017)
    .setName("InletTemperature")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger16bit)
    .setWritable(false);

	public static final AttributeDescriptor OUTLET_TEMPERATURE = new AbstractAttribute()
    .setId(0x0018)
    .setName("OutletTemperature")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger16bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CONTROL_TEMPERATURE = new AbstractAttribute()
    .setId(0x0019)
    .setName("ControlTemperature")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger16bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_INLET_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x001A)
    .setName("CurrentInletEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_OUTLET_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x001B)
    .setName("CurrentOutletEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0000)
    .setName("CurrentTier1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_1_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0001)
.setName("CurrentTier1SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	
	public static final AttributeDescriptor CURRENT_TIER_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0002)
.setName("CurrentTier2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_2_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0003)
.setName("CurrentTier2SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	
	public static final AttributeDescriptor CURRENT_TIER_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0004)
    .setName("CurrentTier3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_3_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0005)
    .setName("CurrentTier1SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	
	public static final AttributeDescriptor CURRENT_TIER_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0006)
    .setName("CurrentTier4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_4_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0007)
    .setName("CurrentTier4SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0008)
    .setName("CurrentTier5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_5_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0009)
    .setName("CurrentTier5SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000A)
    .setName("CurrentTier6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_6_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x000B)
    .setName("CurrentTier6SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000C)
    .setName("CurrentTier7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_7_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x000D)
    .setName("CurrentTier7SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000E)
    .setName("CurrentTier8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_8_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x000F)
    .setName("CurrentTier8SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0010)
    .setName("CurrentTier9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_9_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0011)
    .setName("CurrentTier9SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0012)
    .setName("CurrentTier10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_10_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0013)
    .setName("Current Tier 10 Summation Received")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0014)
    .setName("CurrentTier11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_11_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0015)
    .setName("CurrentTier11SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0016)
    .setName("CurrentTier12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_12_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0017)
    .setName("CurrentTier12SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0018)
    .setName("CurrentTier13SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_13_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x0019)
    .setName("CurrentTier13SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001A)
    .setName("CurrentTier14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_14_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x001B)
    .setName("CurrentTier14SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	public static final AttributeDescriptor CURRENT_TIER_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001C)
    .setName("CurrentTier15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_TIER_15_SUMMATION_RECEIVED = new AbstractAttribute()
    .setId(0x001D)
    .setName("CurrentTier15SummationReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//meter status
	public static final AttributeDescriptor STATUS = new AbstractAttribute()
    .setId(0x0000)
    .setName("Status")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor REMAINING_BATTERY_LIFE = new AbstractAttribute()
    .setId(0x0001)
    .setName("RemainingBatteryLife")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
	public static final AttributeDescriptor HOURS_IN_OPERATION = new AbstractAttribute()
    .setId(0x0002)
    .setName("HoursInOperation")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor HOURS_IN_FAULT = new AbstractAttribute()
    .setId(0x0003)
    .setName("HoursInFault")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	//formatting
	public static final AttributeDescriptor UNIT_OF_MEASURE = new AbstractAttribute()
    .setId(0x0000)
    .setName("UnitOfMeasure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor MULTIPLIER = new AbstractAttribute()
    .setId(0x0001)
    .setName("Multiplier")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor DIVISOR = new AbstractAttribute()
    .setId(0x0002)
    .setName("Divisor")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor SUMMATION_FORMATTING = new AbstractAttribute()
    .setId(0x0003)
    .setName("SummationFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor DEMAND_FORMATTING = new AbstractAttribute()
    .setId(0x0004)
    .setName("DemandFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor HISTORICAL_CONSUMPTION_FORMATTING = new AbstractAttribute()
    .setId(0x0005)
    .setName("HistoricalConsumptionFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor METERING_DEVICE_TYPE = new AbstractAttribute()
    .setId(0x0006)
    .setName("MeteringDeviceType")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor SITE_ID = new AbstractAttribute()
    .setId(0x0007)
    .setName("SiteId")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor METER_SERIAL_NUMBER = new AbstractAttribute()
    .setId(0x0008)
    .setName("MeterSerialNumber")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor ENERGY_CARRIER_UNIT_OF_MEASURE = new AbstractAttribute()
    .setId(0x0009)
    .setName("EnergyCarrierUnitOfMeasure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor ENERGY_CARRIER_SUMMATION_FORMATTING = new AbstractAttribute()
    .setId(0x000A)
    .setName("EnergyCarrierSummationFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor ENERGY_CARRIER_DEMAND_FORMATTING = new AbstractAttribute()
    .setId(0x000B)
    .setName("EnergyCarrierDemandFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor TEMPERATURE_UNIT_OF_MEASURE = new AbstractAttribute()
    .setId(0x000C)
    .setName("TemperatureUnitOfMeasure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	public static final AttributeDescriptor TEMPERATURE_FORMATTING = new AbstractAttribute()
    .setId(0x000D)
    .setName("TemperatureFormatting")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap8bit)
    .setWritable(false);
	
	//historical
	

	
	
	public static final AttributeDescriptor INSTANTANEOUS_DEMAND = new AbstractAttribute()
    .setId(0x0000)
    .setName("InstantaneousDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_DAY_CONSUMPTION_DELIVERED = new AbstractAttribute()
    .setId(0x0001)
    .setName("CurrentDayConsumptionDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_DAY_CONSUMPTION_RECEIVED = new AbstractAttribute()
    .setId(0x0002)
    .setName("CurrentDayConsumptionReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor PREVIOUS_DAY_CONSUMPTION_DELIVERED = new AbstractAttribute()
    .setId(0x0003)
    .setName("PreviousDayConsumptionDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor PREVIOUS_DAY_CONSUMPTION_RECEIVED = new AbstractAttribute()
    .setId(0x0004)
    .setName("PreviousDayConsumptionReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_PARTIAL_PROFILE_INTERVAL_START_TIME_DELIVERED = new AbstractAttribute()
    .setId(0x0005)
    .setName("CurrentPartialProfileIntervalStartTimeDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UTCTime)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_PARTIAL_PROFILE_INTERVAL_START_TIME_RECEIVED = new AbstractAttribute()
    .setId(0x0006)
    .setName("CurrentPartialProfileIntervalStartTimeReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UTCTime)
    .setWritable(false);
	
	
	public static final AttributeDescriptor CURRENT_PARTIAL_PROFILE_INTERVAL_VALUE_DELIVERED = new AbstractAttribute()
    .setId(0x0007)
    .setName("CurrentPartialProfileIntervalCalueDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor CURRENT_PARTIAL_PROFILE_INTERVAL_VALUE_RECEIVED = new AbstractAttribute()
    .setId(0x0008)
    .setName("CurrentPartialProfileIntervalValueReceived")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor CURRENT_DAY_MAX_PRESSURE = new AbstractAttribute()
    .setId(0x0009)
    .setName("CurrentDayMaxPressure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	


	
	
	public static final AttributeDescriptor CURRENT_DAY_MIN_PRESSURE = new AbstractAttribute()
    .setId(0x000A)
    .setName("CurrentDayMinPressure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor PREVIOUS_DAY_MAX_PRESSURE = new AbstractAttribute()
    .setId(0x000B)
    .setName("PreviousDayMaxPressure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor PREVIOUS_DAY_MIN_PRESSURE = new AbstractAttribute()
    .setId(0x000C)
    .setName("PreviousDayMinPressure")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	
	public static final AttributeDescriptor CURRENT_DAY_MAX_DEMAND = new AbstractAttribute()
    .setId(0x000D)
    .setName("CurrentDayMaxDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor PREVIOUS_DAY_MAX_DEMAND = new AbstractAttribute()
    .setId(0x000E)
    .setName("PreviousDayMaxDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_MONTH_MAX_DEMAND = new AbstractAttribute()
    .setId(0x000F)
    .setName("CurrentMonthMaxDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	
	public static final AttributeDescriptor CURRENT_YEAR_MAX_DEMAND = new AbstractAttribute()
    .setId(0x0010)
    .setName("CurrentYearMaxDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_DAY_MAX_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0011)
    .setName("CurrentDayMaxEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor PREVIOUS_DAY_MAX_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0012)
    .setName("PreviousDayMaxEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_MONTH_MAX_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0013)
    .setName("CurrentMonthMaxEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_MONTH_MIN_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0014)
    .setName("CurrentMonthMinEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_YEAR_MAX_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0015)
    .setName("CurrentYearMaxEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_YEAR_MIN_ENERGY_CARRIER_DEMAND = new AbstractAttribute()
    .setId(0x0016)
    .setName("CurrentYearMinEnergyCarrierDemand")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(false);	
//loadprofile
	public static final AttributeDescriptor MAX_NUMBER_OF_PERIODS_DELIVERED = new AbstractAttribute()
    .setId(0x0000)
    .setName("MaxNumberOfPeriodsDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
//supply limit	
	public static final AttributeDescriptor CURRENT_DEMAND_DELIVERED = new AbstractAttribute()
    .setId(0x0000)
    .setName("CurrentDemandDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor DEMAND_LIMIT = new AbstractAttribute()
    .setId(0x0001)
    .setName("DemandLimit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(false);
	public static final AttributeDescriptor DEMAND_INTEGRATION_PERIOD = new AbstractAttribute()
    .setId(0x0002)
    .setName("DemandIntegrationPeriod")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
	public static final AttributeDescriptor NUMBER_OF_DEMAND_AND_SUBINTERVALS = new AbstractAttribute()
    .setId(0x0003)
    .setName("NumberOfDemandAndSubintervals")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
    .setWritable(false);
	
	
	//alarm
		public static final AttributeDescriptor GENERIC_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("genericAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap16bit)
    .setWritable(true);
	public static final AttributeDescriptor ELECTRICITY_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("electricityAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap32bit)
    .setWritable(true);
	public static final AttributeDescriptor GENERIC_FLOW_PRESSURE_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("genericFlowPressureAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap16bit)
    .setWritable(true);
	public static final AttributeDescriptor WATER_SPECIFIC_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("waterSpecificAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap16bit)
    .setWritable(true);
	public static final AttributeDescriptor HEAT_AND_COOLING_SPECIFIC_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("heatAndCoolingSpecificAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap16bit)
    .setWritable(true);
	public static final AttributeDescriptor GAS_SPECIFIC_ALARM_MASK = new AbstractAttribute()
    .setId(0x0003)
    .setName("gasSpecificAlarmMask")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Bitmap16bit)
    .setWritable(true);
	
	
    //block 
	//no tier
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0000)
    .setName("CurrentNoTierBlock1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0001)
    .setName("CurrentNoTierBlock2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0002)
    .setName("CurrentNoTierBlock3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0003)
    .setName("CurrentNoTierBlock4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0004)
    .setName("CurrentNoTierBlock5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0005)
    .setName("CurrentNoTierBlock6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0006)
    .setName("CurrentNoTierBlock7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0007)
    .setName("CurrentNoTierBlock8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0008)
    .setName("CurrentNoTierBlock9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0009)
    .setName("CurrentNoTierBlock10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000A)
    .setName("CurrentNoTierBlock11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000B)
    .setName("CurrentNoTierBlock12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000C)
    .setName("CurrentNoTierBlock13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000D)
    .setName("CurrentNoTierBlock14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000E)
    .setName("CurrentNoTierBlock15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_NO_TIER_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x000F)
    .setName("CurrentNoTierBlock16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	
		//tier 1
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0010)
    .setName("CurrentTier1Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0011)
    .setName("CurrentTier1Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0012)
    .setName("CurrentTier1Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0013)
    .setName("CurrentTier1Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0014)
    .setName("CurrentTier1Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0015)
    .setName("CurrentTier1Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0016)
    .setName("CurrentTier1Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0017)
    .setName("CurrentTier1Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0018)
    .setName("CurrentTier1Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0019)
    .setName("CurrentTier1Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001A)
    .setName("CurrentTier1Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001B)
    .setName("CurrentTier1Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001C)
    .setName("CurrentTier1Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001D)
    .setName("CurrentTier1Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001E)
    .setName("CurrentTier1Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_1_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x001F)
    .setName("CurrentTier1Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	//Tier 2
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0020)
    .setName("CurrentTier2Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0021)
    .setName("CurrentTier2Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0022)
    .setName("CurrentTier2Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0023)
    .setName("CurrentTier2Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0024)
    .setName("CurrentTier2Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0025)
    .setName("CurrentTier2Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0026)
    .setName("CurrentTier2Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0027)
    .setName("CurrentTier2Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0028)
    .setName("CurrentTier2Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0029)
    .setName("CurrentTier2Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002A)
    .setName("CurrentTier2Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002B)
    .setName("CurrentTier2Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002C)
    .setName("CurrentTier2Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002D)
    .setName("CurrentTier2Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002E)
    .setName("CurrentTier2Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_2_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x002F)
    .setName("CurrentTier2Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);

	//tier 3
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0030)
    .setName("CurrentTier3Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0031)
    .setName("CurrentTier3Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0032)
    .setName("CurrentTier3Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0033)
    .setName("CurrentTier3Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0034)
    .setName("CurrentTier3Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0035)
    .setName("CurrentTier3Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0036)
    .setName("CurrentTier3Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0037)
    .setName("CurrentTier3Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0038)
    .setName("CurrentTier3Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0039)
    .setName("CurrentTier3Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003A)
    .setName("CurrentTier3Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003B)
    .setName("CurrentTier3Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003C)
    .setName("CurrentTier3Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003D)
    .setName("CurrentTier3Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003E)
    .setName("CurrentTier3Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_3_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x003F)
    .setName("CurrentTier3Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 4
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0040)
    .setName("CurrentTier4Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0041)
    .setName("CurrentTier4Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0042)
    .setName("CurrentTier4Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0043)
    .setName("CurrentTier4Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0044)
    .setName("CurrentTier4Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0045)
    .setName("CurrentTier4Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0046)
    .setName("CurrentTier4Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0047)
    .setName("CurrentTier4Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0048)
    .setName("CurrentTier4Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0049)
    .setName("CurrentTier4Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004A)
    .setName("CurrentTier4Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004B)
    .setName("CurrentTier4Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004C)
    .setName("CurrentTier4Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004D)
    .setName("CurrentTier4Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004E)
    .setName("CurrentTier4Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_4_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x004F)
    .setName("CurrentTier4Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 5
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0050)
    .setName("CurrentTier5Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0051)
    .setName("CurrentTier5Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0052)
    .setName("CurrentTier5Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0053)
    .setName("CurrentTier5Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0054)
    .setName("CurrentTier5Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0055)
    .setName("CurrentTier5Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0056)
    .setName("CurrentTier5Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0057)
    .setName("CurrentTier5Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0058)
    .setName("CurrentTier5Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0059)
    .setName("CurrentTier5Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005A)
    .setName("CurrentTier5Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005B)
    .setName("CurrentTier5Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005C)
    .setName("CurrentTier5Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005D)
    .setName("CurrentTier5Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005E)
    .setName("CurrentTier5Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_5_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x005F)
    .setName("CurrentTier5Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 6
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0060)
    .setName("CurrentTier6Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0061)
    .setName("CurrentTier6Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0062)
    .setName("CurrentTier6Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0063)
    .setName("CurrentTier6Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0064)
    .setName("CurrentTier6Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0065)
    .setName("CurrentTier6Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0066)
    .setName("CurrentTier6Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0067)
    .setName("CurrentTier6Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0068)
    .setName("CurrentTier6Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0069)
    .setName("CurrentTier6Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006A)
    .setName("CurrentTier6Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006B)
    .setName("CurrentTier6Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006C)
    .setName("CurrentTier6Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006D)
    .setName("CurrentTier6Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006E)
    .setName("CurrentTier6Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_6_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x006F)
    .setName("CurrentTier6Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 7
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0070)
    .setName("CurrentTier7Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0071)
    .setName("CurrentTier7Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0072)
    .setName("CurrentTier7Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0073)
    .setName("CurrentTier7Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0074)
    .setName("CurrentTier7Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0075)
    .setName("CurrentTier7Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0076)
    .setName("CurrentTier7Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0077)
    .setName("CurrentTier7Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0078)
    .setName("CurrentTier7Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0079)
    .setName("CurrentTier7Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007A)
    .setName("CurrentTier7Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007B)
    .setName("CurrentTier7Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007C)
    .setName("CurrentTier7Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007D)
    .setName("CurrentTier7Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007E)
    .setName("CurrentTier7Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_7_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x007F)
    .setName("CurrentTier7Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 8
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0080)
    .setName("CurrentTier8Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0081)
    .setName("CurrentTier8Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0082)
    .setName("CurrentTier8Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0083)
    .setName("CurrentTier8Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0084)
    .setName("CurrentTier8Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0085)
    .setName("CurrentTier8Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0086)
    .setName("CurrentTier8Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0087)
    .setName("CurrentTier8Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0088)
    .setName("CurrentTier8Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0089)
    .setName("CurrentTier8Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008A)
    .setName("CurrentTier8Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008B)
    .setName("CurrentTier8Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008C)
    .setName("CurrentTier8Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008D)
    .setName("CurrentTier8Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008E)
    .setName("CurrentTier8Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_8_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x008F)
    .setName("CurrentTier8Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 9
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0090)
    .setName("CurrentTier9Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0091)
    .setName("CurrentTier9Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0092)
    .setName("CurrentTier9Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0093)
    .setName("CurrentTier9Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0094)
    .setName("CurrentTier9Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0095)
    .setName("CurrentTier9Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0096)
    .setName("CurrentTier9Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0097)
    .setName("CurrentTier9Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0098)
    .setName("CurrentTier9Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x0099)
    .setName("CurrentTier9Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009A)
    .setName("CurrentTier9Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009B)
    .setName("CurrentTier9Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009C)
    .setName("CurrentTier9Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009D)
    .setName("CurrentTier9Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009E)
    .setName("CurrentTier9Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_9_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x009F)
    .setName("CurrentTier9Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 10
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A0)
    .setName("CurrentTier10Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A1)
    .setName("CurrentTier10Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A2)
    .setName("CurrentTier10Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A3)
    .setName("CurrentTier10Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A4)
    .setName("CurrentTier10Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A5)
    .setName("CurrentTier10Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A6)
    .setName("CurrentTier10Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A7)
    .setName("CurrentTier10Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A8)
    .setName("CurrentTier10Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00A9)
    .setName("CurrentTier10Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AA)
    .setName("CurrentTier10Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AB)
    .setName("CurrentTier10Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AC)
    .setName("CurrentTier10Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AD)
    .setName("CurrentTier10Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AE)
    .setName("CurrentTier10Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_10_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00AF)
    .setName("CurrentTier10Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 11
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B0)
    .setName("CurrentTier11Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B1)
    .setName("CurrentTier11Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B2)
    .setName("CurrentTier11Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B3)
    .setName("CurrentTier11Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B4)
    .setName("CurrentTier11Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B5)
    .setName("CurrentTier11Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B6)
    .setName("CurrentTier11Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B7)
    .setName("CurrentTier11Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B8)
    .setName("CurrentTier11Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00B9)
    .setName("CurrentTier11Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BA)
    .setName("CurrentTier11Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BB)
    .setName("CurrentTier11Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BC)
    .setName("CurrentTier11Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BD)
    .setName("CurrentTier11Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BE)
    .setName("CurrentTier11Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_11_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00BF)
    .setName("CurrentTier11Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 12
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C0)
    .setName("CurrentTier12Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C1)
    .setName("CurrentTier12Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C2)
    .setName("CurrentTier12Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C3)
    .setName("CurrentTier12Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C4)
    .setName("CurrentTier12Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C5)
    .setName("CurrentTier12Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C6)
    .setName("CurrentTier12Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C7)
    .setName("CurrentTier12Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C8)
    .setName("CurrentTier12Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00C9)
    .setName("CurrentTier12Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CA)
    .setName("CurrentTier12Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CB)
    .setName("CurrentTier12Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CC)
    .setName("CurrentTier12Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CD)
    .setName("CurrentTier12Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CE)
    .setName("CurrentTier12Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_12_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00CF)
    .setName("CurrentTier12Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	
	//tier 13
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D0)
    .setName("CurrentTier13Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D1)
    .setName("CurrentTier13Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D2)
    .setName("CurrentTier13Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D3)
    .setName("CurrentTier13Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D4)
    .setName("CurrentTier13Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D5)
    .setName("CurrentTier13Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D6)
    .setName("CurrentTier13Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D7)
    .setName("CurrentTier13Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D8)
    .setName("CurrentTier13Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00D9)
    .setName("CurrentTier13Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DA)
    .setName("CurrentTier13Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DB)
    .setName("CurrentTier13Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DC)
    .setName("CurrentTier13Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DD)
    .setName("CurrentTier13Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DE)
    .setName("CurrentTier13Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_13_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00DF)
    .setName("CurrentTier13Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 14
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E0)
    .setName("CurrentTier14Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E1)
    .setName("CurrentTier14Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E2)
    .setName("CurrentTier14Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E3)
    .setName("CurrentTier14Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E4)
    .setName("CurrentTier14Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E5)
    .setName("CurrentTier14Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E6)
    .setName("CurrentTier14Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E7)
    .setName("CurrentTier14Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E8)
    .setName("CurrentTier14Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00E9)
    .setName("CurrentTier14Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00EA)
    .setName("CurrentTier14Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00EB)
    .setName("CurrentTier14Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00EC)
    .setName("CurrentTier14Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00ED)
    .setName("CurrentTier14Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00EE)
    .setName("CurrentTier14Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_14_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00EF)
    .setName("CurrentTier14Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
	//tier 15
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_1_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F0)
    .setName("CurrentTier15Block1SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_2_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F1)
    .setName("CurrentTier15Block2SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_3_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F2)
    .setName("CurrentTier15Block3SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_4_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F3)
    .setName("CurrentTier15Block4SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_5_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F4)
    .setName("CurrentTier15Block5SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_6_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F5)
    .setName("CurrentTier15Block6SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_7_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F6)
    .setName("CurrentTier15Block7SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_8_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F7)
    .setName("CurrentTier15Block8SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_9_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F8)
    .setName("CurrentTier15Block9SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_10_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00F9)
    .setName("CurrentTier15Block10SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_11_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FA)
    .setName("CurrentTier15Block11SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_12_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FB)
    .setName("CurrentTier15Block12SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_13_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FC)
    .setName("CurrentTier15Block13SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_14_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FD)
    .setName("CurrentTier15Block14SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_15_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FE)
    .setName("CurrentTier15Block15SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	public static final AttributeDescriptor CURRENT_TIER_15_BLOCK_16_SUMMATION_DELIVERED = new AbstractAttribute()
    .setId(0x00FF)
    .setName("CurrentTier15Block16SummationDelivered")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(false);
	
}
