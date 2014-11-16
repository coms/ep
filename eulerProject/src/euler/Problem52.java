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
* Permuted multiples
* Problem 52
* It can be seen that the number, 125874, and its double, 251748, 
* contain exactly the same digits, but in a different order.
*
* Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
*
**/
public class Problem52 {

	public static void main(String[] args) {
		for (long k1 = 100000; k1 < 166666; k1++) {
			long k6 = 6 * k1;
			long k5 = 5 * k1;
			long k4 = 4 * k1;
			long k3 = 3 * k1;
			long k2 = 2 * k1;
			int m6 = DigitUtil.multOfDigits(k6);
			if (m6 == DigitUtil.multOfDigits(k5)
				&& m6 == DigitUtil.multOfDigits(k4)
				&& m6 == DigitUtil.multOfDigits(k3)
				&& m6 == DigitUtil.multOfDigits(k2) 
				&& m6 == DigitUtil.multOfDigits(k1)) {
					System.out.println(k1);
					System.out.println(k2);
					System.out.println(k3);
					System.out.println(k4);
					System.out.println(k5);
					System.out.println(k6);
					System.out.println("----------");
				}
		}		
	}
	
}
