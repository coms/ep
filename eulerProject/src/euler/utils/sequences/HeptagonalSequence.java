package euler.utils.sequences;

import java.math.BigInteger;

public class HeptagonalSequence extends BaseSequence {

	@Override
	public BigInteger next() {
		super.currentIndex++;
		BigInteger n = BigInteger.valueOf(super.currentIndex);
		BigInteger retval = n.multiply(BigInteger.valueOf(5).multiply(n).subtract(BigInteger.valueOf(3))).divide(BigInteger.valueOf(2)); 
		return retval;
	}

}
