package euler.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class MathHelper {

	private static List<BigInteger> cache = new ArrayList<BigInteger>();
	
	static {
		cache.add(new BigInteger("1"));
		cache.add(new BigInteger("1"));
		cache.add(new BigInteger("2"));
		cache.add(new BigInteger("6"));
		cache.add(new BigInteger("24"));
		cache.add(new BigInteger("120"));
		cache.add(new BigInteger("720"));
		cache.add(new BigInteger("5040"));
		cache.add(new BigInteger("40320"));
		cache.add(new BigInteger("362880"));
	}
	
	/**
	 * Return n!
	 * @param n
	 * @return
	 */
	public static BigInteger factorial(int n) {
		if (n < 10) {
			return cache.get(n);
		}
		BigInteger b = new BigInteger(String.valueOf(n));
		if (n > 1) {
			b = b.multiply(factorial(n - 1));
		}
		return b;
	}
	
	public static boolean isInteger(double n) {
		return (n == (long) n);
	}

	public static String toBinary(long n) {
		BigInteger bin = new BigInteger(String.valueOf(n));
		return bin.toString(2);
	}
	
	/**
	 * Checks two BigDecimal with given precision - number of nulls after point. 
	 * 
	 * @return
	 */
	public static boolean isEqual(BigDecimal n1, BigDecimal n2, int precision) {
		BigDecimal alpha = BigDecimal.ONE.movePointLeft(precision); 
		return n1.subtract(n2).abs().compareTo(alpha) <= 0 ;
	}

}
