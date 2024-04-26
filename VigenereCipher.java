import java.util.Scanner;
public class VigenereCipher
{
	public static void main(String[] args) 
	{
		String plaintext=acceptplaintext();
		String key=acceptkey();
		if(plaintext.length()>key.length())
		{
			key=processkey(plaintext,key);
		}
		System.out.println("Processed key is: "+key);
		String ciphertext=encrypt(plaintext,key);
		System.out.println("Encrypted text is: "+ciphertext);
		String decrypted=decrypt(ciphertext,key);
		System.out.println("Decrypted text is: "+decrypted);
	}
	static String acceptplaintext()
	{
		Scanner sc=new Scanner(System.in);
		boolean correctinput=false;
		String plaintext;
		do
		{
			System.out.println("Enter plaintext:");
			plaintext=sc.next();
			if(validateinput(plaintext))
			{
				correctinput=true;
			}
		}
		while(!correctinput);
		return plaintext;
		
	}
	static String acceptkey()
	{
		Scanner sc=new Scanner(System.in);
		boolean correctinput=false;
		String key;
		do
		{
			System.out.println("Enter key:");
			key=sc.next();
			if(validateinput(key))
			{
				correctinput=true;
			}
		}
		while(!correctinput);
		return key;
		
	}
	static boolean validateinput(String str)
	{
		boolean flag=true;
		char[] arr=str.toCharArray();
		for(char ch:arr)
		{
			if(!Character.isUpperCase(ch))
			{
				flag=false;
				break;
			}
			
		}
		return flag;
	}
	static String processkey(String plaintext,String stringkey)
	{
		int n=plaintext.length();
		char[] newkey=new char[n];
		char[] key=stringkey.toCharArray();
		for(int i=0; i<n; i++)
		{
			newkey[i]=key[i%key.length];
		}
		String processkey=new String(newkey);
		return processkey;
	}

	static String encrypt(String plaintext,String newkey)
	{
		char[] plainchar=plaintext.toCharArray();
		char[] keychar=newkey.toCharArray();
		char[] cipher=new char[plainchar.length];
		for(int i=0;i<plainchar.length;i++)
		{
			cipher[i]=(char) ((plainchar[i]+keychar[i]-(2*'A'))%26 + 'A');
		}
		String ciphertext=new String(cipher);
		return ciphertext;
	}

	static String decrypt(String ciphertext, String newkey) {
		char[] cipherchar = ciphertext.toCharArray();
		char[] keychar = newkey.toCharArray();
		char[] plain = new char[cipherchar.length];
		for (int i = 0; i < cipherchar.length; i++) {
			int cipherValue = cipherchar[i] - 'A';
			int keyValue = keychar[i] - 'A'; // Using modulo to repeat the key if it's shorter than the ciphertext
			int plainValue = (cipherValue - keyValue + 26) % 26; // Adding 26 before taking modulo to handle negative values
			plain[i] = (char) (plainValue + 'A');
		}
		String plaintext = new String(plain);
		return plaintext;
	}

}
