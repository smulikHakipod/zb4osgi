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
package it.cnr.isti.basedriver.stub;

import it.cnr.isti.basedriver.stub.api.impl.StubZigBeeNode;
import it.cnr.isti.basedriver.stub.api.impl.StubZigbeeDeviceBase;
import it.cnr.isti.basedriver.stub.api.impl.HA.OnOffSwitchDevice;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;

import java.util.ArrayList;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2014-02-07 18:52:09
 *          +0100(ven, 07 feb 2014) $)
 * @since 0.1.0
 * 
 */
public class Activator implements BundleActivator {

	private ArrayList<ServiceRegistration> services = new ArrayList<ServiceRegistration>();

	/**
	 * 
	 * @param bc
	 * @param device
	 * @since 0.2.0 - Revision 118
	 */
	private void registerDevice(BundleContext bc, StubZigbeeDeviceBase device) {

		System.out.println("Registering {} " + device.getClass().getName());

		ServiceRegistration reg = bc.registerService(
				ZigBeeDevice.class.getName(), device, device.getDescription());

		services.add(reg);

	}

	public void start(BundleContext context) throws Exception {

		ZigBeeNode alpha = new StubZigBeeNode("11:22:33:44:55:66:77:88", 0x0100);
		ZigBeeNode beta = new StubZigBeeNode("01:02:03:04:05:06:07:08", 0x0010);
		ZigBeeNode gamma = new StubZigBeeNode("99:AA:BB:CC:DD:EE:FF:00", 0x1000);

		// OnOffOutputDevice[] devices = new OnOffOutputDevice[3];
		// OnOffLightDevice[] lights = new OnOffLightDevice[4];
		OnOffSwitchDevice[] switches = new OnOffSwitchDevice[5];
		switches[0] = new OnOffSwitchDevice(111, gamma);
		switches[1] = new OnOffSwitchDevice(145, gamma);
		switches[2] = new OnOffSwitchDevice(21, gamma);
		switches[3] = new OnOffSwitchDevice(5, gamma);
		switches[4] = new OnOffSwitchDevice(77, gamma);
		registerDevice(context, switches[0]);
		registerDevice(context, switches[1]);
		registerDevice(context, switches[2]);
		registerDevice(context, switches[3]);
		registerDevice(context, switches[4]);

		// for ( int i = 0; i < switches.length; i++ ) {
		// switches[i] = new OnOffSwitchDevice((i+2)*3,gamma);
		// registerDevice( context, switches[i] );
		// }
		// int i = 0;
		// while ( i < devices.length && i < lights.length ){
		// devices[i] = new OnOffOutputDevice((i+2)*3,alpha);
		// registerDevice( context, devices[i] );
		//
		// lights[i] = new OnOffLightDevice((i+2)*3+1,alpha);
		// registerDevice( context, lights[i] );
		// i++;
		// }
		// while ( i < devices.length ){
		// devices[i] = new OnOffOutputDevice(i*3,beta);
		// registerDevice( context, devices[i] );
		// i++;
		// }
		// while ( i < lights.length ){
		// lights[i] = new OnOffLightDevice(i*3,beta);
		// registerDevice( context, lights[i] );
		// i++;
		// }
		// DosageSensorDevice HCdummy = new DosageSensorDevice(75,beta);
		// registerDevice( context, HCdummy );
		//
		// FloodDetectorDevice flood = new FloodDetectorDevice(78,gamma);
		// registerDevice( context, flood );
		//
		// CurtainActuatorDevice curtain = new CurtainActuatorDevice(77,alpha);
		// registerDevice( context, curtain );
		//
		// EnergyDummyDevice EHdummy = new EnergyDummyDevice(75,beta);
		// registerDevice( context, EHdummy );

	}

	public void stop(BundleContext context) throws Exception {
		for (ServiceRegistration registration : services) {
			registration.unregister();
		}
	}

}
