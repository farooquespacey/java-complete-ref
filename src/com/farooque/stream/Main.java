package com.farooque.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		// Remember, intermediate operations are lazy op, they only
		// perform their opretaion once the terminal op is called

		for (int i = 0; i < 5; i++) {
			Set<Integer> seen1 = Collections.synchronizedSet(new HashSet<>());
			// Set<Integer> seen1 = new HashSet<>();
			IntStream stream1 = IntStream.of(1, 2, 1, 2, 3, 4, 4, 5);
			int sum = stream1.parallel().map(
					// stateful behavioral parameter.
					e -> {
						if (seen1.add(e))
							return e;
						else
							return 0;
					}).sum();
			System.out.println(sum);
		}

		List<Integer> data = Collections.synchronizedList(new ArrayList<>());
		Arrays.asList(1, 2, 3, 10, 5, 6, 7).parallelStream().map(i -> {
			data.add(i);
			return i;
		}) // AVOID STATEFUL LAMBDA EXPRESSIONS!
				.forEachOrdered(i -> System.out.print(i + " "));
		System.out.println();
		for (int e : data) {
			System.out.print(e + " ");
		}
		System.out.println();

		List<Person> list = new ArrayList<>();
		list.add(new Person(100, "Mohan"));
		list.add(new Person(200, "Sohan"));
		list.add(new Person(300, "Mahesh"));
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
		map.forEach((x, y) -> System.out.println("Key: " + x + ", value: " + y));

		// A list of double values.
		ArrayList<Double> myList1 = new ArrayList<>();
		myList1.add(7.0);
		myList1.add(18.0);
		myList1.add(10.0);
		myList1.add(24.0);
		myList1.add(17.0);
		myList1.add(5.0);
		// Map the square root of the elements in myList to a new stream.
		Stream<Double> sqrtRootStrm = myList1.stream().map((a) -> Math.sqrt(a));
		// Find the product of the square roots.
		double productOfSqrRoots = sqrtRootStrm.reduce(1.0, (a, b) -> a * b);
		System.out.println("Product of square roots is " + productOfSqrRoots);

		// A list of names, phone numbers, and e-mail addresses.
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Larry", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("James", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Mary", "555-3333", "Mary@HerbSchildt.com"));
		// Map just the names and phone numbers to a new stream.
		Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
		List<NamePhone> npList = nameAndPhone.collect(LinkedList::new, (list_, element) -> list_.add(element),
				(listA, listB) -> listA.addAll(listB));
		for (NamePhone n : npList) {
			System.out.println(n);
		}
		
		
		
		// Create a list of Strings.
		ArrayList<String> strList = new ArrayList<>( );
		strList.add("Al:pha");
		strList.add("Be:ta");
		strList.add("Ga:mma");
		strList.add("De:lta");
		strList.add("Ph:i");
		strList.add("Om:ega");
		// Obtain a Stream to the array list.
		Stream<String> stringStartsWithA = strList.stream();
		List<String> listA = new ArrayList<>();
		List<String> listB = new ArrayList<>();
		stringStartsWithA.forEach(e -> {
			String[] seperatedWithColon = e.split(":");
			listA.add(seperatedWithColon[0]);
			listB.add(seperatedWithColon[1]);
			});
		System.out.println("=-=============================");
		listA.forEach(System.out::println);
		System.out.println("--------------------------------");
		listB.forEach(System.out::println);
		System.out.println("=-=============================");
		
		// Obtain a Stream to the array list.
		Stream<String> myStream = strList.stream();
		// Obtain a Spliterator.
		Spliterator<String> splitItr = myStream.spliterator();
		// 1.Iterate the elements of the stream.
		while(splitItr.tryAdvance((n) -> System.out.println(n)));
		// 2.Loop without looping
		splitItr.forEachRemaining((n) -> System.out.println("foRemain " + n));
		// Now, split the first iterator.
		Spliterator<String> splitItr2 = splitItr.trySplit();
		// 3.If splitItr could be split, use splitItr2 first.
		if(splitItr2 != null) {
		System.out.println("Output from splitItr2: ");
		splitItr2.forEachRemaining((n) -> System.out.println(n));
		}
		// Now, use the splitItr.
		System.out.println("\nOutput from splitItr: ");
		splitItr.forEachRemaining((n) -> System.out.println(n));
	}

}
