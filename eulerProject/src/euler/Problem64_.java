package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
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

import org.javatuples.Pair;

import sun.security.util.BigInt;
import euler.utils.ArraysHelper;
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


Stuck on 94?
**/

public class Problem64_ {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	public static void main(String[] args) {
		int s = 0;
		for (long n = 108; n <= 109; n++) {
			long startTime = System.currentTimeMillis();
			if (!MathHelper.isInteger(Math.sqrt(n))) {
				long y = 0;
				while (true) {
					// solve sq eq  
					y++;
//					System.out.println("y = " + y);
					BigInteger k1 = BigInteger.valueOf(y);
					BigInteger k = k1.multiply(k1).multiply(BigInteger.valueOf(n));
					BigInteger x1 = k.add(BigInteger.ONE);
					BigInteger x2 = k.subtract(BigInteger.ONE);
//					System.out.println("x1 = " + x1 + " sqrt : " + MathHelper.isPerfectSquare(x1));
//					System.out.println("x2 = " + x2 + " sqrt : " + MathHelper.isPerfectSquare(x2));
//					if (MathHelper.isPerfectSquare(x1)) {
//						long stopTime = System.currentTimeMillis();
//						System.out.println("n = " + n + "; +1; y = " + y + "; time : " + (stopTime - startTime)/1000 + " sec" );
//						break;
//					}
//					if (MathHelper.isPerfectSquare(x2)) {
//						long stopTime = System.currentTimeMillis();
//						s++;
//						System.out.println("n = " + n + "; -1; y = " + y + "; s = " + s+ "; time : " + (stopTime - startTime)/1000 + " sec" );
//						break;
//					}
				}
			}
		}
		System.out.println("n with odd period : " + s);
	}
}
