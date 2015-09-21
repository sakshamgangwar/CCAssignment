/**
 * Class contains a method to remove duplicate nodes in a singly linked list.
 * 
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.add(1);
		lList.add(2);
		lList.add(3);
		lList.add(1);
		lList.add(4);
		lList.add(5);

		lList.printList();

		removeDuplicateNodes(lList);

		lList.printList();

	}

	/**
	 * Method to remove duplicate nodes in a singly linked list.
	 * 
	 * Time Complexity: O(n^2) 
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param lList
	 */
	private static void removeDuplicateNodes(LinkedList lList) {

		/**
		 * getting pointer pointing to the head of the list in the beginning.
		 */
		Node pointer = lList.head;

		/**
		 * Looping over the complete linked list till it ends.
		 */
		while (pointer != null) {

			/**
			 * fetching the current pointer.
			 */
			Node current = pointer;

			/***
			 * for every current pointer encountered, looping over the complete
			 * remaining linked list.
			 */
			while (current.next != null) {

				/**
				 * In case we find a duplicate, we can remove the node from the
				 * list and move to the next element.
				 */
				if (pointer.value == current.next.value) {
					current.next = current.next.next;
				} else {
					current = current.next;
				}
			}

			pointer = pointer.next;
		}
	}
}
