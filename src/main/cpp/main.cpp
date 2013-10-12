#include <iostream>

#include "captcha.hpp"

int main() {
  std::cout << "Welcome to ownCAPTCHA" << std::endl;

  background bg(300, 200, rgb(0x00, 0xF0, 0x00));
  text text("Hello", "./au.ttf", 40, 1, 150, 100, rgb(0x00, 0x00, 0xF0));
  save save("background.png");
  save.merge(text.merge(bg.merge(NULL)));
  
  return 0;
}
