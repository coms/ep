package euler;

import euler.utils.DigitUtil;
import euler.utils.MathHelper;


/**
 * 
 */
public class Problem34 {

	public static void main(String[] args) {
		for (int n = 3; n < 10000000; n++) {
			int[] digits = DigitUtil.intToDigits(n);
			int s = 0;
			for (int i : digits) {
				s += MathHelper.factorial(i).intValue();
			}
			if (s == n) {
				System.out.println(n + "!");
			}
		}
		
	}

}
