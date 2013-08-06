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
import it.cnr.isti.zigbee.ha.driver.core.HADevice;

import java.util.ArrayList;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * 
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class DeviceNode {
	
	private ServiceReference sr;
	private boolean isRootNode;
	private String udn ;
	private boolean hasChild;
	private int numberOfSons;
	private ArrayList children;
	private DeviceNode parent;
	final private String friendlyName;
	
	public DeviceNode(ServiceReference sr){
		//PRE: argument is always UPnPDevice service reference
		if (sr == null) 
			throw new IllegalArgumentException("null is not a valid arg in DeviceNode constructor");
		this.sr = sr;
		udn = (String) sr.getProperty(HADevice.ZIGBEE_DEVICE_UUID);
		friendlyName = sr.getProperty(HADevice.HA_DEVICE_NAME)+" ["+sr.getProperty(HADevice.ZIGBEE_DEVICE_UUID)+"]";
		parent=null;
		isRootNode = true;
		String[] sons = null;
		hasChild = (sons != null);
		if (hasChild) {
			children = new ArrayList();
			numberOfSons = sons.length;
		}
		/*
		//Operation to let DeviceNode::isComplete() O(1)
		isComplete = !hasChild;
		*/					
	}
	
	public ServiceReference getReference(){
		return sr;
	}
	public HADevice getDevice(BundleContext ctx){
		return (HADevice)ctx.getService(sr);
	}
			
//	public DeviceNode isAttachable(DeviceNode node){
//		if (node == null) 
//			throw new IllegalArgumentException("null is not a valid arg in DeviceNode.isAttachable() method");
//		String parentUDN=(String) node.getReference().getProperty(UPnPDevice.PARENT_UDN);
//		if(parentUDN==null) return null;
//		return search(parentUDN);		
//	}
		
	public boolean isRoot(){
		return isRootNode;		
	}
	
	public boolean equals(String udn){
		return this.udn.equals(udn);
	}
	
	public String toString(){
		return friendlyName;
	}		
	public boolean isLeaf() {
		return !hasChild;
	}
    
    public void print(){
        System.out.println("####Device Node");
        String[] props = sr.getPropertyKeys();
        for (int i=0;i< props.length;i++){
            Object prop= sr.getProperty(props[i]);
            if (prop instanceof String[]){
                System.out.println(props[i]+ "=");
                String[] multiple = (String[])prop;
                for (int j=0;j< multiple.length;j++){
                    System.out.println(multiple[j]+ ";"); 
                }

            }
            else System.out.println(props[i]+ "="+ prop);
        }
        System.out.println("####Device Node");
   }
}
