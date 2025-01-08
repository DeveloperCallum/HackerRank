package junit.model_classes;

import callum.hackerrank.problems.MagicSquareGeneticAlgorithm;

import java.util.Collections;
import java.util.List;

public class TestableMagicSquare extends MagicSquareGeneticAlgorithm {
	public TestableMagicSquare(List<List<Integer>> dataset, int agents) {
		super(dataset, agents);
	}

	public TestableMagicSquare(List<List<Integer>> dataset, List<List<int[]>> buckets, int agentLength) {
		super(dataset, buckets, agentLength);
	}

	@Override
	public double calculateCostFunctionForAgent(int index) {
		return super.calculateCostFunctionForAgent(index);
	}

	@Override
	public double calculatePenaltyFactor() {
		return super.calculatePenaltyFactor();
	}

	@Override
	public int calculateIncorrectRowsColumnsAndDiagonals() {
		return super.calculateIncorrectRowsColumnsAndDiagonals();
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
