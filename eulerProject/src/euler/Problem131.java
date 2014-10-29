package euler;

import java.math.*;

import euler.utils.PowHelper;
import euler.utils.Prime;

public class Problem131 {
//	static ArrayList winCombs = new ArrayList<String>();
		
	// n^3 + n^2*p = p.cubic
	
	public static void main(String[] args) {
		int pSum = 0;
		System.out.println("Solve problem 131");
		long k = 1;
		long _i = 1;
//		BigInteger k2 = BigInteger.ONE;
//		BigInteger limit = BigInteger.TEN.pow(10);
		while (k < 191434753) {
			k++;
			BigInteger _k = BigInteger.valueOf(k);
			BigInteger k3 = _k.multiply(_k).multiply(_k);
			for (long i=_i; (i*i*i)<k; i++) {
				long n=i*i*i;
				BigInteger _n = BigInteger.valueOf(n);
				BigInteger n3=_n.multiply(_n).multiply(_n);
				BigInteger n2=_n.multiply(_n);
				if ((k3.subtract(n3)).remainder(n2).equals(BigInteger.ZERO)) {
					long p = (k3.subtract(n3)).divide(n2).longValue();
					if(Prime.isPrimeFaster(p)) {
						System.out.println(" n= " + n + " (" + i + ") p = " + p + " k3 = " + k3 + " (" + _k + ")");
						_i=i;
						pSum++;
					}
				}
			}
			
		}
		System.out.println(pSum);
	}

	public static void main2(String[] args) {
		int pSum = 0;
		System.out.println("Solve problem 131");
		Prime.resetPrimeSequnce();
		long p = Prime.nextPrime();
		BigInteger k = BigInteger.valueOf(-1);
		float k2 = 4;
		long m = 0;
		long p2 = 2;
		for (long i = 1; i < 1_000_000; i++) {
			k = BigInteger.valueOf(-1);
			Prime.resetPrimeSequnce();
			Prime.skipPrimesTo(p2);
			p = 0;
			long pLimit = (long) (p2 * k2 * 2);
			while (!PowHelper.isPerfectCubic(k) && p < pLimit) {
				p = Prime.nextPrime();
				k = BigInteger.valueOf(i).pow(9).add(BigInteger.valueOf(i).pow(6).multiply(BigInteger.valueOf(p)));
			}
			if (p < pLimit) {
				k2 = (float) p / p2;
				System.out.println("n = " + i*i*i + " p = " + p + " k = " + k + " k2 = " + k2);
				m++;
				p2 = p;
			}
		}
		System.out.println(m);
	}

}