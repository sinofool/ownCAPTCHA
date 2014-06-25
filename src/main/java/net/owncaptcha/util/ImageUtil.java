package net.owncaptcha.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	
	public static final BufferedImage resize(BufferedImage source, int width, int height) {
	    BufferedImage scaled = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D graphics2D = scaled.createGraphics();
	    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    graphics2D.drawImage(source, 0, 0, width, height, null);
	    graphics2D.dispose();
	    
	    return scaled;
	}
}
