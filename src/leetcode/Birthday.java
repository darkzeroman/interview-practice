package leetcode;

import java.util.*;

public class Birthday {
    public static void main(String[] args) {
        System.out.println(new Birthday().solve(3682, new ArrayList<>(Arrays.asList(
                13511, 9286, 6132, 2958, 21799, 5160, 22244, 5969, 14955, 12808, 3456, 11238, 6511, 4637, 2558, 18808, 15537, 5598, 14022, 4885, 17572, 3775, 23999, 21993, 22203, 24768, 22045, 10785, 11393, 7080, 12218, 16247, 7709
        ))));
    }

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        int min = B.get(0), minIndex = 0;
        for (int i = 1; i < B.size(); i++) {
            if (B.get(i) < min) {
                min = B.get(i);
                minIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A / min; i++) {
            result.add(minIndex);
        }
        if (result.isEmpty()) return new ArrayList<>();

        List<Integer> newS = B.subList(0, minIndex);
        PriorityQueue<Integer> pq = new PriorityQueue<>(result.size(), Comparator.comparing(B::get));
        int total = 0;
        for (Integer i : result) {
            pq.add(i);
            total += B.get(i);
        }

        for (int i = 0; i < newS.size(); i++) {
            int num = newS.get(i);
            if (total - B.get(pq.peek()) + num <= A) {
                total -= B.get(pq.peek());
                total += num;
                pq.poll();
                pq.offer(i);
            }
        }

        ArrayList<Integer> tmp = new ArrayList<>(pq);
        Collections.sort(tmp);
        return tmp;
    }

}
