package com.farooque.gen;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Two-dimensional coordinates.
class TwoD {
	int x, y;

	TwoD(int a, int b) {
		x = a;
		y = b;
	}
}

class ThreeD extends TwoD {
	int z;

	ThreeD(int a, int b, int c) {
		super(a, b);
		z = c;
	}
}

class FourD extends ThreeD {
	int t;

	FourD(int a, int b, int c, int d) {
		super(a, b, c);
		t = d;
	}
}

// This class holds an array of coordinate objects.
class Coords<T extends TwoD> {
	T[] coords;

	Coords(T[] o) {
		coords = o;
	}

	static void showXY(Coords<?> c) {
		System.out.println("X Y Coordinates:");
		for (int i = 0; i < c.coords.length; i++)
			System.out.println(c.coords[i].x + " " + c.coords[i].y);
		System.out.println();
	}

	public static void main(String... args) {
		TwoD[] d = { new TwoD(1, 4), new TwoD(2, 5) };
		Coords<TwoD> c = new Coords<>(d);
		showXY(c);

		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		System.out.println("original list: " + numbers);
		List<Integer> even = numbers.stream().map(s -> Integer.valueOf(s)).filter(number -> number % 2 == 0)
				.collect(Collectors.toList());
		System.out.println("processed list, only even numbers: " + even);

	}
}
