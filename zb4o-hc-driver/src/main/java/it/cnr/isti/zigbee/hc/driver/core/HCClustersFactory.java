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

package it.cnr.isti.zigbee.hc.driver.core;


import it.cnr.isti.zigbee.hc.cluster.impl.BasicImpl;

import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HCClustersFactory extends ClusterFactoryBase {

    //General
    final static String BASIC_KEY = HCProfile.ID + ":" + HCProfile.BASIC;
    final static String POWER_CONFIGURATION_KEY = HCProfile.ID + ":"+ HCProfile.POWER_CONFIGURATION;
    final static String IDENTIFY_KEY = HCProfile.ID + ":"+ HCProfile.IDENTIFY;
    final static String TIME_KEY = HCProfile.ID + ":"+ HCProfile.TIME;
    final static String ALARMS_KEY = HCProfile.ID + ":"+ HCProfile.ALARMS;
    final static String RSSI_LOCATION_KEY = HCProfile.ID + ":"+ HCProfile.RSSI_LOCATION;
    final static String COMMISSIONING_KEY = HCProfile.ID + ":"+ HCProfile.COMMISSIONING;
    final static String PARTITION_KEY = HCProfile.ID + ":"+ HCProfile.PARTITION;
    final static String ALPHA_SECURE_ACCESS_CONTROL_KEY = HCProfile.ID + ":"+ HCProfile.ALPHA_SECURE_ACCESS_CONTROL;
    final static String ALPHA_SECURE_KEY_ESTABLISHMENT_KEY = HCProfile.ID + ":"+ HCProfile.ALPHA_SECURE_KEY_ESTABLISHMENT;

    //Protocol Interfaces
    final static String GENERIC_TUNNEL_KEY = HCProfile.ID + ":"+ HCProfile.GENERIC_TUNNEL;
    final static String PROTOCOL_TUNNEL_11073_KEY = HCProfile.ID + ":"+ HCProfile.PROTOCOL_TUNNEL_11073;

    // Telecommunications Clusters
    final static String VOICE_OVER_ZIGBEE_KEY = HCProfile.ID + ":"+ HCProfile.VOICE_OVER_ZIGBEE;




    public HCClustersFactory(BundleContext ctx){
        super(ctx);

        //General
        addCluster(BASIC_KEY, BasicImpl.class);
        addCluster(POWER_CONFIGURATION_KEY, BasicImpl.class);
        addCluster(IDENTIFY_KEY, BasicImpl.class);
        addCluster(ALARMS_KEY, BasicImpl.class);
        addCluster(TIME_KEY, BasicImpl.class);
        addCluster(RSSI_LOCATION_KEY, BasicImpl.class);
        addCluster(COMMISSIONING_KEY, BasicImpl.class);
        //addCluster(PARTITION_KEY, CommissioningImpl.class); // TODO
        //addCluster(ALPHA_SECURE_ACCESS_CONTROL_KEY, CommissioningImpl.class); // TODO
        //addCluster(ALPHA_SECURE_KEY_ESTABLISHMENT_KEY, CommissioningImpl.class); // TODO

        //Measurement and Sensing
        addCluster(GENERIC_TUNNEL_KEY, BasicImpl.class);
        addCluster(PROTOCOL_TUNNEL_11073_KEY, BasicImpl.class);

        //Telecommunications
        //addCluster(VOICE_OVER_ZIGBEE_KEY, IASZoneImpl.class); //TODO
    }

}
