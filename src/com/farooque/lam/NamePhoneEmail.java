package com.farooque.lam;

// Use map() to create a new stream that contains only
// selected aspects of the original stream.

class NamePhoneEmail extends NamePhone{
	String email;
	
	

	NamePhoneEmail(String n, String p, String e) {
		super(n, p);
		email = e;
	}



	@Override
	public String toString() {
		return "NamePhoneEmail [email=" + email + ", name=" + name + ", phonenum=" + phonenum + "]";
	}
	
}