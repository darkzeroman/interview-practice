package leetcode;

class DivideNumbers {
    public static void main(String[] args) {
        System.out.println(divide(-10, 1));
    }

    public static int divide(int dividend, int divisor) {
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);
        long count = 0;
        long curr = 0;
        while (curr + divisorLong <= dividendLong) {
            count++;
            curr += divisorLong;
        }

        return (int) (isNeg ? -1 * count : count);
    }
}