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
import euler.utils.Fraction;
import euler.utils.MathHelper;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Problem 57
* sqrt(2) =
 **/
public class Problem57 {

	public static void main(String[] args) {
		int sum = 0;
		BigInteger n_1 = BigInteger.valueOf(3);
		BigInteger d_1 = BigInteger.valueOf(2);
		BigInteger n = BigInteger.ZERO;
		BigInteger d = BigInteger.ZERO;
		for (int i = 2; i <= 1000; i++) {
			d = d_1.add(n_1);
			n = d_1.add(d);
//			System.out.println(i + ":" + n + "/" + d );
			d_1 = d;
			n_1 = n;
			if (n.toString().length() > d.toString().length()) {
				System.out.println("i=" + i);
				sum++;
			}
		}
		System.out.println("sum = " + sum);
	}
	
}
