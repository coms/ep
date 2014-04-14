package euler;

import euler.utils.DivisorsHelper;

public class Problem21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		System.out.println("is Amicable 284, 220: " + MathUtils.isAmicableNumbers(284l, 220l));

		Long sum = 0L;
		for (Long i = 2l; i <= 10000l; i++) {
			Long sum1 = DivisorsHelper.properDivisorsSum(i);
			Long sum2 = DivisorsHelper.properDivisorsSum(sum1);
			if (sum2.equals(i) && (!sum1.equals(sum2)) && sum2 < sum1) {
				// is amicable number!!!
				System.out.println("Found amicable numbers : " + sum2 + ":" + sum1 );
				sum += (sum1 + sum2);
			}
		}
		System.out.println(sum);

	}

}
