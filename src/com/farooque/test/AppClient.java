package com.farooque.test;

public class AppClient {
	
	Calculator calculator = new Calculator();

	public static void main(String[] args) {
		if(Calculator.login("das", "fasd")) {
			boolean displayAchaSeHuwaKi = Displayer.display(Calculator.add(12, 432));
			if(displayAchaSeHuwaKi) {
				// dusra kya tu bhi
			}
				//sadasjdasl
		} else {
			System.out.println("Tujhe ijaazat nai");
		}
		
	}
	

}


class Calculator{
	
	static boolean login(String uName, String pass) {
		// check if db has same name and pass
		return true;
	}
	
	static int add(int f, int s) {
//		int f = 12;
//		int s = 15;
		return f + s;
	}

	static int sub(int f, int s) {
		return f - s; 
	}
	
	// dv 
	// mul
	
}

class Displayer{
	
	static boolean display(int kyaToBhi) {
		System.out.println("Sum is : " + kyaToBhi);
		return true;
	}
}

