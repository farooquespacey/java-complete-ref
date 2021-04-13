package com.farooque.test;

import java.math.BigInteger;
import java.util.HashSet;

// Immutable complex number class
public final class Complex {
	private final double re;
	private final double im;

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	// copy constructor
	Complex(Complex c) {
		System.out.println("Copy constructor called");
		re = c.re;
		im = c.im;
	}

	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex plus(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex minus(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex times(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex dividedBy(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			System.out.println("Same instance");
			return true;
		}
		if (!(o instanceof Complex))
			return false;
		System.out.println("Here");
		Complex c = (Complex) o;
		// See page 47 to find out why we use compare instead of ==
		return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
	}

	@Override
	public int hashCode() {
		System.out.println("Called");
		return 31 * Double.hashCode(re) + Double.hashCode(im);
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}
	
	
	public static void main(String[] args) {
		Complex complex = new Complex(12, 131);
		String s1 = new String("farooque");
		System.out.println(complex);
		Complex complex2 = new Complex(12, 131);
		String s2 = new String("farooque");
		HashSet<Complex> cMap = new HashSet<>();
		cMap.add(complex);
		cMap.add(complex2);
		System.out.println("Added");
		HashSet<String> sMap = new HashSet<>();
		sMap.add(s1);
		sMap.add(s2);
		System.out.println(cMap.size());
		System.out.println(complex.equals(complex2));
		System.out.println(complex.hashCode() + " " + complex2.hashCode());
		System.out.println(sMap.size());
		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode() + " " + s2.hashCode());
	}
}