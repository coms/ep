package euler.utils;

public class PowHelper {

	private static int[] sqCache = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
	
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
	
}
