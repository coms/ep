package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.javatuples.Pair;

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
	private static HashMap<String, String> substMap = new HashMap<String, String>();
	
	static {
		substMap.put("IIII", "IV");
		substMap.put("VIV", "IX");
		substMap.put("XXXX", "XL");
		substMap.put("LXL", "XC");
		substMap.put("CCCC", "CD");
		substMap.put("DCD", "CM");
		
		substMap.put("VV", "X");
		substMap.put("LL", "C");
		substMap.put("DD", "M");

		substMap.put("IIIII", "V");
		substMap.put("XXXXX", "L");
		substMap.put("CCCCC", "D");
		
		//substMap.put("VIII", "IIX");
	}
	
	public static void main(String[] args) {
		try {
			ArrayList<Pair<String, String>> numbers = new ArrayList<Pair<String, String>>();
//			Set<String> sortedCodes = new ConcurrentSkipListSet<String>();
			BufferedReader reader = new BufferedReader( new FileReader(new File("data/roman.txt")));
			String str;
			while ((str = reader.readLine()) != null) {
				numbers.add(Pair.with(str, str));
			}
			int totalSavedChars = 0;
			int lineNumber = 1;
			for (Pair<String, String> n : numbers) {
				boolean subst = false;
				do {
					subst = false;
					for (Map.Entry<String, String> substEntry : substMap.entrySet()) {
						int idx = n.getValue1().indexOf(substEntry.getKey());
						if (idx >= 0) {
							System.out.println("make subst : " + substEntry + " on " + n);
							String val = n.getValue1();
							val = val.replaceAll(substEntry.getKey(), substEntry.getValue());
							Pair<String, String> np = n.setAt1(val);
							n = np;
							subst = true;
						}
					}
				} while (subst);
				int savedChars = n.getValue0().length() - n.getValue1().length();
				totalSavedChars += savedChars;
				System.out.println(lineNumber++ + " : " + n + " : saved : " + savedChars);
			}
			System.out.println("total saved : " + totalSavedChars);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
}
