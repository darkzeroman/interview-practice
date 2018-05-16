package leetcode;

import java.util.*;

class NumIslands {
    private int[][] offsets = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        System.out.println(new NumIslands().numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));
    }

    private List<Integer> numIslands2(int m, int n, int[][] positions) {
        Map<Integer, Integer> union = new HashMap<>();

        int[][] grid = new int[m][n];
        int max = 1;
        List<Integer> result = new ArrayList<>();
        int currNumIslands = 0;
        for (int[] position : positions) {
            List<Integer> roots = findRoots(union, connections(grid, position[0], position[1]));
            Collections.sort(roots);
            int islandIdx = -1;
            if (!roots.isEmpty()) {
                for (int i = 1; i < roots.size(); i++) {
                    currNumIslands--;
                    union.put(roots.get(i), roots.get(0));
                }
            } else {
                currNumIslands++;
                islandIdx = max;
                max++;
            }
            grid[position[0]][position[1]] = islandIdx;

            result.add(currNumIslands);
        }

        return result;
    }

    public List<Integer> findRoots(Map<Integer, Integer> union, List<Integer> nums) {
        Set<Integer> result = new HashSet<>();
        for (int num : nums) {
            while (union.containsKey(num)) {
                num = union.get(num);
            }
            result.add(num);
        }
        return new ArrayList<>(result);
    }

    private List<Integer> connections(int[][] grid, int y, int x) {
        List<Integer> result = new ArrayList<>();
        for (int[] offset : offsets) {
            int newX = x + offset[0];
            int newY = y + offset[1];
            if (!isInRange(newY, 0, grid.length) || !isInRange(newX, 0, grid[y].length)) {
                continue;
            }
            if (grid[newY][newX] != 0) {
                result.add(grid[newY][newX]);
            }
        }
        return result;
    }

    public boolean isInRange(int num, int start, int end) {
        return start <= num && num < end;
    }
}