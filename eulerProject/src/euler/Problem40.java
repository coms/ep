package euler;

import java.util.Arrays;

import euler.utils.DigitUtil;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Champernowne's constant
* Problem 40
* An irrational decimal fraction is created by concatenating the positive integers:
* 0.123456789101112131415161718192021...
* It can be seen that the 12th digit of the fractional part is 1.
* If d_n represents the nth digit of the fractional part, find the value of the following 
* expression.
* d_1 × d_10 × d_100 × d_1000 × d_10000 × d_100000 × d_1000000
**/
public class Problem40 {

	public static void main(String[] args) {
		long sum = 1;
		int i = 0;
		long pos = 0;
		for (int n = 1; n <= 1_000_000; n++) {
			pos += Integer.toString(n).length();
			if (pos >= PowHelper.pow(10, i)) {
				long[] a = DigitUtil.longToDigits(n);
				int idx = (int) (a.length - (pos - PowHelper.pow(10, i)));
				long d = a[idx-1]; 
				System.out.println("n = " + n + " a = " + Arrays.toString(a) + " pos = " + pos + " idx = " + idx + " d = " + d);
				i++;
				sum *= d;
			}
		}
		System.out.println("sum = " + sum);
	}
	
}
