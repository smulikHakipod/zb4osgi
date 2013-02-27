package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASZone;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_zone.ZoneStatusChangeNotificationPayload;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class ZoneStatusChangeNotificationCommand extends AbstractCommand {

	private ZoneStatusChangeNotificationPayload cmdPayload;

	public ZoneStatusChangeNotificationCommand(ZoneStatusChangeNotificationPayload cmdPayload){
		super(IASZone.ZONE_STATUS_CHANGE_NOTIFICATION_ID);
		this.cmdPayload = cmdPayload;
	}

	public byte[] getPayload(){	
		if( payload == null){		
			payload = new byte[3];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_short(cmdPayload.getZoneStatus());
			serializer.append_byte(cmdPayload.getExtendedStatus());
		}

		return payload;
	}
}