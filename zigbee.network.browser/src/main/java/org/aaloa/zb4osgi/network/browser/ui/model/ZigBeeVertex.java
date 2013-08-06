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
package org.aaloa.zb4osgi.network.browser.ui.model;
import it.cnr.isti.zigbee.api.ZigBeeDevice;
import it.cnr.isti.zigbee.api.ZigBeeNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ZigBeeVertex {

	private static final Logger logger = LoggerFactory.getLogger(ZigBeeVertex.class);
    
	private final ZigBeeNode node;
	private final ZigBeeDevice device;

	public ZigBeeVertex( ZigBeeNode n ) {
        this.node = n;
        this.device = null;
    }

	public ZigBeeVertex( ZigBeeDevice d ) {
        this.device = d;
        this.node = d.getPhysicalNode();
    }
	
    public String getIEEEAddress() {
        return node.getIEEEAddress();
    }

    public int getNetworkAddress() {
        return node.getNetworkAddress();
    }
    
    public ZigBeeDevice getZigBeeDevice(){
    	return device;
    }

    public String toString(){
    	if( device == null ) {
    		return node.getNetworkAddress() + "/" + getIEEEAddress();
    	} else {
    		return device.getUniqueIdenfier();
    	}
    }
    
    public boolean equals( Object obj ){
        final ZigBeeVertex v = (ZigBeeVertex) obj;
        return toString().equals(v.toString());
    }
        
    public int hashCode(){
        return toString().hashCode();
    }	
}
