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
import it.cnr.isti.zigbee.ha.cluster.glue.other_profiles.smart_energy.Price;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.se.zcl.library.impl.PriceCluster;
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

public class PriceImpl implements Price {

	private PriceCluster priceCluster;

	public PriceImpl(ZigBeeDevice zbDevice) {
		priceCluster = new PriceCluster(zbDevice);

	}

	public int getId() {

		return priceCluster.getId();
	}

	public String getName() {

		return priceCluster.getName();
	}

	public Subscription[] getActiveSubscriptions() {
		return priceCluster.getActiveSubscriptions();
	}

	public Attribute[] getAttributes() {

		return priceCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = priceCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}

	public String getTier1PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier1PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier2PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier2PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier3PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier3PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier4PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier4PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier5PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier5PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier6PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier6PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier7PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier7PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier8PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier8PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier9PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier9PriceLabel().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier10PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier10PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier11PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier11PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier12PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier12PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier13PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier13PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier14PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier14PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public String getTier15PriceLabel() throws ZigBeeHAException {
		try {
			return (String) priceCluster.getAttributeTier15PriceLabel()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock1Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock1Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock2Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock2Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock3Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock3Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock4Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock4Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock5Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock5Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock6Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock6Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock7Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock7Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock8Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock8Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock9Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock9Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock10Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock10Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock11Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock11Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock12Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock12Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock13Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock13Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock14Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock14Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public long getBlock15Thresold() throws ZigBeeHAException {
		try {
			return (Long) priceCluster.getAttributeBlock15Thresold().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public Date getStartOfBlockPeriod() throws ZigBeeHAException {
		try {
			return (Date) priceCluster.getAttributeStartOfBlockPeriod()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getBlockPeriodDuration() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeBlockPeriodDuration()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getThresoldMultiplier() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeThresoldMultiplier()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getThresoldDivisor() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeThresoldDivisor().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getCommodityType() throws ZigBeeHAException {
		try {
			return (Byte) priceCluster.getAttributeCommodityType().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getStandingCharge() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeStandingCharge().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getNoTierBlock16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeNoTierBlock16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier1Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier1Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier2Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier2Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier2Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier3Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier3Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier3Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier4Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier4Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier4Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier5Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier5Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier5Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier6Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier6Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier6Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier7Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier7Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier7Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier8Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier8Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier8Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier9Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier9Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier9Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier10Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier10Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier10Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier11Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier11Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier11Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier12Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier12Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier12Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier13Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier13Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier13Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier14Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier14Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier14Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	/*------------------------------------------------------------------------------------------*/

	public int getTier15Block1Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block1Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block2Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block2Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block3Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block3Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block4Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block4Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block5Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block5Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block6Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block6Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block7Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block7Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block8Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block8Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block9Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block9Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block10Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block10Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block11Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block11Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block12Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block12Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block13Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block13Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block14Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block14Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block15Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block15Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public int getTier15Block16Price() throws ZigBeeHAException {
		try {
			return (Integer) priceCluster.getAttributeTier15Block16Price()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getPriceIncreaseRandomizeMinutes()
			throws ZigBeeHAException {
		try {
			return (Byte) priceCluster.getAttributePriceIncreaseRandomizeMinutes()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getPriceDecreaseRandomizeMinutes()
			throws ZigBeeHAException {
		try {
			return (Byte) priceCluster.getAttributePriceDecreaseRandomizeMinutes()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte getPriceCommodityType() throws ZigBeeHAException {
		try {
			return (Byte) priceCluster.getAttributePriceCommodityType()
					.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

}