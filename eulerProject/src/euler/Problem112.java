package euler;

import euler.utils.DigitUtil;

/**
Bouncy numbers
Problem 112
Working from left-to-right if no digit is exceeded by the digit to its left it is 
called an increasing number; for example, 134468.

Similarly if no digit is exceeded by the digit to its right it is called a 
decreasing number; for example, 66420.

We shall call a positive integer that is neither increasing nor decreasing a 
"bouncy" number; for example, 155349.

Clearly there cannot be any bouncy numbers below one-hundred, but just over half of the 
numbers below one-thousand (525) are bouncy. In fact, the least number for which the 
proportion of bouncy numbers first reaches 50% is 538.

Surprisingly, bouncy numbers become more and more common and by the time we reach 21780 
the proportion of bouncy numbers is equal to 90%.

Find the least number for which the proportion of bouncy numbers is exactly 99%.
**/

public class Problem112 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("Euler Problem 112");
		int sum = 0;
		long n = 0;
		int p = 0;
		while (p < 99) {
			n++;
			if (isBouncy(n)) {
				sum++;
			}
			p = (int)(((sum*100)/n));
		}
		System.out.println("n = " + n + "\t sum = " + sum  + "\t p = " + (int)(((sum*100)/n)));
		System.out.println(sum);		
		System.out.println("Elapsed time : " + (System.currentTimeMillis() - startTime) + " ms.");
	}

	private static boolean isBouncy(long a) {
		long[] d = DigitUtil.longToDigits(a);
		Boolean isIncreasing = null;
		Boolean isDecreasing = null;
		Boolean isBouncy = false;
		for (int i = 1; i < d.length; i++) {
			if (d[i] > d[i-1]) {
				isIncreasing = true;
				if (isDecreasing!=null && isDecreasing) {
					isBouncy = true;
				}
			}
			if (d[i] < d[i-1]) {
				isDecreasing = true;
				if (isIncreasing!=null && isIncreasing) {
					isBouncy = true;
				}
			}
		}
		return isBouncy;
	}
	
}
