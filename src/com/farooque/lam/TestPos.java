package com.farooque.lam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestPos {

	public static void main(String[] args) {

		List<Double> myList = new ArrayList<>();
		List<String> strList = new ArrayList<>();

		strList.add("aaa");
		strList.add("bbb");
		strList.add("vvv");

		myList.add(2.0);
		myList.add(6.0);
		myList.add(12.0);
		myList.add(4.0);
		myList.add(9.0);
		// myList.add(8.0);
		System.out.println(myList);
		// Double db = new Double(1.0);
		// myList.forEach(e -> {double d});

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> squares = numbers.stream().map(i -> i * i).collect(Collectors.toList());
		
		Optional<Double> optionalAdd = myList.parallelStream().reduce((n, m) -> n + m);
		optionalAdd.ifPresent(System.out::println);

		System.out.println(myList.parallelStream().reduce(0.0, (n, m) -> n + m));

		Optional<Double> minVal = myList.parallelStream().min(Double::compare);
		System.out.println(minVal.get());

		Stream<Double> myLstStrm = myList.stream().sorted().filter(n -> (n % 2) == 1).filter(n -> n < 500);

		// Stream<Integer> mySrtdLst = myLstStrm.distinct();
		myLstStrm.forEach(e -> System.out.print(e + ", "));
		// if (n > 500)
		// return true;
		// else
		// return false;
		// });
		// System.out.println(mySrtdLst);

		// System.out.println(myListStrm);

		NumericTest num = n -> n >= 0;

		// System.out.println(num.testPos(-1));

		// System.out.println(thatMethod((n) -> Integer.parseInt(n)));

		Function<String, String> test = TestPos::get;
		// System.out.println(test.apply("Farooque"));

	}

	public static <T, R> Integer thatMethod(Function<String, Integer> s) {
		return s.apply("2");
	}

	public static String get(String a) {
		return "fa";
	}

}
