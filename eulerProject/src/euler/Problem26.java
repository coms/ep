package euler;

import java.math.BigDecimal;

import euler.utils.SequenceFinderHelper;

public class Problem26 {

	public static void main(String[] args) {
		SequenceFinderHelper.findSequences("142857142857142857142857142857142857142857142857142857142858");
		/*
		for (int d = 1; d < 1000; d++) {
			BigDecimal a = BigDecimal.ONE.divide(new BigDecimal(d), 60, BigDecimal.ROUND_CEILING);
			//BigDecimal a = new BigDecimal( 1.0d / (double) d);
			System.out.println("1 / " + d + " = " + a );
		}
		*/
	}

}
