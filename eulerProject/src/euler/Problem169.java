package euler;

import java.math.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import euler.utils.EquationBI;

/**
* Exploring the number of different ways a number can be expressed as a sum of powers of 2
* Problem 169
* Define f(0)=1 and f(n) to be the number of different ways n can be expressed as a 
* sum of integer powers of 2 using each power no more than twice.
*
* For example, f(10)=5 since there are five different ways to express 10:
* 1 + 1 + 8
* 1 + 1 + 4 + 4
* 1 + 1 + 2 + 2 + 4
* 2 + 4 + 4
* 2 + 8
* 
* What is f(10^25)?
*/
public class Problem169 {
	
	static int m = 10;
	static long pSum = 0;
	
	static BigInteger[] pows = new BigInteger[100];
	
	static BigInteger n = BigDecimal.ONE.movePointRight(1).toBigInteger();
	
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static ArrayList<Integer> base = new ArrayList<Integer>();
			
	public static void main(String[] args) {
		System.out.println("Solve problem 169");
		for(int i = 0; i < 100; i++) {
			pows[i] = BigInteger.ONE.shiftLeft(i);
		}
		System.out.println(Arrays.toString(pows));
		String bits = n.toString(2);
		StringBuilder sb = new StringBuilder(bits).reverse();
		System.out.println(n + "_2 = " + bits);
		bits = sb.toString();
		for (int i = 0; i < bits.length(); i++) {
			char ch = bits.charAt(i);
			if (ch == '1') {
				base.add(i);
			}
		}
		
		System.out.println("possible combination = ");
		for (Integer i : base) {
			System.out.print(" + 2^" + i + " (" + pows[i] + ")");
		}
		System.out.println();
		ArrayList<String> bases = splitToBases(bits);
		System.out.println("bases : " + bases);
		
		ArrayList<String> permuted = new ArrayList<String>(bases);
		for (int i = 0; i < bases.size(); i++) {
			int j = i;
			while (permuted.get(j).length() > 1) {
				String shifted = permuted.get(j).substring(0, permuted.get(j).length() - 1);
				if (!permuted.contains(shifted)) {
					permuted.add(j    , shifted);
					permuted.set(j + 1, shifted);
					System.out.println(permuted + " i = " + i + " j = " + j);
				} else {
					if (tailIsSimplest(permuted.subList(0, j+1))) {
						j++;
					} else {
						j--;
					}
				}
			}
			permuted = new ArrayList<String>(bases);
		}
		
	}
	
	private static String getPowAsBits(int n) {
		return new StringBuilder(pows[n].toString(2)).reverse().toString();
	}
	
	private static boolean tailIsSimplest(List<String> tail) {
		for (int i = 0; i < tail.size(); i++) {
			int n = (int) i / 2;
			if (!getPowAsBits(n).equals(tail.get(i))) {
				return false;
			}
		}
		return true;
	}
	
	private static ArrayList<String> splitToBases(String bits) {
		ArrayList<String> retval = new ArrayList<String>();
		for (int i = 0; i < bits.length(); i++) {
			if(bits.charAt(i) == '1') {
				String nulls = "";
				for (int j = 0; j < i; j++) {
					nulls += "0";
				}
				retval.add("1" + nulls);
			}
		}
		return retval;
	}
	
	private static boolean isNoMoreTwice(List<BigInteger> list) {
		HashMap<BigInteger, Integer> cnts = new HashMap<BigInteger, Integer>();
		for (BigInteger i : list) {
			if (!cnts.containsKey(i)) {
				cnts.put(i, 0);
			}
			Integer val = cnts.get(i);
			val++;
			cnts.put(i, val);
			if (val > 2) {
				return false;
			}
		}		
		return true;
	}
	
	private static boolean noMoreThenTwice(List<BigInteger> list) {
		for (BigInteger i : list) {
			if (i.compareTo(BigInteger.valueOf(2)) > 0) {
				return false;
			}
		}		
		return true;
	}	

	
////	int[] intPows = {64, 32, 16, 8, 4, 2, 1};
//	EquationBI e = new EquationBI(n, pows);
//	for (int j = 0; j < 10000; j++) {
//		try {
//			if (j % 1 == 0) {			
//				System.out.println(j);
//			}
//			BigInteger[] nextRoot = e.nextRoot();
//			//if (noMoreThenTwice(Arrays.asList(nextRoot))) {
////				System.out.println("!!!" + Arrays.toString(nextRoot));
//			//}
//		} catch (Exception e1) {
//			System.out.println("j = " + j);
//			e1.printStackTrace();
//			break;
//		}
//	}


}