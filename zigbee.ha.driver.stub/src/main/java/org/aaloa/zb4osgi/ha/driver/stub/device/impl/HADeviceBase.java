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
package org.aaloa.zb4osgi.ha.driver.stub.device.impl;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Alarms;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Basic;
import it.cnr.isti.zigbee.ha.cluster.glue.general.DeviceTemperatureConfiguration;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Identify;
import it.cnr.isti.zigbee.ha.cluster.glue.general.PowerConfiguration;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;
import it.cnr.isti.zigbee.zcl.library.impl.general.AlarmsCluster;
import it.cnr.isti.zigbee.zcl.library.impl.general.BasicCluster;
import it.cnr.isti.zigbee.zcl.library.impl.general.DeviceTemperatureConfigurationCluster;
import it.cnr.isti.zigbee.zcl.library.impl.general.IdentifyCluster;
import it.cnr.isti.zigbee.zcl.library.impl.general.PowerConfigurationCluster;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public abstract class HADeviceBase implements HADevice {
    
    private static final Logger logger = LoggerFactory.getLogger( HADeviceBase.class );

    private static final int HOME_AUTOMATION_PROFILE = 260;
    
    private final AdvancedDeviceDescription description;
    
    public HADeviceBase(AdvancedDeviceDescription description){
        this.description = description;
    }
    
    public abstract HashMap<Integer, Cluster> getClusters();

    public int getDeviceType() {
        return description.getDeviceType();
    }

    public String getName() {
        return description.getName();
    }

    public Cluster[] getAvailableCluster() {
        return (Cluster[]) getClusters().values().toArray(new Cluster[]{});
    }

    public Cluster getCluster( int id ) {
        return getClusters().get( id );
    }

    public DeviceDescription getDescription() {
        return description;
    }

    public int getProfileId() {
        return HOME_AUTOMATION_PROFILE;
    }

    public Alarms getAlarms() {
        return (Alarms) getClusters().get( AlarmsCluster.ID );
    }

    public Basic getBasic() {
        return (Basic) getClusters().get( BasicCluster.ID );
    }

    public Identify getIdentify() {
        return (Identify) getClusters().get( IdentifyCluster.ID );
    }
    
    public DeviceTemperatureConfiguration getDeviceTemperatureConfiguration() {
        return (DeviceTemperatureConfiguration) getClusters().get( DeviceTemperatureConfigurationCluster.ID );
    }

    public PowerConfiguration getPowerConfiguration() {
        return (PowerConfiguration) getClusters().get( PowerConfigurationCluster.ID );
    }

}
