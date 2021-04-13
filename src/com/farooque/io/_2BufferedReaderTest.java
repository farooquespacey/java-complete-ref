package com.farooque.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class _2BufferedReaderTest {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println("Reads typed character, type 'q' to quit");

		char c;
		do {
			c = (char) br.read();
			System.out.println(c);
		} while (c != 'q');

		// String s;
		// do {
		// s = br.readLine();
		// System.out.println(s);
		// } while (!s.equals("stop"));

		// Write using byte-stream
		// int b;
		// b = 'A';
		// System.out.write(b);
		// System.out.write('\n');

		// Write using character-stream
		// PrintWriter pw = new PrintWriter(System.out, true);
		// pw.println("sda");
		// pw.println("asd");
		
		
	}

}
