package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();

        helper(results, new ArrayList<>(), 1, A + 1, B);
        Collections.reverse(results);
        return results;
    }

    public void helper(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list, int curr, int n, int k) {
        if (list.size() == k) {
            results.add(new ArrayList<>(list));
            return;
        }
        if (curr == n) {
            return;
        }

        helper(results, list, curr + 1, n, k);
        list.add(curr);
        helper(results, list, curr + 1, n, k);
        list.remove(list.size() - 1);

    }

    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

        @Override
        public int compare(List<T> o1, List<T> o2) {
            for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                int c = o1.get(i).compareTo(o2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(o1.size(), o2.size());
        }

    }
}

