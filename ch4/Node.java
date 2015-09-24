import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a Node for any graph which can have multiple nodes
 * attached to it as it's neighbors.
 * 
 * @author Saksham Gangwar
 *
 */
public class Node {
	int state;
	List<Node> neighbors = new ArrayList<Node>();

	public Node(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}

}
