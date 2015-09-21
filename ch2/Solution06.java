/**
 * This class contains method to check if a linked list is a palindrome.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {

	public static void main(String[] args) {

		LinkedList ll = new LinkedList();

		ll.add(7);
		ll.add(1);
		ll.add(2);
		ll.add(1);
		ll.add(7);

		System.out.println(isPalindrome(ll));
	}

	/**
	 * Method to check if linked list is palindrome or not.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param lList
	 * @return boolean
	 */
	public static boolean isPalindrome(LinkedList lList) {

		/**
		 * If the list is having just one or null we can return true.
		 */
		if (lList.head == null || lList.head.next == null)
			return true;

		Node slowPointer = lList.head;
		Node fastPointer = lList.head;

		/**
		 * Using fast and slow pointers where fast pointer moves two nodes at a
		 * time and slow pointer moves one node at a time. As soon as fast
		 * pointer reaches end we can be sure that slow pointer must reach
		 * middle of the list.
		 */
		while (fastPointer.next != null && fastPointer.next.next != null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}

		/**
		 * Using the slow pointer now we can reverse the list pointers from middle point onwards.
		 */
		Node secondHalfHead = slowPointer.next;
		slowPointer.next = null;

		Node n1 = secondHalfHead;
		Node n2 = n1.next;

		while (n1 != null && n2 != null) {
			Node temp = n2.next;
			n2.next = n1;
			n1 = n2;
			n2 = temp;
		}

		secondHalfHead.next = null;

		/**
		 * We can compare the two lists now.
		 */
		Node node1 = (n2 == null ? n1 : n2);
		Node node2 = lList.head;
		while (node1 != null) {
			/**
			 * If we find any difference we can return false directly.
			 */
			if (node1.value != node2.value)
				return false;
			node1 = node1.next;
			node2 = node2.next;

		}

		return true;
	}
}
