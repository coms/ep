package euler.utils;

import java.util.Arrays;


// resolve equation with K
// x1*k1+x2*k2+....+x[i]*k[i]=res
public class Equation {

	private int res = 0;
	private int size = 8;
	private int[] k = new int[size];
	private int[] x = new int[size];
	private int[] xm= new int[size];
	
	
	public Equation(int res, int... k) {
		this.res = res;
		this.size = k.length;
		this.k = k;
		this.x = new int[size];
		this.xm= new int[size];
		Arrays.fill(x, 0);
		for(int i = 0; i < size; i++) {
			xm[i] = res / k[i];
		}
		
	}
	
	private void inc(int j) throws Exception {
		int val = x[j];
		if (val == xm[j]) {
			if(j == (size-1)) {
				throw new Exception("no more roots");
			}
			inc(j + 1);
			x[j] = 0;
		} else {
			x[j]++;
		}
	}
	
	public int[] nextRoot() throws Exception {
		do {
				inc(0);
		} while (sum() != res);
		return x;
	}
	
	public int sum() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += x[i] * k[i];
		}
		return sum;
	}
		
}
