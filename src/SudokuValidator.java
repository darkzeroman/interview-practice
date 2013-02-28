

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.Test;

/** Sudoku Validator */
public class SudokuValidator {

	public static boolean isValidSudoku(int[][] sudoku) {

		for (int i = 0; i < sudoku.length; i++) {
			// check rows
			if (isNotValidRange(sudoku, 0, i, sudoku.length, i + 1))
				return false;
			// check columns
			if (isNotValidRange(sudoku, i, 0, i + 1, sudoku.length))
				return false;
		}

		/*
		 * check each subgrid, the following will check as many subgrids as
		 * necesssary
		 */

		int numSubGrids = sudoku.length / 3;
		for (int i = 0; i < numSubGrids; i++)
			for (int j = 0; j < numSubGrids; j++) {
				if (isNotValidRange(sudoku, i * 3, j * 3, (i + 1) * 3, (j + 1) * 3))
					return false;
			}

		return true;
	}

	public static boolean isNotValidRange(int[][] sudoku, int startX, int startY, int endX, int endY) {
		HashSet<Integer> hs = new HashSet<Integer>();

		for (int i = startX; i < endX; i++)
			for (int j = startY; j < endY; j++) {
				if (!hs.add(sudoku[i][j]))
					return true;
			}
		return false;
	}

	@Test
	public void testCases() {

		// valid cases
		int[][] testCase1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] testCase2 = { { 7, 5, 1, 8, 4, 3, 9, 2, 6 }, { 8, 9, 3, 6, 2, 5, 1, 7, 4 },
				{ 6, 4, 2, 1, 7, 9, 5, 8, 3 }, { 4, 2, 5, 3, 1, 6, 7, 9, 8 }, { 1, 7, 6, 9, 8, 2, 3, 4, 5 },
				{ 9, 3, 8, 7, 5, 4, 6, 1, 2 }, { 3, 6, 4, 2, 9, 7, 8, 5, 1 }, { 2, 8, 9, 5, 3, 1, 4, 6, 7 },
				{ 5, 1, 7, 4, 6, 8, 2, 3, 9 } };

		assertTrue(isValidSudoku(testCase1));
		assertTrue(isValidSudoku(testCase2));

		// invalid cases
		int[][] testCase3 = { { 1, 2, 2 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] testCase4 = { { 7, 5, 1, 8, 4, 3, 9, 2, 6 }, { 8, 9, 3, 6, 2, 5, 1, 7, 4 },
				{ 6, 4, 2, 1, 7, 9, 5, 8, 3 }, { 4, 2, 5, 3, 1, 6, 7, 9, 8 }, { 1, 7, 6, 9, 8, 2, 3, 4, 5 },
				{ 9, 3, 8, 7, 5, 4, 6, 1, 1 }, { 3, 6, 4, 2, 9, 7, 8, 5, 1 }, { 2, 8, 9, 5, 3, 1, 4, 6, 7 },
				{ 5, 1, 7, 4, 6, 8, 2, 3, 9 } };

		assertFalse(isValidSudoku(testCase3));
		assertFalse(isValidSudoku(testCase4));
	}
}
