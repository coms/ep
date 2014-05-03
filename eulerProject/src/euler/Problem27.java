package euler;

import euler.utils.Matrix;

public class Problem27 {

	public static void main(String[] args) {
		Matrix m = new Matrix(1001, 1001);
		m.spiralFill();
//		System.out.println("matrix : \n" + m);
		System.out.println("major d.sum = " + m.majorDiagonalSum());
		System.out.println("minor d.sum = " + m.minorDiagonalSum());
		System.out.println(m.majorDiagonalSum() + m.minorDiagonalSum() - m.centralElement());
	}

}
