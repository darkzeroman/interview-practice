import java.awt.Point;
import java.util.Arrays;

public class NQueens {

	public static void main(String[] args) {
		recCall(new boolean[4][4], 0, 0);
	}

	final static int boardSize = 4;

	public static void recCall(boolean[][] grid, int count, int next) {
		if (next == grid.length * grid.length) {

			if (count == 4) {
				for (boolean[] arr : grid)
					System.out.println(Arrays.toString(arr));
				System.out.println();
			}

			return;
		}

		int y = next / boardSize;
		int x = next % boardSize;

		if (isValid(grid, x, y)) {
			grid[y][x] = true;
			recCall(grid, count + 1, next + 1);
			grid[y][x] = false;
			recCall(grid, count, next + 1);
		} else {
			recCall(grid, count, next + 1);
		}

	}

	public static void isCorrect(boolean[][] grid) {
		int count = 0;
		for (boolean[] arr : grid)
			for (boolean val : arr)
				if (val)
					count++;

		if (count == 4) {
			for (boolean[] arr : grid)
				System.out.println(Arrays.toString(arr));
			System.out.println();
		}
	}

	public static boolean isValid(boolean[][] grid, int x, int y) {

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][x])
				return false;
			if (grid[y][i])
				return false;
		}

		Point point = new Point(x, y);
		while (point.x > 0 && point.y > 0)
			point.translate(-1, -1);
		while (point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid.length) {
			if (grid[point.y][point.x])
				return false;
			point.translate(1, 1);
		}

		point = new Point(x, y);
		while (point.x > 0 && point.y < grid.length - 1)
			point.translate(-1, 1);
		while (point.x >= 0 && point.x < grid.length && point.y >= 0 && point.y < grid.length) {
			if (grid[point.y][point.x])
				return false;
			point.translate(1, -1);
		}

		return true;
	}
}
