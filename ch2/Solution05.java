/**
 * This class contains two methods which are used to get sum (in the form of a
 * linked list) of two numbers represented using a linked list, where each node
 * contains a single digit.
 * 
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution05 {

	public static void main(String[] args) {
		LinkedList ll1 = new LinkedList();
		LinkedList ll2 = new LinkedList();

		ll1.add(7);
		ll1.add(1);
		ll1.add(6);

		ll2.add(5);
		ll2.add(9);
		ll2.add(2);

		/**
		 * In Order get sum:
		 */
		System.out.println("In Order:");
		ll1.printList();
		ll2.printList();

		System.out.println("\nSUM:");
		getSumInOrder(ll1, ll2).printList();

		ll1 = new LinkedList();
		ll2 = new LinkedList();

		ll1.add(6);
		ll1.add(1);
		ll1.add(7);

		ll2.add(2);
		ll2.add(9);
		ll2.add(5);

		/**
		 * In Reverse Order get sum:
		 */
		System.out.println("\n\nIn Reverse Order:");
		ll1.printList();
		ll2.printList();
		System.out.println("\nSUM:");
		getSumInReverseOrder(ll1, ll2).printList();

	}

	/**
	 * In this method we are considering digits stored in reverse order, such
	 * that 1's digit is as the head of the list.
	 * 
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * @param ll1
	 * @param ll2
	 * @return LinkedList
	 */
	private static LinkedList getSumInOrder(LinkedList ll1, LinkedList ll2) {
		/**
		 * If both the numbers are null we can directly return null.
		 */
		if (ll1 == null && ll2 == null) {
			return null;
		}

		/**
		 * New linked list to return sum.
		 */
		LinkedList sum = new LinkedList();

		sum.head = new Node(0);
		Node digit1 = ll1.head;
		Node digit2 = ll2.head;
		Node sumDigit = sum.head;

		/**
		 * Initially carry will be set to zero.
		 */
		int carry = 0;
		/**
		 * Continuing until both of the linked list are traversed completely.
		 */
		while (digit1 != null || digit2 != null) {
			/**
			 * if digit one is not null we get the sum by adding everything to
			 * carry from previous round.
			 */
			if (digit1 != null) {
				carry += digit1.value;
				digit1 = digit1.next;
			}

			/**
			 * if digit two is not null we get the sum by adding everything to
			 * carry from previous round.
			 */
			if (digit2 != null) {
				carry += digit2.value;
				digit2 = digit2.next;
			}

			/**
			 * We set the sum digit of result and take remaining carry forward.
			 */
			sumDigit.next = new Node(carry % 10);
			sumDigit = sumDigit.next;
			carry /= 10;
		}

		/**
		 * After the complete sum has been calculated we can check if we having
		 * remaining carry which can be set in the product.
		 */
		if (carry == 1)
			sumDigit.next = new Node(1);
		/**
		 * As we started with a zero node.
		 */
		sum.head = sum.head.next;
		return sum;

	}

	/**
	 * In this method we are considering digits stored in forward order.
	 * 
	 * @param ll1
	 * @param ll2
	 * @return - LinkedList
	 */
	private static LinkedList getSumInReverseOrder(LinkedList ll1,
			LinkedList ll2) {
		return reverseLinkedList(getSumInOrder(reverseLinkedList(ll1),
				reverseLinkedList(ll2)));
	}

	public static LinkedList reverseLinkedList(LinkedList lList) {
		if (lList.head == null || lList.head.next == null)
			return lList;

		Node n1 = lList.head;
		Node n2 = lList.head.next;

		lList.head.next = null;

		while (n1 != null && n2 != null) {
			Node temp = n2.next;
			n2.next = n1;
			n1 = n2;
			if (temp != null) {
				n2 = temp;
			} else {
				break;
			}
		}

		lList.head = n2;

		return lList;
	}
}
