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

package org.persona.zigbee.tester.gui;

import it.cnr.isti.zigbee.ha.cluster.glue.Cluster;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.StyledEditorKit.ItalicAction;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.3.0
 */
public class Command {
	
	public class CommandParsingException extends IllegalArgumentException {
		public String value;
		public int index;
		
		public CommandParsingException(String v, int i, String msg, Throwable ex){
			super(msg,ex);
			index = i;
			value = v;
		}
		
		public CommandParsingException(String v, int i, String msg){
			super(msg);
			index = i;
			value = v;
		}
		
	}
	
	private Method method;
	private Cluster cluster;
	
	public Command(Cluster c, Method m){
		cluster = c;
		method = m;
	}
	
	public String[] getInputParameters(){
		Class<?>[] params = method.getParameterTypes();
		String[] types = new String[params.length];
		for (int i = 0; i < types.length; i++) {
			types[i]=params[i].getName();
		}
		return types;
	}
	
	
	private boolean assignValueFromString(Class<?> clz, Object[] objs, int i, String value) {
		objs[i] = null; //Emptying value
		try {
			if ( clz.isAssignableFrom( long.class ) ) objs[i] = Long.decode(value).longValue();
			else if ( clz.isAssignableFrom( int.class ) )objs[i] = Integer.decode(value).intValue();
			else if ( clz.isAssignableFrom( short.class ) ) objs[i] = Short.decode(value).shortValue();
			else if ( clz.isAssignableFrom( byte.class ) ) objs[i] = Byte.decode(value).byteValue();
			else if ( clz.isAssignableFrom( double.class ) ) objs[i] = Double.valueOf(value).doubleValue();
			else if ( clz.isAssignableFrom( float.class ) ) objs[i] = Float.valueOf(value).floatValue();
		}catch (NumberFormatException ex){
			throw new CommandParsingException(value,i,"The parameter is a number and "+value+" does not reppresent a number", ex);
		}			
		if ( objs[i] != null) return true; //Data already assigned 
		
		if ( clz.isAssignableFrom( boolean.class ) ) objs[i] = Boolean.valueOf(value).booleanValue() || "on".equalsIgnoreCase(value) || "1".equals(value);
		else if ( clz.isAssignableFrom( String.class ) ) objs[i] = value;
		return objs[i] != null;
	}
	
	private Object objectArrayToNativeArray(Class<?> nativeType,Object[] array, int length){
		if ( nativeType == int.class ){
			int[] result = new int[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Integer) array[i];
			}
			return result;
		}
		if ( nativeType == long.class ){
			long[] result = new long[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Long) array[i];
			}
			return result;
		}
		if ( nativeType == short.class ){
			short[] result = new short[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Short) array[i];
			}
			return result;
		}
		if ( nativeType == byte.class ){
			byte[] result = new byte[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Byte) array[i];
			}
			return result;
		}
		if ( nativeType == boolean.class ){
			boolean[] result = new boolean[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Boolean) array[i];
			}
			return result;
		}
		if ( nativeType == float.class ){
			float[] result = new float[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Float) array[i];
			}
			return result;
		}
		if ( nativeType == double.class ){
			double[] result = new double[length];
			for (int i = 0; i < result.length; i++) {
				result[i] = (Double) array[i];
			}
			return result;
		}
		throw new IllegalArgumentException("Unable to convert Object[] to "+nativeType+"[]");
	}
	
	private <T> boolean assignArrayFromString(Class<? extends T[]> clz, Object[] objs, int target, String value) {
		objs[target] = null;
		Class<?> type = clz.getComponentType();
		String[] slices = value.split("[,;]");
		Object[] array = new Object[slices.length];
		int idx = 0;
		for (int j = 0; j < slices.length; j++) {
			slices[j] = slices[j].trim();
			if ( "".equals( slices[j] ) ) continue;
			assignValueFromString(type, array, idx, slices[j]);
			idx++;
		}
		objs[target] = objectArrayToNativeArray(type,array,idx);
		// objs[target] = Arrays.copyOfRange(array, 0, idx, clz); It's not working
		return objs[target] != null;
	}	
	
	public <T> String invoke(String[] values) throws Exception {
		Class<?>[] params = method.getParameterTypes();
		Object[] objs = new Object[params.length];
		for (int i = 0; i < objs.length; i++) {
			if ( params[i].isArray() ){
				Class<? extends T[]> type = (Class<? extends T[]>) params[i];
				assignArrayFromString(type, objs, i, values[i]);
			} else {
				assignValueFromString(params[i], objs, i, values[i]);
			}
			if ( objs[i] == null ){
				throw new CommandParsingException(
						values[i],
						i,
						"No convertion defined from "+String.class+" to argument of type "+params[i]
				);
			}
		}
		if( method.getReturnType() == void.class ) {
			method.invoke(cluster, objs);
			return null;
		}else{
			return method.invoke(cluster, objs).toString();
		}
	}
	

	public String getName() {
		return cluster.getName()+"."+method.getName();
	}
	
	public String toString() {
		return method.getName();
	}
	
}
