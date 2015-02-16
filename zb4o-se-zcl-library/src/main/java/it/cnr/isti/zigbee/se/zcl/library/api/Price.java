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
 * This class represent the <b>Price</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public interface Price extends ZCLCluster {

	public static final short ID = 0x700;
	static final String NAME = "Price";
	// Server Command Received
	static final byte GET_CURRENT_PRICE_ID = 0x00;
	static final byte GET_SCHEDULED_PRICES_ID = 0x01;
	static final byte PRICE_ACKNOWLEDGEMENT_ID = 0x02;
	static final byte GET_BLOCK_PERIOD_ID = 0x03;
	// Server Generated Received
	static final byte PUBLISH_PRICE_ID = 0x00;
	static final byte PUBLISH_BLOCK_PERIOD_ID = 0x01;

	// tier label
	public Attribute getAttributeTier1PriceLabel();

	public Attribute getAttributeTier2PriceLabel();

	public Attribute getAttributeTier3PriceLabel();

	public Attribute getAttributeTier4PriceLabel();

	public Attribute getAttributeTier5PriceLabel();

	public Attribute getAttributeTier6PriceLabel();

	public Attribute getAttributeTier7PriceLabel();

	public Attribute getAttributeTier8PriceLabel();

	public Attribute getAttributeTier9PriceLabel();

	public Attribute getAttributeTier10PriceLabel();

	public Attribute getAttributeTier11PriceLabel();

	public Attribute getAttributeTier12PriceLabel();

	public Attribute getAttributeTier13PriceLabel();

	public Attribute getAttributeTier14PriceLabel();

	public Attribute getAttributeTier15PriceLabel();

	// block thresold
	public Attribute getAttributeBlock1Thresold();

	public Attribute getAttributeBlock2Thresold();

	public Attribute getAttributeBlock3Thresold();

	public Attribute getAttributeBlock4Thresold();

	public Attribute getAttributeBlock5Thresold();

	public Attribute getAttributeBlock6Thresold();

	public Attribute getAttributeBlock7Thresold();

	public Attribute getAttributeBlock8Thresold();

	public Attribute getAttributeBlock9Thresold();

	public Attribute getAttributeBlock10Thresold();

	public Attribute getAttributeBlock11Thresold();

	public Attribute getAttributeBlock12Thresold();

	public Attribute getAttributeBlock13Thresold();

	public Attribute getAttributeBlock14Thresold();

	public Attribute getAttributeBlock15Thresold();

	// block period
	public Attribute getAttributeStartOfBlockPeriod();

	public Attribute getAttributeBlockPeriodDuration();

	public Attribute getAttributeThresoldMultiplier();

	public Attribute getAttributeThresoldDivisor();

	// commodity period
	public Attribute getAttributeCommodityType();

	public Attribute getAttributeStandingCharge();

	// block
	public Attribute getAttributeNoTierBlock1Price();

	public Attribute getAttributeNoTierBlock2Price();

	public Attribute getAttributeNoTierBlock3Price();

	public Attribute getAttributeNoTierBlock4Price();

	public Attribute getAttributeNoTierBlock5Price();

	public Attribute getAttributeNoTierBlock6Price();

	public Attribute getAttributeNoTierBlock7Price();

	public Attribute getAttributeNoTierBlock8Price();

	public Attribute getAttributeNoTierBlock9Price();

	public Attribute getAttributeNoTierBlock10Price();

	public Attribute getAttributeNoTierBlock11Price();

	public Attribute getAttributeNoTierBlock12Price();

	public Attribute getAttributeNoTierBlock13Price();

	public Attribute getAttributeNoTierBlock14Price();

	public Attribute getAttributeNoTierBlock15Price();

	public Attribute getAttributeNoTierBlock16Price();

	public Attribute getAttributeTier1Block1Price();

	public Attribute getAttributeTier1Block2Price();

	public Attribute getAttributeTier1Block3Price();

	public Attribute getAttributeTier1Block4Price();

	public Attribute getAttributeTier1Block5Price();

	public Attribute getAttributeTier1Block6Price();

	public Attribute getAttributeTier1Block7Price();

	public Attribute getAttributeTier1Block8Price();

	public Attribute getAttributeTier1Block9Price();

	public Attribute getAttributeTier1Block10Price();

	public Attribute getAttributeTier1Block11Price();

	public Attribute getAttributeTier1Block12Price();

	public Attribute getAttributeTier1Block13Price();

	public Attribute getAttributeTier1Block14Price();

	public Attribute getAttributeTier1Block15Price();

	public Attribute getAttributeTier1Block16Price();

	public Attribute getAttributeTier2Block1Price();

	public Attribute getAttributeTier2Block2Price();

	public Attribute getAttributeTier2Block3Price();

	public Attribute getAttributeTier2Block4Price();

	public Attribute getAttributeTier2Block5Price();

	public Attribute getAttributeTier2Block6Price();

	public Attribute getAttributeTier2Block7Price();

	public Attribute getAttributeTier2Block8Price();

	public Attribute getAttributeTier2Block9Price();

	public Attribute getAttributeTier2Block10Price();

	public Attribute getAttributeTier2Block11Price();

	public Attribute getAttributeTier2Block12Price();

	public Attribute getAttributeTier2Block13Price();

	public Attribute getAttributeTier2Block14Price();

	public Attribute getAttributeTier2Block15Price();

	public Attribute getAttributeTier2Block16Price();

	public Attribute getAttributeTier3Block1Price();

	public Attribute getAttributeTier3Block2Price();

	public Attribute getAttributeTier3Block3Price();

	public Attribute getAttributeTier3Block4Price();

	public Attribute getAttributeTier3Block5Price();

	public Attribute getAttributeTier3Block6Price();

	public Attribute getAttributeTier3Block7Price();

	public Attribute getAttributeTier3Block8Price();

	public Attribute getAttributeTier3Block9Price();

	public Attribute getAttributeTier3Block10Price();

	public Attribute getAttributeTier3Block11Price();

	public Attribute getAttributeTier3Block12Price();

	public Attribute getAttributeTier3Block13Price();

	public Attribute getAttributeTier3Block14Price();

	public Attribute getAttributeTier3Block15Price();

	public Attribute getAttributeTier3Block16Price();

	public Attribute getAttributeTier4Block1Price();

	public Attribute getAttributeTier4Block2Price();

	public Attribute getAttributeTier4Block3Price();

	public Attribute getAttributeTier4Block4Price();

	public Attribute getAttributeTier4Block5Price();

	public Attribute getAttributeTier4Block6Price();

	public Attribute getAttributeTier4Block7Price();

	public Attribute getAttributeTier4Block8Price();

	public Attribute getAttributeTier4Block9Price();

	public Attribute getAttributeTier4Block10Price();

	public Attribute getAttributeTier4Block11Price();

	public Attribute getAttributeTier4Block12Price();

	public Attribute getAttributeTier4Block13Price();

	public Attribute getAttributeTier4Block14Price();

	public Attribute getAttributeTier4Block15Price();

	public Attribute getAttributeTier4Block16Price();

	public Attribute getAttributeTier5Block1Price();

	public Attribute getAttributeTier5Block2Price();

	public Attribute getAttributeTier5Block3Price();

	public Attribute getAttributeTier5Block4Price();

	public Attribute getAttributeTier5Block5Price();

	public Attribute getAttributeTier5Block6Price();

	public Attribute getAttributeTier5Block7Price();

	public Attribute getAttributeTier5Block8Price();

	public Attribute getAttributeTier5Block9Price();

	public Attribute getAttributeTier5Block10Price();

	public Attribute getAttributeTier5Block11Price();

	public Attribute getAttributeTier5Block12Price();

	public Attribute getAttributeTier5Block13Price();

	public Attribute getAttributeTier5Block14Price();

	public Attribute getAttributeTier5Block15Price();

	public Attribute getAttributeTier5Block16Price();

	public Attribute getAttributeTier6Block1Price();

	public Attribute getAttributeTier6Block2Price();

	public Attribute getAttributeTier6Block3Price();

	public Attribute getAttributeTier6Block4Price();

	public Attribute getAttributeTier6Block5Price();

	public Attribute getAttributeTier6Block6Price();

	public Attribute getAttributeTier6Block7Price();

	public Attribute getAttributeTier6Block8Price();

	public Attribute getAttributeTier6Block9Price();

	public Attribute getAttributeTier6Block10Price();

	public Attribute getAttributeTier6Block11Price();

	public Attribute getAttributeTier6Block12Price();

	public Attribute getAttributeTier6Block13Price();

	public Attribute getAttributeTier6Block14Price();

	public Attribute getAttributeTier6Block15Price();

	public Attribute getAttributeTier6Block16Price();

	public Attribute getAttributeTier7Block1Price();

	public Attribute getAttributeTier7Block2Price();

	public Attribute getAttributeTier7Block3Price();

	public Attribute getAttributeTier7Block4Price();

	public Attribute getAttributeTier7Block5Price();

	public Attribute getAttributeTier7Block6Price();

	public Attribute getAttributeTier7Block7Price();

	public Attribute getAttributeTier7Block8Price();

	public Attribute getAttributeTier7Block9Price();

	public Attribute getAttributeTier7Block10Price();

	public Attribute getAttributeTier7Block11Price();

	public Attribute getAttributeTier7Block12Price();

	public Attribute getAttributeTier7Block13Price();

	public Attribute getAttributeTier7Block14Price();

	public Attribute getAttributeTier7Block15Price();

	public Attribute getAttributeTier7Block16Price();

	public Attribute getAttributeTier8Block1Price();

	public Attribute getAttributeTier8Block2Price();

	public Attribute getAttributeTier8Block3Price();

	public Attribute getAttributeTier8Block4Price();

	public Attribute getAttributeTier8Block5Price();

	public Attribute getAttributeTier8Block6Price();

	public Attribute getAttributeTier8Block7Price();

	public Attribute getAttributeTier8Block8Price();

	public Attribute getAttributeTier8Block9Price();

	public Attribute getAttributeTier8Block10Price();

	public Attribute getAttributeTier8Block11Price();

	public Attribute getAttributeTier8Block12Price();

	public Attribute getAttributeTier8Block13Price();

	public Attribute getAttributeTier8Block14Price();

	public Attribute getAttributeTier8Block15Price();

	public Attribute getAttributeTier8Block16Price();

	public Attribute getAttributeTier9Block1Price();

	public Attribute getAttributeTier9Block2Price();

	public Attribute getAttributeTier9Block3Price();

	public Attribute getAttributeTier9Block4Price();

	public Attribute getAttributeTier9Block5Price();

	public Attribute getAttributeTier9Block6Price();

	public Attribute getAttributeTier9Block7Price();

	public Attribute getAttributeTier9Block8Price();

	public Attribute getAttributeTier9Block9Price();

	public Attribute getAttributeTier9Block10Price();

	public Attribute getAttributeTier9Block11Price();

	public Attribute getAttributeTier9Block12Price();

	public Attribute getAttributeTier9Block13Price();

	public Attribute getAttributeTier9Block14Price();

	public Attribute getAttributeTier9Block15Price();

	public Attribute getAttributeTier9Block16Price();

	public Attribute getAttributeTier10Block1Price();

	public Attribute getAttributeTier10Block2Price();

	public Attribute getAttributeTier10Block3Price();

	public Attribute getAttributeTier10Block4Price();

	public Attribute getAttributeTier10Block5Price();

	public Attribute getAttributeTier10Block6Price();

	public Attribute getAttributeTier10Block7Price();

	public Attribute getAttributeTier10Block8Price();

	public Attribute getAttributeTier10Block9Price();

	public Attribute getAttributeTier10Block10Price();

	public Attribute getAttributeTier10Block11Price();

	public Attribute getAttributeTier10Block12Price();

	public Attribute getAttributeTier10Block13Price();

	public Attribute getAttributeTier10Block14Price();

	public Attribute getAttributeTier10Block15Price();

	public Attribute getAttributeTier10Block16Price();

	public Attribute getAttributeTier11Block1Price();

	public Attribute getAttributeTier11Block2Price();

	public Attribute getAttributeTier11Block3Price();

	public Attribute getAttributeTier11Block4Price();

	public Attribute getAttributeTier11Block5Price();

	public Attribute getAttributeTier11Block6Price();

	public Attribute getAttributeTier11Block7Price();

	public Attribute getAttributeTier11Block8Price();

	public Attribute getAttributeTier11Block9Price();

	public Attribute getAttributeTier11Block10Price();

	public Attribute getAttributeTier11Block11Price();

	public Attribute getAttributeTier11Block12Price();

	public Attribute getAttributeTier11Block13Price();

	public Attribute getAttributeTier11Block14Price();

	public Attribute getAttributeTier11Block15Price();

	public Attribute getAttributeTier11Block16Price();

	public Attribute getAttributeTier12Block1Price();

	public Attribute getAttributeTier12Block2Price();

	public Attribute getAttributeTier12Block3Price();

	public Attribute getAttributeTier12Block4Price();

	public Attribute getAttributeTier12Block5Price();

	public Attribute getAttributeTier12Block6Price();

	public Attribute getAttributeTier12Block7Price();

	public Attribute getAttributeTier12Block8Price();

	public Attribute getAttributeTier12Block9Price();

	public Attribute getAttributeTier12Block10Price();

	public Attribute getAttributeTier12Block11Price();

	public Attribute getAttributeTier12Block12Price();

	public Attribute getAttributeTier12Block13Price();

	public Attribute getAttributeTier12Block14Price();

	public Attribute getAttributeTier12Block15Price();

	public Attribute getAttributeTier12Block16Price();

	public Attribute getAttributeTier13Block1Price();

	public Attribute getAttributeTier13Block2Price();

	public Attribute getAttributeTier13Block3Price();

	public Attribute getAttributeTier13Block4Price();

	public Attribute getAttributeTier13Block5Price();

	public Attribute getAttributeTier13Block6Price();

	public Attribute getAttributeTier13Block7Price();

	public Attribute getAttributeTier13Block8Price();

	public Attribute getAttributeTier13Block9Price();

	public Attribute getAttributeTier13Block10Price();

	public Attribute getAttributeTier13Block11Price();

	public Attribute getAttributeTier13Block12Price();

	public Attribute getAttributeTier13Block13Price();

	public Attribute getAttributeTier13Block14Price();

	public Attribute getAttributeTier13Block15Price();

	public Attribute getAttributeTier13Block16Price();

	public Attribute getAttributeTier14Block1Price();

	public Attribute getAttributeTier14Block2Price();

	public Attribute getAttributeTier14Block3Price();

	public Attribute getAttributeTier14Block4Price();

	public Attribute getAttributeTier14Block5Price();

	public Attribute getAttributeTier14Block6Price();

	public Attribute getAttributeTier14Block7Price();

	public Attribute getAttributeTier14Block8Price();

	public Attribute getAttributeTier14Block9Price();

	public Attribute getAttributeTier14Block10Price();

	public Attribute getAttributeTier14Block11Price();

	public Attribute getAttributeTier14Block12Price();

	public Attribute getAttributeTier14Block13Price();

	public Attribute getAttributeTier14Block14Price();

	public Attribute getAttributeTier14Block15Price();

	public Attribute getAttributeTier14Block16Price();

	public Attribute getAttributeTier15Block1Price();

	public Attribute getAttributeTier15Block2Price();

	public Attribute getAttributeTier15Block3Price();

	public Attribute getAttributeTier15Block4Price();

	public Attribute getAttributeTier15Block5Price();

	public Attribute getAttributeTier15Block6Price();

	public Attribute getAttributeTier15Block7Price();

	public Attribute getAttributeTier15Block8Price();

	public Attribute getAttributeTier15Block9Price();

	public Attribute getAttributeTier15Block10Price();

	public Attribute getAttributeTier15Block11Price();

	public Attribute getAttributeTier15Block12Price();

	public Attribute getAttributeTier15Block13Price();

	public Attribute getAttributeTier15Block14Price();

	public Attribute getAttributeTier15Block15Price();

	public Attribute getAttributeTier15Block16Price();

	public Attribute getAttributePriceIncreaseRandomizeMinutes();

	public Attribute getAttributePriceDecreaseRandomizeMinutes();

	public Attribute getAttributePriceCommodityType();

}