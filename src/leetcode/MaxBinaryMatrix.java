package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxBinaryMatrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = toList(Arrays.asList(1, 1), Arrays.asList(0, 0));
        System.out.println(new MaxBinaryMatrix().maximalRectangle(list));
    }

    public static ArrayList<ArrayList<Integer>> toList(List<Integer>... rows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (List<Integer> row : rows) {
            list.add(new ArrayList<>(row));
        }
        return list;
    }

    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int[][][] dp = new int[A.size() + 1][A.get(0).size() + 1][2];

        int maxSeen = Integer.MIN_VALUE;
        for (int y = 1; y < dp.length; y++) {
            for (int x = 1; x < dp[y].length; x++) {
                int[] leftSide = dp[y][x - 1];
                int[] topSide = dp[y - 1][x];
                if (A.get(y - 1).get(x - 1) != 1) continue;
                int width = Math.min(topSide[0], leftSide[0] + 1);
                int height = Math.min(topSide[1] + 1, leftSide[1]);
                width = Math.max(1, width);
                height = Math.max(1, height);
                dp[y][x] = new int[]{width, height};
                maxSeen = Math.max(maxSeen, dp[y][x][0] * dp[y][x][1]);
            }
        }
        return maxSeen;
    }
}
