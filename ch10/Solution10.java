/**
 * This class is having methods to take input as a stream of integers and at any
 * moment we can fetch rank of any integer which is the number of values less
 * than or equal to it (excluding itself).
 * 
 * Ideal solution of this problem is to consider a binary search tree with each
 * node maintaining one more value which is its rank. Its rank is incremented
 * every time during insertion we move towards its left child.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution10 {

	public static void main(String[] args) {
		BSTree t = new BSTree();
		t.add(5);
		t.add(1);
		t.add(4);
		t.add(4);
		t.add(5);
		t.add(9);
		t.add(7);
		t.add(13);
		t.add(3);

		System.out.println(t.getRank(t.root, 1));
		System.out.println(t.getRank(t.root, 3));
		System.out.println(t.getRank(t.root, 4));
	}

}

class BSTree {

	Node root;

	/**
	 * Method to add a new node in the tree.
	 * 
	 * @param value
	 */
	public void add(int value) {
		/**
		 * If root is null we need to initialize the root and set left and right
		 * children as null.
		 */
		if (root == null) {
			root = new Node(value);
			root.setLeft(null);
			root.setRight(null);
		} else {
			add(root, value);
		}
	}

	/**
	 * Method which will be called recursively until we reach the correct place
	 * in the tree where the desired value has to be inserted while maintaining
	 * the insertion logic for the binary search tree.
	 * 
	 * @param node
	 * @param value
	 */
	public void add(Node node, int value) {
		/**
		 * Move towards the left of the focused node.
		 */
		if (value <= node.value) {

			if (node.left == null) {
				node.left = new Node(value);
				node.left.setLeft(null);
				node.left.setRight(null);

			} else {
				add(node.left, value);
			}
			/**
			 * Incrementing rank.
			 */
			node.rank++;

		} else if (value > node.value) {

			/**
			 * Move towards the right of the focused node.
			 */
			if (node.right == null) {
				node.right = new Node(value);
				node.right.setLeft(null);
				node.right.setRight(null);
			} else {
				add(node.right, value);
			}

		}
	}

	/**
	 * Method to fetch rank for any node.
	 * 
	 * @param root
	 * @param value
	 * @return
	 */
	public int getRank(Node root, int value) {
		/**
		 * Handling null condition
		 */
		if (root == null)
			return -1;
		/**
		 * If we reach exact value.
		 */
		if (root.value == value)
			return root.getRank();
		/**
		 * If on the left child side we can return recursively from the left
		 * side. If from the right side that means we need to add rank of parent
		 * + parent node ( all those are smaller than the node under
		 * consideration) and then find rank of the element which is on the
		 * right side.
		 */
		if (value < root.value)
			return getRank(root.left, value);
		else
			return root.rank + 1 + getRank(root.right, value);
	}

}

class Node {
	int value;
	/**
	 * Adding variable to maintain rank.
	 */
	int rank;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
		this.rank = 0;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
