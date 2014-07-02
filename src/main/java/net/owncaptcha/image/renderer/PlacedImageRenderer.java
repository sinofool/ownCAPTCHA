package net.owncaptcha.image.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class PlacedImageRenderer implements ImageRenderer{
    private int _x;
    private int _y;

    public PlacedImageRenderer(int x, int y) {
        _x = x;
        _y = y;
    }
    
    @Override
    public BufferedImage render(BufferedImage source, BufferedImage destination)
    {
        Graphics graphics = destination.getGraphics();
        graphics.drawImage(source, _x, _y, null);
        graphics.dispose();

        return destination;
    }
}
