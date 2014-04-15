package euler.utils;

import java.util.List;

public class SequenceFinderHelper {

	/**
	 * Search for sequences in defined string.
	 * @param str
	 * @return
	 */
	public static List<Sequence> findSequences(String str) {
		
		for (int size = 1; size <= str.length(); size ++) {
			for (int i = 0; i < str.length() - size; i++) {
				String pattern = str.substring(i, i + size);
				for (int j = i + size; j < str.length() - size; j++) {
					String testPattern = str.substring(j, j + size);
					if (pattern.equals(testPattern)) {
						System.out.println("We found seq : " + pattern + ", i = " + i + ", j = " + j);
					}
				}							
			}			
		}
		
//		System.out.println("....");
//		String[] retval = str.split("(\\.)+");
//		for (String r : retval) {
//			System.out.println(r);	
//		}
		return null;
		
	}
	
}
