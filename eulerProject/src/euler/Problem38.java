package euler;

import euler.utils.PrimeNumberUtils;


/**
 * 
 */
public class Problem38 {

	public static void main(String[] args) {
		int i = 0;
		for (int n = 2; n < 1000000; n++) {
			if (PrimeNumberUtils.isCircularPrime(n)) {
				i++;
				System.out.println(n);
			}
			if (n % 10000 == 0) {
				System.out.println(n + " : " + i);
			}
		}
		System.out.println(i);
		
	}

}
