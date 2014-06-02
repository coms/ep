package euler.geom;

import java.math.BigDecimal;

public class Line {

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
		return Math.toDegrees(Math.atan(k.doubleValue()));
	}
	
	
	
}
