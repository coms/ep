package euler;

import java.math.*;

public class Problem121 {

	static MathContext itgr = new MathContext(0, RoundingMode.FLOOR);
	static BigDecimal total = new BigDecimal("21");
	static int scale = 50;
	static int rounds = 15;
	static int[] ps = null;
	static int m = 10;
	static long pSum = 0;
//	static ArrayList winCombs = new ArrayList<String>();
		
	public static void main(String[] args) {
		System.out.println("Solve problem 121");
		int maxRisedBits = rounds % 2 == 0 ? (int) Math.ceil((rounds - 1) / 2) : (int) Math.ceil((rounds - 1) / 2);
		ps = new int[rounds];
		m = 1 << rounds;
		System.out.println("rounds = " + rounds + " maxRisedBits = " + maxRisedBits + " m = " + m);
		for (int i = 0; i < m; i++) {
			if (Integer.bitCount(i) <= maxRisedBits) {
				String bits = Integer.toBinaryString(i);
				int leadingZeros = rounds - bits.length();
				for (int z = 0; z < leadingZeros; z++) {
					bits = "0" + bits;
				}
//				winCombs.add(bits);
				long pProb = pProb(bits);
				System.out.println("bits = " + bits + " lz=" + leadingZeros + " prob = " + pProb);
				pSum += pProb;
			}
		}
		System.out.println("pSum = " + pSum);
		long q = fact(rounds + 1);
		System.out.println("fact (" + (rounds + 1) + ") = " +  q);
		System.out.println("1/prob = " + q / pSum);
	}
	
	public static long fact(int n) {
		long retval = 1l;
		if (n > 1l) {
			return n * fact(n - 1);
		} else {
			return 1;
		}
	}

	public static long pProb(String s) {
		char[] chrs = s.toCharArray();
		long retval = 1l;
		for (long i = 0; i < s.length(); i++) {
			if (chrs[(int) i] == '1') {
				retval *= (i + 1);
			}
		}
		return retval;
	}
	
}