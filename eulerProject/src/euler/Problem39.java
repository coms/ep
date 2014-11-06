package euler;

import euler.utils.DigitUtil;
import euler.utils.Prime;

/**
* Integer right triangles
* Problem 39
* If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, 
* there are exactly three solutions for p = 120.
* {20,48,52}, {24,45,51}, {30,40,50}
* 
* For which value of p <= 1000, is the number of solutions maximised?
**/
public class Problem39 {

	public static void main(String[] args) {
		int max = 0;
		int maxN = 0;
		int cnt = 0;
		for (int n = 1; n <= 1000; n++) {
			cnt = 0;
			for (int a = 1; a < (n/2); a++ ) {
				for (int b = a+1; b < (n/2); b++ ) {
					int c = n-a-b;
					if (isRightTriangle(a, b, c)) {
						System.out.println(a + "\t" + b + "\t" + c);
						cnt++;
					}
				}
				
			}
			if (cnt > max) {
				max = cnt;
				maxN = n;
			}			
		}
		System.out.println("max = " + max + " maxN = " + maxN);
	}
	
	public static boolean isRightTriangle(long a, long b, long c) {
		return (a*a+b*b)==(c*c);
	}
}
