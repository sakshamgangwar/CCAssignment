/**
 * Class with a method to check if binary tree is a binary search tree.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution05 {

	public static void main(String[] args) {

		BSTree bst = new BSTree();

		bst.add(4);
		bst.add(2);
		bst.add(6);
		bst.add(1);
		bst.add(3);
		bst.add(5);
		bst.add(7);

		System.out.println("Binary Tree In Order: ");
		bst.print(bst.root);

		System.out.println();

		System.out.println(isBST(bst.root));
	}

	/**
	 * Method to test whether the binary tree considered is a BST or not.
	 * 
	 * @param root
	 * @return - boolean
	 */
	public static boolean isBST(BSTNode root) {
		return isValidBST(root, Double.NEGATIVE_INFINITY,
				Double.POSITIVE_INFINITY);
	}

	/**
	 * Method to validate whether binary tree considered is a BST or not.
	 * 
	 * @param node
	 * @param min
	 * @param max
	 * @return boolean
	 */
	public static boolean isValidBST(BSTNode node, double min, double max) {

		/**
		 * If the node contains null, we can return true.
		 */
		if (node == null)
			return true;

		/**
		 * check current node.
		 */
		if (node.getValue() <= min || node.getValue() >= max)
			return false;

		/**
		 * recursively calls are being made to check for the similar case with
		 * the children of the current node.
		 */
		return isValidBST(node.getLeft(), min, node.getValue())
				&& isValidBST(node.getRight(), node.getValue(), max);
	}

}
