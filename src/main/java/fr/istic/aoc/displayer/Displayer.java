package fr.istic.aoc.displayer;

import fr.istic.aoc.channel.GeneratorAsync;
import fr.istic.aoc.observer.Observer;

public interface Displayer extends Observer<GeneratorAsync> {
	
	void update(GeneratorAsync subject);
}
