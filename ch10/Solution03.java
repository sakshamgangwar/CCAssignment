/**
 * Class contains method to search in rotated sorted array.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		int[] input = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };

		System.out.println(searchInRotatedSortedArray(input, 10));

	}

	/**
	 * In order to perform this search we follow similar approach like binary
	 * search with some extra conditions.
	 * 
	 * @param input
	 * @param searchValue
	 * @return - Integer
	 */
	public static Integer searchInRotatedSortedArray(int[] input, int searchValue) {

		/**
		 * getting pointers for the extreme ends.
		 */
		int left = 0;

		int right = input.length - 1;

		while (left <= right) {
			/**
			 * calculating mid.
			 */
			int mid = (left + right) / 2;

			/**
			 * If success at mid we can return mid.
			 */
			if (input[mid] == searchValue)
				return mid;

			/**
			 * If we find value at left extreme is less than value at mid then
			 * if searched value also lies between that we can shift right
			 * pointer to this range other wise left pointer will move towards
			 * other half.
			 */
			if (input[left] <= input[mid]) {

				if (searchValue >= input[left] && searchValue < input[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

			/**
			 * If we find that value at mid is less than value at right, then we
			 * need to check id searched value is in this range then we need to
			 * shift left pointer to this range otherwise right pointer to the
			 * previous range.
			 */
			if (input[mid] <= input[right]) {

				if (searchValue >= input[mid] && searchValue < input[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return null;
	}

}
