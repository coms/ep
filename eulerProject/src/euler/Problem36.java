package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.javatuples.Pair;

import euler.utils.ArraysHelper;
import euler.utils.DigitUtil;
import euler.utils.MathHelper;

/**
Double-base palindromes
Problem 36
The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)
*/
public class Problem36 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	public static void main(String[] args) {
		int s = 0;
		for (long n = 1; n < 1_000_000; n++) {
			if (DigitUtil.isPalindromic(n) && DigitUtil.isPalindromic(MathHelper.toBinary(n))) {
				s += n;
				System.out.println(sdf.format(new Date()) + " n = " + n + " ; " + MathHelper.toBinary(n));
			}
		}
		System.out.println("s = " + s);
	}
	
}
