package euler.utils;

public class E {
	
	static int denomSeqIdx = 0;
	
	int[] denomSequence = {2,  1,2,1, 1,4,1, 1,6,1, 1,8,1, 1,10,1, 1,12,1, 1,14,1, 1,16,1, 1,18,1 };
	
	public static Fraction getFraction(int n) {
		Fraction k = new Fraction(2,1);
		Fraction nextFraction = getNextFraction(n, 1);
		Fraction res = null;
		if (nextFraction != null) {
			res = k.add(nextFraction);	
		} else {
			res = k;
		}
		return res;
	}

	public static Fraction getNextFraction(int n, int i) {
		Fraction k = new Fraction(0, 1);
		if (i < n) {
			int an = getDenom(i+1); // proved
			System.out.println("a[" + i + "] = " + an);
			Fraction nextFraction = getNextFraction(n, i + 1);
			nextFraction = new Fraction(nextFraction.getDenominator(), nextFraction.getNumerator());
			System.out.println("k[" + i + "] prepared to be " + new Fraction(an, 1) + " + (" + nextFraction + ")");
			k = (new Fraction(an, 1)).add(nextFraction);	
//			System.out.println("k_i = " + k + "; i = " + i);
		}
		return k;
	}
	
	public static int getDenom(int n) {
		if (n % 3 == 0) {
			return n / 3 * 2;
		} else {
			return 1;
		}
	}


}
