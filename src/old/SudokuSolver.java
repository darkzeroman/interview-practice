package old;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

public class SudokuSolver {

    static final int BOARD_SIZE = 9;
    static Hashtable<int[], HashSet<Integer>> subGrids = new Hashtable<int[], HashSet<Integer>>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}};
        solveSudoku(grid, 0);
    }

    public static void solveSudoku(int[][] grid, int next) {
        if (next == (grid.length * grid.length)) {
            for (int[] arr : grid)
                System.out.println(Arrays.toString(arr));
            return;
        }

        int x = next / BOARD_SIZE;
        int y = next % BOARD_SIZE;

        boolean given = grid[y][x] == -1 ? false : true;

        if (given) {
            solveSudoku(grid, next + 1);
        } else {
            for (int i = 1; i < 10; i++) {
                if (isValid(grid, i, x, y)) {
                    grid[y][x] = i;
                    solveSudoku(grid, next + 1);
                    grid[y][x] = -1;
                }
            }

        }

    }

    public static boolean isValid(int[][] grid, int num, int x, int y) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[y][i] == num)
                return false;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][x] == num)
                return false;
        }

        x = x / 3;
        y = y / 3;

        for (int i = x; i < (x + 1) * 3; i++) {
            for (int j = y; j < (y + 1) * 3; j++) {
                if (grid[j][i] == num)
                    return false;
            }
        }

        return true;
    }

}
