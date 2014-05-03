package euler;

import euler.utils.Equation;

public class Problem31 {

	public static void main(String[] args) {
		Equation eq = new Equation(200, 200, 100, 50, 20, 10, 5, 2, 1);
		int i = 1;
		try {
		for (i =  1; i < 100000; i++) {
				eq.nextRoot();
				if (i % 10000 == 0) {
					System.out.println(i);
				}
			//System.out.println("x[" + i + "] = " + Arrays.toString(eq.nextRoot()));
		}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(i - 1);
		}
	}

}
