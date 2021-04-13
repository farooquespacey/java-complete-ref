package com.farooque.lam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestMethodRefLam {
	List<String> lis = new ArrayList<>();

	public static void main(String[] args) {
		TestMethodRefLam testMethodRefLam = new TestMethodRefLam();
		testMethodRefLam.someMethod();

	}

	public void someMethod() {
		lis.add("asas");
		lis.add("bas");
		lis.add("cacsa");
		lis.add("dnkl");

		lis.stream().forEach(this::perform);

		getSomethingDone(this::thatRef);
		// .findAny().ifPresent(System.out::println);
		// .orElse("baba");
		// System.out.println(s);

		TriFunction<Sum, String, String, Integer> anon = new TriFunction<Sum, String, String, Integer>() {
			@Override
			public Integer apply(Sum s, String arg1, String arg2) {
				return s.doSum(arg1, arg2);
			}
		};
		System.out.println(anon.apply(new Sum(), "1", "4"));

		TriFunction<Sum, String, String, Integer> lambda = (Sum s, String arg1, String arg2) -> s.doSum(arg1, arg2);
		System.out.println(lambda.apply(new Sum(), "9", "4"));

		TriFunction<Sum, String, String, Integer> mRef = Sum::doSum;
		System.out.println(mRef.apply(new Sum(), "1", "4"));

		System.out.println("=============Shipment=============");

		List<Shipment> l = new ArrayList<Shipment>();
		l.add(new Shipment());
		l.add(new Shipment());
		// Using an anonymous class
		System.out.println(calculateOnShipments(l, new BiFunction<Shipment, Shipment, Double>() {
			public Double apply(Shipment s, Shipment s1) { // The object
				System.out.println("Inside anon " + s + "-=--=-=" + s1);
				return s.calculateWeight(); // The method
			}
		}));

		// Using a lambda expression
		System.out.println(calculateOnShipments(l, (s, s1) -> {
			System.out.println("Inside Lambda " + s + "-=--=-=" + s1);
			return s.calculateWeight();
		}));

		// Using a method reference
		System.out.println(calculateOnShipments(l, Shipment::calculateWeight));

		System.out.println("===============HowToDoInJava========");
		List<String> strings = Arrays.asList("how", "to", "do", "in", "java", "dot", "com");

		List<String> sorted = strings.stream().sorted((s1, s2) -> {
			System.out.println(s1 + "---" + s2);
			return s1.compareTo(s2);
		}).collect(Collectors.toList());

		System.out.println(sorted);

		List<String> sortedAlt = strings.stream().sorted(String::compareTo).collect(Collectors.toList());

		System.out.println(sortedAlt);
	}

	public void getSomethingDone(Something something) {
		something.doThat("baba", "ab", 2);
	}

	public void thatRef(String a, String b, int c) {
		if ((a.length() > c) && (b.length() > c)) {
			System.out.println("I am Grooot!!");
		} else {
			System.out.println("I am Steve!!");
		}
	}

	public void perform(String e) {
		System.out.println("Nope " + e);
	}

	private boolean cont(String s) {
		System.out.println(this.lis.contains(s));
		return this.lis.contains(s);
	}

	public List<Double> calculateOnShipments(List<Shipment> l, BiFunction<Shipment, Shipment, Double> f) {
		System.out.println("CAL");
		Shipment sss = new Shipment();
		List<Double> results = new ArrayList<>();
		for (Shipment s : l) {
			results.add(f.apply(s, sss));
		}
		System.out.println("CALLEnd");
		return results;
	}

}
