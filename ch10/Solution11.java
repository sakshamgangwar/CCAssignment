/**
 * Class containing method to to form alternating sequence of peaks and valleys
 * in a provided input array of numbers.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution11 {

	public static void main(String[] args) {

		int[] input = new int[] { 5, 3, 1, 2, 3 };

		createPeaksAndValleys(input);

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}

	}

	/**
	 * In order to form a alternating sequence of peaks and valleys we can
	 * iterate over the the array by making sure that say all odd places to be
	 * the site of peaks and rest valleys. So we move pointer to odd positions
	 * (say i) and compare it with i-1 and i+1 in order to get the largest among
	 * all three and place it at i position.
	 * 
	 * @param input
	 */
	public static void createPeaksAndValleys(int[] input) {
		for (int i = 1; i < input.length; i = i + 2) {
			/**
			 * boundary condition for i
			 */
			if (i + 1 < input.length) {
				/**
				 * Getting the index of max value among i , i-1 and i+1 values.
				 */
				int maxIndex = ((input[i - 1] > input[i]) && (input[i - 1] > input[i + 1])) ? i - 1
						: ((input[i + 1] > input[i]) ? i + 1 : i);
				/**
				 * If max index is other than i itself when we need to swap it
				 * with i index to keep peak in between.
				 */
				if (maxIndex != i) {
					int temp = input[i];
					input[i] = input[maxIndex];
					input[maxIndex] = temp;
				}
			}
		}
	}

}
