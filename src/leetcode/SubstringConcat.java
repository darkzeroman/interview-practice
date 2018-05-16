package leetcode;

import java.util.*;

public class SubstringConcat {
    public static void main(String[] args) {

        for (Integer integer : findSubstring("barfoothefoobarman", Arrays.asList("foo", "bar"))) {
            System.out.println(integer);
        }
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<String, Integer> counter = new HashMap<>();

        if (B.isEmpty()) {
            return list;
        }
        int l = B.get(0).length();
        for (int i = 0; i < A.length(); i++) {
            counter.clear();
            for (String str : B) {
                counter.put(str, 1 + counter.getOrDefault(str, 0));
            }

            int idx = i;
            while (idx + l <= A.length() && counter.containsKey(A.substring(idx, idx + l))) {
                String str = A.substring(idx, idx + l);
                counter.put(str, counter.get(str) - 1);
                if (counter.get(str) == 0) {
                    counter.remove(str);
                }
                idx += l;
                if (counter.isEmpty()) {
                    list.add(i);
                    break;
                }
            }
        }

        return list;
    }
}
