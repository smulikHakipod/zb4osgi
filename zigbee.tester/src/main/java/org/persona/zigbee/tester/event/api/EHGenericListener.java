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
package org.persona.zigbee.tester.event.api;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision: 799 $ ($LastChangedDate: 2013-08-06 18:00:05 +0200(mar, 06 ago 2013) $)
 * @since 0.3.0
 */
public interface EHGenericListener {
	
	/**
	 * 
	 * @param source the reference to the {@link Object} who generated the event
	 * @param event the original {@link Object} received during the callback
	 * @param eventString the {@link String} representation of the event
	 */
	public void eventReceived(Cluster source, Object event, String eventString);
	
}
