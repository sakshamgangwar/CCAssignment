/**
 * This class contains method to compress a given string. It makes use of count
 * of repeated characters.
 * 
 * Assumption: string consists of only upper case and lower case characters.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {

	public static void main(String[] args) {
		System.out.println(compressString("aaaabbc"));
	}

	/**
	 * Method to compress the provided String.
	 * 
	 * Time Complexity: O(n^2)
	 * 
	 * @param st
	 * @return - String
	 */
	private static String compressString(String st) {
		int count = 0;
		/**
		 * Using string builder instead of using new string every time so as to
		 * be more efficient with the use of memory.
		 */
		StringBuilder sb = new StringBuilder();

		/**
		 * Looping over all the characters in the provided string.
		 */
		for (int i = 0; i < st.length(); i++) {
			count++;
			/**
			 * Checking if the next occurring character is not equal to the
			 * current one then we should append the current character with its
			 * count till now.
			 */
			if (i >= st.length() - 1 || st.charAt(i) != st.charAt(i + 1)) {
				sb.append("" + st.charAt(i) + count);
				/**
				 * Setting count to zero for the next character.
				 */
				count = 0;
			}
		}
		/**
		 * For the case where compressed string is longer than the original one.
		 */
		if (sb.length() < st.length())
			return sb.toString();
		else
			return st;
	}
}
