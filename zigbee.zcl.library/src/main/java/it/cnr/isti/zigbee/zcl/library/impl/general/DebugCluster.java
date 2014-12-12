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

package it.cnr.isti.zigbee.zcl.library.impl.general;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.general.Debug;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.DebugAttributes;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.9.0
 *
 */
public class DebugCluster extends ZCLClusterBase implements Debug {

	private final AttributeImpl uInt24;
	private final AttributeImpl uInt32;
	private final AttributeImpl uInt40;
	private final AttributeImpl uInt48;
	private final AttributeImpl uInt56;
	private final AttributeImpl uInt64;
	private final AttributeImpl sInt24;
	private final AttributeImpl sInt32;
	private final AttributeImpl sInt40;
	private final AttributeImpl sInt48;
	private final AttributeImpl sInt56;
	private final AttributeImpl sInt64;

	private final Attribute[] attributes;

	public DebugCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		uInt24 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT24);
		uInt32 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT32);
		uInt40 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT40);
		uInt48 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT48);
		uInt56 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT56);
		uInt64 = new AttributeImpl(zbDevice, this, DebugAttributes.UINT64);

		sInt24 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT24);
		sInt32 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT32);
		sInt40 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT40);
		sInt48 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT48);
		sInt56 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT56);
		sInt64 = new AttributeImpl(zbDevice, this, DebugAttributes.SINT64);

		attributes = new AttributeImpl[] { uInt24, uInt32, uInt40, uInt48,
				uInt56, uInt64, sInt24, sInt32, sInt40, sInt48, sInt56, sInt64 };
	}

	@Override
	public short getId() {
		return Debug.ID;
	}

	@Override
	public String getName() {
		return Debug.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeUint24() {

		return uInt24;
	}

	public Attribute getAttributeUint32() {

		return uInt32;
	}

	public Attribute getAttributeUint40() {

		return uInt40;
	}

	public Attribute getAttributeUint48() {

		return uInt48;
	}

	public Attribute getAttributeUint56() {
		
		return uInt56;
	}

	public Attribute getAttributeUint64() {
		
		return uInt64;
	}

	public Attribute getAttributeSint24() {
		
		return sInt24;
	}

	public Attribute getAttributeSint32() {
		return sInt32;
		
	}

	public Attribute getAttributeSint40() {
		
		return sInt40;
	}

	public Attribute getAttributeSint48() {
	
		return sInt48;
	}

	public Attribute getAttributeSint56() {
		
		return sInt56;
	}

	public Attribute getAttributeSint64() {
	
		return sInt64;
	}

}
