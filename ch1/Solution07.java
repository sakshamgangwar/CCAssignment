/**
 * Given a NxN matrix, this class contains method to rotate it by 90 degrees.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution07 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		System.out.println("Before Rotation: ");
		printMatrix(matrix, 4);
		System.out.println("\nAfter Rotation: ");
		printMatrix(doMatrixRotation(matrix, 4), 4);

	}

	/**
	 * Method to print the matrix on console.
	 * 
	 * @param matrix
	 * @param size
	 */
	private static void printMatrix(int[][] matrix, int size) {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Method to rotate a NxN matrix by 90 degrees. It is attained by four side
	 * swap using temp variable for each layer of the matrix.
	 * 
	 * Time Complexity: O(n^2)
	 * 
	 * @param matrix
	 * @param size
	 *            (defines N)
	 * @return
	 */
	private static int[][] doMatrixRotation(int[][] matrix, int size) {

		/**
		 * Looping over each layer.
		 */
		for (int i = 0; i < size / 2; ++i) {
			/**
			 * In each layer considering swapping each element by 90 degree
			 * using a temp variable.
			 */
			for (int j = i; j < size - 1 - i; ++j) {

				int temp = matrix[i][j];

				/**
				 * top row getting data from left column.
				 */
				matrix[i][j] = matrix[size - 1 - j][i];

				/**
				 * left column getting data from down row.
				 */
				matrix[size - 1 - j][i] = matrix[size - 1 - i][size - 1 - j];

				/**
				 * down row getting data from right column
				 */
				matrix[size - 1 - i][size - 1 - j] = matrix[j][size - 1 - i];

				/**
				 * right column getting data from top row which we stored in
				 * temp.
				 */
				matrix[j][size - 1 - i] = temp;
			}
		}

		return matrix;
	}
}
