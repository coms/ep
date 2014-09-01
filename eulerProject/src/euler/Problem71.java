package euler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import org.javatuples.Pair;
import euler.utils.DivisorsHelper;

/**
Ordered fractions
Problem 71
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1, it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8

It can be seen that 2/5 is the fraction immediately to the left of 3/7.

By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the fraction 
immediately to the left of 3/7.
 */
public class Problem71 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 71");
		MathContext mc = new MathContext(100, RoundingMode.HALF_DOWN);
		BigDecimal et = BigDecimal.valueOf(3).divide(BigDecimal.valueOf(7), mc);
		BigDecimal minEps = BigDecimal.valueOf(1);
		
		for (int d = 1000000; d > 7; d--) {
			long gcd = d * 7;
			long num3 = d * 3;
			for (int j = 1; j < num3; j++) {
				long num = num3 - j;
				Pair<Long, Long> fraction = reduce(num, gcd);
				if (fraction.getValue1() <= 1000000) {
//					Pair<Long, Long> f2  = Pair.with(fraction.getValue0() * 7, fraction.getValue1() * 7);
//					Pair<Long, Long> f73 = Pair.with(fraction.getValue1() * 3, fraction.getValue1() * 7);
					BigDecimal eps = et.subtract(BigDecimal.valueOf(fraction.getValue0()).divide(BigDecimal.valueOf(fraction.getValue1()), mc));
					if (eps.compareTo(minEps) < 0) {
						minEps = eps;
						System.out.println("f  : " + fraction + " eps : " + eps);
					}
					break;
				}
			}
		}
	}

	private static Pair<Long, Long> reduce(long num, long gcd) {
		List<Long> nDivs = DivisorsHelper.properDivisors(num);
		List<Long> dDivs = DivisorsHelper.properDivisors(gcd);
		nDivs.retainAll(dDivs);
		Long div = nDivs.get(nDivs.size() - 1);
		return Pair.with(num / div, gcd / div);
	}
	
}