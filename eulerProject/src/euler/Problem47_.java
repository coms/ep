package euler;

import java.math.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
public class Problem47_ {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();
	static int primesLimit = 45;

  	private static void debug(long from, long to, List<Long> nums, List<Long> primes, int i, int j, int k) {
		long last = nums.get(nums.size() - 1);
		if (last >= from && last <= to ) {
			System.out.println(last + " : " + primes.get(i) + ", " + primes.get(j) + ", " + primes.get(k));
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("Solve problem 47");
		ArrayList<Long> primes = new ArrayList<Long>();
		ArrayList<Long> nums = new ArrayList<Long>();
		for (int i = 0; i < primesLimit; i++) {
			primes.add(Prime.nextPrime());
		}
		System.out.println("primes = " + primes);
		int from = 124;
		int to = 126;
		for (int i = 0; i < primesLimit; i++) {
			for (int j = 0; j < primesLimit; j++) {
				for (int k = 0; k < primesLimit; k++) {
					for (int l = 0; l < primesLimit; l++) {
						if (i != j && i != k && j != k && i != l && j != l && k != l) {
							nums.add(primes.get(i) * primes.get(j) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(k) * primes.get(l) * primes.get(l));

							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(k) * primes.get(l) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(l) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l) * primes.get(l));
							
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l));
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(l) * primes.get(l));
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l) * primes.get(l));
							nums.add(primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l) * primes.get(l));
							
							nums.add(primes.get(i) * primes.get(i) * primes.get(j) * primes.get(j) * primes.get(k) * primes.get(k) * primes.get(l) * primes.get(l));
						}
					}
				}
			}
		}
		TreeSet<Long> set = new TreeSet<Long>(nums);
		nums = new ArrayList<Long>(set);
//		System.out.println("nums = " + nums);
		
		for (int i = 2; i < nums.size(); i++) {
			if (nums.get(i) == (nums.get(i-1) + 1) && nums.get(i) == (nums.get(i-2) + 2)  && nums.get(i) == (nums.get(i-3) + 3)) {
				System.out.println(nums.get(i - 3) + ", " + nums.get(i - 2) + ", " + nums.get(i - 1) + ", " + nums.get(i));
			}
		}
		
	}

}