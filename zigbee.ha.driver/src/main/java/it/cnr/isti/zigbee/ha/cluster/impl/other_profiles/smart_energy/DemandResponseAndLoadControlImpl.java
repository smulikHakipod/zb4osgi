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

package it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.other_profiles.smart_energy.DemandResponseAndLoadControl;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.se.zcl.library.impl.DemandResponseAndLoadControlCluster;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: $ ($LastChangedDate: $)
 * 
 */

public class DemandResponseAndLoadControlImpl implements
		DemandResponseAndLoadControl {

	private DemandResponseAndLoadControlCluster demandResponseAndLoadControlCluster;

	public DemandResponseAndLoadControlImpl(ZigBeeDevice zbDevice) {
		demandResponseAndLoadControlCluster = new DemandResponseAndLoadControlCluster(
				zbDevice);

	}

	public int getId() {

		return demandResponseAndLoadControlCluster.getId();
	}

	public String getName() {

		return demandResponseAndLoadControlCluster.getName();
	}

	public Subscription[] getActiveSubscriptions() {
		return demandResponseAndLoadControlCluster.getActiveSubscriptions();
	}

	public Attribute[] getAttributes() {

		return demandResponseAndLoadControlCluster.getAvailableAttributes();
	}

	public Attribute getAttribute(int id) {
		Attribute[] attributes = demandResponseAndLoadControlCluster
				.getAvailableAttributes();
		for (int i = 0; i < attributes.length; i++) {
			if (attributes[i].getId() == id)
				return attributes[i];
		}
		return null;
	}

	public byte UtilityEnrolmentGroup() throws ZigBeeHAException {
		try {
			return (Byte) demandResponseAndLoadControlCluster
					.getAttributeUtilityEnrolmentGroup().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte StartRandomizeMinutes() throws ZigBeeHAException {
		try {
			return (Byte) demandResponseAndLoadControlCluster
					.getAttributeStartRandomizeMinutes().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public byte StopRandomizeMinutes() throws ZigBeeHAException {
		try {
			return (Byte) demandResponseAndLoadControlCluster
					.getAttributeStopRandomizeMinutes().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

	public short getDeviceClassValue() throws ZigBeeHAException {
		try {
			return (Short) demandResponseAndLoadControlCluster
					.getAttributeDeviceClassValue().getValue();
		} catch (ZigBeeClusterException e) {
			throw new ZigBeeHAException(e);
		}
	}

}