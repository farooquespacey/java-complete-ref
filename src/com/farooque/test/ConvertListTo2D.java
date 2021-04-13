package com.farooque.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertListTo2D {

	public static void main(String[] args) {
		Coords coords = new Coords(12, 945);
		Coords coords2 = new Coords(14, 872);
		Coords coords3 = new Coords(62, 642);
		Coords coords4 = new Coords(42, 452);
		Coords coords5 = new Coords(17, 645);

		List<Coords> lis = new ArrayList<>();
		lis.add(coords);
		lis.add(coords2);
		lis.add(coords3);
		lis.add(coords4);
		lis.add(coords5);

		double[][] pos = new double[lis.size()][2];
		// for(int i=0; i<lis.size();i++) {
		// pos[i][0] = lis.get(i).x;
		// pos[i][1] = lis.get(i).y;
		// }

		int[][] arr = lis.stream().map(coord -> new int[] { coord.x, coord.y }).toArray(int[][]::new);
		// Arrays.asList(arr).forEach(e -> System.out.println(e[0] + " -> " + e[1]));

		int[] carr = lis.stream().mapToInt(coo -> coo.x).toArray();
//		Arrays.asList(carr).forEach(e -> System.out.println(e + " -> "));
		System.out.println(carr[0]);
	}

	static class Coords {
		public int x;
		public int y;

		public Coords(int val, int val2) {
			x = val;
			y = val2;
		}

	}
}
