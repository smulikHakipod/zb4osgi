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



package it.cnr.isti.zigbee.hc;

import it.cnr.isti.zigbee.hc.core.GenericHCDeviceFactory;
import it.cnr.isti.zigbee.hc.core.HCClustersFactory;
import it.cnr.isti.zigbee.hc.core.HCDeviceFactoryBase;
import it.cnr.isti.zigbee.hc.core.UnknowHADeviceFactory;
import it.cnr.isti.zigbee.hc.device.api.aging_independetly.DosageSensor;
import it.cnr.isti.zigbee.hc.device.impl.aging_independetly.DosageSensorDevice;
import it.cnr.isti.zigbee.hc.driver.HCDriverConfiguration;
import it.cnr.isti.zigbee.hc.driver.HCImporter;
import it.cnr.isti.zigbee.hc.driver.HCReportingConfiguration;

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

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class Activator implements BundleActivator {

    private static final String HC_CONFIG_PID = "it.cnr.isti.zigbee.hc.configuration";

    private HCImporter haImporter;

    private final ArrayList<HCDeviceFactoryBase> factories = new ArrayList<HCDeviceFactoryBase>();

    private ServiceRegistration configRegistration;

    private static HCDriverConfiguration configuration = null;


    private void doRegisterConfigurationService(BundleContext ctx) {
        Properties properties = new Properties();

        properties.setProperty(Constants.SERVICE_PID, HC_CONFIG_PID);

        configuration = new HCDriverConfiguration(ctx);
        configRegistration = ctx.registerService(
                new String[]{ManagedService.class.getName(), HCReportingConfiguration.class.getName()},
                configuration,
                null
                );
    }

    public void start(BundleContext ctx) throws Exception {
        doRegisterConfigurationService(ctx);
        new HCClustersFactory(ctx).register();
        doRegisterDeviceFactories(ctx);
        haImporter = new HCImporter(ctx);
    }

    private void doRegisterDeviceFactories(final BundleContext bc) throws Exception {
        Map< Class<?>, Class<?> > refinedAvailables = new HashMap< Class<?>, Class<?> >();
        refinedAvailables.put( DosageSensor.class, DosageSensorDevice.class );

        final Iterator< Entry<Class<?>, Class<?>> > i = refinedAvailables.entrySet().iterator();
        while ( i.hasNext() ) {
            Entry<Class<?>, Class<?>> refining = i.next();
            factories.add( new GenericHCDeviceFactory( bc, refining.getKey(), refining.getValue() ).register() );
        }

        factories.add( new UnknowHADeviceFactory( bc ).register() );
    }

    public void stop(BundleContext context) throws Exception {
        haImporter.close();

        for (HCDeviceFactoryBase factory : factories) {
            factory.unregister();
        }

    }

    public static HCDriverConfiguration getConfiguration(){
        return configuration;
    }
}