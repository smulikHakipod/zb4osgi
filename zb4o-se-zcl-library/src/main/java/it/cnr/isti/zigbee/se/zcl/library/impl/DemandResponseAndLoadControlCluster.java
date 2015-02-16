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

package it.cnr.isti.zigbee.se.zcl.library.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.se.zcl.library.api.DemandResponseAndLoadControlServer;
import it.cnr.isti.zigbee.se.zcl.library.impl.attribute.AttributesDemandResponseAndLoadControl;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;
import it.cnr.isti.zigbee.zcl.library.impl.core.AttributeImpl;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLClusterBase;

/**
 * This class represent the <b>DemandResponseAndLoadControlServer</b> Cluster as
 * defined by the document:<br>
 * <i>ZigBee Cluster Library</i> public release version 075356r16ZB
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 */

public class DemandResponseAndLoadControlCluster extends ZCLClusterBase
		implements DemandResponseAndLoadControlServer {

	private static AttributeImpl utilityEnrolmentGroup;
	private static AttributeImpl startRandomizeMinutes;
	private static AttributeImpl stopRandomizeMinutes;
	private static AttributeImpl deviceClassValue;

	private final Attribute[] attributes;

	public DemandResponseAndLoadControlCluster(ZigBeeDevice zbDevice) {
		super(zbDevice);

		utilityEnrolmentGroup = new AttributeImpl(zbDevice, this,
				AttributesDemandResponseAndLoadControl.UTILITY_ENROLMENT_GROUP);
		startRandomizeMinutes = new AttributeImpl(zbDevice, this,
				AttributesDemandResponseAndLoadControl.START_RANDOMIZE_MINUTES);
		stopRandomizeMinutes = new AttributeImpl(zbDevice, this,
				AttributesDemandResponseAndLoadControl.STOP_RANDOMIZE_MINUTES);
		deviceClassValue = new AttributeImpl(zbDevice, this,
				AttributesDemandResponseAndLoadControl.DEVICE_CLASS_VALUE);

		attributes = new AttributeImpl[] { utilityEnrolmentGroup,
				startRandomizeMinutes, stopRandomizeMinutes, deviceClassValue };
	}

	@Override
	public short getId() {
		return DemandResponseAndLoadControlServer.ID;
	}

	@Override
	public String getName() {
		return DemandResponseAndLoadControlServer.NAME;
	}

	@Override
	public Attribute[] getStandardAttributes() {
		return attributes;
	}

	public Attribute getAttributeUtilityEnrolmentGroup() {

		return utilityEnrolmentGroup;
	}

	public Attribute getAttributeStartRandomizeMinutes() {

		return startRandomizeMinutes;
	}

	public Attribute getAttributeStopRandomizeMinutes() {

		return stopRandomizeMinutes;
	}

	public Attribute getAttributeDeviceClassValue() {

		return deviceClassValue;
	}

}
