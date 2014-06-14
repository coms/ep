package euler;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;

import euler.utils.DigitUtil;
import euler.utils.Prime;

/**
* Pandigital prime
* Problem 41
* We shall say that an n-digit number is pandigital if it makes use of 
* all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital 
* and is also prime.
* What is the largest n-digit pandigital prime that exists?
*/
public class Problem41 {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();

	public static void main(String[] args) {
		System.out.println("Solve problem 41");
		long sum = 0;
		for (long n = 2; n < 8_000_000; n++) {
			if (n % 1_000_000 == 0) {
				System.out.println(n + " : " + Prime.isPrimeFaster(n));
			}
			if (DigitUtil.isPandigital(n) && Prime.isPrimeFaster(n)) {
//				System.out.println(n);
				sum = n;
			}
		}
		System.out.println(sum);
	}
	
}