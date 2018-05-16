package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixPrint {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        result.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
        result.add(new ArrayList<Integer>(Arrays.asList(7, 8, 9)));

        diagonal(result);
    }

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (A.isEmpty()) {
            return results;
        }

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                int index = i + j;
                if (index + 1 >= results.size()) {
                    results.add(new ArrayList<>());
                }
                results.get(index).add(A.get(i).get(j));
            }
        }
        return results;
    }
}
