package euler.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;


// resolve equation with K
// x1*k1+x2*k2+....+x[i]*k[i]=res
public class EquationBI {

	private BigInteger res = BigInteger.ZERO;
	private int size = 8;
	private BigInteger[] k = new BigInteger[size];
	private BigInteger[] x = new BigInteger[size];
	private BigInteger[] xm= new BigInteger[size];
	
	
	public EquationBI(BigInteger res, BigInteger... k) {
		this.res = res;
		this.size = k.length;
		this.k = k;
		this.x = new BigInteger[size];
		this.xm= new BigInteger[size];
		Arrays.fill(x, BigInteger.ZERO);
		for(int i = 0; i < size; i++) {
			xm[i] = res.divide(k[i]);
		}
		
	}
	
	private void inc(int j) throws Exception {
		BigInteger val = x[j];
		if (val.equals(xm[j])) {
			if(j == (size-1)) {
				throw new Exception("no more roots");
			}
			inc(j + 1);
			x[j] = BigInteger.ZERO;
		} else {
			x[j] = x[j].add(BigInteger.ONE);
		}
	}
	
	public BigInteger[] nextRoot() throws Exception {
		do {
				inc(0);
		} while (!sum().equals(res));
		return x;
	}
	
	public BigInteger sum() {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < size; i++) {
			sum = sum.add(x[i].multiply(k[i]));
		}
		return sum;
	}
		
}
