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
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48
 *          +0100 (gio, 30 gen 2014) $)
 */
public class AttributesPrice {

	public static final AttributeDescriptor TIER_1_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0000).setName("Tier1PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_2_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0001).setName("Tier2PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_3_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0002).setName("Tier3PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_4_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0003).setName("Tier4PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_5_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0004).setName("Tier5PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_6_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0005).setName("Tier6PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_7_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0006).setName("Tier7PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_8_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0007).setName("Tier8PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_9_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0008).setName("Tier9PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_10_PRICE_LABEL = new AbstractAttribute()
			.setId(0x0009).setName("Tier10PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_11_PRICE_LABEL = new AbstractAttribute()
			.setId(0x000A).setName("Tier11PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_12_PRICE_LABEL = new AbstractAttribute()
			.setId(0x000B).setName("Tier12PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_13_PRICE_LABEL = new AbstractAttribute()
			.setId(0x000C).setName("Tier13PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_14_PRICE_LABEL = new AbstractAttribute()
			.setId(0x000D).setName("Tier14PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor TIER_15_PRICE_LABEL = new AbstractAttribute()
			.setId(0x000E).setName("Tier15PriceLabel").setReportable(false)
			.setZigBeeType(ZigBeeType.OctectString).setWritable(true);

	public static final AttributeDescriptor BLOCK_1_THRESOLD = new AbstractAttribute()
			.setId(0x0000).setName("Block1Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_2_THRESOLD = new AbstractAttribute()
			.setId(0x0001).setName("Block2Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_3_THRESOLD = new AbstractAttribute()
			.setId(0x0002).setName("Block3Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_4_THRESOLD = new AbstractAttribute()
			.setId(0x0003).setName("Block4Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_5_THRESOLD = new AbstractAttribute()
			.setId(0x0004).setName("Block5Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_6_THRESOLD = new AbstractAttribute()
			.setId(0x0005).setName("Block6Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_7_THRESOLD = new AbstractAttribute()
			.setId(0x0006).setName("Block7Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_8_THRESOLD = new AbstractAttribute()
			.setId(0x0007).setName("Block8Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_9_THRESOLD = new AbstractAttribute()
			.setId(0x0008).setName("Block9Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_10_THRESOLD = new AbstractAttribute()
			.setId(0x0009).setName("Block10Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_11_THRESOLD = new AbstractAttribute()
			.setId(0x00A).setName("Block11Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_12_THRESOLD = new AbstractAttribute()
			.setId(0x000B).setName("Block12Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_13_THRESOLD = new AbstractAttribute()
			.setId(0x000C).setName("Block13Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_14_THRESOLD = new AbstractAttribute()
			.setId(0x000D).setName("Block14Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor BLOCK_15_THRESOLD = new AbstractAttribute()
			.setId(0x000E).setName("Block15Thresold").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger48bit).setWritable(false);

	public static final AttributeDescriptor START_OF_BLOCK_PERIOD = new AbstractAttribute()
			.setId(0x0000).setName("StartOfBlockPeriod").setReportable(false)
			.setZigBeeType(ZigBeeType.UTCTime).setWritable(false);

	public static final AttributeDescriptor BLOCK_PERIOD_DURATION = new AbstractAttribute()
			.setId(0x0001).setName("BlockPeriodDuration").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger24bit).setWritable(false);

	public static final AttributeDescriptor THRESOLD_MULTIPLIER = new AbstractAttribute()
			.setId(0x0002).setName("ThresoldMultiplier").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger24bit).setWritable(false);

	public static final AttributeDescriptor THRESOLD_DIVISOR = new AbstractAttribute()
			.setId(0x0003).setName("ThresoldDivisor").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger24bit).setWritable(false);

	public static final AttributeDescriptor COMMODITY_TYPE = new AbstractAttribute()
			.setId(0x0000).setName("CommodityType").setReportable(false)
			.setZigBeeType(ZigBeeType.Enumeration8bit).setWritable(false);

	public static final AttributeDescriptor STANDING_CHARGE = new AbstractAttribute()
			.setId(0x0001).setName("StandingCharge").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(false);

	public static final AttributeDescriptor NO_TIER_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0000).setName("NoTierBlock1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0001).setName("NoTierBlock2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0002).setName("NoTierBlock3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0003).setName("NoTierBlock4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0004).setName("NoTierBlock5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0005).setName("NoTierBlock6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0006).setName("NoTierBlock7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0007).setName("NoTierBlock8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0008).setName("NoTierBlock9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0009).setName("NoTierBlock10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x000A).setName("NoTierBlock11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x000B).setName("NoTierBlock12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x000C).setName("NoTierBlock13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x000D).setName("NoTierBlock14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x000E).setName("NoTierBlock15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor NO_TIER_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x000F).setName("NoTierBlock16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0010).setName("Tier1Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0011).setName("Tier1Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0012).setName("Tier1Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0013).setName("Tier1Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0014).setName("Tier1Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0015).setName("Tier1Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0016).setName("Tier1Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0017).setName("Tier1Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0018).setName("Tier1Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0019).setName("Tier1Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x001A).setName("Tier1Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x001B).setName("Tier1Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x001C).setName("Tier1Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x001D).setName("Tier1Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x001E).setName("Tier1Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_1_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x001F).setName("Tier1Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0020).setName("Tier2Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0021).setName("Tier2Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0022).setName("Tier2Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0023).setName("Tier2Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0024).setName("Tier2Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0025).setName("Tier2Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0026).setName("Tier2Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0027).setName("Tier2Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0028).setName("Tier2Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0029).setName("Tier2Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x002A).setName("Tier2Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x002B).setName("Tier2Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x002C).setName("Tier2Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x002D).setName("Tier2Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x002E).setName("Tier2Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_2_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x002F).setName("Tier2Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0030).setName("Tier3Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0031).setName("Tier3Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0032).setName("Tier3Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0033).setName("Tier3Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0034).setName("Tier3Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0035).setName("Tier3Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0036).setName("Tier3Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0037).setName("Tier3Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0038).setName("Tier3Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0039).setName("Tier3Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x003A).setName("Tier3Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x003B).setName("Tier3Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x003C).setName("Tier3Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x003D).setName("Tier3Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x003E).setName("Tier3Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_3_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x003F).setName("Tier3Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0040).setName("Tier4Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0041).setName("Tier4Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0042).setName("Tier4Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0043).setName("Tier4Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0044).setName("Tier4Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0045).setName("Tier4Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0046).setName("Tier4Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0047).setName("Tier4Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0048).setName("Tier4Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0049).setName("Tier4Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x004A).setName("Tier4Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x004B).setName("Tier4Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x004C).setName("Tier4Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x004D).setName("Tier4Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x004E).setName("Tier4Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_4_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x004F).setName("Tier4Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0050).setName("Tier5Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0051).setName("Tier5Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0052).setName("Tier5Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0053).setName("Tier5Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0054).setName("Tier5Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0055).setName("Tier5Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0056).setName("Tier5Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0057).setName("Tier5Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0058).setName("Tier5Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0059).setName("Tier5Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x005A).setName("Tier5Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x005B).setName("Tier5Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x005C).setName("Tier5Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x005D).setName("Tier5Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x005E).setName("Tier5Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_5_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x005F).setName("Tier5Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0060).setName("Tier6Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0061).setName("Tier6Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0062).setName("Tier6Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0063).setName("Tier6Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0064).setName("Tier6Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0065).setName("Tier6Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0066).setName("Tier6Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0067).setName("Tier6Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0068).setName("Tier6Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0069).setName("Tier6Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x006A).setName("Tier6Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x006B).setName("Tier6Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x006C).setName("Tier6Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x006D).setName("Tier6Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x006E).setName("Tier6Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_6_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x006F).setName("Tier6Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0070).setName("Tier7Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0071).setName("Tier7Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0072).setName("Tier7Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0073).setName("Tier7Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0074).setName("Tier7Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0075).setName("Tier7Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0076).setName("Tier7Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0077).setName("Tier7Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0078).setName("Tier7Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0079).setName("Tier7Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x007A).setName("Tier7Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x007B).setName("Tier7Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x007C).setName("Tier7Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x007D).setName("Tier7Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x007E).setName("Tier7Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_7_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x007F).setName("Tier7Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0080).setName("Tier8Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0081).setName("Tier8Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0082).setName("Tier8Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0083).setName("Tier8Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0084).setName("Tier8Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0085).setName("Tier8Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0086).setName("Tier8Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0087).setName("Tier8Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0088).setName("Tier8Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0089).setName("Tier8Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x008A).setName("Tier8Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x008B).setName("Tier8Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x008C).setName("Tier8Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x008D).setName("Tier8Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x008E).setName("Tier8Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_8_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x008F).setName("Tier8Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x0090).setName("Tier9Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x0091).setName("Tier9Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x0092).setName("Tier9Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x0093).setName("Tier9Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x0094).setName("Tier9Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x0095).setName("Tier9Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x0096).setName("Tier9Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x0097).setName("Tier9Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x0098).setName("Tier9Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x0099).setName("Tier9Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x009A).setName("Tier9Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x009B).setName("Tier9Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x009C).setName("Tier9Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x009D).setName("Tier9Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x009E).setName("Tier9Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_9_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x009F).setName("Tier9Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00A0).setName("Tier10Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00A1).setName("Tier10Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00A2).setName("Tier10Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00A3).setName("Tier10Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00A4).setName("Tier10Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00A5).setName("Tier10Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00A6).setName("Tier10Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00A7).setName("Tier10Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00A8).setName("Tier10Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00A9).setName("Tier10Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00AA).setName("Tier10Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00AB).setName("Tier10Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00AC).setName("Tier10Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00AD).setName("Tier10Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00AE).setName("Tier10Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_10_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00AF).setName("Tier10Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00B0).setName("Tier11Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00B1).setName("Tier11Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00B2).setName("Tier11Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00B3).setName("Tier11Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00B4).setName("Tier11Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00B5).setName("Tier11Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00B6).setName("Tier11Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00B7).setName("Tier11Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00B8).setName("Tier11Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00B9).setName("Tier11Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00BA).setName("Tier11Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00BB).setName("Tier11Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00BC).setName("Tier11Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00BD).setName("Tier11Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00BE).setName("Tier11Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_11_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00BF).setName("Tier11Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00C0).setName("Tier12Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00C1).setName("Tier12Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00C2).setName("Tier12Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00C3).setName("Tier12Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00C4).setName("Tier12Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00C5).setName("Tier12Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00C6).setName("Tier12Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00C7).setName("Tier12Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00C8).setName("Tier12Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00C9).setName("Tier12Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00CA).setName("Tier12Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00CB).setName("Tier12Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00CC).setName("Tier12Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00CD).setName("Tier12Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00CE).setName("Tier12Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_12_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00CF).setName("Tier12Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00D0).setName("Tier13Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00D1).setName("Tier13Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00D2).setName("Tier13Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00D3).setName("Tier13Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00D4).setName("Tier13Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00D5).setName("Tier13Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00D6).setName("Tier13Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00D7).setName("Tier13Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00D8).setName("Tier13Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00D9).setName("Tier13Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00DA).setName("Tier13Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00DB).setName("Tier13Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00DC).setName("Tier13Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00DD).setName("Tier13Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00DE).setName("Tier13Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_13_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00DF).setName("Tier13Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00E0).setName("Tier14Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00E1).setName("Tier14Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00E2).setName("Tier14Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00E3).setName("Tier14Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00E4).setName("Tier14Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00E5).setName("Tier14Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00E6).setName("Tier14Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00E7).setName("Tier14Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00E8).setName("Tier14Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00E9).setName("Tier14Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00EA).setName("Tier14Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00EB).setName("Tier14Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00EC).setName("Tier14Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00ED).setName("Tier14Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00EE).setName("Tier14Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_14_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00EF).setName("Tier14Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_1_PRICE = new AbstractAttribute()
			.setId(0x00F0).setName("Tier15Block1Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_2_PRICE = new AbstractAttribute()
			.setId(0x00F1).setName("Tier15Block2Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_3_PRICE = new AbstractAttribute()
			.setId(0x00F2).setName("Tier15Block3Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_4_PRICE = new AbstractAttribute()
			.setId(0x00F3).setName("Tier15Block4Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_5_PRICE = new AbstractAttribute()
			.setId(0x00F4).setName("Tier15Block5Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_6_PRICE = new AbstractAttribute()
			.setId(0x00F5).setName("Tier15Block6Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_7_PRICE = new AbstractAttribute()
			.setId(0x00F6).setName("Tier15Block7Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_8_PRICE = new AbstractAttribute()
			.setId(0x00F7).setName("Tier15Block8Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_9_PRICE = new AbstractAttribute()
			.setId(0x00F8).setName("Tier15Block9Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_10_PRICE = new AbstractAttribute()
			.setId(0x00F9).setName("Tier15Block10Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_11_PRICE = new AbstractAttribute()
			.setId(0x00FA).setName("Tier15Block11Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_12_PRICE = new AbstractAttribute()
			.setId(0x00FB).setName("Tier15Block12Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_13_PRICE = new AbstractAttribute()
			.setId(0x00FC).setName("Tier15Block13Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_14_PRICE = new AbstractAttribute()
			.setId(0x00FD).setName("Tier15Block14Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_15_PRICE = new AbstractAttribute()
			.setId(0x00FE).setName("Tier15Block15Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor TIER_15_BLOCK_16_PRICE = new AbstractAttribute()
			.setId(0x00FF).setName("Tier15Block16Price").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger32bit).setWritable(true);

	public static final AttributeDescriptor PRICE_INCREASE_RANDOMIZE_MINUTES = new AbstractAttribute()
			.setId(0x0000).setName("PriceIncreaseRandomizeMinutes")
			.setReportable(false).setZigBeeType(ZigBeeType.UnsignedInteger8bit)
			.setWritable(true);

	public static final AttributeDescriptor PRICE_DECREASE_RANDOMIZE_MINUTES = new AbstractAttribute()
			.setId(0x0001).setName("PriceDecreaseRandomizeMinutes")
			.setReportable(false).setZigBeeType(ZigBeeType.UnsignedInteger8bit)
			.setWritable(true);

	public static final AttributeDescriptor PRICE_COMMODITY_TYPE = new AbstractAttribute()
			.setId(0x0002).setName("PriceCommodityType").setReportable(false)
			.setZigBeeType(ZigBeeType.Enumeration8bit).setWritable(false);

}
