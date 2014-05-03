package euler.utils;

import java.util.List;

/**
 * Utility librarys for prime numbers.
 * @author coms
 *
 */
public class PrimeNumberUtils {

	public static boolean isPrime(long n) {
		List<Long> divs = DivisorsHelper.divisors(n);
		return divs.size() == 2;
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
