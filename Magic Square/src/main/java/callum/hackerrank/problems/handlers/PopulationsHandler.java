package callum.hackerrank.problems.handlers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PopulationsHandler {
	private final List<List<Integer>> dataset;
	private MagicSquareGeneticAlgorithm[] population;

	public PopulationsHandler(List<List<Integer>> dataset) {
		this.dataset = dataset;
	}

	public void runPopulation(int populationAmount, int agentsAmount, int ittr){
		population = new MagicSquareGeneticAlgorithm[populationAmount - 1];
		Object lock = new Object();
		AtomicInteger finishedCount = new AtomicInteger();

		for (int i = 0; i < populationAmount; i++) {
			MagicSquareGeneticAlgorithm current =  new MagicSquareGeneticAlgorithm(dataset, agentsAmount);
			population[i] = current;

			int finalI = i;
			Thread thread = new Thread(() -> {
				current.startGeneration(ittr, finishedCount::getAndIncrement, lock);
				System.out.println("Generation " + finalI + " has Concluded.");
			});

			thread.start();
		}
	}

	private void generationFinished(int finishedCount, int populationAmount){
		if (finishedCount < populationAmount){
			return;
		}

		//Print Generation Leaders.
		System.out.println("Population Leaders");
		for (int i = 0; i < population.length; i++) {
			MagicSquareGeneticAlgorithm current = population[i];
			current.sortByFitness();

			MagicSquareGeneticAlgorithm.ConvertSingleMatrixToString(current.getBestAgent());
		}
	}
}
