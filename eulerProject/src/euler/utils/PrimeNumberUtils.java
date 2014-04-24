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
	
}
