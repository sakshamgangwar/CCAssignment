import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Class which has test method for testing SetOfStacks which is having Array
 * list of stacks which behave like a single stack.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution03 {

	public static void main(String[] args) {
		SetOfStacks sos = new SetOfStacks(3);
		sos.push(9);
		sos.push(10);
		sos.push(11);

		sos.push(13);
		sos.push(14);
		sos.push(15);

		sos.push(17);
		sos.push(18);
		sos.push(19);

		sos.printStacks();

		sos.pop();
		sos.pop();
		sos.pop();
		sos.pop();

		sos.printStacks();
	}
}

/**
 * In this class we are maintaining a list of stacks and also their max capacity
 * and current count specifier.
 * 
 * @author Saksham Gangwar
 *
 */
class SetOfStacks {

	ArrayList<Stack<Integer>> stacksList = new ArrayList<Stack<Integer>>();

	int capacity;
	int currentCount;

	/**
	 * Method to print all the stacks in the list.
	 */
	public void printStacks() {
		for (int i = 0; i < stacksList.size(); i++) {
			System.out.println("Stack " + i + " : ");
			stacksList.get(i).printStack();
		}
	}

	/**
	 * Initializing the SetOfStacks.
	 * 
	 * @param capacity
	 */
	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		this.currentCount = 0;
	}

	/**
	 * Method to check whether the stackList is empty or not.
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (stacksList.size() > 0 && stacksList.isEmpty() != true)
			return false;
		return true;
	}

	/**
	 * Method to push value in the list of stacks which are behaving like a
	 * single stack.
	 * 
	 * @param value
	 */
	void push(int value) {
		/**
		 * We first check if if current count is zero or is at the extreme end
		 * of the single stack in the list.
		 */
		if (currentCount == 0 || currentCount == capacity) {
			/**
			 * We initialize a new stack, push the new value in it and put the
			 * new stack in the list of stacks and set the current count to 1.
			 */
			Stack<Integer> s = new Stack<>();
			s.push(value);
			stacksList.add(s);
			currentCount = 1;
		} else {
			/**
			 * If current count is not at borders of the stack then we can
			 * directly push it in the current stack and increment the current
			 * count.
			 */
			stacksList.get(stacksList.size() - 1).push(value);
			currentCount++;
		}
	}

	/**
	 * Method to remove the element from the list of stacks being considered as
	 * a single stack.
	 * 
	 * @return int
	 */
	int pop() {
		int popedElement;
		/**
		 * If current count is at the beginning of a stack then we need to shift
		 * it to previous stack's end location and pop out the current element
		 * where the current pointer was currently.
		 */
		if (currentCount == 1) {
			currentCount = capacity;
			popedElement = stacksList.get(stacksList.size() - 1).pop();
			/**
			 * removing the stack which is now totally empty.
			 */
			stacksList.remove(stacksList.size() - 1);
		} else {
			/**
			 * As current counter is not 1 then we can directly remove the
			 * element from the current stack from the list of stacks and
			 * decrement the current count.
			 */
			popedElement = stacksList.get(stacksList.size() - 1).pop();
			currentCount--;
		}
		return popedElement;
	}

}

class Node<T> {
	T value;
	Node<T> next;

	public Node(T value) {
		this.value = value;
	}
}

class Stack<T> {

	Node<T> top;
	int size;

	public T pop() {
		if (top == null)
			throw new EmptyStackException();

		T current = top.value;
		top = top.next;
		size--;
		return current;

	}

	public void printStack() {
		Node<T> n = top;

		while (n != null) {
			System.out.print(" " + n.value);
			n = n.next;
		}

		System.out.println();
	}

	public void push(T value) {
		Node<T> node = new Node<T>(value);
		node.next = top;
		top = node;
		size++;
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		return top.value;
	}

	public boolean isEmpty() {
		return top == null;
	}
}