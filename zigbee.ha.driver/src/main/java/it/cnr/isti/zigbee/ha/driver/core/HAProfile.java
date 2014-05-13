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

package it.cnr.isti.zigbee.ha.driver.core;


import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceControl;
import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceEventsAndAlert;
import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceIdentification;
import it.cnr.isti.zigbee.eh.zcl.library.api.ApplianceStatistics;
import it.cnr.isti.zigbee.eh.zcl.library.api.MeterIdentification;
import it.cnr.isti.zigbee.eh.zcl.library.api.PowerProfile;
import it.cnr.isti.zigbee.ha.device.api.generic.LevelControlSwitch;
import it.cnr.isti.zigbee.ha.device.api.generic.MainsPowerOutlet;
import it.cnr.isti.zigbee.ha.device.api.generic.OnOffOutput;
import it.cnr.isti.zigbee.ha.device.api.generic.OnOffSwitch;
import it.cnr.isti.zigbee.ha.device.api.generic.SimpleSensor;
import it.cnr.isti.zigbee.ha.device.api.hvac.Pump;
import it.cnr.isti.zigbee.ha.device.api.hvac.TemperatureSensor;
import it.cnr.isti.zigbee.ha.device.api.lighting.DimmableLight;
import it.cnr.isti.zigbee.ha.device.api.lighting.LightSensor;
import it.cnr.isti.zigbee.ha.device.api.lighting.OccupancySensor;
import it.cnr.isti.zigbee.ha.device.api.lighting.OnOffLight;
import it.cnr.isti.zigbee.ha.device.api.lighting.OnOffLightSwitch;
import it.cnr.isti.zigbee.ha.device.api.security_safety.IASControlAndIndicatingEquipment;
import it.cnr.isti.zigbee.ha.device.api.security_safety.IAS_Warning;
import it.cnr.isti.zigbee.ha.device.api.security_safety.IAS_Zone;
import it.cnr.isti.zigbee.se.zcl.library.api.DemandResponseAndLoadControlServer;
import it.cnr.isti.zigbee.se.zcl.library.api.Messaging;
import it.cnr.isti.zigbee.se.zcl.library.api.Metering;
import it.cnr.isti.zigbee.se.zcl.library.api.Price;
import it.cnr.isti.zigbee.zcl.library.api.HVAC.FanControl;
import it.cnr.isti.zigbee.zcl.library.api.HVAC.PumpConfigurationAndControl;
import it.cnr.isti.zigbee.zcl.library.api.HVAC.Thermostat;
import it.cnr.isti.zigbee.zcl.library.api.HVAC.ThermostatUserInterfaceConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.closures.DoorLock;
import it.cnr.isti.zigbee.zcl.library.api.closures.ShadeConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.closures.WindowCovering;
import it.cnr.isti.zigbee.zcl.library.api.general.Alarms;
import it.cnr.isti.zigbee.zcl.library.api.general.AnalogInput;
import it.cnr.isti.zigbee.zcl.library.api.general.Basic;
import it.cnr.isti.zigbee.zcl.library.api.general.BinaryInput;
import it.cnr.isti.zigbee.zcl.library.api.general.Commissioning;
import it.cnr.isti.zigbee.zcl.library.api.general.DeviceTemperatureConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.general.Groups;
import it.cnr.isti.zigbee.zcl.library.api.general.Identify;
import it.cnr.isti.zigbee.zcl.library.api.general.LevelControl;
import it.cnr.isti.zigbee.zcl.library.api.general.OnOff;
import it.cnr.isti.zigbee.zcl.library.api.general.OnOffSwitchConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.general.Partition;
import it.cnr.isti.zigbee.zcl.library.api.general.PowerConfiguration;
import it.cnr.isti.zigbee.zcl.library.api.general.Scenes;
import it.cnr.isti.zigbee.zcl.library.api.general.Time;
import it.cnr.isti.zigbee.zcl.library.api.lighting.ColorControl;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.FlowMeasurement;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.IlluminanceLevelSensing;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.IlluminanceMeasurement;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.OccupancySensing;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.PressureMeasurement;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.RelativeHumidityMeasurement;
import it.cnr.isti.zigbee.zcl.library.api.measureament_sensing.TemperatureMeasurement;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASACE;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASWD;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASZone;



/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:h.alink1@chello.nl">Han Alink</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class  HAProfile {

	public static final int ID = 260;

	//CLUSTERS
	//Generic
	public static final int BASIC = Basic.ID;
	public static final int POWER_CONFIGURATION = PowerConfiguration.ID;
	public static final int DEVICE_TEMPERATURE_CONFIGURATION = DeviceTemperatureConfiguration.ID;
	public static final int IDENTIFY = Identify.ID;
	public static final int GROUPS = Groups.ID;
	public static final int SCENES = Scenes.ID;
	public static final int ON_OFF = OnOff.ID;		
	public static final int ON_OFF_SWITCH_CONFIGURATION = OnOffSwitchConfiguration.ID;
	public static final int LEVEL_CONTROL = LevelControl.ID;
	public static final int ALARMS = Alarms.ID;
	public static final int BINARY_INPUT = BinaryInput.ID;
	//fuori specifica
	public static final int TIME = Time.ID;
	public static final int ANALOG_INPUT = AnalogInput.ID;
	public static final int COMMISSIONING = Commissioning.ID;
	public static final int PARTITION = Partition.ID;
	public static final int PRICE = Price.ID;
	public static final int DEMAND_RESPONSE_AND_LOAD_CONTROL = DemandResponseAndLoadControlServer.ID;
	public static final int MESSAGING = Messaging.ID;
	public static final int METERING = Metering.ID; 
	public static final int APPLIANCE_CONTROL = ApplianceControl.ID; 
	public static final int APPLIANCE_EVENTS_AND_ALERT = ApplianceEventsAndAlert.ID; 
	public static final int APPLIANCE_IDENTIFICATION = ApplianceIdentification.ID; 
	public static final int APPLIANCE_STATISTICS = ApplianceStatistics.ID; 
	public static final int METER_IDENTIFICATION = MeterIdentification.ID; 
	public static final int POWER_PROFILE = PowerProfile.ID; 
	
	
	
	
	//Closures
	public static final int SHADE_CONFIGURATION = ShadeConfiguration.ID;    										
	public static final int DOOR_LOCK 		= DoorLock.ID;    								
	public static final int WINDOW_COVERING 	= WindowCovering.ID;
	//HVAC
	public static final int PUMP_CONFIGURATION_AND_CONTROL 		= PumpConfigurationAndControl.ID;    						
	public static final int THERMOSTAT			= Thermostat.ID;    										
	public static final int FAN_CONTROL			= FanControl.ID; 
	public static final int THERMOSTAT_USER_INTERFACE_CONFIGURATION		= ThermostatUserInterfaceConfiguration.ID;    				
	// Lighting
	public static final int COLOR_CONTROL = ColorControl.ID;						
	//Measureament & Sensing
	public static final int PRESSURE_MEASUREMENT =   PressureMeasurement.ID; 	
	public static final int ILLUMINANCE_MEASUREMENT = IlluminanceMeasurement.ID; 		
	public static final int ILLUMINANCE_LEVEL_SENSING= IlluminanceLevelSensing.ID; 						
	public static final int TEMPERATURE_MEASUREMENT = TemperatureMeasurement.ID;
	public static final int FLOW_MEASUREMENT	= FlowMeasurement.ID;								
	public static final int RELATIVE_HUMIDITY_MEASUREMENT = RelativeHumidityMeasurement.ID;
	public static final int OCCUPANCY_SENSING = OccupancySensing.ID;
	// Security & Safety
	public static final int IAS_ZONE = IASZone.ID;										
	public static final int IAS_ACE = IASACE.ID;										
	public static final int IAS_WD = IASWD.ID;											

	// devices
	// GENERIC 0x0000 - 0x00FF
	public static final int ONOFF_SWITCH = OnOffSwitch.DEVICE_ID;
	public static final int LEVELCONTROL = LevelControlSwitch.DEVICE_ID;
	public static final int ONOFF_OUTPUT = OnOffOutput.DEVICE_ID;
	public static final int MAINS_POWER_OUTLET = MainsPowerOutlet.DEVICE_ID;
	public static final int SIMPLE_SENSOR = SimpleSensor.DEVICE_ID;
	// LIGHTNING 0x0100 - 0x1FF
	public static final int ONOFF_LIGHT = OnOffLight.DEVICE_ID;
	public static final int DIMMABLE_LIGHT = DimmableLight.DEVICE_ID;
	public static final int ONOFF_LIGHT_SWITCH = OnOffLightSwitch.DEVICE_ID;
	public static final int LIGHT_SENSOR = LightSensor.DEVICE_ID;
	public static final int OCCUPANCY_SENSOR = OccupancySensor.DEVICE_ID;
	// HVAC - 0x0300 - 0x3FF
	public static final int TEMPERATURE_SENSOR = TemperatureSensor.DEVICE_ID;
	public static final int PUMP = Pump.DEVICE_ID;
	// Intruder Alarm Systems 0x0400 - 0xFFFF
	public static final int IAS_CONTROL_INDICATING_EQUIPMENT = IASControlAndIndicatingEquipment.DEVICE_ID;
	public static final int IASZONE = IAS_Zone.DEVICE_ID;
	public static final int IAS_WARNING_DEVICE = IAS_Warning.DEVICE_ID;


	
	

	public String getDeviceName(String deviceID){

		try{
			
			/*
			 int id = Integer.parseInt(deviceID);
	        switch (id) {
	        case HAProfile.ONOFF_SWITCH: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.LEVELCONTROL: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.ONOFF_OUTPUT: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.MAINS_POWER_OUTLET: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.SIMPLE_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.ONOFF_LIGHT: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.DIMMABLE_LIGHT: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.ONOFF_LIGHT_SWITCH: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.LIGHT_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.OCCUPANCY_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.TEMPERATURE_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.IAS_CONTROL_INDICATING_EQUIPMENT: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.temperature_sensor: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.TEMPERATURE_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	        case HAProfile.TEMPERATURE_SENSOR: 
            	return OnOffSwitch.NAME;
                break;
	           
	            default: 
	                     break;
	        }
			
			
			
			
			
		*/	
			
			
			String id = Integer.toHexString((Integer.parseInt(deviceID)));

			if(id.equals(Integer.toHexString(HAProfile.ONOFF_SWITCH)))
				return OnOffSwitch.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.LEVELCONTROL)))
				return LevelControlSwitch.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ONOFF_OUTPUT)))
				return OnOffOutput.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.MAINS_POWER_OUTLET)))
				return MainsPowerOutlet.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.SIMPLE_SENSOR)))
				return SimpleSensor.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ONOFF_LIGHT)))
				return OnOffLight.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.DIMMABLE_LIGHT)))
				return DimmableLight.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ONOFF_LIGHT_SWITCH)))
				return OnOffLightSwitch.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.LIGHT_SENSOR)))
				return LightSensor.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.OCCUPANCY_SENSOR)))
				return OccupancySensor.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.TEMPERATURE_SENSOR)))
				return TemperatureSensor.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.IAS_CONTROL_INDICATING_EQUIPMENT)))
				return IASControlAndIndicatingEquipment.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.PRESSURE_MEASUREMENT)))
				return PressureMeasurement.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.FLOW_MEASUREMENT)))
				return FlowMeasurement.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ILLUMINANCE_LEVEL_SENSING)))
				return IlluminanceLevelSensing.NAME;
			


			else return null;
		}
		catch(Exception ex){
			return null;
		}
	}

	public String getClusterName(String clusterID){

		try{
			String id = Integer.toHexString((Integer.parseInt(clusterID)));

			if(id.equals(Integer.toHexString(HAProfile.BASIC)))
				return Basic.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.POWER_CONFIGURATION)))
				return PowerConfiguration.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.DEVICE_TEMPERATURE_CONFIGURATION)))
				return DeviceTemperatureConfiguration.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.IDENTIFY)))
				return Identify.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.GROUPS)))
				return Groups.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.SCENES)))
				return Scenes.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ON_OFF)))
				return OnOff.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ON_OFF_SWITCH_CONFIGURATION)))
				return OnOffSwitchConfiguration.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.LEVEL_CONTROL)))
				return LevelControl.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ALARMS)))
				return Alarms.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.TIME)))
				return Time.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.BINARY_INPUT)))
				return BinaryInput.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.COMMISSIONING)))
				return Commissioning.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.COLOR_CONTROL)))
				return ColorControl.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ILLUMINANCE_MEASUREMENT)))
				return IlluminanceMeasurement.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.TEMPERATURE_MEASUREMENT)))
				return TemperatureMeasurement.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.RELATIVE_HUMIDITY_MEASUREMENT)))
				return RelativeHumidityMeasurement.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.OCCUPANCY_SENSING)))
				return OccupancySensing.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.IAS_ZONE)))
				return IASZone.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.IAS_ACE)))
				return IASACE.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.IAS_WD)))
				return IASWD.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.ANALOG_INPUT)))
				return AnalogInput.NAME;
			else if(id.equals(Integer.toHexString(HAProfile.METERING)))
				return Metering.NAME;

			else return null;
		}
		catch(Exception ex){
			return null;
		}
	}

	public String getCategoryDeviceName(String deviceID){

		try{
			String id = Integer.toHexString((Integer.parseInt(deviceID)));
			if(id.startsWith("0"))
				return "Generic";
			else if(id.startsWith("1"))
				return "Lighting";
			else if(id.startsWith("2"))
				return "Closures";
			else if(id.startsWith("3"))
				return "HVAC";
			else if(id.startsWith("4"))
				return "IAS";
			else
				return null;
		}
		catch(Exception ex){
			return null;
		}
	}
}