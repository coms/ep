package euler.graph;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

	private List<Node> nodes = new ArrayList<Node>();
	
	public Graph(String filename) {
		Node startNode = new Node(0);
		long[][] a = loadFileIntoArray(filename);
		System.out.println(Arrays.deepToString(a));
		
		nodes.add(startNode);
		for (int i = 1; i <= ((a.length) * (a[0].length)); i++) {
			nodes.add(new Node(i));
		}
		Node endNode = new Node(999999); 
		nodes.add(endNode);
		
		int mi = a.length;
		int mj = a[0].length;
		
		for (int i = 0; i < mi; i++) {
			for (int j = 0; j < mj; j++) {
				// create right link
				int srcNodeIndex = j == 0? 0 : i*mi + j;
				int dstNodeIndex = j == 0? i*mi + 1 : i*mi + j + 1;
				Node srcNode = nodes.get(srcNodeIndex);
				Node dstNode = nodes.get(dstNodeIndex);
				Link l = new Link(a[i][j], srcNode, dstNode);
				srcNode.addLink(l); 
				// create down link
				if ((i < mi-1) && (srcNodeIndex > 0)) {
					dstNodeIndex = j == 0? i*mi + 1 : (i+1)*mi + j;
					dstNode = nodes.get(dstNodeIndex);
					l = new Link(a[i+1][j-1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create up link
				if ((i > 0) && (srcNodeIndex > 0)) {
					dstNodeIndex = j == 0? i*mi + 1 : (i-1)*mi + j;
					dstNode = nodes.get(dstNodeIndex);
					l = new Link(a[i-1][j-1], srcNode, dstNode);
					srcNode.addLink(l);
				}
				// create finish links
				if (j == mj) {
					dstNode = nodes.get(nodes.size() - 1);
					l = new Link(0, srcNode, dstNode);
					srcNode.addLink(l);
				}
			}
		}
		System.out.println("Generating ending.");
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
