package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASACE;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class ArmCommand extends AbstractCommand {

	private byte armMode;

	public ArmCommand(byte armMode){
		super(IASACE.ARM);
		this.armMode = armMode;
	}

	public byte[] getPayload(){	
		if( payload == null){	
			payload = new byte[1];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.appendByte(armMode);
		}
		return payload;
	}
}