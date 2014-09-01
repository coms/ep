package euler.utils.sequences;

import java.math.BigInteger;

public class SquareSequence extends BaseSequence {

	@Override
	public BigInteger next() {
		super.currentIndex++;
		BigInteger n = BigInteger.valueOf(super.currentIndex);
		BigInteger retval = n.multiply(n);
		return retval;
	}

}
