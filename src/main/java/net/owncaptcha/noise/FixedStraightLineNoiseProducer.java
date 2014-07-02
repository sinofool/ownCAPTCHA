package net.owncaptcha.noise;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FixedStraightLineNoiseProducer implements NoiseProducer{
    private Color _color;
    private int _width;
    private int _x1;
    private int _y1;
    private int _x2;
    private int _y2;
    
    public FixedStraightLineNoiseProducer(Color color, int width, int x1, int y1, int x2, int y2) {
        _color = color;
        _width = width;
        _x1 = x1;
        _y1 = y1;
        _x2 = x2;
        _y2 = y2;
    }

    @Override
    public void makeNoise(BufferedImage image)
    {
        Graphics2D graphics = image.createGraphics();
        graphics.setColor(_color);
        graphics.setStroke(new BasicStroke(_width));
        graphics.drawLine(_x1, _y1, _x2, _y2);
        graphics.dispose();
    }
}
