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

package it.cnr.isti.osgi.util;

import org.osgi.framework.BundleContext;
/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class OSGiProperties {

	private final BundleContext bundle;

	public static final String getString(BundleContext bundle, String property, String defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : value;
	}

	public static final boolean getBoolean(BundleContext bundle, String property, boolean defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
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

	public static final int getInt(BundleContext bundle, String property, int defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : Integer.parseInt(value);
	}
	
	
	public OSGiProperties(BundleContext bundleContext) {
		bundle = bundleContext;
	}

	public String getString(String property){
		return bundle == null ? null : bundle.getProperty(property);		
	}
	public String getString(String property, String defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : value;
	}
	
	public int getInt(String property){
		String value = bundle == null ? null : bundle.getProperty(property);
		return Integer.parseInt(value);
	}
	public int getInt(String property, int defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : Integer.parseInt(value);
	}
	
	public boolean getBoolean(String property){
		String value = bundle == null ? null : bundle.getProperty(property);
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
		String value = bundle == null ? null : bundle.getProperty(property);
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

	public static final long getLong(BundleContext bundle, String property, int defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : Long.parseLong(value);
	}
	public long getLong(String property){
		String value = bundle == null ? null : bundle.getProperty(property);
		return Long.parseLong(value);
	}
	public long getLong(String property, int defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : Long.parseLong(value);
	}

	public static double getDouble(BundleContext  bundle, String property, double defaultValue){
		String value = bundle == null ? null : bundle.getProperty(property);
		return value == null ? defaultValue : Double.parseDouble(value);
	}

	
}
