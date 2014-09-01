package euler.utils.sequences;

import java.math.BigInteger;

public class TriangleSequence extends BaseSequence {

	@Override
	public BigInteger next() {
		super.currentIndex++;
		BigInteger n = BigInteger.valueOf(super.currentIndex);
		BigInteger retval = n.multiply(n.add(BigInteger.ONE)).divide(BigInteger.valueOf(2)); 
		return retval;
	}

}
