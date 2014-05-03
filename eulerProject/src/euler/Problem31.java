package euler;

import java.util.HashSet;
import java.util.Set;

import euler.utils.DigitUtil;


public class Problem31 {

	public static void main(String[] args) {
//		System.out.println(DigitUtil.isPandigital(123456789, 9));
		Set<Integer> ks = new HashSet();
		int sum = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 1; j < 10000; j++) {
				int k = i * j;
				String s = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
//				System.out.println(s);
				if (DigitUtil.isPandigital(s, 9)) {					
					System.out.println("i = " + i + "; j = " + j + "; k = " + k);
					if (!ks.contains(k)) {
						ks.add(k);
						sum += k;
					}
				}
			}	
		}
		System.out.println("sum = " + sum);
	}

}
