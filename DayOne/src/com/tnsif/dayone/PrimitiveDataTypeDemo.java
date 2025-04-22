package com.tnsif.dayone;

public class PrimitiveDataTypeDemo {

	public static void main(String[] args) {

		//byte takes 1 byte
		byte byteMax=127;
		byte byteMin=-128;
		
		System.out.println("Min range of byte is "+ byteMin);
		System.out.println(" Max range of byte is "+byteMax);		
		
		//short takes 2 byte 

		short shortMax=32767;
		short shortMin=	-32768;	
		System.out.println("Min range of short is "+ shortMin);
		System.out.println(" Max range of short is "+shortMax);		
		
		//integer 4 byte 
		int intMax=2147483647;
		int intMin=-2147483648;	
		System.out.println("Min range of int is "+ intMin);
		System.out.println(" Max range of int is "+intMax);		

		//long 8 byte
		
		long longMax=9223372036854775807L;
		long longMin=-9223372036854775808L;
		System.out.println("Min range of long is "+ longMin);
		System.out.println(" Max range of long is "+longMax);
		
		float f=3234.141243278345f;
		double d=3456.14124512345678902345678914d;
		
		System.out.println("float value is :"+f);
		System.out.println("Double value is :"+d);
		
		//boolean
		boolean flag=false;
		System.out.println("boolean value is :"+ flag);

		
		
	}

}
