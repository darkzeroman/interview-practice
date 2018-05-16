package leetcode;

public class NumTrees {
    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(5));
    }

    public int numTrees(int A) {
        int n = A + 1;
        int[] dp = new int[n];
        dp[0] = dp[1] = 1;

        for (int idx = 2; idx < dp.length; idx++) {
            for (int i = 0; i < idx; i++) {
                int left = i, right = idx - i - 1;
                dp[idx] += (dp[left] * dp[right]);
            }
        }

        return dp[A];
    }
}
