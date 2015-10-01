import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Given an input file with 4 billion non-negative integers, this class contains
 * a method which returns an integer which is missing in it.
 * 
 * Assumption: We have 1GB memory available for this algorithm.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution07 {

	public static void main(String[] args) {

		try {
			System.out.println(getMissingInt("abc.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Maintaining Integer array where every bit represents an integer and for
	 * every occurrence of any number we can set that bit to one. Once we done
	 * traversing the complete list we can loop over all the bits in the
	 * Occurrence array and get the number for which bit was not set.
	 * 
	 * @param fileName
	 * @return Integer
	 * @throws IOException
	 */
	public static Integer getMissingInt(String fileName) throws IOException {

		/**
		 * Number of possible integers
		 */
		long ints = ((long) Integer.MAX_VALUE) + 1;

		/**
		 * Representing all the possible integers using integer array bits.
		 */
		int[] occurance = new int[(int) (ints / 32)];

		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		while (str != null) {
			int num = Integer.parseInt(str);
			/**
			 * Setting the occurrence bit representing num
			 */
			occurance[num / 32] = occurance[num / 32] | 1 << (num % 32);
			str = br.readLine();
		}

		/**
		 * looping over occurrence to find out which integer was missing.
		 */
		for (int i = 0; i <= occurance.length; i++) {
			for (int j = 0; j < 32; j++) {
				if ((occurance[i] & (1 << j)) == 0)
					return i * 32 + j;
			}
		}

		return null;

	}

}
