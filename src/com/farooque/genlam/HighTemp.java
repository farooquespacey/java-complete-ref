package com.farooque.genlam;

class HighTemp {
	private int hTemp;
	private String name;

	HighTemp(int ht) {
		hTemp = ht;
	}
	
	HighTemp(int ht, String nm) {
		hTemp = ht;
		name = nm;
	}

	// Return true if the invoking HighTemp object has the same
	// temperature as ht2.
	boolean sameTemp(HighTemp ht2) {
		System.out.println("1:" + this.hTemp);
		System.out.println("2:" + ht2.hTemp);
		return this.hTemp == ht2.hTemp;
	}
	// internally represented if used as
	// "Instance method reference of an object of a particular type"
	// and referenced
//	boolean sameTemp(this, HighTemp ht2) {
//		System.out.println("1:" + this.hTemp);
//		System.out.println("2:" + ht2.hTemp);
//		return this.hTemp == ht2.hTemp;
//	}
	
	
	boolean sameString(String nm) {
		return name.equals(nm);
	}

	// Return true if the invoking HighTemp object has a temperature
	// that is less than ht2.
	boolean lessThanTemp(HighTemp ht2) {
		return hTemp < ht2.hTemp;
	}
}