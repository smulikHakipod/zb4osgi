package it.cnr.isti.zigbee.ha.device.impl;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Groups;
import it.cnr.isti.zigbee.ha.cluster.glue.general.OnOff;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Scenes;
import it.cnr.isti.zigbee.ha.device.api.generic.MainsPowerOutlet;
import it.cnr.isti.zigbee.ha.driver.core.HADeviceBase;
import it.cnr.isti.zigbee.ha.driver.core.HAProfile;
import it.cnr.isti.zigbee.ha.driver.core.ZigBeeHAException;
import it.cnr.isti.zigbee.ha.driver.core.reflection.AbstractDeviceDescription;
import it.cnr.isti.zigbee.ha.driver.core.reflection.DeviceDescription;

import org.osgi.framework.BundleContext;

public class MainsPowerOutletDevice extends HADeviceBase implements MainsPowerOutlet {

	private OnOff onOff;
	private Scenes scenes;
	private Groups groups;

	public MainsPowerOutletDevice(BundleContext ctx, ZigBeeDevice zbDevice) throws ZigBeeHAException {

		super(ctx, zbDevice);
		onOff = (OnOff) addCluster(HAProfile.ON_OFF);
		groups = (Groups) addCluster(HAProfile.GROUPS);
		scenes = (Scenes) addCluster(HAProfile.SCENES);
	}

	public OnOff getOnOff() {

		return onOff;
	}

	public Scenes getScenes() {

		return scenes;
	}

	public Groups getGroups() {

		return groups;
	}

	@Override
	public String getName() {

		return MainsPowerOutlet.NAME;
	}

	@Override
	public DeviceDescription getDescription() {

		return DEVICE_DESCRIPTOR;
	}

	final static DeviceDescription DEVICE_DESCRIPTOR =  new AbstractDeviceDescription(){

		public int[] getCustomClusters() {
			return MainsPowerOutlet.CUSTOM;
		}

		public int[] getMandatoryCluster() {
			return MainsPowerOutlet.MANDATORY;
		}

		public int[] getOptionalCluster() {
			return MainsPowerOutlet.OPTIONAL;
		}

		public int[] getStandardClusters() {
			return MainsPowerOutlet.STANDARD;
		}

	};
}