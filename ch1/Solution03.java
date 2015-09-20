/**
 * Class contains method to replace all spaces in the string with %20, assuming
 * that string has sufficient space to accommodate additional characters.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		System.out.println(getURLString("Mr John Smith    ".toCharArray(), 13));
	}

	/**
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param inputString
	 *            - input text
	 * @param realLength
	 *            - tells about how much is the current content of the string.
	 * @return - URLified String.
	 */
	private static char[] getURLString(char[] inputString, int realLength) {

		int spaceCount = 0;
		int newLength = 0;

		/**
		 * Counting number of spaces in the given string till the real length.
		 */
		for (int i = 0; i < realLength; i++) {
			if (inputString[i] == ' ')
				spaceCount++;
		}

		/**
		 * Considering the amount of length which is required to store extra
		 * characters too for %20
		 */
		newLength = realLength + spaceCount * 2;

		/**
		 * Ending the string with new length defined.
		 */
		inputString[newLength - 1] = '\0';

		for (int i = realLength - 1; i >= 0; i--) {
			/**
			 * If any character exist start moving towards right.
			 */
			if (inputString[i] != ' ') {
				inputString[--newLength] = inputString[i];
			} else {
				/**
				 * place %20 if encounter any space.
				 */
				inputString[--newLength] = '0';
				inputString[--newLength] = '2';
				inputString[--newLength] = '%';
			}
		}

		return inputString;
	}
}
