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

/**
* Square digit chains
* Problem 92
* A number chain is created by continuously adding the square of the digits 
* in a number to form a new number until it has been seen before.
* 
* For example,
* 
* 44 → 32 → 13 → 10 → 1 → 1
* 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
* 
* Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. 
* What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.
* 
* How many starting numbers below ten million will arrive at 89? 
*/
public class Problem92 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	public static void main(String[] args) {
		int counter89 = 0;
		for (int n = 1; n < 10_000_000; n++) {
			if (n % 100_000 == 0) {
				System.out.println(sdf.format(new Date()) + " n = " + n);
			}
			int k = n;
			int s = 0;
			while ((k != 1) && (k != 89)) {
				int[] na = DigitUtil.intToDigits(k);
				for (int i : na) {
					s+=i*i;
				}
//				System.out.println(s);
				k = s;
				s = 0;
			}
			if (k == 89) {
				counter89++;
			}
		}
		System.out.println("counter89 = " + counter89);
	}
	
}
