package com.farooque.gen;

import java.util.HashMap;
import java.util.Map;

public class GenMain {
	
	public static void main(String... args) {
		HashMap<String, Integer> mp = new HashMap<>();
		mp.put("asasas", 789);
		mp.put("dasdasd", 80);
		String str = "faroo";
		Gen<Integer> g = new Gen<>(2);
		Gen<Float> h = new Gen<>(new Float(332));
		
		System.out.println(g.getob());
		System.out.println(h.getob());
		if(g.sameObj(h)) System.out.println("SAME");
		else System.out.println("NOT SAME");
		g.showType();
		System.out.println(isIt("sa"));
	}
	
	<T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y, String s) {
		for(int i=0; i < y.length; i++)
			if(x.equals(y[i])) return true;
		return false;
	}
	
	static <T extends String> boolean isIt(T s) {
		return s.contains("");
	}

}
