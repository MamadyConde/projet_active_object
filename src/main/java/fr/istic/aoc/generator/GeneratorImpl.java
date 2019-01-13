package fr.istic.aoc.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.istic.aoc.observer.ObserverAsync;



public class GeneratorImpl implements Generator {

	private List<ObserverAsync<Generator>> observers = new ArrayList();
    private Integer value;
   

    public GeneratorImpl() {
    }

    public Integer getValue() {
        return this.value;
    }

    public void generateValue() {
        Random r = new Random();
        this.value = r.nextInt(100);
        System.out.println("Valeur du Generateur: " + this.value);
        this.notifyObservers();
       
    }

    public void attach(ObserverAsync<Generator> observerAsync) {
        this.observers.add(observerAsync);
    }

    public void detach(ObserverAsync<Generator> observerAsync) {
        this.observers.remove(observerAsync);
    }

    public void notifyObservers() {
//    	for (int i = 0; i < observers.size(); i++) {
//    		observers.get(i).update(this);
//		}
    }


    public List<ObserverAsync<Generator>> getAsyncObservers() {
        return this.observers;
    }


}
