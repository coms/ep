package euler;

import java.math.*;
import java.util.Arrays;

import euler.geom.Line;
import euler.geom.Point;
import euler.utils.BigSquareRoot;
import euler.utils.MathHelper;

/**
 * 
 *
 * In laser physics, a "white cell" is a mirror system that acts as a delay line for the laser beam. 
 * The beam enters the cell, bounces around on the mirrors, and eventually works its way back out.
 * The specific white cell we will be considering is an ellipse with the equation 4x^2 + y^2 = 100
 * 
 * The section corresponding to −0.01 ≤ x ≤ +0.01 at the top is missing, allowing the light 
 * to enter and exit through the hole.
 * 
 * The light beam in this problem starts at the point (0.0,10.1) just outside the white cell, 
 * and the beam first impacts the mirror at (1.4,-9.6).
 * 
 * Each time the laser beam hits the surface of the ellipse, it follows the usual law of 
 * reflection "angle of incidence equals angle of reflection." That is, both the incident and 
 * reflected beams make the same angle with the normal line at the point of incidence.
 * 
 * In the figure on the left, the red line shows the first two points of contact between 
 * the laser beam and the wall of the white cell; the blue line shows the line tangent to 
 * the ellipse at the point of incidence of the first bounce.
 * 
 * The slope m of the tangent line at any point (x,y) of the given ellipse is: m = −4x/y
 * The normal line is perpendicular to this tangent line at the point of incidence.
 * The animation on the right shows the first 10 reflections of the beam.
 * How many times does the beam hit the internal surface of the white cell before exiting?
 */
public class Problem144 {

	static BigDecimal total = new BigDecimal("21");
	static int scale = 50;
	static int rounds = 15;
	static MathContext real = new MathContext(scale, RoundingMode.FLOOR);
	static MathContext itgr = new MathContext(0, RoundingMode.FLOOR);
	static BigDecimal mk = new BigDecimal(-4);
	static BigDecimal four = new BigDecimal(4);
	static BigDecimal two = new BigDecimal(2);
	static BigDecimal hdr = new BigDecimal(100);
	static BigDecimal leftBrd = new BigDecimal("-0.01");
	static BigDecimal rightBrd = new BigDecimal("0.01");
	static int[] ps = null;
	static int m = 10;
	static long pSum = 0;
		
	public static void main(String[] args) {
		System.out.println("Solve problem 144");
		
		long refl=0L;
		Point m0 = new Point("0", "10.1");
		Point m1 = new Point("1.4", "-9.6");
		Line l0 = new Line(m0, m1);
		System.out.println(l0);
		do {
			double tangentSlope = tangentSlope(m1);
//			System.out.println("tangentSlope = " + tangentSlope);
			double gamma = 180d - l0.slope() + 2 * tangentSlope;
//			System.out.println("gamma = " + gamma);
			Line l1 = new Line(gamma, m1);
//			System.out.println(l1);
			
			BigDecimal k1 = l1.getK();
			BigDecimal b1 = l1.getB();
			BigDecimal a = k1.multiply(k1, real).add(four, real);
			BigDecimal b = two.multiply(k1, real).multiply(b1, real);
			BigDecimal c = b1.multiply(b1, real).subtract(hdr, real);
//			System.out.println("a = " + a + " b = " + b + " c = " + c);
			BigDecimal[] roots = findRoots(a, b, c);
//			System.out.println(Arrays.toString(roots));
			BigDecimal x;
			BigDecimal y;
			if (!MathHelper.isEqual(roots[0], m1.getX(), scale-10)) {
				x = roots[0];
				y = l1.getValue(roots[0]);
			} else {
				x = roots[1];
				y = l1.getValue(roots[1]);
			}			
			m1 = new Point(x, y);
			l0 = l1;
			refl++;
			System.out.println("reflection point : " + m1 + " refl:" + refl);
		} while ((m1.getY().compareTo(BigDecimal.ZERO) < 0) || ((m1.getX().compareTo(leftBrd) < 0) || (m1.getX().compareTo(rightBrd) > 0)));
	}
	
	
	private static double tangentSlope(Point p) {
		double slope = Math.toDegrees(Math.atan(p.getX().multiply(mk, real).divide(p.getY(), real).doubleValue()));
//		if (slope < 0) {
//			slope = slope + 180d;
//		}
		return slope;		
	}
	
	/**
	 * Find roots of square equation.
	 */
	private static BigDecimal[] findRoots(BigDecimal a, BigDecimal b, BigDecimal c) {
		BigDecimal[] retval = new BigDecimal[2];
		BigSquareRoot bsr = new BigSquareRoot();
		bsr.setScale(scale);
		BigDecimal D = b.multiply(b, real).add(mk.multiply(a, real).multiply(c, real));
		BigDecimal sqrtD = bsr.get(D);
		BigDecimal root1 = b.negate().add(sqrtD).divide(a, real).divide(two, real);
		BigDecimal root2 = b.negate().subtract(sqrtD).divide(a, real).divide(two, real);
		retval[0] = root1;
		retval[1] = root2;
		return retval;
	}
	
}