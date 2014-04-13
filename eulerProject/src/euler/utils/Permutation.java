package euler.utils;

public class Permutation {

	private char[] array;
	
	/**
	 * create permutation array
	 * 
	 * @param array
	 */
	public void createArray(char[] array) {
		this.array = array;
	}
	
	public String getArray() {
		return array.toString();
	}
	
	public void nextPermutation() {
		int l = array.length - 1;
		boolean permutated = false;
		
		while(!permutated) {
			if (array[l - 1] < array[l]) {
				// swap l with l-1
				char a = array[l];
				array[l] = array[l-1];
				array[l-1] = a;
				permutated = true;
			}
			l--;
		}
		
	}
	
}
