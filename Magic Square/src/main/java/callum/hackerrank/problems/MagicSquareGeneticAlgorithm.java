package callum.hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicSquareGeneticAlgorithm {
	private int total;
	private final List<List<Integer>> dataset;
	private List<List<int[]>> buckets = new ArrayList<>();
	private final int agentLength; //How big the agents need to be.

	public MagicSquareGeneticAlgorithm(List<List<Integer>> dataset, int agentsAmount) {
		this.dataset = dataset;
		this.agentLength = dataset.get(0).size();
		total = calculateTotal();
		generateNewAgents(agentsAmount);
	}

	protected MagicSquareGeneticAlgorithm(List<List<Integer>> dataset, List<List<int[]>> buckets, int agentLength) {
		this.dataset = dataset;
		this.agentLength = dataset.get(0).size();
		total = calculateTotal();
		this.buckets = buckets;
	}

	protected void generateNewAgents(int agentsAmount){

		//randomise our agents.
//		for (int i = 0; i < agentsAmount; i++) {
//			List<int[]> agent = new ArrayList<>();
//			int[] tempAgentArr = new int[agentLength];
//
//			for (int j = 0; j < agentLength; j++) {
//				Random random = new Random();
//				tempAgentArr[j] = random.nextInt(9) + 1;
//			}
//			buckets.add(tempAgentArr);
//		}
	}

	private int calculateTotal() {
		return (dataset.size() * ((int) Math.pow(dataset.size(), 2) + 1)) / 2;
	}

	/**
	 * cost function that combines both the absolute sum of differences and a penalty for incorrect rows.
	 * However, if the matrix is valid then the absolute difference between the indexes is taken and summed per array.
	 *
	 * @param index The array we are getting cost of; 0 indexed.
	 * @return An integer representing the cost.
	 */
	protected double calculateCostFunctionForAgent(int index) {
//		List<Integer> datasetContext = dataset.get(index);
//		double penalty = calculatePenaltyFactor();
//		List<int[]> agentContext = buckets.get(index);
//
//		int result = 0;
//		for (int i = 0; i < agentLength; i++) {
//			int difference = Math.abs(datasetContext.get(i) - agentContext[i]);
//			result = +difference;
//		}
//
//		return result* penalty;
		return 0;
	}

	protected double calculatePenaltyFactor(){
		double incorrect = calculateIncorrectRowsColumnsAndDiagonals();
		return 1 / (incorrect + 1);
	}
	protected int calculateIncorrectRowsColumnsAndDiagonals() {
		int incorrect = 0;
		int diagonalPositive = 0; //diagonal
		int diagonalNegative = 0; //diagonal

		for (int column = 0; column < agentLength; column++) {
			int rowTotal = 0; //row
			int columnTotal = 0; //column

			for (int index = 0; index < agentLength; index++) { //Sum rows & columns.
				rowTotal += dataset.get(column).get(index);
				columnTotal += dataset.get(index).get(column);

				if (index == 0){ //Sum diagonals
					diagonalPositive += dataset.get(column).get(column);
					diagonalNegative += dataset.get(column).get(Math.abs(column - (agentLength - 1)));
				}
			}

			//Gather results.
			if (rowTotal != total) {
				incorrect++;
			}

			if (columnTotal != total) {
				incorrect++;
			}
		}

		//Check if diagonals were correct.
		if (diagonalNegative != total) {
			incorrect++;
		}

		if (diagonalPositive != total) {
			incorrect++;
		}

		return incorrect;
	}
}
