package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.core.Response;
import it.cnr.isti.zigbee.zcl.library.api.core.ZBDeserializer;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ZoneIDMapResponse;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ZoneTable;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ZoneTable.Zone;
import it.cnr.isti.zigbee.zcl.library.impl.core.DefaultDeserializer;
import it.cnr.isti.zigbee.zcl.library.impl.core.ResponseImpl;

public class ZoneIDMapResponseImpl extends ResponseImpl implements ZoneIDMapResponse {

	private ZoneTable zonesID;

	public ZoneIDMapResponseImpl(Response response) throws ZigBeeClusterException{
		super(response);

		ResponseImpl.checkSpecificCommandFrame(response, ID);

		ZBDeserializer deserializer = new DefaultDeserializer(getPayload(),0);

		zonesID = new ZoneTableImpl();
		for(int i = 0; i < 16; i++)
			zonesID.addZone(new Short(deserializer.read_short()), null, null);
	}

	public Zone[] getZonesID(){
		Zone[] zones = new Zone[zonesID.getZoneTable().length];
		for(int i = 0; i < zonesID.getZoneTable().length; i++)
			zones[i] = zonesID.getZoneTable()[i];

		return zones;
	}
}