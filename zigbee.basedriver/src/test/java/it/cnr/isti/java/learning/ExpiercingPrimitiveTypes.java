package it.cnr.isti.java.learning;

/**
 * 
 * @author <a href="mailto:stefano.lenzi@isti.cnr.it">Stefano "Kismet" Lenzi - ISTI-CNR
 *         </a> - Copyright (c) 2008
 * @version $LastChangedRevision$ ($LastChangedDate$)
 * @since 0.1.0
 *
 */
public class ExpiercingPrimitiveTypes {
	
	public static String toDec(long l){
		return Long.toString(l);
	}
	
	public static String toDec(int i){
		return Integer.toString(i);
	}
	
	public static String toDec(short s){
		return Short.toString(s);
	}
	
	public static String toDec(byte b){
		return Byte.toString(b);		
	}

	public static String toHex(long l){
		String hex = Long.toHexString(l);
		while(hex.length()<16){
			hex = "0"+hex;
		}
		return "0x"+hex.toUpperCase();
	}
	
	public static String toHex(int i){
		String hex = Integer.toHexString(i);
		while(hex.length()<8){
			hex = "0"+hex;
		}
		return "0x"+hex.toUpperCase();
	}
	
	public static String toHex(short s){
		String hex = Integer.toHexString(s);
		if(hex.length()>4){
			hex = hex.substring(hex.length()-4);
		}else{
			while(hex.length()<4){
				hex = "0"+hex;
			}
		}
		return "0x"+hex.toUpperCase();
	}
	
	public static String toHex(byte b){
		String hex = Integer.toHexString(b);
		if(hex.length()>2){
			hex = hex.substring(hex.length()-2);
		}else{
			while(hex.length()<2){
				hex = "0"+hex;
			}
		}
		return "0x"+hex.toUpperCase();
	}
	
	public static void testRepresentation(){
		byte b;
		short s;
		int i;
		long l;

		l = 0x1111111111111111L;	i = (int) l;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("l = 0x1111111111111111L;\ti = (int) l;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");

		l = 0xF000F000F000F000L;	i = (int) l;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("l = F000F000F000F000;\ti = (int) l;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");
	
		l = 0xF0F1F2F3F4F5F6F7L;	i = (int) l;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("l = 0xF0F1F2F3F4F5F6F7L;\ti = (int) l;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");
		
		l = 0x01234567F012F0F0L;	i = (int) l;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("l = 0x01234567F012F0F0L;\ti = (int) l;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");

		i = 0x1000F00F;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("i = 0x1000F00F;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");

		i = 0x12344321;	s = (short) i;	b = (byte) s;
		System.out.println("Testing:");
		System.out.println("i = 0x12344321;\ts = (short) i;\tb = (byte) s");
		System.out.println(toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");
		

		b = (byte) 0xF0; l = b;	i = b;	s = b;	
		System.out.println("Testing:");
		System.out.println("l = b\ti = b\ts = b\tb = (byte) 0xF0");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");

		b = -15; l = b;	i = b;	s = b;	
		System.out.println("Testing:");
		System.out.println("l = b\ti = b\ts = b\tb = -15");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");

		b = 15; l = b;	i = b;	s = b;	
		System.out.println("Testing:");
		System.out.println("l = b\ti = b\ts = b\tb = 15");
		System.out.println(toDec(l)+"\t"+toDec(i)+"\t"+toDec(s)+"\t"+toDec(b)+"\t");
		System.out.println(toHex(l)+"\t"+toHex(i)+"\t"+toHex(s)+"\t"+toHex(b)+"\t");
	}
	
	public static void main(String[] args){
		testRepresentation();
	}
	
}
