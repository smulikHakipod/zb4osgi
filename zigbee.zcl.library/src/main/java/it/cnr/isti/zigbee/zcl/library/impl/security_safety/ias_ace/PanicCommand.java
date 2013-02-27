package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASACE;
import it.cnr.isti.zigbee.zcl.library.impl.core.AbstractCommand;

public class PanicCommand extends AbstractCommand {

	public PanicCommand(){
		super(IASACE.PANIC);
	}
}