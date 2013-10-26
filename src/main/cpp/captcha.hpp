#include <gd.h>
#include <string>
#include <stdio.h>

struct rgb {
  rgb(uint8_t red, uint8_t green, uint8_t blue) : r(red), g(green), b(blue) {};
  uint8_t r;
  uint8_t g;
  uint8_t b;
};

class background {
public:
  background(int width, int height, rgb rgb) :
    _width(width), _height(height), _rgb(rgb) {}
  
  template<typename T> background* merge(T old) {
    this->_img = gdImageCreateTrueColor(_width, _height);
    int bg = gdImageColorResolve(_img, _rgb.r, _rgb.g, _rgb.b);
    gdImageFill(_img, 0, 0, bg);
    return this;
  };
  gdImagePtr img() {
    return _img;
  }
private:
  gdImagePtr _img;
  int _width;
  int _height;
  rgb _rgb;
};

class text {
public:
  text(const std::string& text, const std::string& font, double size, double angle, int x, int y, rgb rgb) :
    _text(text), _font(font), _size(size), _angle(angle), _x(x), _y(y), _rgb(rgb) {};
  template<typename T> text* merge(T old) {
    this->_img = old->img();
    int brect[8];
    int color = gdImageColorResolve(_img, _rgb.r, _rgb.g, _rgb.b);
    gdImageStringFT(_img, &brect[0], 
		    color, const_cast<char*>(_font.c_str()), _size, 
		    _angle, _x, _y, const_cast<char*>(_text.c_str()));
    return this;
  };
  gdImagePtr img() {
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
  gdImagePtr _img;
};

class distorting {
public:
  template<typename T> distorting* merge(T old) {
    gdImagePtr ext = gdImageCreateTrueColor(200, 200);
    gdImageCopy(ext, old->img(), 0, 0, 0, 0, 200, 200);
    this->_img = gdImageSquareToCircle(ext, 200);
    return this;
  };
  gdImagePtr img() {
    return _img;
  };
private:
  gdImagePtr _img;
};

class save {
 public:
 save(const std::string& filename) :
  _filename(filename) {};
  template<typename T> save* merge(T old) {
    FILE* f = fopen(_filename.c_str(), "wb");
    gdImagePng(old->img(), f);
    fclose(f);
    gdImageDestroy(old->img());
    return NULL;
  };
 private:
  std::string _filename;
};
