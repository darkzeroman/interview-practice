package bnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindingLakesPartOne {
    public static void main(String[] args) {
//        int[] heights = new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4};
//        System.out.println(printLake(heights, new int[heights.length]));
//        dumpWater(new int[]{5, 4, 2, 1, 2, 3, 2, 1, 0, 1, 2, 4}, 4, 1);
    }

    public static void dumpWater(int[] arr, int waterAmount, int dumpLocation) {
        int[] waterHeight = new int[arr.length];
        for (int i = 0; i < waterAmount; i++) {
            int minLeft = getSmallest(dumpLocation, -1, arr, waterHeight);
            if (minLeft != dumpLocation) {
                waterHeight[minLeft]++;
                continue;
            }

            int minRight = getSmallest(dumpLocation, 1, arr, waterHeight);
            if (minRight != dumpLocation) {
                waterHeight[minRight]++;
                continue;
            }

            waterHeight[dumpLocation]++;
        }

        System.out.println(printLake(arr, waterHeight));
    }

    public static int getSmallest(int index, int offset, int[] arr, int[] waterHeight) {
        int currIndex = index + offset;
        int height = getTotalHeight(arr, waterHeight, 1);
        int minIndex = index;

        while (currIndex >= 0 && currIndex < arr.length && (getTotalHeight(arr, waterHeight, currIndex)) < height) {
            if (getTotalHeight(arr, waterHeight, currIndex) < getTotalHeight(arr, waterHeight, minIndex)) {
                minIndex = currIndex;
            }

            currIndex += offset;
            height = Math.min(height, getTotalHeight(arr, waterHeight, currIndex) + 1);
        }
        return minIndex;
    }

    public static int getTotalHeight(int[] land, int[] water, int index) {
        return land[index] + water[index];
    }

    public static String printLake(int[] input, int[] waterHeight) {
        List<String> rows = new ArrayList<>();
        int max = Arrays.stream(input).max().getAsInt();

        for (int i = 0; i < max + 1; i++) {
            StringBuilder sb = new StringBuilder();

            for (int index = 0; index < input.length; index++) {
                if (input[index] >= 0) {
                    sb.append('+');
                    input[index]--;
                } else if (waterHeight[index] > 0) {
                    sb.append('W');
                    waterHeight[index]--;
                } else {
                    sb.append(' ');
                }
            }

            rows.add(sb.toString());
        }

        Collections.reverse(rows);
        return String.join("\n", rows);
    }


}
