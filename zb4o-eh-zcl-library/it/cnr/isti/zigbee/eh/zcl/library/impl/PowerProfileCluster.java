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

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceIdentification;
import it.cnr.isti.zigbee.eh.zcl.library.api.PowerProfile;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.Attributes;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 * This class represent the <b>Power Profile</b> Cluster as defined
 * by the document:<br>
 * <i>E@H Technical specification </i> public release Version 0.95
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public class PowerProfileCluster extends ZCLClusterBase implements
PowerProfile {

	private static AttributeImpl description;
	private final Attribute[] attributes;

	public PowerProfileCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		description = new AttributeImpl(zbDevice, this, Attributes.DESCRIPTION);

		attributes = new AttributeImpl[] { description };
	}

	@Override
	public short getId() {
		return PowerProfile.ID;
	}

	@Override
	public String getName() {
		return PowerProfile.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeDescription() {
		return description;
	}

}
