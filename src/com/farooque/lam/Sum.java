package com.farooque.lam;

class Sum {
	Integer doSum(String s1, String s2) {
		System.out.println(this.getClass().getSimpleName());
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}
	
	
	static Integer doSumm(Sum s, String arg1, String arg2) {
		System.out.println("BABA");
		return 258;
	}
}