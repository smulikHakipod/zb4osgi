package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.BypassPayload;

public class BypassPayloadImpl implements BypassPayload {

	public int numberOfZones;
	public int[] zonesID;

	public BypassPayloadImpl(int numberOfZones, int[] zonesID){
		this.numberOfZones = numberOfZones;
		this.zonesID = zonesID;
	}

	public int getNumberOfZones() {
		return numberOfZones;
	}

	public int[] getZonesID() {
		return zonesID;
	}
}
