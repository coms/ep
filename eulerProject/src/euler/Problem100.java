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
Arranged probability
Problem 100
If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs, and two discs were taken at random, 
it can be seen that the probability of taking two blue discs, P(BB) = (15/21)×(14/20) = 1/2.

The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random, is a box containing eighty-five 
blue discs and thirty-five red discs.

By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 discs in total, determine the number of blue discs that 
the box would contain.
**/

public class Problem100 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	private static int scale = 200;
	
	private static BigDecimal total2;

	public static void main(String[] args) {
		int oddPeriods = 0;
		MathContext mc = new MathContext(scale);
		BigDecimal n = new BigDecimal("1000000000000");
		total2 = n.subtract(BigDecimal.ONE);
		BigDecimal p = new BigDecimal("0.5");
		BigSquareRoot bsr = new BigSquareRoot();
		bsr.setScale(scale);
		BigDecimal sq = bsr.get(p);
		System.out.println("sqrt(n) = " + sq);
//		BigDecimal startNumber = sq.multiply(n).setScale(0, RoundingMode.FLOOR);
		BigDecimal startNumber = new BigDecimal(sq.multiply(n).longValue());
		System.out.println("sqrt(n) * p = " + startNumber);
		for (int i = 0; i< 10; i++) {
			System.out.println(getProb(n, startNumber).equals(p));
			startNumber = startNumber.add(BigDecimal.ONE);
		}
//		while (!getProb(n, startNumber).equals(p)) {
//		}
	}
	
	public static BigDecimal getProb(BigDecimal total, BigDecimal blue) {
		System.out.println("total = " + total + ", blue = " + blue);
		BigDecimal p1 = blue.divide(total, scale, RoundingMode.FLOOR);
//		System.out.println("p1 = " + p1);
		BigDecimal b2 = blue.subtract(BigDecimal.ONE);
//		System.out.println("b2 = " + b2);
		BigDecimal p2 = b2.divide(total2, scale, RoundingMode.FLOOR);
		BigDecimal p = p1.multiply(p2); 
		System.out.println("p = " + p);
		return p;
	}
}
