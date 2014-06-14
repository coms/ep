package euler;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;

import euler.utils.DigitUtil;
import euler.utils.Prime;

/**
* Truncatable primes
* Problem 37
* The number 3797 has an interesting property. Being prime itself, it is possible to continuously 
* remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. 
* Similarly we can work from right to left: 3797, 379, 37, and 3.
* 
* Find the sum of the only eleven primes that are both truncatable from left to right and 
* right to left.
* NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/
public class Problem37 {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();

	public static void main(String[] args) {
		System.out.println("Solve problem 37");
		int sum = 0;
		for (long n = 11; n < 1_000_000; n++) {
//		for (long n = 25; n < 26; n++) {
			if (n % 1_000_000 == 0) {
				System.out.println(n + " : " + Prime.isPrimeFaster(n));
			}
			Long[] a = DigitUtil.toDigits(n);
			long a0 = a[0];
			long a1 = a[a.length - 1];
			if (!(a0 == 2 || a0 == 3 || a0 == 5 || a0 == 7)) {
				continue;
			}
			if (!(a1 == 2 || a1 == 3 || a1 == 5 || a1 == 7)) {
				continue;
			}
			if (Prime.isPrimeFaster(n)) {
				boolean isPrime = true;
				for (int i = 1; i < a.length; i++) {
					long[] b = new long[i];
					long[] c = new long[i];
					for (int j = 0; j < i; j++) {
						b[j] = a[j];
						c[j] = a[a.length - i + j];
					}
//						System.out.println("b = " + Arrays.toString(b));
//						System.out.println("c = " + Arrays.toString(c));
					if (!Prime.isPrimeFaster(DigitUtil.digitArrayToLong(b))
							|| !Prime.isPrimeFaster(DigitUtil.digitArrayToLong(c))) {
						isPrime = false;
					}
				}
				if (isPrime) {
					sum += n;
					System.out.println(n + " sum = " + sum);
				}
			}
		}
	}
	
}