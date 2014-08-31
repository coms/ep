package euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.javatuples.Pair;

import euler.utils.DivisorsHelper;
import euler.utils.MathHelper;
import euler.utils.Prime;

/**
 * Combinatoric selections
 * Problem 53
 * There are exactly ten ways of selecting three from five, 12345:
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * In combinatorics, we use the notation, 5C3 = 10.
 * In general,
 * 
 * nCr = n! / r!(n−r)!
 * 
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * 
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, 
 * are greater than one-million?
 */
public class Problem53 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 53");
		int res = 0;
		BigInteger limit = BigInteger.valueOf(1_000_000);
		for (int n = 1; n <=100; n++) {
			BigInteger nf = MathHelper.factorial(n);
			for (int r = 1; r <=n; r++) {
				BigInteger rf = MathHelper.factorial(r);
				BigInteger nrf = MathHelper.factorial(n - r);
				BigInteger q = rf.multiply(nrf);
				BigInteger c = nf.divide(q);
				if (c.compareTo(limit) > 0) {
					res++;				
				}
				System.out.println("C^" + n + "_" + r + " = " + c);
			}
		}
		System.out.println(res);
	}

}