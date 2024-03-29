package com.farooque.io;

import java.io.*;

/**
 * This somewhat contrived example demonstrates how to read three ways, to skip
 * input, and to inspect the amount of data available on a stream.
 * 
 * @author OrionIndia-PC13
 *
 */
class _4FileStreamDemo {
	public static void main(String args[]) {
		int size;
		// Use try-with-resources to close the stream.
		try (FileInputStream f = new FileInputStream(
				"C:\\\\Users\\\\OrionIndia-PC13\\\\Desktop\\\\questionsinJava.txt")) {
			System.out.println("Total Available Bytes: " + (size = f.available()));
			int n = size / 40;
			System.out.println("First " + n + " bytes of the file one read() at a time");
			for (int i = 0; i < n; i++) {
				System.out.print((char) f.read());
			}
			System.out.println("\nStill Available: " + f.available());
			System.out.println("Reading the next " + n + " with one read(b[])");
			byte b[] = new byte[n];
			if (f.read(b) != n) {
				System.err.println("couldn�t read " + n + " bytes.");
			}
			System.out.println(new String(b, 0, n));
			System.out.println("\nStill Available: " + (size = f.available()));
			System.out.println("Skipping half of remaining bytes with skip()");
			f.skip(size / 2);
			System.out.println("Still Available: " + f.available());
			System.out.println("Reading " + n / 2 + " into the end of array");
			if (f.read(b, n / 2, n / 2) != n / 2) {
				System.err.println("couldn�t read " + n / 2 + " bytes.");
			}
			System.out.println(new String(b, b.length / 2, b.length / 2));
			System.out.println("\nStill Available: " + (size = f.available()));
			System.out.println("Reading the rest..");
			byte[] myByte = new byte[size];
			if (f.read(myByte, 0, myByte.length) != size) {
				System.err.println("Nope, Doesn't work");
			}
			System.out.println(new String(myByte, 0, myByte.length));
			System.out.println("\nStill Available: " + (size = f.available()));

		} catch (IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}

class FileOutputStreamDemo {
	public static void main(String args[]) {
		String source = "Now is the time for all good men\n" + " to come to the aid of their country\n"
				+ " and pay their due taxes.";
		byte buf[] = source.getBytes();
		// Use try-with-resources to close the files.
		try (FileOutputStream f0 = new FileOutputStream("file1.txt");
				FileOutputStream f1 = new FileOutputStream("file2.txt");
				FileOutputStream f2 = new FileOutputStream("file3.txt")) {
			// write to first file
			for (int i = 0; i < buf.length; i += 2)
				f0.write(buf[i]);
			// write to second file
			f1.write(buf);
			// write to third file
			f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
		} catch (IOException e) {
			System.out.println("An I/O Error Occurred");
		}
	}
}