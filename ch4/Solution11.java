import java.util.Random;

/**
 * Implementing extra method for BST to get random node from the tree.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution11 {

	public static void main(String[] args) {

		BSTreeSol11 bst = new BSTreeSol11();

		bst.add(10);
		bst.add(7);
		bst.add(30);
		bst.add(1);
		bst.add(8);
		bst.add(15);
		bst.add(34);

		System.out.println(bst.root.getRandomNode());

	}

}

class BSTreeSol11 {

	BSTreeNode root;

	/**
	 * Method to add a node in the tree.
	 * 
	 * @param value
	 */
	public void add(int value) {
		if (root == null) {
			root = new BSTreeNode(value);
		} else {
			root.insert(value);
		}
	}

}

/**
 * Node for the tree considered.
 * 
 * @author Saksham Gangwar
 *
 */
class BSTreeNode {
	int value;
	BSTreeNode left;
	BSTreeNode right;
	int size;

	public BSTreeNode(int value) {
		this.value = value;
		size = 1;
	}

	/**
	 * Method to insert node in the tree. Insertion logic used is of a BST.
	 * 
	 * @param value
	 */
	public void insert(int value) {
		if (value <= this.value) {
			if (left != null) {
				left.insert(value);
			} else {
				left = new BSTreeNode(value);
			}
		} else {
			if (right != null) {
				right.insert(value);
			} else {
				right = new BSTreeNode(value);
			}
		}
		/**
		 * Incrementing size to keep track of current size of the BST.
		 */
		size++;
	}

	/**
	 * Method to find whether a node value exist in the tree of not.
	 * 
	 * @param value
	 * @return
	 */
	public BSTreeNode find(int value) {
		if (this.value == value)
			return this;
		else {
			if (value <= this.value) {
				if (left != null)
					return left.find(value);
				else
					return null;
			} else {
				if (right != null)
					return right.find(value);
				else
					return null;
			}

		}
	}

	/**
	 * Method to get a random node.
	 * 
	 * @return
	 */
	public BSTreeNode getRandomNode() {
		int leftSize = 0;
		if (left != null)
			leftSize = left.size;

		Random r = new Random();

		int i = r.nextInt(this.size);

		System.out.println("random no: " + i);

		/**
		 * If the random value is less than the left size, we need to to fetch
		 * the value from the left side of the tree.
		 */
		if (i < leftSize)
			return left.getRandomNode();

		/**
		 * If the value is equal then the node is the result.
		 */
		else if (i == leftSize)
			return this;

		/**
		 * If the random value is more than the left size, we need to to fetch
		 * the value from the right side of the tree.
		 */
		else
			return right.getRandomNode();

	}

	@Override
	public String toString() {
		return "BSTreeNode [value=" + value + "]";
	}

}
