/**
 * This class contains method to draw line on a monochrome screen represented by
 * a single array of bytes.
 * 
 * @author Saksham Gangwar
 *
 */
public class Solution08 {

	public static void main(String[] args) {

		int width = 8;
		int height = 4;
		byte[] screen = new byte[width * height / 8];
		for (int i = 0; i < width * height / 8; i++) {
			screen[i] = 0;
		}

		drawLine(screen, width, 2, 5, 2);

		printScreen(screen, width);

	}

	/**
	 * Method to print the screen content.
	 * 
	 * @param screen
	 * @param width
	 */
	public static void printScreen(byte[] screen, int width) {
		int height = screen.length * 8 / width;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j = j + 8) {
				byte b = screen[(width * i + j) / 8];
				System.out.print(Integer.toString(b, 2));
				System.out.print(" ");
			}

			System.out.println();
		}

	}

	/**
	 * Method to draw horizontal line on the screen by setting the specified
	 * bits.
	 * 
	 * @param screen
	 * @param width
	 * @param x1
	 * @param x2
	 * @param y
	 */
	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {

		int startOffset = x1 % 8;
		int startByte = x1 / 8;

		if (startOffset != 0) {
			startByte++;
		}

		int endOffset = x2 % 8;
		int endByte = x2 / 8;
		if (endOffset != 7) {
			endByte--;
		}

		/**
		 * Setting complete bytes
		 */
		for (int i = startByte; i <= endByte; i++) {
			screen[(width / 8) * y + i] = (byte) 0xFF;
		}

		byte startMask = (byte) (0xFF >> startOffset);
		byte endMask = (byte) ~(0xFF >> (endOffset + 1));

		if ((x1 / 8) == (x2 / 8)) {
			byte mask = (byte) (startMask & endMask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		} else {
			if (startOffset != 0) {
				int byte_number = (width / 8) * y + startByte - 1;
				screen[byte_number] |= startMask;
			}
			if (endOffset != 7) {
				int byte_number = (width / 8) * y + endByte + 1;
				screen[byte_number] |= endMask;
			}
		}
	}
}
