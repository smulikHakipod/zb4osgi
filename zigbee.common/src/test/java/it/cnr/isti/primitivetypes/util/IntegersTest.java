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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 *
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi</a>
 * @version $LastChangedRevision$ ($LastChangedDate: 2014-05-13 15:58:12
 *          +0200 (Tue, 13 May 2014) $)
 *
 */
public class IntegersTest {

	@Test
	public void testShortFromInts() {
		assertEquals(0x1020,
				Integers.shortFromInts(new int[] { 0x10, 0x20 }, 0, 1));
		assertEquals(0x2010,
				Integers.shortFromInts(new int[] { 0x10, 0x20 }, 1, 0));
		assertEquals((short) 0x8000,
				Integers.shortFromInts(new int[] { 0x80, 0x00 }, 0, 1));
		assertEquals(
				0x8000,
				(int) Integers.shortFromInts(new int[] { 0x80, 0x00 }, 0, 1) & 0xFFFF);
		assertEquals(0x0080,
				Integers.shortFromInts(new int[] { 0x80, 0x00 }, 1, 0));
	}

	@Test
	public void testLongFromInts() {
		assertEquals(
				0x1020304050607080L,
				Integers.longFromInts(new byte[] { 0x10, 0x20, 0x30, 0x40,
						0x50, 0x60, 0x70, (byte) 0x80 }, 0, 7));
		assertEquals(
				0x8070605040302010L,
				Integers.longFromInts(new byte[] { 0x10, 0x20, 0x30, 0x40,
						0x50, 0x60, 0x70, (byte) 0x80 }, 7, 0));
		assertEquals(
				0x1020304050607080L,
				Integers.longFromInts(new int[] { 0x10, 0x20, 0x30, 0x40, 0x50,
						0x60, 0x70, 0x80 }, 0, 7));
		assertEquals(
				0x8070605040302010L,
				Integers.longFromInts(new int[] { 0x10, 0x20, 0x30, 0x40, 0x50,
						0x60, 0x70, 0x80 }, 7, 0));
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testReadWriteObject() {
		byte[] buffer = new byte[4096];
		Comparable[] original = new Comparable[] {
				// from 1-st to 4-th
				Boolean.TRUE,
				Boolean.FALSE,
				new Byte((byte) 1),
				new Byte((byte) -1),
				// from 5-th to 8-th
				new Short((short) 1),
				new Short((short) -1),
				new Short((short) 256),
				new Short((short) -256),
				// from 9-th to 14-th
				new Integer(1), new Integer(-1), new Integer(256),
				new Integer(-256), new Integer(65536),
				new Integer(-65536),
				// from 15-th to 22-nd
				new Long(1), new Long(-1), new Long(256), new Long(-256),
				new Long(65536), new Long(-65536), new Long(4294967296l),
				new Long(-4294967296l) };
		Comparable[] readback = new Comparable[original.length];
		int idx = 0;
		for (int i = 0; i < original.length; i++) {
			idx += Integers.writeObject(buffer, idx, original[i]);
		}
		idx = 0;
		for (int i = 0; i < readback.length; i++) {
			Comparable[] aux = new Comparable[1];
			idx += Integers
					.readObject(buffer, idx, original[i].getClass(), aux);
			readback[i] = aux[0];
		}

		for (int i = 0; i < original.length; i++) {
			boolean result = original[i].compareTo(readback[i]) == 0;
			assertTrue("Camparison " + (i + 1)
					+ "-th item of original[] with readback[] of type "
					+ original[i].getClass().getName() + " original was "
					+ original[i] + ", but read " + readback[i], result);
			assertEquals("Camparison " + (i + 1)
					+ "-th item of original[] with readback[] of type "
					+ original[i].getClass().getName(), original[i].toString(),
					readback[i].toString());
		}

	}

	@Test
	public void testGetByteAsInteger() {
		int[] data;
		long l;
		short s;

		data = new int[] { 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80 };
		l = 0x8080808080808080L;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByteAsInteger(l, i));
		}

		data = new int[] { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70, 0x80 };
		l = 0x8070605040302010L;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByteAsInteger(l, i));
		}

		data = new int[] { 0x80, 0x80 };
		s = (short) 0x8080;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByteAsInteger(s, i));
		}

		data = new int[] { 0x80, 0x10 };
		s = (short) 0x1080;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByteAsInteger(s, i));
		}

		data = new int[] { 0x10, 0x80 };
		s = (short) 0x8010;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByteAsInteger(s, i));
		}

	}

	@Test
	public void testGetByte() {
		byte[] data;
		long l;
		int y;
		short s;

		data = new byte[] { (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80,
				(byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80 };
		l = 0x8080808080808080L;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(l, i));
		}

		data = new byte[] { 0x10, 0x20, 0x30, 0x40, 0x50, 0x60, 0x70,
				(byte) 0x80 };
		l = 0x8070605040302010L;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(l, i));
		}

		data = new byte[] { (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80 };
		y = 0x80808080;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(y, i));
		}

		data = new byte[] { 0x50, 0x60, 0x70, (byte) 0x80 };
		y = 0x80706050;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(y, i));
		}
		data = new byte[] { 0x10, 0x20, 0x30, 0x40 };
		y = 0x40302010;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(y, i));
		}

		data = new byte[] { (byte) 0x80, (byte) 0x80 };
		s = (short) 0x8080;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(s, i));
		}

		data = new byte[] { (byte) 0x80, 0x10 };
		s = (short) 0x1080;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(s, i));
		}

		data = new byte[] { 0x10, (byte) 0x80 };
		s = (short) 0x8010;
		for (int i = 0; i < data.length; i++) {
			assertEquals("Comparing the " + (i + 1) + "-th byte", data[i],
					Integers.getByte(s, i));
		}

	}

	@Test
	public void testReadWriteByte() {
		byte[] expected = new byte[] { 0, 1, -1, 127, -128 };
		byte[] buffer = new byte[expected.length];
		int idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeByte(buffer, idx, expected[i]);
		}
		for (int i = 0; i < expected.length; i++) {
			byte value = Integers.readByte(buffer, i);
			assertEquals(expected[i], value);
		}
	}

	@Test
	public void testReadWriteShort() {
		short[] expected = new short[] { 0, 1, -1, 256, -256, 1025, -1025 };
		byte[] buffer = new byte[2 * expected.length];
		int idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeShort(buffer, idx, expected[i]);
		}
		for (int i = 0; i < expected.length; i++) {
			short value = Integers.readShort(buffer, i * 2);
			assertEquals(expected[i], value);
		}
	}

	@Test
	public void testReadWriteInt() {
		int[] expected = new int[] { 0, 1, -1, 256, -256, 65793, -65793,
				16843009, -16843009 };
		byte[] buffer = new byte[4 * expected.length];
		int idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeInt(buffer, idx, expected[i]);
		}
		for (int i = 0; i < expected.length; i++) {
			int value = Integers.readInt(buffer, i * 4);
			assertEquals(expected[i], value);
		}
	}

	@Test
	public void testReadWriteLong() {
		int[] expected = new int[] { 0, 1, -1, 256, -256, 65793, -65793,
				16843009, -16843009 };
		byte[] buffer = new byte[8 * expected.length];
		int idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeLong(buffer, idx, expected[i]);
		}
		for (int i = 0; i < expected.length; i++) {
			long value = Integers.readLong(buffer, i * 8, 8);
			assertEquals(expected[i], value);
		}
	}

	@Test
	public void testReadWriteLongSized() {
		int MIN_SIZE = 4;
		int MAX_SIZE = 8;
		int[] expected = new int[] { 0, 1, -1, 256, -256, 65793, -65793,
				16843009, -16843009 };
		byte[] buffer = new byte[8 * expected.length];
		int idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeLong(buffer, idx, expected[i]);
		}
		for (int i = 0; i < expected.length; i++) {
			long value = Integers.readLong(buffer, i * 8, 8);
			assertEquals("failed to readback with K=8", expected[i], value);
		}

		idx = 0;
		for (int i = 0; i < expected.length; i++) {
			idx += Integers.writeLong(buffer, idx, expected[i], 8);
		}
		for (int i = 0; i < expected.length; i++) {
			// TODO:Debug
			// long value = Integers.readLong(buffer, i * 8);
			// assertEquals("failed to write with K=8", expected[i], value);
		}

		for (int k = MAX_SIZE; k < MIN_SIZE; k--) {
			buffer = new byte[k * expected.length];
			idx = 0;
			for (int i = 0; i < expected.length; i++) {
				idx += Integers.writeLong(buffer, idx, expected[i], k);
			}
			for (int i = 0; i < expected.length; i++) {
				long value = Integers.readLong(buffer, i * k, k);
				assertEquals("failed with k=" + k, expected[i], value);
			}
		}
	}

	@Test
	public void testReadWriteInt24bit() {
		byte[] original = new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };
		byte[] single = new byte[3];
		Integers.writeInt24bit(single, 0, -1);

		assertArrayEquals(original, single);

		// broken test
		// TODO:Debug
		// int[] expected = new int[] { 0, 1, -1, 256, -256, 65793, -65793 };
		// byte[] buffer = new byte[3 * expected.length];
		// int idx = 0;
		// for (int i = 0; i < expected.length; i++) {
		// idx += Integers.writeInt24bit(buffer, idx, expected[i]);
		// }
		// for (int i = 0; i < expected.length; i++) {
		// int value = Integers.readInt24bit(buffer, i * 3);
		// assertEquals(expected[i], value);
		// }

	}

	@Test
	public void testInvalidInputGetByte() {
		try {
			Integers.getByte(0L, 8);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByte(0L, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByte(0, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByte(0, 5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByte((short) 0, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByte((short) 0, 3);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testInvalidInputGetByteAsInteger() {
		try {
			Integers.getByteAsInteger(0L, 8);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByteAsInteger(0L, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByteAsInteger(0, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByteAsInteger(0, 5);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByteAsInteger((short) 0, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.getByteAsInteger((short) 0, 3);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testBoolean() {
		assertEquals(Integers.INVALID_OBJECT,
				Integers.readBooleanObject(new byte[] { 13 }, 0));
		assertFalse(Integers.readBoolean(new byte[] { 13 }, 0));
		assertFalse(Integers.readBoolean(new byte[] { 0 }, 0));
		assertTrue(Integers.readBoolean(new byte[] { 1 }, 0));
	}

	@Test
	public void testInvalidInputReadWriteObject() {
		try {
			Integers.writeObject(null, 0, "Not supported object");
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
		try {
			Integers.readObject(null, 0, String.class, new Object[] {});
			fail("IllegalArgumentException expected");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	public void testShortIntLongToBytes() {
		long l = 0x1234L;
		byte[] expShort = new byte[8];
		byte[] expInt24 = new byte[8];
		byte[] expInt = new byte[8];
		byte[] expLong = new byte[8];
		byte[] expVarLong = new byte[8];
		Integers.writeShort(expShort, 0, (short) l);
		Integers.writeInt(expInt, 0, (int) l);
		Integers.writeInt(expInt24, 0, (int) l);
		Integers.writeLong(expLong, 0, l, 8);
		assertArrayEquals(expInt24, expInt);
		assertArrayEquals(expLong, expInt);
		Integers.writeLong(expVarLong, 0, l, 8);
		for (int i = 1; i <= 8; i++) {

			byte[] extractedExpectedInt = Arrays.copyOfRange(expInt,
					expInt.length - i, expInt.length);
			byte[] extractedExpectedLong = Arrays.copyOfRange(expVarLong,
					expVarLong.length - i, expVarLong.length);
			assertArrayEquals(extractedExpectedLong, extractedExpectedInt);
		}
		assertArrayEquals(expShort, expInt);
	}

	@Test
	public void testWriteLongByteOrder() throws Exception {
		long l = 0x123456789ABCDEF0L;
		byte[] expected = new byte[] { (byte) 0xF0, (byte) 0xDE, (byte) 0xBC,
				(byte) 0x9A, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 };
		byte[] test64 = new byte[8];
		// checking full 8 bytes write
		Integers.writeLong(test64, 0, l, 8);
		assertArrayEquals(expected, test64);

		// checking partial write
		for (int i = 1; i <= 8; i++) {
			byte[] test = new byte[i];
			Integers.writeLong(test, 0, l, i);
			byte[] extractedExpected = Arrays.copyOfRange(expected,
					expected.length - i, expected.length);
			assertArrayEquals(extractedExpected, test);
		}
	}

	@Test
	public void testWriteLongByteOrder2() throws Exception {
		BigInteger bi = new BigInteger("FEDCBA9876543210", 16);
		long l = bi.longValue();
		byte[] expected = new byte[] { (byte) 0x10, (byte) 0x32, (byte) 0x54,
				(byte) 0x76, (byte) 0x98, (byte) 0xBA, (byte) 0xDC, (byte) 0xFE };
		byte[] test64 = new byte[8];
		// checking full 8 bytes write
		Integers.writeLong(test64, 0, l, 8);
		assertArrayEquals(expected, test64);

		// checking partial writes
		// byte[] test = new byte[1];
		// byte[] partial = new byte[]{expected[7]};
		// Integers.writeLong(test, 0, l, 1);
		// assertArrayEquals(partial, test);

		// checking partial write
		for (int i = 1; i <= 8; i++) {
			byte[] test = new byte[i];
			Integers.writeLong(test, 0, l, i);
			byte[] extractedExpected = Arrays.copyOfRange(expected,
					expected.length - i, expected.length);
			assertArrayEquals(extractedExpected, test);
		}

	}

}
