package euler.utils.sequences;

import java.math.BigInteger;

public class PentagonalSequence extends BaseSequence {

	@Override
	public BigInteger next() {
		super.currentIndex++;
		BigInteger n = BigInteger.valueOf(super.currentIndex);
		BigInteger retval = n.multiply(BigInteger.valueOf(3).multiply(n).subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2)); 
		return retval;
	}

}
