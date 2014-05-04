package euler.utils;

public class ArraysHelper {

	/**
	 * sum of array elements
	 * @param a
	 * @return
	 */
	public static int sum(int[] a) {
		int retval = 0;
		for (int i : a) {
			retval += i;
		}
		return retval;
	}

}
