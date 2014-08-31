package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.javatuples.Pair;

import euler.utils.DivisorsHelper;
import euler.utils.MathHelper;
import euler.utils.Prime;

/**
 * XOR decryption
 * 
 * Problem 59
 * 
 * Each character on a computer is assigned a unique code and the preferred 
 * standard is ASCII (American Standard Code for Information Interchange). 
 * For example, uppercase A = 65, asterisk (*) = 42, and lowercase k = 107.
 * 
 * A modern encryption method is to take a text fihbn                                                                                                                                                                                                                                                                                                                                                                                                                                          c                                                          le, convert the bytes to ASCII, 
 * then XOR each byte with a given value, taken from a secret key. 
 * The advantage with the XOR function is that using the same encryption key on 
 * the cipher text, restores the plain text; for example, 65 XOR 42 = 107, 
 * then 107 XOR 42 = 65.
 * 
 * For unbreakable encryption, the key is the same length as the plain text message, 
 * and the key is made up of random bytes. The user would keep the encrypted message 
 * and the encryption key in different locations, and without both "halves", 
 * it is impossible to decrypt the message.
 * 
 * Unfortunately, this method is impractical for most users, so the modified method 
 * is to use a password as a key. If the password is shorter than the message, 
 * which is likely, the key is repeated cyclically throughout the message. 
 * The balance for this method is using a sufficiently long password key for security, 
 * but short enough to be memorable.
 * 
 * Your task has been made easy, as the encryption key consists of three lower case 
 * characters. Using cipher.txt (right click and 'Save Link/Target As...'), a file 
 * containing the encrypted ASCII codes, and the knowledge that the plain text must 
 * contain common English words, decrypt the message and find the sum of the ASCII 
 * values in the original text.
 */
public class Problem59 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 59");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("data/p059_cipher.txt")));
			String str = reader.readLine();
			String[] strNums = str.split(",");
			int len = strNums.length;
			Integer[] chunk1 = new Integer[(int)(len / 3)];
			Integer[] chunk2 = new Integer[(int)(len / 3)];
			Integer[] chunk3 = new Integer[(int)(len / 3)];
			for(int i = 0; i < len / 3; i++) {
				chunk1[i] = Integer.parseInt(strNums[i * 3]);
				chunk2[i] = Integer.parseInt(strNums[i * 3 + 1]);
				chunk3[i] = Integer.parseInt(strNums[i * 3 + 2]);
			}
			System.out.println("chunk1 : ");
			printFrqs(chunk1);
			System.out.println("chunk2 : ");
			printFrqs(chunk2);
			System.out.println("chunk3 : ");
			printFrqs(chunk3);
			// god
			int p1 = 103; 
			int p2 = 111;
			int p3 = 100;
			String sr = "";
			long sum = 0;
			int lim = 1201;
			for(int i = 0; i <= 1200; i = i + 3) {
				// p1
				int code1 = Integer.parseInt(strNums[i]);
				int symb1 = code1 ^ p1;
				String c1 = Character.toString((char) symb1);
				sr += c1;
				int s1 = symb1;
				// p2
				if ((i + 1) < lim) {
					int code2 = Integer.parseInt(strNums[i+1]);
					int symb2 = code2 ^ p2;				
					String c2 = Character.toString((char) symb2);
					sr += c2;
					s1 += symb2;
				}
				// p3
				if ((i + 2) < lim) {
					int code3 = Integer.parseInt(strNums[i+2]);
					int symb3 = code3 ^ p3;
					String c3 = Character.toString((char) symb3);
					sr += c3;
					s1 += symb3;
				}
				sum += s1;
			}
			System.out.println();
			System.out.print(sr);
			System.out.print(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printFrqs(Integer[] chunk) {
		List<Integer> list = Arrays.asList(chunk);
		Set<Integer> uniqueSet = new HashSet<Integer>(list);
		for (Integer temp : uniqueSet) {
			System.out.println(temp + ": " + Collections.frequency(list, temp));
		}
		
	}

	private static boolean isLetter(int symb) {
		return symb == 32 || (symb >= 65 && symb <=122);
	}

}