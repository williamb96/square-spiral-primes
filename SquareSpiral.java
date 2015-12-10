public class SquareSpiral {
	public static long[][] create(int size) {
		if (size % 2 == 0 || size < 1) {
			throw new IllegalArgumentException("Size must be odd and at least 1");
		}
		
		long[][] spiral = new long[size][size];
		int halfSize = size/2;
		SquareSpiralCursor cursor = new SquareSpiralCursor();
		
		for (int i=0; i<size*size; i++) {
			spiral[cursor.getY()+halfSize][cursor.getX()+halfSize] = i;
			cursor.next();
		}
		
		return spiral;
	}
}