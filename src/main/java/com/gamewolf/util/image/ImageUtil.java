package com.gamewolf.util.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageUtil {
	
	
	public void resizeImage(InputStream is, OutputStream os, int width,int height, String format) throws IOException{
		  BufferedImage prevImage = ImageIO.read(is);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
	      Graphics graphics = image.createGraphics();
	      graphics.drawImage(prevImage, 0, 0, width, height, null);
	      ImageIO.write(image, format, os);
	      os.flush();
	      is.close();
	      os.close();

	}

}
