/**
 * Class contains method to determine whether two linked lists intersect or not
 * and return intersecting node if it intersects.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution07 {

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();
		LinkedList commonList = new LinkedList();

		ll1.add(7);
		ll1.add(1);
		ll1.add(6);

		ll2.add(5);
		ll2.add(9);
		ll2.add(2);

		commonList.add(1);
		commonList.add(2);
		commonList.add(3);

		Node current1 = ll1.head;

		while (current1.next != null)
			current1 = current1.next;

		current1.next = commonList.head;

		Node current2 = ll2.head;

		while (current2.next != null)
			current2 = current2.next;

		current2.next = commonList.head;

		System.out.println(getIntersectionNode(ll1, ll2));

	}

	/**
	 * Method returns the node of intersection for the two provided linked
	 * lists.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param ll1
	 * @param ll2
	 * @return Node
	 */
	public static Node getIntersectionNode(LinkedList ll1, LinkedList ll2) {

		/**
		 * Counting the number of nodes in both the linked lists.
		 * 
		 */
		Node counter1 = ll1.head;
		Node counter2 = ll2.head;

		if (counter1 == null || counter2 == null)
			return null;

		int length1 = 0;
		int length2 = 0;

		while (counter1 != null) {
			length1++;
			counter1 = counter1.next;
		}
		while (counter2 != null) {
			length2++;
			counter2 = counter2.next;
		}

		/**
		 * based on length we can find the difference in the length of both the
		 * linked lists.
		 */

		int diff = 0;
		counter1 = ll1.head;
		counter2 = ll2.head;

		if (length1 > length2) {
			/**
			 * If first list is longer.
			 */
			diff = length1 - length2;
			int i = 0;
			/**
			 * As first list is longer we need to bring the pointer to the same
			 * length as that of second list.
			 */
			while (i < diff) {
				counter1 = counter1.next;
				i++;
			}
		} else {
			/**
			 * If second list is longer.
			 */
			diff = length2 - length1;
			int i = 0;
			/**
			 * As second list is longer we need to bring the pointer to the same
			 * length as that of first list.
			 */
			while (i < diff) {
				counter2 = counter2.next;
				i++;
			}
		}
		/**
		 * Now both the pointers on both the lists are at equal distance from
		 * the end so definitely they should meet in-between if these two lists
		 * intersect.
		 */
		while (counter1 != null && counter2 != null) {
			/**
			 * If two nodes are same definitely it is the intersection point.
			 */
			if (counter1 == counter2) {
				return counter1;
			} else {

			}
			counter1 = counter1.next;
			counter2 = counter2.next;
		}

		return null;
	}

}
