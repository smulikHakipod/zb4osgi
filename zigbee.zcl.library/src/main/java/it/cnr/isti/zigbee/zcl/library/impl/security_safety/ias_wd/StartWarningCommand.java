package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_wd;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASWD;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_wd.StartWarningPayload;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class StartWarningCommand extends AbstractCommand {

	private StartWarningPayload startWarningPayload;

	public StartWarningCommand(StartWarningPayload payload){
		super(IASWD.START_WARNING);
		this.startWarningPayload = payload;
	}

	public byte[] getPayload(){	
		if( payload == null){	
			payload = new byte[8];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_short(startWarningPayload.getStrobe());
			serializer.append_short(startWarningPayload.getWarningMode());
			serializer.append_int(startWarningPayload.getWarningDuration());
		}
		return payload;
	}
}
