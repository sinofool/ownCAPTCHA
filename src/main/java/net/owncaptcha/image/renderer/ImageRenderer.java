package net.owncaptcha.image.renderer;

import java.awt.image.BufferedImage;

public interface ImageRenderer
{
    public BufferedImage render(BufferedImage source, BufferedImage destination);
}
