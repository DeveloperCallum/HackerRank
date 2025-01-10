package junit.model_classes;

import callum.hackerrank.problems.MagicSquareGeneticAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class TestableMagicSquare extends MagicSquareGeneticAlgorithm {
	public TestableMagicSquare(List<List<Integer>> dataset, int agents) {
		super(dataset, agents);
	}

	public TestableMagicSquare(List<List<Integer>> dataset, List<List<int[]>> buckets) {
		super(dataset, buckets);
	}

	@Override
	public double calculateFitnessForAgent(int agentIndex) {
		return super.calculateFitnessForAgent(agentIndex);
	}

	private static void printMatrix(List<List<Integer>> datasetExampleOne) {
		for (List<Integer> row : datasetExampleOne) {
			for (Integer num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
