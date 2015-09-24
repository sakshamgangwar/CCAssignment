import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed graph this class contains a method which checks whether
 * there is any route between two given nodes.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {

	public static void main(String[] args) {

		Node p1 = new Node(0);
		Node p2 = new Node(0);
		Node p3 = new Node(0);
		Node p4 = new Node(0);
		Node p5 = new Node(0);
		Node p6 = new Node(0);
		Node p7 = new Node(0);
		Node p8 = new Node(0);

		List<Node> l = new ArrayList<Node>();
		l.add(p2);
		l.add(p3);

		p1.setNeighbors(l);

		l = new ArrayList<Node>();

		l.add(p4);
		l.add(p5);

		p2.setNeighbors(l);

		l = new ArrayList<Node>();

		l.add(p4);
		l.add(p6);

		p3.setNeighbors(l);

		l = new ArrayList<Node>();

		l.add(p7);

		p5.setNeighbors(l);
		p6.setNeighbors(l);

		l = new ArrayList<Node>();

		l.add(p8);

		p7.setNeighbors(l);

		System.out.println(checkPathExist(p4, p8));

	}

	/**
	 * Method to check if there is any route between provided two nodes in a
	 * directed graph.
	 * 
	 * @param n1
	 * @param n2
	 * @return boolean
	 */
	public static boolean checkPathExist(Node n1, Node n2) {
		/**
		 * Checking for the state of the node if its not yet visited (0), if not
		 * then we need to change it's state to visited (1).
		 */
		if (n1.getState() == 0) {
			n1.setState(1);
			/**
			 * We need to loop over all its neighbors and recursively check if
			 * there is any path till the next node or not. If in later
			 * recursive calls if we find any node equal to the neighbor node it
			 * means that we have encountered a route and we can return true.
			 */
			for (Node node : n1.getNeighbors()) {
				if (node == n2)
					return true;
				if (checkPathExist(node, n2))
					return true;
			}
		}
		return false;
	}

}
