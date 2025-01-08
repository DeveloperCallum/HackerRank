package junit;

import junit.model_classes.TestableMagicSquare;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CostTest {
	@Test
	public void exampleMatrixOne() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(8);
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
		int incorrect = magicSquareOne.calculateIncorrectRowsColumnsAndDiagonals();
		Assertions.assertEquals(4, incorrect);
	}

	@Test
	public void incorrectNoMatrixTwo() {
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
		int incorrect = magicSquareOne.calculateIncorrectRowsColumnsAndDiagonals();
		Assertions.assertEquals(7, incorrect);
	}

	@Test
	public void incorrectNoMatrixThree() {
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
			add(7);
			add(2);
		}});

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, 10);
		int incorrect = magicSquareOne.calculateIncorrectRowsColumnsAndDiagonals();
		Assertions.assertEquals(5, incorrect);
	}

	@Test
	public void incorrectNoMatrixFour() {
		List<List<Integer>> datasetExampleOne = new ArrayList<>();
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(8);
			add(3);
			add(4);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(1);
			add(5);
			add(9);
		}});
		datasetExampleOne.add(new ArrayList<Integer>() {{
			add(6);
			add(7);
			add(2);
		}});

		TestableMagicSquare magicSquareOne = new TestableMagicSquare(datasetExampleOne, 10);
		double incorrect = magicSquareOne.calculateIncorrectRowsColumnsAndDiagonals();
		Assertions.assertEquals(0, incorrect);
	}
}
