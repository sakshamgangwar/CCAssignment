import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution02 {

	public static void main(String[] args) {

		String[] input = { "cat", "zot", "tac", "bat", "act", "bad", "tab",
				"loc" };

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

	public static void groupAnagrams(String[] input) {

		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();

		for (String i : input) {
			char[] s = i.toCharArray();
			Arrays.sort(s);
			String key = new String(s);
			if (result.containsKey(key))
				result.get(key).add(i);
			else {
				result.put(key, new ArrayList<String>());
				result.get(key).add(i);
			}
		}

		int count = 0;
		for (String i : result.keySet()) {
			for (String val : result.get(i)) {
				input[count++] = val;
			}
		}
	}

}
