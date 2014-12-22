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
 * Spiral primes
 * Problem 58
 * 
 * Starting with 1 and spiralling anticlockwise in the following way, 
 * a square spiral with side length 7 is formed.

 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18  5  4  3 12 29
 * 40 19  6  1  2 11 28
 * 41 20  7  8  9 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49

 * It is interesting to note that the odd squares lie along the bottom right diagonal, 
 * but what is more interesting is that 8 out of the 13 numbers lying along both 
 * diagonals are prime; that is, a ratio of 8/13 ≈ 62%.

 * If one complete new layer is wrapped around the spiral above, 
 * a square spiral with side length 9 will be formed. If this process is continued, 
 * what is the side length of the square spiral for which the ratio of primes along 
 * both diagonals first falls below 10%? 
 **/
public class Problem58 {

	public static void main(String[] args) {
		long primes = 0;
		long nums = 1;
		for (long i = 1; i < 50000; i = i + 2) {
			long d =  i * i;
			long c = d - 1 * i + 1;
			long b = d - 2 * i + 2;
			long a = d - 3 * i + 3;
			System.out.println("a = " + a + "; b = " + b + "; c = " + c + "; d = " + d);
			if (Prime.isPrimeFaster(a)) {
				primes++;
		    }
			if (Prime.isPrimeFaster(b)) {
				primes++;
		    }
			if (Prime.isPrimeFaster(c)) {
				primes++;
		    }
			if (Prime.isPrimeFaster(d)) {
				primes++;
		    }
			double r = (double) primes / (double) nums;
			nums = nums + 4;
			System.out.println("r = " + r + "; i = " + i);
			if (r < 0.1d && i > 1) {
				System.exit(0);
			}
		}
	}
	
	
}
