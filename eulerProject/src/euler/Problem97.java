package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.javatuples.Pair;

import euler.utils.ArraysHelper;
import euler.utils.DigitUtil;

/**
Large non-Mersenne prime
Problem 97
The first known prime found to exceed one million digits was discovered in 1999, 
and is a Mersenne prime of the form 2^6972593−1; it contains exactly 2,098,960 digits. 
Subsequently other Mersenne primes, of the form 2^p−1, have been found which contain more digits.

However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 
digits: 28433×2^7_830_457+1.

Find the last ten digits of this prime number.
*/
public class Problem97 {

	public static void main(String[] args) {
		long sum = 0;
		long k = 28433;
		sum = k;
		for (long p = 1; p <= 7_830_457; p++) {
			sum = sum * 2;
			String s = String.valueOf(sum);
			int l = s.length();
			if (l >= 10) {
				s = s.substring(l - 10, l);
//				System.out.println(s);
			}
			sum = Long.valueOf(s);
		}
		sum++;
		System.out.println("sum = " + sum);
	}
	
}
