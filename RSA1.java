import java.math.BigInteger;
import java.util.Scanner;
public class RSA1 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);

		BigInteger p=accept_prime();
		BigInteger q=accept_prime();

		BigInteger n=calculate_n(p,q);
		System.out.println("Value of n is="+n);
		BigInteger m=calculate_m(p,q);
		System.out.println("Value of m is="+m);


		BigInteger e=validate_key(m);

		System.out.println("Enter plaintext:");
		BigInteger plaintext=BigInteger.valueOf(sc.nextLong());

		BigInteger d=decryptionkey(e,m);
		System.out.println("Decryption key is="+d);
		System.out.println("Public key is=("+e+","+n+")");
		System.out.println("Private key is=("+d+","+n+")");


		BigInteger ciphertext=encrypt(plaintext,e,n);
		System.out.println("Ciphertext is="+ciphertext);
		BigInteger decryptedtext=decrypt(ciphertext,d,n);
		System.out.println("Decrypted text is="+decryptedtext);


	}
	static boolean isPrime(BigInteger number) {
		if (number.compareTo(BigInteger.ONE) <= 0) {
			return false; // Numbers less than or equal to 1 are not prime
		}
		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(number.sqrt()) <= 0; i = i.add(BigInteger.ONE)) {
			if (number.mod(i).equals(BigInteger.ZERO)) {
				return false; // If number is divisible by any integer from 2 to sqrt(number), it's not prime
			}
		}
		return true; // If number is not divisible by any integer from 2 to sqrt(number), it's prime
	}
	static BigInteger accept_prime()
	{
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		BigInteger prime=BigInteger.valueOf(0);
		do
		{
			System.out.println("Enter value of prime number");
			prime=BigInteger.valueOf(sc.nextLong());
			if(isPrime(prime)==true)
			{
				flag=true;
				System.out.println(prime+" is a prime number.");
			}
			else
				System.out.println(prime+" is not a prime number.");
		}
		while(flag==false);
		return prime;
	}
	
	static BigInteger validate_key(BigInteger m)
	{
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		BigInteger e=BigInteger.valueOf(0);
		do
		{
			System.out.println("Enter encryption key");
			e=BigInteger.valueOf(sc.nextLong());
			if(gcdvalid(e,m)==true)
			{
				flag=true;
				System.out.println("key is valid");
			}
			else
				System.out.println("key is invalid!");
		}
		while(flag==false);
		return e;
	}

	static BigInteger calculate_n(BigInteger p,BigInteger q)
	{
		BigInteger n=p.multiply(q);
		return n;
	}
	static BigInteger calculate_m(BigInteger p,BigInteger q)
	{
		BigInteger m=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		return m;
	}
	static boolean gcdvalid(BigInteger e,BigInteger m)
	{
		boolean flag=false;
		BigInteger gcd= e.gcd(m);
		if(gcd.equals(BigInteger.ONE))
		{
			flag=true;
		}
		return flag;
	}
	static BigInteger decryptionkey(BigInteger e, BigInteger m)
	{
		BigInteger d=e.modInverse(m);
		return d;
	}
	static BigInteger encrypt(BigInteger plaintext, BigInteger e,BigInteger n)
	{
		BigInteger ciphertext=plaintext.modPow(e, n);
		return ciphertext;
	}
	static BigInteger decrypt(BigInteger ciphertext, BigInteger d,BigInteger n)
	{
		BigInteger plaintext=ciphertext.modPow(d, n);
		return plaintext;
	}

}