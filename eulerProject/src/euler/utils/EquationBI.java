package euler.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;


// resolve equation with K
// x1*k1+x2*k2+....+x[i]*k[i]=res
public class EquationBI {

	private BigInteger res = BigInteger.ZERO;
	private int size = 8;
	private BigInteger[] k = new BigInteger[size];
	private BigInteger[] x = new BigInteger[size];
	private BigInteger[] xm= new BigInteger[size];
	private BigInteger[] base = new BigInteger[size];
	
	
	public EquationBI(BigInteger res, BigInteger... k) {
		this.res = res;
		this.size = k.length;
		this.k = k;
		this.x = new BigInteger[size];
		this.xm= new BigInteger[size];
		Arrays.fill(x, BigInteger.ZERO);
		for(int i = 0; i < size; i++) {
//			xm[i] = res.divide(k[i]);
			xm[i] = BigInteger.valueOf(2).min(res.divide(k[i])); // stoper for problem 169 no more then twice!!!
		}
		
	}
	
	private void inc(int j) throws Exception {
//		System.out.println(Arrays.toString(x));
		BigInteger val = x[j];
		if (val.equals(xm[j])) {
			if(j == (size-1)) {
				throw new Exception("no more roots");
			}
			x[j] = BigInteger.ZERO;
			inc(j + 1);
			p = j;
		} else {
			x[j] = x[j].add(BigInteger.ONE);
		}
	}

	private static int p = 0;

	public BigInteger[] nextRoot() throws Exception {
		do {
				inc(p);
		} while (!sum().equals(res));
		return x;
	}

	private static int idx = 0;
	private static int jdx = 0;
	
	public BigInteger[] nextRoot2() throws Exception {
		boolean shifted = false;
		while (!shifted) {
			if (idx == 0 && jdx == 0 && startPoints.isEmpty()) {
				throw new Exception("no more roots");
			}
			if (idx == 0 && jdx == 1 && !startPoints.isEmpty()) {
				x = Arrays.copyOf(base, size);
				jdx = startPoints.get(startPoints.size()-1);
				startPoints.remove(startPoints.size()-1);
				idx = jdx;
			}
			if (idx == 0 && jdx > 0) {
				idx = jdx;
				jdx--;
			}
			if ((x[idx].compareTo(BigInteger.ZERO) > 0) && (x[idx - 1].compareTo(BigInteger.ZERO) == 0)) {
				x[idx] = x[idx].subtract(BigInteger.ONE);
				x[idx - 1] = BigInteger.valueOf(2);
				shifted = true;
			}
			idx--;
		}
		return x;
	}
	
	public BigInteger sum() {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < size; i++) {
			sum = sum.add(x[i].multiply(k[i]));
		}
		return sum;
	}

	
	public void saveBase() {
		this.base = Arrays.copyOf(this.x, size);
		startPoints.remove(startPoints.size() - 1);
	}

	ArrayList<Integer> startPoints = new ArrayList<Integer>();
	public void setXi(int i, BigInteger a) {
		x[i] = a;
		idx = Math.max(i, idx);
		jdx = idx;
		startPoints.add(i);
	}
		
}
