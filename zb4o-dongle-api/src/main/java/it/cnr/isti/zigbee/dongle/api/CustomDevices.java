/*
   Copyright 2012-2013 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.zigbee.dongle.api;


/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR</a>
 * @author <a href="mailto:manlio.bacco@isti.cnr.it">Manlio Bacco - ISTI-CNR</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.7.0
 *
 */
 public interface CustomDevices {

    public final static String ENDPOINT = "-1";
    public final static String ENDPOINT_KEY = "it.cnr.isti.zigbee.custom.device.endpoint";

    public final static String PROFILE_ID = "-1";
    public final static String PROFILE_ID_KEY = "it.cnr.isti.zigbee.custom.device.profileID";

    public final static String DEVICE_ID = "-1";
    public final static String DEVICE_ID_KEY = "it.cnr.isti.zigbee.custom.device.deviceID";

    public final static String VERSION = "-1";
    public final static String VERSION_KEY = "it.cnr.isti.zigbee.custom.device.version";

    public final static String INPUT_CLUSTERS = "";
    public final static String INPUT_CLUSTERS_KEY = "it.cnr.isti.zigbee.custom.device.inputClusters";

    public final static String OUTPUT_CLUSTERS = "";
    public final static String OUTPUT_CLUSTERS_KEY = "it.cnr.isti.zigbee.custom.device.outputClusters";
}
