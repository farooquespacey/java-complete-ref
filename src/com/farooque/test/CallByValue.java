package com.farooque.test;

public class CallByValue {

	public static void main(String[] args) {
		int i = 12;
		String s = "baba";
		Data d = new Data();
		d.setIn(1);
		d.setStr("Farooque");
		System.out.println("before -> " + i);
		System.out.println("before -> " + s);
		System.out.println("before -> " + d);
		changeVal(i);
		changeVal(s);
		changeDat(d);
		System.out.println("After -> " + i);
		System.out.println("After -> " + s);
		System.out.println("After -> " + d);
	}

	private static void changeVal(int i) {
		System.out.println("Int Op");
		i++;	
	}

	private static void changeVal(String i) {
		System.out.println("String Op");
		i = "abba";
	}

	private static void changeDat(Data d) {
		System.out.println("Data Op");
		d = new Data();
		d.setIn(100);
		d.setStr("Hundred");
	}

}

class Data {
	int in;
	String str;

	public int getIn() {
		return in;
	}

	public void setIn(int in) {
		this.in = in;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "Data [in=" + in + ", str=" + str + "]";
	}

}
