package euler;

import java.math.BigInteger;
import java.util.HashSet;

public class Problem29 {

	public static void main(String[] args) {
		HashSet<BigInteger> set = new HashSet<BigInteger>();
		int maxPow = 100;
		for (int i = 2; i <= maxPow; i++) {
			for (int j = 2; j <= maxPow; j++) {
				BigInteger a = BigInteger.valueOf(i);
				BigInteger b = a.pow(j);
//				System.out.println(b);
				set.add(b);
			}			
		}
		System.out.println("set size : " + set.size());
	}

}
