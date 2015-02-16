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

package it.cnr.isti.zigbee.eh;

import it.cnr.isti.zigbee.eh.cluster.factory.EHClustersFactory;
import it.cnr.isti.zigbee.eh.driver.EHDriverConfiguration;
import it.cnr.isti.zigbee.eh.driver.EHImporter;
import it.cnr.isti.zigbee.eh.driver.core.EHDeviceFactoryBase;
import it.cnr.isti.zigbee.eh.driver.core.GenericEHDeviceFactory;
import it.cnr.isti.zigbee.eh.driver.core.ReportingConfiguration;
import it.cnr.isti.zigbee.eh.driver.core.UnknownEHDeviceFactory;

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
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05 +0200 (mar, 06 ago 2013) $)
 *
 */
public class Activator implements BundleActivator {

    private final static Logger logger = LoggerFactory.getLogger(Activator.class);

    private static final String EH_CONFIG_PID = EHDriverConfiguration.PID;

    private EHImporter ehImporter;

    private final ArrayList<EHDeviceFactoryBase> factories = new ArrayList<EHDeviceFactoryBase>();

    private ServiceRegistration configRegistration;

    private static EHDriverConfiguration configuration = null;


    private void doRegisterConfigurationService(BundleContext ctx){
        Properties properties = new Properties();

        properties.setProperty(Constants.SERVICE_PID, EH_CONFIG_PID);

        configuration = new EHDriverConfiguration(ctx);
        configRegistration = ctx.registerService(
                new String[]{ManagedService.class.getName(), ReportingConfiguration.class.getName()},
                configuration,
                null
                );
    }

    public void start(BundleContext ctx) throws Exception {
        doRegisterConfigurationService(ctx);
        try {
            new EHClustersFactory(ctx).register();
        } catch( Exception ex ) {
            logger.debug( "Failed to register EHClustersFactory ", ex );
        }
        doRegisterDeviceFactories(ctx);
        ehImporter = new EHImporter(ctx);
    }

    private void doRegisterDeviceFactories(final BundleContext bc) throws Exception {
        Map< Class<?>, Class<?> > refinedAvailables = new HashMap< Class<?>, Class<?> >();
     //   refinedAvailables.put( ColorDimmableLight.class, ColorDimmableLightDevice.class );
       

        final Iterator< Entry<Class<?>, Class<?>> > i = refinedAvailables.entrySet().iterator();
        while ( i.hasNext() ) {
            Entry<Class<?>, Class<?>> refining = i.next();
            try {
                factories.add( new GenericEHDeviceFactory( bc, refining.getKey(), refining.getValue() ).register() );
            } catch ( Exception ex) {
                logger.error( "Failed to register GenericEHDeviceFactory for " + refining.getKey(), ex );
            }
        }

        try {
            factories.add( new UnknownEHDeviceFactory( bc ).register() );
        } catch ( Exception ex) {
            logger.error( "Failed to register UnknownEHDeviceFactory", ex );
        }
    }

    public void stop(BundleContext context) throws Exception {
        ehImporter.close();

        for (EHDeviceFactoryBase factory : factories) {
            factory.unregister();
        }

    }

    public static EHDriverConfiguration getConfiguration(){
        return configuration;
    }
}