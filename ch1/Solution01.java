

/**
 * Implementing Algorithm to find whether any string is having all unique
 * characters or not.
 * 
 * Assumption: considering characters as extended ASCII (max 265 characters) and
 * string is not null.
 * 
 * 
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {
	public static void main(String[] args) {
		System.out.println(checkIfUnique("saksham"));
		System.out.println(checkIfUnique("sakhm"));

	}

	/**
	 * 
	 * This method returns true if the input string is having all unique
	 * characters.
	 * 
	 * Time complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param userInput
	 * @return boolean
	 */
	private static boolean checkIfUnique(String userInput) {

		/**
		 * If length of the input is more than 256 characters it means
		 * definitely it has repeated characters.
		 */
		if (userInput.length() > 256)
			return false;

		/**
		 * Considering an array of long variables so that we can store 256
		 * characters' occurrence data.
		 */
		long bitRepresentation[] = new long[4];

		/**
		 * Looping over each and every character in the string.
		 */
		for (int i = 0; i < userInput.length(); i++) {
			/**
			 * getting the ascii value.
			 */
			int asciiValue = userInput.charAt(i);
			/**
			 * getting to know which of the array element it will fall into.
			 */
			int selectedLong = asciiValue / 64;
			/**
			 * checking the offset value in the chosen array element.
			 */
			int loc = asciiValue % 64;
			/**
			 * If already the bit is set to one it means the character occurred
			 * before as well so we need to return false. Otherwise will set the
			 * new character occurrence as one.
			 */
			switch (selectedLong) {

			case 0:
				if (((1L << loc) & bitRepresentation[0]) > 0)
					return false;
				bitRepresentation[0] = bitRepresentation[0] | (1L << loc);
				break;

			case 1:
				if (((1L << loc) & bitRepresentation[1]) > 0)
					return false;
				bitRepresentation[1] = bitRepresentation[1] | (1L << loc);
				break;

			case 2:
				if (((1L << loc) & bitRepresentation[2]) > 0)
					return false;
				bitRepresentation[2] = bitRepresentation[2] | (1L << loc);
				break;

			case 3:
				if (((1L << loc) & bitRepresentation[3]) > 0)
					return false;
				bitRepresentation[3] = bitRepresentation[3] | (1L << loc);
				break;
			}

		}

		return true;
	}

}
