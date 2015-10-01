/**
 * This class contains method to print all the duplicate elements in the input
 * array, where array can have numbers 1 to N where N is at most 32,000. We have
 * only 4kb memory restriction to use.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 3, 2 };
		getDuplicates(input);
	}

	/**
	 * Mehtod to print duplicates.
	 * 
	 * @param input
	 */
	public static void getDuplicates(int[] input) {
		int noOfBits = 32000;
		/**
		 * Using integer array to store occurrences of 32000 numbers in order of
		 * bit positions in those integers.
		 */
		int[] occurance = new int[noOfBits / (8 * 32)];

		/**
		 * Looping over the complete input array.
		 */
		for (int i = 0; i < input.length; i++) {
			int n = input[i] - 1;
			/**
			 * If the number already exist then and result with a number with 1
			 * at bit position signifying that number in the occurrences value
			 * would not be zero.
			 */
			if ((occurance[n / 32] & (1 << (n % 32))) != 0) {
				System.out.println(n + 1);
			} else {
				/**
				 * When occurring for the first time.
				 */
				occurance[n / 32] = occurance[n / 32] | (1 << (n % 32));
			}
		}
	}

}
