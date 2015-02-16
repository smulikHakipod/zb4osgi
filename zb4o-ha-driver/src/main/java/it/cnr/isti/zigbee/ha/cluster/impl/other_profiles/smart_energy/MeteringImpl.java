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

package it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.other_profiles.smart_energy.Metering;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.se.zcl.library.impl.MeteringCluster;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;

import java.util.Date;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: $ ($LastChangedDate: $)
 * 
 */

public class MeteringImpl implements Metering {

	private MeteringCluster meteringCluster;

	public MeteringImpl(ZigBeeDevice zbDevice) {
		meteringCluster = new MeteringCluster(zbDevice);

	}

	public int getId() {

		return meteringCluster.getId();
	}

	public String getName() {

		return meteringCluster.getName();
	}

	public Subscription[] getActiveSubscriptions() {
		return meteringCluster.getActiveSubscriptions();
	}

	public Attribute[] getAttributes() {

		return meteringCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = meteringCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}

	public long getCurrentSummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentSummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentSummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentSummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentMaxDemandDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentMaxDemandDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentMaxDemandReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentMaxDemandReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getDFTSummation() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeDFTSummation()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getDailyFreezeTime() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeDailyFreezeTime()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getPowerFactor() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributePowerFactor()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getReadingSnapShotTime() throws ZigBeeHAException {
		try {
			return (Date) meteringCluster.getAttributeReadingSnapShotTime()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getCurrentMaxDemandDeliveredTime() throws ZigBeeHAException {
		try {
			return (Date) meteringCluster.getAttributeCurrentMaxDemandDeliveredTime()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getCurrentMaxDemandReceivedTime() throws ZigBeeHAException {
		try {
			return (Date) meteringCluster.getAttributeCurrentMaxDemandReceivedTime()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getDefaultUpdatePeriod() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeDefaultUpdatePeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getFastPollUpdatePeriod() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeFastPollUpdatePeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentBlockPeriodConsumptionDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentBlockPeriodConsumptionDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getDailyConsumptionTarget() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeDailyConsumptionTarget()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getCurrentBlock() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeCurrentBlock()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getProfileIntervalPeriod() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeProfileIntervalPeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getIntervalReadReportingPeriod() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeIntervalReadReportingPeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getPresetReadingTime() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributePresetReadingTime()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getVolumePerReport() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeVolumePerReport()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getFlowRestriction() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeFlowRestriction()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getSupplyStatus() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeSupplyStatus()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentInletEnergyCarrierSummation()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentInletEnergyCarrierSummation()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentOutletEnergyCarrierSummation()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentOutletEnergyCarrierSummation()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getInletTemperature() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeInletTemperature()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getOutletTemperature() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeOutletTemperature()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getControlTemperature() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeControlTemperature()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentInletEnergyCarrierDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentInletEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentOutletEnergyCarrierDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentOutletEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15SummationDelivered() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15SummationReceived() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15SummationReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getStatus() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeStatus()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getRemainingBatteryLife() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeRemainingBatteryLife()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getHoursInOperation() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeHoursInOperation()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getHoursInFault() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeHoursInFault()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getUnitOfMeasure() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeUnitOfMeasure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getMultiplier() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeMultiplier()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getDivisor() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeDivisor()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getSummationFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeSummationFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getDemandFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeDemandFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getHistoricalConsumptionFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeHistoricalConsumptionFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getMeteringDeviceType() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeMeteringDeviceType()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getSiteID() throws ZigBeeHAException {try {
		return (String) meteringCluster.getAttributeSiteID()
				.getValue();
	} catch (ZigBeeClusterException e) {
		throw new ZigBeeHAException(e);
	}
	}

	public String getMeterSerialNumber() throws ZigBeeHAException {try {
		return (String) meteringCluster.getAttributeMeterSerialNumber()
				.getValue();
	} catch (ZigBeeClusterException e) {
		throw new ZigBeeHAException(e);
	}
	}

	public byte getEnergyCarrierUnitOfMeasure() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeEnergyCarrierUnitOfMeasure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getEnergyCarrierSummationFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeEnergyCarrierSummationFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getEnergyCarrierDemandFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeEnergyCarrierDemandFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getTemperatureUnitOfMeasure() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeTemperatureUnitOfMeasure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getTemperatureFormatting() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeTemperatureFormatting()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getInstantaneousDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeInstantaneousDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentDayConsumptionDelivered() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentDayConsumptionDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentDayConsumptionReceived() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentDayConsumptionReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getPreviousDayConsumptionDelivered() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributePreviousDayConsumptionDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getPreviousDayConsumptionReceived() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributePreviousDayConsumptionReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getCurrentPartialProfileIntervalStartTimeDelivered()
			throws ZigBeeHAException {
		try {
			return (Date) meteringCluster.getAttributeCurrentPartialProfileIntervalStartTimeDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getCurrentPartialProfileIntervalStartTimeReceived()
			throws ZigBeeHAException {
		try {
			return (Date) meteringCluster.getAttributeCurrentPartialProfileIntervalStartTimeReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentPartialProfileIntervalValueDelivered()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentPartialProfileIntervalValueDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentPartialProfileIntervalValueReceived()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentPartialProfileIntervalValueReceived()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentDayMaxPressure() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentDayMaxPressure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentDayMinPressure() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentDayMinPressure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getPreviousDayMaxPressure() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributePreviousDayMaxPressure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getPreviousDayMinPressure() throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributePreviousDayMinPressure()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentDayMaxDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentDayMaxDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getPreviousDayMaxDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributePreviousDayMaxDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentMonthMaxDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentMonthMaxDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentYearMaxDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentYearMaxDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentDayMaxEnergyCarrierDemand() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentDayMaxEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getPreviousDayMaxEnergyCarrierDemand()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributePreviousDayMaxEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentMonthMaxEnergyCarrierDemand()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentMonthMaxEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentMonthMinEnergyCarrierDemand()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentMonthMinEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentYearMaxEnergyCarrierDemand()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentYearMaxEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentYearMinEnergyCarrierDemand()
			throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentYearMinEnergyCarrierDemand()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getMaxNumberOfPeriodsDelivered() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeMaxNumberOfPeriodsDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getCurrentDemandDelivered() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeCurrentDemandDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getDemandLimit() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeDemandLimit()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getDemandIntegrationPeriod() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeDemandIntegrationPeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getNumberOfDemandAndSubintervals() throws ZigBeeHAException {
		try {
			return (Byte) meteringCluster.getAttributeNumberOfDemandAndSubintervals()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentNoTierBlock16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentNoTierBlock16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier1Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier1Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier2Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier2Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier3Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier3Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier4Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier4Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier5Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier5Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier6Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier6Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier7Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier7Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier8Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier8Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier9Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier9Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier10Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier10Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier11Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier11Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier12Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier12Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier13Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier13Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier14Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier14Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block1SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block1SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block2SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block2SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block3SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block3SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block4SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block4SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block5SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block5SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block6SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block6SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block7SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block7SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block8SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block8SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block9SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block9SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block10SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block10SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block11SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block11SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block12SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block12SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block13SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block13SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block14SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block14SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block15SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block15SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getCurrentTier15Block16SummationDelivered()
			throws ZigBeeHAException {
		try {
			return (Long) meteringCluster.getAttributeCurrentTier15Block16SummationDelivered()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getGenericAlarmMask() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeGenericAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getElectricityAlarmMask() throws ZigBeeHAException {
		try {
			return (Float) meteringCluster.getAttributeElectricityAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getGenericFlowPressureAlarmMask() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeGenericFlowPressureAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getWaterSpecificAlarmMask() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeWaterSpecificAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getHeatAndCoolingSpecificAlarmMask() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeHeatAndCoolingSpecificAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getGasSpecificAlarmMask() throws ZigBeeHAException {
		try {
			return (Short) meteringCluster.getAttributeGasSpecificAlarmMask()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

}