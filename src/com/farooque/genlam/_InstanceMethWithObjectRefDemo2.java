package com.farooque.genlam;

public class _InstanceMethWithObjectRefDemo2 {

	// A method that returns the number of occurrences
	// of an object for which some criteria, as specified by
	// the MyFunc parameter, is true.
	static <T> String counter(String[] vals, MyFunc2 f, String v) {
		String result = "";
		for (int i = 0; i < vals.length; i++) {
			result += f.func(v, vals[i]) + "-";
		}
		return result;
	}

	public static void main(String args[]) {
		String result;
		// Create an array of HighTemp objects.
		String[] weekDayHighs = { new String("80"), new String("82"), new String("90"), new String("89"),
				new String("89"), new String("91"), new String("84"), new String("83") };
		// Use counter() with arrays of the class HighTemp.
		// Notice that a reference to the instance method
		// sameTemp() is passed as the second argument.
		result = counter(weekDayHighs, String::concat, new String("89"));
		System.out.println("Result " + result);
	}
}