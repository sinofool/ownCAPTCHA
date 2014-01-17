package net.owncaptcha.audio.producer;

import net.owncaptcha.audio.Sample;

/**
 * Generates a vocalization for a single character.
 * 
 * @author <a href="mailto:james.childers@gmail.com">James Childers</a>
 *
 */
public interface VoiceProducer {
    public Sample getVocalization(char letter);
}
