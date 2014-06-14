package euler;

import java.math.*;
import java.util.ArrayList;

import euler.utils.DigitUtil;
import euler.utils.DivisorsHelper;
import euler.utils.Prime;

/**
* Sub-string divisibility
* Problem 43
* The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the 
* digits 0 to 9 in some order, but it also has a rather interesting sub-string divisibility 
* property.
*Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
* d2d3d4=406 is divisible by 2
* d3d4d5=063 is divisible by 3
* d4d5d6=635 is divisible by 5
* d5d6d7=357 is divisible by 7
* d6d7d8=572 is divisible by 11
* d7d8d9=728 is divisible by 13
* d8d9d10=289 is divisible by 17
* Find the sum of all 0 to 9 pandigital numbers with this property.
*/
public class Problem43 {
		
	static ArrayList<BigInteger> sq = new ArrayList<BigInteger>();

	public static void main(String[] args) {
		System.out.println("Solve problem 43");
		BigInteger sum = BigInteger.ZERO;
		BigInteger n = BigInteger.valueOf(1000000000);
		BigInteger limit = new BigInteger("5000000000");
		BigInteger step = new BigInteger("10000000");
		while(n.compareTo(limit) < 0) {
			if (n.remainder(step).compareTo(BigInteger.ZERO) == 0) {
				System.out.println(n);				
			}
			if (DigitUtil.isPandigital(n.toString(), 0, 9)) {
				int[] d = DigitUtil.bigIntegerToDigits(n);
				if (isDivisiable(d[1], d[2], d[3], 2)
						&& isDivisiable(d[2], d[3], d[4], 3)
						&& isDivisiable(d[3], d[4], d[5], 5)
						&& isDivisiable(d[4], d[5], d[6], 7)
						&& isDivisiable(d[5], d[6], d[7], 11)
						&& isDivisiable(d[6], d[7], d[8], 13)
						&& isDivisiable(d[7], d[8], d[9], 17)) {
					sum = sum.add(n);
					System.out.println(n + " sum = " + sum);
				}
			}
			n = n.add(BigInteger.ONE);
		}
		System.out.println(sum);
	}
	
	private static boolean isDivisiable(int a1, int a2, int a3, long div) {
		String s = String.valueOf(a1) + String.valueOf(a2) + String.valueOf(a3);
		Integer n = Integer.valueOf(s);
		return n %  div == 0;
	}
	
}