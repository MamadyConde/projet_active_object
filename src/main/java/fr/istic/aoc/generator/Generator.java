package fr.istic.aoc.generator;

import java.util.List;

import fr.istic.aoc.observer.ObserverAsync;
import fr.istic.aoc.observer.SubjectAsync;


public interface Generator extends SubjectAsync<Generator> {
    Integer getValue();

    void generateValue();

    List<ObserverAsync<Generator>> getAsyncObservers();
}
