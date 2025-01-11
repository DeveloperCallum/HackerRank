package callum.hackerrank.problems.handlers;

import callum.hackerrank.problems.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MagicSquareGeneticAlgorithm {
	private int total;
	private final List<List<Integer>> dataset;
	private List<List<int[]>> buckets = new ArrayList<>();
	private final int agentLength; //How big the agents need to be.
	private final Logger logger = new Logger(false);

	public MagicSquareGeneticAlgorithm(List<List<Integer>> dataset, int agentsAmount) {
		this.dataset = dataset;
		this.agentLength = dataset.get(0).size();
		total = calculateTotal();
		generateNewAgents(agentsAmount);
	}

	protected MagicSquareGeneticAlgorithm(List<List<Integer>> dataset, List<List<int[]>> buckets) {
		this.dataset = dataset;
		this.agentLength = dataset.get(0).size();
		total = calculateTotal();
		this.buckets = buckets;
	}

	public void startGeneration(int itr, Runnable event, Object lock) {
		startGeneration(itr);

		synchronized (lock) {
			lock.notify();
		}
	}

	public void startGeneration(int itr) {
		double previousBestFitness = 0;
		int capturedAt = -1;
		boolean allowTermination = false;
		for (int i = 0; i < itr; i++) {
			if ((i - capturedAt) > 20 && allowTermination) {
				logger.printMessage("Generation Exited!");
				break;
			}

			logger.printMessage("Generation: " + (i + 1));
			sortByFitness();

			if (i == 0) {
				previousBestFitness = calculateFitnessForAgent(0);
				capturedAt = i;
			}

			//Clone best performer.
			List<int[]> bestPerformer = cloneAgent(0);
			double currentLeadFitness = calculateFitnessForAgent(0);

			logger.printMessage("Best Fitness : " + currentLeadFitness);
			logger.printMessage("Incorrect: " + calculateIncorrectRowsColumnsAndDiagonals(0));
			logger.printMessage("Worst Fitness: " + calculateFitnessForAgent(buckets.size() - 1));
			logger.printMessage("Incorrect: " + calculateIncorrectRowsColumnsAndDiagonals(buckets.size() - 1));

			for (int x = 1; x < buckets.size(); x += 2) {
				if (x < 5) {
					crossoverParents(x - 1, x);
				}
				mutateAgent(x - 1, 0.40);
				mutateAgent(x, 0.40);
			}

			logger.printMessage("\n" + ConvertSingleMatrixToString(bestPerformer));
			buckets.set(buckets.size() - 1, bestPerformer);

			if ((currentLeadFitness < previousBestFitness) && i != 0) {
				if (calculateIncorrectRowsColumnsAndDiagonals(0) <= 0) {
					previousBestFitness = calculateFitnessForAgent(0);
					capturedAt = i;
					allowTermination = true;
					logger.printMessage("NEW LEADER!");
				}
			} else {
				logger.printMessage("No change in fitness leader for " + (i - capturedAt) + "!");
			}

			logger.printMessage("");
		}

		logger.flush();
	}

	protected void generateNewAgents(int agentsAmount) {
		for (int i = 0; i < agentsAmount; i++) {
			List<int[]> agent = new ArrayList<>(agentLength);

			for (int j = 0; j < agentLength; j++) {
				agent.add(new int[agentLength]);
				for (int x = 0; x < agentLength; x++) {
					mutateAgentGeneticsAtPosition(agent, 0.40, j, x); //High mutation rate so that can have a higher randomised set of solutions.
				}
			}

			buckets.add(agent);
		}
	}

	private void mutateAgent(int agentIndex, double mutateRate) {
		List<int[]> agent = buckets.get(agentIndex);

		for (int column = 0; column < agentLength; column++) {
			for (int row = 0; row < agentLength; row++) {
				mutateAgentGeneticsAtPosition(agent, mutateRate, column, row);
			}
		}
	}

	private void mutateAgentGeneticsAtPosition(List<int[]> agent, double mutationRate, int column, int row) {
		if (mutationRate > 0.90) {
			throw new IllegalArgumentException("Mutation rate cannot be higher than 0.90");
		}

		if (mutationRate < 0.01) {
			throw new IllegalArgumentException("Mutation rate cannot be less than 0.01");
		}

		Random random = new Random();
		if (random.nextDouble() < mutationRate) {
			int mutatedValue = random.nextInt(3) - 1;
			int currentValue = dataset.get(column).get(row);

			if ((currentValue + mutatedValue) > 9 || (currentValue + mutatedValue) < 1) { //Check if value is too high or too low!
				//logger.printMessage("Retrying Mutation: " + row + "," + column);
				mutateAgentGeneticsAtPosition(agent, mutationRate, column, row);
				return;
			}

			agent.get(column)[row] += mutatedValue;
		}
	}

	/**
	 * Uniform Crossover: Each gene in the offspring is randomly chosen from one of the corresponding genes of the parents.
	 * This means that each gene has an equal chance of coming from either parent, leading to a high level of genetic diversity.
	 *
	 * @param parentA
	 * @param parentB
	 */
	public void crossoverParents(int parentA, int parentB) {
		List<int[]> agentA = buckets.get(parentA);
		List<int[]> agentB = buckets.get(parentB);

		List<int[]> newAgentA = new ArrayList<>(agentA);
		List<int[]> newAgentB = new ArrayList<>(agentB);

		Random random = new Random();
		for (int column = 0; column < agentA.size(); column++) {
			for (int row = 0; row < agentA.size(); row++) {
				//Mutate
				if (random.nextDouble() <= 0.5) {
					newAgentA.get(column)[row] = agentB.get(column)[row];
				}

				//Mutate
				if (random.nextDouble() <= 0.5) {
					newAgentB.get(column)[row] = agentA.get(column)[row];
				}
			}

			//Overwrite old agents;
			buckets.set(parentA, newAgentA);
			buckets.set(parentB, newAgentB);
		}
	}

	private void printSingleMatrixToLogger(List<int[]> arr) {
		logger.printMessage(ConvertSingleMatrixToString(arr));
	}

	public static String ConvertSingleMatrixToString(List<int[]> arr) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < arr.size(); i++) {
			int[] row = arr.get(i);
			output.append(Arrays.toString(row)).append("\n");
		}

		return output.toString();
	}

	/**
	 * cost function that combines both the absolute sum of differences and a penalty for incorrect rows.
	 * However, if the matrix is valid then the absolute difference between the indexes is taken and summed per array.
	 *
	 * @param agentIndex The array we are getting cost of; 0 indexed.
	 * @return An integer representing the cost.
	 */
	protected double calculateFitnessForAgent(int agentIndex) {
		double penalty = calculatePenaltyFactor(agentIndex);
		double incorrect = calculateIncorrectRowsColumnsAndDiagonals(agentIndex);
		int cost = 0;

		List<int[]> currentAgent = buckets.get(agentIndex);
		for (int[] geneticArr : currentAgent) {
			for (int i = 0; i < agentLength; i++) {
				cost += Math.abs(geneticArr[i]);
			}
		}

		return (cost + incorrect) * penalty;
	}

	protected double calculatePenaltyFactor(int agentIndex) {
		double incorrect = calculateIncorrectRowsColumnsAndDiagonals(agentIndex);
		return Math.pow((incorrect + 1), 2);
	}

	protected int calculateIncorrectRowsColumnsAndDiagonals(int agentIndex) {
		int incorrect = 0;
		int diagonalPositive = 0; //diagonal
		int diagonalNegative = 0; //diagonal
		List<int[]> agent = buckets.get(agentIndex);

		for (int column = 0; column < agentLength; column++) {
			int rowTotal = 0; //row
			int columnTotal = 0; //column

			for (int index = 0; index < agentLength; index++) { //Sum rows & columns.
				rowTotal += dataset.get(column).get(index) + agent.get(column)[index];
				columnTotal += dataset.get(index).get(column) + agent.get(index)[column];

				if (index == 0) { //Sum diagonals
					diagonalPositive += dataset.get(column).get(column) + agent.get(column)[column];

					int diagonalIndex = Math.abs(column - (agentLength - 1));
					diagonalNegative += dataset.get(column).get(diagonalIndex) + agent.get(column)[diagonalIndex];
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

	public void sortByFitness() {
		for (int x = 0; x < buckets.size(); x++) {
			boolean swapped = false;
			for (int i = 0; i < buckets.size() - 1; i++) {
				for (int j = x; j < buckets.size(); j++) {
					List<int[]> current = buckets.get(i);
					List<int[]> next = buckets.get(j);
					double currentFitness = calculateFitnessForAgent(i);
					double nextFitness = calculateFitnessForAgent(j);

					if (nextFitness < currentFitness) {
						buckets.set(i, next);
						buckets.set(j, current);
						swapped = true;
					}
				}
			}

			if (!swapped) {
				break;
			}
		}
	}

	public List<int[]> cloneAgent(List<int[]> agent) {
		List<int[]> cloned = new ArrayList<>();
		for (int[] array : agent) {
			cloned.add(array.clone());
		}

		return cloned;
	}

	public List<int[]> cloneAgent(int agentIndex) {
		List<int[]> cloned = new ArrayList<>();
		for (int[] array : buckets.get(agentIndex)) {
			cloned.add(array.clone());
		}

		return cloned;
	}

	public List<List<int[]>> getAgents() {
		return new ArrayList<>(buckets);
	}

	private int calculateTotal() {
		return (dataset.size() * ((int) Math.pow(dataset.size(), 2) + 1)) / 2;
	}

	public List<int[]> getBestAgent() {
		sortByFitness();
		return buckets.get(0);
	}
}
