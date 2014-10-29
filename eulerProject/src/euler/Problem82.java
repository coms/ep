package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import euler.graph.Graph;
import euler.utils.ArraysHelper;


/**
* Path sum: three ways
* Problem 82
* NOTE: This problem is a more challenging version of Problem 81.
* The minimal path sum in the 5 by 5 matrix below, by starting in any cell in the left 
* column and finishing in any cell 
* in the right column, and only moving up, down, and right, is indicated in red and bold; 
* the sum is equal to 994.
* 
* 131 673 234 103 18
* 201 96  342 965 150
* 630 803 746 422 111
* 537 699 497 121 956
* 805 732 524  37 331
* 
* Find the minimal path sum, in matrix.txt (right click and "Save Link/Target As..."), a 
* 31K text file containing a 80 by 80 matrix, from the left column to the right column.
*/
public class Problem82 {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	
	public static void main(String[] args) {
		Graph g = new Graph("./data/p082_matrix_small.txt");
	}
	
}
