package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneEnrollRequestPayload;

public class ZoneEnrollRequestPayloadImpl implements ZoneEnrollRequestPayload {

	private short zoneType;
	private int manufacturerCode;

	public ZoneEnrollRequestPayloadImpl(short zoneType, int manufacturerCode){
		this.zoneType = zoneType;
		this.manufacturerCode = manufacturerCode;
	}

	public short getZoneType() {
		return zoneType;
	}

	public int getManufacturerCode() {
		return manufacturerCode;
	}
}