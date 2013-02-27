package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_wd;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_wd.StartWarningPayload;

public class StartWarningPayloadImpl implements StartWarningPayload {

	private short warningMode, strobe;
	private int warningDuration;

	public StartWarningPayloadImpl(short warningMode, short strobe, int warningDuration){

		this.warningMode = warningMode;
		this.strobe = strobe;
		this.warningDuration = warningDuration;
	}

	public short getWarningMode() {
		return warningMode;
	}

	public short getStrobe() {
		return strobe;
	}

	public int getWarningDuration() {
		return warningDuration;
	}
}