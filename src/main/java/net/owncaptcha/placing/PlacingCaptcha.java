package net.owncaptcha.placing;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import net.owncaptcha.CaptchaIF;
import net.owncaptcha.backgrounds.BackgroundProducer;

public class PlacingCaptcha implements CaptchaIF {

    public static class Builder {

	private BufferedImage _bg;

	private final int _width;
	private final int _height;

	private List<BufferedImage> _pendingImage = new ArrayList<BufferedImage>();
	private List<Integer> _pendingX = new ArrayList<Integer>();
	private List<Integer> _pendingY = new ArrayList<Integer>();

	// private List<Integer> _pendingRotate = new ArrayList<Integer>();

	private String _answer;

	public Builder(int width, int height) {
	    this._width = width;
	    this._height = height;
	}

	public Builder addBackground(final BackgroundProducer bg) {
	    _bg = bg.getBackground(_width, _height);
	    return this;
	}

	// This can be both text or image
	public Builder addPlacing(final PlacingProducer image) {
	    _pendingImage.add(image.getImage());
	    _pendingX.add(image.getX());
	    _pendingY.add(image.getY());
	    return this;
	}

	public Builder setAnswer(final String answer) {
	    _answer = answer;
	    return this;
	}

	public PlacingCaptcha build() {
	    Graphics2D g = _bg.createGraphics();
	    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
		    1.0f));
	    for (int x = 0; x < _pendingImage.size(); ++x) {
		g.drawImage(_pendingImage.get(x), _pendingX.get(x),
			_pendingY.get(x), null);
	    }
	    return new PlacingCaptcha(this);
	}
    }

    private BufferedImage _img;
    private String _answer;

    public PlacingCaptcha(Builder builder) {
	this._img = builder._bg;
	this._answer = builder._answer;
    }

    @Override
    public String getAnswer() {
	return _answer;
    }

    @Override
    public BufferedImage getImage() {
	return _img;
    }

}
