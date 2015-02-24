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

package it.cnr.isti.zigbee.ha.cluster.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.general.ProprietaryGlue;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.impl.general.ProprietaryCluster;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @since 0.1.0
 *
 */
public class ProprietaryImpl implements ProprietaryGlue {

	private final ProprietaryCluster proprietaryCluster;

	private final Attribute eP1Enable;
	private final Attribute voltageCostant;
	private final Attribute currentCostant;
	private final Attribute voltageRMS;
	private final Attribute currentRMS;
	private final Attribute eP2Enable;
	private final Attribute eP3Enable;
	private final Attribute eP4EP5Enable;
	private final Attribute eP9Enable;

	public ProprietaryImpl(ZigBeeDevice zbDevice) {
		proprietaryCluster = new ProprietaryCluster(zbDevice);

		eP1Enable = proprietaryCluster.getAttributeEP1Enable();
		voltageCostant = proprietaryCluster.getAttributeVoltageCostant();
		currentCostant = proprietaryCluster.getAttributeCurrentCostant();
		voltageRMS = proprietaryCluster.getAttributeVoltageRMS();
		currentRMS = proprietaryCluster.getAttributeCurrentRMS();
		eP2Enable = proprietaryCluster.getAttributeEP2Enable();
		eP3Enable = proprietaryCluster.getAttributeEP3Enable();
		eP4EP5Enable = proprietaryCluster.getAttributeEP4EP5Enable();
		eP9Enable = proprietaryCluster.getAttributeEP9Enable();

	}

	public Attribute[] getAttributes() {
		return proprietaryCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = proprietaryCluster.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}

	public Subscription[] getActiveSubscriptions() {
		return proprietaryCluster.getActiveSubscriptions();
	}

	public int getId() {
		return proprietaryCluster.getId();
	}

	public String getName() {
		return proprietaryCluster.getName();
	}

	public boolean getAttributeEP1Enable() throws ZigBeeHAException {
		try {
			return (Boolean) eP1Enable.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getAttributeVoltageCostant() throws ZigBeeHAException {
		try {
			return (Float) voltageCostant.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getAttributeCurrentCostant() throws ZigBeeHAException {
		try {
			return (Float) currentCostant.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getAttributeVoltageRMS() throws ZigBeeHAException {
		try {
			return (Float) voltageRMS.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public float getAttributeCurrentRMS() throws ZigBeeHAException {
		try {
			return (Float) currentRMS.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public boolean getAttributeEP2Enable() throws ZigBeeHAException {
		try {
			return (Boolean) eP2Enable.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public boolean getAttributeEP3Enable() throws ZigBeeHAException {
		try {
			return (Boolean) eP3Enable.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public boolean getAttributeEP4EP5Enable() throws ZigBeeHAException {
		try {
			return (Boolean) eP4EP5Enable.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public boolean getAttributeEP9Enable() throws ZigBeeHAException {
		try {
			return (Boolean) eP9Enable.getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

}
