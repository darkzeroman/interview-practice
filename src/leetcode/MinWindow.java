package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MinWindow {
    public static void main(String[] args) {
        System.out.println(minWindow("aa", "aa"));
    }

    public static String minWindow(String S, String T) {
        if (T.length() == 0) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        for (char ch : T.toCharArray()) {
            set.add(ch);
        }

        Map<Character, Integer> map = new HashMap<>();
        int length = 0;
        String minStr = null;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (set.contains(ch)) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            length++;

            if (map.size() == T.length()) {
                while (true) {
                    char tmp = S.charAt(i - length + 1);
                    if (!set.contains(tmp)) {
                        length--;
                        continue;
                    }
                    if (map.get(tmp) > 1) {
                        map.put(tmp, map.get(tmp) - 1);
                        length--;
                    } else {
                        break;
                    }
                }
                if (minStr == null) {
                    minStr = S.substring(i - length + 1, i + 1);
                } else if (length < minStr.length()) {
                    minStr = S.substring(i - length + 1, i + 1);
                }
            }
        }
        return minStr;
    }
}