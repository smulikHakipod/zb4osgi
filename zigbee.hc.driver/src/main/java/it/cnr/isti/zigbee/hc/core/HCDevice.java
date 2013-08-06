package it.cnr.isti.zigbee.hc.core;
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



import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Alarms;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Basic;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Commissioning;
import it.cnr.isti.zigbee.ha.cluster.glue.general.DeviceTemperatureConfiguration;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Identify;
import it.cnr.isti.zigbee.ha.cluster.glue.general.PowerConfiguration;
import it.cnr.isti.zigbee.ha.cluster.glue.general.RSSILocation;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Time;
import it.cnr.isti.zigbee.ha.cluster.glue.protocol_interfaces.GenericTunnel;
import it.cnr.isti.zigbee.ha.driver.ArraysUtil;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;
import it.cnr.isti.zigbee.hc.cluster.glue.ProtocolTunnel11073;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public interface HCDevice {

    public static final String ZIGBEE_DEVICE_SERVICE = "zigbee.service.id";
    public static final String ZIGBEE_DEVICE_UUID = "zigbee.device.uuid";
    public static final String HC_DRIVER = "zigbee.hc.driver.name";
    public static final String HC_DEVICE_NAME = "zigbee.hc.name";
    public static final String HC_DEVICE_GROUP = "zigbee.hc.group";
    public static final String HC_DEVICE_STANDARD = "zigbee.hc.standard";

    public static final int[] MANDATORY = {
        HCProfile.BASIC, HCProfile.IDENTIFY, HCProfile.GENERIC_TUNNEL, HCProfile.PROTOCOL_TUNNEL_11073
    };

    public static final int[] OPTIONAL = {
        HCProfile.POWER_CONFIGURATION, HCProfile.ALARMS, HCProfile.TIME, HCProfile.RSSI_LOCATION,
        HCProfile.ALPHA_SECURE_KEY_ESTABLISHMENT, HCProfile.ALPHA_SECURE_ACCESS_CONTROL,
        HCProfile.PARTITION, HCProfile.COMMISSIONING
    };

    public static final int[] STANDARD = ArraysUtil.append(MANDATORY, OPTIONAL);

    public String getName();
    /**
     *
     * @return an <code>int</code> representing the <b>DeviceId</b> as defined by the<br>
     * 		<i>ZigBee Home Automation</i> profile documentation
     */
    public int getDeviceType();
    public int getEndPointId();
    public int getProfileId();

    /**
     * Access method for the <b>Mandatory</b> cluster: {@link Basic}
     *
     * @return the {@link Basic} cluster object
     */
    public Basic getBasic();

    /**
     * Access method for the <b>Mandatory</b> cluster: {@link Basic}
     *
     * @return the {@link Basic} cluster object
     */
    public Identify getIdentify();

    /**
     * Access method for the <b>Mandatory</b> cluster: {@link GenericTunnel}
     *
     * @return the {@link GenericTunnel} cluster object
     */
    public GenericTunnel getGenericTunnel();

    /**
     * Access method for the <b>Mandatory</b> cluster: {@link DeviceTemperatureConfiguration}
     *
     * @return the {@link DeviceTemperatureConfiguration} cluster object
     */
    public ProtocolTunnel11073 get11073ProtocolTunnel();

    /**
     * Access method for the <b>Optional</b> cluster: {@link PowerConfiguration}
     *
     * @return the {@link PowerConfiguration} cluster object
     */
    public PowerConfiguration getPowerConfiguration();

    /**
     * Access method for the <b>Optional</b> cluster: {@link Alarms}
     *
     * @return the {@link Alarms} cluster object
     */
    public Alarms getAlarms();

    /**
     * Access method for the <b>Optional</b> cluster: {@link Time}
     *
     * @return the {@link Time} cluster object
     */
    public Time getTime();

    /**
     * Access method for the <b>Optional</b> cluster: {@link RSSILocation}
     *
     * @return the {@link RSSILocation} cluster object
     */
    public RSSILocation getRSSILocation();

//    /**
//     * Access method for the <b>Optional</b> cluster: {@link RSSILocation}
//     *
//     * @return the {@link RSSILocation} cluster object
//     */
//    public ASKE getASKE();
//
//    /**
//     * Access method for the <b>Optional</b> cluster: {@link RSSILocation}
//     *
//     * @return the {@link RSSILocation} cluster object
//     */
//    public ASAC getASAC();
//
//    /**
//     * Access method for the <b>Optional</b> cluster: {@link RSSILocation}
//     *
//     * @return the {@link RSSILocation} cluster object
//     */
//    public Partition getPartition();


    /**
     * Access method for the <b>Optional</b> cluster: {@link Commissioning}
     *
     * @return the {@link Commissioning} cluster object
     */
    public Commissioning getCommissioning();

    /**
     * Access method to the {@link DeviceDescription}.<br>
     *
     * <b>NOTE</b>: The {@link DeviceDescription} <b>should</b> be shared among all {@link HADeviceBase}<br>
     * sharing the same <b>DeviceId</b>
     *
     * @return the {@link DeviceDescription}
     */
    public DeviceDescription getDescription();
    /**
     *
     * @param id the <code>int</code> representing the <b>ClusterId</b>
     * @return the {@link Cluster} identified by the given id if this device implements<br>
     * 		otherwise <code>null</code>
     * @since 0.2.0
     */
    public Cluster getCluster(int id);

    /**
     *
     * @return the {@link Cluster} array effectively implemented by the remote ZigBee Device<br>
     * 		otherwise <code>null</code>
     */
    public  Cluster[] getAvailableCluster();


    /**
     *
     * @return return {@link ZigBeeDevice} service that has been refined has {@link HCDevice}
     * @since 0.2.0
     * @deprecated The method should be avoided because it cause Service Reference Leak
     */
    public ZigBeeDevice getZBDevice();
}
