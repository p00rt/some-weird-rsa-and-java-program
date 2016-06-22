import java.math.BigInteger;
import java.util.Scanner;

import rsautils.RSA;


public class RsaCrypt {

	public static void main(String[] args) {
		/*
		System.out.println("Podaj liczbe: ");;
		RSA obj = new RSA(2048);
		Scanner sc = new Scanner(System.in);
		BigInteger len;
		len = sc.nextBigInteger();
		System.out.println("d: " + obj.givePrivateKey() + " e: " + obj.givePublicKey() + " n: " + obj.giveN());
		System.out.println("zaszyfrowana wiadomosc: " + obj.szyfruj(len));
		*/
		
		System.out.println("Podaj liczbe: ");
		Scanner sc = new Scanner(System.in);
		RSA obj = new RSA(2048);
		BigInteger szyfr;
		szyfr = sc.nextBigInteger();
		System.out.println("Podaj d, n: ");
		BigInteger d, n;
		d = sc.nextBigInteger();
		n = sc.nextBigInteger();
		obj.d = d;
		obj.n = n;
		System.out.println("Odszyfrowana wiadomosc to: " + obj.deszyfruj(szyfr));
		
		
		sc.close();
	}

}
