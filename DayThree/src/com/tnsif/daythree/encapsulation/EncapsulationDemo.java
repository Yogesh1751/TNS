package com.tnsif.daythree.encapsulation;

public class EncapsulationDemo {

	public static void main(String[] args) {
		
		//object creation 
		OopsConceptDemo obj=new OopsConceptDemo();
		
		obj.setSerialNum(1001);
		obj.setName("Shubham");
		obj.setAge(26);
		
		System.out.println(obj);
		
		System.out.println(obj.getSerialNum());
		System.out.println(obj.getName());
		System.out.println(obj.getAge());
	}
}
