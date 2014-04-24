package euler;

import java.math.BigDecimal;
import java.util.List;

import euler.utils.PrimeNumberUtils;
import euler.utils.Sequence;
import euler.utils.SequenceFinderHelper;

public class Problem26 {

	public static void main(String[] args) {
		Integer maxD = 1;
		Integer maxSize = 1;
		for (int d = 2; d < 1000; d++) {
			if (!PrimeNumberUtils.isPrime(d)) {
				continue;
			}
			BigDecimal a = BigDecimal.ONE.divide(new BigDecimal(d), 2000, BigDecimal.ROUND_DOWN);
			System.out.println("1 / " + d + " = " + a );
			List<Sequence> sqns = SequenceFinderHelper.findSequences(a.toPlainString());
//			System.out.println(sqns);
			Integer size = 0;
			for (Sequence sq : sqns) {
				size = Math.max(size, sq.getSize());	
			}
			System.out.println("\t" + size);
			if (size > maxSize) {
				maxSize = size;
				maxD = d;
			}
		}
		System.out.println("maxD : " + maxD + ", maxSize : " + maxSize);
	}

}
