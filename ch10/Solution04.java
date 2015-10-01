import java.util.ArrayList;

/**
 * This class contains method to search in a sorted array where the array
 * doesn't have any method to figure out size. We can only fetch elementAt any
 * index. If any element occurs multiple times we can return any index.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		input.add(5);
		input.add(6);
		input.add(7);
		input.add(8);
		input.add(9);
		input.add(10);

		/**
		 * Creating Listy instance.
		 */
		Listy listy = new Listy(input);

		System.out.println(sortedSearchNoSize(listy, 3));

	}

	/**
	 * Method to search occurrence of any number in Listy
	 * 
	 * @param listy
	 * @param value
	 * @return Integer
	 */
	public static Integer sortedSearchNoSize(Listy listy, int value) {

		/**
		 * count is being used to identify range where we can search the value.
		 */
		int count = 1;

		/**
		 * we keep doubling count until we reach end and value being searched
		 * comes in the range we reached.
		 */
		while (listy.elementAt(count) != -1 && value >= listy.elementAt(count)) {
			count = count * 2;
		}

		/**
		 * Setting low and high for the identified range. According to second
		 * last loop of while before it terminated, value should be greater than
		 * count/2. So we get our range correctly.
		 */
		int low = count / 2;
		int high = count;

		/**
		 * Performing binary search.
		 */
		while (low <= high) {
			int mid = (low + high) / 2;

			if (listy.elementAt(mid) == value)
				return mid;

			if (listy.elementAt(mid) > value)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return null;
	}

}
/**
 * Data Structure without any size method.
 * 
 * @author Saksham Gangwar
 *
 */
class Listy {
	private ArrayList<Integer> list;

	public Listy(ArrayList<Integer> list) {
		this.list = list;
	}

	public Integer elementAt(int i) {
		if (i >= list.size())
			return -1;
		else
			return list.get(i);
	}

}
