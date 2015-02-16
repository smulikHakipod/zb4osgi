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

package it.cnr.isti.zigbee.eh.driver.core;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.Activator;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Basic;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Identify;
import it.cnr.isti.zigbee.ha.driver.HADriverConfiguration;
import it.cnr.isti.zigbee.ha.driver.HADriverConfiguration.ProvidedClusterMode;
import it.cnr.isti.zigbee.ha.driver.core.ClusterFactory;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;
import it.cnr.isti.zigbee.zcl.library.api.core.Subscription;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class represent a generic <b>Energy @ Home Device</b> as defined by the document:<br>
 * <i>ZigBee Energy @ Home</i> public release version 075123r01ZB
 * <br>
 * <b>NOTE</b>: In general the mapping between <b>ClusterId</b> and <b>Cluster</b> is defined<br>
 * by the profile, while the mapping between <b><i>Name</i></b> and <b>Cluster</b> is defined where the<br>
 * <b>Cluster</b> is defined: usually inside a <i>Cluster Library</i>
 *
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 *
 * @version $LastChangedRevision: 906 $ ($LastChangedDate: 2014-01-17 18:00:09 +0100(ven, 17 gen 2014) $)
 * @since 0.1.0
 *
 */
public abstract class EHDeviceBase implements EHDevice  {

    private final static Logger logger = LoggerFactory.getLogger(EHDeviceBase.class);

    protected ZigBeeDevice zbDevice;
    private BundleContext ctx;


    private Cluster[] clusters;
    private int index;


    /*
     * Mandatory clusters common to all Energy @ Home devices
     */
    protected Basic basic;
    protected Identify identify;
    /*
     * Optional clusters common to all Energy @ Home devices
     */




    public EHDeviceBase(BundleContext ctx, ZigBeeDevice zbDevice ) throws ZigBeeHAException{
        this.zbDevice = zbDevice;
        this.ctx = ctx;

        final int size;
        if( Activator.getConfiguration().getClusterMode() == ProvidedClusterMode.HomeAutomationProfileStrict ){
            size = zbDevice.getInputClusters().length;
        }else{
            size = zbDevice.getInputClusters().length + zbDevice.getOutputClusters().length;
        }
        clusters = new Cluster[size];
		
        for ( int i = 0; i < zbDevice.getInputClusters().length; i++ ) {
            addCluster( zbDevice.getInputClusters()[i] );
        }
		if( Activator.getConfiguration().getClusterMode() != ProvidedClusterMode.HomeAutomationProfileStrict ){
		    for ( int i = 0; i < zbDevice.getOutputClusters().length; i++ ) {
                addCluster( zbDevice.getOutputClusters()[i] );
            }
		} 

        basic = (Basic) addCluster(EHProfile.BASIC);
        identify = (Identify) addCluster(EHProfile.IDENTIFY);

    
    }

    public  int getDeviceType(){
        return zbDevice.getDeviceId();
    }

    public abstract  String getName();

    public  int getEndPointId(){
        return zbDevice.getId();
    }
    public  int getProfileId(){
        return zbDevice.getProfileId();
    }


    protected boolean isClusterValid(int clusterId, ProvidedClusterMode complainanceMode ) {
        if ( zbDevice.providesInputCluster(clusterId) ) {
            return true;
        }
        return false;
    }

    /**
     * This method create a cluster for the HADevice if and only if the cluster is actually supported by the device.
     * Depending on the current value of {@link HADriverConfiguration#getClusterMode()} it add or not the cluster
     * to the set of cluster which will be returned by executing the method {@link #getAvailableCluster()}
     *
     * @param clusterId the id of the cluster
     * @return {@link Cluster} if it is already present or if it has been added to the {@link EHDeviceBase}
     * @throws ZigBeeHAException
     * @see {@link HADriverConfiguration#PROVIDED_CLUSTER_MODE_KEY}
     */
    protected Cluster addCluster(int clusterId) throws ZigBeeHAException {
        /*
         * Verify if the cluster has already been added. For example, when the HA Driver is working with
         * ProvidedClusterMode.EitherInputAndOutput mode the HA Driver adds either inputs and outputs cluster
         * to the HADeviceBase
         */
        final Cluster duplicated = getCluster( clusterId );
        if ( duplicated != null ) {
            logger.warn(
                    "Cluster {}/{} already added to this device. " +
                    "It may identifies an error in the definition of the device description",
                    duplicated.getName(), Integer.toHexString(clusterId)
            );
            return duplicated;
        }


        //TODO We should move this code in isClusterValid() method
        /*
         * We are trying to add a cluster which is not defined as input cluster and is optional then we are not going to add it
         */
        if ( ! zbDevice.providesInputCluster(clusterId) && getDescription().isOptional(clusterId) ){
            logger.warn(
                    "[WARNING] ZigBeeDevice with DeviceId={} of Energy @ Home profile " +
                    "implements the OPTIONAL cluster {} ONLY AS OUTPUT instead of input " +
                    "it may identify an error either on the Driver description or in " +
                    "in the implementation of firmware of the physical device",
                    zbDevice.getDeviceId(), clusterId
            );
            return null;
        }

        /*
         * We are trying to add a cluster which is not defined as input cluster and is optional then we are not going to add it
         */
        if (! zbDevice.providesInputCluster(clusterId) && getDescription().isCustom(clusterId)){
            //TODO check if exists custom add-on by using ProfileModule interface
            logger.warn(
                    "[WARNING] ZigBeeDevice with DeviceId={} of Energy @ Home profile " +
                    "implements a CUSTOM cluster {} but HA Driver does not support them yet",
                    zbDevice.getDeviceId(), clusterId
            );
            return null;
        }

        /*
         * This is the last case, when a Cluster is not defined as input but it is among the mandotory cluster of the device
         * so if ProvidedClusterMode.EitherInputAndOutput is set we will consider it as a firmware issue so we will add the cluster anyway
         */
        if ( ! zbDevice.providesInputCluster(clusterId) && getDescription().isMandatory(clusterId) ){
            logger.warn(
                    "ZigBeeDevice with DeviceId={} of Energy @ Home profile " +
                    "doesn't implement mandatory cluster {}", zbDevice.getDeviceId(), clusterId
            );
            if ( zbDevice.providesOutputCluster(clusterId) ){
                logger.error(
                        "ZigBeeDevice with DeviceId={} of Energy @ Home profile " +
                        "implements the mandatory cluster {} as output instead of as input " +
                        "it may identify an error either on the Driver description or in " +
                        "in the implementation of firmware of the physical device",
                        zbDevice.getDeviceId(), clusterId
                );
            } else {
                logger.error(
                        "ZigBeeDevice with DeviceId={} of Energy @ Home profile " +
                        "doesn't implements the mandatory cluster {} neither as output " +
                        "nor as input it may identify an error either on the Driver " +
                        "description or in in the implementation of firmware of the " +
                        "physical device",
                        zbDevice.getDeviceId(), clusterId
                );
                return null;
            }
            if( Activator.getConfiguration().getClusterMode() == ProvidedClusterMode.HomeAutomationProfileStrict ) {
                logger.warn(
                        "The cluster {} of the device {} is PROVIDED AS OUTPUT instead of AS INPUT, " +
                        "if you want to add it anyway please change the value of the property {} " +
                        " from {} to {}", new Object[]{
                                clusterId,
                                zbDevice.getDeviceId(),
                                HADriverConfiguration.PROVIDED_CLUSTER_MODE_KEY,
                                ProvidedClusterMode.HomeAutomationProfileStrict,
                                ProvidedClusterMode.EitherInputAndOutput
                        }
                );
                return null;
            } else {
                logger.warn(
                        "The cluster {} of the device {} is PROVIDED AS OUTPUT instead of AS INPUT, " +
                        "it will be added anyway to the device due to value of the property {} " +
                        ", if you want to disable this change the value from {} to {}",
                        new Object[]{
                            clusterId,
                            zbDevice.getDeviceId(),
                            HADriverConfiguration.PROVIDED_CLUSTER_MODE_KEY,
                            ProvidedClusterMode.EitherInputAndOutput,
                            ProvidedClusterMode.HomeAutomationProfileStrict
                        }
                );
            }
        }

        /*
         * At this point we agreed that we should add the Cluster to the device, so we are looking for
         * ClusterFactory that can provide it
         */
        try {
            //TODO We should add a enum configuration property for enabling both the following behavior or just one of them 
            
            String key = EHProfile.ID + ":"+String.valueOf(clusterId);
            String filter = "(" + Cluster.PROFILE_CLUSTER_IDS + "=" + key+ ")";
            ServiceReference[] srClusterFactory = ctx.getServiceReferences(ClusterFactory.class.getName(), filter);
            if( srClusterFactory != null ) {
                ClusterFactory factory = (ClusterFactory) ctx.getService(srClusterFactory[0]);
                Cluster cluster = factory.getInstance(key,zbDevice);
                clusters[index++] = cluster;
                return cluster;
            }
            
            /*
             * After looking up for a ClusterFactory that matches <profileId,clusterId> key, we relax the look up.
             * We are now looking for a ClusterFactory that support the <profileId> of my device and also support
             * the cluster that we are trying to use.
             */
            filter = "(&" +
            		"(" + Cluster.BELONGING_PROFILES + "=" + EHProfile.ID + ")" +
        			"(" + Cluster.RAW_CLUSTER_IDS + "=" + String.valueOf(clusterId) + ")" +
    			")";
            srClusterFactory = ctx.getServiceReferences(ClusterFactory.class.getName(), filter);
            if( srClusterFactory != null ) {
                ClusterFactory factory = (ClusterFactory) ctx.getService(srClusterFactory[0]);
                Cluster cluster = factory.getInstance(key,zbDevice);
                clusters[index++] = cluster;
                return cluster;
            }            
        } catch (InvalidSyntaxException e) {
            logger.error("Modified the value of ANY_HADEVICE_FILTER and recompile",e);
        }

        logger.error("No ClusterFactory found implementing the requested cluster {}", clusterId);
        return null;
    }

    public Basic getBasic(){
        return basic;
    }


    public Identify getIdentify(){
        return identify;
    }

  

    public abstract DeviceDescription getDescription();

    public Cluster getCluster(int id){
        for (int i = 0; i < clusters.length; i++) {
            if (clusters[i] != null && clusters[i].getId()==id)
                return clusters[i];
        }
        return null;
    }

    /**
     *
     * @param name the {@link String} representing the name associated to <b>ClusterId</b>
     * @return the {@link ZCLCluster} identified by the given name if this device implements<br>
     * 		otherwise <code>null</code>
     */
    public Cluster getCluster(String name){
        for (int i = 0; i < clusters.length; i++) {
            if (clusters[i] != null && clusters[i].getName().equals(name))
                return clusters[i];
        }
        return null;
    }

    public  Cluster[] getAvailableCluster(){
        return clusters;
    }

    public void stop() {
        for (int i = 0; i < clusters.length; i++) {
            if ( clusters[i] == null ) continue;

            Subscription[] subscriptions = clusters[i].getActiveSubscriptions();
            if ( subscriptions == null ) continue;

            for (int j = 0; j < subscriptions.length; j++) {
                if ( subscriptions[j] == null ) continue;
                subscriptions[j].clear();
            }
        }
    }

    public ZigBeeDevice getZBDevice(){
        return zbDevice;
    }


}
