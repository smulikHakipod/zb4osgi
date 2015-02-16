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

package it.cnr.isti.zigbee.eh.driver.core;




import it.cnr.isti.zigbee.se.zcl.library.api.Metering;
import it.cnr.isti.zigbee.zcl.library.api.general.Basic;
import it.cnr.isti.zigbee.zcl.library.api.general.Groups;
import it.cnr.isti.zigbee.zcl.library.api.general.Identify;
import it.cnr.isti.zigbee.zcl.library.api.general.OnOff;
import it.cnr.isti.zigbee.zcl.library.api.general.Scenes;
import it.cnr.isti.zigbee.zcl.library.api.general.Time;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.TemperatureMeasurement;


/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:h.alink1@chello.nl">Han Alink</a>
 *
 * @version $LastChangedRevision: 807 $ ($LastChangedDate: 2013-09-18 18:25:49 +0200 (mer, 18 set 2013) $)
 * @since 0.4.0
 *
 */
public class  EHProfile {

	public static final int ID = 0xc23c;

	//CLUSTERS
	//Generic
	public static final int BASIC = Basic.ID;
	public static final int IDENTIFY = Identify.ID;
	public static final int GROUPS = Groups.ID;
	public static final int SCENES = Scenes.ID;
	public static final int ON_OFF = OnOff.ID;	
	public static final int PARTITION = 0x0016; //TODO Add Partition class and replace 0x0016 with Partition.ID const
	public static final int TIME = Time.ID;
	
	//Measureament & Sensing					
	public static final int TEMPERATURE_MEASUREMENT = TemperatureMeasurement.ID;
	
	//Smart Energy	
	public static final int METERING = Metering.ID;    
	
		
	//Energy@Home
	public static final int PRICE = 0x0700;
	public static final int DEMAND_RESPONSE_AND_LOAD_CONTROL = 0x0701;
	public static final int MESSAGE = 0x0703;
	public static final int METER_IDENTIFICATION = 0x0b01;
	public static final int POWER_PROFILE = 0x001a;
	public static final int APPLIANCE_STATISTICS = 0x0b03;
	public static final int APPLIANCE_EVENTS_AND_ALERT = 0x0b02;
	public static final int APPLIANCE_IDENTIFICATION = 0x0b00;
	public static final int APPLIANCE_CONTROL = 0x001b;

	// devices
	// GENERIC 0x0000 - 0x00FF


	


	


}