import java.util.ArrayList;

/**
 * Given a binary tree, this class is having a method to create a linked list of
 * all the nodes at each depth.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		BSTree bst = new BSTree();

		bst.add(5);
		bst.add(4);
		bst.add(6);
		bst.add(3);
		bst.add(8);
		bst.add(1);
		bst.add(12);
		bst.add(23);

		System.out.println("Binary Tree In Order: ");
		bst.print(bst.root);

		System.out.println();

		ArrayList<LinkedList<BSTNode>> result = convertBSTList(bst.root);

		for (LinkedList<BSTNode> ll : result) {
			ll.printList();
		}

	}

	/**
	 * Method to create array of linked lists representing each level in a
	 * binary tree.
	 * 
	 * @param root
	 * @return ArrayList<LinkedList<BSTNode>>
	 */
	public static ArrayList<LinkedList<BSTNode>> convertBSTList(BSTNode root) {

		/**
		 * Initializing a linked list.
		 */
		LinkedList<BSTNode> ll = new LinkedList<BSTNode>();

		/**
		 * Initializing arraylist of linked lists of nodes at each level.
		 */
		ArrayList<LinkedList<BSTNode>> llArray = new ArrayList<LinkedList<BSTNode>>();

		if (root != null)
			ll.add(root);

		/**
		 * Until size of considered part of tree is greater than zero we have to
		 * execute this loop.
		 */
		while (ll.getSize() > 0) {
			/**
			 * adding the linked list to the array.
			 */
			llArray.add(ll);

			LinkedList<BSTNode> currentLevel = ll;

			ll = new LinkedList<BSTNode>();

			LLNode<BSTNode> n = currentLevel.head;

			/**
			 * For every level adding all the nodes on that level to the linked
			 * list. And these nodes will act as parents for the next level
			 * which will help us to create linked list for next level to be
			 * added in the array being formed.
			 */
			while (n != null) {
				if (n.value.getLeft() != null)
					ll.add(n.value.getLeft());

				if (n.value.getRight() != null)
					ll.add(n.value.getRight());

				n = n.next;
			}
		}

		return llArray;

	}

}
