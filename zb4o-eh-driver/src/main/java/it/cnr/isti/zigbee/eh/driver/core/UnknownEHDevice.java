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
import it.cnr.isti.zigbee.eh.Activator;
import it.cnr.isti.zigbee.eh.driver.EHDriverConfiguration.ProvidedClusterMode;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.ha.driver.core.reflection.AbstractDeviceDescription;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;

import org.osgi.framework.BundleContext;

/**
 *
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 869 $ ($LastChangedDate: 2013-10-11 16:02:59 +0200 (ven, 11 ott 2013) $)
 * @since 0.7.0
 *
 */
public class UnknownEHDevice extends EHDeviceBase  {

    public  UnknownEHDevice(BundleContext ctx,ZigBeeDevice zbDevice) throws ZigBeeHAException {
        super(ctx,zbDevice);
        int[] inputClusters = zbDevice.getInputClusters();
        for (int i = 0; i < inputClusters.length; i++) {
            addCluster( inputClusters[i] );
        }

        if ( Activator.getConfiguration().getClusterMode() == ProvidedClusterMode.EitherInputAndOutput ) {
            int[] outputClusters = zbDevice.getOutputClusters();
            for (int i = 0; i < inputClusters.length; i++) {
                addCluster( outputClusters[i] );
            }
        }
    }

    @Override
    public String getName() {
        return "Unknown Energy@Home Device";
    }

    final static DeviceDescription DEVICE_DESCRIPTOR =  new AbstractDeviceDescription(){

        public int[] getCustomClusters() {
            return new int[]{};
        }

        public int[] getMandatoryCluster() {
            return EHDevice.MANDATORY;
        }

        public int[] getOptionalCluster() {
            return EHDevice.OPTIONAL;
        }

        public int[] getStandardClusters() {
            return EHDevice.STANDARD;
        }

    };
	public static final String DEVICE_ID = "-1";

    @Override
    public DeviceDescription getDescription() {
        return DEVICE_DESCRIPTOR;
    }

	public Object getPartition() {
		// TODO Auto-generated method stub
		return null;
	}


}
