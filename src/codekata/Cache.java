package codekata;

import java.util.Arrays;

public class Cache {
	static int[][] cache;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static {
		int size = 8;
		cache = new int[size + 1][size + 1];
		for (int[] row : cache)
			for (int i = 0; i < row.length; i++)
				row[i] = -1;

		for (int i = 0; i < cache.length; i++) {
			cache[1][i] = 0;
			cache[0][i] = i;
			cache[i][0] = i;
		}

		// column 1
		for (int i = 2; i < cache.length; i++)
			cache[i][1] = 1;
		for (int i = 2; i < cache.length; i++)
			if (i % 2 == 0)
				cache[i][2] = 1;
			else
				cache[i][2] = 0;
		for (int i = 2; i < cache.length; i++)
			cache[i][3] = (int) Math.pow(2, i - 2);
		for (int i = 1; i < cache.length; i++)
			if (i % 2 == 1)
				cache[i][4] = 0;
		cache[4][4] = 1;
		cache[6][4] = 47;
		cache[8][4] = 264;

		cache[2][5] = 1;
		cache[3][5] = 4;
		cache[4][5] = 23;
		cache[5][5] = 86;
		cache[6][5] = 397;
		cache[7][5] = 1584;

		cache[2][6] = 1;
		cache[4][6] = 55;
		cache[6][6] = 1770;

		for (int[] arr : cache)
			System.out.println(Arrays.toString(arr));

	}

}
