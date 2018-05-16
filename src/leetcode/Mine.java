package leetcode;

public class Mine {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        // me: 1,3,1
        // them: 4,2

        // me: 1, 3, 1
        // them: 2, 4
//        System.out.println(maxCoins(arr, 0, arr.length - 1));
    }

    public static int maxCoins(int[] arr, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return arr[start];
        }
        int x = arr[start] + Math.min(maxCoins(arr, start + 2, end), maxCoins(arr, start + 1, end - 1));
        int y = arr[end] + Math.min(maxCoins(arr, start + 1, end - 1), maxCoins(arr, start, end - 2));
        return Math.max(x, y);
    }
}
