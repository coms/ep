import java.util.Scanner;
import java.util.Stack;

public class RPN {
	
	
	
	public static void main(String[] args) {
		String sCases;
		Stack vars = new Stack();
		Stack ops = new Stack();
	    Scanner in = new Scanner(System.in);
	    sCases = in.nextLine();
	    int cases = Integer.valueOf(sCases);
	    for (int j = 0; j < cases; j++) {
	    	String sExp = in.nextLine();
	    	StringBuilder sb = new StringBuilder();
	    	char[] exp = sExp.toCharArray();
	    	for (int i = 0; i < exp.length; i++) {
	    		char t = exp[i]; 
	    		if (t >= 'a' && t <= 'z') {
	    			vars.push(t);
	    		} else if (t == '*' || t == '+' || t == '-' || t == '/' || t == '^') {
	    			ops.push(t);
	    		} else if (t == ')') {
	    			if (sb.length() == 0) {
	    				sb.append(vars.pop());
	    			}
	    			sb.append(vars.pop());
	    			sb.append(ops.pop());
	    		}
	    		
	    	}
	    	System.out.println(sb.toString());
	    	
	    }
	    in.close();            
	}
	
}
