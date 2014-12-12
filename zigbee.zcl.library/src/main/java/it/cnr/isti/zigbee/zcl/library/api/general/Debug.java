/*
   Copyright 2008-2014 CNR-ISTI, http://isti.cnr.it
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

public interface Debug extends ZCLCluster {

    public static final short  ID = 0x03E8;
    static final String NAME = "Debug";
    static final String DESCRIPTION = "Debug cluster";


    public Attribute getAttributeUint24();
    public Attribute getAttributeUint32();
    public Attribute getAttributeUint40();
    public Attribute getAttributeUint48();
    public Attribute getAttributeUint56();
    public Attribute getAttributeUint64();
    public Attribute getAttributeSint24();
    public Attribute getAttributeSint32();
    public Attribute getAttributeSint40();
    public Attribute getAttributeSint48();
    public Attribute getAttributeSint56();
    public Attribute getAttributeSint64();
  


}