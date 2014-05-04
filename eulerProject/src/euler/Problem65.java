package euler;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import euler.utils.ArraysHelper;
import euler.utils.DigitUtil;
import euler.utils.E;
import euler.utils.Fraction;
import euler.utils.PowHelper;
import euler.utils.PrimeNumberUtils;


/**
 * 
 */
public class Problem65 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String[] args) {
		System.out.println(E.getFraction(100));

		BigInteger bi1 = new BigInteger(
				"6241836439384347364755929035475107661629176932089826197066");
		BigInteger bi2 = new BigInteger(
				"721687998492614384364344789144430684808846256124649473601");
		BigInteger bi3 = bi1.add(bi2);
		System.out.println(bi3);
		System.out.println(ArraysHelper.sum(DigitUtil.bigIntegerToDigits(bi3)));
	}
}
