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

package it.cnr.isti.zigbee.eh.driver.core;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Basic;
import it.cnr.isti.zigbee.ha.cluster.glue.general.Identify;
import it.cnr.isti.zigbee.ha.driver.ArraysUtil;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05 +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 *
 */
public interface EHDevice {
	
	public static final String ZIGBEE_DEVICE_SERVICE = "zigbee.service.id";
	public static final String ZIGBEE_DEVICE_UUID = "zigbee.device.uuid";
	public static final String EH_DRIVER = "zigbee.eh.driver.name";
	public static final String EH_DEVICE_NAME = "zigbee.eh.name";
	public static final String EH_DEVICE_GROUP = "zigbee.eh.group";
	public static final String EH_DEVICE_STANDARD = "zigbee.eh.standard";
	
	public static final int[] MANDATORY = {EHProfile.BASIC,EHProfile.IDENTIFY};
	public static final int[] OPTIONAL = {/*EHProfile.PARTITION*/};
	public static final int[] STANDARD = ArraysUtil.append(MANDATORY, OPTIONAL);
	
	public String getName();	
	/**
	 * 
	 * @return an <code>int</code> representing the <b>DeviceId</b> as defined by the<br> 
	 * 		<i>ZigBee Home Automation</i> profile documentation
	 */
	public int getDeviceType();
	public int getEndPointId();
	public int getProfileId();
	
	/**
	 * Access method for the <b>Mandatory</b> cluster: {@link Basic} 
	 *  
	 * @return the {@link Basic} cluster object
	 */
	public Basic getBasic();
	
	/**
	 * Access method for the <b>Mandatory</b> cluster: {@link Basic} 
	 *  
	 * @return the {@link Basic} cluster object
	 */	
	public Identify getIdentify();

	/**
	 * Access method for the <b>Optional</b> cluster: {@link Object} 
	 *  
	 * @return the {@link Object} cluster object
	 * @since 0.1.0
	 */
	public Object /*Partition*/ getPartition();


	/**
	 * 
	 * @param id the <code>int</code> representing the <b>ClusterId</b> 
	 * @return the {@link Cluster} identified by the given id if this device implements<br>
	 * 		otherwise <code>null</code>
	 * @since 0.1.0
	 */
	public Cluster getCluster(int id);
	
	/**
	 * 
	 * @return the {@link Cluster} array effectively implemented by the remote ZigBee Device<br>
	 * 		otherwise <code>null</code>
	 */
	public  Cluster[] getAvailableCluster();

}
