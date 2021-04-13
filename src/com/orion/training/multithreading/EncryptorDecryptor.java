package com.orion.training.multithreading;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import java.security.spec.KeySpec;

public class EncryptorDecryptor {
	public static void main(String[] args) throws Exception {
		if (args.length == 0) {
			System.out.println("Pass the encrypted string as first value");
			return;
		}
		
		EncryptorDecryptor decrypter = new EncryptorDecryptor();
		String text = decrypter.decrypt(args[0], "MDHMessagingSecret");
		System.out.println("Decrypted value: " + text);
	}
	
	public String decrypt(String payload, String password) throws Exception {
		
		String[] parts = payload.split("--");
		if (parts.length != 3) return null;

		Base64.Decoder decoder = Base64.getDecoder();
		byte[] data = decoder.decode(parts[0]);
		byte[] iv = decoder.decode(parts[1]);
		byte[] salt = decoder.decode(parts[2]);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 1024, 128);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKey aesKey = new SecretKeySpec(tmp.getEncoded(), "AES");

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, aesKey, new IvParameterSpec(iv));

		byte[] result = cipher.doFinal(data);
		return new String(result, "UTF-8");				
	}
}