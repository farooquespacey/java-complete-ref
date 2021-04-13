package com.farooque.lam;

class Shipment {
	
	public Shipment() {
		// TODO Auto-generated constructor stub
		System.out.println("called");
	}
	
	public double calculateWeight() {
		System.out.println("this:- " + this);
		double weight = 0;
		// Calculate weight
		return weight;
	}
	
	public double calculateWeight(Shipment s) {
		System.out.println("this:- " + this + " and " + s);
		double weight = 0;
		// Calculate weight
		return weight;
	}
}