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

package it.cnr.isti.zigbee.eh.driver;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.eh.driver.core.EHDevice;
import it.cnr.isti.zigbee.eh.driver.core.EHDeviceBase;
import it.cnr.isti.zigbee.eh.driver.core.EHDeviceFactory;
import it.cnr.isti.zigbee.eh.driver.core.EHDeviceRegistry;
import it.cnr.isti.zigbee.eh.driver.core.EHProfile;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

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
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 869 $ ($LastChangedDate: 2013-10-11 16:02:59 +0200 (ven, 11 ott 2013) $)
 * @since 0.1.0
 *
 */
public class EHImporter extends Thread {

    private final static Logger log = LoggerFactory.getLogger(EHImporter.class);

    private final static Object DISCOVERY = new Object();
    private final static String ANY_ZBDEVICE_FILTER = "("+Constants.OBJECTCLASS+"="+ZigBeeDevice.class.getName()+")";
    private final static String ANY_EHDEVICE_FILTER = "(&" + ANY_ZBDEVICE_FILTER + "(" + ZigBeeDevice.PROFILE_ID+"=" + EHProfile.ID +"))";
    private BundleContext context;

    private final Hashtable<String, EHDeviceDescriptor> refinedDevices;
    private final EHDeviceRegistry deviceRegistry;
    private final EHDeviceListener listenerHADevice = new EHDeviceListener();
    private final EHDeviceFactoryListener listenerHADeviceFactory = new EHDeviceFactoryListener();

    private class EHDeviceDescriptor {
        ServiceRegistration registration;
        EHDeviceBase ehDevice;
        ServiceReference zbDeviceSR;
    }

    private class EHDeviceListener implements ServiceListener {

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

    private class EHDeviceFactoryListener implements ServiceListener {

        public void serviceChanged(ServiceEvent event) {
            ServiceReference zbDeviceFactorySR = event.getServiceReference();
            synchronized (DISCOVERY) {
                switch(event.getType()){
                    case ServiceEvent.REGISTERED:{
                        deviceRegistry.addEHDeviceFactory(zbDeviceFactorySR);
                        refineDevices(zbDeviceFactorySR);
                    };break;

                    case ServiceEvent.MODIFIED:{
                        deviceRegistry.removeHADeviceFactory(zbDeviceFactorySR);
                        deviceRegistry.addEHDeviceFactory(zbDeviceFactorySR);
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
                        "("+ZigBeeDevice.PROFILE_ID+"="+EHProfile.ID+")"
                );
                if ( references == null ) return;
                for (int j = 0; j < references.length; j++) {
                    String uuid = (String) references[j].getProperty(ZigBeeDevice.UUID);
                    ServiceReference[] refined = context.getServiceReferences(
                            EHDevice.class.getName(),
                            "(" + EHDevice.ZIGBEE_DEVICE_UUID + "=" + uuid + ")"
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

    public EHImporter(BundleContext context){
        this.context = context;
        deviceRegistry = new EHDeviceRegistry(context);
        refinedDevices = new Hashtable<String, EHDeviceDescriptor>();

        synchronized (DISCOVERY) {
            try {
                context.addServiceListener(listenerHADevice,ANY_EHDEVICE_FILTER);
                context.addServiceListener(listenerHADeviceFactory,EHDeviceRegistry.ANY_ZBDEVICE_FACTORY_FILTER);
            } catch (InvalidSyntaxException e) {
                log.error("Modified the value of ANY_EHDEVICE_FILTER or EHDeviceRegistry.ANY_ZBDEVICE_FACTORY_FILTER and recompile",e);
            }
            try {
                ServiceReference[] zbDeviceSRs = context.getAllServiceReferences(ZigBeeDevice.class.getName(), ANY_EHDEVICE_FILTER);
                if (zbDeviceSRs!= null){
                    for (int i= 0; i<zbDeviceSRs.length;i++){
                        doRefineHADevice(zbDeviceSRs[i]);
                    }
                }
            } catch (InvalidSyntaxException e) {
                log.error("Modified the value of ANY_EHDEVICE_FILTER and recompile",e);
            }
        }
    }

    public void serviceChanged(ServiceEvent event) {

    }

    private void doRefineHADevice(ServiceReference zbDeviceSR) {
        final String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);
        log.info("EHD - refining ZigbeeDevice {}", uuid);
        ZigBeeDevice zbDevice = (ZigBeeDevice) context.getService(zbDeviceSR);
        try {
           
        	final EHDeviceFactory factory = deviceRegistry.getExactFactory(zbDevice);
            final EHDeviceBase refined = factory.getInstance(zbDevice);
       
            doRefinementRegistration(zbDeviceSR, refined, factory);
        } catch (ZigBeeHAException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void doRefinementRegistration(ServiceReference zbDeviceSR, EHDeviceBase refined, EHDeviceFactory factory) {
        String[] directInterfaces = factory.getRefinedInterfaces();

        //TODO definition of HAdevice Properties
        Properties properties = new Properties();

        properties.put(EHDevice.ZIGBEE_DEVICE_UUID, zbDeviceSR.getProperty(ZigBeeDevice.UUID));
        properties.put(EHDevice.ZIGBEE_DEVICE_SERVICE, zbDeviceSR.getProperty(Constants.SERVICE_ID));
        properties.put(EHDevice.EH_DRIVER, "it.cnr.isti.zigbee.eh.driver");
        properties.put(EHDevice.EH_DEVICE_NAME, refined.getName());
        properties.put(EHDevice.EH_DEVICE_GROUP, ""); //TODO
        properties.put(EHDevice.EH_DEVICE_STANDARD, Boolean.TRUE);


        ServiceRegistration registration = context.registerService(directInterfaces, refined, properties);
        String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);

        EHDeviceDescriptor descriptor = new EHDeviceDescriptor();
        descriptor.registration = registration;
        descriptor.ehDevice = refined;
        descriptor.zbDeviceSR = zbDeviceSR;

        synchronized (refinedDevices) {
            refinedDevices.put(uuid, descriptor);
        }
    }

    private void doRemoveRefinement(ServiceReference zbDeviceSR) {
        String uuid = (String) zbDeviceSR.getProperty(ZigBeeDevice.UUID);
        EHDeviceDescriptor descriptor = null;
        synchronized (refinedDevices) {
            descriptor = (EHDeviceDescriptor) refinedDevices.remove(uuid);
        }
        if (descriptor != null){
            descriptor.ehDevice.stop();
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
                EHDeviceDescriptor descriptor = (EHDeviceDescriptor)  refinedDevices.get(key);
                descriptor.ehDevice.stop();
                descriptor.registration.unregister();
                context.ungetService(descriptor.zbDeviceSR);
            }
            refinedDevices.clear();
        }
    }

}
