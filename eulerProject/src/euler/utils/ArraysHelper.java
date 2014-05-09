package euler.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	
	public static Set<String> sort(Set<String> set) {
		Set<String> retval = new HashSet<String>();
		String[] oset = set.toArray(new String[0]);
		Arrays.sort(oset);
		System.out.println(Arrays.toString(oset));
		retval.addAll(Arrays.asList(oset));
		return retval;
	}
	

}
