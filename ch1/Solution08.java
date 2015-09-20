/**
 * This class contains a method which sets entire row and column to zero if any
 * one element in that row or column is zero.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 0, 3, 4 },
				{ 5, 6, 7, 0 } };
		System.out.println("Before Setting Zeros: ");
		printMatrix(matrix);
		System.out.println("\nAfter Setting Zeros: ");
		printMatrix(setZeroMatrix(matrix));

	}

	/**
	 * Method to print the matrix on console.
	 * 
	 * @param matrix
	 * @param size
	 */
	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Method to set rows and columns to zero if any one element in those rows
	 * or columns are zero.
	 * 
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 * 
	 * @param matrix
	 * @return int[][]
	 */
	private static int[][] setZeroMatrix(int[][] matrix) {

		/**
		 * First we need to make sure whether the first row and the first column
		 * are containing zeros or not. It is required so that we don't get
		 * confused with the other placed zeros in the proceeding part of the
		 * algorithm in first row and column.
		 */
		boolean firstRowHasZero = false;
		boolean firstColumnHasZero = false;

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowHasZero = true;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumnHasZero = true;
			}
		}

		/**
		 * Looping over all the items in the matrix, setting the first column
		 * and row of the matrix as zero if there is any zero in any column or
		 * row respectively.
		 */
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		/**
		 * Once we get zeros in the first column which represent that the
		 * respective row is having a zero and the complete row should be set to
		 * zero.
		 */
		for (int i = 1; i < matrix.length; i++) {
			/**
			 * if the element is zero, setting complete row as zero.
			 */
			if (matrix[i][0] == 0) {
				setRowZero(matrix, i);
			}
		}
		/**
		 * Once we get zeros in the first row which represent that the
		 * respective column is having a zero and the complete column should be
		 * set to zero.
		 */
		for (int i = 1; i < matrix[0].length; i++) {
			/**
			 * if the element is zero, setting complete column as zero.
			 */
			if (matrix[0][i] == 0) {
				setColumnZero(matrix, i);
			}
		}

		/**
		 * If the first column had zero then setting complete column as zero.
		 */
		if (firstColumnHasZero) {
			setColumnZero(matrix, 0);
		}

		/**
		 * If the first row had zero then setting complete row as zero.
		 */
		if (firstRowHasZero) {
			setRowZero(matrix, 0);
		}

		return matrix;
	}

	/**
	 * Method to set complete column as zero.
	 * 
	 * @param matrix
	 * @param columnNumber
	 */
	private static void setColumnZero(int[][] matrix, int columnNumber) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][columnNumber] = 0;
		}
	}

	/**
	 * Method to set complete row as zero.
	 * 
	 * @param matrix
	 * @param rowNumber
	 */
	private static void setRowZero(int[][] matrix, int rowNumber) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[rowNumber][i] = 0;
		}
	}

}
