import java.util.ArrayList;

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

		Listy listy = new Listy(input);

		System.out.println(sortedSearchNoSize(listy, 3));

	}

	public static Integer sortedSearchNoSize(Listy listy, int value) {

		int count = 1;

		while (listy.elementAt(count) != -1 && value >= listy.elementAt(count)) {
			count = count * 2;
		}

		int low = count / 2;
		int high = count;

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
