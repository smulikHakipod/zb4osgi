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

package it.cnr.isti.zigbee.se.zcl.library.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.se.zcl.library.api.Metering;
import it.cnr.isti.zigbee.se.zcl.library.impl.attribute.AttributesMetering;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 * This class represent the <b>Metering</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public class MeteringCluster extends ZCLClusterBase implements Metering {

	private final AttributeImpl currentSummationDelivered;
	private final AttributeImpl currentSummationReceived;
	private final AttributeImpl currentMaxDemandReceived;
	private final AttributeImpl currentMaxDemandDelivered;
	private final AttributeImpl dFTSummation;
	private final AttributeImpl dailyFreezeTime;
	private final AttributeImpl powerFactor;
	private final AttributeImpl readingSnapShotTime;
	private final AttributeImpl currentMaxDemandDeliveredTime;
	private final AttributeImpl currentMaxDemandReceivedTime;
	private final AttributeImpl defaultUpdatePeriod;
	private final AttributeImpl fastPollUpdatePeriod;
	private final AttributeImpl currentBlockPeriodConsumptionDelivered;
	private final AttributeImpl dailyConsumptionTarget;
	private final AttributeImpl currentBlock;
	private final AttributeImpl profileIntervalPeriod;
	private final AttributeImpl intervalReadReportingPeriod;
	private final AttributeImpl presetReadingTime;
	private final AttributeImpl volumePerReport;
	private final AttributeImpl supplyStatus;
	private final AttributeImpl flowRestriction;
	private final AttributeImpl currentInletEnergyCarrierSummation;
	private final AttributeImpl currentOutletEnergyCarrierSummation;
	private final AttributeImpl inletTemperature;
	private final AttributeImpl outletTemperature;
	private final AttributeImpl controlTemperature;
	private final AttributeImpl currentInletEnergyCarrierDemand;
	private final AttributeImpl currentOutletEnergyCarrierDemand;
	// TOU information
	private final AttributeImpl currentTier1SummationDelivered;
	private final AttributeImpl currentTier1SummationReceived;
	private final AttributeImpl currentTier2SummationDelivered;
	private final AttributeImpl currentTier2SummationReceived;
	private final AttributeImpl currentTier3SummationDelivered;
	private final AttributeImpl currentTier3SummationReceived;
	private final AttributeImpl currentTier4SummationDelivered;
	private final AttributeImpl currentTier4SummationReceived;
	private final AttributeImpl currentTier5SummationDelivered;
	private final AttributeImpl currentTier5SummationReceived;
	private final AttributeImpl currentTier6SummationDelivered;
	private final AttributeImpl currentTier6SummationReceived;
	private final AttributeImpl currentTier7SummationDelivered;
	private final AttributeImpl currentTier7SummationReceived;
	private final AttributeImpl currentTier8SummationDelivered;
	private final AttributeImpl currentTier8SummationReceived;
	private final AttributeImpl currentTier9SummationDelivered;
	private final AttributeImpl currentTier9SummationReceived;
	private final AttributeImpl currentTier10SummationDelivered;
	private final AttributeImpl currentTier10SummationReceived;
	private final AttributeImpl currentTier11SummationDelivered;
	private final AttributeImpl currentTier11SummationReceived;
	private final AttributeImpl currentTier12SummationDelivered;
	private final AttributeImpl currentTier12SummationReceived;
	private final AttributeImpl currentTier13SummationDelivered;
	private final AttributeImpl currentTier13SummationReceived;
	private final AttributeImpl currentTier14SummationDelivered;
	private final AttributeImpl currentTier14SummationReceived;
	private final AttributeImpl currentTier15SummationDelivered;
	private final AttributeImpl currentTier15SummationReceived;
	// meter status
	private final AttributeImpl status;
	private final AttributeImpl remainingBatteryLife;
	private final AttributeImpl hoursInOperation;
	private final AttributeImpl hoursInFault;
	// formatting
	private final AttributeImpl unitOfMeasure;
	private final AttributeImpl multiplier;
	private final AttributeImpl divisor;
	private final AttributeImpl summationFormatting;
	private final AttributeImpl demandFormatting;
	private final AttributeImpl historicalConsumptionFormatting;
	private final AttributeImpl meteringDeviceType;
	private final AttributeImpl siteID;
	private final AttributeImpl meterSerialNumber;
	private final AttributeImpl energyCarrierUnitOfMeasure;
	private final AttributeImpl energyCarrierSummationFormatting;
	private final AttributeImpl energyCarrierDemandFormatting;
	private final AttributeImpl temperatureUnitOfMeasure;
	private final AttributeImpl temperatureFormatting;
	// historical
	private final AttributeImpl instantaneousDemand;
	private final AttributeImpl currentDayConsumptionDelivered;
	private final AttributeImpl currentDayConsumptionReceived;
	private final AttributeImpl previousDayConsumptionDelivered;
	private final AttributeImpl previousDayConsumptionReceived;
	private final AttributeImpl currentPartialProfileIntervalStartTimeDelivered;
	private final AttributeImpl currentPartialProfileIntervalStartTimeReceived;
	private final AttributeImpl currentPartialProfileIntervalValueDelivered;
	private final AttributeImpl currentPartialProfileIntervalValueReceived;
	private final AttributeImpl currentDayMaxPressure;
	private final AttributeImpl currentDayMinPressure;
	private final AttributeImpl previousDayMaxPressure;
	private final AttributeImpl previousDayMinPressure;
	private final AttributeImpl currentDayMaxDemand;
	private final AttributeImpl previousDayMaxDemand;
	private final AttributeImpl currentMonthMaxDemand;
	private final AttributeImpl currentYearMaxDemand;
	private final AttributeImpl currentDayMaxEnergyCarrierDemand;
	private final AttributeImpl previousDayMaxEnergyCarrierDemand;
	private final AttributeImpl currentMonthMaxEnergyCarrierDemand;
	private final AttributeImpl currentMonthMinEnergyCarrierDemand;
	private final AttributeImpl currentYearMaxEnergyCarrierDemand;
	private final AttributeImpl currentYearMinEnergyCarrierDemand;
	// loadprofile
	private final AttributeImpl maxNumberOfPeriodsDelivered;
	// supply limit
	private final AttributeImpl currentDemandDelivered;
	private final AttributeImpl demandLimit;
	private final AttributeImpl demandIntegrationPeriod;
	private final AttributeImpl numberOfDemandAndSubintervals;
	// block information
	// no tier
	private final AttributeImpl currentNoTierBlock1SummationDelivered;
	private final AttributeImpl currentNoTierBlock2SummationDelivered;
	private final AttributeImpl currentNoTierBlock3SummationDelivered;
	private final AttributeImpl currentNoTierBlock4SummationDelivered;
	private final AttributeImpl currentNoTierBlock5SummationDelivered;
	private final AttributeImpl currentNoTierBlock6SummationDelivered;
	private final AttributeImpl currentNoTierBlock7SummationDelivered;
	private final AttributeImpl currentNoTierBlock8SummationDelivered;
	private final AttributeImpl currentNoTierBlock9SummationDelivered;
	private final AttributeImpl currentNoTierBlock10SummationDelivered;
	private final AttributeImpl currentNoTierBlock11SummationDelivered;
	private final AttributeImpl currentNoTierBlock12SummationDelivered;
	private final AttributeImpl currentNoTierBlock13SummationDelivered;
	private final AttributeImpl currentNoTierBlock14SummationDelivered;
	private final AttributeImpl currentNoTierBlock15SummationDelivered;
	private final AttributeImpl currentNoTierBlock16SummationDelivered;
	// tier 1
	private final AttributeImpl currentTier1Block1SummationDelivered;
	private final AttributeImpl currentTier1Block2SummationDelivered;
	private final AttributeImpl currentTier1Block3SummationDelivered;
	private final AttributeImpl currentTier1Block4SummationDelivered;
	private final AttributeImpl currentTier1Block5SummationDelivered;
	private final AttributeImpl currentTier1Block6SummationDelivered;
	private final AttributeImpl currentTier1Block7SummationDelivered;
	private final AttributeImpl currentTier1Block8SummationDelivered;
	private final AttributeImpl currentTier1Block9SummationDelivered;
	private final AttributeImpl currentTier1Block10SummationDelivered;
	private final AttributeImpl currentTier1Block11SummationDelivered;
	private final AttributeImpl currentTier1Block12SummationDelivered;
	private final AttributeImpl currentTier1Block13SummationDelivered;
	private final AttributeImpl currentTier1Block14SummationDelivered;
	private final AttributeImpl currentTier1Block15SummationDelivered;
	private final AttributeImpl currentTier1Block16SummationDelivered;
	// tier 2
	private final AttributeImpl currentTier2Block1SummationDelivered;
	private final AttributeImpl currentTier2Block2SummationDelivered;
	private final AttributeImpl currentTier2Block3SummationDelivered;
	private final AttributeImpl currentTier2Block4SummationDelivered;
	private final AttributeImpl currentTier2Block5SummationDelivered;
	private final AttributeImpl currentTier2Block6SummationDelivered;
	private final AttributeImpl currentTier2Block7SummationDelivered;
	private final AttributeImpl currentTier2Block8SummationDelivered;
	private final AttributeImpl currentTier2Block9SummationDelivered;
	private final AttributeImpl currentTier2Block10SummationDelivered;
	private final AttributeImpl currentTier2Block11SummationDelivered;
	private final AttributeImpl currentTier2Block12SummationDelivered;
	private final AttributeImpl currentTier2Block13SummationDelivered;
	private final AttributeImpl currentTier2Block14SummationDelivered;
	private final AttributeImpl currentTier2Block15SummationDelivered;
	private final AttributeImpl currentTier2Block16SummationDelivered;
	// tier 3
	private final AttributeImpl currentTier3Block1SummationDelivered;
	private final AttributeImpl currentTier3Block2SummationDelivered;
	private final AttributeImpl currentTier3Block3SummationDelivered;
	private final AttributeImpl currentTier3Block4SummationDelivered;
	private final AttributeImpl currentTier3Block5SummationDelivered;
	private final AttributeImpl currentTier3Block6SummationDelivered;
	private final AttributeImpl currentTier3Block7SummationDelivered;
	private final AttributeImpl currentTier3Block8SummationDelivered;
	private final AttributeImpl currentTier3Block9SummationDelivered;
	private final AttributeImpl currentTier3Block10SummationDelivered;
	private final AttributeImpl currentTier3Block11SummationDelivered;
	private final AttributeImpl currentTier3Block12SummationDelivered;
	private final AttributeImpl currentTier3Block13SummationDelivered;
	private final AttributeImpl currentTier3Block14SummationDelivered;
	private final AttributeImpl currentTier3Block15SummationDelivered;
	private final AttributeImpl currentTier3Block16SummationDelivered;
	// tier 4
	private final AttributeImpl currentTier4Block1SummationDelivered;
	private final AttributeImpl currentTier4Block2SummationDelivered;
	private final AttributeImpl currentTier4Block3SummationDelivered;
	private final AttributeImpl currentTier4Block4SummationDelivered;
	private final AttributeImpl currentTier4Block5SummationDelivered;
	private final AttributeImpl currentTier4Block6SummationDelivered;
	private final AttributeImpl currentTier4Block7SummationDelivered;
	private final AttributeImpl currentTier4Block8SummationDelivered;
	private final AttributeImpl currentTier4Block9SummationDelivered;
	private final AttributeImpl currentTier4Block10SummationDelivered;
	private final AttributeImpl currentTier4Block11SummationDelivered;
	private final AttributeImpl currentTier4Block12SummationDelivered;
	private final AttributeImpl currentTier4Block13SummationDelivered;
	private final AttributeImpl currentTier4Block14SummationDelivered;
	private final AttributeImpl currentTier4Block15SummationDelivered;
	private final AttributeImpl currentTier4Block16SummationDelivered;
	// tier 5
	private final AttributeImpl currentTier5Block1SummationDelivered;
	private final AttributeImpl currentTier5Block2SummationDelivered;
	private final AttributeImpl currentTier5Block3SummationDelivered;
	private final AttributeImpl currentTier5Block4SummationDelivered;
	private final AttributeImpl currentTier5Block5SummationDelivered;
	private final AttributeImpl currentTier5Block6SummationDelivered;
	private final AttributeImpl currentTier5Block7SummationDelivered;
	private final AttributeImpl currentTier5Block8SummationDelivered;
	private final AttributeImpl currentTier5Block9SummationDelivered;
	private final AttributeImpl currentTier5Block10SummationDelivered;
	private final AttributeImpl currentTier5Block11SummationDelivered;
	private final AttributeImpl currentTier5Block12SummationDelivered;
	private final AttributeImpl currentTier5Block13SummationDelivered;
	private final AttributeImpl currentTier5Block14SummationDelivered;
	private final AttributeImpl currentTier5Block15SummationDelivered;
	private final AttributeImpl currentTier5Block16SummationDelivered;
	// tier 6
	private final AttributeImpl currentTier6Block1SummationDelivered;
	private final AttributeImpl currentTier6Block2SummationDelivered;
	private final AttributeImpl currentTier6Block3SummationDelivered;
	private final AttributeImpl currentTier6Block4SummationDelivered;
	private final AttributeImpl currentTier6Block5SummationDelivered;
	private final AttributeImpl currentTier6Block6SummationDelivered;
	private final AttributeImpl currentTier6Block7SummationDelivered;
	private final AttributeImpl currentTier6Block8SummationDelivered;
	private final AttributeImpl currentTier6Block9SummationDelivered;
	private final AttributeImpl currentTier6Block10SummationDelivered;
	private final AttributeImpl currentTier6Block11SummationDelivered;
	private final AttributeImpl currentTier6Block12SummationDelivered;
	private final AttributeImpl currentTier6Block13SummationDelivered;
	private final AttributeImpl currentTier6Block14SummationDelivered;
	private final AttributeImpl currentTier6Block15SummationDelivered;
	private final AttributeImpl currentTier6Block16SummationDelivered;
	// tier 7
	private final AttributeImpl currentTier7Block1SummationDelivered;
	private final AttributeImpl currentTier7Block2SummationDelivered;
	private final AttributeImpl currentTier7Block3SummationDelivered;
	private final AttributeImpl currentTier7Block4SummationDelivered;
	private final AttributeImpl currentTier7Block5SummationDelivered;
	private final AttributeImpl currentTier7Block6SummationDelivered;
	private final AttributeImpl currentTier7Block7SummationDelivered;
	private final AttributeImpl currentTier7Block8SummationDelivered;
	private final AttributeImpl currentTier7Block9SummationDelivered;
	private final AttributeImpl currentTier7Block10SummationDelivered;
	private final AttributeImpl currentTier7Block11SummationDelivered;
	private final AttributeImpl currentTier7Block12SummationDelivered;
	private final AttributeImpl currentTier7Block13SummationDelivered;
	private final AttributeImpl currentTier7Block14SummationDelivered;
	private final AttributeImpl currentTier7Block15SummationDelivered;
	private final AttributeImpl currentTier7Block16SummationDelivered;
	// tier 8
	private final AttributeImpl currentTier8Block1SummationDelivered;
	private final AttributeImpl currentTier8Block2SummationDelivered;
	private final AttributeImpl currentTier8Block3SummationDelivered;
	private final AttributeImpl currentTier8Block4SummationDelivered;
	private final AttributeImpl currentTier8Block5SummationDelivered;
	private final AttributeImpl currentTier8Block6SummationDelivered;
	private final AttributeImpl currentTier8Block7SummationDelivered;
	private final AttributeImpl currentTier8Block8SummationDelivered;
	private final AttributeImpl currentTier8Block9SummationDelivered;
	private final AttributeImpl currentTier8Block10SummationDelivered;
	private final AttributeImpl currentTier8Block11SummationDelivered;
	private final AttributeImpl currentTier8Block12SummationDelivered;
	private final AttributeImpl currentTier8Block13SummationDelivered;
	private final AttributeImpl currentTier8Block14SummationDelivered;
	private final AttributeImpl currentTier8Block15SummationDelivered;
	private final AttributeImpl currentTier8Block16SummationDelivered;
	// tier 9
	private final AttributeImpl currentTier9Block1SummationDelivered;
	private final AttributeImpl currentTier9Block2SummationDelivered;
	private final AttributeImpl currentTier9Block3SummationDelivered;
	private final AttributeImpl currentTier9Block4SummationDelivered;
	private final AttributeImpl currentTier9Block5SummationDelivered;
	private final AttributeImpl currentTier9Block6SummationDelivered;
	private final AttributeImpl currentTier9Block7SummationDelivered;
	private final AttributeImpl currentTier9Block8SummationDelivered;
	private final AttributeImpl currentTier9Block9SummationDelivered;
	private final AttributeImpl currentTier9Block10SummationDelivered;
	private final AttributeImpl currentTier9Block11SummationDelivered;
	private final AttributeImpl currentTier9Block12SummationDelivered;
	private final AttributeImpl currentTier9Block13SummationDelivered;
	private final AttributeImpl currentTier9Block14SummationDelivered;
	private final AttributeImpl currentTier9Block15SummationDelivered;
	private final AttributeImpl currentTier9Block16SummationDelivered;
	// tier 10
	private final AttributeImpl currentTier10Block1SummationDelivered;
	private final AttributeImpl currentTier10Block2SummationDelivered;
	private final AttributeImpl currentTier10Block3SummationDelivered;
	private final AttributeImpl currentTier10Block4SummationDelivered;
	private final AttributeImpl currentTier10Block5SummationDelivered;
	private final AttributeImpl currentTier10Block6SummationDelivered;
	private final AttributeImpl currentTier10Block7SummationDelivered;
	private final AttributeImpl currentTier10Block8SummationDelivered;
	private final AttributeImpl currentTier10Block9SummationDelivered;
	private final AttributeImpl currentTier10Block10SummationDelivered;
	private final AttributeImpl currentTier10Block11SummationDelivered;
	private final AttributeImpl currentTier10Block12SummationDelivered;
	private final AttributeImpl currentTier10Block13SummationDelivered;
	private final AttributeImpl currentTier10Block14SummationDelivered;
	private final AttributeImpl currentTier10Block15SummationDelivered;
	private final AttributeImpl currentTier10Block16SummationDelivered;
	// tier 11
	private final AttributeImpl currentTier11Block1SummationDelivered;
	private final AttributeImpl currentTier11Block2SummationDelivered;
	private final AttributeImpl currentTier11Block3SummationDelivered;
	private final AttributeImpl currentTier11Block4SummationDelivered;
	private final AttributeImpl currentTier11Block5SummationDelivered;
	private final AttributeImpl currentTier11Block6SummationDelivered;
	private final AttributeImpl currentTier11Block7SummationDelivered;
	private final AttributeImpl currentTier11Block8SummationDelivered;
	private final AttributeImpl currentTier11Block9SummationDelivered;
	private final AttributeImpl currentTier11Block10SummationDelivered;
	private final AttributeImpl currentTier11Block11SummationDelivered;
	private final AttributeImpl currentTier11Block12SummationDelivered;
	private final AttributeImpl currentTier11Block13SummationDelivered;
	private final AttributeImpl currentTier11Block14SummationDelivered;
	private final AttributeImpl currentTier11Block15SummationDelivered;
	private final AttributeImpl currentTier11Block16SummationDelivered;
	// tier 12
	private final AttributeImpl currentTier12Block1SummationDelivered;
	private final AttributeImpl currentTier12Block2SummationDelivered;
	private final AttributeImpl currentTier12Block3SummationDelivered;
	private final AttributeImpl currentTier12Block4SummationDelivered;
	private final AttributeImpl currentTier12Block5SummationDelivered;
	private final AttributeImpl currentTier12Block6SummationDelivered;
	private final AttributeImpl currentTier12Block7SummationDelivered;
	private final AttributeImpl currentTier12Block8SummationDelivered;
	private final AttributeImpl currentTier12Block9SummationDelivered;
	private final AttributeImpl currentTier12Block10SummationDelivered;
	private final AttributeImpl currentTier12Block11SummationDelivered;
	private final AttributeImpl currentTier12Block12SummationDelivered;
	private final AttributeImpl currentTier12Block13SummationDelivered;
	private final AttributeImpl currentTier12Block14SummationDelivered;
	private final AttributeImpl currentTier12Block15SummationDelivered;
	private final AttributeImpl currentTier12Block16SummationDelivered;
	// tier 13
	private final AttributeImpl currentTier13Block1SummationDelivered;
	private final AttributeImpl currentTier13Block2SummationDelivered;
	private final AttributeImpl currentTier13Block3SummationDelivered;
	private final AttributeImpl currentTier13Block4SummationDelivered;
	private final AttributeImpl currentTier13Block5SummationDelivered;
	private final AttributeImpl currentTier13Block6SummationDelivered;
	private final AttributeImpl currentTier13Block7SummationDelivered;
	private final AttributeImpl currentTier13Block8SummationDelivered;
	private final AttributeImpl currentTier13Block9SummationDelivered;
	private final AttributeImpl currentTier13Block10SummationDelivered;
	private final AttributeImpl currentTier13Block11SummationDelivered;
	private final AttributeImpl currentTier13Block12SummationDelivered;
	private final AttributeImpl currentTier13Block13SummationDelivered;
	private final AttributeImpl currentTier13Block14SummationDelivered;
	private final AttributeImpl currentTier13Block15SummationDelivered;
	private final AttributeImpl currentTier13Block16SummationDelivered;
	// tier 14
	private final AttributeImpl currentTier14Block1SummationDelivered;
	private final AttributeImpl currentTier14Block2SummationDelivered;
	private final AttributeImpl currentTier14Block3SummationDelivered;
	private final AttributeImpl currentTier14Block4SummationDelivered;
	private final AttributeImpl currentTier14Block5SummationDelivered;
	private final AttributeImpl currentTier14Block6SummationDelivered;
	private final AttributeImpl currentTier14Block7SummationDelivered;
	private final AttributeImpl currentTier14Block8SummationDelivered;
	private final AttributeImpl currentTier14Block9SummationDelivered;
	private final AttributeImpl currentTier14Block10SummationDelivered;
	private final AttributeImpl currentTier14Block11SummationDelivered;
	private final AttributeImpl currentTier14Block12SummationDelivered;
	private final AttributeImpl currentTier14Block13SummationDelivered;
	private final AttributeImpl currentTier14Block14SummationDelivered;
	private final AttributeImpl currentTier14Block15SummationDelivered;
	private final AttributeImpl currentTier14Block16SummationDelivered;
	// tier 15
	private final AttributeImpl currentTier15Block1SummationDelivered;
	private final AttributeImpl currentTier15Block2SummationDelivered;
	private final AttributeImpl currentTier15Block3SummationDelivered;
	private final AttributeImpl currentTier15Block4SummationDelivered;
	private final AttributeImpl currentTier15Block5SummationDelivered;
	private final AttributeImpl currentTier15Block6SummationDelivered;
	private final AttributeImpl currentTier15Block7SummationDelivered;
	private final AttributeImpl currentTier15Block8SummationDelivered;
	private final AttributeImpl currentTier15Block9SummationDelivered;
	private final AttributeImpl currentTier15Block10SummationDelivered;
	private final AttributeImpl currentTier15Block11SummationDelivered;
	private final AttributeImpl currentTier15Block12SummationDelivered;
	private final AttributeImpl currentTier15Block13SummationDelivered;
	private final AttributeImpl currentTier15Block14SummationDelivered;
	private final AttributeImpl currentTier15Block15SummationDelivered;
	private final AttributeImpl currentTier15Block16SummationDelivered;

	// alarm
	private final AttributeImpl genericAlarmMask;
	private final AttributeImpl electricityAlarmMask;
	private final AttributeImpl genericFlowPressureAlarmMask;
	private final AttributeImpl waterSpecificAlarmMask;
	private final AttributeImpl heatAndCoolingSpecificAlarmMask;
	private final AttributeImpl gasSpecificAlarmMask;

	private final Attribute[] attributes;

	public MeteringCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		// reading information
		currentSummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_SUMMATION_DELIVERED);
		currentSummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_SUMMATION_RECEIVED);
		currentMaxDemandReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MAX_DEMAND_RECEIVED);
		currentMaxDemandDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MAX_DEMAND_DELIVERED);
		dFTSummation = new AttributeImpl(zbDevice, this,
				AttributesMetering.DFT_SUMMATION);
		dailyFreezeTime = new AttributeImpl(zbDevice, this,
				AttributesMetering.DAILY_FREEZE_TIME);
		powerFactor = new AttributeImpl(zbDevice, this,
				AttributesMetering.POWER_FACTOR);
		readingSnapShotTime = new AttributeImpl(zbDevice, this,
				AttributesMetering.READING_SNAP_SHOT_TIME);
		currentMaxDemandDeliveredTime = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MAX_DEMAND_DELIVERED_TIME);
		currentMaxDemandReceivedTime = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MAX_DEMAND_RECEIVED_TIME);
		defaultUpdatePeriod = new AttributeImpl(zbDevice, this,
				AttributesMetering.DEFAULT_UPDATE_PERIOD);
		fastPollUpdatePeriod = new AttributeImpl(zbDevice, this,
				AttributesMetering.FAST_POLL_UPDATE_PERIOD);
		currentBlockPeriodConsumptionDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_BLOCK_PERIOD_CONSUMPTION_DELIVERED);
		dailyConsumptionTarget = new AttributeImpl(zbDevice, this,
				AttributesMetering.DAILY_CONSUMPTION_TARGET);
		currentBlock = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_BLOCK);
		profileIntervalPeriod = new AttributeImpl(zbDevice, this,
				AttributesMetering.PROFILE_INTERVAL_PERIOD);
		intervalReadReportingPeriod = new AttributeImpl(zbDevice, this,
				AttributesMetering.INTERVAL_READ_REPORTING_PERIOD);
		presetReadingTime = new AttributeImpl(zbDevice, this,
				AttributesMetering.PRESET_READING_TIME);
		volumePerReport = new AttributeImpl(zbDevice, this,
				AttributesMetering.VOLUME_PER_REPORT);
		flowRestriction = new AttributeImpl(zbDevice, this,
				AttributesMetering.FLOW_RESTRICTION);
		supplyStatus = new AttributeImpl(zbDevice, this,
				AttributesMetering.SUPPLY_STATUS);
		currentInletEnergyCarrierSummation = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_INLET_ENERGY_CARRIER_SUMMATION);
		currentOutletEnergyCarrierSummation = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_OUTLET_ENERGY_CARRIER_SUMMATION);
		inletTemperature = new AttributeImpl(zbDevice, this,
				AttributesMetering.INLET_TEMPERATURE);
		outletTemperature = new AttributeImpl(zbDevice, this,
				AttributesMetering.OUTLET_TEMPERATURE);
		controlTemperature = new AttributeImpl(zbDevice, this,
				AttributesMetering.CONTROL_TEMPERATURE);
		currentInletEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_INLET_ENERGY_CARRIER_DEMAND);
		currentOutletEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_OUTLET_ENERGY_CARRIER_DEMAND);
		// TOU information
		currentTier1SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_1_SUMMATION_DELIVERED);
		currentTier1SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_1_SUMMATION_RECEIVED);
		currentTier2SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_2_SUMMATION_DELIVERED);
		currentTier2SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_2_SUMMATION_RECEIVED);
		currentTier3SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_3_SUMMATION_DELIVERED);
		currentTier3SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_3_SUMMATION_RECEIVED);
		currentTier4SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_4_SUMMATION_DELIVERED);
		currentTier4SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_4_SUMMATION_RECEIVED);
		currentTier5SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_5_SUMMATION_DELIVERED);
		currentTier5SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_5_SUMMATION_RECEIVED);
		currentTier6SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_6_SUMMATION_DELIVERED);
		currentTier6SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_6_SUMMATION_RECEIVED);
		currentTier7SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_7_SUMMATION_DELIVERED);
		currentTier7SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_7_SUMMATION_RECEIVED);
		currentTier8SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_8_SUMMATION_DELIVERED);
		currentTier8SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_8_SUMMATION_RECEIVED);
		currentTier9SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_9_SUMMATION_DELIVERED);
		currentTier9SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_9_SUMMATION_RECEIVED);
		currentTier10SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_10_SUMMATION_DELIVERED);
		currentTier10SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_10_SUMMATION_RECEIVED);
		currentTier11SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_11_SUMMATION_DELIVERED);
		currentTier11SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_11_SUMMATION_RECEIVED);
		currentTier12SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_12_SUMMATION_DELIVERED);
		currentTier12SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_12_SUMMATION_RECEIVED);
		currentTier13SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_13_SUMMATION_DELIVERED);
		currentTier13SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_13_SUMMATION_RECEIVED);
		currentTier14SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_14_SUMMATION_DELIVERED);
		currentTier14SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_14_SUMMATION_RECEIVED);
		currentTier15SummationDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_15_SUMMATION_DELIVERED);
		currentTier15SummationReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_TIER_15_SUMMATION_RECEIVED);

		// meter status
		status = new AttributeImpl(zbDevice, this, AttributesMetering.STATUS);
		remainingBatteryLife = new AttributeImpl(zbDevice, this,
				AttributesMetering.REMAINING_BATTERY_LIFE);
		hoursInOperation = new AttributeImpl(zbDevice, this,
				AttributesMetering.HOURS_IN_OPERATION);
		hoursInFault = new AttributeImpl(zbDevice, this,
				AttributesMetering.HOURS_IN_FAULT);
		// formatting
		unitOfMeasure = new AttributeImpl(zbDevice, this,
				AttributesMetering.UNIT_OF_MEASURE);
		multiplier = new AttributeImpl(zbDevice, this,
				AttributesMetering.MULTIPLIER);
		divisor = new AttributeImpl(zbDevice, this, AttributesMetering.DIVISOR);
		summationFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.SUMMATION_FORMATTING);
		demandFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.DEMAND_FORMATTING);
		historicalConsumptionFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.HISTORICAL_CONSUMPTION_FORMATTING);
		meteringDeviceType = new AttributeImpl(zbDevice, this,
				AttributesMetering.METERING_DEVICE_TYPE);
		siteID = new AttributeImpl(zbDevice, this, AttributesMetering.SITE_ID);
		meterSerialNumber = new AttributeImpl(zbDevice, this,
				AttributesMetering.METER_SERIAL_NUMBER);
		energyCarrierUnitOfMeasure = new AttributeImpl(zbDevice, this,
				AttributesMetering.ENERGY_CARRIER_UNIT_OF_MEASURE);
		energyCarrierSummationFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.ENERGY_CARRIER_SUMMATION_FORMATTING);
		energyCarrierDemandFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.ENERGY_CARRIER_DEMAND_FORMATTING);
		temperatureUnitOfMeasure = new AttributeImpl(zbDevice, this,
				AttributesMetering.TEMPERATURE_UNIT_OF_MEASURE);
		temperatureFormatting = new AttributeImpl(zbDevice, this,
				AttributesMetering.TEMPERATURE_FORMATTING);
		// historical
		instantaneousDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.INSTANTANEOUS_DEMAND);
		currentDayConsumptionDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_CONSUMPTION_DELIVERED);
		currentDayConsumptionReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_CONSUMPTION_RECEIVED);
		previousDayConsumptionDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_CONSUMPTION_DELIVERED);
		previousDayConsumptionReceived = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_CONSUMPTION_RECEIVED);
		currentPartialProfileIntervalStartTimeDelivered = new AttributeImpl(
				zbDevice,
				this,
				AttributesMetering.CURRENT_PARTIAL_PROFILE_INTERVAL_START_TIME_DELIVERED);
		currentPartialProfileIntervalStartTimeReceived = new AttributeImpl(
				zbDevice,
				this,
				AttributesMetering.CURRENT_PARTIAL_PROFILE_INTERVAL_START_TIME_RECEIVED);
		currentPartialProfileIntervalValueDelivered = new AttributeImpl(
				zbDevice,
				this,
				AttributesMetering.CURRENT_PARTIAL_PROFILE_INTERVAL_VALUE_DELIVERED);
		currentPartialProfileIntervalValueReceived = new AttributeImpl(
				zbDevice,
				this,
				AttributesMetering.CURRENT_PARTIAL_PROFILE_INTERVAL_VALUE_RECEIVED);
		currentDayMaxPressure = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_MAX_PRESSURE);
		currentDayMinPressure = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_MIN_PRESSURE);
		previousDayMaxPressure = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_MAX_PRESSURE);
		previousDayMinPressure = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_MIN_PRESSURE);
		currentDayMaxDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_MAX_DEMAND);
		previousDayMaxDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_MAX_DEMAND);
		currentMonthMaxDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MONTH_MAX_DEMAND);
		currentYearMaxDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_YEAR_MAX_DEMAND);
		currentDayMaxEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DAY_MAX_ENERGY_CARRIER_DEMAND);
		previousDayMaxEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.PREVIOUS_DAY_MAX_ENERGY_CARRIER_DEMAND);
		currentMonthMaxEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MONTH_MAX_ENERGY_CARRIER_DEMAND);
		currentMonthMinEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_MONTH_MIN_ENERGY_CARRIER_DEMAND);
		currentYearMaxEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_YEAR_MAX_ENERGY_CARRIER_DEMAND);
		currentYearMinEnergyCarrierDemand = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_YEAR_MIN_ENERGY_CARRIER_DEMAND);
		// loadprofile
		maxNumberOfPeriodsDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.MAX_NUMBER_OF_PERIODS_DELIVERED);
		// supply limit
		currentDemandDelivered = new AttributeImpl(zbDevice, this,
				AttributesMetering.CURRENT_DEMAND_DELIVERED);
		demandLimit = new AttributeImpl(zbDevice, this,
				AttributesMetering.DEMAND_LIMIT);
		demandIntegrationPeriod = new AttributeImpl(zbDevice, this,
				AttributesMetering.DEMAND_INTEGRATION_PERIOD);
		numberOfDemandAndSubintervals = new AttributeImpl(zbDevice, this,
				AttributesMetering.NUMBER_OF_DEMAND_AND_SUBINTERVALS);

		// block information

		// no tier
		currentNoTierBlock1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_1_SUMMATION_DELIVERED);
		currentNoTierBlock2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_2_SUMMATION_DELIVERED);
		currentNoTierBlock3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_3_SUMMATION_DELIVERED);
		currentNoTierBlock4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_4_SUMMATION_DELIVERED);
		currentNoTierBlock5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_5_SUMMATION_DELIVERED);
		currentNoTierBlock6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_6_SUMMATION_DELIVERED);
		currentNoTierBlock7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_7_SUMMATION_DELIVERED);
		currentNoTierBlock8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_8_SUMMATION_DELIVERED);
		currentNoTierBlock9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_9_SUMMATION_DELIVERED);
		currentNoTierBlock10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_10_SUMMATION_DELIVERED);
		currentNoTierBlock11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_11_SUMMATION_DELIVERED);
		currentNoTierBlock12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_12_SUMMATION_DELIVERED);
		currentNoTierBlock13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_13_SUMMATION_DELIVERED);
		currentNoTierBlock14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_14_SUMMATION_DELIVERED);
		currentNoTierBlock15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_15_SUMMATION_DELIVERED);
		currentNoTierBlock16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_NO_TIER_BLOCK_16_SUMMATION_DELIVERED);

		// tier 1
		currentTier1Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_1_SUMMATION_DELIVERED);
		currentTier1Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_2_SUMMATION_DELIVERED);
		currentTier1Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_3_SUMMATION_DELIVERED);
		currentTier1Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_4_SUMMATION_DELIVERED);
		currentTier1Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_5_SUMMATION_DELIVERED);
		currentTier1Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_6_SUMMATION_DELIVERED);
		currentTier1Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_7_SUMMATION_DELIVERED);
		currentTier1Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_8_SUMMATION_DELIVERED);
		currentTier1Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_9_SUMMATION_DELIVERED);
		currentTier1Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_10_SUMMATION_DELIVERED);
		currentTier1Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_11_SUMMATION_DELIVERED);
		currentTier1Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_12_SUMMATION_DELIVERED);
		currentTier1Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_13_SUMMATION_DELIVERED);
		currentTier1Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_14_SUMMATION_DELIVERED);
		currentTier1Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_15_SUMMATION_DELIVERED);
		currentTier1Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_1_BLOCK_16_SUMMATION_DELIVERED);
		// tier 2
		currentTier2Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_1_SUMMATION_DELIVERED);
		currentTier2Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_2_SUMMATION_DELIVERED);
		currentTier2Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_3_SUMMATION_DELIVERED);
		currentTier2Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_4_SUMMATION_DELIVERED);
		currentTier2Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_5_SUMMATION_DELIVERED);
		currentTier2Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_6_SUMMATION_DELIVERED);
		currentTier2Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_7_SUMMATION_DELIVERED);
		currentTier2Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_8_SUMMATION_DELIVERED);
		currentTier2Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_9_SUMMATION_DELIVERED);
		currentTier2Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_10_SUMMATION_DELIVERED);
		currentTier2Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_11_SUMMATION_DELIVERED);
		currentTier2Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_12_SUMMATION_DELIVERED);
		currentTier2Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_13_SUMMATION_DELIVERED);
		currentTier2Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_14_SUMMATION_DELIVERED);
		currentTier2Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_15_SUMMATION_DELIVERED);
		currentTier2Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_2_BLOCK_16_SUMMATION_DELIVERED);
		// tier 3
		currentTier3Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_1_SUMMATION_DELIVERED);
		currentTier3Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_2_SUMMATION_DELIVERED);
		currentTier3Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_3_SUMMATION_DELIVERED);
		currentTier3Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_4_SUMMATION_DELIVERED);
		currentTier3Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_5_SUMMATION_DELIVERED);
		currentTier3Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_6_SUMMATION_DELIVERED);
		currentTier3Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_7_SUMMATION_DELIVERED);
		currentTier3Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_8_SUMMATION_DELIVERED);
		currentTier3Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_9_SUMMATION_DELIVERED);
		currentTier3Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_10_SUMMATION_DELIVERED);
		currentTier3Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_11_SUMMATION_DELIVERED);
		currentTier3Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_12_SUMMATION_DELIVERED);
		currentTier3Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_13_SUMMATION_DELIVERED);
		currentTier3Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_14_SUMMATION_DELIVERED);
		currentTier3Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_15_SUMMATION_DELIVERED);
		currentTier3Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_3_BLOCK_16_SUMMATION_DELIVERED);
		// tier 4
		currentTier4Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_1_SUMMATION_DELIVERED);
		currentTier4Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_2_SUMMATION_DELIVERED);
		currentTier4Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_3_SUMMATION_DELIVERED);
		currentTier4Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_4_SUMMATION_DELIVERED);
		currentTier4Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_5_SUMMATION_DELIVERED);
		currentTier4Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_6_SUMMATION_DELIVERED);
		currentTier4Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_7_SUMMATION_DELIVERED);
		currentTier4Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_8_SUMMATION_DELIVERED);
		currentTier4Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_9_SUMMATION_DELIVERED);
		currentTier4Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_10_SUMMATION_DELIVERED);
		currentTier4Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_11_SUMMATION_DELIVERED);
		currentTier4Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_12_SUMMATION_DELIVERED);
		currentTier4Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_13_SUMMATION_DELIVERED);
		currentTier4Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_14_SUMMATION_DELIVERED);
		currentTier4Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_15_SUMMATION_DELIVERED);
		currentTier4Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_4_BLOCK_16_SUMMATION_DELIVERED);
		// tier 5
		currentTier5Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_1_SUMMATION_DELIVERED);
		currentTier5Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_2_SUMMATION_DELIVERED);
		currentTier5Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_3_SUMMATION_DELIVERED);
		currentTier5Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_4_SUMMATION_DELIVERED);
		currentTier5Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_5_SUMMATION_DELIVERED);
		currentTier5Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_6_SUMMATION_DELIVERED);
		currentTier5Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_7_SUMMATION_DELIVERED);
		currentTier5Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_8_SUMMATION_DELIVERED);
		currentTier5Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_9_SUMMATION_DELIVERED);
		currentTier5Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_10_SUMMATION_DELIVERED);
		currentTier5Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_11_SUMMATION_DELIVERED);
		currentTier5Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_12_SUMMATION_DELIVERED);
		currentTier5Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_13_SUMMATION_DELIVERED);
		currentTier5Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_14_SUMMATION_DELIVERED);
		currentTier5Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_15_SUMMATION_DELIVERED);
		currentTier5Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_5_BLOCK_16_SUMMATION_DELIVERED);
		// tier 6
		currentTier6Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_1_SUMMATION_DELIVERED);
		currentTier6Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_2_SUMMATION_DELIVERED);
		currentTier6Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_3_SUMMATION_DELIVERED);
		currentTier6Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_4_SUMMATION_DELIVERED);
		currentTier6Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_5_SUMMATION_DELIVERED);
		currentTier6Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_6_SUMMATION_DELIVERED);
		currentTier6Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_7_SUMMATION_DELIVERED);
		currentTier6Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_8_SUMMATION_DELIVERED);
		currentTier6Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_9_SUMMATION_DELIVERED);
		currentTier6Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_10_SUMMATION_DELIVERED);
		currentTier6Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_11_SUMMATION_DELIVERED);
		currentTier6Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_12_SUMMATION_DELIVERED);
		currentTier6Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_13_SUMMATION_DELIVERED);
		currentTier6Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_14_SUMMATION_DELIVERED);
		currentTier6Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_15_SUMMATION_DELIVERED);
		currentTier6Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_6_BLOCK_16_SUMMATION_DELIVERED);
		// tier 7
		currentTier7Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_1_SUMMATION_DELIVERED);
		currentTier7Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_2_SUMMATION_DELIVERED);
		currentTier7Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_3_SUMMATION_DELIVERED);
		currentTier7Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_4_SUMMATION_DELIVERED);
		currentTier7Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_5_SUMMATION_DELIVERED);
		currentTier7Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_6_SUMMATION_DELIVERED);
		currentTier7Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_7_SUMMATION_DELIVERED);
		currentTier7Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_8_SUMMATION_DELIVERED);
		currentTier7Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_9_SUMMATION_DELIVERED);
		currentTier7Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_10_SUMMATION_DELIVERED);
		currentTier7Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_11_SUMMATION_DELIVERED);
		currentTier7Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_12_SUMMATION_DELIVERED);
		currentTier7Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_13_SUMMATION_DELIVERED);
		currentTier7Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_14_SUMMATION_DELIVERED);
		currentTier7Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_15_SUMMATION_DELIVERED);
		currentTier7Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_7_BLOCK_16_SUMMATION_DELIVERED);
		// tier 8
		currentTier8Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_1_SUMMATION_DELIVERED);
		currentTier8Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_2_SUMMATION_DELIVERED);
		currentTier8Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_3_SUMMATION_DELIVERED);
		currentTier8Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_4_SUMMATION_DELIVERED);
		currentTier8Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_5_SUMMATION_DELIVERED);
		currentTier8Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_6_SUMMATION_DELIVERED);
		currentTier8Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_7_SUMMATION_DELIVERED);
		currentTier8Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_8_SUMMATION_DELIVERED);
		currentTier8Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_9_SUMMATION_DELIVERED);
		currentTier8Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_10_SUMMATION_DELIVERED);
		currentTier8Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_11_SUMMATION_DELIVERED);
		currentTier8Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_12_SUMMATION_DELIVERED);
		currentTier8Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_13_SUMMATION_DELIVERED);
		currentTier8Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_14_SUMMATION_DELIVERED);
		currentTier8Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_15_SUMMATION_DELIVERED);
		currentTier8Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_8_BLOCK_16_SUMMATION_DELIVERED);
		// tier 9
		currentTier9Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_1_SUMMATION_DELIVERED);
		currentTier9Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_2_SUMMATION_DELIVERED);
		currentTier9Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_3_SUMMATION_DELIVERED);
		currentTier9Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_4_SUMMATION_DELIVERED);
		currentTier9Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_5_SUMMATION_DELIVERED);
		currentTier9Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_6_SUMMATION_DELIVERED);
		currentTier9Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_7_SUMMATION_DELIVERED);
		currentTier9Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_8_SUMMATION_DELIVERED);
		currentTier9Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_9_SUMMATION_DELIVERED);
		currentTier9Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_10_SUMMATION_DELIVERED);
		currentTier9Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_11_SUMMATION_DELIVERED);
		currentTier9Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_12_SUMMATION_DELIVERED);
		currentTier9Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_13_SUMMATION_DELIVERED);
		currentTier9Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_14_SUMMATION_DELIVERED);
		currentTier9Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_15_SUMMATION_DELIVERED);
		currentTier9Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_9_BLOCK_16_SUMMATION_DELIVERED);
		// tier 10
		currentTier10Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_1_SUMMATION_DELIVERED);
		currentTier10Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_2_SUMMATION_DELIVERED);
		currentTier10Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_3_SUMMATION_DELIVERED);
		currentTier10Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_4_SUMMATION_DELIVERED);
		currentTier10Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_5_SUMMATION_DELIVERED);
		currentTier10Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_6_SUMMATION_DELIVERED);
		currentTier10Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_7_SUMMATION_DELIVERED);
		currentTier10Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_8_SUMMATION_DELIVERED);
		currentTier10Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_9_SUMMATION_DELIVERED);
		currentTier10Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_10_SUMMATION_DELIVERED);
		currentTier10Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_11_SUMMATION_DELIVERED);
		currentTier10Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_12_SUMMATION_DELIVERED);
		currentTier10Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_13_SUMMATION_DELIVERED);
		currentTier10Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_14_SUMMATION_DELIVERED);
		currentTier10Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_15_SUMMATION_DELIVERED);
		currentTier10Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_10_BLOCK_16_SUMMATION_DELIVERED);
		// tier 11
		currentTier11Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_1_SUMMATION_DELIVERED);
		currentTier11Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_2_SUMMATION_DELIVERED);
		currentTier11Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_3_SUMMATION_DELIVERED);
		currentTier11Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_4_SUMMATION_DELIVERED);
		currentTier11Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_5_SUMMATION_DELIVERED);
		currentTier11Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_6_SUMMATION_DELIVERED);
		currentTier11Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_7_SUMMATION_DELIVERED);
		currentTier11Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_8_SUMMATION_DELIVERED);
		currentTier11Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_9_SUMMATION_DELIVERED);
		currentTier11Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_10_SUMMATION_DELIVERED);
		currentTier11Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_11_SUMMATION_DELIVERED);
		currentTier11Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_12_SUMMATION_DELIVERED);
		currentTier11Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_13_SUMMATION_DELIVERED);
		currentTier11Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_14_SUMMATION_DELIVERED);
		currentTier11Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_15_SUMMATION_DELIVERED);
		currentTier11Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_11_BLOCK_16_SUMMATION_DELIVERED);
		// tier 12
		currentTier12Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_1_SUMMATION_DELIVERED);
		currentTier12Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_2_SUMMATION_DELIVERED);
		currentTier12Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_3_SUMMATION_DELIVERED);
		currentTier12Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_4_SUMMATION_DELIVERED);
		currentTier12Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_5_SUMMATION_DELIVERED);
		currentTier12Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_6_SUMMATION_DELIVERED);
		currentTier12Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_7_SUMMATION_DELIVERED);
		currentTier12Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_8_SUMMATION_DELIVERED);
		currentTier12Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_9_SUMMATION_DELIVERED);
		currentTier12Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_10_SUMMATION_DELIVERED);
		currentTier12Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_11_SUMMATION_DELIVERED);
		currentTier12Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_12_SUMMATION_DELIVERED);
		currentTier12Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_13_SUMMATION_DELIVERED);
		currentTier12Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_14_SUMMATION_DELIVERED);
		currentTier12Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_15_SUMMATION_DELIVERED);
		currentTier12Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_12_BLOCK_16_SUMMATION_DELIVERED);
		// tier 13
		currentTier13Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_1_SUMMATION_DELIVERED);
		currentTier13Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_2_SUMMATION_DELIVERED);
		currentTier13Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_3_SUMMATION_DELIVERED);
		currentTier13Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_4_SUMMATION_DELIVERED);
		currentTier13Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_5_SUMMATION_DELIVERED);
		currentTier13Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_6_SUMMATION_DELIVERED);
		currentTier13Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_7_SUMMATION_DELIVERED);
		currentTier13Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_8_SUMMATION_DELIVERED);
		currentTier13Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_9_SUMMATION_DELIVERED);
		currentTier13Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_10_SUMMATION_DELIVERED);
		currentTier13Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_11_SUMMATION_DELIVERED);
		currentTier13Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_12_SUMMATION_DELIVERED);
		currentTier13Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_13_SUMMATION_DELIVERED);
		currentTier13Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_14_SUMMATION_DELIVERED);
		currentTier13Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_15_SUMMATION_DELIVERED);
		currentTier13Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_13_BLOCK_16_SUMMATION_DELIVERED);
		// tier 14
		currentTier14Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_1_SUMMATION_DELIVERED);
		currentTier14Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_2_SUMMATION_DELIVERED);
		currentTier14Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_3_SUMMATION_DELIVERED);
		currentTier14Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_4_SUMMATION_DELIVERED);
		currentTier14Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_5_SUMMATION_DELIVERED);
		currentTier14Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_6_SUMMATION_DELIVERED);
		currentTier14Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_7_SUMMATION_DELIVERED);
		currentTier14Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_8_SUMMATION_DELIVERED);
		currentTier14Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_9_SUMMATION_DELIVERED);
		currentTier14Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_10_SUMMATION_DELIVERED);
		currentTier14Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_11_SUMMATION_DELIVERED);
		currentTier14Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_12_SUMMATION_DELIVERED);
		currentTier14Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_13_SUMMATION_DELIVERED);
		currentTier14Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_14_SUMMATION_DELIVERED);
		currentTier14Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_15_SUMMATION_DELIVERED);
		currentTier14Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_14_BLOCK_16_SUMMATION_DELIVERED);
		// tier 15
		currentTier15Block1SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_1_SUMMATION_DELIVERED);
		currentTier15Block2SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_2_SUMMATION_DELIVERED);
		currentTier15Block3SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_3_SUMMATION_DELIVERED);
		currentTier15Block4SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_4_SUMMATION_DELIVERED);
		currentTier15Block5SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_5_SUMMATION_DELIVERED);
		currentTier15Block6SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_6_SUMMATION_DELIVERED);
		currentTier15Block7SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_7_SUMMATION_DELIVERED);
		currentTier15Block8SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_8_SUMMATION_DELIVERED);
		currentTier15Block9SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_9_SUMMATION_DELIVERED);
		currentTier15Block10SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_10_SUMMATION_DELIVERED);
		currentTier15Block11SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_11_SUMMATION_DELIVERED);
		currentTier15Block12SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_12_SUMMATION_DELIVERED);
		currentTier15Block13SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_13_SUMMATION_DELIVERED);
		currentTier15Block14SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_14_SUMMATION_DELIVERED);
		currentTier15Block15SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_15_SUMMATION_DELIVERED);
		currentTier15Block16SummationDelivered = new AttributeImpl(zbDevice,
				this,
				AttributesMetering.CURRENT_TIER_15_BLOCK_16_SUMMATION_DELIVERED);

		// alarm
		genericAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.GENERIC_ALARM_MASK);
		electricityAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.ELECTRICITY_ALARM_MASK);
		genericFlowPressureAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.GENERIC_FLOW_PRESSURE_ALARM_MASK);
		waterSpecificAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.WATER_SPECIFIC_ALARM_MASK);
		heatAndCoolingSpecificAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.HEAT_AND_COOLING_SPECIFIC_ALARM_MASK);
		gasSpecificAlarmMask = new AttributeImpl(zbDevice, this,
				AttributesMetering.GAS_SPECIFIC_ALARM_MASK);

		attributes = new AttributeImpl[]{
		currentSummationDelivered,
		currentSummationReceived,
		currentMaxDemandReceived,
		currentMaxDemandDelivered,
		dFTSummation,
		dailyFreezeTime,
		powerFactor,
		readingSnapShotTime,
		currentMaxDemandDeliveredTime,
		currentMaxDemandReceivedTime,
		defaultUpdatePeriod,
		fastPollUpdatePeriod,
		currentBlockPeriodConsumptionDelivered,
		dailyConsumptionTarget,
		currentBlock,
		profileIntervalPeriod,
		intervalReadReportingPeriod,
		presetReadingTime,
		volumePerReport,
		supplyStatus,
		flowRestriction,
		currentInletEnergyCarrierSummation,
		currentOutletEnergyCarrierSummation,
		inletTemperature,
		outletTemperature,
		controlTemperature,
		currentInletEnergyCarrierDemand,
		currentOutletEnergyCarrierDemand,
		// TOU information
		currentTier1SummationDelivered,
		currentTier1SummationReceived,
		currentTier2SummationDelivered,
		currentTier2SummationReceived,
		currentTier3SummationDelivered,
		currentTier3SummationReceived,
		currentTier4SummationDelivered,
		currentTier4SummationReceived,
		currentTier5SummationDelivered,
		currentTier5SummationReceived,
		currentTier6SummationDelivered,
		currentTier6SummationReceived,
		currentTier7SummationDelivered,
		currentTier7SummationReceived,
		currentTier8SummationDelivered,
		currentTier8SummationReceived,
		currentTier9SummationDelivered,
		currentTier9SummationReceived,
		currentTier10SummationDelivered,
		currentTier10SummationReceived,
		currentTier11SummationDelivered,
		currentTier11SummationReceived,
		currentTier12SummationDelivered,
		currentTier12SummationReceived,
		currentTier13SummationDelivered,
		currentTier13SummationReceived,
		currentTier14SummationDelivered,
		currentTier14SummationReceived,
		currentTier15SummationDelivered,
		currentTier15SummationReceived,
		// meter status
		status,
		remainingBatteryLife,
		hoursInOperation,
		hoursInFault,
		// formatting
		unitOfMeasure,
		multiplier,
		divisor,
		summationFormatting,
		demandFormatting,
		historicalConsumptionFormatting,
		meteringDeviceType,
		siteID,
		meterSerialNumber,
		energyCarrierUnitOfMeasure,
		energyCarrierSummationFormatting,
		energyCarrierDemandFormatting,
		temperatureUnitOfMeasure,
		temperatureFormatting,
		// historical
		instantaneousDemand,
		currentDayConsumptionDelivered,
		currentDayConsumptionReceived,
		previousDayConsumptionDelivered,
		previousDayConsumptionReceived,
		currentPartialProfileIntervalStartTimeDelivered,
		currentPartialProfileIntervalStartTimeReceived,
		currentPartialProfileIntervalValueDelivered,
		currentPartialProfileIntervalValueReceived,
		currentDayMaxPressure,
		currentDayMinPressure,
		previousDayMaxPressure,
		previousDayMinPressure,
		currentDayMaxDemand,
		previousDayMaxDemand,
		currentMonthMaxDemand,
		currentYearMaxDemand,
		currentDayMaxEnergyCarrierDemand,
		previousDayMaxEnergyCarrierDemand,
		currentMonthMaxEnergyCarrierDemand,
		currentMonthMinEnergyCarrierDemand,
		currentYearMaxEnergyCarrierDemand,
		currentYearMinEnergyCarrierDemand,
		// loadprofile
		maxNumberOfPeriodsDelivered,
		// supply limit
		currentDemandDelivered,
		demandLimit,
		demandIntegrationPeriod,
		numberOfDemandAndSubintervals,
		// block information
		// no tier
		currentNoTierBlock1SummationDelivered,
		currentNoTierBlock2SummationDelivered,
		currentNoTierBlock3SummationDelivered,
		currentNoTierBlock4SummationDelivered,
		currentNoTierBlock5SummationDelivered,
		currentNoTierBlock6SummationDelivered,
		currentNoTierBlock7SummationDelivered,
		currentNoTierBlock8SummationDelivered,
		currentNoTierBlock9SummationDelivered,
		currentNoTierBlock10SummationDelivered,
		currentNoTierBlock11SummationDelivered,
		currentNoTierBlock12SummationDelivered,
		currentNoTierBlock13SummationDelivered,
		currentNoTierBlock14SummationDelivered,
		currentNoTierBlock15SummationDelivered,
		currentNoTierBlock16SummationDelivered,
		// tier 1
		currentTier1Block1SummationDelivered,
		currentTier1Block2SummationDelivered,
		currentTier1Block3SummationDelivered,
		currentTier1Block4SummationDelivered,
		currentTier1Block5SummationDelivered,
		currentTier1Block6SummationDelivered,
		currentTier1Block7SummationDelivered,
		currentTier1Block8SummationDelivered,
		currentTier1Block9SummationDelivered,
		currentTier1Block10SummationDelivered,
		currentTier1Block11SummationDelivered,
		currentTier1Block12SummationDelivered,
		currentTier1Block13SummationDelivered,
		currentTier1Block14SummationDelivered,
		currentTier1Block15SummationDelivered,
		currentTier1Block16SummationDelivered,
		// tier 2
		currentTier2Block1SummationDelivered,
		currentTier2Block2SummationDelivered,
		currentTier2Block3SummationDelivered,
		currentTier2Block4SummationDelivered,
		currentTier2Block5SummationDelivered,
		currentTier2Block6SummationDelivered,
		currentTier2Block7SummationDelivered,
		currentTier2Block8SummationDelivered,
		currentTier2Block9SummationDelivered,
		currentTier2Block10SummationDelivered,
		currentTier2Block11SummationDelivered,
		currentTier2Block12SummationDelivered,
		currentTier2Block13SummationDelivered,
		currentTier2Block14SummationDelivered,
		currentTier2Block15SummationDelivered,
		currentTier2Block16SummationDelivered,
		// tier 3
		currentTier3Block1SummationDelivered,
		currentTier3Block2SummationDelivered,
		currentTier3Block3SummationDelivered,
		currentTier3Block4SummationDelivered,
		currentTier3Block5SummationDelivered,
		currentTier3Block6SummationDelivered,
		currentTier3Block7SummationDelivered,
		currentTier3Block8SummationDelivered,
		currentTier3Block9SummationDelivered,
		currentTier3Block10SummationDelivered,
		currentTier3Block11SummationDelivered,
		currentTier3Block12SummationDelivered,
		currentTier3Block13SummationDelivered,
		currentTier3Block14SummationDelivered,
		currentTier3Block15SummationDelivered,
		currentTier3Block16SummationDelivered,
		// tier 4
		currentTier4Block1SummationDelivered,
		currentTier4Block2SummationDelivered,
		currentTier4Block3SummationDelivered,
		currentTier4Block4SummationDelivered,
		currentTier4Block5SummationDelivered,
		currentTier4Block6SummationDelivered,
		currentTier4Block7SummationDelivered,
		currentTier4Block8SummationDelivered,
		currentTier4Block9SummationDelivered,
		currentTier4Block10SummationDelivered,
		currentTier4Block11SummationDelivered,
		currentTier4Block12SummationDelivered,
		currentTier4Block13SummationDelivered,
		currentTier4Block14SummationDelivered,
		currentTier4Block15SummationDelivered,
		currentTier4Block16SummationDelivered,
		// tier 5
		currentTier5Block1SummationDelivered,
		currentTier5Block2SummationDelivered,
		currentTier5Block3SummationDelivered,
		currentTier5Block4SummationDelivered,
		currentTier5Block5SummationDelivered,
		currentTier5Block6SummationDelivered,
		currentTier5Block7SummationDelivered,
		currentTier5Block8SummationDelivered,
		currentTier5Block9SummationDelivered,
		currentTier5Block10SummationDelivered,
		currentTier5Block11SummationDelivered,
		currentTier5Block12SummationDelivered,
		currentTier5Block13SummationDelivered,
		currentTier5Block14SummationDelivered,
		currentTier5Block15SummationDelivered,
		currentTier5Block16SummationDelivered,
		// tier 6
		currentTier6Block1SummationDelivered,
		currentTier6Block2SummationDelivered,
		currentTier6Block3SummationDelivered,
		currentTier6Block4SummationDelivered,
		currentTier6Block5SummationDelivered,
		currentTier6Block6SummationDelivered,
		currentTier6Block7SummationDelivered,
		currentTier6Block8SummationDelivered,
		currentTier6Block9SummationDelivered,
		currentTier6Block10SummationDelivered,
		currentTier6Block11SummationDelivered,
		currentTier6Block12SummationDelivered,
		currentTier6Block13SummationDelivered,
		currentTier6Block14SummationDelivered,
		currentTier6Block15SummationDelivered,
		currentTier6Block16SummationDelivered,
		// tier 7
		currentTier7Block1SummationDelivered,
		currentTier7Block2SummationDelivered,
		currentTier7Block3SummationDelivered,
		currentTier7Block4SummationDelivered,
		currentTier7Block5SummationDelivered,
		currentTier7Block6SummationDelivered,
		currentTier7Block7SummationDelivered,
		currentTier7Block8SummationDelivered,
		currentTier7Block9SummationDelivered,
		currentTier7Block10SummationDelivered,
		currentTier7Block11SummationDelivered,
		currentTier7Block12SummationDelivered,
		currentTier7Block13SummationDelivered,
		currentTier7Block14SummationDelivered,
		currentTier7Block15SummationDelivered,
		currentTier7Block16SummationDelivered,
		// tier 8
		currentTier8Block1SummationDelivered,
		currentTier8Block2SummationDelivered,
		currentTier8Block3SummationDelivered,
		currentTier8Block4SummationDelivered,
		currentTier8Block5SummationDelivered,
		currentTier8Block6SummationDelivered,
		currentTier8Block7SummationDelivered,
		currentTier8Block8SummationDelivered,
		currentTier8Block9SummationDelivered,
		currentTier8Block10SummationDelivered,
		currentTier8Block11SummationDelivered,
		currentTier8Block12SummationDelivered,
		currentTier8Block13SummationDelivered,
		currentTier8Block14SummationDelivered,
		currentTier8Block15SummationDelivered,
		currentTier8Block16SummationDelivered,
		// tier 9
		currentTier9Block1SummationDelivered,
		currentTier9Block2SummationDelivered,
		currentTier9Block3SummationDelivered,
		currentTier9Block4SummationDelivered,
		currentTier9Block5SummationDelivered,
		currentTier9Block6SummationDelivered,
		currentTier9Block7SummationDelivered,
		currentTier9Block8SummationDelivered,
		currentTier9Block9SummationDelivered,
		currentTier9Block10SummationDelivered,
		currentTier9Block11SummationDelivered,
		currentTier9Block12SummationDelivered,
		currentTier9Block13SummationDelivered,
		currentTier9Block14SummationDelivered,
		currentTier9Block15SummationDelivered,
		currentTier9Block16SummationDelivered,
		// tier 10
		currentTier10Block1SummationDelivered,
		currentTier10Block2SummationDelivered,
		currentTier10Block3SummationDelivered,
		currentTier10Block4SummationDelivered,
		currentTier10Block5SummationDelivered,
		currentTier10Block6SummationDelivered,
		currentTier10Block7SummationDelivered,
		currentTier10Block8SummationDelivered,
		currentTier10Block9SummationDelivered,
		currentTier10Block10SummationDelivered,
		currentTier10Block11SummationDelivered,
		currentTier10Block12SummationDelivered,
		currentTier10Block13SummationDelivered,
		currentTier10Block14SummationDelivered,
		currentTier10Block15SummationDelivered,
		currentTier10Block16SummationDelivered,
		// tier 11
		currentTier11Block1SummationDelivered,
		currentTier11Block2SummationDelivered,
		currentTier11Block3SummationDelivered,
		currentTier11Block4SummationDelivered,
		currentTier11Block5SummationDelivered,
		currentTier11Block6SummationDelivered,
		currentTier11Block7SummationDelivered,
		currentTier11Block8SummationDelivered,
		currentTier11Block9SummationDelivered,
		currentTier11Block10SummationDelivered,
		currentTier11Block11SummationDelivered,
		currentTier11Block12SummationDelivered,
		currentTier11Block13SummationDelivered,
		currentTier11Block14SummationDelivered,
		currentTier11Block15SummationDelivered,
		currentTier11Block16SummationDelivered,
		// tier 12
		currentTier12Block1SummationDelivered,
		currentTier12Block2SummationDelivered,
		currentTier12Block3SummationDelivered,
		currentTier12Block4SummationDelivered,
		currentTier12Block5SummationDelivered,
		currentTier12Block6SummationDelivered,
		currentTier12Block7SummationDelivered,
		currentTier12Block8SummationDelivered,
		currentTier12Block9SummationDelivered,
		currentTier12Block10SummationDelivered,
		currentTier12Block11SummationDelivered,
		currentTier12Block12SummationDelivered,
		currentTier12Block13SummationDelivered,
		currentTier12Block14SummationDelivered,
		currentTier12Block15SummationDelivered,
		currentTier12Block16SummationDelivered,
		// tier 13
		currentTier13Block1SummationDelivered,
		currentTier13Block2SummationDelivered,
		currentTier13Block3SummationDelivered,
		currentTier13Block4SummationDelivered,
		currentTier13Block5SummationDelivered,
		currentTier13Block6SummationDelivered,
		currentTier13Block7SummationDelivered,
		currentTier13Block8SummationDelivered,
		currentTier13Block9SummationDelivered,
		currentTier13Block10SummationDelivered,
		currentTier13Block11SummationDelivered,
		currentTier13Block12SummationDelivered,
		currentTier13Block13SummationDelivered,
		currentTier13Block14SummationDelivered,
		currentTier13Block15SummationDelivered,
		currentTier13Block16SummationDelivered,
		// tier 14
		currentTier14Block1SummationDelivered,
		currentTier14Block2SummationDelivered,
		currentTier14Block3SummationDelivered,
		currentTier14Block4SummationDelivered,
		currentTier14Block5SummationDelivered,
		currentTier14Block6SummationDelivered,
		currentTier14Block7SummationDelivered,
		currentTier14Block8SummationDelivered,
		currentTier14Block9SummationDelivered,
		currentTier14Block10SummationDelivered,
		currentTier14Block11SummationDelivered,
		currentTier14Block12SummationDelivered,
		currentTier14Block13SummationDelivered,
		currentTier14Block14SummationDelivered,
		currentTier14Block15SummationDelivered,
		currentTier14Block16SummationDelivered,
		// tier 15
		currentTier15Block1SummationDelivered,
		currentTier15Block2SummationDelivered,
		currentTier15Block3SummationDelivered,
		currentTier15Block4SummationDelivered,
		currentTier15Block5SummationDelivered,
		currentTier15Block6SummationDelivered,
		currentTier15Block7SummationDelivered,
		currentTier15Block8SummationDelivered,
		currentTier15Block9SummationDelivered,
		currentTier15Block10SummationDelivered,
		currentTier15Block11SummationDelivered,
		currentTier15Block12SummationDelivered,
		currentTier15Block13SummationDelivered,
		currentTier15Block14SummationDelivered,
		currentTier15Block15SummationDelivered,
		currentTier15Block16SummationDelivered,

		// alarm
		genericAlarmMask,
		electricityAlarmMask,
		genericFlowPressureAlarmMask,
		waterSpecificAlarmMask,
		heatAndCoolingSpecificAlarmMask,
		gasSpecificAlarmMask};
	}

	@Override
	public short getId() {
		return Metering.ID;
	}

	@Override
	public String getName() {
		return Metering.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeCurrentSummationDelivered() {
		return currentSummationDelivered;
	}

	public Attribute getAttributeCurrentSummationReceived() {
		return currentSummationReceived;
	}

	public Attribute getAttributeCurrentMaxDemandDelivered() {
		return currentMaxDemandDelivered;
	}

	public Attribute getAttributeCurrentMaxDemandReceived() {
		return currentMaxDemandReceived;
	}

	public Attribute getAttributeDFTSummation() {
		return dFTSummation;
	}

	public Attribute getAttributeDailyFreezeTime() {
		return dailyFreezeTime;
	}

	public Attribute getAttributePowerFactor() {
		return powerFactor;
	}

	public Attribute getAttributeReadingSnapShotTime() {
		return readingSnapShotTime;
	}

	public Attribute getAttributeCurrentMaxDemandDeliveredTime() {
		return currentMaxDemandDeliveredTime;
	}

	public Attribute getAttributeCurrentMaxDemandReceivedTime() {
		return currentMaxDemandReceivedTime;
	}

	public Attribute getAttributeDefaultUpdatePeriod() {
		return defaultUpdatePeriod;
	}

	public Attribute getAttributeFastPollUpdatePeriod() {
		return fastPollUpdatePeriod;
	}

	public Attribute getAttributeCurrentBlockPeriodConsumptionDelivered() {
		return currentBlockPeriodConsumptionDelivered;
	}

	public Attribute getAttributeDailyConsumptionTarget() {
		return dailyConsumptionTarget;
	}

	public Attribute getAttributeCurrentBlock() {
		return currentBlock;
	}

	public Attribute getAttributeProfileIntervalPeriod() {
		return profileIntervalPeriod;
	}

	public Attribute getAttributeIntervalReadReportingPeriod() {
		return intervalReadReportingPeriod;
	}

	public Attribute getAttributePresetReadingTime() {
		return presetReadingTime;
	}

	public Attribute getAttributeVolumePerReport() {
		return volumePerReport;
	}

	public Attribute getAttributeFlowRestriction() {
		return flowRestriction;
	}

	public Attribute getAttributeSupplyStatus() {
		return supplyStatus;
	}

	public Attribute getAttributeCurrentInletEnergyCarrierSummation() {
		return currentInletEnergyCarrierSummation;
	}

	public Attribute getAttributeCurrentOutletEnergyCarrierSummation() {
		return currentOutletEnergyCarrierSummation;
	}

	public Attribute getAttributeInletTemperature() {
		return inletTemperature;
	}

	public Attribute getAttributeOutletTemperature() {
		return outletTemperature;
	}

	public Attribute getAttributeControlTemperature() {
		return controlTemperature;
	}

	public Attribute getAttributeCurrentInletEnergyCarrierDemand() {
		return currentInletEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentOutletEnergyCarrierDemand() {
		return currentOutletEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentTier1SummationDelivered() {
		return currentTier1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1SummationReceived() {
		return currentTier1SummationReceived;
	}

	public Attribute getAttributeCurrentTier2SummationDelivered() {
		return currentTier2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2SummationReceived() {
		return currentTier2SummationReceived;
	}

	public Attribute getAttributeCurrentTier3SummationDelivered() {
		return currentTier3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3SummationReceived() {
		return currentTier3SummationReceived;
	}

	public Attribute getAttributeCurrentTier4SummationDelivered() {
		return currentTier4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4SummationReceived() {
		return currentTier4SummationReceived;
	}

	public Attribute getAttributeCurrentTier5SummationDelivered() {
		return currentTier5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5SummationReceived() {
		return currentTier5SummationReceived;
	}

	public Attribute getAttributeCurrentTier6SummationDelivered() {
		return currentTier6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6SummationReceived() {
		return currentTier6SummationReceived;
	}

	public Attribute getAttributeCurrentTier7SummationDelivered() {
		return currentTier7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7SummationReceived() {
		return currentTier7SummationReceived;
	}

	public Attribute getAttributeCurrentTier8SummationDelivered() {
		return currentTier8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8SummationReceived() {
		return currentTier8SummationReceived;
	}

	public Attribute getAttributeCurrentTier9SummationDelivered() {
		return currentTier9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9SummationReceived() {
		return currentTier9SummationReceived;
	}

	public Attribute getAttributeCurrentTier10SummationDelivered() {
		return currentTier10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10SummationReceived() {
		return currentTier10SummationReceived;
	}

	public Attribute getAttributeCurrentTier11SummationDelivered() {
		return currentTier11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11SummationReceived() {
		return currentTier11SummationReceived;
	}

	public Attribute getAttributeCurrentTier12SummationDelivered() {
		return currentTier12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12SummationReceived() {
		return currentTier12SummationReceived;
	}

	public Attribute getAttributeCurrentTier13SummationDelivered() {
		return currentTier13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13SummationReceived() {
		return currentTier13SummationReceived;
	}

	public Attribute getAttributeCurrentTier14SummationDelivered() {
		return currentTier14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14SummationReceived() {
		return currentTier14SummationReceived;
	}

	public Attribute getAttributeCurrentTier15SummationDelivered() {
		return currentTier15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15SummationReceived() {
		return currentTier15SummationReceived;
	}

	public Attribute getAttributeStatus() {
		return status;
	}

	public Attribute getAttributeRemainingBatteryLife() {
		return remainingBatteryLife;
	}

	public Attribute getAttributeHoursInOperation() {
		return hoursInOperation;
	}

	public Attribute getAttributeHoursInFault() {
		return hoursInFault;
	}

	public Attribute getAttributeUnitOfMeasure() {
		return unitOfMeasure;
	}

	public Attribute getAttributeMultiplier() {
		return multiplier;
	}

	public Attribute getAttributeDivisor() {
		return divisor;
	}

	public Attribute getAttributeSummationFormatting() {
		return summationFormatting;
	}

	public Attribute getAttributeDemandFormatting() {
		return demandFormatting;
	}

	public Attribute getAttributeHistoricalConsumptionFormatting() {
		return historicalConsumptionFormatting;
	}

	public Attribute getAttributeMeteringDeviceType() {
		return meteringDeviceType;
	}

	public Attribute getAttributeSiteID() {
		return siteID;
	}

	public Attribute getAttributeMeterSerialNumber() {
		return meterSerialNumber;
	}

	public Attribute getAttributeEnergyCarrierUnitOfMeasure() {
		return energyCarrierUnitOfMeasure;
	}

	public Attribute getAttributeEnergyCarrierSummationFormatting() {
		return energyCarrierSummationFormatting;
	}

	public Attribute getAttributeEnergyCarrierDemandFormatting() {
		return energyCarrierDemandFormatting;
	}

	public Attribute getAttributeTemperatureUnitOfMeasure() {
		return temperatureUnitOfMeasure;
	}

	public Attribute getAttributeTemperatureFormatting() {
		return temperatureFormatting;
	}

	public Attribute getAttributeInstantaneousDemand() {
		return instantaneousDemand;
	}

	public Attribute getAttributeCurrentDayConsumptionDelivered() {
		return currentDayConsumptionDelivered;
	}

	public Attribute getAttributeCurrentDayConsumptionReceived() {
		return currentDayConsumptionReceived;
	}

	public Attribute getAttributePreviousDayConsumptionDelivered() {
		return previousDayConsumptionDelivered;
	}

	public Attribute getAttributePreviousDayConsumptionReceived() {
		return previousDayConsumptionReceived;
	}

	public Attribute getAttributeCurrentPartialProfileIntervalStartTimeDelivered() {
		return currentPartialProfileIntervalStartTimeDelivered;
	}

	public Attribute getAttributeCurrentPartialProfileIntervalStartTimeReceived() {
		return currentPartialProfileIntervalStartTimeReceived;
	}

	public Attribute getAttributeCurrentPartialProfileIntervalValueDelivered() {
		return currentPartialProfileIntervalValueDelivered;
	}

	public Attribute getAttributeCurrentPartialProfileIntervalValueReceived() {
		return currentPartialProfileIntervalValueReceived;
	}

	public Attribute getAttributeCurrentDayMaxPressure() {
		return currentDayMaxPressure;
	}

	public Attribute getAttributeCurrentDayMinPressure() {
		return currentDayMinPressure;
	}

	public Attribute getAttributePreviousDayMaxPressure() {
		return previousDayMaxPressure;
	}

	public Attribute getAttributePreviousDayMinPressure() {
		return previousDayMinPressure;
	}

	public Attribute getAttributeCurrentDayMaxDemand() {
		return currentDayMaxDemand;
	}

	public Attribute getAttributePreviousDayMaxDemand() {
		return previousDayMaxDemand;
	}

	public Attribute getAttributeCurrentMonthMaxDemand() {
		return currentMonthMaxDemand;
	}

	public Attribute getAttributeCurrentYearMaxDemand() {
		return currentYearMaxDemand;
	}

	public Attribute getAttributeCurrentDayMaxEnergyCarrierDemand() {
		return currentDayMaxEnergyCarrierDemand;
	}

	public Attribute getAttributePreviousDayMaxEnergyCarrierDemand() {
		return previousDayMaxEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentMonthMaxEnergyCarrierDemand() {
		return currentMonthMaxEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentMonthMinEnergyCarrierDemand() {
		return currentMonthMinEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentYearMaxEnergyCarrierDemand() {
		return currentYearMaxEnergyCarrierDemand;
	}

	public Attribute getAttributeCurrentYearMinEnergyCarrierDemand() {
		return currentYearMinEnergyCarrierDemand;
	}

	public Attribute getAttributeMaxNumberOfPeriodsDelivered() {
		return maxNumberOfPeriodsDelivered;
	}

	public Attribute getAttributeCurrentDemandDelivered() {
		return currentDemandDelivered;
	}

	public Attribute getAttributeDemandLimit() {
		return demandLimit;
	}

	public Attribute getAttributeDemandIntegrationPeriod() {
		return demandIntegrationPeriod;
	}

	public Attribute getAttributeNumberOfDemandAndSubintervals() {
		return numberOfDemandAndSubintervals;
	}

	public Attribute getAttributeGenericAlarmMask() {
		return genericAlarmMask;
	}

	public Attribute getAttributeElectricityAlarmMask() {
		return electricityAlarmMask;
	}

	public Attribute getAttributeGenericFlowPressureAlarmMask() {
		return genericFlowPressureAlarmMask;
	}

	public Attribute getAttributeWaterSpecificAlarmMask() {
		return waterSpecificAlarmMask;
	}

	public Attribute getAttributeHeatAndCoolingSpecificAlarmMask() {
		return heatAndCoolingSpecificAlarmMask;
	}

	public Attribute getAttributeGasSpecificAlarmMask() {
		return gasSpecificAlarmMask;
	}

	public Attribute getAttributeCurrentNoTierBlock1SummationDelivered() {
		return currentNoTierBlock1SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock2SummationDelivered() {
		return currentNoTierBlock2SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock3SummationDelivered() {
		return currentNoTierBlock3SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock4SummationDelivered() {
		return currentNoTierBlock4SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock5SummationDelivered() {
		return currentNoTierBlock5SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock6SummationDelivered() {
		return currentNoTierBlock6SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock7SummationDelivered() {
		return currentNoTierBlock7SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock8SummationDelivered() {
		return currentNoTierBlock8SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock9SummationDelivered() {
		return currentNoTierBlock9SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock10SummationDelivered() {
		return currentNoTierBlock10SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock11SummationDelivered() {
		return currentNoTierBlock11SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock12SummationDelivered() {
		return currentNoTierBlock12SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock13SummationDelivered() {
		return currentNoTierBlock13SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock14SummationDelivered() {
		return currentNoTierBlock14SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock15SummationDelivered() {
		return currentNoTierBlock15SummationDelivered;
	}

	public Attribute getAttributeCurrentNoTierBlock16SummationDelivered() {
		return currentNoTierBlock16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block1SummationDelivered() {
		return currentTier1Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block2SummationDelivered() {
		return currentTier1Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block3SummationDelivered() {
		return currentTier1Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block4SummationDelivered() {
		return currentTier1Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block5SummationDelivered() {
		return currentTier1Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block6SummationDelivered() {
		return currentTier1Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block7SummationDelivered() {
		return currentTier1Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block8SummationDelivered() {
		return currentTier1Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block9SummationDelivered() {
		return currentTier1Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block10SummationDelivered() {
		return currentTier1Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block11SummationDelivered() {
		return currentTier1Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block12SummationDelivered() {
		return currentTier1Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block13SummationDelivered() {
		return currentTier1Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block14SummationDelivered() {
		return currentTier1Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block15SummationDelivered() {
		return currentTier1Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier1Block16SummationDelivered() {
		return currentTier1Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block1SummationDelivered() {
		return currentTier2Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block2SummationDelivered() {
		return currentTier2Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block3SummationDelivered() {
		return currentTier2Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block4SummationDelivered() {
		return currentTier2Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block5SummationDelivered() {
		return currentTier2Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block6SummationDelivered() {
		return currentTier2Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block7SummationDelivered() {
		return currentTier2Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block8SummationDelivered() {
		return currentTier2Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block9SummationDelivered() {
		return currentTier2Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block10SummationDelivered() {
		return currentTier2Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block11SummationDelivered() {
		return currentTier2Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block12SummationDelivered() {
		return currentTier2Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block13SummationDelivered() {
		return currentTier2Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block14SummationDelivered() {
		return currentTier2Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block15SummationDelivered() {
		return currentTier2Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier2Block16SummationDelivered() {
		return currentTier2Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block1SummationDelivered() {
		return currentTier3Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block2SummationDelivered() {
		return currentTier3Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block3SummationDelivered() {
		return currentTier3Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block4SummationDelivered() {
		return currentTier3Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block5SummationDelivered() {
		return currentTier3Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block6SummationDelivered() {
		return currentTier3Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block7SummationDelivered() {
		return currentTier3Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block8SummationDelivered() {
		return currentTier3Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block9SummationDelivered() {
		return currentTier3Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block10SummationDelivered() {
		return currentTier3Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block11SummationDelivered() {
		return currentTier3Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block12SummationDelivered() {
		return currentTier3Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block13SummationDelivered() {
		return currentTier3Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block14SummationDelivered() {
		return currentTier3Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block15SummationDelivered() {
		return currentTier3Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier3Block16SummationDelivered() {
		return currentTier3Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block1SummationDelivered() {
		return currentTier4Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block2SummationDelivered() {
		return currentTier4Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block3SummationDelivered() {
		return currentTier4Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block4SummationDelivered() {
		return currentTier4Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block5SummationDelivered() {
		return currentTier4Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block6SummationDelivered() {
		return currentTier4Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block7SummationDelivered() {
		return currentTier4Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block8SummationDelivered() {
		return currentTier4Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block9SummationDelivered() {
		return currentTier4Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block10SummationDelivered() {
		return currentTier4Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block11SummationDelivered() {
		return currentTier4Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block12SummationDelivered() {
		return currentTier4Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block13SummationDelivered() {
		return currentTier4Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block14SummationDelivered() {
		return currentTier4Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block15SummationDelivered() {
		return currentTier4Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier4Block16SummationDelivered() {
		return currentTier4Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block1SummationDelivered() {
		return currentTier5Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block2SummationDelivered() {
		return currentTier5Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block3SummationDelivered() {
		return currentTier5Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block4SummationDelivered() {
		return currentTier5Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block5SummationDelivered() {
		return currentTier5Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block6SummationDelivered() {
		return currentTier5Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block7SummationDelivered() {
		return currentTier5Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block8SummationDelivered() {
		return currentTier5Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block9SummationDelivered() {
		return currentTier5Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block10SummationDelivered() {
		return currentTier5Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block11SummationDelivered() {
		return currentTier5Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block12SummationDelivered() {
		return currentTier5Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block13SummationDelivered() {
		return currentTier5Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block14SummationDelivered() {
		return currentTier5Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block15SummationDelivered() {
		return currentTier5Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier5Block16SummationDelivered() {
		return currentTier5Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block1SummationDelivered() {
		return currentTier6Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block2SummationDelivered() {
		return currentTier6Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block3SummationDelivered() {
		return currentTier6Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block4SummationDelivered() {
		return currentTier6Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block5SummationDelivered() {
		return currentTier6Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block6SummationDelivered() {
		return currentTier6Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block7SummationDelivered() {
		return currentTier6Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block8SummationDelivered() {
		return currentTier6Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block9SummationDelivered() {
		return currentTier6Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block10SummationDelivered() {
		return currentTier6Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block11SummationDelivered() {
		return currentTier6Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block12SummationDelivered() {
		return currentTier6Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block13SummationDelivered() {
		return currentTier6Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block14SummationDelivered() {
		return currentTier6Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block15SummationDelivered() {
		return currentTier6Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier6Block16SummationDelivered() {
		return currentTier6Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block1SummationDelivered() {
		return currentTier7Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block2SummationDelivered() {
		return currentTier7Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block3SummationDelivered() {
		return currentTier7Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block4SummationDelivered() {
		return currentTier7Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block5SummationDelivered() {
		return currentTier7Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block6SummationDelivered() {
		return currentTier7Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block7SummationDelivered() {
		return currentTier7Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block8SummationDelivered() {
		return currentTier7Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block9SummationDelivered() {
		return currentTier7Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block10SummationDelivered() {
		return currentTier7Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block11SummationDelivered() {
		return currentTier7Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block12SummationDelivered() {
		return currentTier7Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block13SummationDelivered() {
		return currentTier7Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block14SummationDelivered() {
		return currentTier7Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block15SummationDelivered() {
		return currentTier7Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier7Block16SummationDelivered() {
		return currentTier7Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block1SummationDelivered() {
		return currentTier8Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block2SummationDelivered() {
		return currentTier8Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block3SummationDelivered() {
		return currentTier8Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block4SummationDelivered() {
		return currentTier8Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block5SummationDelivered() {
		return currentTier8Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block6SummationDelivered() {
		return currentTier8Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block7SummationDelivered() {
		return currentTier8Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block8SummationDelivered() {
		return currentTier8Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block9SummationDelivered() {
		return currentTier8Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block10SummationDelivered() {
		return currentTier8Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block11SummationDelivered() {
		return currentTier8Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block12SummationDelivered() {
		return currentTier8Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block13SummationDelivered() {
		return currentTier8Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block14SummationDelivered() {
		return currentTier8Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block15SummationDelivered() {
		return currentTier8Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier8Block16SummationDelivered() {
		return currentTier8Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block1SummationDelivered() {
		return currentTier9Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block2SummationDelivered() {
		return currentTier9Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block3SummationDelivered() {
		return currentTier9Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block4SummationDelivered() {
		return currentTier9Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block5SummationDelivered() {
		return currentTier9Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block6SummationDelivered() {
		return currentTier9Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block7SummationDelivered() {
		return currentTier9Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block8SummationDelivered() {
		return currentTier9Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block9SummationDelivered() {
		return currentTier9Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block10SummationDelivered() {
		return currentTier9Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block11SummationDelivered() {
		return currentTier9Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block12SummationDelivered() {
		return currentTier9Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block13SummationDelivered() {
		return currentTier9Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block14SummationDelivered() {
		return currentTier9Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block15SummationDelivered() {
		return currentTier9Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier9Block16SummationDelivered() {
		return currentTier9Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block1SummationDelivered() {
		return currentTier10Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block2SummationDelivered() {
		return currentTier10Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block3SummationDelivered() {
		return currentTier10Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block4SummationDelivered() {
		return currentTier10Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block5SummationDelivered() {
		return currentTier10Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block6SummationDelivered() {
		return currentTier10Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block7SummationDelivered() {
		return currentTier10Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block8SummationDelivered() {
		return currentTier10Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block9SummationDelivered() {
		return currentTier10Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block10SummationDelivered() {
		return currentTier10Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block11SummationDelivered() {
		return currentTier10Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block12SummationDelivered() {
		return currentTier10Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block13SummationDelivered() {
		return currentTier10Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block14SummationDelivered() {
		return currentTier10Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block15SummationDelivered() {
		return currentTier10Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier10Block16SummationDelivered() {
		return currentTier10Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block1SummationDelivered() {
		return currentTier11Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block2SummationDelivered() {
		return currentTier11Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block3SummationDelivered() {
		return currentTier11Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block4SummationDelivered() {
		return currentTier11Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block5SummationDelivered() {
		return currentTier11Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block6SummationDelivered() {
		return currentTier11Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block7SummationDelivered() {
		return currentTier11Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block8SummationDelivered() {
		return currentTier11Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block9SummationDelivered() {
		return currentTier11Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block10SummationDelivered() {
		return currentTier11Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block11SummationDelivered() {
		return currentTier11Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block12SummationDelivered() {
		return currentTier11Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block13SummationDelivered() {
		return currentTier11Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block14SummationDelivered() {
		return currentTier11Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block15SummationDelivered() {
		return currentTier11Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier11Block16SummationDelivered() {
		return currentTier11Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block1SummationDelivered() {
		return currentTier12Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block2SummationDelivered() {
		return currentTier12Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block3SummationDelivered() {
		return currentTier12Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block4SummationDelivered() {
		return currentTier12Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block5SummationDelivered() {
		return currentTier12Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block6SummationDelivered() {
		return currentTier12Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block7SummationDelivered() {
		return currentTier12Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block8SummationDelivered() {
		return currentTier12Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block9SummationDelivered() {
		return currentTier12Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block10SummationDelivered() {
		return currentTier12Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block11SummationDelivered() {
		return currentTier12Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block12SummationDelivered() {
		return currentTier12Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block13SummationDelivered() {
		return currentTier12Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block14SummationDelivered() {
		return currentTier12Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block15SummationDelivered() {
		return currentTier12Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier12Block16SummationDelivered() {
		return currentTier12Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block1SummationDelivered() {
		return currentTier13Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block2SummationDelivered() {
		return currentTier13Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block3SummationDelivered() {
		return currentTier13Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block4SummationDelivered() {
		return currentTier13Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block5SummationDelivered() {
		return currentTier13Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block6SummationDelivered() {
		return currentTier13Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block7SummationDelivered() {
		return currentTier13Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block8SummationDelivered() {
		return currentTier13Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block9SummationDelivered() {
		return currentTier13Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block10SummationDelivered() {
		return currentTier13Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block11SummationDelivered() {
		return currentTier13Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block12SummationDelivered() {
		return currentTier13Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block13SummationDelivered() {
		return currentTier13Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block14SummationDelivered() {
		return currentTier13Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block15SummationDelivered() {
		return currentTier13Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier13Block16SummationDelivered() {
		return currentTier13Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block1SummationDelivered() {
		return currentTier14Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block2SummationDelivered() {
		return currentTier14Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block3SummationDelivered() {
		return currentTier14Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block4SummationDelivered() {
		return currentTier14Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block5SummationDelivered() {
		return currentTier14Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block6SummationDelivered() {
		return currentTier14Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block7SummationDelivered() {
		return currentTier14Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block8SummationDelivered() {
		return currentTier14Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block9SummationDelivered() {
		return currentTier14Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block10SummationDelivered() {
		return currentTier14Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block11SummationDelivered() {
		return currentTier14Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block12SummationDelivered() {
		return currentTier14Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block13SummationDelivered() {
		return currentTier14Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block14SummationDelivered() {
		return currentTier14Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block15SummationDelivered() {
		return currentTier14Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier14Block16SummationDelivered() {
		return currentTier14Block16SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block1SummationDelivered() {
		return currentTier15Block1SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block2SummationDelivered() {
		return currentTier15Block2SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block3SummationDelivered() {
		return currentTier15Block3SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block4SummationDelivered() {
		return currentTier15Block4SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block5SummationDelivered() {
		return currentTier15Block5SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block6SummationDelivered() {
		return currentTier15Block6SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block7SummationDelivered() {
		return currentTier15Block7SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block8SummationDelivered() {
		return currentTier15Block8SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block9SummationDelivered() {
		return currentTier15Block9SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block10SummationDelivered() {
		return currentTier15Block10SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block11SummationDelivered() {
		return currentTier15Block11SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block12SummationDelivered() {
		return currentTier15Block12SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block13SummationDelivered() {
		return currentTier15Block13SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block14SummationDelivered() {
		return currentTier15Block14SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block15SummationDelivered() {
		return currentTier15Block15SummationDelivered;
	}

	public Attribute getAttributeCurrentTier15Block16SummationDelivered() {
		return currentTier15Block16SummationDelivered;
	}

}
