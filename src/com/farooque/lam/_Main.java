package com.farooque.lam;

import java.util.function.Function;

public class _Main {
	
	String stringInstance;

	public static void main(String[] args) {
		Function<String, String> function = (s) -> "The dev name is " + s;  
		Function<String, NamePhone> namePhoneFunction = (result) -> new NamePhone(result, "");
		NamePhone namePhone = function.andThen(namePhoneFunction).apply("farooque");
		System.out.println(namePhone);
		
		
		NumericTest isEven = (n) -> (n % 2) == 0;
		System.out.println(isEven.testPos(32));
		
		
		// this comparision for lamdba and anonymous
		_Main main = new _Main();
		main.stringInstance = "bob";
		// 1. lambda
		main.someMethodHavingLambdaInIt();
		// 2. Anon
		Function<String, String> fun = new Function<String, String>() {
			@Override
			public String apply(String t) {
				System.out.println(this.getClass().getSimpleName());
				return "noop";
			}
		};
		System.out.println(fun.apply("for anonymous"));
		// =========================================
		
	}
	
	public void someMethodHavingLambdaInIt() {
		int counter = 1;
		Function<String, String> function = (s) -> "(" + this.stringInstance + ":" + counter + ") The dev name is " + s;  
		System.out.println(function.apply("for lambda"));
		
		printThatCounterHere(function);
	}
	
	public void printThatCounterHere(Function<String, String> f) {
		System.out.println(f.apply("for lambda counter"));
	}

}
