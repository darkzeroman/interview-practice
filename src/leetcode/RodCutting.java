package leetcode;

import java.awt.*;
import java.util.*;

public class RodCutting {
    public static void main(String[] args) {
        new RodCutting().rodCut(100, new ArrayList<>(Arrays.asList(2, 3, 6, 7, 14, 22, 25, 30, 34, 45, 51, 52, 54, 56, 57, 58, 59, 61, 63, 66, 76, 78)));
    }

    public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer i : B) set.add(i);

        Map<Point, Wrapper> map = new HashMap<>();
        Wrapper w = minCost(0, A, set, map);
//        System.out.println(w.minCost);
//        System.out.println(w.cuts);
        return w.cuts;
    }

    public Wrapper minCost(int start, int end, TreeSet<Integer> set, Map<Point, Wrapper> map) {
        Point p = new Point(start, end);
        if (map.containsKey(p)) return map.get(p);
        if (start >= end) {
            return new Wrapper(0, new ArrayList<>());
        }
//        System.out.println(String.format("%d - %d", start, end));
        int minCost = Integer.MAX_VALUE;
        ArrayList<Integer> minCuts = new ArrayList<Integer>();

        for (Integer i : set.subSet(start, false, end, false)) {
            Wrapper lw = minCost(start, i, set, map);
            Wrapper rw = minCost(i, end, set, map);
            int mC = lw.minCost + rw.minCost;
            if (mC < minCost) {
                minCost = mC;
                minCuts.clear();
                minCuts.add(i);
                minCuts.addAll(lw.cuts);
                minCuts.addAll(rw.cuts);
            }
        }


        Wrapper tmp = new Wrapper((end - start) + ((minCost == Integer.MAX_VALUE) ? 0 : minCost), minCuts);
        map.put(p, tmp);
        return tmp;
    }

    private static class Wrapper {
        int minCost = 0;
        ArrayList<Integer> cuts = new ArrayList<>();

        public Wrapper(int minCost, ArrayList<Integer> cuts) {
            this.minCost = minCost;
            this.cuts = cuts;
        }
    }
}
