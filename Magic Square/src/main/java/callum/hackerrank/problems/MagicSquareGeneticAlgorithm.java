package callum.hackerrank.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MagicSquareGeneticAlgorithm {
	private final List<List<Integer>> dataset;
	private List<int[]> buckets = new ArrayList<>();
	private final int agentLength; //How big the agents need to be.

	public MagicSquareGeneticAlgorithm(List<List<Integer>> dataset, int agents) {
		this.dataset = dataset;
		this.agentLength = dataset.get(0).size();

		//randomise our agents.
		for (int i = 0; i < agents; i++) {
			List<int[]> agent = new ArrayList<>();
			int[] tempAgentArr = new int[agentLength];

			for (int j = 0; j < agentLength; j++) {
				Random random = new Random();
				tempAgentArr[j] = random.nextInt(9) + 1;
			}
			agent.add(tempAgentArr);
		}
	}

	/**
	 * cost function that combines both the absolute sum of differences and a penalty for incorrect rows.
	 * However, if the matrix is valid then the absolute difference between the indexes is taken and summed per array.
	 * @param index The array we are getting cost of; 0 indexed.
	 * @return An integer representing the cost.
	 */
	private int calculateCostFunction(int index, int penaltyFactor){
		int result = 0;
		List<Integer> datasetContext = dataset.get(index);
		int[] agentContext = buckets.get(index);

		for (int i = 0; i < agentLength; i++) {
			int difference = Math.abs(datasetContext.get(i) - agentContext[i]);
			result =+ difference;
		}

		return  0;
	}
}
