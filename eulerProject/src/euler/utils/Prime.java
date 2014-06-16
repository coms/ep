package euler.utils;

import java.util.List;

/**
 * Utility librarys for prime numbers.
 * @author coms
 *
 */
public class Prime {

	private static long lastPrime = 0L;
	
	public static void resetPrimeSequnce() {
		lastPrime = 0L;
	}
	
	public static long nextPrime() {
		long n = lastPrime;
		do {
			n++;
		} while (!isPrimeFaster(n));
		lastPrime = n;
		return lastPrime;
	}

	public static boolean isPrime(long n) {
		List<Long> divs = DivisorsHelper.divisors(n);
		return divs.size() == 2;
	}

	public static boolean isPrimeFaster(long n) {
		return !DivisorsHelper.moreThen2Div(n);
	}

	public static boolean isCircularPrime(int n) {
		if (!isPrime(n) || String.valueOf(n).contains("0")) {
			return false;
		}
		int size = DigitUtil.intToDigits(n).length;
		for (int i = 0; i < size; i++) {
			n = DigitUtil.rotateLeft(n);
			if (!isPrime(n)) {
				return false;
			}
		}
		return true;
	}
}
