package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.javatuples.Pair;

import euler.utils.DivisorsHelper;
import euler.utils.Prime;

/**
* Distinct primes factors
* Problem 47
* The first two consecutive numbers to have two distinct prime factors are:
* 14 = 2 × 7
* 15 = 3 × 5
* The first three consecutive numbers to have three distinct prime factors are:
* 644 = 2^2 × 7 × 23
* 645 = 3 × 5 × 43
* 646 = 2 × 17 × 19.
* Find the first four consecutive integers to have four distinct prime factors. What is the first of these numbers?
*/
public class Problem47 {
		
	static int primesLimit = 200;

	public static void main(String[] args) {
		System.out.println("Solve problem 47");
		ArrayList<Long> primes = new ArrayList<Long>();
		for (int i = 0; i < primesLimit; i++) {
			Long prime = Prime.nextPrime();
			primes.add(prime);
		}
		System.out.println("primes = " + primes);
		long q1 = 0;
		int j = 0;
		HashSet<Long> divs = new HashSet<Long>();
		for (long n = 134043; n <= 134046; n++) {
			if (n % 10000 == 0) {
				System.out.println(n);
			}
			if (!Prime.isPrimeFaster(n)) {
				divs.clear();
				long k = n;
				int i = 0;
				while (k>1 && divs.size() <= 5) {
					long prime = primes.get(i);
					if (k % prime == 0) {
						k = k / prime;
						divs.add(prime);
						System.out.println(prime);
						i = -1;
					}
					i++;
				}
				if (divs.size() == 4) {
//					System.out.println(n + " : " + divs);
					if (q1 == (n - 1)) {
						j++;
						q1 = n;
					} else {
						j = 0;
						q1 = n;
					}
					if (j == 3) {
						System.out.println("!!! found " + (j+1) + " sequence!!! from : " + (n - j) + divs);
					}
				}
			}
		}
	}

}