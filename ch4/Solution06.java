/**
 * Class contains algorithm, to find the next in-order successor of a given node
 * in s binary search tree. Assuming each node is having a link to it's parents.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {

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

		System.out.println(getSuccessor(bst.root.left.right));
	}

	/**
	 * Method to find next node of a given node (in-order successor), in a
	 * binary search tree.
	 * 
	 * @param node
	 * @return BSTNode
	 */
	public static BSTNode getSuccessor(BSTNode node) {
		/**
		 * Handling the empty case.
		 */
		if (node == null)
			return null;

		/**
		 * If right child is null. We need to traverse up to the parent.
		 */
		if (node.right == null) {
			BSTNode current = node;
			BSTNode parent = node.getParent();
			while (parent != null && parent.left != current) {
				current = parent;
				parent = parent.getParent();
			}
			return parent;
		} else {
			/**
			 * Else we can aim for the left most child from the right branch.
			 */
			return leftMostChildFromRightBranch(node.right);
		}
	}

	/**
	 * Method which returns left most child from a given node.
	 * 
	 * @param node
	 * @return BSTNode
	 */
	private static BSTNode leftMostChildFromRightBranch(BSTNode node) {
		/**
		 * Handling the null case.
		 */
		if (node == null)
			return null;

		/**
		 * Looping until we reach the left most child in the considered tree.
		 */
		while (node.getLeft() != null) {
			node = node.left;
		}

		return node;
	}

}
