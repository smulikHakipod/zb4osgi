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

import it.cnr.isti.osgi.util.DictionaryHelper;
import it.cnr.isti.osgi.util.OSGiProperties;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceBase;

import java.util.Dictionary;
import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HCDriverConfiguration implements ManagedService, HCReportingConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(HCDriverConfiguration.class);


    public enum ProvidedClusterMode {
        HealthCareProfileStrict,
        EitherInputAndOutput;
    }
    /**
     * The key to {@link String} property representing on values of th {@link ProvidedClusterMode} enum, that change the<br>
     * creation behavior of the {@link HADeviceBase} objects, by following the rules:<br>
     * <ul>
     * <li>
     * if the value is equal to <b>EitherInputAndOutput</b> then if a device provides an cluster X as <i>Input cluster</i> only,<br>
     * and if the cluster X is mandatory and appear as <i>Output cluster</i>, then the <i>Home Automation Driver</i> consider the<br>
     * cluster available X available for input too, and it add it to the actual list of cluster for the {@link HADevice} created
     * <li>
     * if the value is equal to <b>HomeAutomationProfileStrict</b> then the <i>Home Automation Driver</i> create the cluster for the<br>
     * {@link HADevice} if and only if it is reported as an <i>Input cluster</i>
     * </li>
     *
     */
    public static final String PROVIDED_CLUSTER_MODE_KEY = "it.isti.cnr.zigbee.hc.driver.cluster.discovery.mode";
    /**
     * The default value for the property {@link #PROVIDED_CLUSTER_MODE_KEY}, that is <b>HomeAutomationProfileStrict</b>
     */
    public static final String DEFAULT_PROVIDED_CLUSTER_MODE = ProvidedClusterMode.HealthCareProfileStrict.toString();

    private final HashMap<String, Object> configuration = new HashMap<String, Object>();
    private final BundleContext context;

    public HCDriverConfiguration(BundleContext bc){
        context = bc;
        synchronized (configuration) {
            configuration.put(HCReportingConfiguration.CONFIGURE_REPORTING_MIN_KEY,
                    OSGiProperties.getInt(context, HCReportingConfiguration.CONFIGURE_REPORTING_MIN_KEY, HCReportingConfiguration.DEFAULT_CONFIGURE_REPORTING_MIN)
            );

            configuration.put(HCReportingConfiguration.CONFIGURE_REPORTING_MAX_KEY,
                    OSGiProperties.getInt(context, HCReportingConfiguration.CONFIGURE_REPORTING_MAX_KEY, HCReportingConfiguration.DEFAULT_CONFIGURE_REPORTING_MAX)
            );

            configuration.put(HCReportingConfiguration.CONFIGURE_REPORTING_CHANGE_KEY,
                    OSGiProperties.getDouble(context, HCReportingConfiguration.CONFIGURE_REPORTING_CHANGE_KEY, HCReportingConfiguration.DEFAULT_CONFIGURE_REPORTING_CHANGE)
            );

            configuration.put(HCReportingConfiguration.CONFIGURE_REPORTING_OVERWRITE_KEY,
                    OSGiProperties.getBoolean(context, HCReportingConfiguration.CONFIGURE_REPORTING_OVERWRITE_KEY, HCReportingConfiguration.DEFAULT_CONFIGURE_REPORTING_OVERWRITE)
            );
            try{
                configuration.put(PROVIDED_CLUSTER_MODE_KEY,
                    OSGiProperties.getString(context, PROVIDED_CLUSTER_MODE_KEY, ProvidedClusterMode.HealthCareProfileStrict.toString() )
                );
            }catch(IllegalArgumentException ex){
                logger.error(
                    "The value current value {} of the property {} doesn't not belong to the enum {}, so it has been SET TO DEFAULT {}",
                    new Object[]{
                        OSGiProperties.getString(context, PROVIDED_CLUSTER_MODE_KEY, null ),
                        PROVIDED_CLUSTER_MODE_KEY,
                        ProvidedClusterMode.class.getName(),
                        ProvidedClusterMode.HealthCareProfileStrict.toString()
                    }
                );
                configuration.put(PROVIDED_CLUSTER_MODE_KEY, ProvidedClusterMode.HealthCareProfileStrict.toString() );
            }
        }

        logger.debug("Initialized {} with {}", this, configuration);
    }

    @SuppressWarnings("unchecked")
    public void updated(Dictionary newConfig) throws ConfigurationException {

        logger.info("Updating configuration with {}", newConfig);

        if( newConfig == null ){
            logger.debug("New configuration is null, avoiding to update it");
            return;
        }

        DictionaryHelper helper = new DictionaryHelper(newConfig);
        boolean isChanged = false;
        synchronized (this) {
            isChanged = setInteger(HCReportingConfiguration.CONFIGURE_REPORTING_MIN_KEY,
                    helper.getInt(HCReportingConfiguration.CONFIGURE_REPORTING_MIN_KEY, getReportingMinimum())
            ) || isChanged;

            isChanged = setInteger(HCReportingConfiguration.CONFIGURE_REPORTING_MAX_KEY,
                    helper.getInt(HCReportingConfiguration.CONFIGURE_REPORTING_MAX_KEY, getReportingMaximum())
            ) || isChanged;

            isChanged = setDouble(HCReportingConfiguration.CONFIGURE_REPORTING_CHANGE_KEY,
                    helper.getDouble(HCReportingConfiguration.CONFIGURE_REPORTING_CHANGE_KEY, getReportingChange())
            ) || isChanged;

            isChanged = setBoolean(HCReportingConfiguration.CONFIGURE_REPORTING_OVERWRITE_KEY,
                    helper.getBoolean(HCReportingConfiguration.CONFIGURE_REPORTING_OVERWRITE_KEY, getReportingOverwrite())
            ) || isChanged;
            try {
                isChanged = setStringCaseSensitve( PROVIDED_CLUSTER_MODE_KEY,
                    helper.getString( PROVIDED_CLUSTER_MODE_KEY, getClusterMode().toString() )
                ) || isChanged;
            } catch ( IllegalArgumentException ex ) {
                logger.error( "The new value current value {} for the property {} doesn't not belong to the enum {}, so it has been IGNORED",
                    new Object[] {
                        helper.getString( PROVIDED_CLUSTER_MODE_KEY, getClusterMode().toString() ),
                        PROVIDED_CLUSTER_MODE_KEY,
                        ProvidedClusterMode.class.getName()
                    }
                );
            }

        }

        logger.debug("Current configuration after applying new configuration is {}", configuration);

    }

    private int getInt(String key){
        return ((Integer) configuration.get(key)).intValue();
    }

    private long getLong(String key){
        return ((Long) configuration.get(key)).longValue();
    }

    private double getDouble(String key){
        return ((Double) configuration.get(key)).doubleValue();
    }

    private boolean getBoolean(String key){
        return ((Boolean) configuration.get(key)).booleanValue();
    }

    private String getString(String key){
        return (String) configuration.get(key);
    }

    private boolean setStringCaseInsensitve(String key, String value){
        if( getString(key).equalsIgnoreCase(value) ) return false;
        configuration.put(key, value);
        return true;
    }

    private boolean setStringCaseSensitve(String key, String value){
        if( getString(key).compareTo(value) == 0) return false;
        configuration.put(key, value);
        return true;
    }

    private boolean setLong(String key, long value){
        if( getLong(key) == value ) return false;
        configuration.put(key, value);
        return true;
    }

    private boolean setInteger(String key, int value){
        if( getInt(key) == value ) return false;
        configuration.put(key, value);
        return true;
    }

    private boolean setBoolean(String key, boolean value){
        if( getBoolean(key) == value ) return false;
        configuration.put(key, value);
        return true;
    }

    private boolean setDouble(String key, double value){
        if( getDouble(key) == value ) return false;
        configuration.put(key, value);
        return true;
    }

    public synchronized int getReportingMinimum() {
        return getInt(HCReportingConfiguration.CONFIGURE_REPORTING_MIN_KEY);
    }

    public synchronized int getReportingMaximum() {
        return getInt(HCReportingConfiguration.CONFIGURE_REPORTING_MAX_KEY);
    }

    public synchronized double getReportingChange() {
        return getDouble(HCReportingConfiguration.CONFIGURE_REPORTING_CHANGE_KEY);
    }

    public synchronized boolean getReportingOverwrite() {
        return getBoolean(HCReportingConfiguration.CONFIGURE_REPORTING_OVERWRITE_KEY);
    }

    /**
     *
     * @return
     * @since  0.6.0 - Revision 88
     */
    public synchronized ProvidedClusterMode getClusterMode() {
        return ProvidedClusterMode.valueOf( getString( PROVIDED_CLUSTER_MODE_KEY ) );
    }
}
