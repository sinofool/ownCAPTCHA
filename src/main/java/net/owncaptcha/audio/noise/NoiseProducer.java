package net.owncaptcha.audio.noise;

import java.util.List;

import net.owncaptcha.audio.Sample;

public interface NoiseProducer {
    public Sample addNoise(List<Sample> target);
}
