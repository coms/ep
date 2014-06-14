package euler.utils;

import java.math.BigInteger;
import java.util.Arrays;

public class DigitUtil {

	public static Long[] toDigits(Long n) {
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
	
	public static long[] longToDigits(long n) {
		String s = String.valueOf(n);
		int size = s.length();
		long[] retval = new long[size];
		for (int i = 0; i < size; i++) {
			retval[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
		}
		return retval;
	}

	
	public static int[] bigIntegerToDigits(BigInteger n) {
		String s = n.toString();
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
	public static boolean isPandigital(long n, int pan) {
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

	public static boolean isPandigital(long n) {
		String s = String.valueOf(n);
		return isPandigital(s);
	}

	// pandigital is number with digits from 1 to n;
	// 34512 - pandigital to 5;
	public static boolean isPandigital(String s) {
		if (s.indexOf("0") != -1) {
			return false;
		}
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		for (int i = 0; i < ca.length; i++) {
			if (Integer.valueOf(String.valueOf(ca[i])) != (i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static int rotateLeft(int n) {
		int[] a = intToDigits(n);
		int k = a[0]; 
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = k;
		return digitArrayToInt(a);
	}

	public static int digitArrayToInt(int[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		return Integer.valueOf(sb.toString());
	}

	public static long digitArrayToLong(long[] a) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			sb.append(a[i]);
		}
		return Long.valueOf(sb.toString());
	}

	public static boolean isPalindromic(long n) {
		String s = String.valueOf(n);
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return s.equals(sb.toString());
	}
	
	public static boolean isPalindromic(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		return s.equals(sb.toString());
	}

}
