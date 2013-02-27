package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneStatusChangeNotificationPayload;

public class ZoneStatusChangeNotificationPayloadImpl implements ZoneStatusChangeNotificationPayload {

	private short zoneStatus;
	private byte extendedStatus;

	public ZoneStatusChangeNotificationPayloadImpl(ZoneStatusChangeNotificationPayload payload){

		this.zoneStatus = payload.getZoneStatus();
		this.extendedStatus = payload.getExtendedStatus();
	}

	public short getZoneStatus() {
		return zoneStatus;
	}

	public byte getExtendedStatus() {
		return extendedStatus;
	}
}