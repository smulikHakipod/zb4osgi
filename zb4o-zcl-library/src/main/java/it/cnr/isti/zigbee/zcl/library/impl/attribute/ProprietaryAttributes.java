/*
   Copyright 2008-2014 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.zcl.library.impl.attribute;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;


/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48
 *          +0100 (gio, 30 gen 2014) $)
 */
public class ProprietaryAttributes {

	

	public static final AttributeDescriptor EP1ENABLE = new AbstractAttribute()
    .setId(0x0000)
    .setName("EP1Enable")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Boolean)
    .setWritable(true);
	
	public static final AttributeDescriptor VOLTAGECOSTANT = new AbstractAttribute()
    .setId(0x0001)
    .setName("VoltageCostant")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SinglePrecision)
    .setWritable(true);
	
	
	public static final AttributeDescriptor CURRENTCOSTANT = new AbstractAttribute()
    .setId(0x0002)
    .setName("EurrentCostant")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SinglePrecision)
    .setWritable(true);

	public static final AttributeDescriptor VOLTAGERMS = new AbstractAttribute()
    .setId(0x0003)
    .setName("VoltageRMS")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SinglePrecision)
    .setWritable(false);
	
	public static final AttributeDescriptor EP3ENABLE = new AbstractAttribute()
    .setId(0x0020)
    .setName("EP3Enable")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Boolean)
    .setWritable(true);
	
	public static final AttributeDescriptor EP2ENABLE = new AbstractAttribute()
    .setId(0x0010)
    .setName("EP2Enable")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Boolean)
    .setWritable(true);

	public static final AttributeDescriptor CURRENTRMS = new AbstractAttribute()
    .setId(0x0004)
    .setName("CurrentRMS")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SinglePrecision)
    .setWritable(false);
	
	public static final AttributeDescriptor EP9ENABLE = new AbstractAttribute()
    .setId(0x0040)
    .setName("EP9Enable")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Boolean)
    .setWritable(true);
	
	public static final AttributeDescriptor EP4EP5ENABLE = new AbstractAttribute()
    .setId(0x0030)
    .setName("EP4EP5Enable")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.Boolean)
    .setWritable(true);

}
