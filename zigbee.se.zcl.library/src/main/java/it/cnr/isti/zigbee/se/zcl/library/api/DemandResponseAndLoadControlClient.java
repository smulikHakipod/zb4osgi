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

package it.cnr.isti.zigbee.se.zcl.library.api;

import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.api.core.ZCLCluster;

/**
 * This class represent the <b>DemandeResponseAndLoadControl</b> Cluster as
 * defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public interface DemandResponseAndLoadControlClient extends ZCLCluster {

	public static final short ID = 0x0701;
	static final String NAME = "DemandResponseAndLoadControlClient";
	static final String DESCRIPTION = "To be filled";
		
	//Client
	static final byte REPORT_EVENT_STATUS_ID = 0x00;
	static final byte GET_SCHEDULED_EVENTS_ID = 0x01;
	public Attribute getAttributeUtilityEnrolmentGroup();
	public Attribute getAttributeStartRandomizeMinutes();
	public Attribute getAttributeStopRandomizeMinutes();
	public Attribute getAttributeDeviceClassValue();	

}
