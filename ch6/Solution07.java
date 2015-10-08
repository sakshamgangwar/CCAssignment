import java.util.Random;

/**
 * This class contains method to run simulation for calculating ratio of girls
 * to total population for the overall result.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution07 {

	public static void main(String[] args) {
		System.out.println(runSimulation(10000));
	}

	/**
	 * In this simulation method we are making use of a random method which
	 * generates new borns with random gender (probability of any gender is 0.5)
	 * It returns an integer array which holds count of boys and girls born in a
	 * family. Once we have the complete data we find out the ratio and return
	 * the result.
	 * 
	 * @param count
	 * @return ratio of girls vs total new borns
	 */
	public static double runSimulation(int count) {
		int girlCount = 0;
		int boyCount = 0;

		/**
		 * Running the simulation for count number of times
		 */
		for (int i = 0; i < count; i++) {
			/**
			 * Getting count of new borns for any family.
			 */
			int[] counts = getRandomBirthCount();
			girlCount += counts[1]; // incrementing the girl count
			boyCount += counts[0]; // incrementing the boy count
		}

		/**
		 * Returning the ratio
		 */
		return (double) girlCount / (girlCount + boyCount);
	}

	/**
	 * Method to replicate question scenario where a family keeps on giving
	 * birth until they get a girl child.
	 * 
	 * @return int[]
	 */
	public static int[] getRandomBirthCount() {
		Random r = new Random();
		int[] counts = new int[2];
		int countBoy = 0;
		int countGirl = 0;

		/**
		 * Till the time we get random variable as true that means a boy is
		 * being born so we need to remain in while loop and keep incrementing
		 * boy count
		 */
		while (r.nextBoolean())
			countBoy++;
		countGirl++;

		counts[0] = countBoy;
		counts[1] = countGirl;

		return counts;
	}

}
