package com.farooque.gen;

public class Rhombus {

	public static void main(String... strings) {
		for (int i = 1; i <= 7; i++) {
			int gap = 7 - i;
			int mid = gap / 2;
			for (int j = 0; i < mid; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i; k++) {
				System.out.print(i);
			}

			for (int j = 0; i < mid; j++) {
				System.out.print(" ");
			}
		}
	}

}
