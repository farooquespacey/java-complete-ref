package com.farooque.test;

import java.lang.reflect.Array;

public class Main1 {

	public static void main(String[] args) {
		A first = new A();
		first.name = "abc";
		A second = new A();
		second.name = "abc";
		B b = new B();
		System.out.println(first.equals(first));
		System.out.println(first.equals(b));
		System.out.println(first.equals(second));
		
		String user = "skhandelw\\al";
		System.out.println(user.replaceFirst(".*?\\\\", ""));
		String[] s = (String[])Array.newInstance(String.class, 32);
		s[1] = "sdasdsa";
		System.out.println(s[1]);
	}

}
class B{
	
}

class A {
	String name;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof A) {
			A tmp = (A) obj;
			if (this == tmp) {
				System.out.println("Same reference");
				return true;
			} else {
				System.out.println("Same stuff");
				return this.name.equals(tmp.name);
			}
		} else {
			System.out.println("Wrong obj");
			return false;
		}
	}

}
