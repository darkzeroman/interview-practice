package leetcode;

import java.util.Arrays;

public class ScrambleString {
    public static void main(String[] args) {
        int tmp = new ScrambleString().isScramble("great", "rgeat");
        System.out.println(tmp);
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int isScramble(final String A, final String B) {
        int n = A.length();
        if (A.length() != B.length()) return 0;
        if (!sortedString(A).equals(sortedString(B))) return 0;
        if (A.equals(B)) {
            return 1;
        }

        for (int i = 1; i < n; i++) {
            if (isScramble(A.substring(0, i), B.substring(0, i)) == 1 && 1 == isScramble(A.substring(i), B.substring(i)))
                return 1;
            if (isScramble(A.substring(0, i), B.substring(n - i)) == 1 && 1 == isScramble(A.substring(i), B.substring(0, n - i)))
                return 1;
        }
        return 0;
    }

    public String sortedString(String str) {
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

}
