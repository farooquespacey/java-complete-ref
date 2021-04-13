package com.farooque.lam;
// Java code for Stream map(Function mapper) 
// to get a stream by applying the 
// given function to this stream. 
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors; 

class GFG { 

	// Driver code 
	public static void main(String[] args) 
	{ 

		System.out.println("The stream after applying "
						+ "the function is : "); 

		// Creating a list of Integers 
		List<String> list = Arrays.asList("geeks", "gfg", "g", 
										"e", "e", "k", "s"); 

		
		Function<String, String> uppercaseFun = e -> e.toUpperCase();
		Predicate<String> lengthGreaterthan1 = e -> e.length() == 1;
		
		// Using Stream map(Function mapper) to 
		// convert the Strings in stream to 
		// UpperCase form 
		
		List<String> answer = list.stream().filter(lengthGreaterthan1).map(uppercaseFun). 
		collect(Collectors.toList()); 

		// displaying the new stream of UpperCase Strings 
		System.out.println(answer); 
	} 
} 
