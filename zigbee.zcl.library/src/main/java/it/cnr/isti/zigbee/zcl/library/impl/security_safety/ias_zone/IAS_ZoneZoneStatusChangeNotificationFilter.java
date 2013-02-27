package it.cnr.isti.zigbee.zcl.library.impl.security_safety.ias_zone;

import it.cnr.isti.zigbee.api.Cluster;
import it.cnr.isti.zigbee.api.ClusterFilter;
import it.cnr.isti.zigbee.zcl.library.api.security_safety.IASZone;
import it.cnr.isti.zigbee.zcl.library.impl.core.ZCLFrame;

public class IAS_ZoneZoneStatusChangeNotificationFilter implements ClusterFilter {

	public final static IAS_ZoneZoneStatusChangeNotificationFilter FILTER = new IAS_ZoneZoneStatusChangeNotificationFilter();

	private IAS_ZoneZoneStatusChangeNotificationFilter() {

	}

	public boolean match(Cluster cluster) {
		if( cluster.getId() != IASZone.ID )  return false;

		ZCLFrame frame = new ZCLFrame(cluster);
		return frame.getHeader().getCommandId() == IASZone.ZONE_STATUS_CHANGE_NOTIFICATION_ID
				&& frame.getHeader().getFramecontrol().isClusterSpecificCommand();
	}
}