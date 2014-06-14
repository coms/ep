package euler;

import java.math.*;
import java.util.ArrayList;

/**
* Number letter counts
* Problem 17
* If the numbers 1 to 5 are written out in words: one, two, three, four, five, then 
* there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
* 
* If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
* how many letters would be used?
* 
* NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
* contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
* The use of "and" when writing out numbers is in compliance with British usage.
*/
public class Problem17 {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();
	static String[] ones = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static String[] huns = {"hundred", "thousand"};
	
	public static void main(String[] args) {
		
		System.out.println("Solve problem 17");
		int l = 0;
		for (int i = 1; i < 1001; i++) {
			String s = str(i);
			System.out.println(s);
			l += s.length();
		}
		System.out.println(l);
	}
	
	public static String str(int i) {
		StringBuilder sb = new StringBuilder();
		if (i == 1000) {
			return "onethousand";
		}
		boolean isHuns = false;
		int hunds = i / 100;
		if (hunds > 0) {
			sb.append(ones[hunds - 1]);
			sb.append("hundred");
			isHuns = true;
		}
		i = i % 100;
		if (i > 1 && i < 20) {
			if (isHuns) {
				sb.append("and");
				isHuns = false;
			}
			sb.append(ones[i - 1]);
			return sb.toString();
		}
		int idxTens = i / 10;
		if (idxTens > 0) {
			if (isHuns) {
				sb.append("and");
				isHuns = false;
			}
			sb.append(tens[idxTens - 1]);			
		}
		int idxOnes = i % 10;
		if (idxOnes > 0) {
			if (isHuns) {
				sb.append("and");
				isHuns = false;
			}
			sb.append(ones[idxOnes - 1]);
		}
		return sb.toString();
	}
	
}