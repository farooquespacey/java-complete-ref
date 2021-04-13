package com.farooque.lam;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamDemo5Chnged {
	public static void main(String[] args) {
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));
		System.out.println("Original values in myList: ");
		myList.stream().forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum + " " + a.email);
		});
		System.out.println();
		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().filter((a) -> a.name.equals("James"))
				.peek((a) -> System.out.println(a.name.concat("baba"))).map((a) -> new NamePhone(a.name, a.phonenum));
		System.out.println("List of names and phone numbers: ");
		nameAndPhone.forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});

		System.out.println();
		Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
				.peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
				.peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());

		int[][] values = new int[3][3];
		
		/*for (int i = 0; i < values.length; i++) {
			for (int k = 0; k < values[i].length; k++) {
				values[i][k] = new Random().nextFloat();
				// do something with i, k and value
			}
		}*/

		/*
		 * for (int i = 0; i < values.length; i++) { for (int k = 0; k <
		 * values[i].length; k++) { float value = values[i][k]; // do something with i,
		 * k and value System.out.println(value); } }
		 */
		System.out.println(values[0][0]);
		loopToSet(values, (a, b) -> new Random().nextInt());
		System.out.println("after " + values[0][0] );
		loopToGet(values, (i, k) -> {
			int value = values[i][k];
			// do something with i, k and value
			System.out.println(value);
		});

	}

	private static void loopToGet(int[][] values, BiConsumer<Integer, Integer> consumer) {
		for (int i = 0; i < values.length; i++) {
			for (int k = 0; k < values[i].length; k++) {
				consumer.accept(i, k);
			}
		}
	}
	
	
	private static void loopToSet(int[][] values, BiFunction<Integer, Integer, Integer> biFunction) {
		for (int i = 0; i < values.length; i++) {
			for (int k = 0; k < values[i].length; k++) {
				values[i][k] = biFunction.apply(i, k);
			}
		}
	}
}