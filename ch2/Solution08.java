/**
 * Class contains method to detect if there is any loop in a linked list and
 * also the node from where the loop begins.
 * 
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();

		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);

		Node current = ll.head;

		while (current.next != null)
			current = current.next;

		current.next = ll.head.next.next;

		System.out.println(detectLoop(ll));

	}

	/**
	 * Method to detect loop in a linked list and return node where the loop
	 * begins in the linked list.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param ll
	 * @return Node
	 */
	private static Node detectLoop(LinkedList ll) {
		Node current = ll.head;
		Node slowPointer = current;
		Node fastPointer = current;

		/**
		 * looping on the list with two pointers one is moving with twice speed
		 * of the other and we break only when they reach on the same node in
		 * the loop.
		 */
		while (slowPointer.next != null && fastPointer.next != null) {

			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer == fastPointer)
				break;
		}

		/**
		 * If both are null then there is definitely no loop.
		 */
		if (fastPointer == null || fastPointer.next == null)
			return null;

		/**
		 * setting slow pointer back to the head of linked list.
		 */
		slowPointer = ll.head;

		/**
		 * both the pointers will now move at same speed and will meet at the
		 * point where the loop starts.
		 */
		while (slowPointer != fastPointer) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next;
		}

		return fastPointer;
	}
}
