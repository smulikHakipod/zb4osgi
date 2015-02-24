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
import it.cnr.isti.zigbee.zcl.library.api.general.Proprietary;
import it.cnr.isti.zigbee.zcl.library.impl.attribute.ProprietaryAttributes;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.9.0
 *
 */
public class ProprietaryCluster extends ZCLClusterBase implements Proprietary {

	private final AttributeImpl eP1Enable;
	private final AttributeImpl voltageCostant;
	private final AttributeImpl currentCostant;
	private final AttributeImpl voltageRMS;
	private final AttributeImpl currentRMS;
	private final AttributeImpl eP2Enable;
	private final AttributeImpl eP3Enable;
	private final AttributeImpl eP4EP5Enable;
	private final AttributeImpl eP9Enable;

	private final Attribute[] attributes;

	public ProprietaryCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);
		eP1Enable = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.EP1ENABLE);
		voltageCostant = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.VOLTAGECOSTANT);
		currentCostant = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.CURRENTCOSTANT);
		voltageRMS = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.VOLTAGERMS);
		currentRMS = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.CURRENTRMS);
		eP2Enable = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.EP2ENABLE);
		eP3Enable = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.EP3ENABLE);
		eP4EP5Enable = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.EP4EP5ENABLE);
		eP9Enable = new AttributeImpl(zbDevice, this,
				ProprietaryAttributes.EP9ENABLE);

		attributes = new AttributeImpl[] { eP1Enable, voltageCostant,
				currentCostant, voltageRMS, currentRMS, eP2Enable, eP3Enable,
				eP4EP5Enable, eP9Enable };
	}

	public Attribute getAttributeEP1Enable() {
		return eP1Enable;
	}

	public Attribute getAttributeVoltageCostant() {
		return voltageCostant;
	}

	public Attribute getAttributeCurrentCostant() {
		return currentCostant;
	}

	public Attribute getAttributeVoltageRMS() {
		return voltageRMS;
	}

	public Attribute getAttributeCurrentRMS() {
		return currentRMS;
	}

	public Attribute getAttributeEP2Enable() {
		return eP2Enable;
	}

	public Attribute getAttributeEP3Enable() {
		return eP3Enable;
	}

	public Attribute getAttributeEP4EP5Enable() {
		return eP4EP5Enable;
	}

	public Attribute getAttributeEP9Enable() {
		return eP9Enable;
	}

	@Override
	public short getId() {
		return Proprietary.ID;
	}

	@Override
	public String getName() {
		return Proprietary.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

}
