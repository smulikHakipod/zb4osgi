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
package it.cnr.isti.zigbee.zcl.library.api.general;

import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;

/**
 * This class represent the <b>Binary Input (Basic)</b> Cluster as defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075123r04ZB
 *
 * @author <a href="mailto:h.alink1@chello.nl">Han Alink</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.8.0
 *
 */
public interface BinaryInput extends ZCLCluster {

    static final short ID = 0x000F;
    static final String NAME = "Binary Input (Basic)";
    static final String DESCRIPTION =
            "An interface for reading the value of a binary measurement and accessing "
             + "various characteristics of that measurement.";


    public Attribute getAttributeActiveText();
    public Attribute getAttributeDescription();
    public Attribute getAttributeInactiveText();
    public Attribute getAttributeOutOfService();
    public Attribute getAttributePolarity();
    public Attribute getAttributePresentValue();
    public Attribute getAttributeReliability();
    public Attribute getAttributeStatusFlags();
    public Attribute getAttributeApplicationType();

}
