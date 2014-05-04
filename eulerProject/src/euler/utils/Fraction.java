package euler.utils;

import java.math.BigInteger;

public class Fraction {

	//private long numerator = 1;
	private BigInteger numerator = BigInteger.ONE;

	private BigInteger denominator = BigInteger.ONE;
	
	public Fraction(long numerator, long denominator) {
		super();
		this.numerator = BigInteger.valueOf(numerator);
		this.denominator = BigInteger.valueOf(denominator);
	}

	public Fraction(BigInteger numerator, BigInteger denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public BigInteger getNumerator() {
		return numerator;
	}

	public BigInteger getDenominator() {
		return denominator;
	}

	public Fraction add(Fraction f) {
		Fraction retval = null;
		if (f.denominator.equals(this.denominator)) {
			retval = new Fraction(f.numerator.add(this.numerator), this.denominator);
		} else if (f.denominator.equals(BigInteger.ZERO)) {
			retval = new Fraction(this.numerator, this.denominator);
		} else if (this.denominator.equals(BigInteger.ZERO)) {
			retval = new Fraction(f.numerator, f.denominator);
		} else {
			BigInteger denom = f.denominator.multiply(this.denominator);
//			long denom = f.denominator * this.denominator;

			BigInteger nom = f.numerator.multiply(this.denominator).add(this.numerator.multiply(f.denominator));
//			long nom = f.numerator * this.denominator + this.numerator * f.denominator;
			retval = new Fraction(nom, denom);
		}
		return retval;
	}

	@Override
	public String toString() {
		return numerator + " / " + denominator;
	}
	
	
	
}
