package euler;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import euler.utils.EquationBI;

/**
* Tribonacci non-divisors
* 
* Problem 225
* 
* The sequence 1, 1, 1, 3, 5, 9, 17, 31, 57, 105, 193, 355, 653, 1201 ...
* is defined by T1 = T2 = T3 = 1 and Tn = Tn-1 + Tn-2 + Tn-3.
*
* It can be shown that 27 does not divide any terms of this sequence.
* In fact, 27 is the first odd number with this property.
* 
* Find the 124th odd number that does not divide any terms of the above sequence.
*/
public class Problem225 {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();
			
	public static void main(String[] args) {
		System.out.println("Solve problem 225");
		sq.add(BigInteger.ONE);
		sq.add(BigInteger.ONE);
		sq.add(BigInteger.ONE);
		BigInteger n = BigInteger.ONE;
		BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
		int limit = 100_000;
		int i = 0;
//		while(n.compareTo(div) == -1) {
		while (i < limit) {
			n = addNext(sq);
			i++;
		}
//		System.out.println(sq);
		
		int j = 0;
		
		BigInteger div = BigInteger.valueOf(25); 
		while (j < 125) {
			div = div.add(two);
			boolean  isGood = true;
			for (BigInteger a : sq) {
				if (a.remainder(div).compareTo(BigInteger.ZERO) == 0) {
//					System.out.println(a + " % " + div + " == 0");
					isGood = false;
					break;
				}
			}
			if (isGood) {
				System.out.println("[" + (++j) + "] " + div + " is not divisor of sequence.");
			} else {
//				System.out.println(div + " is divisor of sequence.");
			}
		}
	}
	
	public static BigInteger addNext(ArrayList<BigInteger> sq) {
		int last = sq.size();
		BigInteger n = getNext(sq.get(last - 1), sq.get(last - 2), sq.get(last - 3)); 
		sq.add(n);
		return n;
	}
	
	public static BigInteger getNext(BigInteger t1, BigInteger t2, BigInteger t3) {
		return t1.add(t2).add(t3);
	}

}