package euler;

import java.text.SimpleDateFormat;
import java.util.Date;

import euler.utils.DigitUtil;
import euler.utils.PowHelper;
import euler.utils.PrimeNumberUtils;


/**
 * 
 */
public class Problem46 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String[] args) {
		long k = 0;
		for (int n = 2; n < 100000; n = n + 2) {
			if (++k % 10000 == 0) {
				System.out.println(sdf.format(new Date()) + " : " + n);
			}
			if (PrimeNumberUtils.isPrime(n)) {
				continue;
			}
			boolean isSolved = false;
				PrimeNumberUtils.resetPrimeSequnce();
				long prime = PrimeNumberUtils.nextPrime(); 
				while (prime < n) {
					double sq = Math.sqrt((n - prime) / 2d);
					if (sq == (int)sq) { // check if sq in integer
						if ((prime + 2*sq*sq) == n) {
//							System.out.println(n + " = " + prime + " + " + "2 * " + sq + "^2");
							isSolved = true;
						}
					}
					prime = PrimeNumberUtils.nextPrime();
				}
			if (!isSolved) {
				System.out.println("Cannot find solution for " + n + "!!!");
			}
		}
	}
}
