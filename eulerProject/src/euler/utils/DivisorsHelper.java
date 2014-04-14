package euler.utils;

import java.util.ArrayList;
import java.util.List;

public class DivisorsHelper {

	/**
	 * return list of divisors of N
	 */
	public static List<Long> divisors(Long n) {
		List<Long> retval = new ArrayList<Long>();
		long div = 1;
		long pairedDiv = 2;
		while (div < pairedDiv) {
			if (n % div == 0) {
				retval.add(div);
				pairedDiv = n / div;
				if (pairedDiv != div) {
					retval.add(pairedDiv);
				}
			}
			div++;
		}
		return retval;
	}

	/**
	 * return list of proper divisors (div != N) of N
	 */
	public static List<Long> properDivisors(Long n) {
		List<Long> retval = divisors(n);
		retval.remove(n);
//		System.out.println("removed : " + n + ":" + retval);
		return retval;
	}
	
	public static Long properDivisorsSum(Long n) {
		List<Long> properDivisors = properDivisors(n);
		Long sum = 0l;
		for (Long i : properDivisors) {
			sum += i;
		}
		return sum;
	}
	
	public static boolean isAmicableNumbers(Long a, Long b) {
		return properDivisorsSum(a).equals(b) && properDivisorsSum(b).equals(a);
	}
	
	
}
