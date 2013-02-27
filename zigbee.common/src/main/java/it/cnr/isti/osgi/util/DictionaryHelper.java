/*
   Copyright 2008-2010 CNR-ISTI, http://isti.cnr.it
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

package it.cnr.isti.osgi.util;

import java.util.Dictionary;
/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class DictionaryHelper {

	private Dictionary<Object, Object> dictionary;
	
	public DictionaryHelper(Dictionary<Object, Object> dictionary){
		if(dictionary == null){
			throw new NullPointerException("Can't wrap a null object");
		}
			
		this.dictionary = dictionary;
	}

	public String getString(String property){
		return (String) dictionary.get(property);
	}
	public String getString(String property, String defaultValue){
		String value = (String) dictionary.get(property);
		return value == null ? defaultValue : value;
	}
	
	public int getInt(String property){
		String value = (String) dictionary.get(property);
		return Integer.parseInt(value);
	}
	public int getInt(String property, int defaultValue){
		String value = (String) dictionary.get(property);
		return value == null ? defaultValue : Integer.parseInt(value);
	}
	
	public boolean getBoolean(String property){
		String value = (String) dictionary.get(property);
		if( value == null){
			throw new NullPointerException("Property "+property+" doesn't exist");
		}else if( value.equalsIgnoreCase("true") ){
			return true;
		}else if( value.equalsIgnoreCase("on") ){
			return true;
		}else if( value.equalsIgnoreCase("yes") ){
			return true;
		}else{
			return false;
		}
	}	
	public boolean getBoolean(String property, boolean defaultValue){
		String value = (String) dictionary.get(property);
		if( value == null){
			return defaultValue;
		}else if( value.equalsIgnoreCase("true") ){
			return true;
		}else if( value.equalsIgnoreCase("on") ){
			return true;
		}else if( value.equalsIgnoreCase("yes") ){
			return true;
		}else{
			return false;
		}
	}

	public long getLong(String property){
		String value = (String) dictionary.get(property);
		return Long.parseLong(value);
	}
	
	public long getLong(String property, long defaultValue){
		String value = (String) dictionary.get(property);
		return value == null ? defaultValue : Long.parseLong(value);
	}

	public double getDouble(String property, double defaultValue) {
		String value = (String) dictionary.get(property);
		return value == null ? defaultValue : Double.parseDouble(value);
	}
	
	
	
}
