/**
 * This class contains method to solve egg drop problem in minimum number of
 * drops.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {

	/**
	 * Initializing a variable to hold total number of drops done in an
	 * experiment.
	 */
	static int dropCount = 0;
	/**
	 * Defining the breaking point for the experiment.
	 */
	static int breakingPoint = 25;

	public static void main(String[] args) {
		System.out.println(eggDropProblem(100, 10));
		System.out.println("Total Drops: " + dropCount);

	}

	/**
	 * This method returns the breaking point which is found using two eggs
	 * dropping experiment.
	 * 
	 * @param totalFloors
	 * @param interval
	 * @return int
	 */
	public static int eggDropProblem(int totalFloors, int interval) {
		/**
		 * Location of egg 1 (i.e. floor number).
		 */
		int e1 = 0;
		/**
		 * Used to store prev location of egg 1.
		 */
		int prevFloor = 0;
		/**
		 * Dropping egg 1 until it breaks or until we reach top of the building.
		 * For each step we are decrementing the interval factor.
		 */
		while (e1 < breakingPoint && e1 <= totalFloors) {
			dropCount++; // overall drop count incremented
			prevFloor = e1;
			/**
			 * Decrementing the interval factor, reducing potential steps for
			 * egg2.
			 */
			interval--;
			e1 += interval;
		}

		/**
		 * Drop count incremented for the case when egg 1 broke.
		 */
		dropCount++;

		/**
		 * Location of egg 2 (i.e. floor number).
		 */
		int e2 = prevFloor + 1;

		/**
		 * Dropping egg 2 until we find out the breaking floor or we reach top
		 * of the building.
		 */
		while (e2 < e1 && e2 <= totalFloors && e2 < breakingPoint) {
			dropCount++; // overall drop count incremented.
			e2++;
		}

		/**
		 * Drop count incremented for the case when egg 2 broke.
		 */
		dropCount++;
		
		return (e2 > totalFloors) ? -1 : e2;
	}

}
