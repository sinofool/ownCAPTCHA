package net.owncaptcha.image.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class DefaultImageRenderer implements ImageRenderer{

    @Override
    public BufferedImage render(BufferedImage source, BufferedImage destination)
    {
        Graphics graphics = destination.getGraphics();
        graphics.drawImage(source, 0, 0, null);
        graphics.dispose();

        return destination;
    }

}
