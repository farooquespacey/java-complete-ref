package com.farooque.io;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;

public class _1IOMain {

	public static void main(String[] args) {
		String n = "C:\\Users\\OrionIndia-PC13\\Desktop\\questionsinJava.txt";
		File f = new File(n);
		// for(String s : f.getParentFile().list()) {
		// System.out.println(s);
		// }

		// usage of FilenameFilter with list()
		// File f2 = f.getParentFile();
		// for (String s1 : f2.list((fil, fname) -> {
		// return fname.endsWith(".txt");
		// })) {
		// System.out.println(s1);
		// }

		// usage of FilenameFilter with listFiles()
		// File f2 = f.getParentFile();
		// for (File s1 : f2.listFiles((fil, fname) -> {
		// return fname.endsWith(".txt");
		// })) {
		// System.out.println(s1);
		// }

		// usage of FileFilter with listFiles()
		// File f3 = f.getParentFile();
		// for (File s1 : f3.listFiles((tmpfil) -> {
		// return tmpfil.isDirectory();
		// })) {
		// System.out.println(s1);
		// }
		
		
		
		

	}

}
