package com.farooque.regex;

// Use wildcard and quantifier.
import java.util.regex.*;

class RegExpr5 {
	public static void main(String args[]) {
		String in = "    {\r\n" + 
				"                \"text\": \"<@UBNNX0UA3>\",\r\n" + 
				"                \"user\": \"farooque.aslam\",\r\n" + 
				"                \"timestamp\": \"154951";
		Pattern pat = Pattern.compile("(<@)(\\S+)(>)");
		
		Matcher mat = pat.matcher(in);
//		while(mat.find()) {
			String found = mat.group(2);
			in = in.replaceAll(found, "baba");
//		}
		System.out.println(in);
//		while (mat.find())
//			System.out.println("Match: " + mat.group());
	}
}