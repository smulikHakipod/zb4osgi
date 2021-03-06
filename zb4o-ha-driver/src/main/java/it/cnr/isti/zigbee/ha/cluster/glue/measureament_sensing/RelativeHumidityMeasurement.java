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

package it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.event.MeasuredValueListener;
import it.cnr.isti.zigbee.ha.cluster.glue.measureament_sensing.event.ToleranceListener;
import it.cnr.isti.zigbee.zcl.library.api.core.Attribute;

/**
 * This interface simplify the use of the cluster by avoiding the check of error messages and flow control. 
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @author <a href="mailto:francesco.furfari@isti.cnr.it">Francesco Furfari</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public interface RelativeHumidityMeasurement extends Cluster {

	public Attribute getMeasuredValue();
	public Attribute getMinMeasuredValue();
	public Attribute getMaxMeasuredValue();
	public Attribute getTolerance();

	/**
	 * 
	 * @param tl The {@link ToleranceListener} to subscribe for events
	 * @since 0.6.0
	 */
	public boolean subscribe(ToleranceListener tl);
	
	/**
	 * 
	 * @param tl The {@link ToleranceListener} to unsubscribe
	 * @since 0.6.0
	 */
	public boolean unsubscribe(ToleranceListener tl);
	
	/**
	 * 
	 * @param mvl The {@link MeasuredValueListener} to subscribe for events
	 * @since 0.6.0
	 */
	public boolean subscribe(MeasuredValueListener mvl);
	
	/**
	 * 
	 * @param mvl The {@link MeasuredValueListener} to unsubscribe
	 * @since 0.6.0
	 */
	public boolean unsubscribe(MeasuredValueListener mvl);
	
}
