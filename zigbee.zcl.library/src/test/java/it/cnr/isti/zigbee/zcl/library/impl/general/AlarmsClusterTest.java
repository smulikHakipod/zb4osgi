package it.cnr.isti.zigbee.zcl.library.impl.general;

import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;
import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ZigBeeBasedriverException;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.zcl.library.api.core.Status;
import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeClusterException;
import it.cnr.isti.zigbee.zcl.library.api.general.Alarms;
import it.cnr.isti.zigbee.zcl.library.api.general.Groups;
import it.cnr.isti.zigbee.zcl.library.api.general.groups.AddGroupResponse;
import it.cnr.isti.zigbee.zcl.library.api.global.DefaultResponse;
import it.cnr.isti.zigbee.zcl.library.impl.RawClusterImpl;

import org.junit.Test;

public class AlarmsClusterTest {

	private ZigBeeDevice createMockDevice() throws ZigBeeBasedriverException {
		ZigBeeDevice mock = createMock(ZigBeeDevice.class);
		
		expect(mock.invoke( (Cluster) anyObject()))
			.andReturn( new RawClusterImpl(
							Alarms.ID, 
							new byte[]{0x28, 0x0A, 0x0B, 0x00, 0x00 }
			) );
		replay( mock );
		return mock;
	}
	
	@Test
	public void testResetAlarm() {
		AlarmsCluster cluster = null;
		ZigBeeDevice device = null;
		try {
			device = createMockDevice();
			cluster = new AlarmsCluster(device);
		} catch (ZigBeeBasedriverException ignored) {
		}
		try {
			DefaultResponse response = (DefaultResponse) cluster.resetAlarm(1, 1);
			assertEquals( Status.SUCCESS, response.getStatus() );
		} catch (ZigBeeClusterException ex) {
			fail("Unexpected exception "+ex);
			ex.printStackTrace();
		}	
	}

}
