package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import euler.utils.AlphabetHelper;
import euler.utils.DigitUtil;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Coded triangle numbers
* Problem 42
* The nth term of the sequence of triangle numbers is given by, t_n = 1/2n(n+1); 
* so the first ten triangle numbers are:
* 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
* 
* By converting each letter in a word to a number corresponding to its alphabetical 
* position and adding these values we form a word value. For example, the word 
* value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a triangle number 
* then we shall call the word a triangle word.
* 
* Using words.txt (right click and 'Save Link/Target As...'), a 16K text file 
* containing nearly two-thousand common English words, how many are triangle words?
**/
public class Problem42 {

	private static HashSet<Long> triangleNumbers = new HashSet<Long>();
	
	public static void main(String[] args) {
		long sum = 0;
		int i = 0;
		long pos = 0;
		BufferedReader reader = null;
		initTriangleNumbers();
		try {
		  reader = new BufferedReader(new FileReader(new File("./data/p042_words.txt")));
		  String str = null;
		  int j = 0;
		  long maxC = 0;
		  while((str = reader.readLine()) != null) {
			  String[] strNums = str.split(",");
			  for (String str2 : strNums) {
				  String s = str2.substring(1, str2.length() - 1);
				  long c = AlphabetHelper.score(s);
				  maxC = Math.max(maxC, c);
				  if (triangleNumbers.contains(c)) {
					  System.out.println(s + "\t" + c);					 
					  sum++;
				  }
			  }
		  }
		  System.out.println(maxC);
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
  		  e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("sum = " + sum);
	}

	private static void initTriangleNumbers() {
		for (int i = 1; i < 100; i++) {
			triangleNumbers.add((long)((i+1)*i / 2));			
		}
	}
	
}
