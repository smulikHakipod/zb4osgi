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
import it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.AddScenePayload;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.AddSceneResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.GetSceneMembershipResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.RemoveAllScenesResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.RemoveSceneResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.StoreSceneResponse;
import it.cnr.isti.zigbee.zcl.library.api.general.scenes.ViewSceneResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ScenesStub implements Scenes {

    private static final Logger logger = LoggerFactory.getLogger( ScenesStub.class );

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#recallScene(int, short)
     */
    public void recallScene( int groupId, short sceneId )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub

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
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#addScene(it.cnr.isti.zigbee.zcl.library.api.general.scenes.AddScenePayload)
     */
    public AddSceneResponse addScene( AddScenePayload scenePayload )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getCurrentGroup()
     */
    public Attribute getCurrentGroup() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getCurrentScene()
     */
    public Attribute getCurrentScene() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getLastConfiguredBy()
     */
    public Attribute getLastConfiguredBy() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getNameSupport()
     */
    public Attribute getNameSupport() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getSceneCount()
     */
    public Attribute getSceneCount() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getSceneMembership(int)
     */
    public GetSceneMembershipResponse getSceneMembership( int groupId )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#getSceneValid()
     */
    public Attribute getSceneValid() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#removeScene(int, short)
     */
    public RemoveSceneResponse removeScene( int groupId, short sceneId )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#storeScene(int, short)
     */
    public StoreSceneResponse storeScene( int groupId, short sceneId )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#viewScene(int, short)
     */
    public ViewSceneResponse viewScene( int groupId, short sceneId )
        throws ZigBeeHAException {
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

    /* (non-Javadoc)
     * @see it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes#removeAllScene(int)
     */
    public RemoveAllScenesResponse removeAllScene( int groupId )
        throws ZigBeeHAException {
        // TODO Auto-generated method stub
        return null;
    }

}
