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
import it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff;
import it.cnr.isti.zigbee.ha.cluster.glue.general.event.OnOffListener;
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
public class OnOffStub
    implements OnOff {

    private static final Logger logger = LoggerFactory.getLogger( OnOffStub.class );

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#getOnOff()
     */
    public boolean getOnOff()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#off()
     */
    public void off()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#on()
     */
    public void on()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#subscribe(it.cnr.isti.zigbee.ha.cluster.glue.general.event.OnOffListener)
     */
    public boolean subscribe( OnOffListener listener ) {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#toggle()
     */
    public void toggle()
        throws ZigBeeHAException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff#unsubscribe(it.cnr.isti.zigbee.ha.cluster.glue.general.event.OnOffListener)
     */
    public boolean unsubscribe( OnOffListener listener ) {
        // TODO Auto-generated method stub
        return false;
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

}
