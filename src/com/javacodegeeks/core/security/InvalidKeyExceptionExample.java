package com.javacodegeeks.core.security;

public class InvalidKeyExceptionExample {

	static String PLAIN_TEXT = "Java Code Geeks Rock!\0\0\0\0\0\0\0\0\0\0\0";
	static String ENCRYPTION_KEY = "0123456789abcdef";

	public static void main(String [] args) {
		try {

			System.out.println("Plain text:" + PLAIN_TEXT);

			byte[] cipherText = AESUtils.encrypt(PLAIN_TEXT, ENCRYPTION_KEY);

			System.out.print("Cipher Text:  ");
			for (int i=0; i<cipherText.length; i++)
				System.out.print( String.format("%02X ",cipherText[i]));

			System.out.println("");

			String decrypted = AESUtils.decrypt(cipherText, ENCRYPTION_KEY);

			System.out.println("Decrypted Text: " + decrypted);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}