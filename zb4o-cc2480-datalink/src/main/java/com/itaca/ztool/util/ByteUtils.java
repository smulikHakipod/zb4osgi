/*
   Copyright 2008-2013 Andrew Rapp, http://code.google.com/p/xbee-api/

   Copyright 2008-2013 ITACA-TSB, http://www.tsb.upv.es/
   Instituto Tecnologico de Aplicaciones de Comunicacion 
   Avanzadas - Grupo Tecnologias para la Salud y el 
   Bienestar (TSB)


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

package com.itaca.ztool.util;

import java.io.IOException;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:andrew.rapp@gmail.com">Andrew Rapp</a>
 * @author <a href="mailto:alfiva@aaa.upv.es">Alvaro Fides Valero</a>
 * @version $LastChangedRevision$ ($LastChangedDate$)
 *
 */
public class ByteUtils {

	private final static Logger logger = LoggerFactory.getLogger(ByteUtils.class);
	
	/**
	 * There is a slight problem with this method that you might have noticed;  a Java int is signed, so we can't make
	 * use of the 32nd bit.  This means we this method does not support a four byte value with msb greater than 01111111 ((2^7-1) or 127).
	 * 
	 * TODO use long instead of int to support 4 bytes values.  note that long assignments are not atomic.
	 */
	public static int convertMultiByteToInt(int[] bytes) {
		
		if (bytes.length > 4) {
			throw new RuntimeException("too big");
		} else if (bytes.length == 4 && ((bytes[0] & 0x80) == 0x80)) {
			// 0x80 == 10000000, 0x7e == 01111111
			throw new RuntimeException("Java int can't support a four byte value, with msb byte greater than 7e");
		}
		
		int val = 0;
		
		for (int i = 0; i < bytes.length; i++) {
			
			if (bytes[i] > 0xFF) {
				throw new RuntimeException("Values exceeds byte range: " + bytes[i]);
			}
			
			if (i == (bytes.length - 1)) {
				val+= bytes[i];
			} else {
				val+= bytes[i] << ((bytes.length - i - 1) * 8);	
			}
		}
		
		return val;
	}
        
        public static long convertMultiByteToLong(byte[] bytes) {
		
		if (bytes.length > 8) {
			throw new IllegalArgumentException("too many bytes can't be converted to long");
		} else if (bytes.length == 8 && ((bytes[0] & 0x80) == 0x80)) {
			// 0x80 == 10000000, 0x7e == 01111111
			throw new RuntimeException("Java long can't support a 8 bytes value, where msb byte greater than 7e");
		}
		
		long val = 0;
		
		for (int i = 0; i < bytes.length; i++) {
			val += 0x000000FF & bytes[i];
			val = val << 8;	
		}
		
		return val;
	}
	
	public static int[] convertInttoMultiByte(int val) {
		
		// must decompose into a max of 4 bytes
		// b1		b2		 b3		  b4
		// 01111111 11111111 11111111 11111111
		// 127      255      255      255
		
		int size = 0;
		
		if ((val >> 24) > 0) {
			size = 4;
		} else if ((val >> 16) > 0) {
			size = 3;
		} else if ((val >> 8) > 0) {
			size = 2;
		} else {
			size = 1;
		}
		
		int[] data = new int[size];
		
		for (int i = 0; i < size; i++) {
			data[i] = (val >> (size - i - 1) * 8) & 0xFF;
		}
		
		return data;	
	}
        
        public static int[] convertLongtoMultiByte(long val) {
		
		int size = 0;
		
		if ((val >> 56) > 0) {
			size = 8;
		} else if ((val >> 48) > 0) {
			size = 7;
		} else if ((val >> 40) > 0) {
			size = 6;
		} else if ((val >> 32) > 0) {
			size = 5;
		} else if ((val >> 24) > 0) {
			size = 4;
		} else if ((val >> 16) > 0) {
			size = 3;
		} else if ((val >> 8) > 0) {
			size = 2;
		} else {
			size = 1;
		}
		
		int[] data = new int[size];
		
		for (int i = 0; i < size; i++) {
			data[i] = (int) ((val >> (size - i - 1) * 8) & 0xFF);
		}
		
		return data;	
	}
	public final static String toBase16(final int[] arr) {
		return toBase16(arr, 0, arr.length);
	}
	
	/**
	 * 
	 *  @since 0.6.0
	 */
	public final static String toBase16(final int[] arr, final int start) {
		return toBase16(arr, start, arr.length);
	}
	
	/**
	 * 
	 *  @since 0.6.0
	 */
	public final static String toBase16(final int[] arr, final int start, final int end) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = start; i < end; i++) {
			sb.append(toBase16(arr[i]));
			
			if (i < arr.length - 1) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * This method convert string that matches the following formats:<ul>
	 * <li>0xfe 0x19 0x44 0x81 0x00</li> 
	 * <li>fe 19 44 81 00</li>
	 * </ul>
	 * to the following array of int<br>
	 * [ 254, 25, 68, 129, 00 ]
	 * 
	 * @param bytes the {@link String} representing the bytes in hex form (as described above)
	 * @return the int array parsed from the argument
	 * @since 0.6.0 - Revision 60
	 */
	public static int[] fromBase16toIntArray(String bytes){
		final String PATTERN = "\\s*((0x[0-9a-f]{2}|[0-9a-f]{2})\\s*)+";
		bytes = bytes.toLowerCase();
		if( bytes.matches(PATTERN) == false ){
			throw new IllegalArgumentException("Unable to parse "+bytes+" doesn't match regex "+PATTERN);
		}
		String[] singleBytes = bytes.split("\\s+");
		String item;
		int[] values = new int[singleBytes.length];
		for (int i = 0; i < singleBytes.length; i++) {
			item = singleBytes[i];
			if ( item.length() == 0 ) 
				continue;
			
			if( item.startsWith("0x") ) {
				item = item.substring(2);
			}
			
			values[i] = (Integer.parseInt(item, 16) & 0xFF);
		}
		return values;
	}
	
	/**
	 * This method return a <code>byte[]</code> from a <code>String</code>. It support the format<br>
	 * of the {@link #toBase16(byte[])} and in general it supports the following {@link Pattern}:<br>
	 * <pre>\s*((0x[0-9a-f]{2}|[0-9a-f]{2})\s*)+</pre>
	 * <b>Exmaple:</b>
	 * <pre>
	 * 0x23 0xab 0xfE 0xDD
	 * 0x23 0xab 0xfe 0xdd
	 * 0x23 ab 0xfE DD
	 * </pre>  
	 * <b>NOTE</b><br>
	 * The main difference with {@link #fromBase16toIntArray(String)} is that the data returned<br>
	 * is signed, so values goes from <code>-128 to 127</code>
	 * 
	 * @param bytes the String representing the bytes in hex form
	 * @return the formatted bytes
	 * @since 0.6.0 - Revision 60 
	 */
	public static byte[] fromBase16toByteArray(String bytes){
		int[] values = fromBase16toIntArray(bytes);
		byte[] returns = new byte[values.length];
		for (int i = 0; i < values.length; i++) {
			returns[i] = (byte) (values[i] & 0xFF);
		}
		return returns;
	}
	
	public static String toBase16(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(toBase16(arr[i]));			
			if (i < arr.length - 1) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	

	public static String toBase2(int[] arr) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			sb.append(toBase2(arr[i]));
			
			if (i < arr.length - 1) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}

	public static String toBase10(int[] arr) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			sb.append((arr[i]));
			
			if (i < arr.length - 1) {
				sb.append(" ");
			}
		}
		
		return sb.toString();
	}
	
	public static String toChar(int[] arr) {
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < arr.length; i++) {
			sb.append((char)arr[i]);
		}
		
		return sb.toString();
	}	
	
	private static String padBase2(String s) {
		
		for (int i = s.length(); i < 8; i++) {
			s = "0" + s;
		}
		
		return s;
	}
	
//	/**
//	 * Determines the bit value of a single byte
//	 * 
//	 * @param b
//	 * @return
//	 */
//	public static boolean[] parseBits(int b) {
//		
//		boolean[] results = new boolean[8];
//		
//		for (int i = 0; i < 8; i++) {
//			if (((b >> i) & 0x1) == 0x1) {
//				results[i] = true;
//			} else {
//				results[i] = false;
//			}
//		}
//	
//		return results;
//	}
	
	/**
	 * Returns true if the bit is on (1) at the specified position
	 * Position range: 1-8
	 */
	public static boolean getBit(int b, int position) {
		
		if (position < 1 || position > 8) {
			throw new IllegalArgumentException("Position is out of range");
		}
		
		if (b > 0xff) {
			throw new IllegalArgumentException("input value is larger than a byte");
		}
		
		if (((b >> (--position)) & 0x1) == 0x1) {
			return true;
		} 
		
		return false;		
	}
	/**
	 * 
	 * @param b the int value to check if it contains a byte representable value
	 * @return true if the value of the int could be expressed with 8 bits
	 * @since 0.8.0
	 */
	public static boolean isByteValue(int b) {
		final boolean valid = ( (b & 0xffffff00) == 0 || (b & 0xffffff00) == 0xffffff00);
		if ( logger.isTraceEnabled() && valid && ( b < -128 || b > 127 ) ) {
			logger.trace(
					"The value {} ({}) is considered a byte because only the 8 least significant bits are set" +
					", but its value is outside signed byte that is between -128 and 127", b, Integer.toHexString(b) 
			);
		}
		return valid;
	}
	
	public static String toBase16(int b) {
		if (! isByteValue(b) ) {
			throw new IllegalArgumentException("Error converting "+b+" input value to hex string it is larger than a byte");
		}
		if ( b < 0) {
			return "0x" + Integer.toHexString(b).substring(6);
		} else if (b < 0x10) {
			return "0x0" + Integer.toHexString(b);
		} else if (b >= 0x10){
			return "0x" + Integer.toHexString(b);			
		} else {
			throw new IllegalArgumentException("Unable to recognize the value "+b);			
		}
	}
	
	public static String toBase2(int b) {
		
		if (b > 0xff) {
			throw new IllegalArgumentException("input value is larger than a byte");
		}
		
		return padBase2(Integer.toBinaryString(b));
	}
	
	public static String formatByte(int b) {
		return "base10=" + Integer.toString(b) + ",base16=" + toBase16(b) + ",base2=" + toBase2(b);
	}
	
	public static int[] stringToIntArray(String s) {
		int[] intArr = new int[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			intArr[i] = (int)s.charAt(i);
		}
		
		return intArr;
	}
	
	/**
	 * Parses a 10-bit analog value from the input stream
	 * 
	 * @param pos relative position in packet (for logging only)
	 * 
	 * @return
	 * @throws IOException
	 */
	public static int parse10BitAnalog(int msb, int lsb) throws IOException {	
		msb = msb & 0xff;
		
		// shift up bits 9 and 10 of the msb
		msb = (msb & 0x3) << 8;
		
//		log.debug("shifted msb is " + msb);
		
		lsb = lsb & 0xff;
		
		return msb + lsb;
	}
		
	public static int parse10BitAnalog(IIntArrayInputStream in, int pos) throws IOException {
		int adcMsb = in.read("Analog " + pos + " MSB");
		int adcLsb = in.read("Analog " + pos + " LSB");
		
		return ByteUtils.parse10BitAnalog(adcMsb, adcLsb);
	}

	
	/**
	 * Parse N-th bit from a byte
	 * 
	 * @param byte from whitch exstract n-th bit
	 * 
	 * @return boolean
	 * 
	 */
	public static boolean getNthBitFromByte(byte thebyte, int position) {

		return (1 == ((thebyte >> position) & 1));

	}
}
