package com.farooque.lam;

import java.util.ArrayList;
import java.util.stream.Stream;

class StreamDemo5 {
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
		System.out.println("James ====");
		// Map just the names and phone numbers to a new stream.
		myList.stream()
		.filter((a) -> a.name.equals("James"))
		.map((a) -> new NamePhone(a.name, a.phonenum))
		.forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});
	}
}