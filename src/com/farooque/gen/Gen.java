package com.farooque.gen;

import java.util.HashMap;
import java.util.Map;

public class Gen<T extends Number> {

	T ob;
	
	Gen(T o) {
		ob = o;
	}
	
	Gen(){}
	
	T getob() {
		return ob;
	}
	
	boolean sameObj(Gen<? extends Float> o2) {
		System.out.println(ob.getClass().getName() + " " + (o2.getob().getClass().getName()));
		return ob.getClass().getName().equals(o2.getob().getClass().getName());
	}
	
	void showType(){
		System.out.println("Type of T is " + ob.getClass().getName());
//		System.out.println("Type of J is " + ob2.getClass().getName());
		
	}
	
}
