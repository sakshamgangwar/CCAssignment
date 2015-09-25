public class Solution03 {

	public static void main(String[] args) {
		int[] input = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		
		System.out.println(searchInRotatedSortedArray(input, 10));
		
	}

	public static Integer searchInRotatedSortedArray(int[] input,
			int searchValue) {

		int left = 0;
		int right = input.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (input[mid] == searchValue)
				return mid;

			if (input[left] <= input[mid]) {

				if (searchValue >= input[left] && searchValue < input[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}

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
