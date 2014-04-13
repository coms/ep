package euler.utils;

public class Permutation {

	private char[] array;
	private int n;
	
	/**
	 * create permutation array
	 * 
	 * @param array
	 */
	public void createArray(char[] array) {
		this.array = array;
		this.n = array.length;
	}
	
	public String getArray() {
		return array.toString();
	}
	
	public void nextPermutation() {
		int l = n - 1;
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
	
	public char[] narayanaNextPerm () {
	    int i, k, t;
	    char tmp;
	 
	    //иру 1
	    for (k = n - 2; (k >= 0) && (array[k] >= array[k + 1]); k--);
	 
	    //иру 2
	    if (k == -1)
	        return null;
	 
	    for (t = n - 1; (array[k] >= array[t]) && (t >= k + 1); t--);
	 
	    tmp = array[k];
	    array[k] = array[t];
	    array[t] = tmp;
	 
	    //иру 3
	    for (i = k + 1; i <= (n + k)/2; i++)
	    {
	        t = n + k - i;
	        tmp = array[i];
	        array[i] = array[t];
	        array[t] = tmp;
	    }
	    return array;
	}
	
}
