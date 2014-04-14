package euler.utils;

public class SequenceFinderHelper {

	/**
	 * Search for sequences in defined string.
	 * @param str
	 * @return
	 */
	public static Sequence[] findSequence(String str) {
		System.out.println("....");
		String[] retval = str.split("(\\.)+");
		for (String r : retval) {
			System.out.println(r);	
		}
		return null;
		
	}
	
}
