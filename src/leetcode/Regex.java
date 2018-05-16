package leetcode;

public class Regex {
    public static void main(String[] args) {
        System.out.println(isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "a*"));
    }

    public static int isMatch(final String A, final String B) {
        if (A.length() == 0 || B.length() == 0) {
            return A.length() == B.length() ? 1 : 0;
        }

        char ch = B.charAt(0);
        if (ch == '?') {
            return isMatch(A.substring(1), B.substring(1));
        } else if (ch == '*') {
            int isMatch = 0;
            for (int i = 0; i <= A.length(); i++) {
                isMatch = Math.max(isMatch, isMatch(A.substring(i), B.substring(1)));
            }
            return isMatch;
        } else if (ch == A.charAt(0)) {
            return isMatch(A.substring(1), B.substring(1));
        }
        return 0;
    }
}
