/**
 * Given a string the method in this class checks if it is a permutation of a
 * palindrome or not.
 * 
 * Time Complexity: O(n)
 * 
 * Space Complexity: O(1)
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		System.out.println(isPallindromePermutation("taco cta"));
	}

	private static boolean isPallindromePermutation(String input) {
		/**
		 * Considering all 256 ASCII characters which can occur in input string.
		 * Constant size integer array to hold occurrence frequency of
		 * characters in the string.
		 */
		long bitRepresentation[] = new long[4];

		for (int i = 0; i < input.length(); i++) {

			int asciiValue = input.charAt(i);
			/**
			 * Ignoring the case where any space character occurs.
			 */
			if (input.charAt(i) != ' ') {

				/**
				 * Deciding which long array element the character's occurrence
				 * can be stored.
				 */
				int selectedLong = asciiValue / 64;
				/**
				 * checking the offset value in the chosen array element.
				 */
				int loc = asciiValue % 64;

				switch (selectedLong) {

				case 0:
					if (((1L << loc) & bitRepresentation[0]) > 0) {
						/**
						 * If the element exists already then occurrence bit
						 * should be set to zero again.
						 */
						bitRepresentation[0] = bitRepresentation[0]
								& ~(1L << loc);
					} else {
						/**
						 * Else occurrence bit should be set.
						 */
						bitRepresentation[0] = bitRepresentation[0]
								| (1L << loc);
					}
					break;

				case 1:
					if (((1L << loc) & bitRepresentation[1]) > 0) {
						/**
						 * If the element exists already then occurrence bit
						 * should be set to zero again.
						 */
						bitRepresentation[1] = bitRepresentation[1]
								& ~(1L << loc);
					} else {
						/**
						 * Else occurrence bit should be set.
						 */
						bitRepresentation[1] = bitRepresentation[1]
								| (1L << loc);
					}
					break;

				case 2:
					if (((1L << loc) & bitRepresentation[2]) > 0) {
						/**
						 * If the element exists already then occurrence bit
						 * should be set to zero again.
						 */
						bitRepresentation[2] = bitRepresentation[2]
								& ~(1L << loc);
					} else {
						/**
						 * Else occurrence bit should be set.
						 */
						bitRepresentation[2] = bitRepresentation[2]
								| (1L << loc);
					}
					break;

				case 3:
					if (((1L << loc) & bitRepresentation[3]) > 0) {
						/**
						 * If the element exists already then occurrence bit
						 * should be set to zero again.
						 */
						bitRepresentation[3] = bitRepresentation[3]
								& ~(1L << loc);
					} else {
						/**
						 * Else occurrence bit should be set.
						 */
						bitRepresentation[3] = bitRepresentation[3]
								| (1L << loc);
					}
					break;
				}

			}

		}
		/**
		 * Getting combined OR result so as to check if any bits are still set
		 * to one.
		 */
		long ORResult = bitRepresentation[0] | bitRepresentation[1]
				| bitRepresentation[2] | bitRepresentation[3];

		long ANDResult = bitRepresentation[0] & bitRepresentation[1]
				& bitRepresentation[2] & bitRepresentation[3];

		/**
		 * Figuring out if leaving just one character rest all characters are a
		 * part of palindrome.
		 */
		if (((ORResult & (ORResult - 1)) == 0) && ANDResult == 0
				&& ((bitRepresentation[0] & (bitRepresentation[0] - 1)) == 0)
				&& ((bitRepresentation[1] & (bitRepresentation[1] - 1)) == 0)
				&& ((bitRepresentation[2] & (bitRepresentation[2] - 1)) == 0)
				&& ((bitRepresentation[3] & (bitRepresentation[3] - 1)) == 0)) {
			return true;

		}
		return false;

	}

}
