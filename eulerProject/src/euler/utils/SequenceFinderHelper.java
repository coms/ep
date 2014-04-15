package euler.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SequenceFinderHelper {

	/**
	 * Search for sequences in defined string.
	 * Non greedy algorithm, 
	 * @param str
	 * @return
	 */
	public static List<Sequence> findSequences(String str) {
		
		List<Sequence> retval = new ArrayList<Sequence>();
		Map<String, Sequence> seqns = new HashMap<String, Sequence>(); 
		
		for (int size = 1; size <= str.length(); size ++) {
			for (int i = 0; i < str.length() - size * 2; i++) {
				String pattern = str.substring(i, i + size);
				String testPattern = str.substring(i + size, i + size * 2);
				if (pattern.equals(testPattern)) {
					// check if pattern already founded in subpatterns
					if (!isSuperString(seqns, pattern)) {
						if (seqns.containsKey(pattern)) {
							Sequence sq = seqns.get(pattern);
							sq.addPosition(i);
							sq.addPosition(i + size);
//							System.out.println(sq);
						} else {
							Sequence sq = new Sequence(i, size, pattern);
							sq.addPosition(i + size);
							seqns.put(pattern, sq);
//							System.out.println(sq);
						}
					}
				}
			}
		}
		for(Sequence sq : seqns.values()) {
			retval.add(sq);
		}
		return retval;
		
	}

	private static boolean isSuperString(Map<String, Sequence> seqns, String pattern) {
		for (String key : seqns.keySet()) {
			if (pattern.startsWith(key)) {
				return true;
			}
		}
		return false;
	}
	
}
