package com.farooque.lam;

@FunctionalInterface
public interface NumericTest {

	boolean testPos(int n);
	
	default void doSomethingCommon() {
		System.out.println("wubba lubba dub dub");
	}
	
}
