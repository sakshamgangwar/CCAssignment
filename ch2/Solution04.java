/**
 * Contains method to partition a linked list around a value x such that all
 * nodes less than x come before all nodes greater than x.
 * 
 * 
 * @author Saksham Gangwar
 *
 */

public class Solution04 {
	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.add(3);
		lList.add(5);
		lList.add(8);
		lList.add(5);
		lList.add(10);
		lList.add(2);
		lList.add(1);

		lList.printList();

		doPartition(lList, 5);

		lList.printList();
	}

	/**
	 * In order to partition the list, we can try to create two linked lists one
	 * with elements less than the value mentioned and one with elements with
	 * value more than the one mentioned. And at the end join both the list
	 * together.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param lList
	 * @param value
	 */
	private static void doPartition(LinkedList lList, int value) {
		Node lessThanValHead = null;
		Node lessThanValTail = null;
		Node moreThanValHead = null;
		Node moreThanValTail = null;

		Node node = lList.head;

		while (node != null) {

			/**
			 * Saving the pointer to the next node.
			 */
			Node nextNode = node.next;

			node.next = null;

			/**
			 * If the value of node is less than the considered value we can add
			 * it to the less than list
			 */
			if (node.value < value) {
				if (lessThanValHead == null) { 
					/**
					 * If the list was empty.
					 */
					lessThanValHead = node;
					lessThanValTail = lessThanValHead;
				} else {
					/**
					 * If the list was not empty.
					 */
					lessThanValTail.next = node;
					lessThanValTail = node;
				}
			} else {
				/**
				 * If the value of node is more than the considered value we can add
				 * it to the more than list
				 */
				if (moreThanValHead == null) {
					/**
					 * If the list was empty.
					 */
					moreThanValHead = node;
					moreThanValTail = moreThanValHead;
				} else {
					/**
					 * If the list was not empty.
					 */
					moreThanValTail.next = node;
					moreThanValTail = node;
				}
			}

			/**
			 * Making node point to the next of the original linked list.
			 * 
			 */
			node = nextNode;
		}

		/**
		 * Now forming the new linked list for the solution.
		 */
		
		/**
		 * If there was no element more than the considered one.
		 */
		if (moreThanValHead == null) {
			lList.head = lessThanValHead;
		}

		if (lessThanValTail != null) {
			/**
			 * Joining the two lists.
			 */
			lessThanValTail.next = moreThanValHead;
			lList.head = lessThanValHead;
		}


		/**
		 * If there was no element less than the considered one.
		 */
		if (lessThanValHead == null) {
			lList.head = moreThanValHead;
		}

	}

}
