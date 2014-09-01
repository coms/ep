package euler.utils.sequences;

import java.math.BigInteger;

public class HexagonalSequence extends BaseSequence {

	@Override
	public BigInteger next() {
		super.currentIndex++;
		BigInteger n = BigInteger.valueOf(super.currentIndex);
		BigInteger retval = n.multiply(BigInteger.valueOf(2).multiply(n).subtract(BigInteger.ONE)); 
		return retval;
	}

}
