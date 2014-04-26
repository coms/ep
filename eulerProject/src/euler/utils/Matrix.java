package euler.utils;

public class Matrix {
	
	private Long[][] matrix = null;
	
	public void spiralFill() {
		int m = matrix.length;
		int n = matrix[0].length;
		int i = (int) Math.floor(m / 2);
		int j = (int) Math.floor(n / 2);
		Long a = 1L;
		this.matrix [i][j] = a++;
		do {
			do {
				this.matrix [i][++j] = a++;
			} while (a < m * n && this.matrix[i+1][j] != null);
			if (a == m * n) { // exit condition
				this.matrix[0][n -1] = a; 
				break;
			}
			do {
				this.matrix [++i][j] = a++;
			} while (this.matrix[i][j-1] != null);
			do {
				this.matrix [i][--j] = a++;
			} while (this.matrix[i-1][j] != null);
			do {
				this.matrix [--i][j] = a++;
			} while (this.matrix[i][j+1] != null);
		} while (a < (m * n));
	}
	
	public Matrix(int m, int n) {
		this.matrix = new Long[m][n];
	}
	

	public Long centralElement() {
		int i = (int) Math.floor(matrix.length / 2);
		return matrix[i][i];
		
	}
	
	public Long majorDiagonalSum() {
		Long sum = 0L;
		for (int i = 0; i < this.matrix.length; i++) {
			sum += this.matrix[i][i];
		}
		return sum;
	}

	public Long minorDiagonalSum() {
		Long sum = 0L;
		int size = this.matrix.length - 1;
		for (int i = size; i >= 0; i--) {
			sum += this.matrix[i][size - i];
		}
		return sum;
	}
	

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				sb.append(matrix[i][j]).append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
