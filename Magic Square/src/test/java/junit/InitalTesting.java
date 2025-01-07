package junit;

import callum.hackerrank.problems.MagicSquareGeneticAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InitalTesting {
	@Test
	public void exampleMatrixOne() {
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

		printMatrix(datasetExampleOne);
		MagicSquareGeneticAlgorithm magicSquareOne = new MagicSquareGeneticAlgorithm(datasetExampleOne, 10);
	}

	private void printMatrix(List<List<Integer>> datasetExampleOne) {
		for (List<Integer> row : datasetExampleOne) {
			for (Integer num : row) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
