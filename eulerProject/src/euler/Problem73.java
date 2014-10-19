package euler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import org.javatuples.Pair;
import euler.utils.DivisorsHelper;

/**
Counting fractions in a range
Problem 73
Consider the fraction, n/d, where n and d are positive integers. If n<d and HCF(n,d)=1,
 it is called a reduced proper fraction.

If we list the set of reduced proper fractions for d <= 8 in ascending order of size, we get:

1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5,
 5/6, 6/7, 7/8

It can be seen that there are 3 fractions between 1/3 and 1/2.

How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for 
d <= 12,000?
 */
public class Problem73 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 73");
		MathContext mc = new MathContext(100, RoundingMode.HALF_DOWN);
		BigDecimal left = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3), mc);
		BigDecimal right = BigDecimal.valueOf(1).divide(BigDecimal.valueOf(2), mc);
		long c = 0;
		for (long j = 5; j <= 12000; j++) {
			for (long i = Math.max(2, (long) Math.floor(j/3 + 1)); i <= (j/2); i++) {
				Pair<Long, Long> fraction = reduce(i, j);
				if (fraction.getValue1() == j) {
					System.out.println(i + "/" + j);
					c++;					
				}
				
			}
		}
		System.out.println(c);
//		for (int d = 1000000; d > 7; d--) {
//			long gcd = d * 7;
//			long num3 = d * 3;
//			for (int j = 1; j < num3; j++) {
//				long num = num3 - j;
//				Pair<Long, Long> fraction = reduce(num, gcd);
//				if (fraction.getValue1() <= 1000000) {
//					Pair<Long, Long> f2  = Pair.with(fraction.getValue0() * 7, fraction.getValue1() * 7);
//					Pair<Long, Long> f73 = Pair.with(fraction.getValue1() * 3, fraction.getValue1() * 7);
//					BigDecimal eps = et.subtract(BigDecimal.valueOf(fraction.getValue0()).divide(BigDecimal.valueOf(fraction.getValue1()), mc));
//					if (eps.compareTo(minEps) < 0) {
//						minEps = eps;
//						System.out.println("f  : " + fraction + " eps : " + eps);
//					}
//					break;
//				}
//			}
//		}
	}

	private static Pair<Long, Long> reduce(long num, long gcd) {
		List<Long> nDivs = DivisorsHelper.divisors(num);
		List<Long> dDivs = DivisorsHelper.divisors(gcd);
		nDivs.retainAll(dDivs);
		Long div = nDivs.get(nDivs.size() - 1);
		return Pair.with(num / div, gcd / div);
	}
	
}