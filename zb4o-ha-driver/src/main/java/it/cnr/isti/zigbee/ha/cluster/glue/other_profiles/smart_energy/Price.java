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
 * @version $LastChangedRevision: $ ($LastChangedDate: $)
 * 
 */

public interface Price extends Cluster {

	// tier label
	public String getTier1PriceLabel() throws ZigBeeHAException;

	public String getTier2PriceLabel() throws ZigBeeHAException;

	public String getTier3PriceLabel() throws ZigBeeHAException;

	public String getTier4PriceLabel() throws ZigBeeHAException;

	public String getTier5PriceLabel() throws ZigBeeHAException;

	public String getTier6PriceLabel() throws ZigBeeHAException;

	public String getTier7PriceLabel() throws ZigBeeHAException;

	public String getTier8PriceLabel() throws ZigBeeHAException;

	public String getTier9PriceLabel() throws ZigBeeHAException;

	public String getTier10PriceLabel() throws ZigBeeHAException;

	public String getTier11PriceLabel() throws ZigBeeHAException;

	public String getTier12PriceLabel() throws ZigBeeHAException;

	public String getTier13PriceLabel() throws ZigBeeHAException;

	public String getTier14PriceLabel() throws ZigBeeHAException;

	public String getTier15PriceLabel() throws ZigBeeHAException;

	// block thresold
	public long getBlock1Thresold() throws ZigBeeHAException;

	public long getBlock2Thresold() throws ZigBeeHAException;

	public long getBlock3Thresold() throws ZigBeeHAException;

	public long getBlock4Thresold() throws ZigBeeHAException;

	public long getBlock5Thresold() throws ZigBeeHAException;

	public long getBlock6Thresold() throws ZigBeeHAException;

	public long getBlock7Thresold() throws ZigBeeHAException;

	public long getBlock8Thresold() throws ZigBeeHAException;

	public long getBlock9Thresold() throws ZigBeeHAException;

	public long getBlock10Thresold() throws ZigBeeHAException;

	public long getBlock11Thresold() throws ZigBeeHAException;

	public long getBlock12Thresold() throws ZigBeeHAException;

	public long getBlock13Thresold() throws ZigBeeHAException;

	public long getBlock14Thresold() throws ZigBeeHAException;

	public long getBlock15Thresold() throws ZigBeeHAException;

	// block period
	public Date getStartOfBlockPeriod() throws ZigBeeHAException;

	public int getBlockPeriodDuration() throws ZigBeeHAException;

	public int getThresoldMultiplier() throws ZigBeeHAException;

	public int getThresoldDivisor() throws ZigBeeHAException;

	// commodity period
	public byte getCommodityType() throws ZigBeeHAException;

	public int getStandingCharge() throws ZigBeeHAException;

	// block
	public int getNoTierBlock1Price() throws ZigBeeHAException;

	public int getNoTierBlock2Price() throws ZigBeeHAException;

	public int getNoTierBlock3Price() throws ZigBeeHAException;

	public int getNoTierBlock4Price() throws ZigBeeHAException;

	public int getNoTierBlock5Price() throws ZigBeeHAException;

	public int getNoTierBlock6Price() throws ZigBeeHAException;

	public int getNoTierBlock7Price() throws ZigBeeHAException;

	public int getNoTierBlock8Price() throws ZigBeeHAException;

	public int getNoTierBlock9Price() throws ZigBeeHAException;

	public int getNoTierBlock10Price() throws ZigBeeHAException;

	public int getNoTierBlock11Price() throws ZigBeeHAException;

	public int getNoTierBlock12Price() throws ZigBeeHAException;

	public int getNoTierBlock13Price() throws ZigBeeHAException;

	public int getNoTierBlock14Price() throws ZigBeeHAException;

	public int getNoTierBlock15Price() throws ZigBeeHAException;

	public int getNoTierBlock16Price() throws ZigBeeHAException;

	public int getTier1Block1Price() throws ZigBeeHAException;

	public int getTier1Block2Price() throws ZigBeeHAException;

	public int getTier1Block3Price() throws ZigBeeHAException;

	public int getTier1Block4Price() throws ZigBeeHAException;

	public int getTier1Block5Price() throws ZigBeeHAException;

	public int getTier1Block6Price() throws ZigBeeHAException;

	public int getTier1Block7Price() throws ZigBeeHAException;

	public int getTier1Block8Price() throws ZigBeeHAException;

	public int getTier1Block9Price() throws ZigBeeHAException;

	public int getTier1Block10Price() throws ZigBeeHAException;

	public int getTier1Block11Price() throws ZigBeeHAException;

	public int getTier1Block12Price() throws ZigBeeHAException;

	public int getTier1Block13Price() throws ZigBeeHAException;

	public int getTier1Block14Price() throws ZigBeeHAException;

	public int getTier1Block15Price() throws ZigBeeHAException;

	public int getTier1Block16Price() throws ZigBeeHAException;

	public int getTier2Block1Price() throws ZigBeeHAException;

	public int getTier2Block2Price() throws ZigBeeHAException;

	public int getTier2Block3Price() throws ZigBeeHAException;

	public int getTier2Block4Price() throws ZigBeeHAException;

	public int getTier2Block5Price() throws ZigBeeHAException;

	public int getTier2Block6Price() throws ZigBeeHAException;

	public int getTier2Block7Price() throws ZigBeeHAException;

	public int getTier2Block8Price() throws ZigBeeHAException;

	public int getTier2Block9Price() throws ZigBeeHAException;

	public int getTier2Block10Price() throws ZigBeeHAException;

	public int getTier2Block11Price() throws ZigBeeHAException;

	public int getTier2Block12Price() throws ZigBeeHAException;

	public int getTier2Block13Price() throws ZigBeeHAException;

	public int getTier2Block14Price() throws ZigBeeHAException;

	public int getTier2Block15Price() throws ZigBeeHAException;

	public int getTier2Block16Price() throws ZigBeeHAException;

	public int getTier3Block1Price() throws ZigBeeHAException;

	public int getTier3Block2Price() throws ZigBeeHAException;

	public int getTier3Block3Price() throws ZigBeeHAException;

	public int getTier3Block4Price() throws ZigBeeHAException;

	public int getTier3Block5Price() throws ZigBeeHAException;

	public int getTier3Block6Price() throws ZigBeeHAException;

	public int getTier3Block7Price() throws ZigBeeHAException;

	public int getTier3Block8Price() throws ZigBeeHAException;

	public int getTier3Block9Price() throws ZigBeeHAException;

	public int getTier3Block10Price() throws ZigBeeHAException;

	public int getTier3Block11Price() throws ZigBeeHAException;

	public int getTier3Block12Price() throws ZigBeeHAException;

	public int getTier3Block13Price() throws ZigBeeHAException;

	public int getTier3Block14Price() throws ZigBeeHAException;

	public int getTier3Block15Price() throws ZigBeeHAException;

	public int getTier3Block16Price() throws ZigBeeHAException;

	public int getTier4Block1Price() throws ZigBeeHAException;

	public int getTier4Block2Price() throws ZigBeeHAException;

	public int getTier4Block3Price() throws ZigBeeHAException;

	public int getTier4Block4Price() throws ZigBeeHAException;

	public int getTier4Block5Price() throws ZigBeeHAException;

	public int getTier4Block6Price() throws ZigBeeHAException;

	public int getTier4Block7Price() throws ZigBeeHAException;

	public int getTier4Block8Price() throws ZigBeeHAException;

	public int getTier4Block9Price() throws ZigBeeHAException;

	public int getTier4Block10Price() throws ZigBeeHAException;

	public int getTier4Block11Price() throws ZigBeeHAException;

	public int getTier4Block12Price() throws ZigBeeHAException;

	public int getTier4Block13Price() throws ZigBeeHAException;

	public int getTier4Block14Price() throws ZigBeeHAException;

	public int getTier4Block15Price() throws ZigBeeHAException;

	public int getTier4Block16Price() throws ZigBeeHAException;

	public int getTier5Block1Price() throws ZigBeeHAException;

	public int getTier5Block2Price() throws ZigBeeHAException;

	public int getTier5Block3Price() throws ZigBeeHAException;

	public int getTier5Block4Price() throws ZigBeeHAException;

	public int getTier5Block5Price() throws ZigBeeHAException;

	public int getTier5Block6Price() throws ZigBeeHAException;

	public int getTier5Block7Price() throws ZigBeeHAException;

	public int getTier5Block8Price() throws ZigBeeHAException;

	public int getTier5Block9Price() throws ZigBeeHAException;

	public int getTier5Block10Price() throws ZigBeeHAException;

	public int getTier5Block11Price() throws ZigBeeHAException;

	public int getTier5Block12Price() throws ZigBeeHAException;

	public int getTier5Block13Price() throws ZigBeeHAException;

	public int getTier5Block14Price() throws ZigBeeHAException;

	public int getTier5Block15Price() throws ZigBeeHAException;

	public int getTier5Block16Price() throws ZigBeeHAException;

	public int getTier6Block1Price() throws ZigBeeHAException;

	public int getTier6Block2Price() throws ZigBeeHAException;

	public int getTier6Block3Price() throws ZigBeeHAException;

	public int getTier6Block4Price() throws ZigBeeHAException;

	public int getTier6Block5Price() throws ZigBeeHAException;

	public int getTier6Block6Price() throws ZigBeeHAException;

	public int getTier6Block7Price() throws ZigBeeHAException;

	public int getTier6Block8Price() throws ZigBeeHAException;

	public int getTier6Block9Price() throws ZigBeeHAException;

	public int getTier6Block10Price() throws ZigBeeHAException;

	public int getTier6Block11Price() throws ZigBeeHAException;

	public int getTier6Block12Price() throws ZigBeeHAException;

	public int getTier6Block13Price() throws ZigBeeHAException;

	public int getTier6Block14Price() throws ZigBeeHAException;

	public int getTier6Block15Price() throws ZigBeeHAException;

	public int getTier6Block16Price() throws ZigBeeHAException;

	public int getTier7Block1Price() throws ZigBeeHAException;

	public int getTier7Block2Price() throws ZigBeeHAException;

	public int getTier7Block3Price() throws ZigBeeHAException;

	public int getTier7Block4Price() throws ZigBeeHAException;

	public int getTier7Block5Price() throws ZigBeeHAException;

	public int getTier7Block6Price() throws ZigBeeHAException;

	public int getTier7Block7Price() throws ZigBeeHAException;

	public int getTier7Block8Price() throws ZigBeeHAException;

	public int getTier7Block9Price() throws ZigBeeHAException;

	public int getTier7Block10Price() throws ZigBeeHAException;

	public int getTier7Block11Price() throws ZigBeeHAException;

	public int getTier7Block12Price() throws ZigBeeHAException;

	public int getTier7Block13Price() throws ZigBeeHAException;

	public int getTier7Block14Price() throws ZigBeeHAException;

	public int getTier7Block15Price() throws ZigBeeHAException;

	public int getTier7Block16Price() throws ZigBeeHAException;

	public int getTier8Block1Price() throws ZigBeeHAException;

	public int getTier8Block2Price() throws ZigBeeHAException;

	public int getTier8Block3Price() throws ZigBeeHAException;

	public int getTier8Block4Price() throws ZigBeeHAException;

	public int getTier8Block5Price() throws ZigBeeHAException;

	public int getTier8Block6Price() throws ZigBeeHAException;

	public int getTier8Block7Price() throws ZigBeeHAException;

	public int getTier8Block8Price() throws ZigBeeHAException;

	public int getTier8Block9Price() throws ZigBeeHAException;

	public int getTier8Block10Price() throws ZigBeeHAException;

	public int getTier8Block11Price() throws ZigBeeHAException;

	public int getTier8Block12Price() throws ZigBeeHAException;

	public int getTier8Block13Price() throws ZigBeeHAException;

	public int getTier8Block14Price() throws ZigBeeHAException;

	public int getTier8Block15Price() throws ZigBeeHAException;

	public int getTier8Block16Price() throws ZigBeeHAException;

	public int getTier9Block1Price() throws ZigBeeHAException;

	public int getTier9Block2Price() throws ZigBeeHAException;

	public int getTier9Block3Price() throws ZigBeeHAException;

	public int getTier9Block4Price() throws ZigBeeHAException;

	public int getTier9Block5Price() throws ZigBeeHAException;

	public int getTier9Block6Price() throws ZigBeeHAException;

	public int getTier9Block7Price() throws ZigBeeHAException;

	public int getTier9Block8Price() throws ZigBeeHAException;

	public int getTier9Block9Price() throws ZigBeeHAException;

	public int getTier9Block10Price() throws ZigBeeHAException;

	public int getTier9Block11Price() throws ZigBeeHAException;

	public int getTier9Block12Price() throws ZigBeeHAException;

	public int getTier9Block13Price() throws ZigBeeHAException;

	public int getTier9Block14Price() throws ZigBeeHAException;

	public int getTier9Block15Price() throws ZigBeeHAException;

	public int getTier9Block16Price() throws ZigBeeHAException;

	public int getTier10Block1Price() throws ZigBeeHAException;

	public int getTier10Block2Price() throws ZigBeeHAException;

	public int getTier10Block3Price() throws ZigBeeHAException;

	public int getTier10Block4Price() throws ZigBeeHAException;

	public int getTier10Block5Price() throws ZigBeeHAException;

	public int getTier10Block6Price() throws ZigBeeHAException;

	public int getTier10Block7Price() throws ZigBeeHAException;

	public int getTier10Block8Price() throws ZigBeeHAException;

	public int getTier10Block9Price() throws ZigBeeHAException;

	public int getTier10Block10Price() throws ZigBeeHAException;

	public int getTier10Block11Price() throws ZigBeeHAException;

	public int getTier10Block12Price() throws ZigBeeHAException;

	public int getTier10Block13Price() throws ZigBeeHAException;

	public int getTier10Block14Price() throws ZigBeeHAException;

	public int getTier10Block15Price() throws ZigBeeHAException;

	public int getTier10Block16Price() throws ZigBeeHAException;

	public int getTier11Block1Price() throws ZigBeeHAException;

	public int getTier11Block2Price() throws ZigBeeHAException;

	public int getTier11Block3Price() throws ZigBeeHAException;

	public int getTier11Block4Price() throws ZigBeeHAException;

	public int getTier11Block5Price() throws ZigBeeHAException;

	public int getTier11Block6Price() throws ZigBeeHAException;

	public int getTier11Block7Price() throws ZigBeeHAException;

	public int getTier11Block8Price() throws ZigBeeHAException;

	public int getTier11Block9Price() throws ZigBeeHAException;

	public int getTier11Block10Price() throws ZigBeeHAException;

	public int getTier11Block11Price() throws ZigBeeHAException;

	public int getTier11Block12Price() throws ZigBeeHAException;

	public int getTier11Block13Price() throws ZigBeeHAException;

	public int getTier11Block14Price() throws ZigBeeHAException;

	public int getTier11Block15Price() throws ZigBeeHAException;

	public int getTier11Block16Price() throws ZigBeeHAException;

	public int getTier12Block1Price() throws ZigBeeHAException;

	public int getTier12Block2Price() throws ZigBeeHAException;

	public int getTier12Block3Price() throws ZigBeeHAException;

	public int getTier12Block4Price() throws ZigBeeHAException;

	public int getTier12Block5Price() throws ZigBeeHAException;

	public int getTier12Block6Price() throws ZigBeeHAException;

	public int getTier12Block7Price() throws ZigBeeHAException;

	public int getTier12Block8Price() throws ZigBeeHAException;

	public int getTier12Block9Price() throws ZigBeeHAException;

	public int getTier12Block10Price() throws ZigBeeHAException;

	public int getTier12Block11Price() throws ZigBeeHAException;

	public int getTier12Block12Price() throws ZigBeeHAException;

	public int getTier12Block13Price() throws ZigBeeHAException;

	public int getTier12Block14Price() throws ZigBeeHAException;

	public int getTier12Block15Price() throws ZigBeeHAException;

	public int getTier12Block16Price() throws ZigBeeHAException;

	public int getTier13Block1Price() throws ZigBeeHAException;

	public int getTier13Block2Price() throws ZigBeeHAException;

	public int getTier13Block3Price() throws ZigBeeHAException;

	public int getTier13Block4Price() throws ZigBeeHAException;

	public int getTier13Block5Price() throws ZigBeeHAException;

	public int getTier13Block6Price() throws ZigBeeHAException;

	public int getTier13Block7Price() throws ZigBeeHAException;

	public int getTier13Block8Price() throws ZigBeeHAException;

	public int getTier13Block9Price() throws ZigBeeHAException;

	public int getTier13Block10Price() throws ZigBeeHAException;

	public int getTier13Block11Price() throws ZigBeeHAException;

	public int getTier13Block12Price() throws ZigBeeHAException;

	public int getTier13Block13Price() throws ZigBeeHAException;

	public int getTier13Block14Price() throws ZigBeeHAException;

	public int getTier13Block15Price() throws ZigBeeHAException;

	public int getTier13Block16Price() throws ZigBeeHAException;

	public int getTier14Block1Price() throws ZigBeeHAException;

	public int getTier14Block2Price() throws ZigBeeHAException;

	public int getTier14Block3Price() throws ZigBeeHAException;

	public int getTier14Block4Price() throws ZigBeeHAException;

	public int getTier14Block5Price() throws ZigBeeHAException;

	public int getTier14Block6Price() throws ZigBeeHAException;

	public int getTier14Block7Price() throws ZigBeeHAException;

	public int getTier14Block8Price() throws ZigBeeHAException;

	public int getTier14Block9Price() throws ZigBeeHAException;

	public int getTier14Block10Price() throws ZigBeeHAException;

	public int getTier14Block11Price() throws ZigBeeHAException;

	public int getTier14Block12Price() throws ZigBeeHAException;

	public int getTier14Block13Price() throws ZigBeeHAException;

	public int getTier14Block14Price() throws ZigBeeHAException;

	public int getTier14Block15Price() throws ZigBeeHAException;

	public int getTier14Block16Price() throws ZigBeeHAException;

	public int getTier15Block1Price() throws ZigBeeHAException;

	public int getTier15Block2Price() throws ZigBeeHAException;

	public int getTier15Block3Price() throws ZigBeeHAException;

	public int getTier15Block4Price() throws ZigBeeHAException;

	public int getTier15Block5Price() throws ZigBeeHAException;

	public int getTier15Block6Price() throws ZigBeeHAException;

	public int getTier15Block7Price() throws ZigBeeHAException;

	public int getTier15Block8Price() throws ZigBeeHAException;

	public int getTier15Block9Price() throws ZigBeeHAException;

	public int getTier15Block10Price() throws ZigBeeHAException;

	public int getTier15Block11Price() throws ZigBeeHAException;

	public int getTier15Block12Price() throws ZigBeeHAException;

	public int getTier15Block13Price() throws ZigBeeHAException;

	public int getTier15Block14Price() throws ZigBeeHAException;

	public int getTier15Block15Price() throws ZigBeeHAException;

	public int getTier15Block16Price() throws ZigBeeHAException;

	public byte getPriceIncreaseRandomizeMinutes() throws ZigBeeHAException;

	public byte getPriceDecreaseRandomizeMinutes() throws ZigBeeHAException;

	public byte getPriceCommodityType() throws ZigBeeHAException;

}
