package euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import euler.utils.Prime;

/**
Prime pair sets
Problem 60
The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating 
them in any order the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. 
The sum of these four primes, 792, represents the lowest sum for a set of four primes with this property.

Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
**/
public class Problem60 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 60");
		List<Set<Long>> chains = new ArrayList();  
		Set<Long> chain1 = new HashSet<Long>();
		chains.add(chain1);
		for (long n = 11; n < 100000000; n++) {
			if (Prime.isPrimeFaster(n)) {
				String sn = String.valueOf(n);
				for (int i = 1; i < sn.length(); i++) {
					Long n1 = Long.valueOf(sn.substring(0, i));
					if (sn.substring(i).startsWith("0")) {
						continue;
					}
					Long n2 = Long.valueOf(sn.substring(i));
					Long n3 = Long.valueOf(sn.substring(i) + sn.substring(0, i));
					Set<Long> newChain = null;
					if (Prime.isPrimeFaster(n1) && Prime.isPrimeFaster(n2) && Prime.isPrimeFaster(n3)) {
						Long newPrime = n1;
						for (Set<Long> primes : chains) {
							if (primes.size() < 2) {
								primes.add(n1);
								primes.add(n2);
							} else if (primes.contains(n1)) {
								newPrime = n2;
							}
							boolean isAddable = true; 
							for (Long a : primes) {
								Long n4 = Long.valueOf(a.toString() + newPrime.toString());
								Long n5 = Long.valueOf(newPrime.toString() + a.toString());
								if (!Prime.isPrimeFaster(n4) || !Prime.isPrimeFaster(n5)) {
									isAddable = false;
								}
							}
							if (isAddable) {
								primes.add(newPrime);
//								System.out.println(chains);
								if (primes.size() == 5) {
									System.out.println(primes);
									System.exit(0);
								}
							} else {
								newChain = new HashSet<Long>();
								newChain.add(n1);
								newChain.add(n2);
							}
						}
						if (newChain != null) {
							chains.add(newChain);
						}
					}
				}
			}
		}
	}		

}