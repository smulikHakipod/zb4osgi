package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.ZBSerializer;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASACE;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.BypassPayload;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultSerializer;

public class BypassCommand extends AbstractCommand {

	private BypassPayload bypassPayload;

	public BypassCommand(BypassPayload bypassPayload){
		super(IASACE.BYPASS);
		this.bypassPayload = bypassPayload;
	}

	public byte[] getPayload(){	
		if( payload == null){	
			int length = 4 + bypassPayload.getNumberOfZones()*4;

			payload = new byte[length];
			ZBSerializer serializer = new DefaultSerializer(payload,0);
			serializer.append_int(bypassPayload.getNumberOfZones());
			for(int i = 0; i < bypassPayload.getNumberOfZones(); i++){
				serializer.append_int(bypassPayload.getZonesID()[i]);
			}
		}
		return payload;
	}
}