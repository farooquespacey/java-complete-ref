package com.farooque.lam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamDemo7 {
	public static void main(String[] args) {
		Predicate<NamePhoneEmail> aaa = StreamDemo7::checkForName;
		aaa = aaa.or(StreamDemo7::checkForEmail);
		
		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Merry", "555-3333", "bbb@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Marry", "555-3333", "Mary@HerbSchildt.com"));
		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.parallelStream()
				.filter((n) -> {
					return true;
				})
				.filter(aaa)
				.map((a) -> new NamePhone(a.name, a.phonenum));
		// Use collect to create a List of the names and phone numbers.
		List<NamePhone> npList = nameAndPhone.collect(Collectors.toList());
		System.out.println("Names and phone numbers in a List:");
		for (NamePhone e : npList)
			System.out.println(e.name + ": " + e.phonenum);
		// Obtain another mapping of the names and phone numbers.
		nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
		// Now, create a Set by use of collect().
		Set<NamePhone> npSet = nameAndPhone.collect(Collectors.toSet());
		System.out.println("\nNames and phone numbers in a Set:");
		for (NamePhone e : npSet)
			System.out.println(e.name + ": " + e.phonenum);
	}
	
	
	public static boolean checkForName(NamePhoneEmail npE) {
		return npE.name.startsWith("M");
	}
	
	public static boolean checkForEmail(NamePhoneEmail npE) {
		return npE.email.contains("bbb");
	}
}