package leetcode;

import java.util.*;

public class AlienOrder {

    // Not done
    public static void main(String[] args) {
        System.out.println(new AlienOrder().alienOrder(new String[]{"ab", "adc"}));
    }

    public String alienOrder(String[] words) {
        Map<Character, CharOrder> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < words.length - 1; i++) add(words[i], words[i + 1], map, set);
        StringBuilder sb = new StringBuilder();
        for (Character ch : set) {
            if (!map.containsKey(ch)) {
                sb.append(ch);
            }
        }
        String str = topologicalSort(map);
        return (str == null ? "" : str); // + sb.toString();
    }

    public void add(String s1, String s2, Map<Character, CharOrder> map, Set<Character> set) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            addToMap(map, ch1, ch2, set);

            if (ch1 == ch2) {
                for (int j = i; j < s2.length(); j++) {
                    addToMap(map, ch1, s2.charAt(j), set);
                }
            }
        }
    }

    public void addToMap(Map<Character, CharOrder> map, char ch1, char ch2, Set<Character> set) {
        set.add(ch1);
        set.add(ch2);

        if (!map.containsKey(ch1)) {
            map.put(ch1, new CharOrder(ch1));
        }

        if (ch1 == ch2) {
            return;
        }

        if (!map.containsKey(ch2)) {
            map.put(ch2, new CharOrder(ch2));
        }

        if (map.get(ch1).next.add(ch2)) map.get(ch2).in++;


    }

    public String topologicalSort(Map<Character, CharOrder> map) {
        StringBuilder sb = new StringBuilder();
        List<CharOrder> list = new ArrayList<>(map.values());
        while (!list.isEmpty()) {
            list.sort(Comparator.comparingInt(o -> o.in));
            CharOrder charOrder = list.remove(0);
            if (charOrder.in == 0) {
                sb.append(charOrder.ch);
                for (Character ch : charOrder.next) {
                    map.get(ch).in--;
                }
            } else {
                return null;
            }
        }

        return sb.toString();
    }

    private static class CharOrder {
        char ch;
        int in;
        Set<Character> next = new HashSet<>();

        public CharOrder(char ch) {
            this.ch = ch;
        }
    }
}
