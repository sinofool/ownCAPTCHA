
CPP=g++
LIBGD_HOME=$(HOME)/code/build/libgd

CXXFLAGS=-I$(LIBGD_HOME)/include
LDFLAGS=-L$(LIBGD_HOME)/lib -lgd

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

ownCAPTCHA: src/main/cpp/main.cpp
	$(CPP) -g -o $@ $(CXXFLAGS) $(LDFLAGS) $^
