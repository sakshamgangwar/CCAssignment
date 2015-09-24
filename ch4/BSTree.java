/**
 * Class used to implement Binary Search Tree for several solutions in the
 * chapter.
 * 
 * @author Saksham Gangwar
 *
 */
public class BSTree {

	/**
	 * Reference for the root node of the tree.
	 */
	BSTNode root;

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
			root = new BSTNode(value);
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
	public void add(BSTNode node, int value) {
		/**
		 * Move towards the left of the focused node.
		 */
		if (value < node.value) {
			if (node.left == null) {
				node.left = new BSTNode(value);
				node.left.parent = node;
				node.left.setLeft(null);
				node.left.setRight(null);
			} else {
				add(node.left, value);
			}
		} else if (value > node.value) {
			/**
			 * Move towards the right of the focused node.
			 */
			if (node.right == null) {
				node.right = new BSTNode(value);
				node.right.parent = node;
				node.right.setLeft(null);
				node.right.setRight(null);
			} else {
				add(node.right, value);
			}
		}
	}

	/**
	 * Method to print the tree from a given node in-order.
	 * 
	 * @param node
	 */
	void print(BSTNode node) {
		if (node != null) {
			print(node.getLeft());
			System.out.print(node.getValue() + " ");
			print(node.getRight());
		}
	}

}

/**
 * Class used to define an individual node on the BST.
 * 
 * @author Saksham Gangwar
 *
 */
class BSTNode {
	int value;
	BSTNode left;
	BSTNode right;
	/**
	 * Added parent reference for a single problem and is not used in any other
	 * problem.
	 */
	BSTNode parent;

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}

	public BSTNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "BSTNode [value=" + value + "]";
	}

}
