package all;

import java.util.Arrays;

public class MaxEquation {

	public static void main(String[] args) {

		leastCostToMult(new Matrix[] { new Matrix(50, 20), new Matrix(20, 1), new Matrix(1, 10), new Matrix(10, 100) });
		// 2*3+5*3
		// 0: *, 1: +
		maxExpression(new int[] { 10, 2, 3, 1 }, new int[] { 0, 0, 1 });
		int n = 5;
		for (int s = 1; s < n; s++)
			for (int i = 0; i < n - s; i++) {
				int j = i + s;
				System.out.println(i + " " + j);

			}

	}

	public static void maxExpression(int[] operands, int[] operators) {
		int[][] dp = new int[operands.length][operands.length];
		for (int i = 0; i < dp.length; ++i)
			dp[i][i] = operands[i];

		for (int s = 1; s < operands.length; s++) {
			for (int i = 0; i + s < operands.length; ++i) {
				int j = i + s;
				dp[i][j] = Integer.MIN_VALUE;
				for (int k = i; k < j; k++)
					dp[i][j] = Math.max(dp[i][j], operandOperator(dp[i][k], dp[k + 1][j], operators[k]));
			}
		}

		for (int[] arr : dp)
			System.out.println(Arrays.toString(arr));
		System.out.println(dp[0][operands.length - 1]);
	}

	public static int operandOperator(int a, int b, int operator) {
		if (operator == 0)
			return a * b;
		if (operator == 1)
			return a + b;
		System.out.println("Shouldn't be here.");
		return a + b;
	}

	private static class Matrix {
		int r, c;

		public Matrix(int i, int j) {
			// TODO Auto-generated constructor stub
			this.r = i;
			this.c = j;
		}

	}

	public static int leastCostToMult(Matrix mats[]) {
		// Validate mult
		for (int i = 1; i < mats.length; ++i) {
			if (mats[i].r != mats[i - 1].c) {
				return -1;
			}
		}

		int[][] dp = new int[mats.length][mats.length];
		for (int i = 0; i < mats.length; ++i)
			dp[i][i] = 0;

		for (int s = 1; s < mats.length; s++) {
			for (int i = 0; i + s < mats.length; ++i) {
				int j = i + s;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++)
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + mats[i].r * mats[k].c * mats[j].c);

			}
		}

		for (int[] arr : dp)
			System.out.println(Arrays.toString(arr));
		System.out.println(dp[0][mats.length - 1]);
		return dp[0][mats.length - 1];
	}
}
