package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import euler.utils.ArraysHelper;


/**
* Roman numerals
* Problem 89
* The rules for writing Roman numerals allow for many ways of writing each number 
* (see About Roman Numerals...). However, there is always a "best" way of writing a particular number.
* For example, the following represent all of the legitimate ways of writing the number sixteen:
* IIIIIIIIIIIIIIII
* VIIIIIIIIIII
* VVIIIIII
* XIIIIII
* VVVI
* XVI
* The last example being considered the most efficient, as it uses the least number of numerals.
* The 11K text file, roman.txt (right click and 'Save Link/Target As...'), contains one 
* thousand numbers written in valid, but not necessarily minimal, Roman numerals; that is, 
* they are arranged in descending units and obey the subtractive pair rule 
* (see About Roman Numerals... for the definitive rules for this problem).
* 
* Find the number of characters saved by writing each of these in their minimal form.
* 
* Note: You can assume that all the Roman numerals in the file contain no more than 
* four consecutive identical units.*/

public class Problem89 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String[] args) {
		try {
			Set<String> codes = new HashSet<String>();
			Set<String> sortedCodes = new ConcurrentSkipListSet<String>();
			BufferedReader reader = new BufferedReader( new FileReader(new File("data/keylog.txt")));
			String str;
			while ((str = reader.readLine()) != null) {
				codes.add(str);
			}
			sortedCodes = ArraysHelper.sort(codes);			
			long sum = 0l;
			
			String s = "73162890";
			
			boolean check = checkPattern(s, sortedCodes);
			
			System.out.println(check);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	
	/***
	 * Checks String s on patterns.
	 * @param s
	 * @param patterns
	 * @return
	 */
	public static boolean checkPattern(String s, Set<String> patterns) {
		for (String pattern : patterns) {
			char s1 = pattern.charAt(0);
			char s2 = pattern.charAt(1);
			char s3 = pattern.charAt(2);
			String p = "\\d*" + s1 + "\\d*" + s2 + "\\d*" + s3 + "\\d*";
			if (!s.matches(p)) {
				System.out.println(s + " is not match " + p);
				return false;
			}
		}
		return true;
	}
	
}
