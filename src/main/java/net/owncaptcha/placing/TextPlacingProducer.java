package net.owncaptcha.placing;

import java.awt.image.BufferedImage;

public class TextPlacingProducer implements PlacingProducer {

    private final String _text;
    private final int _size;
    
    private final int _x;
    private final int _y;
    
    public TextPlacingProducer(final String text, int size, int x, int y) {
	this._text = text;
	this._size = size;
	this._x = x;
	this._y = y;
    }
    
    @Override
    public int getX() {
	return _x;
    }

    @Override
    public int getY() {
	return _y;
    }

    @Override
    public BufferedImage getImage() {
	//TODO
	return null;
    }

}
