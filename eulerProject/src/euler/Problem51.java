package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

import euler.utils.AlphabetHelper;
import euler.utils.DigitUtil;
import euler.utils.MathHelper;
import euler.utils.PowHelper;
import euler.utils.Prime;

/**
* Prime digit replacements
* 
* Problem 51
* 
* By replacing the 1st digit of the 2-digit number *3, it turns out that six of the 
* nine possible values: 13, 23, 43, 53, 73, and 83, are all prime.
* 
* By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit 
* number is the first example having seven primes among the ten generated numbers, 
* yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and 56993. 
* Consequently 56003, being the first member of this family, is the smallest prime with 
* this property.
* 
* Find the smallest prime which, by replacing part of the number (not necessarily 
* adjacent digits) with the same digit, is part of an eight prime value family.
*
**/
public class Problem51 {

	public static void main(String[] args) {
		int maxPrimes = 0;
		long n0 = 0;
		String maxMask = "";
		for (long n = 100000; n < 1000000; n++) {
			int size = String.valueOf(n).length();
			int m_size = (int) PowHelper.pow(2, size);
			String nulls = String.format("%0" + size + "d", 0);
			if (Prime.isPrimeFaster(n)) {
//				System.out.println(n);
				for (int mask = 1; mask < m_size; mask++) {
					int primes = 1;
					long[] aN = DigitUtil.longToDigits(n);
					String binaryMask = Integer.valueOf(mask).toBinaryString(mask);
					String s_mask = (nulls + binaryMask).substring(binaryMask.length());
//					System.out.println("mask : " + s_mask);
					for (int i_mask = 0; i_mask < s_mask.length(); i_mask++) {
						if (!isDigitsSame(s_mask, n)) {
							break; 
						}
						while (replace(s_mask, aN)) {
							long n2 = DigitUtil.digitArrayToLong(aN); 
							if (Prime.isPrimeFaster(n2)) {
//								System.out.println(n2 + " is Prime!!");
								primes++;
							}
						}
					}
//					System.out.println("!!! primes = " + primes);
					if (primes > maxPrimes) {
						maxMask = s_mask;
						maxPrimes = primes;
						n0 = n;
					}
				}
			}
		}
		System.out.println("!!! maxPrimes = " + maxPrimes);
		System.out.println("!!! n0 = " + n0);
		System.out.println("!!! maxMask = " + maxMask);
	}

	private static boolean isDigitsSame(String s_mask, long n) {
		String sn = String.valueOf(n);
		char digit = 0x00;
		for (int i = 0; i < s_mask.length(); i++) {
			if (s_mask.charAt(i) == '1') {
				if (digit == 0x00) {
					digit = sn.charAt(i);
				} else {
					if (sn.charAt(i) != digit) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static boolean replace(String s_mask, long[] n) {
		String sn = String.valueOf(DigitUtil.digitArrayToLong(n));
		long digit = 99;
		for (int i = 0; i < s_mask.length(); i++) {
			if (s_mask.charAt(i) == '1') {
				if (digit == 99) {
					digit = Long.valueOf("" + sn.charAt(i)) + 1L;
					if (digit == 10) {
						return false;
					}
				} 
				n[i] = digit;
			}
		}
		return true;
	}
}
