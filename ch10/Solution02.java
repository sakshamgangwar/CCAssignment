import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class contains methods to sort array of strings so that all the anagrams are
 * next to each other.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {

	public static void main(String[] args) {

		String[] input = { "cat", "zot", "tac", "bat", "act", "bad", "tab", "loc" };

		for (String s : input) {
			System.out.print(s + " ");
		}
		System.out.println();

		groupAnagrams(input);

		for (String s : input) {
			System.out.print(s + " ");
		}
		System.out.println();

	}

	/**
	 * Method to sort array of strings and place anagrams next to each other. My
	 * approach is to sort each and every string and maintain a hashmap where we
	 * can store all the anagrams as value for the sorted string key.
	 * 
	 * @param input
	 */
	public static void groupAnagrams(String[] input) {

		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();

		/**
		 * Forming hashmap for anagrams.
		 */
		for (String i : input) {
			char[] s = i.toCharArray();
			/**
			 * Sorting the string
			 */
			Arrays.sort(s);
			String key = new String(s);
			if (result.containsKey(key))
				result.get(key).add(i);
			else {
				result.put(key, new ArrayList<String>());
				result.get(key).add(i);
			}
		}

		/**
		 * Setting input string with sorted strings.
		 */
		int count = 0;
		for (String i : result.keySet()) {
			for (String val : result.get(i)) {
				input[count++] = val;
			}
		}
	}

}
