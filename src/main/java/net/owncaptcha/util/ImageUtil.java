package net.owncaptcha.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

public class ImageUtil {
	public static final void applyFilter(BufferedImage img, BufferedImageOp filter) {
		// FilteredImageSource src = new FilteredImageSource(img.getSource(), filter);
		// Image fImg = Toolkit.getDefaultToolkit().createImage(src);
		// Graphics2D g = img.createGraphics();
		// g.drawImage(fImg, 0, 0, null, null);
		// g.dispose();
		
		BufferedImage fImg = filter.filter(img, null);
		Graphics2D g = img.createGraphics();
		g.drawImage(fImg, 0, 0, null, null);
		g.dispose();
	}
}
