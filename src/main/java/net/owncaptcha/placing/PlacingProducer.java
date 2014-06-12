package net.owncaptcha.placing;

import java.awt.image.BufferedImage;

public interface PlacingProducer {

    public int getX();

    public int getY();

    public BufferedImage getImage();
}
