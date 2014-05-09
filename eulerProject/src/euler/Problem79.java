package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;

import euler.utils.AlphabetHelper;
import euler.utils.ArraysHelper;
import euler.utils.DigitUtil;
import euler.utils.E;
import euler.utils.Fraction;
import euler.utils.PowHelper;
import euler.utils.PrimeNumberUtils;


/**
* Passcode derivation
*  Problem 79
* A common security method used for online banking is to ask the user 
* for three random characters from a passcode. For example, if the passcode was 531278, 
* they may ask for the 2nd, 3rd, and 5th characters; the expected reply would be: 317.
* 
* The text file, keylog.txt, contains fifty successful login attempts.
* 
* Given that the three characters are always asked for in order, 
* analyse the file so as to determine the shortest possible secret passcode of unknown length.
*/
public class Problem79 {

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
