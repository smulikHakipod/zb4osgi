package it.cnr.isti.zigbee.hc.core;
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



import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.driver.ArraysUtil;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 *
 */
public class UnknowHADeviceFactory extends HCDeviceFactoryBase   {

    private String[] implementedInterfaces = {
                    HCDevice.class.getName()
    };

    public  UnknowHADeviceFactory(BundleContext ctx) throws ZigBeeHAException {
        super(ctx, UnknowHADevice.class);
    }

    public int[] getDeviceClusters() {
        String filter = "(" + Cluster.PROFILE_CLUSTER_IDs + "=*)";
        final int CLUSTER_INDEX = ( HAProfile.ID + ":" ).length();
        int[] ids = new int[]{};
        ServiceReference[] srClusterFactory;
        try {
            srClusterFactory = ctx.getServiceReferences(ClusterFactory.class.getName(), filter);
            if ( srClusterFactory == null ) return ids;
            for (int j = 0; j < srClusterFactory.length; j++) {
                final String[] stringIDs = (String[]) srClusterFactory[j].getProperty(Cluster.PROFILE_CLUSTER_IDs);
                final int[] clusterIDs = new int[stringIDs.length];
                for ( int i = 0; i < clusterIDs.length; i++ ) {
                    if ( stringIDs[i].startsWith( HAProfile.ID + ":"  ) == false ) continue;
                    clusterIDs[i] = Integer.parseInt( stringIDs[i].substring( CLUSTER_INDEX ) );
                }
                ids = ArraysUtil.append(ids, clusterIDs );
            }
        } catch (InvalidSyntaxException e) {
        }
        return ids;

    }

    public int hasMatch(ServiceReference ref) {
        int[] inputClusterIDs = (int[]) ref.getProperty(ZigBeeDevice.CLUSTERS_INPUT_ID);
        int score = Integer.parseInt( (String) ref.getProperty(ZigBeeDevice.PROFILE_ID) ) == HAProfile.ID
                ? ZigBeeDevice.MATCH_PROFILE_ID : 0;

        for (int i = 0; i < inputClusterIDs.length; i++) {
            String key = HAProfile.ID + ":"+String.valueOf( inputClusterIDs[i] );
            String filter = "(" + Cluster.PROFILE_CLUSTER_IDs + "=" + key+ ")";
            ServiceReference[] srClusterFactory;
            try {
                srClusterFactory = ctx.getServiceReferences(ClusterFactory.class.getName(), filter);
                score += srClusterFactory != null ? ZigBeeDevice.MATCH_CLUSTER_ID : 0;
            } catch (InvalidSyntaxException e) {
            }
        }

        score += ( (String) ref.getProperty(ZigBeeDevice.DEVICE_ID) ).equals( getDeviceId() )
                ? ZigBeeDevice.MATCH_DEVICE_ID : 0;

        return score;
    }

    @Override
    public String getDeviceId() {
        return "-1";
    }

    @Override
    public String[] getRefinedInterfaces() {
        return implementedInterfaces;
    }

    @Override
    public HCDeviceBase getInstance(ZigBeeDevice zbDevice) throws ZigBeeHCException {
        return new UnknowHADevice(ctx, zbDevice);
    }


}
