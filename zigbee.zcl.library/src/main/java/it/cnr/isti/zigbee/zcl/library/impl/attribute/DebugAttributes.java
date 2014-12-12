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
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48 +0100 (gio, 30 gen 2014) $)
 */
public class DebugAttributes  {
   

	public static final AttributeDescriptor UINT24 = new AbstractAttribute()
    .setId(0x0000)
    .setName("UnsignedInteger24bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT24 = new AbstractAttribute()
    .setId(0x0001)
    .setName("SignedInteger24bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger24bit)
    .setWritable(true);
	
	public static final AttributeDescriptor UINT32 = new AbstractAttribute()
    .setId(0x0002)
    .setName("UnsignedInteger32bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger24bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT32 = new AbstractAttribute()
    .setId(0x0003)
    .setName("SignedInteger32bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger32bit)
    .setWritable(true);
	
	public static final AttributeDescriptor UINT40 = new AbstractAttribute()
    .setId(0x0004)
    .setName("UnsignedInteger40bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger40bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT40 = new AbstractAttribute()
    .setId(0x0005)
    .setName("SignedInteger40bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger40bit)
    .setWritable(true);
	
	public static final AttributeDescriptor UINT48 = new AbstractAttribute()
    .setId(0x0006)
    .setName("UnsignedInteger48bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger48bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT48 = new AbstractAttribute()
    .setId(0x0007)
    .setName("SignedInteger48bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger48bit)
    .setWritable(true);
	
	public static final AttributeDescriptor UINT56 = new AbstractAttribute()
    .setId(0x0008)
    .setName("UnsignedInteger56bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger56bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT56 = new AbstractAttribute()
    .setId(0x0009)
    .setName("SignedInteger56bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger56bit)
    .setWritable(true);
	
	
	public static final AttributeDescriptor UINT64 = new AbstractAttribute()
    .setId(0x000A)
    .setName("UnsignedInteger64bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.UnsignedInteger64bit)
    .setWritable(true);
	
	public static final AttributeDescriptor SINT64 = new AbstractAttribute()
    .setId(0x000B)
    .setName("SignedInteger64bit")
    .setReportable(false)
    .setZigBeeType(ZigBeeType.SignedInteger64bit)
    .setWritable(true);	
	
}
