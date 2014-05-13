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

package it.cnr.isti.zigbee.ha.driver.core;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;

import java.lang.reflect.Constructor;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Properties;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class ClusterFactoryBase implements ClusterFactory{

    private static final int PROFILE_ID_IDX = 0;
	private static final int CLUSTER_ID_IDX = 1;
	
	private final static Logger log = LoggerFactory.getLogger(ClusterFactoryBase.class);
	
	private BundleContext ctx;
    private ServiceRegistration registration = null;
    private Dictionary dictionary;
    private Hashtable<String, Class> clusters;


    public ClusterFactoryBase(BundleContext ctx){
        this.ctx = ctx;
        dictionary = new Properties();
        clusters = new Hashtable<String, Class>();
    }



    public void addProperty(String key, Object value){
        dictionary.put(key, value);
    }


    public void register(){
    	HashSet<String> profiles = new HashSet<String>();
    	HashSet<String> rawClustersIds = new HashSet<String>();
    	
        Enumeration<String> keys = clusters.keys();
        String[] clusterIDs = new String[clusters.size()];
        int i = 0;
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            clusterIDs[i++]=key;
            
        	String[] parts = key.split(":");
        	if ( parts.length == 2 ){
        		profiles.add(parts[PROFILE_ID_IDX]);
        		rawClustersIds.add(parts[CLUSTER_ID_IDX]);
        	} else {
        		log.warn(
        				"Using cluster key {}, that does not belong to the standard format <profileId>:<clusterId>, "
        				+ "so unable to populate automatically the profile id set and cluster raw id set. "
        				+ "The cluster {} will be ignored.", key, clusters.get(key)
    			);    		 
        	}            
        }
        dictionary.put(Cluster.PROFILE_CLUSTER_IDS, clusterIDs);
        dictionary.put(Cluster.BELONGING_PROFILES, profiles.toArray(new String[]{}));
        dictionary.put(Cluster.RAW_CLUSTER_IDS, rawClustersIds.toArray(new String[]{}));
        registration = ctx.registerService(ClusterFactory.class.getName(), this, dictionary);
    }

    public void unregister(){
        registration.unregister();
        registration = null;
    }


    protected void addCluster(String key, Class clazz) {
    	if ( registration != null ){
    		throw new IllegalStateException(
				"The method addCluster should be invoked before registering the "
				+ this.getClass().getName() + " object"
			);
    	}
    	
        clusters.put(key,clazz);
    }

    public Cluster getInstance(String key, ZigBeeDevice zbDevice) {
        Class clazz = clusters.get(key);
        if (clazz != null) {
            try {
                Constructor<?> constructor = clazz.getConstructor(ZigBeeDevice.class);
                Cluster cluster =  (Cluster) constructor.newInstance(zbDevice);
                return cluster;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
