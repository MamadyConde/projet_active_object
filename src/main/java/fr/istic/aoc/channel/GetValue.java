package fr.istic.aoc.channel;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

import fr.istic.aoc.generator.Generator;


public class GetValue implements Callable<Integer> {
    private Generator generator;
    ScheduledExecutorService scheduled;

    public GetValue(Generator generator) {
        this.generator = generator;
    }
    
    private Integer getValue(){
        return this.generator.getValue();
    }

    public Integer call() throws Exception {
        return this.generator.getValue();
    }
}
