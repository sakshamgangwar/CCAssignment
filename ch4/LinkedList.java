/**
 * Class to represent a generic linked list node used in few solutions of
 * chapter 4.
 * 
 * @author Saksham Gangwar
 *
 * @param <T>
 */
class LLNode<T> {

	LLNode<T> next;
	T value;

	public LLNode(T value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return value + "";
	}

}

/**
 * Generic linked list used in few solutions for chapter 4.
 * 
 * @author Saksham Gangwar
 *
 * @param <T>
 */
class LinkedList<T> {

	LLNode<T> head;

	public LinkedList() {
		head = null;
	}

	/**
	 * 
	 * Method to print the complete linked list.
	 */
	public void printList() {
		LLNode n = head;
		System.out.println();
		while (n != null) {
			System.out.print("[ " + n.value + " ] -> ");
			n = n.next;
		}
		System.out.println("[X]");
	}

	/**
	 * Method to add a new value in the linked list.
	 * 
	 * @param value
	 */
	public void add(T value) {
		LLNode n = new LLNode(value);
		if (head == null) {
			head = n;
		} else {
			LLNode counterNode = head;
			while (counterNode.next != null) {
				counterNode = counterNode.next;
			}

			counterNode.next = n;

		}
	}

	/**
	 * Method to return size of any linked list.
	 * 
	 * @return - int
	 */
	public int getSize() {
		LLNode p = head;
		int count = 0;
		if (head == null)
			return 0;
		else {
			while (p != null) {
				count++;
				p = p.next;
			}

			return count;
		}
	}

}
