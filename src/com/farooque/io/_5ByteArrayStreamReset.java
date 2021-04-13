package com.farooque.io;

import java.io.*;

class _5ByteArrayStreamReset {
	public static void main(String args[]) {
		String tmp = "abc";
		byte b[] = tmp.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(b);
		// for (int i = 0; i < 2; i++) {
		// int c;
		// while ((c = in.read()) != -1) {
		// System.out.print("Loop of " + i + " - ");
		// if (i == 0) {
		// System.out.print((char) c + ", ");
		// } else {
		// System.out.print(Character.toUpperCase((char) c) + ", ");
		// }
		// }
		// System.out.println();
		// in.reset();
		// }

		// Using previous file logic
		int size;
		int avail;
		byte[] bb = new byte[(size = in.available())];
		for (int i = 0; i < 2; i++) {
			if ((avail = in.read(bb, 0, size)) == size) {
				System.out.print("Loop of " + i + " - ");
				if (i == 0) {
					System.out.print(new String(bb));
				} else {
					System.out.print(new String(bb).toUpperCase());
				}
			} else {
				System.err.println("Error reading from byte. Found only " + avail + " to read.");
			}
			System.out.println();
			in.reset();
		}

	}
}

// Demonstrate ByteArrayOutputStream.
// This program uses try-with-resources. It requires JDK 7 or later.
class ByteArrayOutputStreamDemo {
	public static void main(String args[]) {
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		String s = "This should end up in the array";
		byte buf[] = s.getBytes();
		try {
			f.write(buf);
		} catch (IOException e) {
			System.out.println("Error Writing to Buffer");
			return;
		}
		System.out.println("Buffer as a string");
		System.out.println(f.toString());
		System.out.println("Into array");
		byte b[] = f.toByteArray();
		for (int i = 0; i < b.length; i++)
			System.out.print((char) b[i]);
		System.out.println("\nTo an OutputStream()");
		// Use try-with-resources to manage the file stream.
		try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
			f.writeTo(f2);
		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
			return;
		}
		System.out.println("Doing a reset");
		f.reset();
		for (int i = 0; i < 3; i++)
			f.write('X');
		System.out.println(f.toString());
	}
}