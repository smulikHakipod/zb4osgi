/**
 * 
 */
package org.aaloa.zb4osgi.network.browser.ui.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 *         </a> - Copyright (c) 29/set/2010
 * @version $LastChangedRevision$ ($LastChangedDate$)
 */
public class ZigBeeEdge {

	private static final Logger logger = LoggerFactory.getLogger(ZigBeeEdge.class);
	
	private ZigBeeVertex from;
	private ZigBeeVertex to;
	
	
	public ZigBeeEdge(ZigBeeVertex from, ZigBeeVertex to) {
		this.from = from;
		this.to = to;
	}

	public int hashCode() {
		return toString().hashCode();
	}
	
	public String toString() {
		return from + "->" + to;
	}
	
	public boolean equals(Object obj) {
		if ( obj == null ) 
			return false;
		return this.toString().equals(obj.toString());
	}
}
