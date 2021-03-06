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
package it.cnr.isti.zigbee.zcl.library.impl;
import it.cnr.isti.zigbee.api.Cluster;
/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2010-09-23 14:21:48 +0200(Thu, 23 Sep 2010) $)
 * @since 0.8.0
 *
 */
public class RawClusterImpl implements Cluster {

    private byte[] frame;
    private short id;

    public RawClusterImpl(short id, byte[] frame) {
        this.frame = frame;
        this.id = id;
    }

    public byte[] getClusterMsg() {
        return frame;
    }

    public short getId() {
        return id;
    }

}
