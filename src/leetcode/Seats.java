package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    public static void main(String[] args) {
        System.out.println(new Seats().seats("....x..xx...x.."));
    }

    public int seats(String A) {
        boolean[] arr = new boolean[A.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'x') {
                arr[i] = true;
                list.add(i);
            }
        }
        if (list.isEmpty()) return 0;

        long count = 0;
        int median = list.get(list.size() / 2);
        int nextOpen = median;
        while (nextOpen < arr.length && arr[nextOpen]) nextOpen++;
        for (int i = median; i < arr.length; i++) {
            if (!arr[i]) continue;
            if (nextOpen < i) {
                arr[nextOpen] = true;
                arr[i] = false;
                count += i - nextOpen;

                while (nextOpen < arr.length && arr[nextOpen]) nextOpen++;
            }
        }

        nextOpen = median;
        while (nextOpen >= 0 && arr[nextOpen]) nextOpen--;
        for (int i = median; i > 0; i--) {
            if (!arr[i]) continue;
            if (nextOpen > i) {
                arr[nextOpen] = true;
                arr[i] = false;
                count += nextOpen - i;

                while (nextOpen < arr.length && arr[nextOpen]) nextOpen--;
            }
        }

        return (int) (count % 10000003);
    }


    // private void find(int[] arr, int start, )
}

