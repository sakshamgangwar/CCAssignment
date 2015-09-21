class Node {

	Node next;
	int value;

	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return value + "";
	}

}

class LinkedList {

	Node head;

	public LinkedList() {
		head = null;
	}

	public void printList() {
		Node n = head;
		System.out.println();
		while (n != null) {
			System.out.print("[ " + n.value + " ] -> ");
			n = n.next;
		}
		System.out.println("[X]");
	}

	public void add(int value) {
		Node n = new Node(value);
		if (head == null) {
			head = n;
		} else {
			Node counterNode = head;
			while (counterNode.next != null) {
				counterNode = counterNode.next;
			}

			counterNode.next = n;

		}
	}

}
