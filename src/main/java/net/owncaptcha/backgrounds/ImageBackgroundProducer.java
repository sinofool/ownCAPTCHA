package net.owncaptcha.backgrounds;

import java.awt.image.BufferedImage;
import net.owncaptcha.util.ImageUtil;

public class ImageBackgroundProducer implements BackgroundProducer {
    private BufferedImage _image;
    
    public ImageBackgroundProducer(BufferedImage image) {
        _image = image;
    }

    @Override
    public BufferedImage addBackground(BufferedImage image) {
        return _image;
    }

    @Override
    public BufferedImage getBackground(int width, int height) {
        if (_image.getWidth() != width || _image.getHeight() != height) {
            return ImageUtil.resize(_image, width, height);
        } else {
            return _image;
        }
    }
}
