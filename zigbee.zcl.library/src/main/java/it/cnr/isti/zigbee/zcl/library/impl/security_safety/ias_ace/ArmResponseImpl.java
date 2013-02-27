package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ArmResponse;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

public class ArmResponseImpl extends ResponseImpl implements ArmResponse {

	private byte armNotification;

	public ArmResponseImpl(Response response) throws ZigBeeClusterException {
		super(response);

		ResponseImpl.checkSpecificCommandFrame(response, ID);

		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(),0);
		armNotification = deserializer.read_byte();
	}

	public byte getArmNotification() {
		return armNotification;
	}
}