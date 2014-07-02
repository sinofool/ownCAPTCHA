package net.owncaptcha.image.producer;

import java.awt.image.BufferedImage;

public class DefaultImageProducer implements ImageProducer {
    private BufferedImage _image;
    
    public DefaultImageProducer() {
        _image = new BufferedImage(0, 0, BufferedImage.TRANSLUCENT);
    }
    
    public DefaultImageProducer(BufferedImage image) {
        _image = image;
    }
    
    @Override
    public BufferedImage getImage() {
        return _image;
    }
}
