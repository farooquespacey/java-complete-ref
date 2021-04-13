package com.farooque.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cpu_Mem_Usage {

	public static void main(String[] args) throws IOException {
//		String strPat = "(.*29130?\\s+)(.*?)(\\s+)(.*?)(\\s)"; // 2 & 4
//		Pattern patToCheckForCurrVersion = Pattern.compile(strPat);
//		File fileToEst = new File("C:\\Users\\OrionIndia-PC13\\Desktop\\airflow_case\\cpu_mem_usage.txt");
//		System.out.println(calculateUsage(fileToEst, patToCheckForCurrVersion));
		
		String patternToSplitUp = "^(USER)(\\s+)(.*?)(\\s+)(.+?)(\\s+)(.+?)(\\s)";
		String patternToAddUp = "^(.+?)(\\s+)(.*?)(\\s+)(.+?)(\\s+)(.+?)(\\s)"; // 5 & 7
		Pattern patToSplitUp = Pattern.compile(patternToSplitUp);
		Pattern patToAddUp = Pattern.compile(patternToAddUp);
		File airFileToEst = new File("C:\\Users\\OrionIndia-PC13\\Desktop\\airflow_case\\cpu_mem_iowaits_airflow_10files_4gb_min60_g1gc.txt");
		System.out.println(calculateAirUsage(airFileToEst, patToSplitUp, patToAddUp));
//		String json = "{\r\n" + 
//				"\"key\" : \"value\"\r\n" + 
//				"}";
//		File file = new File("simpleJson.json");
//		file.createNewFile();
	}

	public static String calculateUsage(File fileToEst, Pattern patToCheckFor) throws FileNotFoundException {
		int count = 0;
		double cpuTotal = 0;
		double memTotal = 0;
		try (Scanner scanner = new Scanner(fileToEst)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Matcher mat = patToCheckFor.matcher(line);
				if (mat.find()) {
					++count;
					cpuTotal += Double.parseDouble(mat.group(2));
					memTotal += Double.parseDouble(mat.group(4));
				}
			}
		}
		System.out.println(count);
		return cpuTotal/count + "->" + memTotal/count;
	}
	
	public static String calculateAirUsage(File fileToEst, Pattern patToSplitUp, Pattern patToAddUp) throws FileNotFoundException {
		int count = 0;
		double cpuTotal = 0;
		double memTotal = 0;
		try (Scanner scanner = new Scanner(fileToEst)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.contains("%iowait")) {
					break;
				}
				Matcher mat = patToAddUp.matcher(line);
				Matcher matToSpl = patToSplitUp.matcher(line);
				if(matToSpl.find()) {
					++count;
				}
				else if (mat.find()) {
					System.out.println(line);
					cpuTotal += Double.parseDouble(mat.group(5));
					memTotal += Double.parseDouble(mat.group(7));
				}
			}
		}
		System.out.println(count);
		return cpuTotal/count + "->" + memTotal/count;
	}

}
