package fr.istic.aoc.displayer;

import java.util.concurrent.ExecutionException;

import fr.istic.aoc.channel.GeneratorAsync;

public class DisplayerImpl implements Displayer {

	public void update(GeneratorAsync subject) {
        try {
            int value = ((Integer)subject.getValue().get());
            System.out.println("Valeur Afficheur "+value);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        } catch (ExecutionException var4) {
            var4.printStackTrace();
        }
  }

}
