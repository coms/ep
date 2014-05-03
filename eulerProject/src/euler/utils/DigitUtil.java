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
	
	// pandigital is number with digits from 1 to n;
	// 34512 - pandigital to 5;
	public static boolean isPandigital(int n, int pan) {
		String s = String.valueOf(n);
		return isPandigital(s, pan);
	}

	// pandigital is number with digits from 1 to n;
	// 34512 - pandigital to 5;
	public static boolean isPandigital(String s, int pan) {
		if (s.indexOf("0") != -1) {
			return false;
		}
		for (int i = 1; i <= pan; i++) {
			String c = String.valueOf(i);
			if ((s.indexOf(c) == -1) || (s.indexOf(c) != s.lastIndexOf(c))) {
				return false;
			}
		}
		return true;
	}

}
