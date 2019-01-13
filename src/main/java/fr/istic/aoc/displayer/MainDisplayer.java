package fr.istic.aoc.displayer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import fr.istic.aoc.channel.Channel;
import fr.istic.aoc.generator.GeneratorImpl;
import fr.istic.aoc.strategy.Atomic;
import fr.istic.aoc.strategy.DiffusionStrategy;
import fr.istic.aoc.strategy.Sequential;



public class MainDisplayer {
	
	public static void main(String[] args) {
		GeneratorImpl generator = new GeneratorImpl();
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(Integer.MAX_VALUE);

		Channel channel1 = new Channel(generator, 50);
		generator.attach(channel1);
		Displayer displayer1 = new DisplayerImpl();
		channel1.attach(displayer1);
		//generateur.generateValue();
		channel1.setScheduled(scheduled);
		
		Channel channel2 = new Channel(generator, 150);
		generator.attach(channel2);
		Displayer displayer2 = new DisplayerImpl();
		channel2.attach(displayer2);
		//generateur.generateValue();
		channel2.setScheduled(scheduled);
		
		Channel channel3 = new Channel(generator, 250);
		generator.attach(channel3);
		Displayer displayer3 = new DisplayerImpl();
		channel3.attach(displayer3);
		//generateur.generateValue();
		channel3.setScheduled(scheduled);
		
		Channel channel4 = new Channel(generator, 500);
		generator.attach(channel4);
		Displayer displayer4 = new DisplayerImpl();
		channel4.attach(displayer4);
		//generateur.generateValue();
		channel4.setScheduled(scheduled);
		
        DiffusionStrategy strategy = new Sequential();
        strategy.configure(generator);
        scheduled.scheduleAtFixedRate(() -> strategy.run(), 0, 1000, TimeUnit.MILLISECONDS);

//		DiffusionStrategy atomic = new Atomic();
//		atomic.configure(generator);
//		scheduled.scheduleAtFixedRate(() -> atomic.run(), 0, 1000, TimeUnit.MILLISECONDS);
	}
}
