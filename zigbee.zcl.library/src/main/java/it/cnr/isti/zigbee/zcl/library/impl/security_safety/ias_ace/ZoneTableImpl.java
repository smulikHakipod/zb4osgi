package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_ace;

import it.cnr.isti.zigbee.zcl.library.api.security_safety.ias_ace.ZoneTable;

public class ZoneTableImpl implements ZoneTable {

	private Zone[] zoneTable;

	public ZoneTableImpl(){
		zoneTable = new Zone[256];
	}

	public Zone[] getZoneTable() {
		return zoneTable;
	}

	public void addZone(Short zoneID, Short zoneType, String zoneAddress) {
		for(int i = 0; i < zoneTable.length; i++){
			if(zoneTable[i] == null)
				zoneTable[i] = new Zone(zoneID, zoneType, zoneAddress);
		}		
	}

	public void removeZone(Short zoneID) {
		for(int i = 0; i < zoneTable.length; i++){
			Zone zone = zoneTable[i];
			if(zone.getZoneID().equals(zoneID)){
				zoneTable[i] = null;
				break;
			}
		}		
	}
}