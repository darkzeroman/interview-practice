package old;

import java.util.Arrays;

public class MinCostMatrixMultiplication {

    /**
     * @param args
     */
    public static void main(String[] args) {
        leastCostToMult(new Matrix[]{new Matrix(50, 20), new Matrix(20, 1), new Matrix(1, 10), new Matrix(10, 100)});

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

    private static class Matrix {
        int r, c;

        public Matrix(int i, int j) {
            // TODO Auto-generated constructor stub
            this.r = i;
            this.c = j;
        }

    }

}
