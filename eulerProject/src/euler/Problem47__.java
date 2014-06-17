package euler;

import java.util.ArrayList;
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
public class Problem47__ {
		
	static int primesLimit = 200;

	public static void main(String[] args) {
		System.out.println("Solve problem 47");
		ArrayList<Pair<Long, Long>> primes = new ArrayList<Pair<Long, Long>>();
		for (int i = 0; i < primesLimit; i++) {
			Long prime = Prime.nextPrime();
			primes.add(Pair.with(prime, prime));
		}
		System.out.println("primes = " + primes);
		long q1=0, q2=0, q3=0, q4 = 0;
		for (long n1 = 1_000_000; n1 < 2_000_000; n1++) {
			if (n1 % 10_000 == 0) {
				System.out.println(n1);
			}
			List<Long> divs = DivisorsHelper.divisors(n1);
			List<Pair<Long, Long>> divs2 = new ArrayList<Pair<Long, Long>>();
			for (Long div : divs) {
				for (Pair<Long, Long> pair : primes) {
					if (pair.getValue0() == div) {
						divs2.add(pair);
					}
				}
			}
			boolean solution = false;
//			System.out.println(divs2.size());
			for (int i = 0; i < divs2.size() - 3; i++) {
				for (int j = i+1; j < divs2.size() - 2; j++) {
					for (int k = j+1; k < divs2.size() - 1; k++) {
						for (int l = k+1; l < divs2.size(); l++) {
							if ((divs2.get(i).getValue0() * divs2.get(j).getValue0() * divs2.get(k).getValue0() * divs2.get(l).getValue0() == n1)
									&& divs2.get(i).getValue1() != divs2.get(j).getValue1()
									&& divs2.get(i).getValue1() != divs2.get(k).getValue1()
									&& divs2.get(i).getValue1() != divs2.get(l).getValue1()
									&& divs2.get(j).getValue1() != divs2.get(k).getValue1()
									&& divs2.get(j).getValue1() != divs2.get(l).getValue1()
									&& divs2.get(k).getValue1() != divs2.get(l).getValue1()
									) {
//								System.out.println(n1 + " : " + divs2.get(i).getValue0() + " * " + divs2.get(j).getValue0() + " * " + divs2.get(k).getValue0() + " * " + divs2.get(l).getValue0());
								solution = true;
							}
						}
					}	
				}
			}
			// check for consecutive condition
			if (solution) {
				q4 = q3;
				q3 = q2;
				q2 = q1;
				q1 = n1;
				if ((q1 == q2 + 1) && (q2 == q3 + 1) && (q3 == q4 + 1)) {
					System.out.println("!!! solution from " + q4);
				}
			}
		}
	}

}