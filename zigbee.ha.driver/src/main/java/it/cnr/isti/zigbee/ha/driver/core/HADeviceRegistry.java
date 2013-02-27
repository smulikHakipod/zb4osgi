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

package it.cnr.isti.zigbee.ha.driver.core;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.HAImporter;

import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *         
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class HADeviceRegistry {

	private final static Object REGISTRY = new Object();
	public final static String ANY_ZBDEVICE_FACTORY_FILTER = "("+Constants.OBJECTCLASS+"="+HADeviceFactory.class.getName()+")";

	private final static Logger log = LoggerFactory.getLogger(HADeviceRegistry.class);
	private final BundleContext ctx;
	private HashMap<String, HADeviceFactory> registry;
	private HAImporter refiner;

	public HADeviceRegistry(BundleContext ctx){
		this.ctx = ctx ; 
		registry = new HashMap<String, HADeviceFactory>();
		
		try {
			ServiceReference[] zbDeviceSRs = ctx.getAllServiceReferences(HADeviceFactory.class.getName(), ANY_ZBDEVICE_FACTORY_FILTER);
			if (zbDeviceSRs!= null){
				for (int i= 0; i<zbDeviceSRs.length;i++){
					addHADeviceFactory(zbDeviceSRs[i]);
				}
			}
		} catch (InvalidSyntaxException e) {
			log.error("Bad ANY_ZBDEVICE_FACTORY_FILTER: " + ANY_ZBDEVICE_FACTORY_FILTER,e);
		}
	}

	public void addHADeviceFactory(ServiceReference zbDeviceFactorySR) {
		HADeviceFactory factory = (HADeviceFactory) ctx.getService(zbDeviceFactorySR);
		String key = factory.getDeviceId();
		
		HADeviceFactory value;
		synchronized (REGISTRY) {
			value = registry.put(key, factory);			
		}
		if(value != null){
			log.warn("ATTENTION a device with ID:" +  key + " has been replaced in the registry !!");
		}
	}

	public void  removeHADeviceFactory(ServiceReference zbDeviceFactorySR) {
		String deviceId = (String) zbDeviceFactorySR.getProperty(ZigBeeDevice.DEVICE_ID);
		synchronized (REGISTRY) {
			registry.remove(deviceId);			
		}
		ctx.ungetService(zbDeviceFactorySR);
	}

	/**
	 * This method selects among all the {@link HADeviceFactory} all the {@link HADeviceFactory} that can<br>
	 * refine the {@link ZigBeeDevice}. Thus all the {@link HADeviceFactory} having<br> 
	 * {@link HADeviceFactory#hasMatch(ServiceReference)} greater than 0  
	 * 
	 * @param zbDevice 
	 * @return a {@link HADeviceFactory} array containing all the factories with a matching value greater then 0
	 * 
	 * @throws ZigBeeHAException
	 */
	/*
	public HADeviceFactory[] getDeviceFactories(ZigBeeDevice zbDevice) throws ZigBeeHAException {
	    	//TODO follow the javadoc
	    
		final String deviceId = String.valueOf(zbDevice.getDeviceId());
		
		synchronized (REGISTRY) {
			HADeviceFactory factory = registry.get(deviceId);
			if (factory != null)
				return new HADeviceFactory[]{ factory };
			else 
				return null;
		}
	}
	*/
	
	public HADeviceFactory getFactory(ZigBeeDevice zbDevice) {
		final String deviceId = String.valueOf(zbDevice.getDeviceId());
		
		synchronized (REGISTRY) {
			return registry.get(deviceId);
		}
	}
	
	public HADeviceBase getInstance(ZigBeeDevice zbDevice) throws ZigBeeHAException{
	    final HADeviceFactory factory = getFactory(zbDevice);
	    if (factory != null) {
		return factory.getInstance(zbDevice);
	    } else { 
		return null;
	    }
	}

}
