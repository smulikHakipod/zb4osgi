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
public class AttributesDemandResponseAndLoadControl {

	public static final AttributeDescriptor UTILITY_ENROLMENT_GROUP = new AbstractAttribute()
			.setId(0x0000).setName("UtilityEnrolmentGroup")
			.setReportable(false).setZigBeeType(ZigBeeType.UnsignedInteger8bit)
			.setWritable(true);
	public static final AttributeDescriptor START_RANDOMIZE_MINUTES = new AbstractAttribute()
			.setId(0x0000).setName("StartRandomizeMinutes")
			.setReportable(false).setZigBeeType(ZigBeeType.UnsignedInteger8bit)
			.setWritable(true);
	public static final AttributeDescriptor STOP_RANDOMIZE_MINUTES = new AbstractAttribute()
			.setId(0x0000).setName("StopRandomizeMinutes").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger8bit).setWritable(true);
	public static final AttributeDescriptor DEVICE_CLASS_VALUE = new AbstractAttribute()
			.setId(0x0000).setName("DeviceClassValue").setReportable(false)
			.setZigBeeType(ZigBeeType.UnsignedInteger16bit).setWritable(true);
}
