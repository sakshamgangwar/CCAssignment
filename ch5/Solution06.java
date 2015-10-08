/**
 * This class contains method to return how many bits need to be flipped to
 * convert n1 to n2. Using XOR Approach.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {

	public static void main(String[] args) {
		System.out.println(numberOfBitsSwap(45, 8));
	}

	/**
	 * Method to return number of bits to be flipped to get n1 converted to n2.
	 * Using XOR Approach.
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static int numberOfBitsSwap(int n1, int n2) {
		/**
		 * Counter for measuring flip count.
		 */
		int flipCount = 0;
		/**
		 * Counting number of bits in n1 XOR n2 that are one, this will tell us
		 * how many bits to be flipped.
		 */
		for (int i = n1 ^ n2; i != 0; i = i >> 1)
			flipCount += i & 1;

		return flipCount;
	}

}
