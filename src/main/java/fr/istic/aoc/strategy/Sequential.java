package fr.istic.aoc.strategy;

import fr.istic.aoc.generator.Generator;
import fr.istic.aoc.observer.ObserverAsync;


public class Sequential implements DiffusionStrategy{

	private Generator generator;

	public void configure(Generator generator) {
		this.generator = generator;
		
	}

	public void run() {
        this.generator.generateValue();
        for(ObserverAsync<Generator> observerAsync:this.generator.getAsyncObservers()) {
            observerAsync.update(this.generator);
        }		
	}

}
