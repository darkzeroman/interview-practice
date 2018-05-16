package leetcode;

import java.util.Arrays;
import java.util.List;

public class SortedInsertPosition {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5, 6);
        System.out.println(SortedInsertPosition.searchInsert(list, 2));
    }

    public static int searchInsert(List<Integer> a, int b) {
        int lo = 0, hi = a.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a.get(mid) == b) {
                lo = mid;
                break;
            } else if (b < a.get(mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
