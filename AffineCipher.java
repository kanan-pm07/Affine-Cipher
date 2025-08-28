//Documentation Section
/*
 Author - Kanan Prasad Moharana
 Regd - 2241013354
 Program Details - Affine Cipher 
 */
import java.util.Scanner;
public class AffineCipher {

	public static void main(String[] args) {
		//Input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the message you want to encrypt : "); //Enter the user string
		String input_String = sc.nextLine();
		
		
		//Output
		String ciphertext = encrypt(input_String);
		System.out.println("The Encrypted Text is : "+ciphertext);
		String plaintext = decrypt(ciphertext);
		System.out.println("The Decrypted Text is : "+plaintext);
		
		
		
		

	}
	
	public static String encrypt(String text) {
		int k1=7; //Multiplicative key
		int k2=2; //Additive key
		
		char ciphertext[] = new char[text.length()];
		for (int i=0; i<text.length(); i++) {
			char character = text.charAt(i); //Stores the Character ; to check if it is Capital or Small
			if (Character.isUpperCase(character)) { // if Character is Capital
				int k3 = text.charAt(i) - 'A'; //Stores the corresponding value of the Character
				int encryptedtext = (k3*k1+k2)%26; //Formula according to question 
				ciphertext[i] = (char)(encryptedtext + 'A'); //C = (P × k1 + k2) mod 26  k1 + k2) mod 26
			}else{ // if Character is Small
				int k3 = text.charAt(i) - 'a'; //Stores the corresponding value of the Character
	            int encrypt = (k3 * k1 +k2) % 26; //  Formula according to question 
	            ciphertext[i] = (char)(encrypt + 'a'); //C = (P × k1 + k2) mod 26  k1 + k2) mod 26
			}
			
		}
		return new String(ciphertext);
	}
	
	public static String decrypt(String text) {
		int k1 = 7; //Multiplicative Key
		int k2 = 2; //Additive Key
		int in = 15; //Inverse 
		char plaintext[] = new char[text.length()];
		
		for (int i=0; i<text.length(); i++) { 
			char character = text.charAt(i); //Stores the Character ; to check if it is Capital or Small
			if (Character.isUpperCase(character)) { // if Character is Capital
				int k3 = text.charAt(i) - 'A'; //Stores the corresponding value of the Character
				int decrypt = ((k3-k2 + 26)*in)%26; //Formula according to question
				plaintext[i]=(char)(decrypt + 'A'); //P = ((C − k2) × k1 k2) × k1 + k2) mod 26  k1− k2) × k1^-1) mod 26
				
			}else { //if character is small
				int k3 = text.charAt(i) - 'a'; //Stores the corresponding value of the Character
				int decrypt = ((k3-k2 + 26)*in)%26; //Formula according to question
				plaintext[i]=(char)(decrypt + 'a'); //P = ((C − k2) × k1 k2) × k1 + k2) mod 26  k1− k2) × k1^-1) mod 26
				
			}
			
		}
		return new String(plaintext);
	}

}
