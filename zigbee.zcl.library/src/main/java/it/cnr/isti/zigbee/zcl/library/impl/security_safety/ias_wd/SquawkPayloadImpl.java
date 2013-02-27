package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_wd;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_wd.SquawkPayload;

public class SquawkPayloadImpl implements SquawkPayload {

	private short squawkMode, squawkLevel, strobe;

	public SquawkPayloadImpl(short squawkMode, short squawkLevel, short strobe){

		this.squawkMode = squawkMode;
		this.strobe = strobe;
		this.squawkLevel = squawkLevel;
	}

	public short getSquawkMode() {
		return squawkMode;
	}

	public short getSquawkLevel() {
		return squawkLevel;
	}

	public short getStrobe() {
		return strobe;
	}
}
