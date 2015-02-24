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

public interface Proprietary extends ZCLCluster {

	public static final short ID = (short) (0xF1CA);
	static final String NAME = "Proprietary Template";
	static final String DESCRIPTION = "Proprietary Template cluster";

	public Attribute getAttributeEP1Enable();

	public Attribute getAttributeVoltageCostant();

	public Attribute getAttributeCurrentCostant();

	public Attribute getAttributeVoltageRMS();

	public Attribute getAttributeCurrentRMS();

	public Attribute getAttributeEP2Enable();

	public Attribute getAttributeEP3Enable();

	public Attribute getAttributeEP4EP5Enable();

	public Attribute getAttributeEP9Enable();

}