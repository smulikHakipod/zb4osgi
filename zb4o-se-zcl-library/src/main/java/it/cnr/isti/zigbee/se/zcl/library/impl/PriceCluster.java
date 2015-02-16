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
import it.cnr.isti.zigbee.se.zcl.library.api.Price;
import it.cnr.isti.zigbee.se.zcl.library.impl.attribute.AttributesPrice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 * This class represent the <b>Price</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public class PriceCluster extends ZCLClusterBase implements Price {

	// tier label
	private final AttributeImpl tier1PriceLabel;
	private final AttributeImpl tier2PriceLabel;
	private final AttributeImpl tier3PriceLabel;
	private final AttributeImpl tier4PriceLabel;
	private final AttributeImpl tier5PriceLabel;
	private final AttributeImpl tier6PriceLabel;
	private final AttributeImpl tier7PriceLabel;
	private final AttributeImpl tier8PriceLabel;
	private final AttributeImpl tier9PriceLabel;
	private final AttributeImpl tier10PriceLabel;
	private final AttributeImpl tier11PriceLabel;
	private final AttributeImpl tier12PriceLabel;
	private final AttributeImpl tier13PriceLabel;
	private final AttributeImpl tier14PriceLabel;
	private final AttributeImpl tier15PriceLabel;

	// block thresold
	private final AttributeImpl block1Thresold;
	private final AttributeImpl block2Thresold;
	private final AttributeImpl block3Thresold;
	private final AttributeImpl block4Thresold;
	private final AttributeImpl block5Thresold;
	private final AttributeImpl block6Thresold;
	private final AttributeImpl block7Thresold;
	private final AttributeImpl block8Thresold;
	private final AttributeImpl block9Thresold;
	private final AttributeImpl block10Thresold;
	private final AttributeImpl block11Thresold;
	private final AttributeImpl block12Thresold;
	private final AttributeImpl block13Thresold;
	private final AttributeImpl block14Thresold;
	private final AttributeImpl block15Thresold;

	// block period
	private final AttributeImpl startOfBlockPeriod;
	private final AttributeImpl blockPeriodDuration;
	private final AttributeImpl thresoldMultiplier;
	private final AttributeImpl thresoldDivisor;

	// commodity period
	private final AttributeImpl commodityType;
	private final AttributeImpl standingCharge;

	// block
	private final AttributeImpl noTierBlock1Price;
	private final AttributeImpl noTierBlock2Price;
	private final AttributeImpl noTierBlock3Price;
	private final AttributeImpl noTierBlock4Price;
	private final AttributeImpl noTierBlock5Price;
	private final AttributeImpl noTierBlock6Price;
	private final AttributeImpl noTierBlock7Price;
	private final AttributeImpl noTierBlock8Price;
	private final AttributeImpl noTierBlock9Price;
	private final AttributeImpl noTierBlock10Price;
	private final AttributeImpl noTierBlock11Price;
	private final AttributeImpl noTierBlock12Price;
	private final AttributeImpl noTierBlock13Price;
	private final AttributeImpl noTierBlock14Price;
	private final AttributeImpl noTierBlock15Price;
	private final AttributeImpl noTierBlock16Price;

	private final AttributeImpl tier1Block1Price;
	private final AttributeImpl tier1Block2Price;
	private final AttributeImpl tier1Block3Price;
	private final AttributeImpl tier1Block4Price;
	private final AttributeImpl tier1Block5Price;
	private final AttributeImpl tier1Block6Price;
	private final AttributeImpl tier1Block7Price;
	private final AttributeImpl tier1Block8Price;
	private final AttributeImpl tier1Block9Price;
	private final AttributeImpl tier1Block10Price;
	private final AttributeImpl tier1Block11Price;
	private final AttributeImpl tier1Block12Price;
	private final AttributeImpl tier1Block13Price;
	private final AttributeImpl tier1Block14Price;
	private final AttributeImpl tier1Block15Price;
	private final AttributeImpl tier1Block16Price;

	private final AttributeImpl tier2Block1Price;
	private final AttributeImpl tier2Block2Price;
	private final AttributeImpl tier2Block3Price;
	private final AttributeImpl tier2Block4Price;
	private final AttributeImpl tier2Block5Price;
	private final AttributeImpl tier2Block6Price;
	private final AttributeImpl tier2Block7Price;
	private final AttributeImpl tier2Block8Price;
	private final AttributeImpl tier2Block9Price;
	private final AttributeImpl tier2Block10Price;
	private final AttributeImpl tier2Block11Price;
	private final AttributeImpl tier2Block12Price;
	private final AttributeImpl tier2Block13Price;
	private final AttributeImpl tier2Block14Price;
	private final AttributeImpl tier2Block15Price;
	private final AttributeImpl tier2Block16Price;

	private final AttributeImpl tier3Block1Price;
	private final AttributeImpl tier3Block2Price;
	private final AttributeImpl tier3Block3Price;
	private final AttributeImpl tier3Block4Price;
	private final AttributeImpl tier3Block5Price;
	private final AttributeImpl tier3Block6Price;
	private final AttributeImpl tier3Block7Price;
	private final AttributeImpl tier3Block8Price;
	private final AttributeImpl tier3Block9Price;
	private final AttributeImpl tier3Block10Price;
	private final AttributeImpl tier3Block11Price;
	private final AttributeImpl tier3Block12Price;
	private final AttributeImpl tier3Block13Price;
	private final AttributeImpl tier3Block14Price;
	private final AttributeImpl tier3Block15Price;
	private final AttributeImpl tier3Block16Price;

	private final AttributeImpl tier4Block1Price;
	private final AttributeImpl tier4Block2Price;
	private final AttributeImpl tier4Block3Price;
	private final AttributeImpl tier4Block4Price;
	private final AttributeImpl tier4Block5Price;
	private final AttributeImpl tier4Block6Price;
	private final AttributeImpl tier4Block7Price;
	private final AttributeImpl tier4Block8Price;
	private final AttributeImpl tier4Block9Price;
	private final AttributeImpl tier4Block10Price;
	private final AttributeImpl tier4Block11Price;
	private final AttributeImpl tier4Block12Price;
	private final AttributeImpl tier4Block13Price;
	private final AttributeImpl tier4Block14Price;
	private final AttributeImpl tier4Block15Price;
	private final AttributeImpl tier4Block16Price;

	private final AttributeImpl tier5Block1Price;
	private final AttributeImpl tier5Block2Price;
	private final AttributeImpl tier5Block3Price;
	private final AttributeImpl tier5Block4Price;
	private final AttributeImpl tier5Block5Price;
	private final AttributeImpl tier5Block6Price;
	private final AttributeImpl tier5Block7Price;
	private final AttributeImpl tier5Block8Price;
	private final AttributeImpl tier5Block9Price;
	private final AttributeImpl tier5Block10Price;
	private final AttributeImpl tier5Block11Price;
	private final AttributeImpl tier5Block12Price;
	private final AttributeImpl tier5Block13Price;
	private final AttributeImpl tier5Block14Price;
	private final AttributeImpl tier5Block15Price;
	private final AttributeImpl tier5Block16Price;

	private final AttributeImpl tier6Block1Price;
	private final AttributeImpl tier6Block2Price;
	private final AttributeImpl tier6Block3Price;
	private final AttributeImpl tier6Block4Price;
	private final AttributeImpl tier6Block5Price;
	private final AttributeImpl tier6Block6Price;
	private final AttributeImpl tier6Block7Price;
	private final AttributeImpl tier6Block8Price;
	private final AttributeImpl tier6Block9Price;
	private final AttributeImpl tier6Block10Price;
	private final AttributeImpl tier6Block11Price;
	private final AttributeImpl tier6Block12Price;
	private final AttributeImpl tier6Block13Price;
	private final AttributeImpl tier6Block14Price;
	private final AttributeImpl tier6Block15Price;
	private final AttributeImpl tier6Block16Price;

	private final AttributeImpl tier7Block1Price;
	private final AttributeImpl tier7Block2Price;
	private final AttributeImpl tier7Block3Price;
	private final AttributeImpl tier7Block4Price;
	private final AttributeImpl tier7Block5Price;
	private final AttributeImpl tier7Block6Price;
	private final AttributeImpl tier7Block7Price;
	private final AttributeImpl tier7Block8Price;
	private final AttributeImpl tier7Block9Price;
	private final AttributeImpl tier7Block10Price;
	private final AttributeImpl tier7Block11Price;
	private final AttributeImpl tier7Block12Price;
	private final AttributeImpl tier7Block13Price;
	private final AttributeImpl tier7Block14Price;
	private final AttributeImpl tier7Block15Price;
	private final AttributeImpl tier7Block16Price;

	private final AttributeImpl tier8Block1Price;
	private final AttributeImpl tier8Block2Price;
	private final AttributeImpl tier8Block3Price;
	private final AttributeImpl tier8Block4Price;
	private final AttributeImpl tier8Block5Price;
	private final AttributeImpl tier8Block6Price;
	private final AttributeImpl tier8Block7Price;
	private final AttributeImpl tier8Block8Price;
	private final AttributeImpl tier8Block9Price;
	private final AttributeImpl tier8Block10Price;
	private final AttributeImpl tier8Block11Price;
	private final AttributeImpl tier8Block12Price;
	private final AttributeImpl tier8Block13Price;
	private final AttributeImpl tier8Block14Price;
	private final AttributeImpl tier8Block15Price;
	private final AttributeImpl tier8Block16Price;

	private final AttributeImpl tier9Block1Price;
	private final AttributeImpl tier9Block2Price;
	private final AttributeImpl tier9Block3Price;
	private final AttributeImpl tier9Block4Price;
	private final AttributeImpl tier9Block5Price;
	private final AttributeImpl tier9Block6Price;
	private final AttributeImpl tier9Block7Price;
	private final AttributeImpl tier9Block8Price;
	private final AttributeImpl tier9Block9Price;
	private final AttributeImpl tier9Block10Price;
	private final AttributeImpl tier9Block11Price;
	private final AttributeImpl tier9Block12Price;
	private final AttributeImpl tier9Block13Price;
	private final AttributeImpl tier9Block14Price;
	private final AttributeImpl tier9Block15Price;
	private final AttributeImpl tier9Block16Price;

	private final AttributeImpl tier10Block1Price;
	private final AttributeImpl tier10Block2Price;
	private final AttributeImpl tier10Block3Price;
	private final AttributeImpl tier10Block4Price;
	private final AttributeImpl tier10Block5Price;
	private final AttributeImpl tier10Block6Price;
	private final AttributeImpl tier10Block7Price;
	private final AttributeImpl tier10Block8Price;
	private final AttributeImpl tier10Block9Price;
	private final AttributeImpl tier10Block10Price;
	private final AttributeImpl tier10Block11Price;
	private final AttributeImpl tier10Block12Price;
	private final AttributeImpl tier10Block13Price;
	private final AttributeImpl tier10Block14Price;
	private final AttributeImpl tier10Block15Price;
	private final AttributeImpl tier10Block16Price;

	private final AttributeImpl tier11Block1Price;
	private final AttributeImpl tier11Block2Price;
	private final AttributeImpl tier11Block3Price;
	private final AttributeImpl tier11Block4Price;
	private final AttributeImpl tier11Block5Price;
	private final AttributeImpl tier11Block6Price;
	private final AttributeImpl tier11Block7Price;
	private final AttributeImpl tier11Block8Price;
	private final AttributeImpl tier11Block9Price;
	private final AttributeImpl tier11Block10Price;
	private final AttributeImpl tier11Block11Price;
	private final AttributeImpl tier11Block12Price;
	private final AttributeImpl tier11Block13Price;
	private final AttributeImpl tier11Block14Price;
	private final AttributeImpl tier11Block15Price;
	private final AttributeImpl tier11Block16Price;

	private final AttributeImpl tier12Block1Price;
	private final AttributeImpl tier12Block2Price;
	private final AttributeImpl tier12Block3Price;
	private final AttributeImpl tier12Block4Price;
	private final AttributeImpl tier12Block5Price;
	private final AttributeImpl tier12Block6Price;
	private final AttributeImpl tier12Block7Price;
	private final AttributeImpl tier12Block8Price;
	private final AttributeImpl tier12Block9Price;
	private final AttributeImpl tier12Block10Price;
	private final AttributeImpl tier12Block11Price;
	private final AttributeImpl tier12Block12Price;
	private final AttributeImpl tier12Block13Price;
	private final AttributeImpl tier12Block14Price;
	private final AttributeImpl tier12Block15Price;
	private final AttributeImpl tier12Block16Price;

	private final AttributeImpl tier13Block1Price;
	private final AttributeImpl tier13Block2Price;
	private final AttributeImpl tier13Block3Price;
	private final AttributeImpl tier13Block4Price;
	private final AttributeImpl tier13Block5Price;
	private final AttributeImpl tier13Block6Price;
	private final AttributeImpl tier13Block7Price;
	private final AttributeImpl tier13Block8Price;
	private final AttributeImpl tier13Block9Price;
	private final AttributeImpl tier13Block10Price;
	private final AttributeImpl tier13Block11Price;
	private final AttributeImpl tier13Block12Price;
	private final AttributeImpl tier13Block13Price;
	private final AttributeImpl tier13Block14Price;
	private final AttributeImpl tier13Block15Price;
	private final AttributeImpl tier13Block16Price;

	private final AttributeImpl tier14Block1Price;
	private final AttributeImpl tier14Block2Price;
	private final AttributeImpl tier14Block3Price;
	private final AttributeImpl tier14Block4Price;
	private final AttributeImpl tier14Block5Price;
	private final AttributeImpl tier14Block6Price;
	private final AttributeImpl tier14Block7Price;
	private final AttributeImpl tier14Block8Price;
	private final AttributeImpl tier14Block9Price;
	private final AttributeImpl tier14Block10Price;
	private final AttributeImpl tier14Block11Price;
	private final AttributeImpl tier14Block12Price;
	private final AttributeImpl tier14Block13Price;
	private final AttributeImpl tier14Block14Price;
	private final AttributeImpl tier14Block15Price;
	private final AttributeImpl tier14Block16Price;

	private final AttributeImpl tier15Block1Price;
	private final AttributeImpl tier15Block2Price;
	private final AttributeImpl tier15Block3Price;
	private final AttributeImpl tier15Block4Price;
	private final AttributeImpl tier15Block5Price;
	private final AttributeImpl tier15Block6Price;
	private final AttributeImpl tier15Block7Price;
	private final AttributeImpl tier15Block8Price;
	private final AttributeImpl tier15Block9Price;
	private final AttributeImpl tier15Block10Price;
	private final AttributeImpl tier15Block11Price;
	private final AttributeImpl tier15Block12Price;
	private final AttributeImpl tier15Block13Price;
	private final AttributeImpl tier15Block14Price;
	private final AttributeImpl tier15Block15Price;
	private final AttributeImpl tier15Block16Price;

	private final AttributeImpl priceIncreaseRandomizeMinutes;
	private final AttributeImpl priceDecreaseRandomizeMinutes;
	private final AttributeImpl priceCommodityType;

	private final Attribute[] attributes;

	public PriceCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		// tier label
		tier1PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_PRICE_LABEL);
		tier2PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_PRICE_LABEL);
		tier3PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_PRICE_LABEL);
		tier4PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_PRICE_LABEL);
		tier5PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_PRICE_LABEL);
		tier6PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_PRICE_LABEL);
		tier7PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_PRICE_LABEL);
		tier8PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_PRICE_LABEL);
		tier9PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_PRICE_LABEL);
		tier10PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_PRICE_LABEL);
		tier11PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_PRICE_LABEL);
		tier12PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_PRICE_LABEL);
		tier13PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_PRICE_LABEL);
		tier14PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_PRICE_LABEL);
		tier15PriceLabel = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_PRICE_LABEL);

		// block thresold
		block1Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_1_THRESOLD);
		block2Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_2_THRESOLD);
		block3Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_3_THRESOLD);
		block4Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_4_THRESOLD);
		block5Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_5_THRESOLD);
		block6Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_6_THRESOLD);
		block7Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_7_THRESOLD);
		block8Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_8_THRESOLD);
		block9Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_9_THRESOLD);
		block10Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_10_THRESOLD);
		block11Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_11_THRESOLD);
		block12Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_12_THRESOLD);
		block13Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_13_THRESOLD);
		block14Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_14_THRESOLD);
		block15Thresold = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_15_THRESOLD);

		// block period
		startOfBlockPeriod = new AttributeImpl(zbDevice, this,
				AttributesPrice.START_OF_BLOCK_PERIOD);
		blockPeriodDuration = new AttributeImpl(zbDevice, this,
				AttributesPrice.BLOCK_PERIOD_DURATION);
		thresoldMultiplier = new AttributeImpl(zbDevice, this,
				AttributesPrice.THRESOLD_MULTIPLIER);
		thresoldDivisor = new AttributeImpl(zbDevice, this,
				AttributesPrice.THRESOLD_DIVISOR);

		// commodity period
		commodityType = new AttributeImpl(zbDevice, this,
				AttributesPrice.COMMODITY_TYPE);
		standingCharge = new AttributeImpl(zbDevice, this,
				AttributesPrice.STANDING_CHARGE);

		// block

		noTierBlock1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_1_PRICE);
		noTierBlock2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_2_PRICE);
		noTierBlock3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_3_PRICE);
		noTierBlock4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_4_PRICE);
		noTierBlock5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_5_PRICE);
		noTierBlock6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_6_PRICE);
		noTierBlock7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_7_PRICE);
		noTierBlock8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_8_PRICE);
		noTierBlock9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_9_PRICE);
		noTierBlock10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_10_PRICE);
		noTierBlock11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_11_PRICE);
		noTierBlock12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_12_PRICE);
		noTierBlock13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_13_PRICE);
		noTierBlock14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_14_PRICE);
		noTierBlock15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_15_PRICE);
		noTierBlock16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.NO_TIER_BLOCK_16_PRICE);

		tier1Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_1_PRICE);
		tier1Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_2_PRICE);
		tier1Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_3_PRICE);
		tier1Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_4_PRICE);
		tier1Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_5_PRICE);
		tier1Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_6_PRICE);
		tier1Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_7_PRICE);
		tier1Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_8_PRICE);
		tier1Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_9_PRICE);
		tier1Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_10_PRICE);
		tier1Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_11_PRICE);
		tier1Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_12_PRICE);
		tier1Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_13_PRICE);
		tier1Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_14_PRICE);
		tier1Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_15_PRICE);
		tier1Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_1_BLOCK_16_PRICE);

		tier2Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_1_PRICE);
		tier2Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_2_PRICE);
		tier2Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_3_PRICE);
		tier2Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_4_PRICE);
		tier2Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_5_PRICE);
		tier2Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_6_PRICE);
		tier2Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_7_PRICE);
		tier2Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_8_PRICE);
		tier2Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_9_PRICE);
		tier2Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_10_PRICE);
		tier2Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_11_PRICE);
		tier2Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_12_PRICE);
		tier2Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_13_PRICE);
		tier2Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_14_PRICE);
		tier2Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_15_PRICE);
		tier2Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_2_BLOCK_16_PRICE);

		tier3Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_1_PRICE);
		tier3Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_2_PRICE);
		tier3Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_3_PRICE);
		tier3Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_4_PRICE);
		tier3Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_5_PRICE);
		tier3Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_6_PRICE);
		tier3Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_7_PRICE);
		tier3Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_8_PRICE);
		tier3Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_9_PRICE);
		tier3Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_10_PRICE);
		tier3Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_11_PRICE);
		tier3Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_12_PRICE);
		tier3Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_13_PRICE);
		tier3Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_14_PRICE);
		tier3Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_15_PRICE);
		tier3Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_3_BLOCK_16_PRICE);

		tier4Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_1_PRICE);
		tier4Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_2_PRICE);
		tier4Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_3_PRICE);
		tier4Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_4_PRICE);
		tier4Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_5_PRICE);
		tier4Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_6_PRICE);
		tier4Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_7_PRICE);
		tier4Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_8_PRICE);
		tier4Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_9_PRICE);
		tier4Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_10_PRICE);
		tier4Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_11_PRICE);
		tier4Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_12_PRICE);
		tier4Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_13_PRICE);
		tier4Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_14_PRICE);
		tier4Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_15_PRICE);
		tier4Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_4_BLOCK_16_PRICE);

		tier5Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_1_PRICE);
		tier5Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_2_PRICE);
		tier5Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_3_PRICE);
		tier5Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_4_PRICE);
		tier5Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_5_PRICE);
		tier5Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_6_PRICE);
		tier5Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_7_PRICE);
		tier5Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_8_PRICE);
		tier5Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_9_PRICE);
		tier5Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_10_PRICE);
		tier5Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_11_PRICE);
		tier5Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_12_PRICE);
		tier5Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_13_PRICE);
		tier5Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_14_PRICE);
		tier5Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_15_PRICE);
		tier5Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_5_BLOCK_16_PRICE);

		tier6Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_1_PRICE);
		tier6Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_2_PRICE);
		tier6Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_3_PRICE);
		tier6Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_4_PRICE);
		tier6Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_5_PRICE);
		tier6Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_6_PRICE);
		tier6Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_7_PRICE);
		tier6Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_8_PRICE);
		tier6Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_9_PRICE);
		tier6Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_10_PRICE);
		tier6Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_11_PRICE);
		tier6Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_12_PRICE);
		tier6Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_13_PRICE);
		tier6Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_14_PRICE);
		tier6Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_15_PRICE);
		tier6Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_6_BLOCK_16_PRICE);

		tier7Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_1_PRICE);
		tier7Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_2_PRICE);
		tier7Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_3_PRICE);
		tier7Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_4_PRICE);
		tier7Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_5_PRICE);
		tier7Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_6_PRICE);
		tier7Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_7_PRICE);
		tier7Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_8_PRICE);
		tier7Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_9_PRICE);
		tier7Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_10_PRICE);
		tier7Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_11_PRICE);
		tier7Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_12_PRICE);
		tier7Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_13_PRICE);
		tier7Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_14_PRICE);
		tier7Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_15_PRICE);
		tier7Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_7_BLOCK_16_PRICE);

		tier8Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_1_PRICE);
		tier8Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_2_PRICE);
		tier8Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_3_PRICE);
		tier8Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_4_PRICE);
		tier8Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_5_PRICE);
		tier8Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_6_PRICE);
		tier8Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_7_PRICE);
		tier8Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_8_PRICE);
		tier8Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_9_PRICE);
		tier8Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_10_PRICE);
		tier8Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_11_PRICE);
		tier8Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_12_PRICE);
		tier8Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_13_PRICE);
		tier8Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_14_PRICE);
		tier8Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_15_PRICE);
		tier8Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_8_BLOCK_16_PRICE);

		tier9Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_1_PRICE);
		tier9Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_2_PRICE);
		tier9Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_3_PRICE);
		tier9Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_4_PRICE);
		tier9Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_5_PRICE);
		tier9Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_6_PRICE);
		tier9Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_7_PRICE);
		tier9Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_8_PRICE);
		tier9Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_9_PRICE);
		tier9Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_10_PRICE);
		tier9Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_11_PRICE);
		tier9Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_12_PRICE);
		tier9Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_13_PRICE);
		tier9Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_14_PRICE);
		tier9Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_15_PRICE);
		tier9Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_9_BLOCK_16_PRICE);

		tier10Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_1_PRICE);
		tier10Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_2_PRICE);
		tier10Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_3_PRICE);
		tier10Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_4_PRICE);
		tier10Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_5_PRICE);
		tier10Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_6_PRICE);
		tier10Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_7_PRICE);
		tier10Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_8_PRICE);
		tier10Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_9_PRICE);
		tier10Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_10_PRICE);
		tier10Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_11_PRICE);
		tier10Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_12_PRICE);
		tier10Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_13_PRICE);
		tier10Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_14_PRICE);
		tier10Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_15_PRICE);
		tier10Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_10_BLOCK_16_PRICE);

		tier11Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_1_PRICE);
		tier11Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_2_PRICE);
		tier11Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_3_PRICE);
		tier11Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_4_PRICE);
		tier11Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_5_PRICE);
		tier11Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_6_PRICE);
		tier11Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_7_PRICE);
		tier11Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_8_PRICE);
		tier11Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_9_PRICE);
		tier11Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_10_PRICE);
		tier11Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_11_PRICE);
		tier11Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_12_PRICE);
		tier11Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_13_PRICE);
		tier11Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_14_PRICE);
		tier11Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_15_PRICE);
		tier11Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_11_BLOCK_16_PRICE);

		tier12Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_1_PRICE);
		tier12Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_2_PRICE);
		tier12Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_3_PRICE);
		tier12Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_4_PRICE);
		tier12Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_5_PRICE);
		tier12Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_6_PRICE);
		tier12Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_7_PRICE);
		tier12Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_8_PRICE);
		tier12Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_9_PRICE);
		tier12Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_10_PRICE);
		tier12Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_11_PRICE);
		tier12Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_12_PRICE);
		tier12Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_13_PRICE);
		tier12Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_14_PRICE);
		tier12Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_15_PRICE);
		tier12Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_12_BLOCK_16_PRICE);

		tier13Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_1_PRICE);
		tier13Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_2_PRICE);
		tier13Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_3_PRICE);
		tier13Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_4_PRICE);
		tier13Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_5_PRICE);
		tier13Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_6_PRICE);
		tier13Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_7_PRICE);
		tier13Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_8_PRICE);
		tier13Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_9_PRICE);
		tier13Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_10_PRICE);
		tier13Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_11_PRICE);
		tier13Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_12_PRICE);
		tier13Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_13_PRICE);
		tier13Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_14_PRICE);
		tier13Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_15_PRICE);
		tier13Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_13_BLOCK_16_PRICE);

		tier14Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_1_PRICE);
		tier14Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_2_PRICE);
		tier14Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_3_PRICE);
		tier14Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_4_PRICE);
		tier14Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_5_PRICE);
		tier14Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_6_PRICE);
		tier14Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_7_PRICE);
		tier14Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_8_PRICE);
		tier14Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_9_PRICE);
		tier14Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_10_PRICE);
		tier14Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_11_PRICE);
		tier14Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_12_PRICE);
		tier14Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_13_PRICE);
		tier14Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_14_PRICE);
		tier14Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_15_PRICE);
		tier14Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_14_BLOCK_16_PRICE);

		tier15Block1Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_1_PRICE);
		tier15Block2Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_2_PRICE);
		tier15Block3Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_3_PRICE);
		tier15Block4Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_4_PRICE);
		tier15Block5Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_5_PRICE);
		tier15Block6Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_6_PRICE);
		tier15Block7Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_7_PRICE);
		tier15Block8Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_8_PRICE);
		tier15Block9Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_9_PRICE);
		tier15Block10Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_10_PRICE);
		tier15Block11Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_11_PRICE);
		tier15Block12Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_12_PRICE);
		tier15Block13Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_13_PRICE);
		tier15Block14Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_14_PRICE);
		tier15Block15Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_15_PRICE);
		tier15Block16Price = new AttributeImpl(zbDevice, this,
				AttributesPrice.TIER_15_BLOCK_16_PRICE);

		priceIncreaseRandomizeMinutes = new AttributeImpl(zbDevice, this,
				AttributesPrice.PRICE_INCREASE_RANDOMIZE_MINUTES);
		priceDecreaseRandomizeMinutes = new AttributeImpl(zbDevice, this,
				AttributesPrice.PRICE_DECREASE_RANDOMIZE_MINUTES);
		priceCommodityType = new AttributeImpl(zbDevice, this,
				AttributesPrice.PRICE_COMMODITY_TYPE);

		attributes = new AttributeImpl[] {
				// tier label
				tier1PriceLabel,
				tier2PriceLabel,
				tier3PriceLabel,
				tier4PriceLabel,
				tier5PriceLabel,
				tier6PriceLabel,
				tier7PriceLabel,
				tier8PriceLabel,
				tier9PriceLabel,
				tier10PriceLabel,
				tier11PriceLabel,
				tier12PriceLabel,
				tier13PriceLabel,
				tier14PriceLabel,
				tier15PriceLabel,
				// block thresold
				block1Thresold,
				block2Thresold,
				block3Thresold,
				block4Thresold,
				block5Thresold,
				block6Thresold,
				block7Thresold,
				block8Thresold,
				block9Thresold,
				block10Thresold,
				block11Thresold,
				block12Thresold,
				block13Thresold,
				block14Thresold,
				block15Thresold,
				// block period
				startOfBlockPeriod,
				blockPeriodDuration,
				thresoldMultiplier,
				thresoldDivisor,
				// commodity period
				commodityType,
				standingCharge,
				// block
				noTierBlock1Price, noTierBlock2Price, noTierBlock3Price,
				noTierBlock4Price, noTierBlock5Price, noTierBlock6Price,
				noTierBlock7Price, noTierBlock8Price, noTierBlock9Price,
				noTierBlock10Price, noTierBlock11Price, noTierBlock12Price,
				noTierBlock13Price, noTierBlock14Price, noTierBlock15Price,
				noTierBlock16Price, tier1Block1Price, tier1Block2Price,
				tier1Block3Price, tier1Block4Price, tier1Block5Price,
				tier1Block6Price, tier1Block7Price, tier1Block8Price,
				tier1Block9Price, tier1Block10Price, tier1Block11Price,
				tier1Block12Price, tier1Block13Price, tier1Block14Price,
				tier1Block15Price, tier1Block16Price, tier2Block1Price,
				tier2Block2Price, tier2Block3Price, tier2Block4Price,
				tier2Block5Price, tier2Block6Price, tier2Block7Price,
				tier2Block8Price, tier2Block9Price, tier2Block10Price,
				tier2Block11Price, tier2Block12Price, tier2Block13Price,
				tier2Block14Price, tier2Block15Price, tier2Block16Price,
				tier3Block1Price, tier3Block2Price, tier3Block3Price,
				tier3Block4Price, tier3Block5Price, tier3Block6Price,
				tier3Block7Price, tier3Block8Price, tier3Block9Price,
				tier3Block10Price, tier3Block11Price, tier3Block12Price,
				tier3Block13Price, tier3Block14Price, tier3Block15Price,
				tier3Block16Price, tier4Block1Price, tier4Block2Price,
				tier4Block3Price, tier4Block4Price, tier4Block5Price,
				tier4Block6Price, tier4Block7Price, tier4Block8Price,
				tier4Block9Price, tier4Block10Price, tier4Block11Price,
				tier4Block12Price, tier4Block13Price, tier4Block14Price,
				tier4Block15Price, tier4Block16Price, tier5Block1Price,
				tier5Block2Price, tier5Block3Price, tier5Block4Price,
				tier5Block5Price, tier5Block6Price, tier5Block7Price,
				tier5Block8Price, tier5Block9Price, tier5Block10Price,
				tier5Block11Price, tier5Block12Price, tier5Block13Price,
				tier5Block14Price, tier5Block15Price, tier5Block16Price,
				tier6Block1Price, tier6Block2Price, tier6Block3Price,
				tier6Block4Price, tier6Block5Price, tier6Block6Price,
				tier6Block7Price, tier6Block8Price, tier6Block9Price,
				tier6Block10Price, tier6Block11Price, tier6Block12Price,
				tier6Block13Price, tier6Block14Price, tier6Block15Price,
				tier6Block16Price, tier7Block1Price, tier7Block2Price,
				tier7Block3Price, tier7Block4Price, tier7Block5Price,
				tier7Block6Price, tier7Block7Price, tier7Block8Price,
				tier7Block9Price, tier7Block10Price, tier7Block11Price,
				tier7Block12Price, tier7Block13Price, tier7Block14Price,
				tier7Block15Price, tier7Block16Price, tier8Block1Price,
				tier8Block2Price, tier8Block3Price, tier8Block4Price,
				tier8Block5Price, tier8Block6Price, tier8Block7Price,
				tier8Block8Price, tier8Block9Price, tier8Block10Price,
				tier8Block11Price, tier8Block12Price, tier8Block13Price,
				tier8Block14Price, tier8Block15Price, tier8Block16Price,
				tier9Block1Price, tier9Block2Price, tier9Block3Price,
				tier9Block4Price, tier9Block5Price, tier9Block6Price,
				tier9Block7Price, tier9Block8Price, tier9Block9Price,
				tier9Block10Price, tier9Block11Price, tier9Block12Price,
				tier9Block13Price, tier9Block14Price, tier9Block15Price,
				tier9Block16Price, tier10Block1Price, tier10Block2Price,
				tier10Block3Price, tier10Block4Price, tier10Block5Price,
				tier10Block6Price, tier10Block7Price, tier10Block8Price,
				tier10Block9Price, tier10Block10Price, tier10Block11Price,
				tier10Block12Price, tier10Block13Price, tier10Block14Price,
				tier10Block15Price, tier10Block16Price, tier11Block1Price,
				tier11Block2Price, tier11Block3Price, tier11Block4Price,
				tier11Block5Price, tier11Block6Price, tier11Block7Price,
				tier11Block8Price, tier11Block9Price, tier11Block10Price,
				tier11Block11Price, tier11Block12Price, tier11Block13Price,
				tier11Block14Price, tier11Block15Price, tier11Block16Price,
				tier12Block1Price, tier12Block2Price, tier12Block3Price,
				tier12Block4Price, tier12Block5Price, tier12Block6Price,
				tier12Block7Price, tier12Block8Price, tier12Block9Price,
				tier12Block10Price, tier12Block11Price, tier12Block12Price,
				tier12Block13Price, tier12Block14Price, tier12Block15Price,
				tier12Block16Price, tier13Block1Price, tier13Block2Price,
				tier13Block3Price, tier13Block4Price, tier13Block5Price,
				tier13Block6Price, tier13Block7Price, tier13Block8Price,
				tier13Block9Price, tier13Block10Price, tier13Block11Price,
				tier13Block12Price, tier13Block13Price, tier13Block14Price,
				tier13Block15Price, tier13Block16Price, tier14Block1Price,
				tier14Block2Price, tier14Block3Price, tier14Block4Price,
				tier14Block5Price, tier14Block6Price, tier14Block7Price,
				tier14Block8Price, tier14Block9Price, tier14Block10Price,
				tier14Block11Price, tier14Block12Price, tier14Block13Price,
				tier14Block14Price, tier14Block15Price, tier14Block16Price,
				tier15Block1Price, tier15Block2Price, tier15Block3Price,
				tier15Block4Price, tier15Block5Price, tier15Block6Price,
				tier15Block7Price, tier15Block8Price, tier15Block9Price,
				tier15Block10Price, tier15Block11Price, tier15Block12Price,
				tier15Block13Price, tier15Block14Price, tier15Block15Price,
				tier15Block16Price,

				priceIncreaseRandomizeMinutes, priceDecreaseRandomizeMinutes,
				priceCommodityType };
	}

	@Override
	public short getId() {
		return Price.ID;
	}

	@Override
	public String getName() {
		return Price.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeTier1PriceLabel() {
		return tier1PriceLabel;
	}

	public Attribute getAttributeTier2PriceLabel() {
		return tier2PriceLabel;
	}

	public Attribute getAttributeTier3PriceLabel() {
		return tier3PriceLabel;
	}

	public Attribute getAttributeTier4PriceLabel() {
		return tier4PriceLabel;
	}

	public Attribute getAttributeTier5PriceLabel() {
		return tier5PriceLabel;
	}

	public Attribute getAttributeTier6PriceLabel() {
		return tier6PriceLabel;
	}

	public Attribute getAttributeTier7PriceLabel() {
		return tier7PriceLabel;
	}

	public Attribute getAttributeTier8PriceLabel() {
		return tier8PriceLabel;
	}

	public Attribute getAttributeTier9PriceLabel() {
		return tier9PriceLabel;
	}

	public Attribute getAttributeTier10PriceLabel() {
		return tier10PriceLabel;
	}

	public Attribute getAttributeTier11PriceLabel() {
		return tier11PriceLabel;
	}

	public Attribute getAttributeTier12PriceLabel() {
		return tier12PriceLabel;
	}

	public Attribute getAttributeTier13PriceLabel() {
		return tier13PriceLabel;
	}

	public Attribute getAttributeTier14PriceLabel() {
		return tier14PriceLabel;
	}

	public Attribute getAttributeTier15PriceLabel() {
		return tier15PriceLabel;
	}

	public Attribute getAttributeBlock1Thresold() {
		return block1Thresold;
	}

	public Attribute getAttributeBlock2Thresold() {
		return block2Thresold;
	}

	public Attribute getAttributeBlock3Thresold() {
		return block3Thresold;
	}

	public Attribute getAttributeBlock4Thresold() {
		return block4Thresold;
	}

	public Attribute getAttributeBlock5Thresold() {
		return block5Thresold;
	}

	public Attribute getAttributeBlock6Thresold() {
		return block6Thresold;
	}

	public Attribute getAttributeBlock7Thresold() {
		return block7Thresold;
	}

	public Attribute getAttributeBlock8Thresold() {
		return block8Thresold;
	}

	public Attribute getAttributeBlock9Thresold() {
		return block9Thresold;
	}

	public Attribute getAttributeBlock10Thresold() {
		return block10Thresold;
	}

	public Attribute getAttributeBlock11Thresold() {
		return block11Thresold;
	}

	public Attribute getAttributeBlock12Thresold() {
		return block12Thresold;
	}

	public Attribute getAttributeBlock13Thresold() {
		return block13Thresold;
	}

	public Attribute getAttributeBlock14Thresold() {
		return block14Thresold;
	}

	public Attribute getAttributeBlock15Thresold() {
		return block15Thresold;
	}

	public Attribute getAttributeStartOfBlockPeriod() {
		return startOfBlockPeriod;
	}

	public Attribute getAttributeBlockPeriodDuration() {
		return blockPeriodDuration;
	}

	public Attribute getAttributeThresoldMultiplier() {
		return thresoldMultiplier;
	}

	public Attribute getAttributeThresoldDivisor() {
		return thresoldDivisor;
	}

	public Attribute getAttributeCommodityType() {
		return commodityType;
	}

	public Attribute getAttributeStandingCharge() {
		return standingCharge;
	}

	public Attribute getAttributeNoTierBlock1Price() {
		return noTierBlock1Price;
	}

	public Attribute getAttributeNoTierBlock2Price() {
		return noTierBlock2Price;
	}

	public Attribute getAttributeNoTierBlock3Price() {
		return noTierBlock4Price;
	}

	public Attribute getAttributeNoTierBlock4Price() {
		return noTierBlock5Price;
	}

	public Attribute getAttributeNoTierBlock5Price() {
		return noTierBlock6Price;
	}

	public Attribute getAttributeNoTierBlock6Price() {
		return noTierBlock7Price;
	}

	public Attribute getAttributeNoTierBlock7Price() {
		return noTierBlock8Price;
	}

	public Attribute getAttributeNoTierBlock8Price() {
		return noTierBlock9Price;
	}

	public Attribute getAttributeNoTierBlock9Price() {
		return noTierBlock10Price;
	}

	public Attribute getAttributeNoTierBlock10Price() {
		return noTierBlock11Price;
	}

	public Attribute getAttributeNoTierBlock11Price() {
		return noTierBlock12Price;
	}

	public Attribute getAttributeNoTierBlock12Price() {
		return noTierBlock13Price;
	}

	public Attribute getAttributeNoTierBlock13Price() {
		return noTierBlock14Price;
	}

	public Attribute getAttributeNoTierBlock14Price() {
		return noTierBlock3Price;
	}

	public Attribute getAttributeNoTierBlock15Price() {
		return noTierBlock3Price;
	}

	public Attribute getAttributeNoTierBlock16Price() {
		return noTierBlock3Price;
	}

	public Attribute getAttributeTier1Block1Price() {
		return tier1Block1Price;
	}

	public Attribute getAttributeTier1Block2Price() {
		return tier1Block2Price;
	}

	public Attribute getAttributeTier1Block3Price() {
		return tier1Block3Price;
	}

	public Attribute getAttributeTier1Block4Price() {
		return tier1Block4Price;
	}

	public Attribute getAttributeTier1Block5Price() {
		return tier1Block5Price;
	}

	public Attribute getAttributeTier1Block6Price() {
		return tier1Block6Price;
	}

	public Attribute getAttributeTier1Block7Price() {
		return tier1Block7Price;
	}

	public Attribute getAttributeTier1Block8Price() {
		return tier1Block8Price;
	}

	public Attribute getAttributeTier1Block9Price() {
		return tier1Block9Price;
	}

	public Attribute getAttributeTier1Block10Price() {
		return tier1Block10Price;
	}

	public Attribute getAttributeTier1Block11Price() {
		return tier1Block11Price;
	}

	public Attribute getAttributeTier1Block12Price() {
		return tier1Block12Price;
	}

	public Attribute getAttributeTier1Block13Price() {
		return tier1Block13Price;
	}

	public Attribute getAttributeTier1Block14Price() {
		return tier1Block14Price;
	}

	public Attribute getAttributeTier1Block15Price() {
		return tier1Block15Price;
	}

	public Attribute getAttributeTier1Block16Price() {
		return tier1Block16Price;
	}

	public Attribute getAttributeTier2Block1Price() {
		return tier2Block1Price;
	}

	public Attribute getAttributeTier2Block2Price() {
		return tier2Block1Price;
	}

	public Attribute getAttributeTier2Block3Price() {
		return tier2Block3Price;
	}

	public Attribute getAttributeTier2Block4Price() {
		return tier2Block4Price;
	}

	public Attribute getAttributeTier2Block5Price() {
		return tier2Block5Price;
	}

	public Attribute getAttributeTier2Block6Price() {
		return tier2Block6Price;
	}

	public Attribute getAttributeTier2Block7Price() {
		return tier2Block7Price;
	}

	public Attribute getAttributeTier2Block8Price() {
		return tier2Block8Price;
	}

	public Attribute getAttributeTier2Block9Price() {
		return tier2Block9Price;
	}

	public Attribute getAttributeTier2Block10Price() {
		return tier2Block10Price;
	}

	public Attribute getAttributeTier2Block11Price() {
		return tier2Block11Price;
	}

	public Attribute getAttributeTier2Block12Price() {
		return tier2Block12Price;
	}

	public Attribute getAttributeTier2Block13Price() {
		return tier2Block13Price;
	}

	public Attribute getAttributeTier2Block14Price() {
		return tier2Block14Price;
	}

	public Attribute getAttributeTier2Block15Price() {
		return tier2Block15Price;
	}

	public Attribute getAttributeTier2Block16Price() {
		return tier2Block16Price;
	}

	public Attribute getAttributeTier3Block1Price() {
		return tier3Block1Price;
	}

	public Attribute getAttributeTier3Block2Price() {
		return tier3Block2Price;
	}

	public Attribute getAttributeTier3Block3Price() {
		return tier3Block3Price;
	}

	public Attribute getAttributeTier3Block4Price() {
		return tier3Block4Price;
	}

	public Attribute getAttributeTier3Block5Price() {
		return tier3Block5Price;
	}

	public Attribute getAttributeTier3Block6Price() {
		return tier3Block6Price;
	}

	public Attribute getAttributeTier3Block7Price() {
		return tier3Block7Price;
	}

	public Attribute getAttributeTier3Block8Price() {
		return tier3Block8Price;
	}

	public Attribute getAttributeTier3Block9Price() {
		return tier3Block9Price;
	}

	public Attribute getAttributeTier3Block10Price() {
		return tier3Block10Price;
	}

	public Attribute getAttributeTier3Block11Price() {
		return tier3Block11Price;
	}

	public Attribute getAttributeTier3Block12Price() {
		return tier3Block12Price;
	}

	public Attribute getAttributeTier3Block13Price() {
		return tier3Block13Price;
	}

	public Attribute getAttributeTier3Block14Price() {
		return tier3Block14Price;
	}

	public Attribute getAttributeTier3Block15Price() {
		return tier3Block15Price;
	}

	public Attribute getAttributeTier3Block16Price() {
		return tier3Block16Price;
	}

	public Attribute getAttributeTier4Block1Price() {
		return tier4Block1Price;
	}

	public Attribute getAttributeTier4Block2Price() {
		return tier4Block2Price;
	}

	public Attribute getAttributeTier4Block3Price() {
		return tier4Block3Price;
	}

	public Attribute getAttributeTier4Block4Price() {
		return tier4Block4Price;
	}

	public Attribute getAttributeTier4Block5Price() {
		return tier4Block5Price;
	}

	public Attribute getAttributeTier4Block6Price() {
		return tier4Block6Price;
	}

	public Attribute getAttributeTier4Block7Price() {
		return tier4Block7Price;
	}

	public Attribute getAttributeTier4Block8Price() {
		return tier4Block8Price;
	}

	public Attribute getAttributeTier4Block9Price() {
		return tier4Block9Price;
	}

	public Attribute getAttributeTier4Block10Price() {
		return tier4Block10Price;
	}

	public Attribute getAttributeTier4Block11Price() {
		return tier4Block11Price;
	}

	public Attribute getAttributeTier4Block12Price() {
		return tier4Block12Price;
	}

	public Attribute getAttributeTier4Block13Price() {
		return tier4Block13Price;
	}

	public Attribute getAttributeTier4Block14Price() {
		return tier4Block14Price;
	}

	public Attribute getAttributeTier4Block15Price() {
		return tier4Block15Price;
	}

	public Attribute getAttributeTier4Block16Price() {
		return tier4Block16Price;
	}

	public Attribute getAttributeTier5Block1Price() {
		return tier5Block1Price;
	}

	public Attribute getAttributeTier5Block2Price() {
		return tier5Block2Price;
	}

	public Attribute getAttributeTier5Block3Price() {
		return tier5Block3Price;
	}

	public Attribute getAttributeTier5Block4Price() {
		return tier5Block4Price;
	}

	public Attribute getAttributeTier5Block5Price() {
		return tier5Block5Price;
	}

	public Attribute getAttributeTier5Block6Price() {
		return tier5Block6Price;
	}

	public Attribute getAttributeTier5Block7Price() {
		return tier5Block7Price;
	}

	public Attribute getAttributeTier5Block8Price() {
		return tier5Block8Price;
	}

	public Attribute getAttributeTier5Block9Price() {
		return tier5Block9Price;
	}

	public Attribute getAttributeTier5Block10Price() {
		return tier5Block10Price;
	}

	public Attribute getAttributeTier5Block11Price() {
		return tier5Block11Price;
	}

	public Attribute getAttributeTier5Block12Price() {
		return tier5Block12Price;
	}

	public Attribute getAttributeTier5Block13Price() {
		return tier5Block13Price;
	}

	public Attribute getAttributeTier5Block14Price() {
		return tier5Block14Price;
	}

	public Attribute getAttributeTier5Block15Price() {
		return tier5Block15Price;
	}

	public Attribute getAttributeTier5Block16Price() {
		return tier5Block16Price;
	}

	public Attribute getAttributeTier6Block1Price() {
		return tier6Block1Price;
	}

	public Attribute getAttributeTier6Block2Price() {
		return tier6Block2Price;
	}

	public Attribute getAttributeTier6Block3Price() {
		return tier6Block3Price;
	}

	public Attribute getAttributeTier6Block4Price() {
		return tier6Block4Price;
	}

	public Attribute getAttributeTier6Block5Price() {
		return tier6Block5Price;
	}

	public Attribute getAttributeTier6Block6Price() {
		return tier6Block6Price;
	}

	public Attribute getAttributeTier6Block7Price() {
		return tier6Block7Price;
	}

	public Attribute getAttributeTier6Block8Price() {
		return tier6Block8Price;
	}

	public Attribute getAttributeTier6Block9Price() {
		return tier6Block9Price;
	}

	public Attribute getAttributeTier6Block10Price() {
		return tier6Block10Price;
	}

	public Attribute getAttributeTier6Block11Price() {
		return tier6Block11Price;
	}

	public Attribute getAttributeTier6Block12Price() {
		return tier6Block12Price;
	}

	public Attribute getAttributeTier6Block13Price() {
		return tier6Block13Price;
	}

	public Attribute getAttributeTier6Block14Price() {
		return tier6Block14Price;
	}

	public Attribute getAttributeTier6Block15Price() {
		return tier6Block15Price;
	}

	public Attribute getAttributeTier6Block16Price() {
		return tier6Block16Price;
	}

	public Attribute getAttributeTier7Block1Price() {
		return tier7Block1Price;
	}

	public Attribute getAttributeTier7Block2Price() {
		return tier7Block2Price;
	}

	public Attribute getAttributeTier7Block3Price() {
		return tier7Block3Price;
	}

	public Attribute getAttributeTier7Block4Price() {
		return tier7Block4Price;
	}

	public Attribute getAttributeTier7Block5Price() {
		return tier7Block5Price;
	}

	public Attribute getAttributeTier7Block6Price() {
		return tier7Block6Price;
	}

	public Attribute getAttributeTier7Block7Price() {
		return tier7Block7Price;
	}

	public Attribute getAttributeTier7Block8Price() {
		return tier7Block8Price;
	}

	public Attribute getAttributeTier7Block9Price() {
		return tier7Block9Price;
	}

	public Attribute getAttributeTier7Block10Price() {
		return tier7Block10Price;
	}

	public Attribute getAttributeTier7Block11Price() {
		return tier7Block11Price;
	}

	public Attribute getAttributeTier7Block12Price() {
		return tier7Block12Price;
	}

	public Attribute getAttributeTier7Block13Price() {
		return tier7Block13Price;
	}

	public Attribute getAttributeTier7Block14Price() {
		return tier7Block14Price;
	}

	public Attribute getAttributeTier7Block15Price() {
		return tier7Block15Price;
	}

	public Attribute getAttributeTier7Block16Price() {
		return tier7Block16Price;
	}

	public Attribute getAttributeTier8Block1Price() {
		return tier8Block1Price;
	}

	public Attribute getAttributeTier8Block2Price() {
		return tier8Block2Price;
	}

	public Attribute getAttributeTier8Block3Price() {
		return tier8Block3Price;
	}

	public Attribute getAttributeTier8Block4Price() {
		return tier8Block4Price;
	}

	public Attribute getAttributeTier8Block5Price() {
		return tier8Block5Price;
	}

	public Attribute getAttributeTier8Block6Price() {
		return tier8Block6Price;
	}

	public Attribute getAttributeTier8Block7Price() {
		return tier8Block7Price;
	}

	public Attribute getAttributeTier8Block8Price() {
		return tier8Block8Price;
	}

	public Attribute getAttributeTier8Block9Price() {
		return tier8Block9Price;
	}

	public Attribute getAttributeTier8Block10Price() {
		return tier8Block10Price;
	}

	public Attribute getAttributeTier8Block11Price() {
		return tier8Block11Price;
	}

	public Attribute getAttributeTier8Block12Price() {
		return tier8Block12Price;
	}

	public Attribute getAttributeTier8Block13Price() {
		return tier8Block13Price;
	}

	public Attribute getAttributeTier8Block14Price() {
		return tier8Block14Price;
	}

	public Attribute getAttributeTier8Block15Price() {
		return tier8Block15Price;
	}

	public Attribute getAttributeTier8Block16Price() {
		return tier8Block16Price;
	}

	public Attribute getAttributeTier9Block1Price() {
		return tier9Block1Price;
	}

	public Attribute getAttributeTier9Block2Price() {
		return tier9Block2Price;
	}

	public Attribute getAttributeTier9Block3Price() {
		return tier9Block3Price;
	}

	public Attribute getAttributeTier9Block4Price() {
		return tier9Block4Price;
	}

	public Attribute getAttributeTier9Block5Price() {
		return tier9Block5Price;
	}

	public Attribute getAttributeTier9Block6Price() {
		return tier9Block6Price;
	}

	public Attribute getAttributeTier9Block7Price() {
		return tier9Block7Price;
	}

	public Attribute getAttributeTier9Block8Price() {
		return tier9Block8Price;
	}

	public Attribute getAttributeTier9Block9Price() {
		return tier9Block9Price;
	}

	public Attribute getAttributeTier9Block10Price() {
		return tier9Block10Price;
	}

	public Attribute getAttributeTier9Block11Price() {
		return tier9Block11Price;
	}

	public Attribute getAttributeTier9Block12Price() {
		return tier9Block12Price;
	}

	public Attribute getAttributeTier9Block13Price() {
		return tier9Block13Price;
	}

	public Attribute getAttributeTier9Block14Price() {
		return tier9Block14Price;
	}

	public Attribute getAttributeTier9Block15Price() {
		return tier9Block15Price;
	}

	public Attribute getAttributeTier9Block16Price() {
		return tier9Block16Price;
	}

	public Attribute getAttributeTier10Block1Price() {
		return tier10Block1Price;
	}

	public Attribute getAttributeTier10Block2Price() {
		return tier10Block2Price;
	}

	public Attribute getAttributeTier10Block3Price() {
		return tier10Block3Price;
	}

	public Attribute getAttributeTier10Block4Price() {
		return tier10Block4Price;
	}

	public Attribute getAttributeTier10Block5Price() {
		return tier10Block5Price;
	}

	public Attribute getAttributeTier10Block6Price() {
		return tier10Block6Price;
	}

	public Attribute getAttributeTier10Block7Price() {
		return tier10Block7Price;
	}

	public Attribute getAttributeTier10Block8Price() {
		return tier10Block8Price;
	}

	public Attribute getAttributeTier10Block9Price() {
		return tier10Block9Price;
	}

	public Attribute getAttributeTier10Block10Price() {
		return tier10Block10Price;
	}

	public Attribute getAttributeTier10Block11Price() {
		return tier10Block11Price;
	}

	public Attribute getAttributeTier10Block12Price() {
		return tier10Block12Price;
	}

	public Attribute getAttributeTier10Block13Price() {
		return tier10Block13Price;
	}

	public Attribute getAttributeTier10Block14Price() {
		return tier10Block14Price;
	}

	public Attribute getAttributeTier10Block15Price() {
		return tier10Block15Price;
	}

	public Attribute getAttributeTier10Block16Price() {
		return tier10Block16Price;
	}

	public Attribute getAttributeTier11Block1Price() {
		return tier11Block1Price;
	}

	public Attribute getAttributeTier11Block2Price() {
		return tier11Block2Price;
	}

	public Attribute getAttributeTier11Block3Price() {
		return tier11Block3Price;
	}

	public Attribute getAttributeTier11Block4Price() {
		return tier11Block4Price;
	}

	public Attribute getAttributeTier11Block5Price() {
		return tier11Block5Price;
	}

	public Attribute getAttributeTier11Block6Price() {
		return tier11Block6Price;
	}

	public Attribute getAttributeTier11Block7Price() {
		return tier11Block7Price;
	}

	public Attribute getAttributeTier11Block8Price() {
		return tier11Block8Price;
	}

	public Attribute getAttributeTier11Block9Price() {
		return tier11Block9Price;
	}

	public Attribute getAttributeTier11Block10Price() {
		return tier11Block10Price;
	}

	public Attribute getAttributeTier11Block11Price() {
		return tier11Block11Price;
	}

	public Attribute getAttributeTier11Block12Price() {
		return tier11Block12Price;
	}

	public Attribute getAttributeTier11Block13Price() {
		return tier11Block13Price;
	}

	public Attribute getAttributeTier11Block14Price() {
		return tier11Block14Price;
	}

	public Attribute getAttributeTier11Block15Price() {
		return tier11Block15Price;
	}

	public Attribute getAttributeTier11Block16Price() {
		return tier11Block16Price;
	}

	public Attribute getAttributeTier12Block1Price() {
		return tier12Block1Price;
	}

	public Attribute getAttributeTier12Block2Price() {
		return tier12Block2Price;
	}

	public Attribute getAttributeTier12Block3Price() {
		return tier12Block3Price;
	}

	public Attribute getAttributeTier12Block4Price() {
		return tier12Block4Price;
	}

	public Attribute getAttributeTier12Block5Price() {
		return tier12Block5Price;
	}

	public Attribute getAttributeTier12Block6Price() {
		return tier12Block6Price;
	}

	public Attribute getAttributeTier12Block7Price() {
		return tier12Block7Price;
	}

	public Attribute getAttributeTier12Block8Price() {
		return tier12Block8Price;
	}

	public Attribute getAttributeTier12Block9Price() {
		return tier12Block9Price;
	}

	public Attribute getAttributeTier12Block10Price() {
		return tier12Block10Price;
	}

	public Attribute getAttributeTier12Block11Price() {
		return tier12Block11Price;
	}

	public Attribute getAttributeTier12Block12Price() {
		return tier12Block12Price;
	}

	public Attribute getAttributeTier12Block13Price() {
		return tier12Block13Price;
	}

	public Attribute getAttributeTier12Block14Price() {
		return tier12Block14Price;
	}

	public Attribute getAttributeTier12Block15Price() {
		return tier12Block15Price;
	}

	public Attribute getAttributeTier12Block16Price() {
		return tier12Block16Price;
	}

	public Attribute getAttributeTier13Block1Price() {
		return tier13Block1Price;
	}

	public Attribute getAttributeTier13Block2Price() {
		return tier13Block2Price;
	}

	public Attribute getAttributeTier13Block3Price() {
		return tier13Block3Price;
	}

	public Attribute getAttributeTier13Block4Price() {
		return tier13Block4Price;
	}

	public Attribute getAttributeTier13Block5Price() {
		return tier13Block5Price;
	}

	public Attribute getAttributeTier13Block6Price() {
		return tier13Block6Price;
	}

	public Attribute getAttributeTier13Block7Price() {
		return tier13Block7Price;
	}

	public Attribute getAttributeTier13Block8Price() {
		return tier13Block8Price;
	}

	public Attribute getAttributeTier13Block9Price() {
		return tier13Block9Price;
	}

	public Attribute getAttributeTier13Block10Price() {
		return tier13Block10Price;
	}

	public Attribute getAttributeTier13Block11Price() {
		return tier13Block11Price;
	}

	public Attribute getAttributeTier13Block12Price() {
		return tier13Block12Price;
	}

	public Attribute getAttributeTier13Block13Price() {
		return tier13Block13Price;
	}

	public Attribute getAttributeTier13Block14Price() {
		return tier13Block14Price;
	}

	public Attribute getAttributeTier13Block15Price() {
		return tier13Block15Price;
	}

	public Attribute getAttributeTier13Block16Price() {
		return tier13Block16Price;
	}

	public Attribute getAttributeTier14Block1Price() {
		return tier14Block1Price;
	}

	public Attribute getAttributeTier14Block2Price() {
		return tier14Block2Price;
	}

	public Attribute getAttributeTier14Block3Price() {
		return tier14Block3Price;
	}

	public Attribute getAttributeTier14Block4Price() {
		return tier14Block4Price;
	}

	public Attribute getAttributeTier14Block5Price() {
		return tier14Block5Price;
	}

	public Attribute getAttributeTier14Block6Price() {
		return tier14Block6Price;
	}

	public Attribute getAttributeTier14Block7Price() {
		return tier14Block7Price;
	}

	public Attribute getAttributeTier14Block8Price() {
		return tier14Block8Price;
	}

	public Attribute getAttributeTier14Block9Price() {
		return tier14Block9Price;
	}

	public Attribute getAttributeTier14Block10Price() {
		return tier14Block10Price;
	}

	public Attribute getAttributeTier14Block11Price() {
		return tier14Block11Price;
	}

	public Attribute getAttributeTier14Block12Price() {
		return tier14Block12Price;
	}

	public Attribute getAttributeTier14Block13Price() {
		return tier14Block13Price;
	}

	public Attribute getAttributeTier14Block14Price() {
		return tier14Block14Price;
	}

	public Attribute getAttributeTier14Block15Price() {
		return tier14Block15Price;
	}

	public Attribute getAttributeTier14Block16Price() {
		return tier14Block16Price;
	}

	public Attribute getAttributeTier15Block1Price() {
		return tier15Block1Price;
	}

	public Attribute getAttributeTier15Block2Price() {
		return tier15Block2Price;
	}

	public Attribute getAttributeTier15Block3Price() {
		return tier15Block3Price;
	}

	public Attribute getAttributeTier15Block4Price() {
		return tier15Block4Price;
	}

	public Attribute getAttributeTier15Block5Price() {
		return tier15Block5Price;
	}

	public Attribute getAttributeTier15Block6Price() {
		return tier15Block6Price;
	}

	public Attribute getAttributeTier15Block7Price() {
		return tier15Block7Price;
	}

	public Attribute getAttributeTier15Block8Price() {
		return tier15Block8Price;
	}

	public Attribute getAttributeTier15Block9Price() {
		return tier15Block9Price;
	}

	public Attribute getAttributeTier15Block10Price() {
		return tier15Block10Price;
	}

	public Attribute getAttributeTier15Block11Price() {
		return tier15Block11Price;
	}

	public Attribute getAttributeTier15Block12Price() {
		return tier15Block12Price;
	}

	public Attribute getAttributeTier15Block13Price() {
		return tier15Block13Price;
	}

	public Attribute getAttributeTier15Block14Price() {
		return tier15Block14Price;
	}

	public Attribute getAttributeTier15Block15Price() {
		return tier15Block15Price;
	}

	public Attribute getAttributeTier15Block16Price() {
		return tier15Block16Price;
	}

	public Attribute getAttributePriceIncreaseRandomizeMinutes() {
		return priceIncreaseRandomizeMinutes;
	}

	public Attribute getAttributePriceDecreaseRandomizeMinutes() {
		return priceDecreaseRandomizeMinutes;
	}

	public Attribute getAttributePriceCommodityType() {
		return priceCommodityType;
	}

}
