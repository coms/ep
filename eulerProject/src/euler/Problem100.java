package euler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

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

	static MathContext itgr = new MathContext(0, RoundingMode.FLOOR);
	static BigDecimal total = new BigDecimal("21");
	static BigDecimal limit = new BigDecimal("1000000000000");
	static BigDecimal blue = new BigDecimal("15");
	static BigDecimal addTotal = new BigDecimal("12"); // magic numbers
	static BigDecimal addBlue = new BigDecimal("8"); // magic numbers
	static BigDecimal prob = prob(total, blue);
	static BigDecimal k = new BigDecimal(120d/21d);
	static int scale = 50;
		
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("Solve problem 100");
		System.out.println("total = " + total + ", blue = " + blue + ", prob = " + prob + ", k = " + k);
		BigDecimal nextTotal = total.multiply(k, itgr).setScale(0, RoundingMode.DOWN);
		BigDecimal nextBlue = blue.multiply(k, itgr).setScale(0, RoundingMode.DOWN);
		BigDecimal two = new BigDecimal(2);
		do {
			prob = prob(nextTotal, nextBlue);
			if (prob.compareTo(two) == 0) {
				System.out.println("--- We found next solution!");
				System.out.println("[found values] nextTotal = " + nextTotal + ", nextBlue = " + nextBlue + ", k = " + k);
				k = nextTotal.divide(total, scale, RoundingMode.DOWN);
				total = new BigDecimal(nextTotal.toString());
				blue = new BigDecimal(nextBlue.toString());
				nextTotal = nextTotal.multiply(k, itgr).add(addTotal).setScale(0, RoundingMode.DOWN);
				nextBlue = nextBlue.multiply(k, itgr).add(addBlue).setScale(0, RoundingMode.DOWN);
				System.out.println("[probable values] nextTotal = " + nextTotal + ", nextBlue = " + nextBlue + ", k = " + k);
			} else if (prob.compareTo(two) > 0) {
				nextBlue = nextBlue.add(BigDecimal.ONE);
			} else if (prob.compareTo(two) < 0) {
				nextTotal = nextTotal.add(BigDecimal.ONE);
			}
		} while(total.compareTo(limit) < 0);
		System.out.println("Elapsed time : " + (System.currentTimeMillis() - startTime) + " ms ");
	}

	private static BigDecimal prob(BigDecimal total, BigDecimal blue) {
		BigDecimal p = total.multiply(total.subtract(BigDecimal.ONE));
		BigDecimal q = blue.multiply(blue.subtract(BigDecimal.ONE));
		return p.divide(q, scale, RoundingMode.FLOOR);
	}
}
