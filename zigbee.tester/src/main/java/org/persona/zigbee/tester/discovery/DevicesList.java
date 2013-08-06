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

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class DevicesList {
	
	ArrayList devices;	
	DeviceChangeListener listener = null;
	
	public DevicesList(){
		devices = new ArrayList();
	}
	
	
	public boolean add(DeviceNode dev) {
		if(listener!=null) 
			listener.addedDevice(dev);
		return devices.add(dev);
	}

	public Iterator iterator() {
		return devices.iterator();
	}

	public boolean remove(DeviceNode dev) {
		if(listener!=null)
			listener.removedDevice(dev);
		return devices.remove(dev);
	}

	public DeviceChangeListener getChangeListener() {
		return listener;
	}

	public void setChangeListener(DeviceChangeListener listener) {
		this.listener = listener;
	}
	
	
}
