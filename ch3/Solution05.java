/**
 * Class which is having method to test a method which basically sorts the stack
 * using a temporary stack.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution05 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(12);
		stack.push(34);
		stack.push(3);
		stack.push(100);
		stack.push(9);
		stack.push(32);

		stack.printStack();

		sortStack(stack).printStack();

	}

	/**
	 * Method to sort the Stack using as additional stack.
	 * 
	 * @param s
	 * @return Stack<Integer>
	 */
	public static Stack<Integer> sortStack(Stack<Integer> s) {
		/**
		 * Stack to maintain the new sorted values.
		 */
		Stack<Integer> sorted = new Stack<Integer>();

		/**
		 * Loop over all the values of the passed stack.
		 */
		while (!s.isEmpty()) {
			/**
			 * Without popping from the passed stack we need to check whether
			 * sorted has any value in it or not, if not we can directly push
			 * the value in the sorted stack.
			 */
			Integer current = s.peek();
			if (sorted.isEmpty()) {
				sorted.push(s.pop());
			} else {
				/**
				 * If the sorted stack is not empty we can check with the peeked
				 * value if the passed stack's top value is less than sorted
				 * stack top's value then we need to push this new value in the
				 * sorted stack and pop it from the currently passed stack.
				 */
				if (current < sorted.peek()) {
					sorted.push(s.pop());
				} else {
					/**
					 * Otherwise we need to keep popping from the sorted stack
					 * (and keep pushing to the passed stack) until we get a
					 * number which is more than the current value in the passed
					 * stack or sorted gets empty. Once that happens we need to
					 * push the value in the sorted stack.
					 */
					current = s.pop();
					while (!sorted.isEmpty() && sorted.peek() < current) {
						s.push(sorted.pop());
					}

					sorted.push(current);
				}
			}
		}

		return sorted;
	}

}
