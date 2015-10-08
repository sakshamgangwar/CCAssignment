/**
 * This class contains method to swap odd and even bits in an integer with as
 * few instructions as possible.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution07 {

	public static void main(String[] args) {
		printBinary(10);

		int result = pairwiseSwap(10);

		printBinary(result);
	}

	/**
	 * Method to perform pairwise swap. This will work only for 32 bits
	 * integers.
	 * 
	 * @param num
	 * @return
	 */
	public static int pairwiseSwap(int num) {
		return (((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1));
	}

	public static void printBinary(int num) {
		System.out.println("Number: " + num + " in binary format: " + Integer.toBinaryString(num));
	}

}
