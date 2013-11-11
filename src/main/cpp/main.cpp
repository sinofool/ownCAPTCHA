#include <iostream>

#include "captcha.hpp"

int main() {
  std::cout << "Welcome to ownCAPTCHA" << std::endl;

  background bg(300, 200, rgb(0x0000, 0xF000, 0x0000));
  text text("Hello", "./au.ttf", 50, 1, 0, 0, rgb(0x0000, 0x0000, 0xF000));
  mathadd mathadd(3, 5, 0, 0, rgb(0x0000, 0x0000, 0xF000));
  distorting distorting;
  save save("background.png");
  save.merge(distorting.merge(mathadd.merge(bg.merge(NULL))));
  
  return 0;
}
