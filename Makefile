
CPP=g++

CXXFLAGS=`Magick++-config --cflags --cppflags`
LDFLAGS=`Magick++-config --ldflags --libs`

.PHONY: all
.PHONY: clean
.PHONY: run

all: ownCAPTCHA
	echo "Compiling ownCAPTCHA"

clean:
	rm -f ownCAPTCHA

run:
	./ownCAPTCHA

*.o: *.cpp
	$(CPP) -c -g -o $@ $(CXXFLAGS) $<

ownCAPTCHA: src/main/cpp/main.cpp src/main/cpp/captcha.hpp
	$(CPP) -g -o $@ $(CXXFLAGS) $(LDFLAGS) $<
