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

package it.cnr.isti.zigbee.ha;

import it.cnr.isti.zigbee.ha.cluster.factory.HAClustersFactory;
import it.cnr.isti.zigbee.ha.device.factory.ColorDimmableLightFactory;
import it.cnr.isti.zigbee.ha.device.factory.DimmableLightFactory;
import it.cnr.isti.zigbee.ha.device.factory.IASAncillaryControlEquipmentFactory;
import it.cnr.isti.zigbee.ha.device.factory.IASControlAndIndicatingEquipmentFactory;
import it.cnr.isti.zigbee.ha.device.factory.IASWarningDeviceFactory;
import it.cnr.isti.zigbee.ha.device.factory.IAS_ZoneFactory;
import it.cnr.isti.zigbee.ha.device.factory.LevelControlSwitchFactory;
import it.cnr.isti.zigbee.ha.device.factory.LightSensorFactory;
import it.cnr.isti.zigbee.ha.device.factory.MainsPowerOutletFactory;
import it.cnr.isti.zigbee.ha.device.factory.OccupancySensorFactory;
import it.cnr.isti.zigbee.ha.device.factory.OnOffLightFactory;
import it.cnr.isti.zigbee.ha.device.factory.OnOffLightSwitchFactory;
import it.cnr.isti.zigbee.ha.device.factory.OnOffOutputFactory;
import it.cnr.isti.zigbee.ha.device.factory.OnOffSwitchFactory;
import it.cnr.isti.zigbee.ha.device.factory.PumpFactory;
import it.cnr.isti.zigbee.ha.device.factory.TemperatureSensorFactory;
import it.cnr.isti.zigbee.ha.device.impl.GenericHADevice;
import it.cnr.isti.zigbee.ha.driver.HADriverConfiguration;
import it.cnr.isti.zigbee.ha.driver.HAImporter;
import it.cnr.isti.zigbee.ha.driver.core.GenericHADeviceFactory;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceFactoryBase;
import it.cnr.isti.zigbee.ha.driver.core.ReportingConfiguration;

import java.util.ArrayList;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class Activator implements BundleActivator {

	private static final String HA_CONFIG_PID = "it.cnr.isti.zigbee.ha.configuration";

	private HAImporter haImporter;

	private final ArrayList<HADeviceFactoryBase> factories = new ArrayList<HADeviceFactoryBase>();

	private ServiceRegistration configRegistration;

	private static HADriverConfiguration configuration = null;


	private void doRegisterConfigurationService(BundleContext ctx){
		Properties properties = new Properties();

		properties.setProperty(Constants.SERVICE_PID, HA_CONFIG_PID);

		configuration = new HADriverConfiguration(ctx);
		configRegistration = ctx.registerService(
				new String[]{ManagedService.class.getName(), ReportingConfiguration.class.getName()}, 
				configuration, 
				null
				);
	}

	public void start(BundleContext ctx) throws Exception {

		doRegisterConfigurationService(ctx);

		new HAClustersFactory(ctx).register();
        //TODO Replace all specific Factory with GenericHADeviceFactory
		//factories.add(new GenericHADeviceFactory(ctx, HADevice.class, GenericHADevice.class).register());

		factories.add(new ColorDimmableLightFactory(ctx).register());

		factories.add(new DimmableLightFactory(ctx).register());

		factories.add(new IAS_ZoneFactory(ctx).register());

		factories.add(new IASAncillaryControlEquipmentFactory(ctx).register());

		factories.add(new IASControlAndIndicatingEquipmentFactory(ctx).register());

		factories.add(new IASWarningDeviceFactory(ctx).register());

		factories.add(new LevelControlSwitchFactory(ctx).register());

		factories.add(new LightSensorFactory(ctx).register());

		factories.add(new MainsPowerOutletFactory(ctx).register());

		factories.add(new OccupancySensorFactory(ctx).register());

		factories.add(new OnOffLightFactory(ctx).register());		

		factories.add(new OnOffLightSwitchFactory(ctx).register());

		factories.add(new OnOffOutputFactory(ctx).register());

		factories.add(new OnOffSwitchFactory(ctx).register());

		factories.add(new PumpFactory(ctx).register());	

		factories.add(new TemperatureSensorFactory(ctx).register());

		haImporter = new HAImporter(ctx);
	}

	public void stop(BundleContext context) throws Exception {
		haImporter.close();

		for (HADeviceFactoryBase factory : factories) {
			factory.unregister();
		}

	}

	public static HADriverConfiguration getConfiguration(){
		return configuration;
    }
}