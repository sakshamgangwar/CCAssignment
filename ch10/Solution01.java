/**
 * Class contains method to merge two sorted arrays A and B where A has enough
 * buffer to accommodate B.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution01 {

	public static void main(String[] args) {

		Integer[] a1 = new Integer[8];
		a1[0] = 34;
		a1[1] = 35;
		a1[2] = 36;
		a1[3] = 37;
		Integer[] a2 = { 2, 4, 6, 8 };

		sortedMerge(a1, a2);

		for (int i = 0; i < a1.length; i++)
			System.out.println(a1[i]);

	}

	/**
	 * Method to merge two sorted arrays.
	 * 
	 * @param a1
	 * @param a2
	 */
	public static void sortedMerge(Integer[] a1, Integer[] a2) {
		int count = 0;
		/**
		 * Moving counter to the end of content in a1.
		 */
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == null)
				break;
			count++;
		}

		System.out.println("Length of real content in a1: " + count);

		/**
		 * Pointer to point at the end content of a1.
		 */
		int i = count - 1;

		/**
		 * getting two pointers for the end of two arrays.
		 * 
		 */
		int j = a2.length - 1;

		int k = a1.length - 1;

		/**
		 * Looping and placing the largest first on the a1 array.
		 */
		while (i >= 0 && j >= 0 && k >= 0) {

			if (a1[i] < a2[j]) {
				a1[k] = a2[j];
				k--;
				j--;
			} else if (a1[i] > a2[j]) {
				a1[k] = a1[i];
				i--;
				k--;
			}

		}

		/**
		 * 
		 * Boundary condition if elements left from a2.
		 */
		while (k >= 0 && j >= 0) {
			a1[k] = a2[j];
			k--;
			j--;
		}

	}

}
