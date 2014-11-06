package euler.utils;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PowHelper {

	private static int[] sqCache = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
	
	private static Map<BigInteger, Long> cubicCache = new HashMap<BigInteger, Long>();
	private static BigInteger maxCubicInCache = BigInteger.ZERO;
	
	static {
		cubicCache.put(BigInteger.ZERO, 0L);
	}
	
	/**
	 * Return square of N.
	 * @param n
	 * @return
	 */
	public static int square(int n) {
		if (n < sqCache.length) {
			return sqCache[n];
		}
		return n * n;
	}
	
	public static boolean isPerfectCubic(BigInteger n) {
		while (maxCubicInCache.compareTo(n) < 0) {
			Long v = cubicCache.get(maxCubicInCache);
			++v;
			BigInteger vb = BigInteger.valueOf(v);
			BigInteger k = vb.multiply(vb).multiply(vb);
			cubicCache.put(k, v);
			maxCubicInCache = k;
		}
		return cubicCache.containsKey(n);
	}
	
	public static long pow(long n, long pow) {
		if (pow == 0) {
			return 1;
		}
		long retval = n;
		for (long i = 2; i <= pow; i++) {
			retval *= n;
		}
		return retval;
	}

	
}
