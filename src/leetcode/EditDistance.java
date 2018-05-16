package leetcode;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("aaa", "aa"));
    }

    public int minDistance(String A, String B) {
        int[][] cost = new int[A.length() + 1][B.length() + 1];

        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                if (i == 0) {
                    cost[i][j] = j;
                    continue;
                } else if (j == 0) {
                    cost[i][j] = i;
                    continue;
                }

                char a = A.charAt(i - 1);
                char b = B.charAt(j - 1);

                if (a == b) {
                    cost[i][j] = cost[i - 1][j - 1];
                } else {
                    // insert, remove, change
                    cost[i][j] = 1 + min(cost[i - 1][j], cost[i][j - 1], cost[i - 1][j - 1]);

                }
            }
        }
        return cost[A.length()][B.length()];
    }

    public int min(int... nums) {
        if (nums.length == 0) {
            return -1;
        }

        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
