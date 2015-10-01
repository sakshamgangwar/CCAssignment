/**
 * Class contains method to search in a sorted matrix where elements are sorted
 * in ascending order in each row and column.
 * 
 * In order to find any element in this matrix we can make use of two pointers
 * till they reach boundary. One of the pointer points to row and the other for
 * column. We start from checking the last element of the row and if we find
 * that the element is less than that then we decrement the column index and row
 * remains the same but if its bigger then we need to increment row index.
 * 
 * This process continues till we get the number of we reach boundary.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution09 {

	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 13 }, { 14, 16, 17, 23 } };
		System.out.println(sortedMatrixSearch(input, 10));
	}

	public static boolean sortedMatrixSearch(int[][] input, int search) {

		/**
		 * Last index for column.
		 */
		int j = input[0].length - 1;
		/**
		 * Starting row index.
		 */
		int i = 0;

		/**
		 * While we don't reach respective boundaries which means number we are
		 * searching is not present.
		 */
		while (i < input.length && j >= 0) {
			if (input[i][j] == search)
				return true;
			else if (search < input[i][j])
				j--; // It means number is that row only so decrementing column
						// index.
			else
				i++;
		}

		return false;
	}

}
