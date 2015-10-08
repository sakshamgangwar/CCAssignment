/**
 * This class contains method to insert specified bits of one number into
 * another.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {

	public static void main(String[] args) {
		System.out.println(Integer.toBinaryString(1024));
		System.out.println(Integer.toBinaryString(10));
		int result = insertBits(1024, 10, 2, 6);
		System.out.println(Integer.toBinaryString(result));
	}

	/**
	 * This method inserts num2 bits in num1 starting from bit j and ending at
	 * bit i.
	 * 
	 * @param num1
	 * @param num2
	 * @param i
	 * @param j
	 * @return
	 */
	static int insertBits(int num1, int num2, int i, int j) {
		/**
		 * Creating a mask to preserve bits in num1 which won't be altered.
		 */
		int mask = ~0 << (j + 1) | ((1 << i) - 1);
		/**
		 * Applying mask on num1 and shifting num2 to correct position and doing
		 * Or with the masked num1.
		 */
		return (num1 & mask) | (num2 << i);
	}
}
