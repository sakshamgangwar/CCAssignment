/**
 * Given a sorted array, this class is having a method to create a binary search
 * tree with minimum height.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {

	public static void main(String[] args) {
		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		BSTNode n = createMinBST(list, 0, list.length - 1);
		print(n);

	}

	/**
	 * Method to print BST in - order.
	 * 
	 * @param node
	 */
	private static void print(BSTNode node) {
		if (node != null) {
			print(node.getLeft());
			System.out.print(node.getValue() + " ");
			print(node.getRight());
		}
	}

	/**
	 * 
	 * Method to create BST of minimum height using the sorted array being
	 * provided as input.
	 * 
	 * @param list
	 * @param start
	 * @param end
	 * @return
	 */
	public static BSTNode createMinBST(int[] list, int start, int end) {
		/**
		 * Handling the end condition.
		 */
		if (end < start)
			return null;
		/**
		 * Firstly setting the node and then it's left and right children based
		 * on the sorted array. As by dividing the array at it's mid every time
		 * we can get perfectly balanced BST which will have least possible
		 * height.
		 */
		BSTNode node = new BSTNode(list[(start + end) / 2]);
		/**
		 * Less than mid.
		 */
		node.setLeft(createMinBST(list, start, ((start + end) / 2) - 1));
		/**
		 * More than mid.
		 */
		node.setRight(createMinBST(list, ((start + end) / 2) + 1, end));

		return node;

	}

}
