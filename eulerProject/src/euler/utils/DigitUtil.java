package euler.utils;

public class DigitUtil {

	public static Long[] longToDigits(Long n) {
		String s = String.valueOf(n);
		int size = s.length();
		Long[] retval = new Long[size];
		for (int i = 0; i < size; i++) {
			retval[i] = Long.parseLong(String.valueOf(s.charAt(i)));
		}
		return retval;
	}

	public static int[] intToDigits(int n) {
		String s = String.valueOf(n);
		int size = s.length();
		int[] retval = new int[size];
		for (int i = 0; i < size; i++) {
			retval[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		return retval;
	}

}
