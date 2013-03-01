package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneEnrollResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

public class ZoneEnrollResponseImpl extends ResponseImpl implements ZoneEnrollResponse {

	private int enrollResponseCode;
	private int zoneID;

	public ZoneEnrollResponseImpl(Response response) throws ZigBeeClusterException {

		super(response);

		//ResponseImpl.checkGeneralCommandFrame(response, ZoneEnrollResponse.ID);
		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(), 0);
		enrollResponseCode = (Integer) deserializer.readZigBeeType(ZigBeeType.Enumeration8bit);
		zoneID = (Integer) deserializer.readZigBeeType(ZigBeeType.UnsignedInteger8bit);
	}

	public ZoneEnrollResponseImpl(Cluster cluster, short expectedClusterId) throws ZigBeeClusterException {

		super(cluster, expectedClusterId);

		//ResponseImpl.checkGeneralCommandFrame(response, ZoneEnrollResponse.ID);
		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(), 0);
		enrollResponseCode = (Integer) deserializer.readZigBeeType(ZigBeeType.Enumeration8bit);
		zoneID = (Integer) deserializer.readZigBeeType(ZigBeeType.UnsignedInteger8bit);
	}

	public int getEnrollResponseCode() {

		return enrollResponseCode;
	}

	public int getZoneID() {

		return zoneID;
	}
}