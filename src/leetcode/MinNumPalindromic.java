package leetcode;

public class MinNumPalindromic {
    public static void main(String[] args) {
        MinNumPalindromic m = new MinNumPalindromic();
        System.out.println(m.solve("ananabc"));
    }

    public int solve(String A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= A.length() / 2; i++) {
            min = Math.min(min, minRequired(A, i, i));
            if (i != A.length() / 2) {
                min = Math.min(min, minRequired(A, i, i + 1));
            }
        }

        return min;
    }

    public int minRequired(String str, int left, int right) {
        while (true) {
            if (right == str.length()) {
                return left + 1;
            }

            if (str.charAt(left) != str.charAt(right)) {
                return Integer.MAX_VALUE;
            }

            if (left == 0) {
                return str.length() - right - 1;
            }

            left--;
            right++;
        }
    }
    // babb
}
