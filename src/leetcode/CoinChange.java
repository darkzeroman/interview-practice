package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int num = new CoinChange().coinchange2(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), 4);
        System.out.println(num);
    }

    public int coinchange2(ArrayList<Integer> A, int B) {
        int[] dp = new int[B + 1];

        for (int i = 1; i < dp.length; i++) {
            int numWays = 0;
            for (int coin : A) {
                if (i == coin) {
                    numWays++;
                } else if (i - coin > 0 && dp[i - coin] > 0) {
                    numWays += dp[i - coin];
                }
            }
            dp[i] = numWays % 1000007;
        }

        return dp[B];
    }
}