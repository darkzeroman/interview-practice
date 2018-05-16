package leetcode;

import java.util.*;

public class NumCandies {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 2);
        System.out.println(new NumCandies().candy(new ArrayList<>(input)));
    }

    public int candy(ArrayList<Integer> A) {
        int[] candies = new int[A.size()];
        int count = 0;
        PriorityQueue<Integer> indexRank = new PriorityQueue<>(A.size(), Comparator.comparing((a) -> A.get(a)));
        for (int i = 0; i < A.size(); i++) indexRank.add(i);

        while (!indexRank.isEmpty()) {
            int index = indexRank.poll();
            candies[index] = numCandies(candies, index, A);
            count += candies[index];
        }

        return count;
    }

    public int numCandies(int[] candies, int index, List<Integer> A) {
        int max = candies[index];
        if (index - 1 >= 0) {
            if (A.get(index - 1).equals(A.get(index)) && candies[index - 1] > 0) {
                return candies[index - 1];
            }
            max = Math.max(max, candies[index - 1]);
        }
        if (index + 1 < candies.length) {
            if (A.get(index + 1).equals(A.get(index)) && candies[index + 1] > 0) {
                return candies[index + 1];
            }
            ;
            max = Math.max(max, candies[index + 1]);
        }
        return max + 1;
    }
}
