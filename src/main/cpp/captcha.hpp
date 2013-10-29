#include <Magick++.h>
#include <string>
#include <stdio.h>

struct rgb {
	rgb(uint16_t red, uint16_t green, uint16_t blue) :
			r(red), g(green), b(blue) {
	}
	uint16_t r;
	uint16_t g;
	uint16_t b;
};

using Magick::Image;
using Magick::Geometry;
using Magick::Color;
using Magick::Quantum;
using Magick::Drawable;
using Magick::DrawableText;
using Magick::DrawableGravity;
using Magick::CenterGravity;
using Magick::DrawableFont;
using Magick::DrawablePointSize;
using Magick::DrawableRotation;
using Magick::DrawableStrokeColor;
using Magick::DrawableFillColor;
using Magick::NormalStyle;
using Magick::NormalStretch;

class background {
public:
	background(int width, int height, rgb rgb) :
			_width(width), _height(height), _rgb(rgb) {
	}

	template<typename T> background* merge(T old) {
		this->_img = new Image(Geometry(_width, _height),
				Color(_rgb.r, _rgb.g, _rgb.b, 0));
		return this;
	}

	Magick::Image* img() {
		return _img;
	}
private:
	Image* _img;
	int _width;
	int _height;
	rgb _rgb;
};

class text {
public:
	text(const std::string& text, const std::string& font, double size,
			double angle, int x, int y, rgb rgb) :
			_text(text), _font(font), _size(size), _angle(angle), _x(x), _y(y), _rgb(
					rgb) {
	}

	template<typename T> text* merge(T old) {
		this->_img = old->img();
		std::list<Drawable> txt;
		txt.push_back(DrawableGravity(CenterGravity));
		txt.push_back(DrawableRotation(_angle*(-180.0/3.14)));
		txt.push_back(DrawableFont(_font));
		txt.push_back(DrawablePointSize(_size));
		txt.push_back(DrawableStrokeColor(Color(_rgb.r, _rgb.g, _rgb.b)));
		txt.push_back(DrawableFillColor(Color(_rgb.r, _rgb.g, _rgb.b, 0)));
		txt.push_back(DrawableText(_x, _y, _text));
		_img->draw(txt);
		return this;
	}

	Image* img() {
		return _img;
	}
private:
	std::string _text;
	std::string _font;
	double _size;
	double _angle;
	int _x;
	int _y;
	rgb _rgb;
	Image* _img;
};

class distorting {
public:
	template<typename T> distorting* merge(T old) {
		this->_img = old->img();
		return this;
	}

	Image* img() {
		return _img;
	}

private:
	Image* _img;
};

class save {
public:
	save(const std::string& filename) :
			_filename(filename) {
	}

	template<typename T> save* merge(T old) {
		Image* img = old->img();
		img->magick("png");
		img->write(_filename);
		return NULL;
	}
private:
	std::string _filename;
};
