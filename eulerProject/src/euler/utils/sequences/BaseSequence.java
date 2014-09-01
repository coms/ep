package euler.utils.sequences;

import java.math.BigInteger;

public abstract class BaseSequence {

	int currentIndex = 0;
	
	public abstract BigInteger next();
	
	public void reset() {
		this.currentIndex = 0;
	}
	
}
