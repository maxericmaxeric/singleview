package com.ecsolutions.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

public class TripleDES {
	public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	public static final String DES_ENCRYPTION_SCHEME = "DES";
	public static final String SUB_ENCRYPTION_KEY = "Long Long Live chairman Mao!";
	public static final String DEFAULT_ENCRYPTION_KEY = "Long Long Live StevenChen!";

	private KeySpec keySpec;
	private SecretKeyFactory keyFactory;
	private Cipher cipher;

	private static final String UNICODE_FORMAT = "UTF8";

	public TripleDES() throws EncryptionException {
		this(DESEDE_ENCRYPTION_SCHEME, SUB_ENCRYPTION_KEY + DEFAULT_ENCRYPTION_KEY);
	}

	public TripleDES(String encryptionScheme, String encryptionKey) throws EncryptionException {

		if (encryptionKey == null)
			throw new IllegalArgumentException("encryption key was null");
		if (encryptionKey.trim().length() < 24)
			throw new IllegalArgumentException("encryption key was less than 24 characters");

		try {
			byte[] keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);
			keySpec = new DESedeKeySpec(keyAsBytes);

			if (encryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
				keySpec = new DESedeKeySpec(keyAsBytes);
			} else if (encryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
				keySpec = new DESKeySpec(keyAsBytes);
			} else {
				throw new IllegalArgumentException("Encryption scheme not supported: " + encryptionScheme);
			}

			keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
			cipher = Cipher.getInstance(encryptionScheme);

		} catch (InvalidKeyException e) {
			throw new EncryptionException(e);
		} catch (UnsupportedEncodingException e) {
			throw new EncryptionException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new EncryptionException(e);
		} catch (NoSuchPaddingException e) {
			throw new EncryptionException(e);
		}

	}

	public String encrypt(String unencryptedString) throws EncryptionException {
		if (unencryptedString == null || unencryptedString.trim().length() == 0)
			throw new IllegalArgumentException("unencrypted string was null or empty");

		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//byte[] cleartext = unencryptedString.getBytes(UNICODE_FORMAT);
			byte[] cleartext = unencryptedString.getBytes();
			byte[] ciphertext = cipher.doFinal(cleartext);

			BASE64Encoder base64encoder = new BASE64Encoder();
			return base64encoder.encode(ciphertext);
		} catch (Exception e) {
			throw new EncryptionException(e);
		}
	}

	public String decrypt(String encryptedString) throws EncryptionException {
		if (encryptedString == null || encryptedString.trim().length() <= 0)
			throw new IllegalArgumentException("encrypted string was null or empty");

		try {
			SecretKey key = keyFactory.generateSecret(keySpec);
			cipher.init(Cipher.DECRYPT_MODE, key);
			BASE64Decoder base64decoder = new BASE64Decoder();
			byte[] cleartext = base64decoder.decodeBuffer(encryptedString);

			byte[] ciphertext = cipher.doFinal(cleartext);
			//String a = a.getBytes(ciphertext,"UTF-8");
			return new String(ciphertext);
		} catch (Exception e) {
			throw new EncryptionException(e);
		}
	}

	private static String bytes2String(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			stringBuffer.append((char) bytes[i]);
		}
		return stringBuffer.toString();
	}

	public static class EncryptionException extends Exception {
		public EncryptionException(Throwable t) {
			super(t);
		}
	}

	/**
	 * @param args
	 * @throws EncryptionException 
	 */
	public static void main(String[] args) throws EncryptionException {
		TripleDES tri = new TripleDES();
		String ss = tri.encrypt("hsbdb123");
		System.out.println("SSS--->>>" + ss + ",l=" + ss.length());
		String aaa = tri.encrypt("SOLARHSB");
		System.out.println("aaa--->>>" + aaa);

		String pwd = tri.decrypt(ss);
		System.out.println("SSS--->>>" + pwd + ",l=" + pwd.length());
		String urn = tri.decrypt(aaa);
		System.out.println("aaa--->>>" + urn);

		
	}

}

