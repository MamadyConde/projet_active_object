package fr.istic.aoc.channel;

import java.util.concurrent.Callable;

import fr.istic.aoc.generator.Generator;
import fr.istic.aoc.observer.Observer;
import fr.istic.aoc.observer.SubjectAsync;



public class Update implements Callable<Void> {

    private GeneratorAsync generateurAsync;
    private Observer<GeneratorAsync> obsever;

    
    public Update(SubjectAsync<Generator> generatorSubjectAsync) {
		super();
	}

	public Update(GeneratorAsync generateurAsync, Observer<GeneratorAsync> obsever) {
        this.generateurAsync = generateurAsync;
        this.obsever = obsever;
    }
    

	public Void call() throws Exception {
		this.obsever.update(this.generateurAsync);
		return null;
	}
    

}

