package leetcode;

import java.util.*;

public class ParenthesisBinary {
    public static void main(String[] args) {
        ParenthesisBinary pB = new ParenthesisBinary();
        System.out.println(pB.largest("(( ( (()()) (()) ) ))"));
    }

    public String largest(String input) {
        Stack<List<String>> stack = new Stack<>();
        stack.push(new ArrayList<>());
        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (ch == '(') {
                stack.push(new ArrayList<>());
            } else {
                List<String> strs = stack.pop();
                strs.sort(Comparator.naturalOrder());
                Collections.reverse(strs);
                stack.peek().add("1" + String.join("", strs) + "0");
            }
        }
        return stack.pop().get(0);
    }

    public static class Node {
        boolean isRoot = false;
        List<Node> children = new ArrayList<>();

        public String toString() {
            List<String> childStrs = new ArrayList<>();

            for (Node child : children) {
                childStrs.add(child.toString());
            }

            childStrs.sort(Comparator.comparing((String str) -> str));
            String joinStr = String.join("", childStrs);
            if (isRoot) {
                return joinStr;
            } else {
                return "1" + joinStr + "0";
            }
        }

    }

}
