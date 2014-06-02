package euler.geom;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Line {
	
	static int scale = 50;
	static MathContext real = new MathContext(scale, RoundingMode.HALF_UP);
	static MathContext itgr = new MathContext(0, RoundingMode.FLOOR);

	private Point p1 = null;
	private Point p2 = null;
	
	private BigDecimal k = null;
	private BigDecimal b = null;
	
	/**
	 * Create line by 2 points.
	 */
	public Line(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		BigDecimal kp = p2.getY().subtract(p1.getY(), real);
		BigDecimal kq = p2.getX().subtract(p1.getX(), real);
		this.k = kp.divide(kq, real);
		this.b = p1.getY().subtract(p1.getX().multiply(k, real), real);
	}

	/**
	 * Create line by slant and point.
	 * 
	 * @param k
	 * @param b
	 */
	public Line(double alpha, Point p) {
		super();
		this.p1 = p;
		this.k = new BigDecimal(Math.tan(Math.toRadians(alpha)));
		this.b = p.getY().subtract(this.k.multiply(p.getX(), real), real); 
	}

	/**
	 * Create line by y = k*x + b
	 * @param k
	 * @param b
	 */
	public Line(BigDecimal k, BigDecimal b) {
		super();
		this.k = k;
		this.b = b;
	}

	/**
	 * @return  slope of line in degrees
	 */
	public double slope() {
		double slope = Math.toDegrees(Math.atan(this.k.doubleValue()));
//		if (slope < 0) {
//			slope = slope + 180d;
//		}
		return slope;
	}
	
	public BigDecimal getK() {
		return this.k;
	}

	public BigDecimal getB() {
		return this.b;
	}
	
	/**
	 * Return Y value in given X.
	 * @param x
	 * @return
	 */
	public BigDecimal getValue(BigDecimal x) {
		return x.multiply(k, real).add(b, real);
	}

	@Override
	public String toString() {
		return "Line [slope()=" + slope() + ", getK()=" + getK() + ", getB()=" + getB() + "]";
	}
	
}
