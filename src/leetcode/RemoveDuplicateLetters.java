package leetcode;

import java.util.*;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("abacb"));
    }

    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            map.put(ch, map.get(ch) - 1);

            if (set.contains(ch)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && map.get(stack.peek()) >= 1) {
                set.remove(stack.pop());
            }


            stack.push(ch);
            set.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : new ArrayList<>(stack)) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
