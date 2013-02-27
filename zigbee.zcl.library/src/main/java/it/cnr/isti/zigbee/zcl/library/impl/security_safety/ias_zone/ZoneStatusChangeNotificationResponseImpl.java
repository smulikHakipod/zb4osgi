package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneStatusChangeNotificationResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

public class ZoneStatusChangeNotificationResponseImpl extends ResponseImpl implements ZoneStatusChangeNotificationResponse {

	private short zoneStatus;
	private byte extendedStatus;

	public ZoneStatusChangeNotificationResponseImpl(Response response){
		super(response);

		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(), 0);
		zoneStatus = deserializer.read_short();
		extendedStatus = deserializer.read_byte();
	}

	public short getZoneStatus() {
		return zoneStatus;
	}

	public byte getExtendedStatus() {
		return extendedStatus;
	}
}
