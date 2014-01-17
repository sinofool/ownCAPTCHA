package net.owncaptcha.servlet;

import static org.junit.Assert.*;
import net.owncaptcha.Captcha;
import net.owncaptcha.servlet.StickyCaptchaServlet;

import org.junit.Test;

public class StickyCaptchaServletTest {
    @Test
    public void testShouldExpire() {
        Captcha captcha = new Captcha.Builder(200, 50)
            .addText()
            .build();
        
        assertFalse(StickyCaptchaServlet.shouldExpire(captcha));
        
        StickyCaptchaServlet.setTtl(0);
        assertTrue(StickyCaptchaServlet.shouldExpire(captcha));
        
        assertEquals(0, StickyCaptchaServlet.getTtl());
        StickyCaptchaServlet.setTtl(-1000);
        assertEquals(0, StickyCaptchaServlet.getTtl());
        
        StickyCaptchaServlet.setTtl(Long.MAX_VALUE);
        assertFalse(StickyCaptchaServlet.shouldExpire(captcha));
    }
}
