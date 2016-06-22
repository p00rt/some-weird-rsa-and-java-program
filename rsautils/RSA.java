package rsautils;
import java.math.BigInteger;
import java.security.SecureRandom;


public class RSA {
	
	public BigInteger e, d, n;

	// Zwraca liste liczb w kolejnosci [d, e, n]
	private BigInteger[] genKeys(int len){
		
		BigInteger[] klucze = new BigInteger[3];
		SecureRandom gen = new SecureRandom();
		
		BigInteger p = new BigInteger(len / 2, 100, gen);
		BigInteger q = new BigInteger(len / 2, 100, gen);
		klucze[2] = p.multiply(q);
		
		// fin to wynik funkcji Eulera od n
		BigInteger fin = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		klucze[1] = new BigInteger("3");
		
		while (fin.gcd(klucze[1]).intValue() > 1) {
			klucze[1] = klucze[1].add(new BigInteger("2"));
		}
		
		klucze[0] = klucze[1].modInverse(fin);
		
		return klucze;
	}
	
	public RSA (int len) {
		BigInteger klucze[] = genKeys(len);
		d = klucze[0];
		e = klucze[1];
		n = klucze[2];
	}
	
	public RSA (BigInteger de, BigInteger nn, boolean dore) {
		if (dore){
			d = de;
		}
		else {
			e = de;
		}
		n = nn;
	}
	
	public BigInteger szyfruj(BigInteger wiad) {
		BigInteger wiad1 = wiad.modPow(e, n);
		return wiad1;
	}
	
	public BigInteger deszyfruj(BigInteger wiad) {
		return wiad.modPow(d, n);
	}
	
	public BigInteger givePrivateKey() {
		return d;
	}
	
	public BigInteger givePublicKey() {
		return e;
	}
	
	public BigInteger giveN() {
		return n;
	}
}
