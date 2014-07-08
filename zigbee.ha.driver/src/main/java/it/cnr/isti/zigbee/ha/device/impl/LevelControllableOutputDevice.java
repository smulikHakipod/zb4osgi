/*
   Copyright 2008-2014 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.ha.device.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Groups;
import it.cnr.isti.zigbee.ha.cluster.glue.general.LevelControl;
import it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes;
import it.cnr.isti.zigbee.ha.device.api.generic.LevelControllableOutput;
import it.cnr.isti.zigbee.ha.device.api.generic.OnOffOutput;
import it.cnr.isti.zigbee.ha.device.api.lighting.OnOffLight;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceBase;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.ha.driver.core.reflection.AbstractDeviceDescription;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;

import org.osgi.framework.BundleContext;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.8.0
 *
 */
public class LevelControllableOutputDevice extends HADeviceBase implements LevelControllableOutput {

    private OnOff onOff;
    private Scenes scenes;
    private Groups groups;
    private LevelControl levelControl;

    public  LevelControllableOutputDevice(BundleContext ctx,ZigBeeDevice zbDevice) throws ZigBeeHAException {
        super(ctx,zbDevice);
        onOff = (OnOff) addCluster(HAProfile.ON_OFF);
        groups = (Groups) addCluster(HAProfile.GROUPS);
        scenes = (Scenes) addCluster(HAProfile.SCENES);
        levelControl = (LevelControl) addCluster(HAProfile.LEVEL_CONTROL);
    }


    public Groups getGroups() {
        return groups;
    }

    public OnOff getOnOff() {
        return onOff;
    }

    public Scenes getScenes() {
        return scenes;
    }

    public LevelControl getLevelControl() {
        return levelControl;
    }

    @Override
    public String getName() {
        return OnOffOutput.NAME;
    }

    public final static DeviceDescription DEVICE_DESCRIPTOR =  new AbstractDeviceDescription(){

        public int[] getCustomClusters() {
            return OnOffLight.CUSTOM;
        }

        public int[] getMandatoryCluster() {
            return OnOffLight.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return OnOffLight.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return OnOffLight.STANDARD;
        }

    };

    @Override
    public DeviceDescription getDescription() {
        return DEVICE_DESCRIPTOR;
    }





}
