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

package it.cnr.isti.primitivetypes.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * An utility class that contains method for:<br>
 * - creating <b>long</b>, <b>int</b>, and <b>short</b> from <code>int[]</code><br>
 * - extracting a byte configuration from a:<b>long</b>, <b>int</b>, and
 * <b>short</b>
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2013-08-06 18:00:05
 *          +0200 (mar, 06 ago 2013) $)
 * @since 0.1.0
 * @deprecated
 *
 */
public class Integers {

	/**
	 *
	 * @param x
	 *            the long containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte of the representation of x
	 */
	public static final byte getByte(final long x, final int n) {
		switch (n) {
		case 0:
			return (byte) (x & 0x00000000000000FFL);
		case 1:
			return (byte) ((x & 0x000000000000FF00L) >> 8);
		case 2:
			return (byte) ((x & 0x0000000000FF0000L) >> 16);
		case 3:
			return (byte) ((x & 0x00000000FF000000L) >> 24);
		case 4:
			return (byte) ((x & 0x000000FF00000000L) >> 32);
		case 5:
			return (byte) ((x & 0x0000FF0000000000L) >> 40);
		case 6:
			return (byte) ((x & 0x00FF000000000000L) >> 48);
		case 7:
			return (byte) ((x & 0xFF00000000000000L) >> 56);
		default:
			throw new IllegalArgumentException(
					"long is reppresented as 8 bytes,"
							+ " hence value of n must be between 0 and 3: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param x
	 *            the long containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte as int of the representation of x thus it
	 *         returns always value between 0 and 255
	 */
	public static final int getByteAsInteger(final long x, final int n) {
		switch (n) {
		case 0:
			return (int) (x & 0x00000000000000FFL);
		case 1:
			return (int) ((x & 0x000000000000FF00L) >> 8);
		case 2:
			return (int) ((x & 0x0000000000FF0000L) >> 16);
		case 3:
			return (int) ((x & 0x00000000FF000000L) >> 24);
		case 4:
			return (int) ((x & 0x000000FF00000000L) >> 32);
		case 5:
			return (int) ((x & 0x0000FF0000000000L) >> 40);
		case 6:
			return (int) ((x & 0x00FF000000000000L) >> 48);
		case 7:
			return (int) (((x & 0xFF00000000000000L) >> 56) & 0xFF);
		default:
			throw new IllegalArgumentException(
					"long is reppresented as 8 bytes,"
							+ " hence value of n must be between 0 and 3: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param x
	 *            the int containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte as int of the representation of x thus it
	 *         returns always value between 0 and 255
	 * @since 0.2.0
	 */
	public static final int getByteAsInteger(final int x, final int n) {
		switch (n) {
		case 0:
			return (int) (x & 0x000000FF);
		case 1:
			return (int) ((x & 0x0000FF00) >> 8);
		case 2:
			return (int) ((x & 0x00FF0000) >> 16);
		case 3:
			return (int) ((x & 0xFF000000) >> 24);
		default:
			throw new IllegalArgumentException(
					"long is reppresented as 8 bytes,"
							+ " hence value of n must be between 0 and 3: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param x
	 *            the int containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte of the representation of x
	 */
	public static final byte getByte(final int x, final int n) {
		switch (n) {
		case 0:
			return (byte) (x & 0x000000FF);
		case 1:
			return (byte) ((x & 0x0000FF00) >> 8);
		case 2:
			return (byte) ((x & 0x00FF0000) >> 16);
		case 3:
			return (byte) ((x & 0xFF000000) >> 24);
		default:
			throw new IllegalArgumentException(
					"int is reppresented as 4 bytes,"
							+ " hence value of n must be between 0 and 3: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param x
	 *            the short containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte of the representation of x
	 */
	public static final byte getByte(final short x, final int n) {
		switch (n) {
		case 0:
			return (byte) (x & 0x00FF);
		case 1:
			return (byte) ((x & 0xFF00) >> 8);
		default:
			throw new IllegalArgumentException(
					"short is reppresented as 2 bytes,"
							+ " hence value of n must be between 0 and 1: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param x
	 *            the short containing the data
	 * @param n
	 *            the index of the byte to return
	 * @return return the n-th byte as int of the representation of x it returns
	 *         always value between 0 and 255
	 */
	public static final int getByteAsInteger(final short x, final int n) {
		switch (n) {
		case 0:
			return (x & 0x00FF);
		case 1:
			return ((x & 0xFF00) >> 8);
		default:
			throw new IllegalArgumentException(
					"short is reppresented as 2 bytes,"
							+ " hence value of n must be between 0 and 1: you have tryed to use "
							+ n);
		}
	}

	/**
	 *
	 * @param values
	 *            the int[] array containing the data
	 * @param msb
	 *            the index of the most significant byte
	 * @param lsb
	 *            the index of the least significant byte
	 * @return the short decoded from the int[]
	 */
	public static short shortFromInts(int[] values, int msb, int lsb) {
		int value = (values[msb] << 8) + values[lsb];
		return (short) value;
	}

	/**
	 *
	 * @param values
	 *            the byte[] array containing the data
	 * @param msb
	 *            the index of the most significant byte
	 * @param lsb
	 *            the index of the least significant byte
	 * @return the long decoded from the byte[]
	 */
	public static long longFromInts(byte[] values, int msb, int lsb) {
		long result = (values[msb] & 0xFF);
		if (msb < lsb) {
			for (int i = msb + 1; i <= lsb; i++) {
				result = (result << 8) + (values[i] & 0xFF);
			}
		} else {
			for (int i = msb - 1; i >= lsb; i--) {
				result = (result << 8) + (values[i] & 0xFF);
			}
		}
		return result;
	}

	/**
	 *
	 * @param values
	 *            the int[] array containing the data
	 * @param msb
	 *            the index of the most significant byte
	 * @param lsb
	 *            the index of the least significant byte
	 * @return the long decoded from the int[]
	 */
	public static long longFromInts(int[] values, int msb, int lsb) {
		long result = (values[msb] & 0xFF);
		if (msb < lsb) {
			for (int i = msb + 1; i <= lsb; i++) {
				result = (result << 8) + (values[i] & 0xFF);
			}
		} else {
			for (int i = msb - 1; i >= lsb; i--) {
				result = (result << 8) + (values[i] & 0xFF);
			}
		}
		return result;
	}

	// /////////////////////////////////////////////////////////
	// serialization routines to be use for payload management
	// /////////////////////////////////////////////////////////

	final public static class InvalidObject {
	};

	final public static InvalidObject INVALID_OBJECT = new InvalidObject();

	final public static int writeObject(byte[] dest, int pos, Object data) {
		if (data.getClass().equals(Boolean.class)) {
			return writeBooleanObject(dest, pos, (Boolean) data);
		} else if (data.getClass().equals(Byte.class)) {
			return writeByteObject(dest, pos, (Byte) data);
		} else if (data.getClass().equals(Short.class)) {
			return writeShortObject(dest, pos, (Short) data);
		} else if (data.getClass().equals(Integer.class)) {
			return writeIntObject(dest, pos, (Integer) data);
		} else if (data.getClass().equals(Long.class)) {
			return writeLongObject(dest, pos, (Long) data);
		} else {
			throw new IllegalArgumentException("Type "
					+ data.getClass().getName() + " not supported!");
		}
	}

	final public static int readObject(byte[] dest, int pos, Class clazz,
			Object[] result) {
		if (clazz.equals(Boolean.class) || clazz.equals(boolean.class)) {
			result[0] = readBooleanObject(dest, pos);
			return 1;
		} else if (clazz.equals(Byte.class) || clazz.equals(byte.class)) {
			result[0] = readByteObject(dest, pos);
			return 1;
		} else if (clazz.equals(Short.class) || clazz.equals(short.class)) {
			result[0] = readShortObject(dest, pos);
			return 2;
		} else if (clazz.equals(Integer.class) || clazz.equals(int.class)) {
			result[0] = readIntObject(dest, pos);
			return 4;
		} else if (clazz.equals(Long.class) || clazz.equals(long.class)) {
			result[0] = readLongObject(dest, pos);
			return 8;
		} else {
			throw new IllegalArgumentException("Type " + clazz.getName()
					+ " not supported!");
		}
	}

	final public static int writeBooleanObject(byte[] dest, int pos,
			Boolean data) {
		return writeBoolean(dest, pos, data.booleanValue());
	}

	final public static int writeBoolean(byte[] dest, int pos, boolean data) {
		dest[pos] = (byte) (data ? 0x01 : 0x00);
		return 1;
	}

	final public static int writeByteObject(byte[] dest, int pos, Byte data) {
		return writeByte(dest, pos, data.byteValue());
	}

	final public static int writeByte(byte[] dest, int pos, byte data) {
		dest[pos] = data;
		return 1;
	}

	final public static int writeShortObject(byte[] dest, int pos, Short data) {
		return writeShort(dest, pos, data.shortValue());
	}

	final public static int writeShort(byte[] dest, int pos, short data) {
		dest[pos + 1] = (byte) (data >> 8);
		dest[pos] = (byte) ((data << 8) >> 8);
		return 2;
	}

	final public static int writeIntObject(byte[] dest, int pos, Integer data) {
		return writeInt(dest, pos, data.intValue());
	}

	final public static int writeInt(byte[] dest, int pos, int data) {

		ByteBuffer.wrap(dest, pos, 4).order(ByteOrder.LITTLE_ENDIAN)
				.putInt(data);
		return 4;
	}

	final public static int writeLongObject(byte[] dest, int pos, Long data) {
		return writeLong(dest, pos, data.longValue());
	}

	final public static int writeLong(byte[] dest, int pos, long data, int size) {

		ByteBuffer bb = ByteBuffer.wrap(dest, pos, size);
		byte[] bytes = ByteBuffer.allocate(8).putLong(data).array();
		for (int i = 0; i < size; i++)

		{
			bb.put(i + pos, bytes[8 - 1 - i]);

		}

		return size;
	}

	final public static int writeLong(byte[] dest, int pos, long data) {
		return writeLong(dest, pos, data, 8);

	}

	public static Object readBooleanObject(byte[] src, int pos) {
		switch (src[pos]) {
		case 0:
			return Boolean.FALSE;
		case 1:
			return Boolean.TRUE;
		default:
			return INVALID_OBJECT;
		}
	}

	public static boolean readBoolean(byte[] src, int pos) {
		return (src[pos] == 0x01);
	}

	public static Byte readByteObject(byte[] src, int pos) {
		return Byte.valueOf(readByte(src, pos));
	}

	public static byte readByte(byte[] src, int pos) {
		return src[pos];
	}

	public static Short readShortObject(byte[] src, int pos) {
		return Short.valueOf(readShort(src, pos));
	}

	public static short readShort(byte[] src, int pos) {
		return (short) (((src[pos + 1] & 0x000000FF) << 8) + (src[pos] & 0x000000FF));
	}

	public static Integer readIntObject(byte[] src, int pos) {
		return Integer.valueOf(readInt(src, pos));
	}

	public static int readInt(byte[] src, int pos) {

		int result = ByteBuffer.wrap(src, pos, 4)
				.order(ByteOrder.LITTLE_ENDIAN).getInt();
		return result;

	}

	public static Long readLongObject(byte[] src, int pos) {
		return Long.valueOf(readLong(src, pos));
	}

	public static long readLong(byte[] src, int pos, int size) {

		byte[] resultByteArray = new byte[8];
		ByteBuffer bb = ByteBuffer.wrap(src, pos, size);

		for (int i = 0; i < size; i++)

		{
			byte temp = bb.get();
			resultByteArray[8 - i - 1] = temp;

		}

		ByteBuffer buffer = ByteBuffer.wrap(resultByteArray);
		return buffer.getLong();

	}

	public static long readLong(byte[] src, int pos) {
		return readLong(src, pos, 8);

	}

	/**
	 *
	 * @param pos
	 *            the point where to start from reading the 24bit
	 * @param data
	 *            an array of <code>byte</code> that contains the encoded 24bit
	 *            int
	 * @return an <code>int</code> decoded from the data array
	 *
	 * @since 0.2.0
	 */
	public static int readInt24bit(byte[] src, int pos) {

		int[] buffer = new int[3];
		ByteBuffer b = ByteBuffer.wrap(src);
		buffer[0] = b.get(pos + 2);
		buffer[1] = b.get(pos + 1);
		buffer[2] = b.get(pos);

		int result = ((buffer[0] << 24) | (buffer[1] << 16) | (buffer[2] << 8)) >> 8;

		return result;
	}

	/**
	 *
	 * @param dest
	 *            an array of <code>byte</code> that will store the encoded
	 *            24bit int
	 * @param pos
	 *            the point where to start writing the 24bit
	 * @param data
	 *            the 24bit to write on the array
	 * @return the number of byte wrote on the array
	 *
	 * @since 0.2.0
	 */
	public static int writeInt24bit(byte[] dest, int pos, int data) {

		ByteBuffer b = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
		b.putInt(data);
		byte[] result = b.array();

		dest[pos] = (byte) ((result[0]));
		dest[pos + 1] = (byte) ((result[1]));
		dest[pos + 2] = (byte) ((result[2]));

		return 3;
	}

	public static int writeFloat(byte[] dest, int pos, Float data) {
		int bits = Float.floatToIntBits(data);
		dest[pos] = (byte) (bits & 0xff);
		dest[pos + 1] = (byte) ((bits >> 8) & 0xff);
		dest[pos + 2] = (byte) ((bits >> 16) & 0xff);
		dest[pos + 3] = (byte) ((bits >> 24) & 0xff);
		return 4;
	}

}
