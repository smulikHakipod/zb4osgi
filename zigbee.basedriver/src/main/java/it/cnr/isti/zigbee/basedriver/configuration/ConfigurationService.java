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

package it.cnr.isti.zigbee.basedriver.configuration;

import it.cnr.isti.osgi.util.DictionaryHelper;
import it.cnr.isti.osgi.util.OSGiProperties;
import it.cnr.isti.zigbee.api.Constants;
import it.cnr.isti.zigbee.basedriver.Activator;
import it.cnr.isti.zigbee.basedriver.configuration.BaseDriverProperties.DiscoveryMode;
import it.cnr.isti.zigbee.dongle.api.ConfigurationProperties;
import it.cnr.isti.zigbee.dongle.api.DriverStatus;
import it.cnr.isti.zigbee.dongle.api.DuplicateMacPolicy;
import it.cnr.isti.zigbee.dongle.api.NetworkMode;
import it.cnr.isti.zigbee.dongle.api.SimpleDriver;

import java.util.Dictionary;
import java.util.EnumSet;
import java.util.HashMap;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 * 
 */
public class ConfigurationService implements ManagedService {

	public static final String PID = Constants.MANAGED_SERVICE_PID;

	private final static Logger logger = LoggerFactory
			.getLogger(ConfigurationService.class);

	private final HashMap<String, Object> configuration = new HashMap<String, Object>();
	private SimpleDriver driver;

	public ConfigurationService() {
		synchronized (this) {
			configuration.put(ConfigurationProperties.PAN_ID_KEY,
					OSGiProperties.getInt(Activator.getBundleContext(),
							ConfigurationProperties.PAN_ID_KEY,
							ConfigurationProperties.PAN_ID));
			configuration.put(ConfigurationProperties.CHANNEL_ID_KEY,
					OSGiProperties.getInt(Activator.getBundleContext(),
							ConfigurationProperties.CHANNEL_ID_KEY,
							ConfigurationProperties.CHANNEL_ID));
			configuration.put(ConfigurationProperties.COM_BAUDRATE_KEY,
					OSGiProperties.getInt(Activator.getBundleContext(),
							ConfigurationProperties.COM_BAUDRATE_KEY,
							ConfigurationProperties.COM_BAUDRATE));
			configuration.put(ConfigurationProperties.COM_NAME_KEY,
					OSGiProperties.getString(Activator.getBundleContext(),
							ConfigurationProperties.COM_NAME_KEY,
							ConfigurationProperties.COM_NAME));
			configuration.put(ConfigurationProperties.NETWORK_MODE_KEY,
					NetworkMode.valueOf(OSGiProperties.getString(
							Activator.getBundleContext(),
							ConfigurationProperties.NETWORK_MODE_KEY,
							ConfigurationProperties.NETWORK_MODE)));
			configuration.put(ConfigurationProperties.NETWORK_FLUSH_KEY,
					OSGiProperties.getBoolean(Activator.getBundleContext(),
							ConfigurationProperties.NETWORK_FLUSH_KEY,
							ConfigurationProperties.NETWORK_FLUSH));

			configuration
					.put(ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT_KEY,
							OSGiProperties.getInt(
									Activator.getBundleContext(),
									ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT_KEY,
									ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT));
			configuration
					.put(ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY_KEY,
							OSGiProperties.getInt(
									Activator.getBundleContext(),
									ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY_KEY,
									ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY));
			configuration
					.put(ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY,
							OSGiProperties.getLong(
									Activator.getBundleContext(),
									ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY,
									ConfigurationProperties.APPLICATION_MSG_TIMEOUT));

			configuration
					.put(ConfigurationProperties.NETWORK_BROWSING_PERIOD_KEY,
							OSGiProperties.getLong(
									Activator.getBundleContext(),
									ConfigurationProperties.NETWORK_BROWSING_PERIOD_KEY,
									ConfigurationProperties.NETWORK_BROWSING_PERIOD));
			configuration
					.put(ConfigurationProperties.DEVICE_INSPECTION_PERIOD_KEY,
							OSGiProperties.getLong(
									Activator.getBundleContext(),
									ConfigurationProperties.DEVICE_INSPECTION_PERIOD_KEY,
									ConfigurationProperties.DEVICE_INSPECTION_PERIOD));

			configuration
					.put(ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY,
							OSGiProperties.getInt(
									Activator.getBundleContext(),
									ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY,
									ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY));
			configuration.put(
					ConfigurationProperties.FIRST_ENDPOINT_ADDRESS_KEY,
					OSGiProperties.getInt(Activator.getBundleContext(),
							ConfigurationProperties.FIRST_ENDPOINT_ADDRESS_KEY,
							ConfigurationProperties.FIRST_ENDPOINT_ADDRESS));

			configuration.put(BaseDriverProperties.DISCOVERY_MODE_KEY,
					OSGiProperties.getInt(Activator.getBundleContext(),
							BaseDriverProperties.DISCOVERY_MODE_KEY,
							BaseDriverProperties.DISCOVERY_MODE));

			configuration.put(ConfigurationProperties.NETWORK_MODE_KEY,
					NetworkMode.valueOf(OSGiProperties.getString(
							Activator.getBundleContext(),
							ConfigurationProperties.NETWORK_MODE_KEY,
							ConfigurationProperties.NETWORK_MODE)));

			configuration
					.put(ConfigurationProperties.DISCOVERY_DUPLICATE_MAC_KEY,
							DuplicateMacPolicy.valueOf(OSGiProperties.getString(
									Activator.getBundleContext(),
									ConfigurationProperties.DISCOVERY_DUPLICATE_MAC_KEY,
									ConfigurationProperties.DISCOVERY_DUPLICATE_MAC)));

		}

		logger.debug("Initialized {} with {}", this, configuration);
	}

	@SuppressWarnings("unchecked")
	public void updated(Dictionary newConfig) throws ConfigurationException {

		logger.info("Updating configuration with {}", newConfig);

		if (newConfig == null) {
			logger.debug("New configuration is null, avoiding to update it");
			return;
		}

		DictionaryHelper helper = new DictionaryHelper(newConfig);
		boolean isChanged = false;
		synchronized (this) {
			isChanged |= setInteger(ConfigurationProperties.PAN_ID_KEY,
					helper.getInt(ConfigurationProperties.PAN_ID_KEY,
							getPanId()));
			isChanged |= setInteger(ConfigurationProperties.CHANNEL_ID_KEY,
					helper.getInt(ConfigurationProperties.CHANNEL_ID_KEY,
							getChannelId()));
			isChanged |= setInteger(ConfigurationProperties.COM_BAUDRATE_KEY,
					helper.getInt(ConfigurationProperties.COM_BAUDRATE_KEY,
							getSerialBaudRate()));
			isChanged |= setStringCaseSensitive(
					ConfigurationProperties.COM_NAME_KEY, helper.getString(
							ConfigurationProperties.COM_NAME_KEY,
							getSerialPortName()));
			isChanged |= setNetworkMode(
					ConfigurationProperties.NETWORK_MODE_KEY,
					NetworkMode.valueOf(helper.getString(
							ConfigurationProperties.NETWORK_MODE_KEY,
							getNetworkMode().toString())));
			isChanged |= setBoolean(ConfigurationProperties.NETWORK_FLUSH_KEY,
					helper.getBoolean(
							ConfigurationProperties.NETWORK_FLUSH_KEY,
							getForceNetworkCleaning()));
			isChanged |= setInteger(
					ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT_KEY,
					helper.getInt(
							ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT_KEY,
							getMessageRetryCount()));
			isChanged |= setInteger(
					ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY_KEY,
					helper.getInt(
							ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY_KEY,
							getMessageRetryDelay()));
			isChanged |= setLong(
					ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY,
					helper.getLong(
							ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY,
							getZigBeeTimeout()));
	
			setDiscoveryDuplicateMac(
					ConfigurationProperties.DISCOVERY_DUPLICATE_MAC_KEY,
					DuplicateMacPolicy.valueOf(helper.getString(
							ConfigurationProperties.DISCOVERY_DUPLICATE_MAC_KEY,
							getDiscoveryDuplicateMacPolicy().toString())));
			
			setLong(ConfigurationProperties.NETWORK_BROWSING_PERIOD_KEY,
					helper.getLong(
							ConfigurationProperties.NETWORK_BROWSING_PERIOD_KEY,
							getNetworkBrowsingPeriod()));
			setLong(ConfigurationProperties.DEVICE_INSPECTION_PERIOD_KEY,
					helper.getLong(
							ConfigurationProperties.DEVICE_INSPECTION_PERIOD_KEY,
							getDeviceInspectionPeriod()));

			setInteger(
					ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY,
					helper.getInt(
							ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY,
							getAutomaticFreeEndPointRetry()));
			setInteger(ConfigurationProperties.FIRST_ENDPOINT_ADDRESS_KEY,
					helper.getInt(
							ConfigurationProperties.FIRST_ENDPOINT_ADDRESS_KEY,
							getFirstFreeEndPoint()));
		}

		logger.debug(
				"Current configuration after applying new configuration is {}",
				configuration);

		if (isChanged) {
			logger.info("Configuration related to the dongle changed, updating it");
			updateDriverConfiguration();
		}
	}

	private boolean setDiscoveryDuplicateMac(String key, DuplicateMacPolicy value) {
		if (getDiscoveryDuplicateMac(key) == value)
			return false;
		configuration.put(key, value);
		return true;
	}

	private DuplicateMacPolicy getDiscoveryDuplicateMac(String key) {
		return (DuplicateMacPolicy) configuration.get(key);
	}

	private int getInt(String key) {
		return ((Integer) configuration.get(key)).intValue();
	}

	private long getLong(String key) {
		return ((Long) configuration.get(key)).longValue();
	}

	private boolean getBoolean(String key) {
		return ((Boolean) configuration.get(key)).booleanValue();
	}

	private String getString(String key) {
		return (String) configuration.get(key);
	}

	private NetworkMode getNetworkMode(String key) {
		return (NetworkMode) configuration.get(key);
	}

	private boolean setStringCaseInsensitive(String key, String value) {
		if (getString(key).equalsIgnoreCase(value))
			return false;
		configuration.put(key, value);
		return true;
	}

	private boolean setStringCaseSensitive(String key, String value) {
		if (getString(key).compareTo(value) == 0)
			return false;
		configuration.put(key, value);
		return true;
	}

	private boolean setLong(String key, long value) {
		if (getLong(key) == value)
			return false;
		configuration.put(key, value);
		return true;
	}

	private boolean setInteger(String key, int value) {
		if (getInt(key) == value)
			return false;
		configuration.put(key, value);
		return true;
	}

	private boolean setBoolean(String key, boolean value) {
		if (getBoolean(key) == value)
			return false;
		configuration.put(key, value);
		return true;
	}

	private boolean setNetworkMode(String key, NetworkMode value) {
		if (getNetworkMode(key) == value)
			return false;
		configuration.put(key, value);
		return true;
	}

	public synchronized short getPanId() {
		return (short) getInt(ConfigurationProperties.PAN_ID_KEY);
	}

	public synchronized byte getChannelId() {
		return (byte) getInt(ConfigurationProperties.CHANNEL_ID_KEY);
	}

	public synchronized String getSerialPortName() {
		return getString(ConfigurationProperties.COM_NAME_KEY);
	}

	public synchronized int getSerialBaudRate() {
		return getInt(ConfigurationProperties.COM_BAUDRATE_KEY);
	}

	public synchronized NetworkMode getNetworkMode() {
		return getNetworkMode(ConfigurationProperties.NETWORK_MODE_KEY);
	}

	public synchronized boolean getForceNetworkCleaning() {
		return getBoolean(ConfigurationProperties.NETWORK_FLUSH_KEY);
	}

	public synchronized int getMessageRetryCount() {
		return getInt(ConfigurationProperties.APPLICATION_MSG_RETRY_COUNT_KEY);
	}

	public synchronized int getMessageRetryDelay() {
		return getInt(ConfigurationProperties.APPLICATION_MSG_RETRY_DELAY_KEY);
	}

	public synchronized long getZigBeeTimeout() {
		return getLong(ConfigurationProperties.APPLICATION_MSG_TIMEOUT_KEY);
	}

	public synchronized DuplicateMacPolicy getDiscoveryDuplicateMacPolicy() {
		return getDiscoveryDuplicateMac(ConfigurationProperties.DISCOVERY_DUPLICATE_MAC_KEY);
	}

	/**
	 * This method configures the {@link SimpleDriver} and open it. Moreover it
	 * will start to apply all the changes of the configuration to the
	 * {@link SimpleDriver} as long as its status is {@link DriverStatus#CLOSED}
	 * 
	 * @param driver
	 *            The {@link SimpleDriver} to configure and keep in synch with
	 *            this configuration
	 */
	public void setDriver(SimpleDriver driver) {
		this.driver = driver;
		if (driver != null) {
			updateDriverConfiguration();
		}
	}

	private void updateDriverConfiguration() {
		if (driver == null) {
			logger.info(
					"No ZigBee Interface Controller configured because the is no {} registered",
					SimpleDriver.class.getName());
			return;
		}
		if (driver != null && driver.getDriverStatus() != DriverStatus.CLOSED) {
			logger.info(
					"{} not configured nor started because its status is not equal to CLOSED",
					driver);
			return;
		}
		logger.debug("Setting driver parameters of {}", driver);
		driver.setSerialPort(getSerialPortName(), getSerialBaudRate());
		driver.setZigBeeNetwork(getChannelId(), (short) getPanId());
		driver.setZigBeeNodeMode(getNetworkMode());
		driver.open(Activator.getCurrentConfiguration()
				.getForceNetworkCleaning());	
	}

	public synchronized long getDeviceInspectionPeriod() {
		return getLong(ConfigurationProperties.DEVICE_INSPECTION_PERIOD_KEY);
	}

	public synchronized long getNetworkBrowsingPeriod() {
		return getLong(ConfigurationProperties.NETWORK_BROWSING_PERIOD_KEY);
	}

	/**
	 * 
	 * @return
	 * @since 0.6.0 - Revision 81
	 */
	public synchronized int getAutomaticFreeEndPointRetry() {
		return getInt(ConfigurationProperties.AUTOMATIC_ENDPOINT_ADDRESS_RETRY_KEY);
	}

	/**
	 * 
	 * @return
	 * @since 0.6.0 - Revision 86
	 */
	public synchronized int getFirstFreeEndPoint() {
		return getInt(ConfigurationProperties.FIRST_ENDPOINT_ADDRESS_KEY);
	}

	/**
	 * 
	 * @return
	 * @since 0.7.0
	 */
	public synchronized EnumSet<DiscoveryMode> getDiscoveryMode() {
		return DiscoveryMode
				.toEnumSet(getInt(BaseDriverProperties.DISCOVERY_MODE_KEY));
	}
}
