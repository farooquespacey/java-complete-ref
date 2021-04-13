package com.farooque.lam;

class NamePhone {
	String name;
	String phonenum;

	NamePhone(String n, String p) {
		name = n;
		phonenum = p;
	}

	@Override
	public String toString() {
		return "NamePhone [name=" + name + ", phonenum=" + phonenum + "]";
	}
	
	
}