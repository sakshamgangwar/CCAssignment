/**
 * Class containing method to perform sparse search where we are provided with
 * an sorted array of strings which has been interspersed with empty strings.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution05 {

	public static void main(String[] args) {

		String[] input = new String[] { "", "abs", "", "", "ball", "", "", "", "cat", "", "", "lat" };

		System.out.println(sparseSearch(input, "ball", 0, input.length - 1));

	}

	/**
	 * In order to perform this search we make use of binary search algorithm
	 * with a change that whenever we encounter any space we try to move our
	 * pointers to the next available non-empty string.
	 * 
	 * @param input
	 * @param search
	 * @param low
	 * @param high
	 * @return Integer
	 */
	public static Integer sparseSearch(String[] input, String search, int low, int high) {
		/**
		 * boundary case.
		 */
		if (low > high)
			return null;

		/**
		 * getting the mid index.
		 */
		int mid = (low + high) / 2;

		/**
		 * If we figure out that the value at mid index is empty string then we
		 * need to move left and right pointers in their respective directions
		 * till they encounter non-empty string.
		 */
		if (input[mid].equals("")) {
			while (true) {

				int left = mid - 1;
				int right = mid + 1;

				if (left < low && right > high)
					return null;
				else if (right <= high && !input[right].equals("")) {
					mid = right;
					break;
				} else if (left >= low && !input[left].equals("")) {
					mid = left;
					break;
				}
				left--;
				right++;

			}
		}

		/**
		 * If success we can return the result directly otherwise we need to
		 * traverse on the either side based on value.
		 */
		if (input[mid].equals(search))
			return mid;
		else if (input[mid].compareTo(search) < 0)
			return sparseSearch(input, search, mid + 1, high);
		else
			return sparseSearch(input, search, low, mid - 1);

	}
}
