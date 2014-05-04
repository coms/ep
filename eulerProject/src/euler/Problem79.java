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

import euler.utils.AlphabetHelper;
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
			ArrayList<String> names = new ArrayList<String>();
			BufferedReader reader = new BufferedReader( new FileReader(new File("data/keycodes.txt")));
			String str = reader.readLine();
			String[] namesArray = str.split(",");
			for (String rawName : namesArray) {
				String name = rawName.substring(1, rawName.length() - 1);
//				System.out.println(name);
				names.add(name);
			}
			Collections.sort(names);
			System.out.println(names);
			long sum = 0l;
			for (int i = 1; i <= names.size(); i++) {
				String name = names.get(i - 1);
				sum += AlphabetHelper.score(name) * i;
			}
			System.out.println(sum);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
