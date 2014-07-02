package net.owncaptcha.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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
	    BufferedImage scaled = new BufferedImage(width, height, source.getType());
	    Graphics2D graphics2D = scaled.createGraphics();
	    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    graphics2D.drawImage(source, 0, 0, width, height, null);
	    graphics2D.dispose();
	    
	    return scaled;
	}
	
	public static final BufferedImage load(String filename) throws IOException {
	    return ImageIO.read(new File(filename));
	}
	
	public static final BufferedImage layer(BufferedImage source, BufferedImage destination, int x, int y) {
	    Graphics2D graphics = destination.createGraphics();
	    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	    graphics.drawImage(source, null, null);
	    graphics.dispose();
	    
	    return destination;
	}
}
