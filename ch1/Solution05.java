/**
 * There can be three types of edits which can be performed on a string,
 * inserting a character, removing a character or replacing a character, this
 * class is having a method which checks if the two strings are one or less
 * edits away or not.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution05 {

	public static void main(String[] args) {
		System.out.println(checkIfOneAway("bale", "palew"));
	}

	/**
	 * Time Complexity : O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param st1
	 * @param st2
	 * @return - boolean
	 */
	private static boolean checkIfOneAway(String st1, String st2) {
		/**
		 * The size difference in both the strings should not be more than 1.
		 */
		if (Math.abs(st1.length() - st2.length()) > 1)
			return false;

		/**
		 * if the length of both the strings is same then checking how many
		 * differences are there using a flag which is set to true if there is a
		 * difference and if more than one times difference is encountered it
		 * means it is more than one edit away.
		 */
		if (st1.length() == st2.length()) {
			boolean diff = false;
			for (int i = 0; i < st1.length(); i++) {
				if (st1.charAt(i) != st2.charAt(i)) {
					if (diff) {
						return false;
					}
					diff = true;
				}
			}
		} else {
			/**
			 * Making sure that st1 is the smaller string if not replace it with
			 * st2.
			 */
			if (st1.length() > st2.length()) {
				String temp = st1;
				st1 = st2;
				st2 = temp;
			}

			int currentPointer1 = 0;
			int currentPointer2 = 0;

			boolean diff = false;
			/**
			 * Using two pointers and checking if characters at each pointer
			 * location is same, if yes then move to the next and if not making
			 * sure that the difference is occurring only once.
			 */
			while (currentPointer1 < st1.length()
					&& currentPointer2 < st2.length()) {

				if (st1.charAt(currentPointer1) == st2.charAt(currentPointer2)) {
					currentPointer1++;
					currentPointer2++;
				} else {
					if (diff) {
						return false;
					}
					diff = true;
					currentPointer2++;
				}

			}

		}

		return true;
	}
}
