/*
   Copyright 2008-2013 CNR-ISTI, http://isti.cnr.it
   Institute of Information Science and Technologies 
   of the Italian National Research Council 


   See the NOTICE file distributed with this work for additional 
   information regarding copyright ownership

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.persona.zigbee.tester.discovery;

import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.ha.driver.core.HADevice;

import java.util.ArrayList;

import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.persona.zigbee.tester.Activator;
import org.persona.zigbee.tester.gui.LogPanel;

/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2014-01-27 17:50:47
 *          +0100(lun, 27 gen 2014) $)
 * @since 0.1.0
 * 
 */
public class RootDeviceListener {

	// This list contains all partial tree of UPnP Device
	// when a device is complete it will be removed from the list
	private ArrayList<DeviceNode> devices;

	private DeviceNodeListener listener;

	private HADeviceServiceListener haListener = null;
	private HADeviceServiceListener ehListener = null;
	private ZigBeeDeviceServiceListener zbListener = null;

	class HADeviceServiceListener implements ServiceListener {

		public void serviceChanged(ServiceEvent e) {
			switch (e.getType()) {
				case ServiceEvent.REGISTERED : {
					addNewDevice(e.getServiceReference());
				}
					;
					break;

				case ServiceEvent.MODIFIED : {
				}
					;
					break;

				case ServiceEvent.UNREGISTERING : {
					removeDevice(e.getServiceReference());
				}
					;
					break;

			}
		}
	}

	class ZigBeeDeviceServiceListener implements ServiceListener {

		public void serviceChanged(ServiceEvent e) {
			switch (e.getType()) {
				case ServiceEvent.REGISTERED : {
					// TODO Verify if next line create duplicate devices
					listener.deviceDetected(e.getServiceReference());
				}
					;
					break;

				case ServiceEvent.MODIFIED : {
				}
					;
					break;

				case ServiceEvent.UNREGISTERING : {
					ZigBeeDevice device = (ZigBeeDevice) Activator.context
							.getService(e.getServiceReference());
					listener.rootDeviceUnplugged(device.getUniqueIdenfier());
				}
					;
					break;

			}
		}

	}

	public RootDeviceListener() {
		devices = new ArrayList<DeviceNode>();
	}

	public void setDeviceNodeListener(DeviceNodeListener listener) {
		this.listener = listener;
	}

	public synchronized void addNewDevice(ServiceReference sr) {
		LogPanel.log("adding device:" + sr.getProperty(HADevice.HA_DEVICE_NAME));
		DeviceNode node = new DeviceNode(sr);
		// node.print();
		if (node.isRoot() && node.isLeaf()) {
			// Obiovsly
			listener.deviceDetected(node);
			return;
		}

		devices.add(node);
	}

	public void removeDevice(ServiceReference sr) {
		DeviceNode node = new DeviceNode(sr);
		if (node.isRoot()) {
			LogPanel.log("removing root device ..."
					+ sr.getProperty(HADevice.HA_DEVICE_NAME));
			listener.rootDeviceUnplugged(node.toString());
			return;
		}

	}

	/**
	 * Register this object to listen to all "well registered" UPnPDevice<br>
	 * that should be Exported<br>
	 * And look for all the already registered UPnPDevice to be exported
	 * 
	 */
	public void activate() {
		/*
		 * I listen for the UPnPDevice service that are Root that should be
		 * exported to UPnP Network.
		 */
		try {
			haListener = new HADeviceServiceListener();
			ehListener = new HADeviceServiceListener();
			zbListener = new ZigBeeDeviceServiceListener();
			Activator.context.addServiceListener(haListener, "("
					+ Constants.OBJECTCLASS + "=" + HADevice.class.getName() + ")");
			Activator.context.addServiceListener(ehListener, "("
					+ Constants.OBJECTCLASS + "=" + "it.cnr.isti.zigbee.eh.driver.core.EHDevice" + ")");
			/*
			 * Activator.context.addServiceListener(haListener, "(|"+
			 * "("+Constants.OBJECTCLASS+"="+HADevice.class.getName()+")" +
			 * "("+Constants.OBJECTCLASS+"="+EHDevice.class.getName()+")" + ")"
			 * );
			 */

			Activator.context.addServiceListener(
					zbListener,
					"(" + Constants.OBJECTCLASS + "="
							+ ZigBeeDevice.class.getName() + ")");
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		ServiceReference[] roots = null;
		try {
			roots = Activator.context.getServiceReferences(
					HADevice.class.getName(), null);
		} catch (InvalidSyntaxException e) {
			e.printStackTrace();
		}
		if (roots != null) {
			for (int i = 0; i < roots.length; i++) {
				addNewDevice(roots[i]);
			}
		}
	}

	/**
	 * 
	 */
	public void deactive() {
		if (zbListener != null)
			Activator.context.removeServiceListener(zbListener);
		if (haListener != null)
			Activator.context.removeServiceListener(haListener);
	}

	// public void checkIncompleteDevice() {
	// if (devices.size() == 0){
	// LogPanel.log("[check incomplete device] no pending devices !" );
	// return;
	// }
	// Iterator list = devices.iterator();
	// while(list.hasNext()){
	// LogPanel.log("[check incomplete device] " );
	// LogPanel.log("------- device -------- " );
	// DeviceNode tree = (DeviceNode) list.next();
	// printProperties(tree.getReference());
	// }
	//
	// }

	// public static void checkErrataDevice() {
	// ServiceReference[] allUPnPDevice = null;
	// ServiceReference[] UPnPbaseDriverDevice = null;
	// try {
	// allUPnPDevice = Activator.context.getServiceReferences(
	// UPnPDevice.class.getName(),
	// "(&" + "(" + UPnPDevice.UPNP_EXPORT + "=*)"
	// + "("+Constants.OBJECTCLASS+"="+UPnPDevice.class.getName()+")"
	// + ")"
	// );
	// // filter used by UPnP base Driver
	// UPnPbaseDriverDevice =
	// Activator.context.getServiceReferences(UPnPDevice.class.getName(),
	// "(&" + "(" + UPnPDevice.UPNP_EXPORT + "=*)" +
	// "(DEVICE_CATEGORY=UPnP)" +
	// "(" + UPnPDevice.UDN + "=*)" +
	// "(" + UPnPDevice.FRIENDLY_NAME + "=*)" +
	// "(" + UPnPDevice.MANUFACTURER + "=*)" +
	// "(" + UPnPDevice.MODEL_NAME + "=*)" +
	// "(" + UPnPDevice.TYPE + "=*)" +
	// "(!("+ UPnPDevice.PARENT_UDN + "=*))" +
	// ")");
	//
	// } catch (InvalidSyntaxException e) {
	// e.printStackTrace();
	// }
	// if (allUPnPDevice!=null){
	// if (UPnPbaseDriverDevice!= null){
	// if (allUPnPDevice.length == UPnPbaseDriverDevice.length){
	// LogPanel.log("---- Check Errata Device ----");
	// LogPanel.log("All registered Devices have mandatory properties specified");
	// LogPanel.log("--------  End Check  --------");
	// }
	// else if (allUPnPDevice.length > UPnPbaseDriverDevice.length)
	// printErrataDevice(allUPnPDevice,UPnPbaseDriverDevice) ;
	// }
	// else {
	// printErrataDevice(allUPnPDevice,UPnPbaseDriverDevice) ;
	// }
	// }
	//
	// }

	// public static void printErrataDevice(ServiceReference[]
	// allUPnPDevice,ServiceReference[] UPnPbaseDriverDevice) {
	// LogPanel.log("---- Check Errata Device ----");
	// for (int i =0;i< allUPnPDevice.length;i++){
	// if (! isPresent(allUPnPDevice[i],UPnPbaseDriverDevice)){
	// LogPanel.log("---- Device ----");
	// printProperties(allUPnPDevice[i]);
	// }
	// }
	// LogPanel.log("--------  End Check  --------");
	// }

	public static boolean isPresent(ServiceReference sr, ServiceReference[] list) {
		Object s = Activator.context.getService(sr);
		for (int i = 0; i < list.length; i++) {
			Object item = Activator.context.getService(list[i]);
			if (s == item) {
				Activator.context.ungetService(sr);
				Activator.context.ungetService(list[i]);
				return true;
			}
			Activator.context.ungetService(list[i]);
		}
		Activator.context.ungetService(sr);
		return false;
	}

	// public static void printProperties(ServiceReference service){
	// String[] properties = service.getPropertyKeys();
	// if (properties == null)
	// LogPanel.log("properties are null");
	// else {
	// for(int j =0;j<properties.length;j++)
	// LogPanel.log(properties[j] + "=" +
	// Util.justString(service.getProperty(properties[j])));
	// }
	//
	// if ( service.getProperty(UPnPDevice.UDN)== null)
	// LogPanel.log("[Warning] missing property: "+UPnPDevice.UDN);
	// if ( service.getProperty(UPnPDevice.FRIENDLY_NAME)== null)
	// LogPanel.log("[Warning] missing property: "+UPnPDevice.FRIENDLY_NAME);
	// if ( service.getProperty(UPnPDevice.MANUFACTURER)== null)
	// LogPanel.log("[Warning] missing property: "+UPnPDevice.MANUFACTURER);
	// if ( service.getProperty(UPnPDevice.MODEL_NAME)== null)
	// LogPanel.log("[Warning] missing property: "+UPnPDevice.MODEL_NAME);
	// if ( service.getProperty(UPnPDevice.TYPE)== null)
	// LogPanel.log("[Warning] missing property: "+UPnPDevice.TYPE);
	//
	// }

}
