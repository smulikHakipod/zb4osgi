package it.cnr.isti.zigbee.hc.core;
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



import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.HAImporter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HCDeviceRegistry {

    private final static Object REGISTRY = new Object();
    public final static String ANY_ZBDEVICE_FACTORY_FILTER = "("+Constants.OBJECTCLASS+"="+HCDeviceFactory.class.getName()+")";

    private final static Logger log = LoggerFactory.getLogger(HCDeviceRegistry.class);
    private final BundleContext ctx;
    private HashMap<String, HCDeviceFactory> registry;
    private HAImporter refiner;

    public HCDeviceRegistry(BundleContext ctx){
        this.ctx = ctx ;
        registry = new HashMap<String, HCDeviceFactory>();

        try {
            ServiceReference[] zbDeviceSRs = ctx.getAllServiceReferences(HCDeviceFactory.class.getName(), ANY_ZBDEVICE_FACTORY_FILTER);
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
        HCDeviceFactory factory = (HCDeviceFactory) ctx.getService(zbDeviceFactorySR);
        String key = factory.getDeviceId();

        HCDeviceFactory value;
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
     * This method selects among all the {@link HCDeviceFactory} the best {@link HCDeviceFactory} that can<br>
     * refine the {@link ZigBeeDevice} by using the method {@link HCDeviceFactory#hasMatch(ServiceReference)}<br>
     * for comparing them
     *
     * @param sr the {@link ServiceReference} refering the the {@link ZigBeeDevice} to refine
     * @return the {@link HCDeviceFactory} with the best {@link HCDeviceFactory#hasMatch(ServiceReference)}
     * @since  0.7.0
     */
    public HCDeviceFactory getBestFactory(ServiceReference sr) {

        synchronized (REGISTRY) {
            final Collection<HCDeviceFactory> factories = registry.values();
            HCDeviceFactory refining = null;
            int bestMatching = -1;

            for (Iterator<HCDeviceFactory> iterator = factories.iterator(); iterator.hasNext();) {
                final HCDeviceFactory factory = (HCDeviceFactory) iterator.next();
                final int matching = factory.hasMatch( sr );
                if ( factory.hasMatch( sr ) > bestMatching ) {
                    refining = factory;
                    bestMatching = matching;
                }
            }

            return refining;
        }
    }

    /**
     * This method selects among all the {@link HCDeviceFactory} the {@link HCDeviceFactory} that match the rule<br>
     * {@link HCDeviceFactory#getDeviceId()} equal to {@link ZigBeeDevice#getDeviceId()}
     *
     * @param zbDevice the {@link ZigBeeDevice} to refine
     * @return the {@link HCDeviceFactory} whose {@link HCDeviceFactory#getDeviceId()} equal to {@link ZigBeeDevice#getDeviceId()}
     */
    public HCDeviceFactory getFactory(ZigBeeDevice zbDevice) {
        final String deviceId = String.valueOf(zbDevice.getDeviceId());

        synchronized (REGISTRY) {
            return registry.get(deviceId);
        }
    }

    public HCDeviceBase getInstance(ServiceReference sr, ZigBeeDevice device) throws ZigBeeHCException{
        final HCDeviceFactory factory = getBestFactory(sr);

        if (factory != null) {
            return factory.getInstance(device);
        } else {
            return null;
        }
    }

}
