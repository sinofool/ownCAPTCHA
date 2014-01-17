package net.owncaptcha;

import java.awt.image.BufferedImage;

public interface CaptchaIF {
    public String getAnswer();
    public BufferedImage getImage();
}
