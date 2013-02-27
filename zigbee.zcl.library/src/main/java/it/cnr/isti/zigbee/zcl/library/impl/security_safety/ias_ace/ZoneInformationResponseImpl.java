package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ZoneInformationResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

public class ZoneInformationResponseImpl extends ResponseImpl implements ZoneInformationResponse {

	private int zoneID;
	private short zoneType;
	private String IEEEaddress;

	public ZoneInformationResponseImpl(Response response) throws ZigBeeClusterException {
		super(response);

		ResponseImpl.checkSpecificCommandFrame(response, ID);

		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(),0);
		zoneID = deserializer.read_int();
		zoneType = deserializer.readShort();
		IEEEaddress = deserializer.readString();
	}

	public int getZoneID() {
		return zoneID;
	}

	public short getZoneType() {
		return zoneType;
	}

	public String getIEEEAddress() {
		return IEEEaddress;
	}
}
