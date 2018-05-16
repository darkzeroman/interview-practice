package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkylineProblem {
    public static void main(String[] args) {

        List<int[]> result = new SkylineProblem().getSkyline(new int[][]{
                {2, 9, 10}, {3, 7, 15}, {5, 12, 12}
        });

        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }


    public List<int[]> getSkyline(int[][] buildings) {
        int[][] endBuildings = copyArray(buildings);
        Arrays.sort(buildings, Comparator.comparing(i -> i[0]));
        Arrays.sort(endBuildings, (o1, o2) -> Integer.compare(o2[1], o1[1]));

        ArrayList<int[]> result = new ArrayList<>();

        int currHeight = 0;
        int f = 0, s = 0;

        while (f < buildings.length || s < buildings.length) {
            boolean nextOpen = f < buildings.length && buildings[f][0] <= endBuildings[s][0];

            if (nextOpen) {
                int tmpCurrHeight = Math.max(currHeight, buildings[f][2]);
                if (tmpCurrHeight > currHeight) {
                    currHeight = tmpCurrHeight;
                    if (result.isEmpty()) {
                        result.add(new int[]{buildings[f][0], currHeight});
                    } else if (result.get(result.size() - 1)[0] == buildings[f][0]) {
                        result.get(result.size() - 1)[1] = currHeight;
                    } else {
                        result.add(new int[]{buildings[f][0], currHeight});
                    }
                }
                f++;
            } else {
                int tmpCurrHeight = Math.max(currHeight, endBuildings[s][2]);
                if (tmpCurrHeight < currHeight) {
                    currHeight = tmpCurrHeight;
                    if (result.isEmpty()) {
                        result.add(new int[]{buildings[s][1], currHeight});
                    } else if (result.get(result.size() - 1)[0] == buildings[s][1]) {
                        result.get(result.size() - 1)[1] = currHeight;
                    } else {
                        result.add(new int[]{buildings[s][1], currHeight});
                    }
                }
                s++;
            }
        }


        return result;
    }

    public int[][] copyArray(int[][] buildings) {
        int[][] clone = new int[buildings.length][];

        for (int i = 0; i < buildings.length; i++) {
            clone[i] = Arrays.copyOf(buildings[i], buildings[i].length);
        }

        return clone;
    }

}