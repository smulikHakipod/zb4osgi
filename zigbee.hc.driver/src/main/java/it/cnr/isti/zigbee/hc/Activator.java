/*
   Copyright 2013-2013 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.hc;

import it.cnr.isti.zigbee.hc.driver.HCDriverConfiguration;
import it.cnr.isti.zigbee.hc.driver.HCImporter;
import it.cnr.isti.zigbee.hc.driver.HCReportingConfiguration;
import it.cnr.isti.zigbee.hc.driver.core.GenericHCDeviceFactory;
import it.cnr.isti.zigbee.hc.driver.core.HCClustersFactory;
import it.cnr.isti.zigbee.hc.driver.core.HCDeviceFactoryBase;
import it.cnr.isti.zigbee.hc.driver.core.UnknowHCDeviceFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2014-01-09 19:07:02
 *          +0100 (gio, 09 gen 2014) $)
 * 
 */
public class Activator implements BundleActivator {

	private final static Logger logger = LoggerFactory
			.getLogger(Activator.class);

	private static final String HC_CONFIG_PID = "it.cnr.isti.zigbee.hc.configuration";

	private HCImporter hcImporter;

	private final ArrayList<HCDeviceFactoryBase> factories = new ArrayList<HCDeviceFactoryBase>();

	private ServiceRegistration configRegistration;

	private static HCDriverConfiguration configuration = null;

	private void doRegisterConfigurationService(BundleContext ctx) {
		Properties properties = new Properties();

		properties.setProperty(Constants.SERVICE_PID, HC_CONFIG_PID);

		configuration = new HCDriverConfiguration(ctx);
		configRegistration = ctx.registerService(
				new String[] { ManagedService.class.getName(),
						HCReportingConfiguration.class.getName() },
				configuration, null);
	}

	public void start(BundleContext ctx) throws Exception {
		doRegisterConfigurationService(ctx);
		new HCClustersFactory(ctx).register();
		doRegisterDeviceFactories(ctx);
		hcImporter = new HCImporter(ctx);
	}

	private void doRegisterDeviceFactories(final BundleContext bc)
			throws Exception {
		Map<Class<?>, Class<?>> refinedAvailables = new HashMap<Class<?>, Class<?>>();
	//	refinedAvailables.put(DosageSensor.class, DosageSensorDevice.class);

		  final Iterator< Entry<Class<?>, Class<?>> > i = refinedAvailables.entrySet().iterator();
	        while ( i.hasNext() ) {
	            Entry<Class<?>, Class<?>> refining = i.next();
	            try {
	                factories.add( new GenericHCDeviceFactory( bc, refining.getKey(), refining.getValue() ).register() );
	            } catch ( Exception ex) {
	                logger.error( "Failed to register GenericHCDeviceFactory for " + refining.getKey(), ex );
	            }
	        }

	        try {
	            factories.add( new UnknowHCDeviceFactory( bc ).register() );
	        } catch ( Exception ex) {
	            logger.error( "Failed to register UnknowHCDeviceFactory", ex );
	        }
	    }

	public void stop(BundleContext context) throws Exception {
		hcImporter.close();

		for (HCDeviceFactoryBase factory : factories) {
			factory.unregister();
		}

	}

	public static HCDriverConfiguration getConfiguration() {
		return configuration;
	}
}