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

package it.cnr.isti.zigbee.eh.driver.core;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.ArraysUtil;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05 +0200 (mar, 06 ago 2013) $)
 * @since 0.4.0
 *
 */
public abstract class EHDeviceFactoryBase implements EHDeviceFactory {

    private static final Logger logger = LoggerFactory.getLogger(EHDeviceFactoryBase.class);

    protected BundleContext ctx;

    private ServiceRegistration registration;
    private Dictionary dictionary;
    private Class<?> refinement;
    protected int[] clusters;

    /**
     *
     * @param ctx {@link BundleContext} of the bundle extending the refinement capabilities
     * @param refinement {@link Class} of the most refined interfaces provided by this factory
     */
    public EHDeviceFactoryBase(BundleContext ctx, Class<?> refinement) {
        this.ctx = ctx;
        this.refinement = refinement;
        dictionary = new Properties();
        dictionary.put(ZigBeeDevice.PROFILE_ID, Integer.toString(EHProfile.ID));
    }

    public abstract String getDeviceId();

    public int[] getDeviceClusters() {
        synchronized (this) {
            if (clusters == null) {
                try {
                    final int[] standard = (int[]) refinement.getDeclaredField("STANDARD").get(null);
                    final int[] custom = (int[]) refinement.getDeclaredField("CUSTOM").get(null);
                    clusters = ArraysUtil.append(standard, custom);
                } catch (Exception e) {
                    logger.error(
                        "Unable to retrieve the implemented clusters by means of the reflection, "
                        + "the class {} does not provide the static field STANDARD or CUSTOM.\n"
                        + "Please modify the source code of the class by adding such static field or"
                                            + "override the getDeviceClusters() method ", refinement.getName()
                    );
                    logger.debug("Stack exception of the getDeviceClusters() error", e);
                }
            }
            return clusters;
        }
    }

    public abstract String[] getRefinedInterfaces();

    public abstract EHDeviceBase getInstance(ZigBeeDevice zbDevice) throws ZigBeeHAException;

    public void addProperty(String key, Object value) {
        dictionary.put(key, value);
    }

    public int hasMatch(ServiceReference ref) {
        int[] inputClusterIDs = (int[]) ref.getProperty(ZigBeeDevice.CLUSTERS_INPUT_ID);
        int[] refinedClusterIds = (int[]) getDeviceClusters();
        int score = Integer.parseInt( (String) ref.getProperty(ZigBeeDevice.PROFILE_ID) ) == EHProfile.ID
                ? ZigBeeDevice.MATCH_PROFILE_ID : 0;

        for (int i = 0; i < inputClusterIDs.length; i++) {
            for (int j = 0; j < refinedClusterIds.length; j++) {
                score += inputClusterIDs[i] == refinedClusterIds[j] ? ZigBeeDevice.MATCH_CLUSTER_ID : 0;
            }
        }

        score += ( (String) ref.getProperty(ZigBeeDevice.DEVICE_ID) ).equals( getDeviceId() )
                ? ZigBeeDevice.MATCH_DEVICE_ID : 0;

        return score;
    }

    public EHDeviceFactoryBase register() {
        dictionary.put(ZigBeeDevice.DEVICE_ID, getDeviceId());
        dictionary.put(ZigBeeDevice.CLUSTERS_INPUT_ID, getDeviceClusters());
        if( logger.isInfoEnabled() ) {
            logger.info(
                "Registering a EHDeviceFactory ( a refinement driver ) whose refines service with deviceId={} and clusters={}",
                getDeviceId(), Arrays.toString( getDeviceClusters() )
            );
        }
        registration = ctx.registerService(EHDeviceFactory.class.getName(), this, dictionary);
        return this;
    }

    public EHDeviceFactoryBase unregister() {
        registration.unregister();
        return this;
    }

}
