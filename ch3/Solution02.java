import java.util.EmptyStackException;

/**
 * Class with implementation of a stack with has a extra method min() to fetch
 * min value of the stack in O(1) time.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {

	public static void main(String[] args) {
		StackWithMin<Integer> s = new StackWithMin<Integer>();

		s.push(12);
		s.push(13);
		s.push(3);
		s.push(5);
		s.push(32);

		s.printStack();

		System.out.println(s.min());

		s.pop();

		s.printStack();

		System.out.println(s.min());

		s.pop();

		s.printStack();

		System.out.println(s.min());

		s.pop();

		s.printStack();

		System.out.println(s.min());

	}

}

/**
 * Class for defining simple stack with operations such as push, pop, peek and
 * isEmpty also a method to print the complete stack.
 * 
 * @author Saksham Gangwar
 *
 * @param <T>
 */
class Stack02<T> {

	Node<T> top;
	/**
	 * Variable to keep track of size of stack.
	 */
	int size;

	/**
	 * Method to remove pop element from the Stack.
	 * 
	 * @return
	 */
	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		/**
		 * Getting the top of stack to be popped out.
		 */
		T current = top.value;
		top = top.next;
		/**
		 * decrementing the stack size.
		 */
		size--;
		return current;

	}

	/**
	 * Method to print the complete stack.
	 */
	public void printStack() {
		Node<T> n = top;

		while (n != null) {
			System.out.print(" " + n.value);
			n = n.next;
		}

		System.out.println();
	}

	/**
	 * Method to add new element in the stack.
	 * 
	 * @param value
	 */
	public void push(T value) {
		Node<T> node = new Node<T>(value);
		node.next = top;
		top = node;
		/**
		 * Incrementing the stack size.
		 */
		size++;
	}

	/**
	 * Method to know the top element of the stack without popping it out.
	 * 
	 * @return
	 */
	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.value;
	}

	/**
	 * Check is the stack is empty or not.
	 * 
	 * @return boolean
	 */
	public boolean isEmpty() {
		return top == null;
	}
}

/**
 * Implementing an stack which extends the stack defined above but with extra
 * method to return current min value in the stack. It is done by using a
 * separate stack for maintaining the min of the stack status.
 * 
 * @author Saksham Gangwar
 *
 * @param <T>
 */
class StackWithMin<T> extends Stack02<Integer> {

	/**
	 * Stack being used to maintain the min values.
	 */
	Stack02<Integer> ms;

	public StackWithMin() {
		ms = new Stack02<Integer>();
	}

	/**
	 * Whenever a new value is being pushed in the stack we do compare that
	 * value with the current top min value in the min stack if the inserted
	 * value is smaller than the min stack top value then we push the new value
	 * in the min stack too.
	 * 
	 * @param value
	 */
	public void push(int value) {

		super.push(value);

		/**
		 * If the value less than the min stack top value we insert it in the
		 * min stack too.
		 */
		if (value <= min())
			ms.push(value);

	}

	/**
	 * Method to pop the element from the stack, in case if the same element is
	 * the top of stack representing the current min value then the value should
	 * be popped from the min stack too.
	 */
	public Integer pop() {
		int value = super.pop();
		if (value == min())
			ms.pop();
		return value;
	}

	/**
	 * Method to return the top min value of the min stack, if it is empty then
	 * we return the Max integer value.
	 * 
	 * @return
	 */
	public Integer min() {
		if (ms.isEmpty())
			return Integer.MAX_VALUE;
		else
			return ms.peek();

	}

}
