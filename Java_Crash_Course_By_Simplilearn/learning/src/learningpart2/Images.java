package learningpart2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/*
 * Two classes in java to deal with images
 * -java.awt.Image -> superclass that represents graphical images as rectangular arrays of pixels
 * -java.awt.Image.BufferedImage -> extends the image class, allows the app to operate with imageData
 * 
 */

public class Images {
	public static void main(String[] args) {
		int width = 963;
		int height = 640;
		
		BufferedImage image = null;
		image = readFromFile(width, height, image);
		writeToFile(image);
	}
	
	private static BufferedImage readFromFile(int width, int height, BufferedImage image) {
		try {
			File sampleFile = new File("F:\\soft\\Nat_Geo_Wallpapers\\0811wallpaper-1_1280.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			
			//Reading input file
			image = ImageIO.read(sampleFile);
			
			System.out.println("Reading complete. " + image);
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("EXCEPTION CAUGHT : " + e);
		}
		return image;
	}
	
	private static void writeToFile(BufferedImage image) {
		try {
			File output = new File("F:\\java\\Java_Crash_Course_By_Simplilearn\\learning\\files\\out.jpg");
			ImageIO.write(image, "jpg", output);
			System.out.println("Writing complete.");
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Exception in Writing Image : " + e);
		}
	}
}
