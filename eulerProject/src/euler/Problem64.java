package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import euler.utils.ArraysHelper;
import euler.utils.BigSquareRoot;
import euler.utils.DigitUtil;
import euler.utils.MathHelper;
import euler.utils.Permutation;
import euler.utils.Prime;
import euler.utils.Sequence;

/**
Odd period square roots
Problem 64
All square roots are periodic when written as continued fractions and can be written in the form:
It can be seen that the sequence is repeating. For conciseness, we use the notation 
√23 = [4;(1,3,1,8)], to indicate that the block (1,3,1,8) repeats indefinitely.
The first ten continued fraction representations of (irrational) square roots are:
√2=[1;(2)], period=1
√3=[1;(1,2)], period=2
√5=[2;(4)], period=1
√6=[2;(2,4)], period=2
√7=[2;(1,1,1,4)], period=4
√8=[2;(1,4)], period=2
√10=[3;(6)], period=1
√11=[3;(3,6)], period=2
√12= [3;(2,6)], period=2
√13=[3;(1,1,1,1,6)], period=5
Exactly four continued fractions, for N ≤ 13, have an odd period.
How many continued fractions for N ≤ 10000 have an odd period?
**/

public class Problem64 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	private static int scale = 200;
	
	public static void main(String[] args) {
		int oddPeriods = 0;
		MathContext mc = new MathContext(scale);
		for (long n = 2; n <= 10000; n++) {
			if (!MathHelper.isInteger(Math.sqrt(n))) {
//				System.out.print("sqrt(" + n + ") = [");
				BigSquareRoot bsr = new BigSquareRoot();
				bsr.setScale(scale);
//				bsr.setTraceFlag(true);
				BigDecimal x = bsr.get(BigInteger.valueOf(n));
				long a0 = Double.valueOf(x.doubleValue()).longValue();
				long a = a0;
//				System.out.print(a0 + ";(");
//				System.out.println(" a0 = " + a0 + " x = " + x);
				int i = 0;
				BigDecimal one = BigDecimal.ONE.setScale(scale); 
				while (a != a0 * 2) {
					i++;
					BigDecimal bdA = BigDecimal.valueOf(a);
					bdA.setScale(scale);
					BigDecimal diff = x.subtract(bdA, mc); 
//					System.out.println("diff = " + diff);
					x = one.divide(diff, mc);
					a = x.longValue();
//					System.out.println(" i = " + i + " x = " + x + " a = " + a);
//					System.out.print(a + ",");
				}
//				System.out.println(")]");
				System.out.println(" n :" + n + " period : " + i);
				if (i % 2 == 1) {
					oddPeriods++;
				}
			}
		}
		System.out.println("odd periods : " + oddPeriods);
	}
}
