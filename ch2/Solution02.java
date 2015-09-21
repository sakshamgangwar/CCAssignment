/**
 * Class containing method to return Kth to the last element of a singly linked
 * list.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.add(1);
		lList.add(2);
		lList.add(3);
		lList.add(1);
		lList.add(4);
		lList.add(5);

		lList.printList();

		System.out.println(returnKthToLast(lList, 3));
	}

	/**
	 * Making use of iterative approach to find the kth to the last element in
	 * the singly linked list.Making use of two pointers to the list, moving the
	 * first pointer by k nodes and then moving both the pointers together so
	 * that as soon as the pointer at kth position reaches end of list the first
	 * pointer which started from first position will point at element which is
	 * kth to last.
	 * 
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param lList
	 * @param k
	 * @return
	 */
	private static Integer returnKthToLast(LinkedList lList, int k) {
		
		Node pointer1 = lList.head;
		Node pointer2 = lList.head;

		/**
		 * Moving pointer 2 with k positions.
		 */
		for (int i = 0; i < k; i++) {
			if (pointer2 == null)
				return null;
			pointer2 = pointer2.next;
		}

		/**
		 * Once pointer 2 is at kth position from the beginning we can move both
		 * the pointers 1 and 2 till 2 reaches the end.
		 */
		while (pointer2.next != null) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}

		return pointer1.value;

	}

}
