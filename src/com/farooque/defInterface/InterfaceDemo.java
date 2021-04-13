package com.farooque.defInterface;

public class InterfaceDemo implements A, B{

	public static void main(String[] args) {
		InterfaceDemo interfaceDemo = new InterfaceDemo();
		interfaceDemo.get();
	}

	@Override
	public void get() {
		System.out.println("SD");
	}

	

}
