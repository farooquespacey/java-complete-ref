package com.farooque.regex;

import java.util.HashSet;
import java.util.Set;
// Use a quantifier.
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpr4 {
	public static void main(String args[]) {
		Pattern pat = Pattern.compile("W+");
		Matcher mat = pat.matcher("WWWWW");
		System.out.println(Pattern.matches("W+", "WWWWW WWWWWWWW WWWWWWWWWWWWWW"));
		System.out.println(mat.matches());
		while (mat.find())
			System.out.println("Match: " + mat.group());

		System.out.println("++++++++++++++++++++++++++++++");

		Set<String> hash_Set = new HashSet<String>();

		hash_Set.add("PDI_SERVER#PDI_PROJECT#fw-jb_set_dev_env#sv-framework[1407]");

		String req = "^(\\S+?#)+" + Pattern.quote("sv-framework") + "(\\[" + Pattern.quote("1407") + "\\])$";
		Pattern p = Pattern.compile(req);
		boolean match = hash_Set.stream().anyMatch(w -> {
			Matcher mmm = p.matcher(w);
			while(mmm.find()) {
				System.out.println(mmm.group(1));
			}
			return p.matcher(w).matches();
		});
		System.out.println(match);
	}

}