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

package it.cnr.isti.zigbee.eh.cluster.factory;

import it.cnr.isti.zigbee.eh.cluster.impl.ApplianceControlImpl;
import it.cnr.isti.zigbee.eh.cluster.impl.ApplianceEventsAndAlertImpl;
import it.cnr.isti.zigbee.eh.cluster.impl.ApplianceIdentificationImpl;
import it.cnr.isti.zigbee.eh.cluster.impl.ApplianceStatisticsImpl;
import it.cnr.isti.zigbee.eh.cluster.impl.MeterIdentificationImpl;
import it.cnr.isti.zigbee.eh.cluster.impl.PowerProfileImpl;
import it.cnr.isti.zigbee.eh.driver.core.EHProfile;
import it.cnr.isti.zigbee.ha.cluster.impl.BasicImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.GroupsImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.IdentifyImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.OnOffImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.PartitionImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.ScenesImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.TemperatureMeasurementImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.TimeImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.DemandResponseAndLoadControlImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.MessagingImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.MeteringImpl;
import it.cnr.isti.zigbee.ha.cluster.impl.other_profiles.smart_energy.PriceImpl;
import it.cnr.isti.zigbee.ha.driver.core.ClusterFactoryBase;

import org.osgi.framework.BundleContext;

/**
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">§Giancarlo Riolo</a>
 * 
 * @version $LastChangedRevision: 894 $ ($LastChangedDate: 2013-11-12 17:32:41
 *          +0100 (mar, 12 nov 2013) $)
 * @since 0.1.0
 * 
 */
public class EHClustersFactory extends ClusterFactoryBase {

	// General
	final static String BASIC_KEY = EHProfile.ID + ":" + EHProfile.BASIC;
	final static String IDENTIFY_KEY = EHProfile.ID + ":" + EHProfile.IDENTIFY;
	final static String GROUPS_KEY = EHProfile.ID + ":" + EHProfile.GROUPS;
	final static String SCENES_KEY = EHProfile.ID + ":" + EHProfile.SCENES;
	final static String ONOFF_KEY = EHProfile.ID + ":" + EHProfile.ON_OFF;
	final static String TIME_KEY = EHProfile.ID + ":" + EHProfile.TIME;
	static final String PARTITION_KEY = EHProfile.ID + ":"
			+ EHProfile.PARTITION;

	// Measurement and Sensing

	final static String TEMPERATURE_MEASUREMENT_KEY = EHProfile.ID + ":"
			+ EHProfile.TEMPERATURE_MEASUREMENT;

	// Smart Energy
	final static String PRICE_KEY = EHProfile.ID + ":" + EHProfile.PRICE;
	final static String DEMAND_RESPONSE_AND_LOAD_CONTROL_KEY = EHProfile.ID
			+ ":" + EHProfile.DEMAND_RESPONSE_AND_LOAD_CONTROL;
	final static String METERING_KEY = EHProfile.ID + ":" + EHProfile.METERING;
	final static String MESSAGE_KEY = EHProfile.ID + ":" + EHProfile.MESSAGE;

	// EN50523 Clusters
	final static String APPLIANCE_IDENTIFICATION_KEY = EHProfile.ID + ":"
			+ EHProfile.APPLIANCE_IDENTIFICATION;
	final static String APPLIANCE_CONTROL_KEY = EHProfile.ID + ":"
			+ EHProfile.APPLIANCE_CONTROL;
	final static String APPLIANCE_EVENTS_AND_ALERT_KEY = EHProfile.ID + ":"
			+ EHProfile.APPLIANCE_EVENTS_AND_ALERT;
	final static String APPLIANCE_STATISTICS_KEY = EHProfile.ID + ":"
			+ EHProfile.APPLIANCE_STATISTICS;
	final static String POWER_PROFILE_KEY = EHProfile.ID + ":"
			+ EHProfile.POWER_PROFILE;
	final static String METER_IDENTIFICATION_KEY = EHProfile.ID + ":"
			+ EHProfile.METER_IDENTIFICATION;

	public EHClustersFactory(BundleContext ctx) {
		super(ctx);

		// General
		addCluster(BASIC_KEY, BasicImpl.class);
		addCluster(IDENTIFY_KEY, IdentifyImpl.class);
		addCluster(GROUPS_KEY, GroupsImpl.class);
		addCluster(SCENES_KEY, ScenesImpl.class);
		addCluster(ONOFF_KEY, OnOffImpl.class);
		addCluster(TIME_KEY, TimeImpl.class);
		addCluster(PARTITION_KEY, PartitionImpl.class);
		// measurement
		addCluster(TEMPERATURE_MEASUREMENT_KEY,
				TemperatureMeasurementImpl.class);
		// smart energy
		addCluster(DEMAND_RESPONSE_AND_LOAD_CONTROL_KEY,
				DemandResponseAndLoadControlImpl.class);
		addCluster(METERING_KEY, MeteringImpl.class);
		addCluster(MESSAGE_KEY, MessagingImpl.class);
		addCluster(PRICE_KEY, PriceImpl.class);

		// e@h
		addCluster(APPLIANCE_IDENTIFICATION_KEY,
				ApplianceIdentificationImpl.class);
		addCluster(APPLIANCE_CONTROL_KEY, ApplianceControlImpl.class);
		addCluster(APPLIANCE_EVENTS_AND_ALERT_KEY,
				ApplianceEventsAndAlertImpl.class);
		addCluster(APPLIANCE_STATISTICS_KEY, ApplianceStatisticsImpl.class);
		addCluster(POWER_PROFILE_KEY, PowerProfileImpl.class);
		addCluster(METER_IDENTIFICATION_KEY, MeterIdentificationImpl.class);

	}

}
