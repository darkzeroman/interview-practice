package leetcode;

public class SquareRoot {
    public static void main(String[] args) {
//        System.out.println(sqrt(1));
//        System.out.println(sqrt(2));
        System.out.println(sqrt(4));
        System.out.println(sqrt(7));
        System.out.println(sqrt(10));
        System.out.println(sqrt(2147395599));

    }

    public static int sqrt(int x) {
        long lo = 0, hi = x;

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;

            long tmp = mid * mid;
            if (tmp == x) {
                return (int) mid;
            }

            if (tmp > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }

        }

        return (int) (lo * lo > x ? lo - 1 : lo);
    }

}
