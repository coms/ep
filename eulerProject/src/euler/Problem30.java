package euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import euler.utils.Combination;
import euler.utils.DigitUtil;
import euler.utils.Matrix;
import euler.utils.PrimeNumberUtils;
import euler.utils.Sequence;
import euler.utils.SequenceFinderHelper;

public class Problem30 {

	public static void main(String[] args) {
		Combination comb = new Combination(8);
		comb.setValues(1L, 2L, 5L, 10L, 20L, 50L, 100L, 200L);
		comb.resetCounter();
		for (int i = 0; i < 127; i++) {
			comb.incrementCounter();			
		}
		System.out.println("sum = " + comb.getCoins());
	}

}
