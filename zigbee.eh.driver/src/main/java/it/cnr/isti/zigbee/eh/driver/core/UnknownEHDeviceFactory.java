/*
   Copyright 2013-2013 CNR-ISTI, http://isti.cnr.it
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
import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.driver.ArraysUtil;
import it.cnr.isti.zigbee.ha.driver.core.ClusterFactory;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;

import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 869 $ ($LastChangedDate: 2013-10-11 16:02:59 +0200 (ven, 11 ott 2013) $)
 * @since 0.7.0
 *
 */
public class UnknownEHDeviceFactory extends EHDeviceFactoryBase   {

    private String[] implementedInterfaces = {
                    EHDevice.class.getName()
    };

    public  UnknownEHDeviceFactory(BundleContext ctx) throws ZigBeeHAException {
        super(ctx, UnknownEHDevice.class);
    }

    public int[] getDeviceClusters() {
        String filter = "(" + Cluster.PROFILE_CLUSTER_IDS + "=*)";
        final int CLUSTER_INDEX = ( EHProfile.ID + ":" ).length();
        int[] ids = new int[]{};
        ServiceReference[] srClusterFactory;
        try {
            srClusterFactory = ctx.getServiceReferences(ClusterFactory.class.getName(), filter);
            if ( srClusterFactory == null ) return ids;
            for (int j = 0; j < srClusterFactory.length; j++) {
                final String[] stringIDs = (String[]) srClusterFactory[j].getProperty(Cluster.PROFILE_CLUSTER_IDS);
                final int[] clusterIDs = new int[stringIDs.length];
                for ( int i = 0; i < clusterIDs.length; i++ ) {
                    if ( stringIDs[i].startsWith( EHProfile.ID + ":"  ) == false ) continue;
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
        int score = Integer.parseInt( (String) ref.getProperty(ZigBeeDevice.PROFILE_ID) ) == EHProfile.ID
                ? ZigBeeDevice.MATCH_PROFILE_ID : 0;

        for (int i = 0; i < inputClusterIDs.length; i++) {
            String key = EHProfile.ID + ":"+String.valueOf( inputClusterIDs[i] );
            String filter = "(" + Cluster.PROFILE_CLUSTER_IDS + "=" + key+ ")";
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
        return UnknownEHDevice.DEVICE_ID;
    }

    @Override
    public String[] getRefinedInterfaces() {
        return implementedInterfaces;
    }

    @Override
    public EHDeviceBase getInstance(ZigBeeDevice zbDevice) throws ZigBeeHAException {
        return new UnknownEHDevice(ctx, zbDevice);
    }


}
