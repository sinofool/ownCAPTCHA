package net.owncaptcha.math;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import net.owncaptcha.CaptchaIF;
import net.owncaptcha.backgrounds.BackgroundProducer;
import net.owncaptcha.backgrounds.TransparentBackgroundProducer;
import net.owncaptcha.noise.CurvedLineNoiseProducer;
import net.owncaptcha.noise.NoiseProducer;
import net.owncaptcha.text.renderer.DefaultWordRenderer;

public class MathCaptcha implements CaptchaIF {

    public static final String NAME = "mathCaptcha";
    private static final Random RAND = new SecureRandom();

    private Builder _builder;
    
    private MathCaptcha(Builder builder) {
        _builder = builder;
    }

  
    
    public static class Builder {

        private BufferedImage _img;
        /**
         * @serial
         */
        private BufferedImage _bg;

        private String _question;
        private String _answer;
        private int a;
        private int b;
        
        public Builder(int width, int height) {
            _img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        	this.a = RAND.nextInt(100);
        	this.b = RAND.nextInt(100);
        	if (a<b) {
        		_question = a + " + " + b + " = ?";
        		_answer = (""+(a+b));
        	} else {
        		_question = a + " - " + b + " = ?";
        		_answer = (""+(a-b));
        	}
        }
        
        /**
         * Add a background using the default {@link BackgroundProducer} (a {@link TransparentBackgroundProducer}).
         */
        public Builder addBackground() {
            return addBackground(new TransparentBackgroundProducer());
        }

        /**
         * Add a background using the given {@link BackgroundProducer}.
         * 
         * @param bgProd
         */
        public Builder addBackground(BackgroundProducer bgProd) {
        	_bg = bgProd.getBackground(_img.getWidth(), _img.getHeight());
            
            return this;
        }

        /**
         * Add noise using the default {@link NoiseProducer} (a {@link CurvedLineNoiseProducer}).
         */
        public Builder addNoise() {
            return this.addNoise(new CurvedLineNoiseProducer());
        }

        /**
         * Add noise using the given NoiseProducer.
         * 
         * @param nProd
         */
        public Builder addNoise(NoiseProducer nProd) {
            nProd.makeNoise(_img);
            return this;
        }

        public MathCaptcha build() {
        	if (_bg == null) {
        		_bg = new TransparentBackgroundProducer().getBackground(_img.getWidth(), _img.getHeight());
        	}

        	// Paint the main image over the background
        	Graphics2D g = _bg.createGraphics();
        	g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        	g.drawImage(_img, null, null);

        	_img = _bg;

        	new DefaultWordRenderer().render(_question, _img);
        	
            return new MathCaptcha(this);
        }

        @Override public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append("[Answer: ");
            sb.append(_answer);
            sb.append("]");

            return sb.toString();
        }
    }

    public boolean isCorrect(String answer) {
        return answer.equals(_builder._answer);
    }

    @Override
    public String getAnswer() {
        return _builder._answer;
    }

    /**
     * Get the CAPTCHA image, a PNG.
     *
     * @return A PNG CAPTCHA image.
     */
    @Override
    public BufferedImage getImage() {
        return _builder._img;
    }
    
    public String getChallenge() {
        return _builder._question;
    }

    @Override public String toString() {
        return _builder.toString();
    }
}
