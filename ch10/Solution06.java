import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Class implementing external sort for handling sorting of large size file.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution06 {

	public static void externalSort(String fileName, int sizeOfFile, int sizeOfChunk) {

		int[] temp = new int[sizeOfChunk];

		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int noOfChunks = (int) (sizeOfFile / sizeOfChunk);

			for (int i = 0; i < noOfChunks; i++) {
				for (int j = 0; j < sizeOfChunk; j++) {

					String content = br.readLine();

					temp[j] = Integer.parseInt(content);

				}
				Arrays.sort(temp);

				FileWriter fw = new FileWriter(Integer.toString(i) + ".txt");
				PrintWriter pw = new PrintWriter(fw);
				for (int k = 0; k < sizeOfChunk; k++)
					pw.println(temp[k]);

				pw.close();
				fw.close();
			}

			br.close();
			fr.close();

			int[] topNums = new int[noOfChunks];
			BufferedReader[] brs = new BufferedReader[noOfChunks];

			for (int i = 0; i < noOfChunks; i++) {
				brs[i] = new BufferedReader(new FileReader(Integer.toString(i) + ".txt"));
				String t = brs[i].readLine();
				if (t != null)
					topNums[i] = Integer.parseInt(t);
				else
					topNums[i] = Integer.MAX_VALUE;
			}

			FileWriter fw = new FileWriter("sorted.txt");
			PrintWriter pw = new PrintWriter(fw);

			for (int i = 0; i < sizeOfFile; i++) {
				int min = topNums[0];
				int minFile = 0;

				for (int j = 0; j < noOfChunks; j++) {
					if (min > topNums[j]) {
						min = topNums[j];
						minFile = j;
					}
				}

				pw.println(min);
				String t = brs[minFile].readLine();
				if (t != null)
					topNums[minFile] = Integer.parseInt(t);
				else
					topNums[minFile] = Integer.MAX_VALUE;

			}
			for (int i = 0; i < noOfChunks; i++)
				brs[i].close();

			pw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		externalSort("dat.txt", 2000, 10);
	}

}
