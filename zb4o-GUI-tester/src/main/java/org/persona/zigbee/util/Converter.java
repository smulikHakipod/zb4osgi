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

package org.persona.zigbee.util;

import it.cnr.isti.zigbee.zcl.library.api.core.ZigBeeType;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.4.0
 *
 */
public class Converter {

	public static Object fromString(String value, ZigBeeType type){
		Object newValue;
		if( type.getJavaClass() == Long.class ) {
			newValue = Long.decode(value);
		} else if( type.getJavaClass() == Integer.class ) {
			newValue =  Integer.decode(value);
		} else if( type.getJavaClass() == Short.class ) {
			newValue =  Short.decode(value);
		} else if( type.getJavaClass() == Byte.class ) {
			newValue =  Byte.decode(value);
		} else if( type.getJavaClass() == Double.class ) {
			newValue =  Double.valueOf(value);
		} else if( type.getJavaClass() == Float.class ) {
			newValue =  Float.valueOf(value);
		} else if( type.getJavaClass() == String.class ) {
			newValue =  value;
		} else if( type.getJavaClass() == Boolean.class) {
			newValue =  Boolean.valueOf(value) || "1".equals(value) || "on".equalsIgnoreCase(value);
		} else {
			throw new IllegalArgumentException("Unsupported ZigBee Type: "+ type);
		}
		return newValue;
		
	}
}
