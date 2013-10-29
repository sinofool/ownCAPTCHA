#include <iostream>

#include "captcha.hpp"

int main() {
  std::cout << "Welcome to ownCAPTCHA" << std::endl;

  background bg(300, 200, rgb(0x0000, 0xF000, 0x0000));
  text text("Hello", "./au.ttf", 40, 0.2, 50, 100, rgb(0x00, 0x00, 0xF000));
  distorting distorting;
  save save("background.png");
  save.merge(distorting.merge(text.merge(bg.merge(NULL))));
  
  return 0;
}
