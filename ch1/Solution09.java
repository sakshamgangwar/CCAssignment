/**
 * Class contains method which checks if one word is a rotation of other word.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution09 {

	public static void main(String[] args) {
		System.out.println(checkIfStringRotation("waterbottle", "rrbottlewat"));
	}

	/**
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return boolean
	 */
	private static boolean checkIfStringRotation(String s1, String s2) {
		/**
		 * If both the strings are of equal length then only we should go ahead
		 * and check for whether one is rotation of other or not.
		 */
		if (s1.length() == s2.length()) {
			/**
			 * If a string is rotation of another string then definitely it
			 * should occur as a substring of original string doubled with the
			 * same content.
			 */
			return isSubstring(s1 + s1, s2);
		}

		return false;

	}

	/**
	 * Just checking whether s2 is present in s1 or not. 
	 * 
	 * @param s1
	 * @param s2
	 * @return - boolean
	 */
	private static boolean isSubstring(String s1, String s2) {
		if (s1.contains(s2))
			return true;
		return false;
	}

}
