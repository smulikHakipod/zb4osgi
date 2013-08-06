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

import it.cnr.isti.zigbee.zcl.library.api.general.Alarms;
import it.cnr.isti.zigbee.zcl.library.api.general.Basic;
import it.cnr.isti.zigbee.zcl.library.api.general.Commissioning;
import it.cnr.isti.zigbee.zcl.library.api.general.Identify;
import it.cnr.isti.zigbee.zcl.library.api.general.PowerConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.general.Time;

/**
 * This class collects all the Device and Cluster ids used by the <b>ZigBee Health Care Profile</b>
 * as specified by the public document <i>ZigBee Document 075360r15</i>
 *
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HCProfile {

    /**
     * The ZigBee Health Care Profile identifier specified by the ZigBee Alliance
     */
    public static final int ID = 0x0108;

    /*
     * CLUSTERS
     */
    /* Generic Clusters */
    public static final int BASIC = Basic.ID;
    public static final int POWER_CONFIGURATION = PowerConfiguration.ID;
    public static final int IDENTIFY = Identify.ID;
    public static final int TIME = Time.ID;
    public static final int ALARMS = Alarms.ID;
    public static final int RSSI_LOCATION = 0x000b; // TODO
    public static final int COMMISSIONING = Commissioning.ID; // TODO
    public static final int PARTITION = 0x0016; // TODO
    public static final int ALPHA_SECURE_ACCESS_CONTROL = 0x0017; // TODO
    public static final int ALPHA_SECURE_KEY_ESTABLISHMENT = 0x0018; // TODO

    /* Protocol Interfaces Clusters */
    public static final int GENERIC_TUNNEL = 0x0600; // TODO
    public static final int PROTOCOL_TUNNEL_11073 = 0x614; // TODO

    /* Telecommunications Clusters */
    public static final int VOICE_OVER_ZIGBEE = 0x904; // TODO

    /*
     * DEVICES
     */
    /* Data Management Devices */
    public static final int GENERIC_MULTIFUNCTION_HEALTHCARE_DEVICE = 0x0f00;	//TODO

    /* Multifunction Devices */
    public static final int PULSE_OXIMETER = 0x1004; //TODO
    public static final int ECG = 0x1006; //TODO
    public static final int BLOOD_PRESSURE_MONITOR = 0x1007; //TODO
    public static final int THERMOMETER = 0x1008; //TODO
    public static final int WEIGHT_SCALE = 0x100f; //TODO

    /* Disease Management Devices */
    public static final int GLUCOSE_METER = 0x1011; //TODO
    public static final int INTERNATIONAL_NORMALIZED_RATIO = 0x1012; //TODO
    public static final int INSULIN_PUMP = 0x1013; //TODO
    public static final int PEAK_FLOW_MONITOR = 0x1015; //TODO

    /* Health and Fitness Devices */
    public static final int CARDIOVASCULAR_FITNESS_AND_ACTIVITY_MONITOR = 0x1029; //TODO
    public static final int STRENGTH_FITNESS_EQUIPMENT = 0x102a; //TODO
    public static final int PHYSICAL_ACTIVITY_MONITOR = 0x102b; //TODO
    public static final int STEP_COUNTER = 0x1068; //TODO

    /* Aging Independently Devices */
    public static final int INDEPENDENT_LIVING_ACTIVITY_HUB = 0x1047; //TODO
    public static final int ADHERENCE_MONITOR = 0x1048; //TODO
    public static final int FALL_SENSOR = 0x1075; //TODO
    public static final int PERS_SENSOR = 0x1076; //TODO
    public static final int SMOKE_SENSOR = 0x1077; //TODO
    public static final int CO_SENSOR = 0x1078; //TODO
    public static final int WATER_SENSOR = 0x1079; //TODO
    public static final int GAS_SENSOR = 0x107a; //TODO
    public static final int MOTION_SENSOR = 0x107b; //TODO
    public static final int PROPERTY_EXIT_SENSOR = 0x107c; //TODO
    public static final int ENURESIS_SENSOR = 0x107d; //TODO
    public static final int CONTACT_CLOSURE_SENSOR = 0x107e; //TODO
    public static final int USAGE_SENSOR = 0x107f; //TODO
    public static final int SWITCH_USE_SENSOR = 0x1080; //TODO
    public static final int DOSAGE_SENSOR = 0x1081; //TODO
    public static final int TEMPERATURE_SENSOR = 0x1082; //TODO

    public String getDeviceName(String deviceID) {

        try {
            String id = Integer.toHexString((Integer.parseInt(deviceID)));
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getClusterName(String clusterID) {

        try {
            String id = Integer.toHexString((Integer.parseInt(clusterID)));

            if (id.equals(Integer.toHexString(HCProfile.BASIC)))
                return Basic.NAME;
            else if (id.equals(Integer
                    .toHexString(HCProfile.POWER_CONFIGURATION)))
                return PowerConfiguration.NAME;
            else if (id.equals(Integer.toHexString(HCProfile.IDENTIFY)))
                return Identify.NAME;
            else if (id.equals(Integer.toHexString(HCProfile.ALARMS)))
                return Alarms.NAME;
            else if (id.equals(Integer.toHexString(HCProfile.TIME)))
                return Time.NAME;
            else if (id.equals(Integer.toHexString(HCProfile.COMMISSIONING)))
                return Commissioning.NAME;

            else
                return null;
        } catch (Exception ex) {
            return null;
        }
    }

    public String getCategoryDeviceName(String deviceID) {
        // TODO
        try {
            return null;
        } catch (Exception ex) {
            return null;
        }
    }
}