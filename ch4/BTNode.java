/**
 * Class used to represent a node for a Binary Tree.
 * 
 * @author Saksham Gangwar
 *
 */
public class BTNode {
	BTNode left;
	BTNode right;
    int value;
     
    public BTNode(int value) {
        left = null;
        right = null;
        this.value = value;
    }

	@Override
	public String toString() {
		return "BTNode [value=" + value + "]";
	}
    
    
}
