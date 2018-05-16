package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinSearchRange {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 7, 7, 8, 8, 10);
        ArrayList<Integer> integers = new BinSearchRange().searchRange(list, 8);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {

        ArrayList<Integer> range = new ArrayList<>();
        int start = binSearch(a, new LeftSide(b));
        int end = binSearch(a, new RightSide(b));

        if (start == -1 && end == -1) {
            range.add(-1);
            range.add(-1);
        } else {
            if (start == -1) {
                start = 0;
            }

            if (end == -1) {
                end = 0;
            }
            range.add(start);
            range.add(end);
        }
        return range;
    }

    private int binSearch(List<Integer> a, Strategy strategy) {
        int lo = 0, hi = a.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int ret = strategy.compare(a, mid);

            if (ret == 0) {
                return mid;
            } else if (ret < 0) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    private interface Strategy {
        int compare(List<Integer> a, int index);
    }

    private static class LeftSide implements Strategy {
        int target;

        LeftSide(int target) {
            this.target = target;
        }

        @Override
        public int compare(List<Integer> a, int index) {
            int tmp = Integer.compare(target, a.get(index));
            if (tmp != 0) {
                return tmp;
            }

            if (index == 0) {
                return 0;
            }

            if (a.get(index - 1) != target) {
                return 0;
            }

            return -1;
        }
    }

    private static class RightSide implements Strategy {
        int target;

        RightSide(int target) {
            this.target = target;
        }

        @Override
        public int compare(List<Integer> a, int index) {
            int tmp = Integer.compare(target, a.get(index));
            if (tmp != 0) {
                return tmp;
            }

            if (index == a.size() - 1) {
                return 0;
            }

            if (a.get(index + 1) != target) {
                return 0;
            }

            return 1;
        }
    }
}

