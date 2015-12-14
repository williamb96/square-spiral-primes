import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Primes {
	public static void main(String[] args) throws Exception {
		// Read startup args
		int imageSize, backgroundColor, highlightColor;
		
		if (args.length == 4) {
			try {
				imageSize = Integer.parseInt(args[0]);
				backgroundColor = Integer.parseInt(args[1], 16);
				highlightColor = Integer.parseInt(args[2], 16);
				
				if (imageSize % 2 == 0 || imageSize < 1) {
					System.out.println("The image size must be odd and at least 1.");
					return;
				}
				
				if (backgroundColor < 0 || backgroundColor > 0xffffff) {
					System.out.println("Invalid background color. Provide a value between 0 and 0xffffff.");
					return;
				}
				
				if (highlightColor < 0 || highlightColor > 0xffffff) {
					System.out.println("Invalid highlight color. Provide a value between 0 and 0xffffff.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("Bad arguments. Make sure you're passing actual numbers!");
				return;
			}
		} else {
			System.out.println("Start the program with the arguments [image size] [background color] [highlight color] [output file]");
			System.out.println("Example: 899 ffffff 000000 primes.png");
			return;
		}
		
		// If the startup args were parsed correctly we'll begin constructing the image
		long[][] spiral = SquareSpiral.create(imageSize);
		
		BufferedImage image = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_INT_RGB);
		
		for (int y=0; y<imageSize; y++) {
			for (int x=0; x<imageSize; x++) {
				image.setRGB(x, y, isPrime(spiral[y][x]) ? highlightColor : backgroundColor);
			}
		}
		
		// And finally we'll write the image to disk
		try {
			ImageIO.write(image, "png", new File(args[3]));
		} catch (Exception e) {
			System.out.println("Error saving image: " + e.getClass().getName());
		}
	}
	
	private static boolean isPrime(long num) {
		if (num == 2) {
			return true;
		}
		
		if (num % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i * i <= num; i += 2) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}