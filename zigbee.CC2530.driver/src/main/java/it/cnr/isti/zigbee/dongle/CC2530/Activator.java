/*
   Copyright 2008-2011 CNR-ISTI, http://isti.cnr.it
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
package it.cnr.isti.zigbee.dongle.CC2530;

import it.cnr.isti.osgi.util.OSGiProperties;
import it.cnr.isti.zigbee.dongle.CC2530.impl.DriverCC2530;
import it.cnr.isti.zigbee.dongle.api.ConfigurationProperties;
import it.cnr.isti.zigbee.dongle.api.NetworkMode;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR</a>
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco - ISTI-CNR</a>
 * @version $LastChangedRevision: 229 $ ($LastChangedDate: 2011-05-20 11:42:58 +0200 (ven, 20 mag 2011) $)
 * @since 0.1.0
 *
 */
public class Activator implements BundleActivator {

	private DriverCC2530 driver;
	private ServiceRegistration service;
	
	public void start(BundleContext bc) throws Exception {
		driver = new DriverCC2530(
				OSGiProperties.getString(bc, ConfigurationProperties.COM_NAME_KEY, ConfigurationProperties.COM_NAME),
				OSGiProperties.getInt(bc, ConfigurationProperties.COM_BOUDRATE_KEY, ConfigurationProperties.COM_BOUDRATE), 
				NetworkMode.valueOf(OSGiProperties.getString(
						bc, ConfigurationProperties.NETWORK_MODE_KEY, ConfigurationProperties.NETWORK_MODE
				)),
				OSGiProperties.getInt(bc, ConfigurationProperties.PAN_ID_KEY, ConfigurationProperties.PAN_ID),
				OSGiProperties.getInt(bc, ConfigurationProperties.CHANNEL_ID_KEY, ConfigurationProperties.CHANNEL_ID),
				OSGiProperties.getBoolean(bc, ConfigurationProperties.NETWORK_FLUSH_KEY, ConfigurationProperties.NETWORK_FLUSH),
				OSGiProperties.getLong(bc, ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY, ConfigurationProperties.APPLICATION_MSG_TIMEOUT)
		);
		Properties properties = new Properties();
		properties.put("zigbee.driver.id", DriverCC2530.class.getName());
		properties.put("zigbee.supported.devices", new String[]{"tsb"});
		properties.put("zigbee.driver.type", "hardware");
		properties.put("zigbee.driver.mode", "real");
		service = bc.registerService(SimpleDriver.class.getName(), driver, properties);	}

	public void stop(BundleContext bc) throws Exception {
		service.unregister();
		driver.close();
	}

}
