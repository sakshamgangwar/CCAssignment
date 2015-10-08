/**
 * Given a positive integer, this class contains method to print the next
 * smallest and next largest number that have same number of 1 bits in their
 * binary representation.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		getNextNumbers(13948);
	}

	/**
	 * Method to print next smallest and next largest number which are having
	 * same number of bits as binary representation of the passed number.
	 * 
	 * @param num
	 */
	public static void getNextNumbers(int num) {
		printBinary(num);
		/**
		 * Variables to keep a track of all trailing zeros and ones.
		 */
		int rightTrailingZeroCount = 0;
		int rightTrailingOneCount = 0;
		int input = num;
		/**
		 * Counting trailing zeros.
		 */
		while (((input & 1) == 0) && (input != 0)) {
			rightTrailingZeroCount++;
			input = input >> 1;
		}

		/**
		 * Counting trailing ones.
		 */
		while ((input & 1) == 1) {
			rightTrailingOneCount++;
			input = input >> 1;
		}

		/**
		 * Getting next smaller. And making sure number of ones remains the
		 * same.
		 */
		int nextSmaller = num - (1 << rightTrailingOneCount) - (1 << (rightTrailingZeroCount - 1)) + 1;

		System.out.println("Next Smaller Number with same number of bits: ");
		printBinary(nextSmaller);

		/**
		 * Getting next larger. And making sure number of ones remains the same.
		 */
		int nextBigger = num + (1 << rightTrailingZeroCount) + (1 << (rightTrailingOneCount - 1)) - 1;
		System.out.println("Next Bigger Number with same number of bits: ");
		printBinary(nextBigger);
	}

	/**
	 * Method to print binary representation.
	 * 
	 * @param num
	 */
	public static void printBinary(int num) {
		System.out.println("Number: " + num + " in binary format: " + Integer.toBinaryString(num));
	}

}
