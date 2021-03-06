package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.javatuples.Pair;
import org.javatuples.Triplet;

import com.sun.xml.internal.fastinfoset.algorithm.HexadecimalEncodingAlgorithm;

import euler.utils.DivisorsHelper;
import euler.utils.MathHelper;
import euler.utils.Prime;
import euler.utils.sequences.BaseSequence;
import euler.utils.sequences.HeptagonalSequence;
import euler.utils.sequences.HexagonalSequence;
import euler.utils.sequences.OctagonalSequence;
import euler.utils.sequences.PentagonalSequence;
import euler.utils.sequences.SquareSequence;
import euler.utils.sequences.TriangleSequence;

/**
Problem 61
Triangle, square, pentagonal, hexagonal, heptagonal, and octagonal numbers are 
all figurate (polygonal) numbers and are generated by the following formulae:

Triangle	 	P3,n=n(n+1)/2	 	1, 3, 6, 10, 15, ...
Square	 		P4,n=n2	 			1, 4, 9, 16, 25, ...
Pentagonal	 	P5,n=n(3n−1)/2	 	1, 5, 12, 22, 35, ...
Hexagonal	 	P6,n=n(2n−1)	 	1, 6, 15, 28, 45, ...
Heptagonal	 	P7,n=n(5n−3)/2	 	1, 7, 18, 34, 55, ...
Octagonal	 	P8,n=n(3n−2)	 	1, 8, 21, 40, 65, ...
The ordered set of three 4-digit numbers: 8128, 2882, 8281, has three interesting properties.

The set is cyclic, in that the last two digits of each number is the first two digits of 
the next number (including the last number with the first).
Each polygonal type: triangle (P3,127=8128), square (P4,91=8281), and 
pentagonal (P5,44=2882), is represented by a different number in the set.
This is the only set of 4-digit numbers with this property.
Find the sum of the only ordered set of six cyclic 4-digit numbers for which each 
polygonal type: triangle, square, pentagonal, hexagonal, heptagonal, and octagonal, 
is represented by a different number in the set.
 */
public class Problem61 {
		
	public static void main(String[] args) {
		System.out.println("Solve problem 61");
		
		List<Triplet<Integer, Integer, Integer>> l3 = prepareList(new TriangleSequence(), 3);
		List<Triplet<Integer, Integer, Integer>> l4 = prepareList(new SquareSequence(), 4);
		List<Triplet<Integer, Integer, Integer>> l5 = prepareList(new PentagonalSequence(), 5);
		List<Triplet<Integer, Integer, Integer>> l6 = prepareList(new HexagonalSequence(), 6);
		List<Triplet<Integer, Integer, Integer>> l7 = prepareList(new HeptagonalSequence(), 7);
		List<Triplet<Integer, Integer, Integer>> l8 = prepareList(new OctagonalSequence(), 8);

		List<Triplet<Integer, Integer, Integer>> l = new ArrayList<Triplet<Integer, Integer, Integer>>();
		l.addAll(l3);
		l.addAll(l4);
		l.addAll(l5);
		l.addAll(l6);
		l.addAll(l7);
		l.addAll(l8);
		
		int sum = 0;

//		for (Triplet<Integer, Integer, Integer> i0 : l) {
//			for (Triplet<Integer, Integer, Integer> i1 : l) {
//				if (last2digits((Integer) i0.getValue0()) == first2digits((Integer) i1.getValue0())) {
//					for (Triplet<Integer, Integer, Integer> i2 : l) {
//						if (last2digits((Integer) i1.getValue0()) == first2digits((Integer) i2.getValue0())
//							&& last2digits((Integer) i2.getValue0()) == first2digits((Integer) i0.getValue0())
//							&& checkBases(i0, i1, i2) && i0.getValue1() == 3) {
//								System.out.println("i0 = " + i0);
//								System.out.println("i1 = " + i1);
//								System.out.println("i2 = " + i2);
//													
//								sum += (i0.getValue0() + i1.getValue0() + i2.getValue0());
//								System.out.println("sum = " + sum);
//							}															
//						}
//					}								
//				}
//			}			
//		}

		
		for (Triplet<Integer, Integer, Integer> i0 : l) {
			for (Triplet<Integer, Integer, Integer> i1 : l) {
				if (last2digits((Integer) i0.getValue0()) == first2digits((Integer) i1.getValue0())) {
					for (Triplet<Integer, Integer, Integer> i2 : l) {
						if (last2digits((Integer) i1.getValue0()) == first2digits((Integer) i2.getValue0())) {
							for (Triplet<Integer, Integer, Integer> i3 : l) {
								if (last2digits((Integer) i2.getValue0()) == first2digits((Integer) i3.getValue0())) {
									for (Triplet<Integer, Integer, Integer> i4 : l) {
										if (last2digits((Integer) i3.getValue0()) == first2digits((Integer) i4.getValue0())) {
											for (Triplet<Integer, Integer, Integer> i5 : l) {
												if (last2digits((Integer) i4.getValue0()) == first2digits((Integer) i5.getValue0())
														&& last2digits((Integer) i5.getValue0()) == first2digits((Integer) i0.getValue0())
														//&& checkBases(i0, i1, i2, i3, i4, i5) && i0.getValue1() == 3) {
														&& checkBases(i0, i1, i2, i3, i4, i5)) {
													System.out.println("i0 = " + i0);
													System.out.println("i1 = " + i1);
													System.out.println("i2 = " + i2);
													System.out.println("i3 = " + i3);
													System.out.println("i4 = " + i4);
													System.out.println("i5 = " + i5);
													
													sum += (i0.getValue0() + i1.getValue0() + i2.getValue0() + i3.getValue0() + i4.getValue0() + i5.getValue0());
													System.out.println("sum = " + sum);
												}
											}															
										}
									}															
								}
							}															
						}
					}								
				}
			}			
		}
	}
	
	private static boolean checkBases(Triplet<Integer, Integer, Integer> i0, Triplet<Integer, Integer, Integer> i1, Triplet<Integer, Integer, Integer> i2) {
			return i0.getValue1() != i1.getValue1() && i0.getValue1() != i2.getValue1()
			&& i1.getValue1() != i2.getValue1();
	}
	
	private static boolean checkBases(Triplet<Integer, Integer, Integer> i0,
			Triplet<Integer, Integer, Integer> i1, Triplet<Integer, Integer, Integer> i2,
			Triplet<Integer, Integer, Integer> i3, Triplet<Integer, Integer, Integer> i4,
			Triplet<Integer, Integer, Integer> i5) {	
		return i0.getValue1() != i1.getValue1() && i0.getValue1() != i2.getValue1() && i0.getValue1() != i3.getValue1() && i0.getValue1() != i4.getValue1() && i0.getValue1() != i5.getValue1()
				&& i1.getValue1() != i2.getValue1() && i1.getValue1() != i3.getValue1() && i1.getValue1() != i4.getValue1() && i1.getValue1() != i5.getValue1()
				&& i2.getValue1() != i3.getValue1() && i2.getValue1() != i4.getValue1() && i2.getValue1() != i5.getValue1()
				&& i3.getValue1() != i4.getValue1() && i3.getValue1() != i5.getValue1()
				&& i4.getValue1() != i5.getValue1();
	}

	private static Integer last2digits(Integer n) {
		return Integer.valueOf(n.toString().substring(2));
	}

	private static Integer first2digits(Integer n) {
		return Integer.valueOf(n.toString().substring(0, 2));
	}

	private static List<Triplet<Integer, Integer, Integer>> prepareList(BaseSequence s, int base) {
		List<Triplet<Integer, Integer, Integer>> retval = new ArrayList<Triplet<Integer, Integer, Integer>>();
		int n = 0;
		BigInteger next = BigInteger.ZERO;
		while (next.compareTo(BigInteger.valueOf(1000L)) < 0) {
			n++;
			next = s.next();
		}
		Triplet<Integer, Integer, Integer> p = new Triplet<Integer, Integer, Integer>(next.intValue(), base, n);
		retval.add(p);
		int i = s.next().intValue();
		n++;
		do {
			p = new Triplet<Integer, Integer, Integer>(i, base, n);
			retval.add(p);
			i = s.next().intValue();
			n++;
		} while (i < 10000);
		return retval;
	}

}