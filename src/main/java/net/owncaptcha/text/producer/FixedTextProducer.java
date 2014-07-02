package net.owncaptcha.text.producer;

public class FixedTextProducer implements TextProducer {
    private String text;
    
    public FixedTextProducer(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
