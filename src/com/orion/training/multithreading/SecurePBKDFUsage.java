package com.orion.training.multithreading;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/*
        This class shows how to use PBKDF2 based password generation.
        Recommended way of storing passwords in databases. Also called as password stretching
*/
public class SecurePBKDFUsage {

	public static String PDKDF_ALGORITHM = "PBKDF2WithHmacSHA1";
	public static int ITERATION_COUNT = 1024;
	public static int SALT_LENGTH = 128;
	public static int DERIVED_KEY_LENGTH = 128;

	public static void main(String args[]) throws UnsupportedEncodingException {

		// Strings are immutatable, so there is no way to change/nullify/modify its
		// content after use. So always, collect and store security sensitive
		// information in a char array instead.
		char[] PASSWORD = args[0].toCharArray();

		String hashedPassword = null;
		try {
			hashedPassword = computePBKDF(PASSWORD);
		} catch (GeneralSecurityException genSecExc) {
			System.out.println(genSecExc.getMessage() + " " + genSecExc.getCause());
			System.exit(1);
		}

		System.out.println("PDKDF2 = " + hashedPassword);
	}

	public static String computePBKDF(char[] password) throws GeneralSecurityException, UnsupportedEncodingException {
		byte[] salt = new byte[SALT_LENGTH];

		SecureRandom secRandom = new SecureRandom();
		secRandom.nextBytes(salt);

		PBEKeySpec keySpec = null;
		try {
			keySpec = new PBEKeySpec(password, salt, ITERATION_COUNT, DERIVED_KEY_LENGTH * 8);
		} catch (NullPointerException nullPointerExc) {
			throw new GeneralSecurityException("Salt " + salt + "is null");
		} catch (IllegalArgumentException illegalArgumentExc) {
			throw new GeneralSecurityException("One of the argument is illegal. Salt " + salt
					+ " is of 0 length, iteration count " + ITERATION_COUNT + " is not positive or derived key length "
					+ DERIVED_KEY_LENGTH + " is not positive.");
		}

		SecretKeyFactory pbkdfKeyFactory = null;

		try {
			pbkdfKeyFactory = SecretKeyFactory.getInstance(PDKDF_ALGORITHM);
		} catch (NullPointerException nullPointExc) {
			throw new GeneralSecurityException("Specified algorithm " + PDKDF_ALGORITHM + "is null");
		} catch (NoSuchAlgorithmException noSuchAlgoExc) {
			throw new GeneralSecurityException("Specified algorithm " + PDKDF_ALGORITHM
					+ "is not available by the provider " + pbkdfKeyFactory.getProvider().getName());
		}

		byte[] pbkdfHashedArray = null;
		try {
			pbkdfHashedArray = pbkdfKeyFactory.generateSecret(keySpec).getEncoded();
		} catch (InvalidKeySpecException invalidKeyExc) {
			throw new GeneralSecurityException("Specified key specification is inappropriate");
		}

		SecretKey aesKey = new SecretKeySpec(pbkdfHashedArray, "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, aesKey, new IvParameterSpec(getInitializationVectorBytes()));

		byte[] result = cipher.doFinal(password.toString().getBytes());
		String finalResult = new String(result, "UTF-8");

		return Base64.getEncoder().encodeToString(finalResult.getBytes());
	}
	
	 private static byte[] getInitializationVectorBytes() {
			byte iv[] = new byte[16];
			 
			SecureRandom secRandom = new SecureRandom() ;
			secRandom.nextBytes(iv); // self-seeded randomizer to generate IV
			 
			return iv;
		}
}