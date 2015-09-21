/**
 * This class contains method to remove middle node of a singly linked list with
 * access given only to the middle node.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		LinkedList lList = new LinkedList();
		lList.add(1);
		lList.add(2);
		lList.add(3);
		lList.add(4);
		lList.add(5);

		lList.printList();

		deleteMiddleNode(lList.head.next.next);

		lList.printList();
	}

	/**
	 * In this method in order to remove the middle node for which we have a
	 * pointer, we can copy the content of next node to this one and point it to
	 * the following node after the next node.
	 * 
	 * Time Complexity: O(1)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param nodeToBeDeleted
	 * @return - boolean
	 */
	private static boolean deleteMiddleNode(Node nodeToBeDeleted) {
		if (nodeToBeDeleted == null || nodeToBeDeleted.next == null) {
			return false;
		}

		Node nextNode = nodeToBeDeleted.next;
		nodeToBeDeleted.value = nextNode.value;
		nodeToBeDeleted.next = nextNode.next;

		return true;

	}

}
