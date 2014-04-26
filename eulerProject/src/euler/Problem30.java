package euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import euler.utils.DigitUtil;
import euler.utils.Matrix;
import euler.utils.PrimeNumberUtils;
import euler.utils.Sequence;
import euler.utils.SequenceFinderHelper;

public class Problem30 {

	public static void main(String[] args) {
		Long s = 0L;
		for (Long i = 2L; i < 10000000L; i++) {
			Long[] a = DigitUtil.longToDigits(i);
			Long sum = 0L;
			for (Long l : a) {
				sum = sum + (long) Math.pow(l, 5);
			}
			if (sum.equals(i)) {
				s += sum;
				System.out.println(i + " = " + sum);
			}
		}
		System.out.println("sum = " + s);
	}

}
