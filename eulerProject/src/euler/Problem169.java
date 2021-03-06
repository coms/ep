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
* 2 + 8
* 2 + 4 + 4
* 1 + 1 + 8
* 1 + 1 + 4 + 4
* 1 + 1 + 2 + 2 + 4
* 
* What is f(10^25)?
* 
* 1(1) - 1, :1
* 10(2) - 10, 1+1, : 2
* 100(4) - 100, 10+10, 10+1+1, 3
* 1000(8) - 1000, 100+100, 100+10+10, 100+10+1+1 - 4
* 10000(16) - 10000, 1000+1000, 1000+100+100, 1000+100+10+10, 1000+100+10+1+1 - 5
*  
*/
public class Problem169 {
	
	static int m = 10;
	static long pSum = 0;
	
	static BigInteger[] pows = new BigInteger[100];
	
//	static BigInteger n = BigDecimal.ONE.movePointRight(5).toBigInteger();
	static BigInteger n = BigDecimal.valueOf(100).toBigInteger();
	
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static ArrayList<Integer> base = new ArrayList<Integer>();
			
	public static void main(String[] args) {
		System.out.println("Solve problem 169");
		for(int i = 0; i < 100; i++) {
			pows[i] = BigInteger.ONE.shiftLeft(i);
		}
		System.out.println(Arrays.toString(pows));
		
		for (int nd = 10000000; nd < 10000001; nd++) {
			n = BigDecimal.valueOf(nd).toBigInteger();
			String bits = n.toString(2);

			StringBuilder sb = new StringBuilder(bits).reverse();
			System.out.println(n + "_2 = " + bits);
//			System.out.println(n + "_3 = " + new StringBuilder(n.toString(3)));
			bits = sb.toString();
			base.clear();
			for (int i = 0; i < bits.length(); i++) {
				char ch = bits.charAt(i);
				if (ch == '1') {
					base.add(i);
				}
			}
//			for (Integer i : base) {
//				System.out.print(" + 2^" + i + " (" + pows[i] + ")");
//			}
//			System.out.println();
			ArrayList<String> bases = splitToBases(bits);
			
			EquationBI e = new EquationBI(n, pows);
//			for (String bit : bases) {
//				e.setXi(bit.length() - 1, BigInteger.ONE);
//			}
//			e.saveBase();
			int j2 = 0;
			for (int j = 0; j < 10000; j++) {
				try {
//					if (j % 1 == 0) {
//						System.out.println(j);
//					}
					BigInteger[] nextRoot = e.nextRoot();
					// //if (noMoreThenTwice(Arrays.asList(nextRoot))) {
//					System.out.println("!!!" + Arrays.toString(nextRoot));
					// //}
				} catch (Exception e1) {
					System.out.println("j = " + j);
					j2 = j;
					// e1.printStackTrace();
					break;
				}
			}
//			if (j2 == 5) {
//				System.out.println(n + "_2 = " + new StringBuilder(n.toString(2)));
////				System.out.println(n + "_3 = " + new StringBuilder(n.toString(3)));
//			}
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

}