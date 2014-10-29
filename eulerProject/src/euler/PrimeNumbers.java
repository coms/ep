package euler;

import euler.utils.Prime;

public class PrimeNumbers {

	public static void main(String[] args) {
		int c = 0;
		for (long i = 1; i < 200; i++) {
			if(Prime.isPrimeFaster(i)) {
//				++c;
				System.out.println(i + " : " + (++c));				
			}
		}
		System.out.println(c);

	}

}
