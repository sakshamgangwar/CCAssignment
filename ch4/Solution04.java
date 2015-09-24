/**
 * Class contains method to check whether a binary tree is balanced or not,
 * where balanced tree means height of any two sub trees in the entire tree
 * cannot differ by more than one.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution04 {

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

		System.out.println(isBTBalanced(bst.root));
	}

	/**
	 * Method to check if the binary tree is balanced or not.
	 * 
	 * @param root
	 * @return boolean
	 */
	public static boolean isBTBalanced(BSTNode root) {
		/**
		 * If there is null at the root itself.
		 */
		if (root == null)
			return true;

		/**
		 * If it comes as -1 that means the difference is more than one and that
		 * is why the tree is not balanced.
		 */
		if (getBSTHeight(root) == -1)
			return false;

		return true;
	}

	/**
	 * Method to get height of the BST.
	 * 
	 * @param root
	 * @return int
	 */
	public static int getBSTHeight(BSTNode root) {

		/**
		 * handling the null condition.
		 */
		if (root == null)
			return 0;

		/**
		 * recursively calling the methods to get height from their neighbor
		 * nodes.
		 */
		int left = getBSTHeight(root.getLeft());
		int right = getBSTHeight(root.getRight());

		if (left == -1 || right == -1)
			return -1;

		if (Math.abs(left - right) > 1) {
			return -1;
		}

		/**
		 * When we get correct height difference which is 1 or less.
		 */
		if (left > right)
			return left + 1;
		else
			return right + 1;

	}

}
