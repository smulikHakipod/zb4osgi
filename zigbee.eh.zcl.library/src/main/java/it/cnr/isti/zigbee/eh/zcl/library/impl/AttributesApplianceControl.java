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

package it.cnr.isti.zigbee.eh.zcl.library.impl;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AbstractAttribute;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.AttributeDescriptor;
/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 937 $ ($LastChangedDate: 2014-01-30 18:47:48 +0100 (gio, 30 gen 2014) $)
 */
public class AttributesApplianceControl  {
   


		
	
	
	public static final AttributeDescriptor BASIC_IDENTIFICATION = new AbstractAttribute()
	    .setId(0x0000)
	    .setName("basicIdentification")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.Bitmap56bit)
	    .setWritable(false);
	 public static final AttributeDescriptor COMPANY_NAME = new AbstractAttribute()
	    .setId(0x0010)
	    .setName("companyName")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.CharacterString)
	    .setWritable(false);
	 public static final AttributeDescriptor COMPANY_ID = new AbstractAttribute()
	    .setId(0x0011)
	    .setName("companyId")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
	    .setWritable(false);
	 public static final AttributeDescriptor BRAND_NAME = new AbstractAttribute()
	    .setId(0x0012)
	    .setName("brandName")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.CharacterString)
	    .setWritable(false);
	 public static final AttributeDescriptor BRAND_ID = new AbstractAttribute()
	    .setId(0x0013)
	    .setName("brandId")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
	    .setWritable(false);
	 public static final AttributeDescriptor MODEL = new AbstractAttribute()
	    .setId(0x0014)
	    .setName("model")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.OctectString)
	    .setWritable(false);
	 public static final AttributeDescriptor PART_NUMBER = new AbstractAttribute()
	    .setId(0x0015)
	    .setName("partNumber")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.OctectString)
	    .setWritable(false);
	 public static final AttributeDescriptor PRODUCT_REVISION = new AbstractAttribute()
	    .setId(0x0016)
	    .setName("productRevision")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.OctectString)
	    .setWritable(false);
	 public static final AttributeDescriptor SOFTWARE_REVISION = new AbstractAttribute()
	    .setId(0x0017)
	    .setName("softwareRevision")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.OctectString)
	    .setWritable(false);
	 public static final AttributeDescriptor PRODUCT_TYPE_NAME = new AbstractAttribute()
	    .setId(0x0018)
	    .setName("productTypeName")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.OctectString)
	    .setWritable(false);
	 public static final AttributeDescriptor PRODUCT_TYPE_ID = new AbstractAttribute()
	    .setId(0x0019)
	    .setName("productTypeId")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.UnsignedInteger16bit)
	    .setWritable(false);
	 public static final AttributeDescriptor CECED_SPECIFICATION_VERSION = new AbstractAttribute()
	    .setId(0x001A)
	    .setName("CECEDSpecificationVersion")
	    .setReportable(false)
	    .setZigBeeType(ZigBeeType.UnsignedInteger8bit)
	    .setWritable(false);
	 
	 
	 
	 
}