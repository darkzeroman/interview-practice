package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NodeDistance {
    public static void main(String[] args) {
        System.out.println(new NodeDistance().solve(new ArrayList<>(Arrays.asList(-1, 0, 0, 0, 3))));
    }

    public int solve(ArrayList<Integer> A) {
        List<int[]> arr = A.stream().map(i -> new int[2]).collect(Collectors.toList());
        // largestDistance, maxDistance

        int maxDistance = 0;

        for (int i = A.size() - 1; i > 0; i--) {
            int elem = A.get(i);

            int[] parent = arr.get(elem);
            int currentLength = arr.get(i)[0] + 1;

            parent[1] = Math.max(parent[1], parent[0] + currentLength);
            parent[0] = Math.max(parent[0], currentLength);
            maxDistance = Math.max(maxDistance, parent[1]);
        }

        return maxDistance;
    }
}
