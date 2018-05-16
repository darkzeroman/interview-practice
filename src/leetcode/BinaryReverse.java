package leetcode;

public class BinaryReverse {
    public static void main(String[] args) {
        System.out.println(reverse(3));
    }

    public static long reverse(long a) {
        long ret = 0, mask = 1 << 31, rmask = 1;
        for (int i = 0; i < 32; i++) {
            if ((a & rmask) != 0) {
                ret = ret | mask;
            }
            rmask = rmask << 1;
            mask = mask >> 1;
        }
        return ret;
    }

}
