package leetcode;

public class SayNumber {
    public static void main(String[] args) {
        System.out.println(SayNumber.countAndSay(19));
    }

    public static String countAndSay(int A) {
        String tmp = "1";

        for (int i = 1; i < A; i++) {
            String nextTmp = "";
            int count = 1;
            for (int idx = 1; idx <= tmp.length(); idx++) {
                if (idx != tmp.length() && tmp.charAt(idx - 1) == tmp.charAt(idx)) {
                    count++;
                } else {
                    nextTmp += count + "" + tmp.charAt(idx - 1);
                    count = 1;
                }
            }
            tmp = nextTmp;
        }

        return tmp;
    }
}

