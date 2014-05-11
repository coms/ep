package euler;

import euler.utils.Prime;


/**
 * 
 */
public class Problem35 {

	public static void main(String[] args) {
		int i = 0;
		for (int n = 2; n < 1000000; n++) {
			if (Prime.isCircularPrime(n)) {
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
