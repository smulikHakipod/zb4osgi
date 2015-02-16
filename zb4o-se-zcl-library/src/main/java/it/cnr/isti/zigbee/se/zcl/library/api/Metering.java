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

package it.cnr.isti.zigbee.se.zcl.library.api;

import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;

/**
 * This class represent the <b>Metering</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05 +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public interface Metering extends ZCLCluster {
	
	public static final short  ID = 0x0702;
	static final String NAME = "Metering";
	static final String DESCRIPTION = "Mechanism to retrieve usage information from Electric, Gas, Water and potentially metering devices";
	
	//reading information
	public Attribute getAttributeCurrentSummationDelivered();
	public Attribute getAttributeCurrentSummationReceived();
	public Attribute getAttributeCurrentMaxDemandDelivered();
	public Attribute getAttributeCurrentMaxDemandReceived();
	public Attribute getAttributeDFTSummation();
	public Attribute getAttributeDailyFreezeTime();
	public Attribute getAttributePowerFactor();
	public Attribute getAttributeReadingSnapShotTime();
	public Attribute getAttributeCurrentMaxDemandDeliveredTime();
	public Attribute getAttributeCurrentMaxDemandReceivedTime();
	public Attribute getAttributeDefaultUpdatePeriod();
	public Attribute getAttributeFastPollUpdatePeriod();
	public Attribute getAttributeCurrentBlockPeriodConsumptionDelivered();
	public Attribute getAttributeDailyConsumptionTarget();
	public Attribute getAttributeCurrentBlock();
	public Attribute getAttributeProfileIntervalPeriod();
	public Attribute getAttributeIntervalReadReportingPeriod();
	public Attribute getAttributePresetReadingTime();
	public Attribute getAttributeVolumePerReport();
	public Attribute getAttributeFlowRestriction();
	public Attribute getAttributeSupplyStatus();
	public Attribute getAttributeCurrentInletEnergyCarrierSummation();
	public Attribute getAttributeCurrentOutletEnergyCarrierSummation();
	public Attribute getAttributeInletTemperature();
	public Attribute getAttributeOutletTemperature();
	public Attribute getAttributeControlTemperature();
	public Attribute getAttributeCurrentInletEnergyCarrierDemand();
	public Attribute getAttributeCurrentOutletEnergyCarrierDemand();	
	//TOU information set
	public Attribute getAttributeCurrentTier1SummationDelivered();
	public Attribute getAttributeCurrentTier1SummationReceived();
	public Attribute getAttributeCurrentTier2SummationDelivered();
	public Attribute getAttributeCurrentTier2SummationReceived();
	public Attribute getAttributeCurrentTier3SummationDelivered();
	public Attribute getAttributeCurrentTier3SummationReceived();
	public Attribute getAttributeCurrentTier4SummationDelivered();
	public Attribute getAttributeCurrentTier4SummationReceived();
	public Attribute getAttributeCurrentTier5SummationDelivered();
	public Attribute getAttributeCurrentTier5SummationReceived();
	public Attribute getAttributeCurrentTier6SummationDelivered();
	public Attribute getAttributeCurrentTier6SummationReceived();
	public Attribute getAttributeCurrentTier7SummationDelivered();
	public Attribute getAttributeCurrentTier7SummationReceived();
	public Attribute getAttributeCurrentTier8SummationDelivered();
	public Attribute getAttributeCurrentTier8SummationReceived();
	public Attribute getAttributeCurrentTier9SummationDelivered();
	public Attribute getAttributeCurrentTier9SummationReceived();
	public Attribute getAttributeCurrentTier10SummationDelivered();
	public Attribute getAttributeCurrentTier10SummationReceived();
	public Attribute getAttributeCurrentTier11SummationDelivered();
	public Attribute getAttributeCurrentTier11SummationReceived();
	public Attribute getAttributeCurrentTier12SummationDelivered();
	public Attribute getAttributeCurrentTier12SummationReceived();
	public Attribute getAttributeCurrentTier13SummationDelivered();
	public Attribute getAttributeCurrentTier13SummationReceived();
	public Attribute getAttributeCurrentTier14SummationDelivered();
	public Attribute getAttributeCurrentTier14SummationReceived();
	public Attribute getAttributeCurrentTier15SummationDelivered();
	public Attribute getAttributeCurrentTier15SummationReceived();
	//meter status
	public Attribute getAttributeStatus();
	public Attribute getAttributeRemainingBatteryLife();
	public Attribute getAttributeHoursInOperation();
	public Attribute getAttributeHoursInFault();
	//formatting	
	public Attribute getAttributeUnitOfMeasure();
	public Attribute getAttributeMultiplier();
	public Attribute getAttributeDivisor();
	public Attribute getAttributeSummationFormatting();
	public Attribute getAttributeDemandFormatting();
	public Attribute getAttributeHistoricalConsumptionFormatting();
	public Attribute getAttributeMeteringDeviceType();
	public Attribute getAttributeSiteID();
	public Attribute getAttributeMeterSerialNumber();
	public Attribute getAttributeEnergyCarrierUnitOfMeasure();
	public Attribute getAttributeEnergyCarrierSummationFormatting();
	public Attribute getAttributeEnergyCarrierDemandFormatting();
	public Attribute getAttributeTemperatureUnitOfMeasure();
	public Attribute getAttributeTemperatureFormatting();
	//historical	
	public Attribute getAttributeInstantaneousDemand();
	public Attribute getAttributeCurrentDayConsumptionDelivered();
	public Attribute getAttributeCurrentDayConsumptionReceived();
	public Attribute getAttributePreviousDayConsumptionDelivered();
	public Attribute getAttributePreviousDayConsumptionReceived();
	public Attribute getAttributeCurrentPartialProfileIntervalStartTimeDelivered();
	public Attribute getAttributeCurrentPartialProfileIntervalStartTimeReceived();
	public Attribute getAttributeCurrentPartialProfileIntervalValueDelivered();
	public Attribute getAttributeCurrentPartialProfileIntervalValueReceived();
	public Attribute getAttributeCurrentDayMaxPressure();
	public Attribute getAttributeCurrentDayMinPressure();
	public Attribute getAttributePreviousDayMaxPressure();
	public Attribute getAttributePreviousDayMinPressure();
	public Attribute getAttributeCurrentDayMaxDemand();
	public Attribute getAttributePreviousDayMaxDemand();
	public Attribute getAttributeCurrentMonthMaxDemand();
	public Attribute getAttributeCurrentYearMaxDemand();
	public Attribute getAttributeCurrentDayMaxEnergyCarrierDemand();
	public Attribute getAttributePreviousDayMaxEnergyCarrierDemand();
	public Attribute getAttributeCurrentMonthMaxEnergyCarrierDemand();
	public Attribute getAttributeCurrentMonthMinEnergyCarrierDemand();
	public Attribute getAttributeCurrentYearMaxEnergyCarrierDemand();
	public Attribute getAttributeCurrentYearMinEnergyCarrierDemand();
	//load
	public Attribute getAttributeMaxNumberOfPeriodsDelivered();
	//supply limit	
	public Attribute getAttributeCurrentDemandDelivered();
	public Attribute getAttributeDemandLimit();
	public Attribute getAttributeDemandIntegrationPeriod();
	public Attribute getAttributeNumberOfDemandAndSubintervals();
	//block
	public Attribute getAttributeCurrentNoTierBlock1SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock2SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock3SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock4SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock5SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock6SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock7SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock8SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock9SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock10SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock11SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock12SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock13SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock14SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock15SummationDelivered();
	public Attribute getAttributeCurrentNoTierBlock16SummationDelivered();
	
	public Attribute getAttributeCurrentTier1Block1SummationDelivered();
	public Attribute getAttributeCurrentTier1Block2SummationDelivered();
	public Attribute getAttributeCurrentTier1Block3SummationDelivered();
	public Attribute getAttributeCurrentTier1Block4SummationDelivered();
	public Attribute getAttributeCurrentTier1Block5SummationDelivered();
	public Attribute getAttributeCurrentTier1Block6SummationDelivered();
	public Attribute getAttributeCurrentTier1Block7SummationDelivered();
	public Attribute getAttributeCurrentTier1Block8SummationDelivered();
	public Attribute getAttributeCurrentTier1Block9SummationDelivered();
	public Attribute getAttributeCurrentTier1Block10SummationDelivered();
	public Attribute getAttributeCurrentTier1Block11SummationDelivered();
	public Attribute getAttributeCurrentTier1Block12SummationDelivered();
	public Attribute getAttributeCurrentTier1Block13SummationDelivered();
	public Attribute getAttributeCurrentTier1Block14SummationDelivered();
	public Attribute getAttributeCurrentTier1Block15SummationDelivered();
	public Attribute getAttributeCurrentTier1Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier2Block1SummationDelivered();
	public Attribute getAttributeCurrentTier2Block2SummationDelivered();
	public Attribute getAttributeCurrentTier2Block3SummationDelivered();
	public Attribute getAttributeCurrentTier2Block4SummationDelivered();
	public Attribute getAttributeCurrentTier2Block5SummationDelivered();
	public Attribute getAttributeCurrentTier2Block6SummationDelivered();
	public Attribute getAttributeCurrentTier2Block7SummationDelivered();
	public Attribute getAttributeCurrentTier2Block8SummationDelivered();
	public Attribute getAttributeCurrentTier2Block9SummationDelivered();
	public Attribute getAttributeCurrentTier2Block10SummationDelivered();
	public Attribute getAttributeCurrentTier2Block11SummationDelivered();
	public Attribute getAttributeCurrentTier2Block12SummationDelivered();
	public Attribute getAttributeCurrentTier2Block13SummationDelivered();
	public Attribute getAttributeCurrentTier2Block14SummationDelivered();
	public Attribute getAttributeCurrentTier2Block15SummationDelivered();
	public Attribute getAttributeCurrentTier2Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier3Block1SummationDelivered();
	public Attribute getAttributeCurrentTier3Block2SummationDelivered();
	public Attribute getAttributeCurrentTier3Block3SummationDelivered();
	public Attribute getAttributeCurrentTier3Block4SummationDelivered();
	public Attribute getAttributeCurrentTier3Block5SummationDelivered();
	public Attribute getAttributeCurrentTier3Block6SummationDelivered();
	public Attribute getAttributeCurrentTier3Block7SummationDelivered();
	public Attribute getAttributeCurrentTier3Block8SummationDelivered();
	public Attribute getAttributeCurrentTier3Block9SummationDelivered();
	public Attribute getAttributeCurrentTier3Block10SummationDelivered();
	public Attribute getAttributeCurrentTier3Block11SummationDelivered();
	public Attribute getAttributeCurrentTier3Block12SummationDelivered();
	public Attribute getAttributeCurrentTier3Block13SummationDelivered();
	public Attribute getAttributeCurrentTier3Block14SummationDelivered();
	public Attribute getAttributeCurrentTier3Block15SummationDelivered();
	public Attribute getAttributeCurrentTier3Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier4Block1SummationDelivered();
	public Attribute getAttributeCurrentTier4Block2SummationDelivered();
	public Attribute getAttributeCurrentTier4Block3SummationDelivered();
	public Attribute getAttributeCurrentTier4Block4SummationDelivered();
	public Attribute getAttributeCurrentTier4Block5SummationDelivered();
	public Attribute getAttributeCurrentTier4Block6SummationDelivered();
	public Attribute getAttributeCurrentTier4Block7SummationDelivered();
	public Attribute getAttributeCurrentTier4Block8SummationDelivered();
	public Attribute getAttributeCurrentTier4Block9SummationDelivered();
	public Attribute getAttributeCurrentTier4Block10SummationDelivered();
	public Attribute getAttributeCurrentTier4Block11SummationDelivered();
	public Attribute getAttributeCurrentTier4Block12SummationDelivered();
	public Attribute getAttributeCurrentTier4Block13SummationDelivered();
	public Attribute getAttributeCurrentTier4Block14SummationDelivered();
	public Attribute getAttributeCurrentTier4Block15SummationDelivered();
	public Attribute getAttributeCurrentTier4Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier5Block1SummationDelivered();
	public Attribute getAttributeCurrentTier5Block2SummationDelivered();
	public Attribute getAttributeCurrentTier5Block3SummationDelivered();
	public Attribute getAttributeCurrentTier5Block4SummationDelivered();
	public Attribute getAttributeCurrentTier5Block5SummationDelivered();
	public Attribute getAttributeCurrentTier5Block6SummationDelivered();
	public Attribute getAttributeCurrentTier5Block7SummationDelivered();
	public Attribute getAttributeCurrentTier5Block8SummationDelivered();
	public Attribute getAttributeCurrentTier5Block9SummationDelivered();
	public Attribute getAttributeCurrentTier5Block10SummationDelivered();
	public Attribute getAttributeCurrentTier5Block11SummationDelivered();
	public Attribute getAttributeCurrentTier5Block12SummationDelivered();
	public Attribute getAttributeCurrentTier5Block13SummationDelivered();
	public Attribute getAttributeCurrentTier5Block14SummationDelivered();
	public Attribute getAttributeCurrentTier5Block15SummationDelivered();
	public Attribute getAttributeCurrentTier5Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier6Block1SummationDelivered();
	public Attribute getAttributeCurrentTier6Block2SummationDelivered();
	public Attribute getAttributeCurrentTier6Block3SummationDelivered();
	public Attribute getAttributeCurrentTier6Block4SummationDelivered();
	public Attribute getAttributeCurrentTier6Block5SummationDelivered();
	public Attribute getAttributeCurrentTier6Block6SummationDelivered();
	public Attribute getAttributeCurrentTier6Block7SummationDelivered();
	public Attribute getAttributeCurrentTier6Block8SummationDelivered();
	public Attribute getAttributeCurrentTier6Block9SummationDelivered();
	public Attribute getAttributeCurrentTier6Block10SummationDelivered();
	public Attribute getAttributeCurrentTier6Block11SummationDelivered();
	public Attribute getAttributeCurrentTier6Block12SummationDelivered();
	public Attribute getAttributeCurrentTier6Block13SummationDelivered();
	public Attribute getAttributeCurrentTier6Block14SummationDelivered();
	public Attribute getAttributeCurrentTier6Block15SummationDelivered();
	public Attribute getAttributeCurrentTier6Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier7Block1SummationDelivered();
	public Attribute getAttributeCurrentTier7Block2SummationDelivered();
	public Attribute getAttributeCurrentTier7Block3SummationDelivered();
	public Attribute getAttributeCurrentTier7Block4SummationDelivered();
	public Attribute getAttributeCurrentTier7Block5SummationDelivered();
	public Attribute getAttributeCurrentTier7Block6SummationDelivered();
	public Attribute getAttributeCurrentTier7Block7SummationDelivered();
	public Attribute getAttributeCurrentTier7Block8SummationDelivered();
	public Attribute getAttributeCurrentTier7Block9SummationDelivered();
	public Attribute getAttributeCurrentTier7Block10SummationDelivered();
	public Attribute getAttributeCurrentTier7Block11SummationDelivered();
	public Attribute getAttributeCurrentTier7Block12SummationDelivered();
	public Attribute getAttributeCurrentTier7Block13SummationDelivered();
	public Attribute getAttributeCurrentTier7Block14SummationDelivered();
	public Attribute getAttributeCurrentTier7Block15SummationDelivered();
	public Attribute getAttributeCurrentTier7Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier8Block1SummationDelivered();
	public Attribute getAttributeCurrentTier8Block2SummationDelivered();
	public Attribute getAttributeCurrentTier8Block3SummationDelivered();
	public Attribute getAttributeCurrentTier8Block4SummationDelivered();
	public Attribute getAttributeCurrentTier8Block5SummationDelivered();
	public Attribute getAttributeCurrentTier8Block6SummationDelivered();
	public Attribute getAttributeCurrentTier8Block7SummationDelivered();
	public Attribute getAttributeCurrentTier8Block8SummationDelivered();
	public Attribute getAttributeCurrentTier8Block9SummationDelivered();
	public Attribute getAttributeCurrentTier8Block10SummationDelivered();
	public Attribute getAttributeCurrentTier8Block11SummationDelivered();
	public Attribute getAttributeCurrentTier8Block12SummationDelivered();
	public Attribute getAttributeCurrentTier8Block13SummationDelivered();
	public Attribute getAttributeCurrentTier8Block14SummationDelivered();
	public Attribute getAttributeCurrentTier8Block15SummationDelivered();
	public Attribute getAttributeCurrentTier8Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier9Block1SummationDelivered();
	public Attribute getAttributeCurrentTier9Block2SummationDelivered();
	public Attribute getAttributeCurrentTier9Block3SummationDelivered();
	public Attribute getAttributeCurrentTier9Block4SummationDelivered();
	public Attribute getAttributeCurrentTier9Block5SummationDelivered();
	public Attribute getAttributeCurrentTier9Block6SummationDelivered();
	public Attribute getAttributeCurrentTier9Block7SummationDelivered();
	public Attribute getAttributeCurrentTier9Block8SummationDelivered();
	public Attribute getAttributeCurrentTier9Block9SummationDelivered();
	public Attribute getAttributeCurrentTier9Block10SummationDelivered();
	public Attribute getAttributeCurrentTier9Block11SummationDelivered();
	public Attribute getAttributeCurrentTier9Block12SummationDelivered();
	public Attribute getAttributeCurrentTier9Block13SummationDelivered();
	public Attribute getAttributeCurrentTier9Block14SummationDelivered();
	public Attribute getAttributeCurrentTier9Block15SummationDelivered();
	public Attribute getAttributeCurrentTier9Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier10Block1SummationDelivered();
	public Attribute getAttributeCurrentTier10Block2SummationDelivered();
	public Attribute getAttributeCurrentTier10Block3SummationDelivered();
	public Attribute getAttributeCurrentTier10Block4SummationDelivered();
	public Attribute getAttributeCurrentTier10Block5SummationDelivered();
	public Attribute getAttributeCurrentTier10Block6SummationDelivered();
	public Attribute getAttributeCurrentTier10Block7SummationDelivered();
	public Attribute getAttributeCurrentTier10Block8SummationDelivered();
	public Attribute getAttributeCurrentTier10Block9SummationDelivered();
	public Attribute getAttributeCurrentTier10Block10SummationDelivered();
	public Attribute getAttributeCurrentTier10Block11SummationDelivered();
	public Attribute getAttributeCurrentTier10Block12SummationDelivered();
	public Attribute getAttributeCurrentTier10Block13SummationDelivered();
	public Attribute getAttributeCurrentTier10Block14SummationDelivered();
	public Attribute getAttributeCurrentTier10Block15SummationDelivered();
	public Attribute getAttributeCurrentTier10Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier11Block1SummationDelivered();
	public Attribute getAttributeCurrentTier11Block2SummationDelivered();
	public Attribute getAttributeCurrentTier11Block3SummationDelivered();
	public Attribute getAttributeCurrentTier11Block4SummationDelivered();
	public Attribute getAttributeCurrentTier11Block5SummationDelivered();
	public Attribute getAttributeCurrentTier11Block6SummationDelivered();
	public Attribute getAttributeCurrentTier11Block7SummationDelivered();
	public Attribute getAttributeCurrentTier11Block8SummationDelivered();
	public Attribute getAttributeCurrentTier11Block9SummationDelivered();
	public Attribute getAttributeCurrentTier11Block10SummationDelivered();
	public Attribute getAttributeCurrentTier11Block11SummationDelivered();
	public Attribute getAttributeCurrentTier11Block12SummationDelivered();
	public Attribute getAttributeCurrentTier11Block13SummationDelivered();
	public Attribute getAttributeCurrentTier11Block14SummationDelivered();
	public Attribute getAttributeCurrentTier11Block15SummationDelivered();
	public Attribute getAttributeCurrentTier11Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier12Block1SummationDelivered();
	public Attribute getAttributeCurrentTier12Block2SummationDelivered();
	public Attribute getAttributeCurrentTier12Block3SummationDelivered();
	public Attribute getAttributeCurrentTier12Block4SummationDelivered();
	public Attribute getAttributeCurrentTier12Block5SummationDelivered();
	public Attribute getAttributeCurrentTier12Block6SummationDelivered();
	public Attribute getAttributeCurrentTier12Block7SummationDelivered();
	public Attribute getAttributeCurrentTier12Block8SummationDelivered();
	public Attribute getAttributeCurrentTier12Block9SummationDelivered();
	public Attribute getAttributeCurrentTier12Block10SummationDelivered();
	public Attribute getAttributeCurrentTier12Block11SummationDelivered();
	public Attribute getAttributeCurrentTier12Block12SummationDelivered();
	public Attribute getAttributeCurrentTier12Block13SummationDelivered();
	public Attribute getAttributeCurrentTier12Block14SummationDelivered();
	public Attribute getAttributeCurrentTier12Block15SummationDelivered();
	public Attribute getAttributeCurrentTier12Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier13Block1SummationDelivered();
	public Attribute getAttributeCurrentTier13Block2SummationDelivered();
	public Attribute getAttributeCurrentTier13Block3SummationDelivered();
	public Attribute getAttributeCurrentTier13Block4SummationDelivered();
	public Attribute getAttributeCurrentTier13Block5SummationDelivered();
	public Attribute getAttributeCurrentTier13Block6SummationDelivered();
	public Attribute getAttributeCurrentTier13Block7SummationDelivered();
	public Attribute getAttributeCurrentTier13Block8SummationDelivered();
	public Attribute getAttributeCurrentTier13Block9SummationDelivered();
	public Attribute getAttributeCurrentTier13Block10SummationDelivered();
	public Attribute getAttributeCurrentTier13Block11SummationDelivered();
	public Attribute getAttributeCurrentTier13Block12SummationDelivered();
	public Attribute getAttributeCurrentTier13Block13SummationDelivered();
	public Attribute getAttributeCurrentTier13Block14SummationDelivered();
	public Attribute getAttributeCurrentTier13Block15SummationDelivered();
	public Attribute getAttributeCurrentTier13Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier14Block1SummationDelivered();
	public Attribute getAttributeCurrentTier14Block2SummationDelivered();
	public Attribute getAttributeCurrentTier14Block3SummationDelivered();
	public Attribute getAttributeCurrentTier14Block4SummationDelivered();
	public Attribute getAttributeCurrentTier14Block5SummationDelivered();
	public Attribute getAttributeCurrentTier14Block6SummationDelivered();
	public Attribute getAttributeCurrentTier14Block7SummationDelivered();
	public Attribute getAttributeCurrentTier14Block8SummationDelivered();
	public Attribute getAttributeCurrentTier14Block9SummationDelivered();
	public Attribute getAttributeCurrentTier14Block10SummationDelivered();
	public Attribute getAttributeCurrentTier14Block11SummationDelivered();
	public Attribute getAttributeCurrentTier14Block12SummationDelivered();
	public Attribute getAttributeCurrentTier14Block13SummationDelivered();
	public Attribute getAttributeCurrentTier14Block14SummationDelivered();
	public Attribute getAttributeCurrentTier14Block15SummationDelivered();
	public Attribute getAttributeCurrentTier14Block16SummationDelivered();
	
	public Attribute getAttributeCurrentTier15Block1SummationDelivered();
	public Attribute getAttributeCurrentTier15Block2SummationDelivered();
	public Attribute getAttributeCurrentTier15Block3SummationDelivered();
	public Attribute getAttributeCurrentTier15Block4SummationDelivered();
	public Attribute getAttributeCurrentTier15Block5SummationDelivered();
	public Attribute getAttributeCurrentTier15Block6SummationDelivered();
	public Attribute getAttributeCurrentTier15Block7SummationDelivered();
	public Attribute getAttributeCurrentTier15Block8SummationDelivered();
	public Attribute getAttributeCurrentTier15Block9SummationDelivered();
	public Attribute getAttributeCurrentTier15Block10SummationDelivered();
	public Attribute getAttributeCurrentTier15Block11SummationDelivered();
	public Attribute getAttributeCurrentTier15Block12SummationDelivered();
	public Attribute getAttributeCurrentTier15Block13SummationDelivered();
	public Attribute getAttributeCurrentTier15Block14SummationDelivered();
	public Attribute getAttributeCurrentTier15Block15SummationDelivered();
	public Attribute getAttributeCurrentTier15Block16SummationDelivered();

		
	//alarm	
	public Attribute getAttributeGenericAlarmMask();
	public Attribute getAttributeElectricityAlarmMask();
	public Attribute getAttributeGenericFlowPressureAlarmMask();
	public Attribute getAttributeWaterSpecificAlarmMask();
	public Attribute getAttributeHeatAndCoolingSpecificAlarmMask();
	public Attribute getAttributeGasSpecificAlarmMask();
		

}
