/**
 * This class contains method to return which bit to be flipped so that we can
 * get max sequence of ones.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		System.out.println(flipBitToWin(new int[] { 1, 1, 1, 0, 1, 0, 0, 1, 1, 1 }));
	}

	/**
	 * Method to return index of bit to be flipped so as to get max sequence of
	 * ones.
	 * 
	 * @param input
	 * @return
	 */
	private static int flipBitToWin(int[] input) {

		/**
		 * Used to store max length of ones formed.
		 */
		int maxLength = 0;
		/**
		 * Index of bit to be flipped.
		 */
		int bitToBeFlipped = -1;
		/**
		 * Index of previous zero bit flipped.
		 */
		int previousZeroLoc = -1;
		/**
		 * Index of bit previous to previous bit flipped.
		 */
		int beforePreviousZeroLoc = -1;

		/**
		 * Moving over the complete input bit by bit.
		 */
		for (int i = 0; i < input.length; ++i) {
			/**
			 * If we encounter zero, we need to check including the mid zero
			 * location (previous zero location) is this new length of ones
			 * sequence is better than the previous max result.
			 */
			if (input[i] == 0) {
				if (i - beforePreviousZeroLoc > maxLength) {
					/**
					 * If this new result is better, then we need to set bit to
					 * be flipped as previous zero location and set the new max
					 * length.
					 */
					maxLength = i - beforePreviousZeroLoc;
					bitToBeFlipped = previousZeroLoc;
				}

				/**
				 * Now our previous to previous zero location pointer will move
				 * to previous zero location and current zero location will be
				 * the previous zero location.
				 */
				beforePreviousZeroLoc = previousZeroLoc;
				previousZeroLoc = i;
			}
		}

		/**
		 * Checking for the last zero.
		 */
		if (input.length - beforePreviousZeroLoc > maxLength)
			bitToBeFlipped = previousZeroLoc;

		return bitToBeFlipped;
	}
}
