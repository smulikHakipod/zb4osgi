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

package it.cnr.isti.zigbee.ha.cluster.factory;

import it.cnr.isti.zigbee.ha.cluster.impl.AlarmsImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.AnalogInputImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.BasicImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.BinaryInputImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ColorControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.CommissioningImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.DebugImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.DeviceTemperatureConfigurationImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.DoorLockImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.FanControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.FlowMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.GroupsImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IASACEImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IASWDImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IASZoneImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IdentifyImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IlluminanceLevelSensingImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IlluminanceMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.LevelControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.OccupancySensingImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.OnOffImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.OnOffSwitchConfigurationImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.PartitionImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.PowerConfigurationImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.PressureMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ProprietaryImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.PumpConfigurationAndControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.RelativeHumidityMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ScenesImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ShadeConfigurationImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.TemperatureMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ThermostatImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ThermostatUserInterfaceConfigurationImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.TimeImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.WindowCoveringImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.DemandResponseAndLoadControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.MessagingImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.MeteringImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.PriceImpl;
import it.cnr.isti.zigbee.ha.driver.core.ClusterFactoryBase;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;

import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 *  @author <a href="mailto:giancarlo.riolo@isti.cnr.it">§Giancarlo Riolo</a>
 *
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class HAClustersFactory extends ClusterFactoryBase {

    //General
    final static String BASIC_KEY = HAProfile.ID + ":" + HAProfile.BASIC;
    final static String POWER_CONFIGURATION_KEY = HAProfile.ID + ":"+ HAProfile.POWER_CONFIGURATION;
    final static String DEVICE_TEMPERATURE_CONFIGURATION_KEY = HAProfile.ID + ":"+ HAProfile.DEVICE_TEMPERATURE_CONFIGURATION;
    final static String IDENTIFY_KEY = HAProfile.ID + ":"+ HAProfile.IDENTIFY;
    final static String GROUPS_KEY = HAProfile.ID + ":"+ HAProfile.GROUPS;
    final static String SCENES_KEY = HAProfile.ID + ":"+ HAProfile.SCENES;
    final static String ONOFF_KEY = HAProfile.ID + ":"+ HAProfile.ON_OFF;
    final static String ON_OFF_SWITCH_CONFIGURATION_KEY = HAProfile.ID + ":"+ HAProfile.ON_OFF_SWITCH_CONFIGURATION;
    final static String LEVEL_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.LEVEL_CONTROL;
    final static String ALARMS_KEY = HAProfile.ID + ":"+ HAProfile.ALARMS;   
    final static String BINARY_INPUT_KEY = HAProfile.ID + ":"+ HAProfile.BINARY_INPUT;  
    
  
     
    //Measurement and Sensing
    final static String ILLUMINANCE_LEVEL_SENSING_KEY = HAProfile.ID + ":"+ HAProfile.ILLUMINANCE_LEVEL_SENSING; // new
    final static String ILLUMINANCE_MEASUREMENT_KEY = HAProfile.ID + ":"+ HAProfile.ILLUMINANCE_MEASUREMENT; // new
    final static String TEMPERATURE_MEASUREMENT_KEY = HAProfile.ID + ":"+ HAProfile.TEMPERATURE_MEASUREMENT;
    final static String PRESSURE_MEASUREMENT_KEY = HAProfile.ID + ":"+ HAProfile.PRESSURE_MEASUREMENT;
    final static String FLOW_MEASUREMENT_KEY = HAProfile.ID + ":"+ HAProfile.FLOW_MEASUREMENT;
    final static String RELATIVE_HUMIDITY_MEASUREMENT_KEY = HAProfile.ID + ":"+ HAProfile.RELATIVE_HUMIDITY_MEASUREMENT;
    final static String OCCUPANCY_SENSING_KEY = HAProfile.ID + ":"+ HAProfile.OCCUPANCY_SENSING;
    //Security and Safety
    final static String IAS_ZONE_KEY = HAProfile.ID + ":"+ HAProfile.IAS_ZONE;
    final static String IAS_WD_KEY = HAProfile.ID + ":"+ HAProfile.IAS_WD;
    final static String IAS_ACE_KEY = HAProfile.ID + ":"+ HAProfile.IAS_ACE;
   
    
    //HVAC
	private static final String THERMOSTAT_USER_INTERFACE_CONFIGURATION_KEY = HAProfile.ID + ":"+ HAProfile.THERMOSTAT_USER_INTERFACE_CONFIGURATION;
	private static final String FAN_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.FAN_CONTROL;
	private static final String THERMOSTAT_KEY = HAProfile.ID + ":"+ HAProfile.THERMOSTAT;
	private static final String PUMP_CONFIGURATION_AND_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.PUMP_CONFIGURATION_AND_CONTROL;
	//Closures
	private static final String SHADE_CONFIGURATION_KEY = HAProfile.ID + ":"+ HAProfile.SHADE_CONFIGURATION;
	private static final String DOOR_LOCK_KEY = HAProfile.ID + ":"+ HAProfile.DOOR_LOCK;
	private static final String WINDOW_COVERING_KEY = HAProfile.ID + ":"+ HAProfile.WINDOW_COVERING;
	//Lightening
	private static final String COLOR_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.COLOR_CONTROL;
	
	 //fuori profilo HA
    final static String TIME_KEY = HAProfile.ID + ":"+ HAProfile.TIME;
    final static String COMMISSIONING_KEY = HAProfile.ID + ":"+ HAProfile.COMMISSIONING;
    final static String ANALOG_INPUT_KEY = HAProfile.ID + ":"+ HAProfile.ANALOG_INPUT;
    final static String PARTITION_KEY = HAProfile.ID + ":"+ HAProfile.PARTITION;
    final static String PRICE_KEY = HAProfile.ID + ":"+ HAProfile.PRICE;
    final static String DEMAND_RESPONSE_AND_LOAD_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.DEMAND_RESPONSE_AND_LOAD_CONTROL;
    final static String MESSAGING_KEY = HAProfile.ID + ":"+ HAProfile.MESSAGING;
    final static String METERING_KEY = HAProfile.ID + ":"+ HAProfile.METERING;
    
    final static String APPLIANCE_CONTROL_KEY = HAProfile.ID + ":"+ HAProfile.APPLIANCE_CONTROL;
    final static String APPLIANCE_EVENTS_AND_ALERT_KEY = HAProfile.ID + ":"+ HAProfile.APPLIANCE_EVENTS_AND_ALERT;
    final static String APPLIANCE_IDENTIFICATION_KEY = HAProfile.ID + ":"+ HAProfile.APPLIANCE_IDENTIFICATION;
    final static String APPLIANCE_STATISTICS_KEY = HAProfile.ID + ":"+ HAProfile.APPLIANCE_STATISTICS;
    final static String METER_IDENTIFICATION_KEY = HAProfile.ID + ":"+ HAProfile.METER_IDENTIFICATION;
    final static String POWER_PROFILE_KEY = HAProfile.ID + ":"+ HAProfile.POWER_PROFILE;
   
  //debug
    final static String DEBUG_KEY = HAProfile.ID + ":"+ HAProfile.DEBUG;
    
  //proprietary
    final static String PROPRIETARY_KEY = HAProfile.ID + ":"+ HAProfile.PROPRIETARY;
    
    public HAClustersFactory(BundleContext ctx){
        super(ctx);

        //General
        addCluster(BASIC_KEY, BasicImpl.class);
        addCluster(POWER_CONFIGURATION_KEY, PowerConfigurationImpl.class);
        addCluster(DEVICE_TEMPERATURE_CONFIGURATION_KEY, DeviceTemperatureConfigurationImpl.class);
        addCluster(IDENTIFY_KEY, IdentifyImpl.class);
        addCluster(GROUPS_KEY, GroupsImpl.class);
        addCluster(SCENES_KEY, ScenesImpl.class);
        addCluster(ONOFF_KEY, OnOffImpl.class);
        addCluster(ON_OFF_SWITCH_CONFIGURATION_KEY, OnOffSwitchConfigurationImpl.class);
        addCluster(LEVEL_CONTROL_KEY, LevelControlImpl.class);
        addCluster(ALARMS_KEY, AlarmsImpl.class);     
        addCluster(BINARY_INPUT_KEY, BinaryInputImpl.class);
   
        
        //fuori profilo HA
        addCluster(ANALOG_INPUT_KEY, AnalogInputImpl.class);
        addCluster(COMMISSIONING_KEY, CommissioningImpl.class); // new
        addCluster(TIME_KEY, TimeImpl.class);
        addCluster(PARTITION_KEY, PartitionImpl.class);
        addCluster(METERING_KEY, MeteringImpl.class);
        addCluster(PRICE_KEY, PriceImpl.class);
        addCluster(DEMAND_RESPONSE_AND_LOAD_CONTROL_KEY, DemandResponseAndLoadControlImpl.class);
        addCluster(MESSAGING_KEY, MessagingImpl.class);
       /* addCluster(APPLIANCE_CONTROL_KEY, ApplianceControlImpl.class);
        addCluster(APPLIANCE_EVENTS_AND_ALERT_KEY, ApplianceEventsAndAlertImpl.class);
        addCluster(APPLIANCE_IDENTIFICATION_KEY, ApplianceIdentificationImpl.class);
        addCluster(APPLIANCE_STATISTICS_KEY, ApplianceStatisticsImpl.class);
        addCluster(METER_IDENTIFICATION_KEY, MeterIdentificationImpl.class);
        addCluster(POWER_PROFILE_KEY, PowerProfileImpl.class);*/
        
        
       
        
   

        //Measurement and Sensing
        addCluster(ILLUMINANCE_MEASUREMENT_KEY, IlluminanceMeasurementImpl.class); // new
        addCluster(TEMPERATURE_MEASUREMENT_KEY, TemperatureMeasurementImpl.class);
        addCluster(RELATIVE_HUMIDITY_MEASUREMENT_KEY, RelativeHumidityMeasurementImpl.class);
        addCluster(OCCUPANCY_SENSING_KEY, OccupancySensingImpl.class);
        addCluster(PRESSURE_MEASUREMENT_KEY, PressureMeasurementImpl.class);
        addCluster(FLOW_MEASUREMENT_KEY, FlowMeasurementImpl.class);
        addCluster(ILLUMINANCE_LEVEL_SENSING_KEY, IlluminanceLevelSensingImpl.class);

        //Security and Safety
        addCluster(IAS_ZONE_KEY, IASZoneImpl.class);
        addCluster(IAS_WD_KEY, IASWDImpl.class);
        addCluster(IAS_ACE_KEY, IASACEImpl.class);
        
        //HVAC
        addCluster(PUMP_CONFIGURATION_AND_CONTROL_KEY, PumpConfigurationAndControlImpl.class);
        addCluster(THERMOSTAT_KEY, ThermostatImpl.class);
        addCluster(FAN_CONTROL_KEY, FanControlImpl.class);
        addCluster(THERMOSTAT_USER_INTERFACE_CONFIGURATION_KEY, ThermostatUserInterfaceConfigurationImpl.class);
        
        //Closures
        addCluster(SHADE_CONFIGURATION_KEY, ShadeConfigurationImpl.class);
        addCluster(DOOR_LOCK_KEY, DoorLockImpl.class);
        addCluster(WINDOW_COVERING_KEY, WindowCoveringImpl.class);
        
        
        //Lighting
        addCluster(COLOR_CONTROL_KEY, ColorControlImpl.class);
   
        //debug
        addCluster(DEBUG_KEY, DebugImpl.class);
        addCluster(PROPRIETARY_KEY, ProprietaryImpl.class);
        
      
    }

}
