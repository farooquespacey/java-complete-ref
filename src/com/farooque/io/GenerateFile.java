package com.farooque.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerateFile {

	public static void main(String[] args) throws IOException {
		StringBuilder inp = new StringBuilder();
		try(Scanner scanner = new Scanner(new File("C:\\Users\\OrionIndia-PC13\\Desktop\\airflow_case\\wf_airflow_test.xml"))){
			while(scanner.hasNextLine()) {
				inp.append(scanner.nextLine() + "\n");
			}
		}
		for(int i=1; i <= 100; i++) {
			String tmp = null;
			File file = new File("C:\\Users\\OrionIndia-PC13\\eclipse-workspace\\transform\\co\\wf_airflow_test" + i + ".xml");
			FileWriter fw = new FileWriter(file);
			tmp = inp.toString().replace("REP_UAT", "REP_UAT" + i);
			fw.write(tmp);
			System.out.println("Over");
			fw.close();
		}
		
	}

}
