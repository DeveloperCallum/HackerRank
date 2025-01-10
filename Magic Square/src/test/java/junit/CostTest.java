package junit;

import junit.model_classes.TestableMagicSquare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CostTest {
	@Test
	public void correctMatrixOne() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		List<List<int[]>> bucketSet = new ArrayList<>();
		List<int[]> agentSet = new ArrayList<>();
		agentSet.add(new int[]{3, 0, 0});
		agentSet.add(new int[]{0, 0, 1});
		agentSet.add(new int[]{0, 3, 0});
		bucketSet.add(agentSet);

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, bucketSet);
		double cost = magicSquareOne.calculateFitnessForAgent(0);
		Assertions.assertEquals(7, cost);
	}

	@Test
	public void incorrectMatrixOne() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		List<List<int[]>> bucketSet = new ArrayList<>();
		List<int[]> agentSet = new ArrayList<>();
		agentSet.add(new int[]{3, 0, 1});
		agentSet.add(new int[]{0, 0, 1});
		agentSet.add(new int[]{0, 3, 0});
		bucketSet.add(agentSet);

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, bucketSet);
		double cost = magicSquareOne.calculateFitnessForAgent(0);
		Assertions.assertEquals(176, cost);
	}

	@Test
	public void incorrectMatrixTwo() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		List<List<int[]>> bucketSet = new ArrayList<>();
		List<int[]> agentSet = new ArrayList<>();
		agentSet.add(new int[]{3, 0, -1});
		agentSet.add(new int[]{0, 0, 1});
		agentSet.add(new int[]{0, 3, 0});
		bucketSet.add(agentSet);

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, bucketSet);
		double cost = magicSquareOne.calculateFitnessForAgent(0);
		Assertions.assertEquals(176, cost);
	}

	@Test
	public void incorrectMatrixThree() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		List<List<int[]>> bucketSet = new ArrayList<>();
		List<int[]> agentSet = new ArrayList<>();
		agentSet.add(new int[]{1, 0, -1});
		agentSet.add(new int[]{1, 0, 1});
		agentSet.add(new int[]{0, 1, 2});
		bucketSet.add(agentSet);

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, bucketSet);
		double cost = magicSquareOne.calculateFitnessForAgent(0);
		Assertions.assertEquals(637, cost);
	}

	@Test
	public void sort() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, 10);
		List<List<int[]>> agents = magicSquareOne.getAgents();

		for (int i = 0; i < agents.size(); i++) {
			System.out.print(magicSquareOne.calculateFitnessForAgent(i) + ", ");
		}

		System.out.print('\n');
		magicSquareOne.sortByFitness();

		for (int i = 0; i < agents.size(); i++) {
			System.out.print(magicSquareOne.calculateFitnessForAgent(i) + ", ");
		}
		System.out.print('\n');

		printSingleMatrix(magicSquareOne.getAgents().get(0));
		printSingleMatrix(magicSquareOne.getAgents().get(1));
		printSingleMatrix(magicSquareOne.getAgents().get(2));
	}

	@Test
	public void generationStart() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(5);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(8);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(4);
			add(2);
		}});

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, 10);
		magicSquareOne.startGeneration(10000);
	}

	private void printMatrix(List<List<int[]>> arr) {
		for (List<int[]> agent : arr) {
			for (int i = 0; i < agent.size(); i++) {
				int[] row = agent.get(i);
				System.out.println(Arrays.toString(row));
			}

			System.out.println("");
		}
	}

	private void printSingleMatrix(List<int[]> arr) {
		for (int i = 0; i < arr.size(); i++) {
			int[] row = arr.get(i);
			System.out.println(Arrays.toString(row));
		}

		System.out.println("");
	}
}