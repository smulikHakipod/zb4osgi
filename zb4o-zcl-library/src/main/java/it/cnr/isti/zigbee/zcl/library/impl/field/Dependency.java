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

package it.cnr.isti.zigbee.zcl.library.impl.field;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;

/**
 * 
 * @author <a href="mailto:giancarlo.riolo@isti.cnr.it">Giancarlo Riolo</a>
 * @author <a href="mailto:stefano.lenz@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * 
 */
public interface Dependency {

	/**
	 * @param object
	 * @param zigBeeType
	 * @return
	 */
	boolean match(Object object, ZigBeeType zigBeeType);

	/**
	 * @return
	 */
	int getFieldIndex();

	public BitmaskDependency dependFromField(int fieldIndex);

	public BitmaskDependency matchType(MatchType singleBit, int... indexes);
	
	public BitmaskDependency matchPositions(int... positions);
}
