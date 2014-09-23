package euler.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class Graph {

	private List<Node> nodes;
	
	public Graph(String filename) {
		Node startNode = new Node(1);
		long[][] a = loadFileIntoArray(filename);
		System.out.println(Arrays.toString(a));
	}
	
	private long[][] loadFileIntoArray(String filename) {
		int width = getWidth(filename);
		int height = getHeight(filename);
		long[][] retval = new long[width][height];
		BufferedReader reader = null;
		try {
		  reader = new BufferedReader(new FileReader(new File(filename)));
		  String str = null;
		  int j = 0;
		  while((str = reader.readLine()) != null) {
			  String[] strNums = str.split(",");
			  for (int i = 0; i < width; i++) {
				  retval[j][i] = Integer.valueOf(strNums[i]);
			  }
			  j++;
		  }
		} catch (FileNotFoundException e) {
		  e.printStackTrace();
		} catch (IOException e) {
  		  e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return retval;
	}

	public static int getHeight(String filename) {
	    InputStream is = null;
	    try {
	    	is = new BufferedInputStream(new FileInputStream(filename));
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
	    } finally {
	        try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    return 0;
	}

	private int getWidth(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
			String str = reader.readLine();
			String[] strNums = str.split(",");
			return strNums.length;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
