package net.owncaptcha.backgrounds;

import java.awt.image.BufferedImage;

public class FixedBackgroundProducer implements BackgroundProducer {

    private final BufferedImage bg;

    public FixedBackgroundProducer(final BufferedImage bg) {
	this.bg = bg;
    }

    @Override
    public BufferedImage addBackground(BufferedImage image) {
	return bg;
    }

    @Override
    public BufferedImage getBackground(int width, int height) {
	return bg;
    }

}
