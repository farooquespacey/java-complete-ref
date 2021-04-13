package com.farooque.io;
// Demonstrate unread(). 

// This program uses try-with-resources. It requires JDK 7 or later. 

import java.io.*;

class _7PushbackInputStreamDemo {
	public static void main(String args[]) {
		System.out.printf("faroo%sque", "das");
		System.out.println();
		String s = "if (a == 4) a = 0;\n";
		byte buf[] = s.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int c;

		try (PushbackInputStream f = new PushbackInputStream(in, 64)) {
			while ((c = f.read()) != -1) {
				switch (c) {
				case '=':
					if ((c = f.read()) == '=')
						System.out.print(".eq.");
					else {
						System.out.print("<-");
						f.unread(c);
					}
					break;
				default:
					System.out.print((char) c);
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}