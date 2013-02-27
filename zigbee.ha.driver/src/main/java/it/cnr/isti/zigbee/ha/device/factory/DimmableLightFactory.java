/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.ha.device.factory;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.device.api.lighting.DimmableLight;
import it.cnr.isti.zigbee.ha.device.impl.DimmableLightDevice;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceBase;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceFactoryBase;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco</a>
 *         
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 *
 */
public class DimmableLightFactory extends HADeviceFactoryBase {

	public DimmableLightFactory(BundleContext ctx) {
		super(ctx, DimmableLight.class);
	}

	private String[] clusters;
	private String[] implementedInterfaces = { 
			HADevice.class.getName(), 
			HADeviceBase.class.getName(),
			DimmableLight.class.getName()
	};

	@Override
	public String getDeviceId() {
		return String.valueOf(DimmableLightDevice.DEVICE_ID);
	}

	@Override
	public String[] getRefinedInterfaces() {
		return implementedInterfaces;
	}

	@Override
	public HADeviceBase getInstance(ZigBeeDevice zbDevice) throws ZigBeeHAException {
		return new DimmableLightDevice(ctx, zbDevice);
	}
}