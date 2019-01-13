package fr.istic.aoc.channel;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.generator.Generator;
import fr.istic.aoc.observer.Observer;
import fr.istic.aoc.observer.ObserverAsync;
import fr.istic.aoc.observer.Subject;



public class Channel implements ObserverAsync<Generator>, GeneratorAsync, Subject<GeneratorAsync> {
	
    private Generator generator;
    ScheduledExecutorService scheduler;
    private Observer<GeneratorAsync> observersChannel; 
    private int delay;
    
  
	public Channel(Generator generator, int delay) {
		super();
		this.generator = generator;
		this.delay = delay;
		this.scheduler = Executors.newScheduledThreadPool(10);
	}
	
	
	public void attach(Observer<GeneratorAsync> observer) {
		this.observersChannel = observer;	
	}
	public void detach(Observer<GeneratorAsync> observer) {
		this.observersChannel = null;		
	}
	public void notifyObservers() {
		// TODO Auto-generated method stub
		
	}
	public Future<Void> update(Generator subjectasync) {
        Callable<Void> update = new Update(this, this.observersChannel);
        return this.scheduler.schedule(update, (long)this.delay, TimeUnit.MILLISECONDS);
    }
 
	    public Future<Integer> getValue() {
	        Callable<Integer> getValue = new GetValue(this.generator);
	        return this.scheduler.schedule(getValue, (long)this.delay, TimeUnit.MILLISECONDS);
	    }

    public void setScheduled(ScheduledExecutorService scheduled) {
        this.scheduler = scheduled;
    }





}

