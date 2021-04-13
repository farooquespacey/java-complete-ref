package com.farooque.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _3FileInputStreamTest {
	public static void main(String... args) {
		int i;
		FileInputStream fin;
		// First, confirm that a filename has been specified.
		if (args.length != 1) {
			System.out.println("Usage: ShowFile filename");
			return;
		}
		// Attempt to open the file.
		try {
			fin = new FileInputStream(args[0]);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot Open File");
			return;
		}
		// At this point, the file is open and can be read.
		// The following reads characters until EOF is encountered.
		try {
			do {
				i = fin.read();
				if (i != -1)
					System.out.print((char) i);
				else
					System.out.println("BABA " + (char) i);
			} while (i != -1);
		} catch (IOException e) {
			System.out.println("Error Reading File");
		}
		// Close the file.
		try {
			fin.close();
		} catch (IOException e) {
			System.out.println("Error Closing File");
		}
	}
}
