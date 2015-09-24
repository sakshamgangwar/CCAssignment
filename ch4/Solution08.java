/**
 * Class with a method to find first common ancestor or least common ancestor
 * for the two given nodes in a binary tree.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {
	public static void main(String args[]) {

		BTNode root = new BTNode(5);
		root.left = new BTNode(12);
		root.right = new BTNode(6);

		BTNode l1 = new BTNode(3);
		BTNode l2 = new BTNode(4);

		BTNode r1 = new BTNode(22);
		BTNode r2 = new BTNode(23);

		root.left.left = l1;
		root.left.right = l2;

		root.right.left = r1;
		root.right.right = r2;

		root.left.right.right = new BTNode(34);

		System.out.println(firstCommonAncestor(root, root.left.left,
				root.left.right));

	}

	/**
	 * Method to return first common ancestor for the provided two nodes of a
	 * binary tree.
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return BTNode
	 */
	public static BTNode firstCommonAncestor(BTNode root, BTNode node1,
			BTNode node2) {

		BTNode leftNode = null;
		BTNode rightNode = null;

		/**
		 * handling the null condition.
		 */
		if (root == null)
			return null;

		/**
		 * If any one of the given two nodes is equal to the tree root then we
		 * know that root is the first common ancestor.
		 */
		if (root == node1 || root == node2)
			return root;
		/**
		 * If not we need to check in the left side and right side of the tree
		 * recursively.
		 */
		leftNode = firstCommonAncestor(root.left, node1, node2);
		rightNode = firstCommonAncestor(root.right, node1, node2);

		/**
		 * If both of them are not null that means only one of the node was on
		 * either sides so root has to be the first common ancestor.
		 */
		if (leftNode != null && rightNode != null)
			return root;

		/**
		 * If not we can return based on from which side we got the result.
		 */
		return (leftNode != null) ? leftNode : rightNode;
	}
}
