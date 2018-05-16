package leetcode;

public class AnyTwo {
    public static void main(String[] args) {
        int tmp = new AnyTwo().anytwo("abab");
        System.out.println(tmp);
    }

    public int anytwo(String A) {
        String aRev = new StringBuilder(A).reverse().toString();
        int n = A.length() + 1;
        boolean[][] dp = new boolean[n][n];

        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[row].length; col++) {
                boolean b = dp[row][col - 1] || dp[row - 1][col];
                if (row != col && aRev.charAt(row - 1) == aRev.charAt(col - 1)) {
                    b = b || dp[row - 1][col - 1];
                }
                dp[row][col] = b;
            }
        }

        return dp[n - 1][n - 1] ? 1 : 0;
    }
}
