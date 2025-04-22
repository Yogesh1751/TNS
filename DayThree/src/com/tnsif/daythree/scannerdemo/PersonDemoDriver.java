package com.tnsif.daythree.scannerdemo;

import java.util.Scanner;

public class PersonDemoDriver {

	public static void main(String[] args) {

		Scanner ob=new Scanner(System.in);
		
		String name;
		System.out.println("Enter Person Name :");
		name=ob.next();
		System.out.println("Enter age :");
		int age = ob.nextInt();
		System.out.println("enter gender :");
		String gender = ob.next();
		System.out.println("Enter income ");
		int income = ob.nextInt();
		
		Person person=new Person();
		person.setName(name);
		person.setGender(gender);
		person.setAge(age);
		person.setIncome(income);
		
		System.out.println(person);
		
		Taxcalculation calc=new Taxcalculation();
		calc.calculateTax(person);
		System.out.println("After calculation tax :");
		
		System.out.println(person);
		
		
		
		
		
		
		
		
		
	}

}
