/**
 * This class contains method which on providing two strings, it decides if one
 * is permutation of the other.
 * 
 * Assumption: considering characters as extended ASCII (max 265 characters) and
 * string is not null.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {

	public static void main(String[] args) {
		System.out.println(checkIfPermutation("saksham", "saksham"));
		System.out.println(checkIfPermutation("saksham", "sakshwm"));

	}

	/**
	 * Using integer array to store occurrence count of all possible ASCII
	 * characters in the string1 and decrementing the count if the character
	 * appears in other string thus making sure that if two strings are
	 * permutation of each other then occurrence array should contain all zeros.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param string1
	 * @param string2
	 * @return - boolean
	 */
	private static boolean checkIfPermutation(String string1, String string2) {

		if (string1.equals(string2))
			return true;
		if (string1.length() != string2.length())
			return false;
		/**
		 * Constant size integer array to hold occurrence frequency of
		 * characters in the string.
		 */
		int[] occurance = new int[256];

		/**
		 * For first string we are incrementing the count for any occurrence.
		 */
		for (int i = 0; i < string1.length(); i++)
			occurance[string1.charAt(i)]++;

		/**
		 * For second string we are decrementing the count for any occurrence.
		 */
		for (int i = 0; i < string2.length(); i++)
			occurance[string2.charAt(i)]--;

		/**
		 * If there is any character which does't match the character in the
		 * other string then occurrence value should not be zero.
		 */
		for (int i = 0; i < 256; i++) {
			if (occurance[i] != 0)
				return false;
		}

		return true;
	}
}
