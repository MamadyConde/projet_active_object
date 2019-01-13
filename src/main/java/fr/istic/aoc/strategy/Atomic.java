package fr.istic.aoc.strategy;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.generator.Generator;
import fr.istic.aoc.observer.ObserverAsync;


public class Atomic implements DiffusionStrategy{
	private Generator generator;

	@Override
	public void configure(Generator generator) {
		this.generator = generator;
		
	}

	@Override
	public void run() {
        this.generator.generateValue();
        for(ObserverAsync<Generator> observerAsync: this.generator.getAsyncObservers()){
            try {
                observerAsync.update(this.generator).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }		
	}

}
