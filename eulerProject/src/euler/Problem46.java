package euler;

import java.text.SimpleDateFormat;
import java.util.Date;

import euler.utils.DigitUtil;
import euler.utils.PowHelper;
import euler.utils.Prime;


/**
 * 
 */
public class Problem46 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String[] args) {
		long k = 0;
		for (int n = 3; n < 100000; n = n + 2) {
			if (++k % 1000 == 0) {
				System.out.println(sdf.format(new Date()) + " : " + n + " numbers processed");
			}
			if (Prime.isPrime(n)) {
				continue;
			}
			boolean isSolved = false;
				Prime.resetPrimeSequnce();
				long prime = Prime.nextPrime(); 
				while (prime < n) {
					double sq = Math.sqrt((n - prime) / 2d);
					if (sq == (int)sq) { // check if sq in integer
						if ((prime + 2*sq*sq) == n) {
//							System.out.println(n + " = " + prime + " + " + "2 * " + sq + "^2");
							isSolved = true;
						}
					}
					prime = Prime.nextPrime();
				}
			if (!isSolved) {
				System.out.println("Cannot find solution for " + n + "!!!");
			}
		}
	}
}
