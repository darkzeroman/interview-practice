package old;

import java.util.Arrays;

public class MaxExpression {

    public static void main(String[] args) {

        // 2*3+5*3
        // 0: *, 1: +
        // maxExpression(new int[] { 10, 2, 3, 1 }, new int[] { 0, 0, 1 });
        maxExpression(new int[]{3, 2, 1}, new int[]{0, 1});

    }

    public static void maxExpression(int[] operands, int[] operators) {
        int[][] dp = new int[operands.length][operands.length];
        for (int i = 0; i < dp.length; ++i)
            dp[i][i] = operands[i];

        for (int s = 1; s < operands.length; s++) {
            for (int i = 0; i + s < operands.length; i++) {
                int j = i + s;
                dp[i][j] = Integer.MIN_VALUE;
                // System.out.println(j + " " + i);
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.max(dp[i][j], applyOperator(dp[i][k], dp[k + 1][j], operators[k]));
            }
        }

        for (int[] arr : dp)
            System.out.println(Arrays.toString(arr));
        System.out.println(dp[0][operands.length - 1]);
    }

    public static int applyOperator(int a, int b, int operator) {
        if (operator == 0)
            return a * b;
        if (operator == 1)
            return a + b;
        System.out.println("Shouldn't be here.");
        return a + b;
    }

}
