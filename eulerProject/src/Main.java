import java.util.Scanner;

public class Main {
	
	
	
	public static void main(String[] args) {
		String sCases;
	    Scanner in = new Scanner(System.in);
	    sCases = in.nextLine();
	    int cases = Integer.valueOf(sCases);
	    for (int j = 0; j < cases; j++) {
	    	String limits = in.nextLine();
	    	
	    	String[] l = limits.split("\\s");
	    	long from = Long.valueOf(l[0]);
	    	long to = Long.valueOf(l[1]);
	    	for (long i = from; i <= to; i++) {
	    		if (isPrime(i)) {
	    			System.out.println(i);
	    		}
	    	}
	    	
	    }
	    in.close();            
	}
	
	public static boolean isPrime(Long n) {
		if (n == 1 || n % 2 == 0 || n % 3 == 0) {
			return false; // hardcode for "1,2,3";
		}
		long div = 5;
		long pairedDiv = n / div;
		while (div < pairedDiv) {
			if (n % div == 0  && n != div) {
				return false;
			}
			div++;
			pairedDiv = n / div;
		}
		return true;
	}
	
}
