import java.util.EmptyStackException;

/**
 * This class is having methods to implement single array to implement three
 * stacks.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {

	public static void main(String[] args) {
		Solution01 tio = new Solution01(3, 5);

		tio.push(1, 0);

		tio.push(8, 1);

		tio.push(5, 2);
		tio.push(7, 2);
		tio.push(9, 2);

		tio.pop(0);

		tio.printStack();
	}

	/**
	 * Variable to store number of stacks to be made in one array.
	 */
	int noOfStacks;

	/**
	 * Variable to store capacity for each stack in an array.
	 */
	int eachStackCapacity;

	int[] stack;
	int[] currentLength;

	public Solution01(int noOfStacks, int eachStackCapacity) {
		/**
		 * Initializing array and the length array to keep track of current
		 * number of elements in the stacks.
		 */
		this.noOfStacks = noOfStacks;
		this.eachStackCapacity = eachStackCapacity;

		stack = new int[noOfStacks * eachStackCapacity];
		currentLength = new int[noOfStacks];

	}

	/**
	 * Method to push a value in a specified stack (by stack number)
	 * 
	 * @param value
	 * @param stackNumber
	 * @return boolean
	 */
	public boolean push(int value, int stackNumber) {

		/**
		 * In case if the stack specified is full we need to return false.
		 */
		if (isFull(stackNumber))
			return false;

		/**
		 * Increment the current size for the stack under consideration.
		 */
		currentLength[stackNumber]++;

		/**
		 * Setting the new number in the stack.
		 */
		stack[stackNumber * eachStackCapacity + currentLength[stackNumber] - 1] = value;

		/**
		 * Returning true for success case.
		 */
		return true;
	}

	/**
	 * Method to pop out element from the specified stack.
	 * 
	 * @param stackNumber
	 * @return int
	 */
	public int pop(int stackNumber) {

		/**
		 * In case if the specified stack is empty we are throwing empty stack
		 * exception.
		 */
		if (isEmpty(stackNumber))
			throw new EmptyStackException();

		/**
		 * Getting the top element to be removed from the specified stack.
		 */
		int top = stack[stackNumber * eachStackCapacity
				+ currentLength[stackNumber] - 1];
		/**
		 * Setting it to zero.
		 */
		stack[stackNumber * eachStackCapacity + currentLength[stackNumber] - 1] = 0;

		/**
		 * Decrementing the current length of the specified stack.
		 */
		currentLength[stackNumber]--;

		return top;
	}

	/**
	 * Method to check whether the stack is empty or not.
	 * 
	 * @param stackNumber
	 * @return boolean
	 */
	public boolean isEmpty(int stackNumber) {
		if (currentLength[stackNumber] == 0)
			return true;
		return false;
	}

	/**
	 * Method to check whether the stack in full or not.
	 * 
	 * @param stackNumber
	 * @return boolean
	 */
	public boolean isFull(int stackNumber) {
		if (currentLength[stackNumber] == eachStackCapacity)
			return true;
		return false;
	}

	/**
	 * Method to print complete array.
	 */
	public void printStack() {
		for (int i = 0; i < stack.length; i++) {
			System.out.print(" " + stack[i]);
		}
	}

}
