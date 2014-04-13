package euler;

import euler.utils.Permutation;

public class Problem24 {
	
	/*
	 * test sequence for lexicographical order 0,1,2
	 * 
	 * 012
	 * 021
	 * 102
	 * 120
	 * 201
	 * 210
	 */

	public static void main(String[] args) {
		
		// create test permutation array
		Permutation perm = new Permutation();
		char[] array = {'0','1','2'};
		perm.createArray(array);
		System.out.println(array);
		perm.nextPermutation();
		System.out.println(array);
		perm.nextPermutation();
		System.out.println(array);
		
	}

}
