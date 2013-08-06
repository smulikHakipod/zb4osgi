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
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class AdvancedDeviceDescription
    implements DeviceDescription {

    private static final Logger logger = LoggerFactory.getLogger( AdvancedDeviceDescription.class );
    private final int type;
    private final String name;
    private final DeviceDescription description;

    public AdvancedDeviceDescription(int type, String name, DeviceDescription dd){
        this.type = type;
        this.name = name;
        this.description = dd;
        
    }
    
    public String getName() {
        return name;
    }
    
    public int getDeviceType() {
        return type;
    }

    /**
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#getCustomClusters()
     */
    public int[] getCustomClusters() {
        return description.getCustomClusters();
    }

    /**
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#getMandatoryCluster()
     */
    public int[] getMandatoryCluster() {
        return description.getMandatoryCluster();
    }

    /**
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#getOptionalCluster()
     */
    public int[] getOptionalCluster() {
        return description.getOptionalCluster();
    }

    /**
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#getStandardClusters()
     */
    public int[] getStandardClusters() {
        return description.getStandardClusters();
    }

    /**
     * @param clusterId
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#isCustom(int)
     */
    public boolean isCustom( int clusterId ) {
        return description.isCustom( clusterId );
    }

    /**
     * @param clusterId
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#isMandatory(int)
     */
    public boolean isMandatory( int clusterId ) {
        return description.isMandatory( clusterId );
    }

    /**
     * @param clusterId
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#isOptional(int)
     */
    public boolean isOptional( int clusterId ) {
        return description.isOptional( clusterId );
    }

    /**
     * @param clusterId
     * @return
     * @see it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription#isStandard(int)
     */
    public boolean isStandard( int clusterId ) {
        return description.isStandard( clusterId );
    }

}
