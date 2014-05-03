package euler;

import euler.utils.DigitUtil;
import euler.utils.PrimeNumberUtils;


/**
 * 
 */
public class Problem46 {

	public static void main(String[] args) {
		long max = 0;
		for (int n = 1; n < 100000; n++) {
			String s = "";
			for (int i = 1; i < 10; i++) {
				String k = String.valueOf(n * i);
				s += k;
				if (DigitUtil.isPandigital(s, 9)) {
					System.out.println("i = " + i + "; n = " + n + "; s = " + s);
					max = Math.max(max, Long.valueOf(s));
				}
			}
		}
		System.out.println("max = " + max);
	}
}
