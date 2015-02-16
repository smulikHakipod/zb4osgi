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

package it.cnr.isti.zigbee.ha.cluster.glue.other_profiles.smart_energy;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import java.util.Date;
/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision:  $ ($LastChangedDate: $)
 *
 */


public interface Metering extends Cluster {
    
	//reading information
		public long getCurrentSummationDelivered() throws ZigBeeHAException;
		public long getCurrentSummationReceived() throws ZigBeeHAException;
		public long getCurrentMaxDemandDelivered() throws ZigBeeHAException;
		public long getCurrentMaxDemandReceived() throws ZigBeeHAException;
		public long getDFTSummation() throws ZigBeeHAException;
		public short getDailyFreezeTime() throws ZigBeeHAException;
		public byte getPowerFactor() throws ZigBeeHAException;
		public Date getReadingSnapShotTime() throws ZigBeeHAException;
		public Date getCurrentMaxDemandDeliveredTime() throws ZigBeeHAException;
		public Date getCurrentMaxDemandReceivedTime() throws ZigBeeHAException;
		public byte getDefaultUpdatePeriod() throws ZigBeeHAException;
		public byte getFastPollUpdatePeriod() throws ZigBeeHAException;
		public long getCurrentBlockPeriodConsumptionDelivered() throws ZigBeeHAException;
		public float getDailyConsumptionTarget() throws ZigBeeHAException;
		public byte getCurrentBlock() throws ZigBeeHAException;
		public byte getProfileIntervalPeriod() throws ZigBeeHAException;
		public short getIntervalReadReportingPeriod() throws ZigBeeHAException;
		public short getPresetReadingTime() throws ZigBeeHAException;
		public short getVolumePerReport() throws ZigBeeHAException;
		public byte getFlowRestriction() throws ZigBeeHAException;
		public byte getSupplyStatus() throws ZigBeeHAException;
		public long getCurrentInletEnergyCarrierSummation() throws ZigBeeHAException;
		public long getCurrentOutletEnergyCarrierSummation() throws ZigBeeHAException;
		public short getInletTemperature() throws ZigBeeHAException;
		public short getOutletTemperature() throws ZigBeeHAException;
		public short getControlTemperature() throws ZigBeeHAException;
		public float getCurrentInletEnergyCarrierDemand() throws ZigBeeHAException;
		public float getCurrentOutletEnergyCarrierDemand() throws ZigBeeHAException;	
		//TOU information set
		public long getCurrentTier1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14SummationReceived() throws ZigBeeHAException;
		public long getCurrentTier15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15SummationReceived() throws ZigBeeHAException;
		//meter status
		public byte getStatus() throws ZigBeeHAException;
		public byte getRemainingBatteryLife() throws ZigBeeHAException;
		public float getHoursInOperation() throws ZigBeeHAException;
		public float getHoursInFault() throws ZigBeeHAException;
		//formatting	
		public byte getUnitOfMeasure() throws ZigBeeHAException;
		public float getMultiplier() throws ZigBeeHAException;
		public float getDivisor() throws ZigBeeHAException;
		public byte getSummationFormatting() throws ZigBeeHAException;
		public byte getDemandFormatting() throws ZigBeeHAException;
		public byte getHistoricalConsumptionFormatting() throws ZigBeeHAException;
		public byte getMeteringDeviceType() throws ZigBeeHAException;
		public String getSiteID() throws ZigBeeHAException;
		public String getMeterSerialNumber() throws ZigBeeHAException;
		public byte getEnergyCarrierUnitOfMeasure() throws ZigBeeHAException;
		public byte getEnergyCarrierSummationFormatting() throws ZigBeeHAException;
		public byte getEnergyCarrierDemandFormatting() throws ZigBeeHAException;
		public byte getTemperatureUnitOfMeasure() throws ZigBeeHAException;
		public byte getTemperatureFormatting() throws ZigBeeHAException;
		//historical	
		public float getInstantaneousDemand() throws ZigBeeHAException;
		public float getCurrentDayConsumptionDelivered() throws ZigBeeHAException;
		public float getCurrentDayConsumptionReceived() throws ZigBeeHAException;
		public float getPreviousDayConsumptionDelivered() throws ZigBeeHAException;
		public float getPreviousDayConsumptionReceived() throws ZigBeeHAException;
		public Date getCurrentPartialProfileIntervalStartTimeDelivered() throws ZigBeeHAException;
		public Date getCurrentPartialProfileIntervalStartTimeReceived() throws ZigBeeHAException;
		public float getCurrentPartialProfileIntervalValueDelivered() throws ZigBeeHAException;
		public float getCurrentPartialProfileIntervalValueReceived() throws ZigBeeHAException;
		public long getCurrentDayMaxPressure() throws ZigBeeHAException;
		public long getCurrentDayMinPressure() throws ZigBeeHAException;
		public long getPreviousDayMaxPressure() throws ZigBeeHAException;
		public long getPreviousDayMinPressure() throws ZigBeeHAException;
		public float getCurrentDayMaxDemand() throws ZigBeeHAException;
		public float getPreviousDayMaxDemand() throws ZigBeeHAException;
		public float getCurrentMonthMaxDemand() throws ZigBeeHAException;
		public float getCurrentYearMaxDemand() throws ZigBeeHAException;
		public float getCurrentDayMaxEnergyCarrierDemand() throws ZigBeeHAException;
		public float getPreviousDayMaxEnergyCarrierDemand() throws ZigBeeHAException;
		public float getCurrentMonthMaxEnergyCarrierDemand() throws ZigBeeHAException;
		public float getCurrentMonthMinEnergyCarrierDemand() throws ZigBeeHAException;
		public float getCurrentYearMaxEnergyCarrierDemand() throws ZigBeeHAException;
		public float getCurrentYearMinEnergyCarrierDemand() throws ZigBeeHAException;
		//load
		public byte getMaxNumberOfPeriodsDelivered() throws ZigBeeHAException;
		//supply limit	
		public float getCurrentDemandDelivered() throws ZigBeeHAException;
		public float getDemandLimit() throws ZigBeeHAException;
		public byte getDemandIntegrationPeriod() throws ZigBeeHAException;
		public byte getNumberOfDemandAndSubintervals() throws ZigBeeHAException;
		//block
		public long getCurrentNoTierBlock1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentNoTierBlock16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier1Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier1Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier2Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier2Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier3Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier3Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier4Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier4Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier5Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier5Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier6Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier6Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier7Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier7Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier8Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier8Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier9Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier9Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier10Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier10Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier11Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier11Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier12Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier12Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier13Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier13Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier14Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier14Block16SummationDelivered() throws ZigBeeHAException;
		
		public long getCurrentTier15Block1SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block2SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block3SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block4SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block5SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block6SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block7SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block8SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block9SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block10SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block11SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block12SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block13SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block14SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block15SummationDelivered() throws ZigBeeHAException;
		public long getCurrentTier15Block16SummationDelivered() throws ZigBeeHAException;

			
		//alarm	
		public short getGenericAlarmMask() throws ZigBeeHAException;
		public float getElectricityAlarmMask() throws ZigBeeHAException;
		public short getGenericFlowPressureAlarmMask() throws ZigBeeHAException;
		public short getWaterSpecificAlarmMask() throws ZigBeeHAException;
		public short getHeatAndCoolingSpecificAlarmMask() throws ZigBeeHAException;
		public short getGasSpecificAlarmMask() throws ZigBeeHAException;

}
