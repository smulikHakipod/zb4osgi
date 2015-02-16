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
package org.aaloa.zb4osgi.ha.driver.stub.device.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Alarms;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Groups;
import it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes;
import it.cnr.isti.zigbee.ha.device.api.generic.OnOffOutput;
import it.cnr.isti.zigbee.ha.device.impl.OnOffOutputDevice;

import java.util.HashMap;

import org.aaloa.zb4osgi.ha.driver.stub.cluster.impl.AlarmsStub;
import org.aaloa.zb4osgi.ha.driver.stub.cluster.impl.GroupsStub;
import org.aaloa.zb4osgi.ha.driver.stub.cluster.impl.OnOffStub;
import org.aaloa.zb4osgi.ha.driver.stub.cluster.impl.ScenesStub;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class OnOffOutputDeviceStub extends HADeviceBase implements OnOffOutput {

    final HashMap<Integer, Cluster> map = new HashMap<Integer, Cluster>();

    public OnOffOutputDeviceStub(){        
        super(
            new AdvancedDeviceDescription(
                OnOffOutput.DEVICE_ID, 
                OnOffOutput.NAME, 
                OnOffOutputDevice.DEVICE_DESCRIPTOR
            )
        );
    }
    
    public HashMap<Integer, Cluster> getClusters() {
        return map;
    }
    
    public Groups getGroups() {
        return new GroupsStub();
    }

    public OnOff getOnOff() {
        return new OnOffStub();
    }

    public Scenes getScenes() {
        return new ScenesStub();
    }

    public Alarms getAlarms() {
        return new AlarmsStub();
    }

    public int getEndPointId() {
        return 0;
    }

    public ZigBeeDevice getZBDevice() {
        return null;
    }
}
