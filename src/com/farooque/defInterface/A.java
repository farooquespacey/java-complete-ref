package com.farooque.defInterface;

public interface A {
	
	default void get() {
		System.out.println("A get()");
	}

}
