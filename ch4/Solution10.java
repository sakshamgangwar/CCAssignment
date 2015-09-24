/**
 * This class contains a method to check whether a binary tree is subset of the
 * other binary tree.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution10 {

	public static void main(String[] args) {
		BTNode root = new BTNode(10);

		root.left = new BTNode(12);

		root.right = new BTNode(32);

		root.left.left = new BTNode(5);
		root.left.right = new BTNode(6);

		BTNode root1 = new BTNode(12);

		root1.left = new BTNode(5);
		root1.right = new BTNode(16);

		System.out.println(isSubtree(root, root1));
		
		root1 = new BTNode(12);

		root1.left = new BTNode(5);
		root1.right = new BTNode(6);
		
		System.out.println(isSubtree(root, root1));
		
	}

	/**
	 * Method to check whether a tree is copy of the other tree. we can call
	 * this method recursively to keep checking each and every node in sequence.
	 * 
	 * @param tree1Node
	 * @param tree2Node
	 * @return boolean
	 */
	public static boolean equals(BTNode tree1Node, BTNode tree2Node) {
		/**
		 * Handling the edge cases.
		 */
		if (tree1Node == null && tree2Node == null)
			return true;
		if (tree1Node == null || tree1Node == null)
			return false;

		return (tree1Node.value == tree2Node.value
				&& equals(tree1Node.left, tree2Node.left) && equals(
					tree1Node.right, tree2Node.right));
	}

	/**
	 * Method to check whether tree2 is subset of tree1.
	 * 
	 * @param tree1Node
	 * @param tree2Node
	 * @return boolean
	 */
	public static boolean isSubtree(BTNode tree1Node, BTNode tree2Node) {
		/**
		 * Handling edge cases.
		 */
		if (tree2Node == null)
			return true;
		if (tree1Node == null)
			return false;

		if (equals(tree1Node, tree2Node))
			return true;
		/**
		 * making recursive call to subtree checking method using the
		 * left and right subtree of the tree1.
		 */
		return isSubtree(tree1Node.left, tree2Node)
				|| isSubtree(tree1Node.right, tree2Node);
	}
}
