/*
   Copyright 2013-2014 CNR-ISTI, http://isti.cnr.it
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
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public enum DuplicateMacPolicy {

    /**
     * The ZigBee Base Driver will ignore the duplicated device and it will not update the network address of it
     */
    IGNORE,

    /**
     * The ZigBee Base Driver will detect the duplication and update the related ZigBeeDevice service
     */
    UPDATE,

    /**
     * The ZigBee Base Driver will deregister the old ZigBeeDevice service and register new one with the correct data
     */
    REGISTER
}
