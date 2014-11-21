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
* Problem 63
* n-th power
 **/
public class Problem63 {

	public static void main(String[] args) {
		long sum = 0;
		long maxSum = 0;
		int maxA = 0;
		int maxB = 0;
		for (int a = 1; a < 10 ; a++) {
			for (int b = 1; b < 24; b++) {
				BigInteger a1 = BigInteger.valueOf(a);
				BigInteger c = a1.pow(b);
				if (c.toString().length() == b) {	
					sum++;
					System.out.println(a + "^" + b + "=" + c + " : " + sum);
				}
			}
		}
//		System.out.println(maxSum + ", a=" + maxA + ", b=" + maxB);
	}
	
}
