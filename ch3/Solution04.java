/**
 * This class contains method to test a queue being implemented by two stacks.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution04 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();

		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);

		System.out.println(q.remove());

		System.out.println(q.remove());

		System.out.println(q.remove());

		System.out.println(q.remove());

	}

}

/**
 * A queue which is being implemented by two stacks.
 * 
 * @author Saksham Gangwar
 *
 * @param <T>
 */
class Queue<T> {
	/**
	 * Stack which is used to insert elements.
	 */
	private Stack<T> forAdding = new Stack<T>();
	/**
	 * Stack which is used to delete elements.
	 */
	private Stack<T> forRemoving = new Stack<T>();

	/**
	 * Add operation where we insert or push in the addition stack.
	 * 
	 * @param value
	 */
	public void add(T value) {
		forAdding.push(value);
	}

	/**
	 * In order to remove from the queue we need to access the last stack
	 * element, in order to access it we make use of another stack, where we pop
	 * out all the elements from the addition stack so that we get the reverse
	 * order of insertion in the new deletion stack and when we pop from this
	 * stack it appears as if we are deleting from the queue.
	 * 
	 * @return
	 */
	public T remove() {
		/**
		 * If the removal stack is empty will push all the elements from the
		 * addition queue.
		 */
		if (forRemoving.isEmpty()) {
			while (!forAdding.isEmpty()) {
				forRemoving.push(forAdding.pop());
			}
		}
		return forRemoving.pop();
	}

}
