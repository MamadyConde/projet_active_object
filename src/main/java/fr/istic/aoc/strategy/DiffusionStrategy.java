package fr.istic.aoc.strategy;

import fr.istic.aoc.generator.Generator;

public interface DiffusionStrategy {
    void configure(Generator generateur); 
    void run();
}
