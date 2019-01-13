package fr.istic.aoc.observer;


public interface Subject<T> {
    void attach(Observer<T> var1);

    void detach(Observer<T> var1);

    void notifyObservers();
}