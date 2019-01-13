package fr.istic.aoc.observer;


public interface SubjectAsync<T> {
    void attach(ObserverAsync<T> var1);

    void detach(ObserverAsync<T> var1);

    void notifyObservers();
}
