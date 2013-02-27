package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASACE;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class ZoneInformationCommand extends AbstractCommand {

	public int zoneID;

	public ZoneInformationCommand(int zoneID) {
		super(IASACE.GET_ZONE_INFORMATION);
		this.zoneID = zoneID;
	}

	public byte[] getPayload(){	
		if( payload == null){	
			payload = new byte[4];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_int(zoneID);
		}
		return payload;
	}
}
