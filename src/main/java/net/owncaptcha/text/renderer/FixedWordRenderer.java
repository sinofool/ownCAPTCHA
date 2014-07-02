package net.owncaptcha.text.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class FixedWordRenderer implements WordRenderer {
    private Color _color;
    private Font _font;
    private int _x;
    private int _y;

    public FixedWordRenderer(int x, int y) {
        _x = x;
        _y = y;
    }
    
    public FixedWordRenderer(Color color, int x, int y) {
        _color = color;
        _x = x;
        _y = y;
    }

    public FixedWordRenderer(Color color, Font font, int x, int y) {
        _color = color;
        _font = font;
        _x = x;
        _y = y;
    }

    @Override
    public void render(String word, BufferedImage image) {
        Graphics2D graphics = image.createGraphics();

        if (_color != null) {
            graphics.setColor(_color);
        }

        if (_font != null) {
            graphics.setFont(_font);
        }

        graphics.drawString(word, _x, _y);
    }
}
