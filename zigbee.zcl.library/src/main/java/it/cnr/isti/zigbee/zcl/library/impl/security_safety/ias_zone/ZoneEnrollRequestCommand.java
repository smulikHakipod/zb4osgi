package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASZone;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneEnrollRequestPayload;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class ZoneEnrollRequestCommand extends AbstractCommand {

	private ZoneEnrollRequestPayload cmdPayload;

	public ZoneEnrollRequestCommand(ZoneEnrollRequestPayload cmdPayload) {
		super(IASZone.ZONE_ENROLL_REQUEST_ID);
		this.cmdPayload = cmdPayload;
	}

	public byte[] getPayload(){	
		if( payload == null){		
			payload = new byte[6];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_short(cmdPayload.getZoneType());
			serializer.append_int(cmdPayload.getManufacturerCode());
		}

		return payload;
	}
}