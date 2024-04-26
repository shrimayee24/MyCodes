public class DHMwithoutAPI 
{

	public static void main(String[] args) 
	{
		long n=11,g=7,prA=5,prB=8;
		System.out.println("n="+n+" g="+g+"\nPrivate key of Alice(prA)= "+prA+" \nPrivate key of Bob(prB)= "+prB);
		long puA =pubAlice(n,g,prA);
		System.out.println("Public key of Alice (puA) is: "+puA);
		long puB =pubBob(n,g,prB);
		System.out.println("Public key of Bob (puB) is: "+puB);
		long keyAlice =keyAlice(prA,puB,n);
		System.out.println("Symmetric key calculated by Alice ="+keyAlice);
		long keyBob =keyBob(prB,puA,n);
		System.out.println("Symmetric key calculated by Bob="+keyBob);
	}
	static long pubAlice(long n, long g,long prA)
	{
		long pow=pow(g,prA);
		long puA=pow%n;
		return puA;
	}
	static long pubBob(long n, long g,long prB)
	{
		long pow=pow(g,prB);
		long puB=pow%n;
		return puB;
	}
	static long keyAlice(long prA,long puB,long n)
	{
		long pow=pow(puB,prA);
		long K=pow%n;
		return K;
	}
	static long keyBob(long prB,long puA,long n)
	{
		long pow=pow(puA,prB);
		long K=pow%n;
		return K;
	}
	static long pow(long a, long b)
	{
		long answer=1;
		for(int i=1;i<=b;i++)
		{
			answer=a*answer;
		}
		return answer;
	}



}
