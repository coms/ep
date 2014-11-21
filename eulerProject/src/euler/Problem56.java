package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import euler.poker.PokerHand;
import euler.utils.AlphabetHelper;
import euler.utils.DigitUtil;
import euler.utils.MathHelper;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Powerful digit sum
* Problem 56
* A googol (10^100) is a massive number: one followed by one-hundred zeros; 
* 100^100 is almost unimaginably large: one followed by two-hundred zeros. 
* Despite their size, the sum of the digits in each number is only 1.
* 
* Considering natural numbers of the form, a^b, where a, b < 100, 
* what is the maximum digital sum?
 **/
public class Problem56 {

	public static void main(String[] args) {
		long sum = 0;
		long maxSum = 0;
		int maxA = 0;
		int maxB = 0;
		for (int a = 99; a > 50; a--) {
			for (int b = 100; b > 50; b--) {
				BigInteger a1 = BigInteger.valueOf(a);
				BigInteger c = a1.pow(b);
				sum = DigitUtil.sumOfDigits(c);
				System.out.println(a + "^" + b + "=" + c + " : " + sum);
				if (sum > maxSum) {
					maxSum = sum;
					maxA = a;
					maxB = b;
				}
			}
		}
		System.out.println(maxSum + ", a=" + maxA + ", b=" + maxB);
	}
	
}
