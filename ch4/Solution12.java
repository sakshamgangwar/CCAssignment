/**
 * ALgorithm to find number of paths in a binary tree which sum to a given
 * value. Any path need not start or end at root or leaf node.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution12 {
	public static void main(String[] args) {

		BTNode root = new BTNode(10);
		root.left = new BTNode(5);
		root.right = new BTNode(-3);

		BTNode l1 = new BTNode(3);
		BTNode l2 = new BTNode(3);

		BTNode r2 = new BTNode(11);

		root.left.left = l1;
		root.left.right = l2;

		root.right.right = r2;

		root.left.left.left = new BTNode(3);
		root.left.left.right = new BTNode(-2);

		root.left.right.right = new BTNode(1);

		System.out.println(noOfPathWithSum(8, root));

	}

	/**
	 * Method to return number of paths which can result in same sum value in a
	 * Binary tree.
	 * 
	 * @param sum
	 * @param node
	 * @return int
	 */
	public static int noOfPathWithSum(int sum, BTNode node) {
		/**
		 * Handling null case.
		 */
		if (node == null)
			return 0;
		/**
		 * Trying to recursively fetch the sum from every node possible in the
		 * tree for the desired sum.
		 */
		return (getPathsFromNode(node, sum, 0)
				+ noOfPathWithSum(sum, node.left) + noOfPathWithSum(sum,
					node.right));

	}

	/**
	 * Method which is recursively used to continuously add and figure out
	 * whether the path being taken is having the total sum desired or not.
	 * 
	 * @param node
	 * @param totalSum
	 * @param currentSum
	 * @return int
	 */
	public static int getPathsFromNode(BTNode node, int totalSum, int currentSum) {

		int paths = 0;

		if (node != null) {

			currentSum += node.value;

			/**
			 * If we get total sum as current sum then we can increment the path
			 * variable.
			 */
			if (currentSum == totalSum)
				paths++;

			paths += getPathsFromNode(node.left, totalSum, currentSum);
			paths += getPathsFromNode(node.right, totalSum, currentSum);
		}

		return paths;

	}
}
