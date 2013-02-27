package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_wd;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASWD;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_wd.SquawkPayload;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class SquawkCommand extends AbstractCommand {

	private SquawkPayload squawkPayload;

	public SquawkCommand(SquawkPayload payload){
		super(IASWD.SQUAWK);
		this.squawkPayload = payload;
	}

	public byte[] getPayload(){	
		if( payload == null){	
			payload = new byte[6];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_short((short)squawkPayload.getSquawkLevel());
			serializer.append_short((short)squawkPayload.getSquawkMode());
			serializer.append_short((byte)squawkPayload.getStrobe());
		}
		return payload;
	}
}
