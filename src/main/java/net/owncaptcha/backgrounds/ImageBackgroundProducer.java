package net.owncaptcha.backgrounds;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.owncaptcha.util.ImageUtil;

public class ImageBackgroundProducer implements BackgroundProducer {
    private BufferedImage image;
    
    public ImageBackgroundProducer(final String filename) throws IOException {
        this.image = ImageIO.read(new File(filename));
    }
    
    public ImageBackgroundProducer(BufferedImage image) {
        this.image = image;
    }
    
    public ImageBackgroundProducer(BufferedImage image, int width, int height) {
        this.image = ImageUtil.resize(image, width, height);
    }

    @Override
    public BufferedImage addBackground(BufferedImage image) {
        return image;
    }

    @Override
    public BufferedImage getBackground(int width, int height) {
        if (image.getWidth() != width || image.getHeight() != height) {
            return ImageUtil.resize(image, width, height);
        } else {
            return image;
        }
    }
}
