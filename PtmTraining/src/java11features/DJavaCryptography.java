package java11features;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.NamedParameterSpec;

//Java Cryptography
//It replaced ECDH scheme with
//Curve25519 and Curve448

public class DJavaCryptography {
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
//		alternatively: 
//		kpg = KeyPairGenerator.getInstance("X25519");
		NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
		kpg.initialize(paramSpec);
		//OR kpg.initialize(255);
		KeyPair kp = kpg.generateKeyPair();
		
		System.out.println("---Public Key---");
		PublicKey publickey = kp.getPublic();
		
		System.out.println(publickey.getAlgorithm()); //XDH
		System.out.println(publickey.getFormat()); //X.509
		
		//save this public key
		byte[] pubKey = publickey.getEncoded();
		
		System.out.println("---");
		
		System.out.println("---Private Key---");
		PrivateKey privatekey = kp.getPrivate();
		
		System.out.println(privatekey.getAlgorithm()); //XDH
		System.out.println(privatekey.getFormat()); //PKCS#8
		
		//save this private key
		byte[] priKey = privatekey.getEncoded();

	}
}
