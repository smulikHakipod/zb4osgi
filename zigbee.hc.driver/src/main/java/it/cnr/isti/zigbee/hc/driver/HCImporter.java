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

package it.cnr.isti.zigbee.hc.driver;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceRegistry;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;
import it.cnr.isti.zigbee.hc.core.HCDevice;
import it.cnr.isti.zigbee.hc.core.HCDeviceBase;
import it.cnr.isti.zigbee.hc.core.HCDeviceFactory;
import it.cnr.isti.zigbee.hc.core.HCDeviceRegistry;
import it.cnr.isti.zigbee.hc.core.HCProfile;
import it.cnr.isti.zigbee.hc.core.ZigBeeHCException;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HCImporter extends Thread {

    private final static Logger log = LoggerFactory.getLogger(HCImporter.class);

    private final static Object DISCOVERY = new Object();
    private final static String ANY_ZBDEVICE_FILTER = "("+Constants.OBJECTCLASS+"="+ZigBeeDevice.class.getName()+")";
    private final static String ANY_HCDEVICE_FILTER = "(&" + ANY_ZBDEVICE_FILTER + "(" + ZigBeeDevice.PROFILE_ID+"=" + HCProfile.ID +"))";
    private BundleContext context;

    private final Hashtable<String, HCDeviceDescriptor> refinedDevices;
    private final HCDeviceRegistry deviceRegistry;
    private final HCDeviceListener listenerHADevice = new HCDeviceListener();
    private final HCDeviceFactoryListener listenerHADeviceFactory = new HCDeviceFactoryListener();

    private class HCDeviceDescriptor {
        ServiceRegistration registration;
        HCDeviceBase haDevice;
        ServiceReference zbDeviceSR;
    }

    private class HCDeviceListener implements ServiceListener {

        public void serviceChanged(ServiceEvent event) {
            synchronized (DISCOVERY) {
                ServiceReference zbDeviceSR = event.getServiceReference();
                switch(event.getType()){
                    case ServiceEvent.REGISTERED:{
                        doRefineHADevice(zbDeviceSR);
                    };break;

                    case ServiceEvent.MODIFIED:{
                        // never modified
                    };break;

                    case ServiceEvent.UNREGISTERING:{
                        doRemoveRefinement(zbDeviceSR);
                    };break;
                }
            }
        }
    }

    private class HCDeviceFactoryListener implements ServiceListener {

        public void serviceChanged(ServiceEvent event) {
            ServiceReference zbDeviceFactorySR = event.getServiceReference();
            synchronized (DISCOVERY) {
                switch(event.getType()){
                    case ServiceEvent.REGISTERED:{
                        deviceRegistry.addHADeviceFactory(zbDeviceFactorySR);
                        refineDevices(zbDeviceFactorySR);
                    };break;

                    case ServiceEvent.MODIFIED:{
                        deviceRegistry.removeHADeviceFactory(zbDeviceFactorySR);
                        deviceRegistry.addHADeviceFactory(zbDeviceFactorySR);
                    };break;

                    case ServiceEvent.UNREGISTERING:{
                        deviceRegistry.removeHADeviceFactory(zbDeviceFactorySR);
                    };break;
                }
            }
        }

        private void refineDevices(ServiceReference factory) {
            try {
                ServiceReference[] references = context.getServiceReferences(
                        ZigBeeDevice.class.getName(),
                        "("+ZigBeeDevice.PROFILE_ID+"="+HAProfile.ID+")"
                );
                if ( references == null ) return;
                for (int j = 0; j < references.length; j++) {
                    String uuid = (String) references[j].getProperty(ZigBeeDevice.UUID);
                    ServiceReference[] refined = context.getServiceReferences(
                            HCDevice.class.getName(),
                            "(" + HCDevice.ZIGBEE_DEVICE_UUID + "=" + uuid + ")"
                    );
                    if ( refined != null ) {
                        log.debug(
                                "Device {} already refined. I won't checked if it could be refined by " +
                                "the new factory {}", uuid, factory.getProperty(Constants.OBJECTCLASS)
                        );
                        continue;
                    }
                    doRefineHADevice(references[j]);
                }
            } catch (InvalidSyntaxException ex) {
                log.error("Fixed the filter definition and recompile the bundle {}",ex);
            }
        }

    }

    public void run(){
        //TODO Move registration inside the run
    }

    public HCImporter(BundleContext context){
        this.context = context;
        deviceRegistry = new HCDeviceRegistry(context);
        refinedDevices = new Hashtable<String, HCDeviceDescriptor>();

        synchronized (DISCOVERY) {
            try {
                context.addServiceListener(listenerHADevice,ANY_HCDEVICE_FILTER);
                context.addServiceListener(listenerHADeviceFactory,HADeviceRegistry.ANY_ZBDEVICE_FACTORY_FILTER);
            } catch (InvalidSyntaxException e) {
                log.error("Modified the value of ANY_HCDEVICE_FILTER or HADeviceRegistry.ANY_ZBDEVICE_FACTORY_FILTER and recompile",e);
            }
            try {
                ServiceReference[] zbDeviceSRs = context.getAllServiceReferences(ZigBeeDevice.class.getName(), ANY_HCDEVICE_FILTER);
                if (zbDeviceSRs!= null){
                    for (int i= 0; i<zbDeviceSRs.length;i++){
                        doRefineHADevice(zbDeviceSRs[i]);
                    }
                }
            } catch (InvalidSyntaxException e) {
                log.error("Modified the value of ANY_HCDEVICE_FILTER and recompile",e);
            }
        }
    }

    public void serviceChanged(ServiceEvent event) {

    }

    private void doRefineHADevice(ServiceReference zbDeviceSR) {
        final String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);
        log.info("HCD - refining ZigbeeDevice {}", uuid);
        ZigBeeDevice zbDevice = (ZigBeeDevice) context.getService(zbDeviceSR);
        try {
            /*
             * Call the getDeviceFactories and check for multiple factory
             * capable of handling the device
             */
            final HCDeviceFactory factory = deviceRegistry.getBestFactory(zbDeviceSR);
            if ( factory == null) { // pending services
                log.warn("No refinement for ZigbeeDevice {} currently found", uuid);
                return;
            }
            final HCDeviceBase refined = factory.getInstance(zbDevice);
            doRefinementRegistration(zbDeviceSR, refined, factory);
        } catch (ZigBeeHCException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void doRefinementRegistration(ServiceReference zbDeviceSR, HCDeviceBase refined, HCDeviceFactory factory) {
        String[] directInterfaces = factory.getRefinedInterfaces();

        //TODO definition of HAdevice Properties
        Properties properties = new Properties();

        properties.put(HCDevice.ZIGBEE_DEVICE_UUID, zbDeviceSR.getProperty(ZigBeeDevice.UUID));
        properties.put(HCDevice.ZIGBEE_DEVICE_SERVICE, zbDeviceSR.getProperty(Constants.SERVICE_ID));
        properties.put(HCDevice.HC_DRIVER, "it.cnr.isti.zigbee.hc.driver");
        properties.put(HCDevice.HC_DEVICE_NAME, refined.getName());
        properties.put(HCDevice.HC_DEVICE_GROUP, ""); //TODO
        properties.put(HCDevice.HC_DEVICE_STANDARD, Boolean.TRUE);


        ServiceRegistration registration = context.registerService(directInterfaces, refined, properties);
        String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);

        HCDeviceDescriptor descriptor = new HCDeviceDescriptor();
        descriptor.registration = registration;
        descriptor.haDevice = refined;
        descriptor.zbDeviceSR = zbDeviceSR;

        synchronized (refinedDevices) {
            refinedDevices.put(uuid, descriptor);
        }
    }

    private void doRemoveRefinement(ServiceReference zbDeviceSR) {
        String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);
        HCDeviceDescriptor descriptor = null;
        synchronized (refinedDevices) {
            descriptor = (HCDeviceDescriptor) refinedDevices.remove(uuid);
        }
        if (descriptor != null){
            descriptor.haDevice.stop();
            descriptor.registration.unregister();
            context.ungetService(descriptor.zbDeviceSR);
        }
    }


    public void close() {
        synchronized (refinedDevices) {
            context.removeServiceListener(listenerHADevice);
            context.removeServiceListener(listenerHADeviceFactory);
            Enumeration<String> keys =  refinedDevices.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                HCDeviceDescriptor descriptor = (HCDeviceDescriptor)  refinedDevices.get(key);
                descriptor.haDevice.stop();
                descriptor.registration.unregister();
                context.ungetService(descriptor.zbDeviceSR);
            }
            refinedDevices.clear();
        }
    }

}
