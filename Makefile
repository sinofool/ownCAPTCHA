
CPP=g++
IMAGEMAGICK_HOME=$(HOME)/code/build/imagemagick
IMAGEMAGICK_INCLUDE=$(IMAGEMAGICK_HOME)/include/ImageMagick-6
IMAGEMAGICK_LIB=$(IMAGEMAGICK_HOME)/lib

LIBPNG_HOME=$(HOME)/code/build/libpng
LIBPNG_LIB=$(LIBPNG_HOME)/lib

JPEG_HOME=$(HOME)/code/build/jpeg-9
JPEG_LIB=$(JPEG_HOME)/lib

CXXFLAGS=-I$(IMAGEMAGICK_INCLUDE) -DMAGICKCORE_HDRI_ENABLE=0 -DMAGICKCORE_QUANTUM_DEPTH=16
LDFLAGS=-L$(IMAGEMAGICK_LIB) -lMagick++-6.Q16 -lMagickWand-6.Q16 -lMagickCore-6.Q16 -lz -lxml2 \
 -L$(LIBPNG_LIB) -lpng -L$(JPEG_LIB) -ljpeg -lbz2

.PHONY: all
.PHONY: clean
.PHONY: run

all: ownCAPTCHA
	echo "Welcome to ownCAPTCHA"

clean:
	rm ownCAPTCHA

run:
	./ownCAPTCHA

*.o: *.cpp
	$(CPP) -c -g -o $@ $(CXXFLAGS) $<

ownCAPTCHA: src/main/cpp/main.cpp src/main/cpp/captcha.hpp
	$(CPP) -g -o $@ $(CXXFLAGS) $(LDFLAGS) $<
