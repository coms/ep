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
		for (long n = 1000; n < 100000; n++) {
			if (DigitUtil.isRepeatableDigits(n)) {
				System.out.println(n);
			}
		}
		
//		for(int l = 2; l < 3; l++) {
//			int[] a = new int[l];
//			for (int j = l-1; j >= 0; j--) {
//				for (int k = 0; k < 10; k++) {
//					a[j] = k;
//					int n = DigitUtil.digitArrayToInt(a);
//					if (Prime.isPrimeFaster(n)) {
//						System.out.println(n);
//						
//					}
//				}				
//			}
//		}
		
	}
	
}
