/**
 * This class contains method to print binary representation of any real number
 * between 0 and 1.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution02 {
	public static void main(String[] args) {
		System.out.println(binaryToString(0.625));
	}

	/**
	 * Method returns binary representation of the real number.
	 * 
	 * @param input
	 * @return
	 */
	public static String binaryToString(double input) {

		StringBuffer sb = new StringBuffer();

		sb.append(".");

		while (input > 0) {
			/**
			 * Boundary limit of 32 characters.
			 */
			if (sb.length() >= 32)
				return "ERROR";

			/**
			 * For every loop we multiply input by 2 and check if it's greater
			 * than 1, if it is then we do shifting and append 1 in the output
			 * otherwise zero gets appended.
			 */

			double temp = input * 2;

			if (temp >= 1) {
				sb.append(1);
				input = temp - 1;
			} else {
				sb.append(0);
				input = temp;
			}
		}

		return sb.toString();
	}
}
