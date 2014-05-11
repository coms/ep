package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import euler.utils.Permutation;
import euler.utils.Prime;
import euler.utils.Sequence;

/**
Prime permutations
Problem 49
The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, 
is unusual in two ways: 
(i) each of the three terms are prime, and, 
(ii) each of the 4-digit numbers are permutations of one another.

There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, 
exhibiting this property, but there is one other 4-digit increasing sequence.

What 12-digit number do you form by concatenating the three terms in this sequence?
*/
public class Problem49 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	public static void main(String[] args) {
		int s = 0;
		for (long n = 1000; n < 10_000; n++) {
			boolean isPrime = Prime.isPrime(n);
//			System.out.println( n + " isPrime : " + isPrime);
			if (isPrime) {
				// prepare array of permutated values
				List<Long> list = new ArrayList<Long>();  
				Permutation perm = new Permutation();
				list.add(n);
				perm.createArray(String.valueOf(n).toCharArray());
				String st = null;
				while (perm.narayanaNextPerm() != null) {
					st = perm.getArray();
					long l = Long.valueOf(st);
					if (Prime.isPrime(l)) {
						list.add(l);
					}
				}
				for (int i = 0; i < list.size() - 2; i ++) {
					for (int j = i + 1; j < list.size() - 1; j ++) {				
						for (int k = j + 1; k < list.size(); k ++) {
							List<Long> seq = new ArrayList<Long>();
							seq.add(list.get(i));
							seq.add(list.get(j));
							seq.add(list.get(k));
							boolean isSequence = Sequence.isArithmeticSequence(seq);
							if (isSequence) {
								System.out.println(seq + " is arithm. progression : " + isSequence);
							}
						}
					}
				}
			}
		}
	}
}
