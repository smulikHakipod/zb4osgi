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
package org.aaloa.zb4osgi.ha.driver.stub.cluster.impl;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Basic;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class BasicStub implements Basic {

    private static final Logger logger = LoggerFactory.getLogger( BasicStub.class );

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getAlarmMask()
     */
    public Attribute getAlarmMask() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getApplicationVersion()
     */
    public Attribute getApplicationVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getDateCode()
     */
    public Attribute getDateCode() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getDeviceEnabled()
     */
    public boolean getDeviceEnabled()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getHWVersion()
     */
    public Attribute getHWVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getLocationDescription()
     */
    public String getLocationDescription()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getManufacturerName()
     */
    public Attribute getManufacturerName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getModelIdentifier()
     */
    public Attribute getModelIdentifier() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getPhysicalEnviroment()
     */
    public Attribute getPhysicalEnviroment() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getPowerSource()
     */
    public Attribute getPowerSource() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getStackVersion()
     */
    public Attribute getStackVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getZCLVersion()
     */
    public Attribute getZCLVersion() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#resetToFactoryDefault()
     */
    public void resetToFactoryDefault()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getActiveSubscriptions()
     */
    public Subscription[] getActiveSubscriptions() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getAttribute(int)
     */
    public Attribute getAttribute( int id ) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getAttributes()
     */
    public Attribute[] getAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getId()
     */
    public int getId() {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.Cluster#getName()
     */
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getDisableLocalConfig()
     */
    public Attribute getDisableLocalConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Basic#getPhysicalEnvironment()
     */
    public Attribute getPhysicalEnvironment() {
        // TODO Auto-generated method stub
        return null;
    }

}
