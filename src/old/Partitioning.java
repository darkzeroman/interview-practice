package old;

public class Partitioning {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int ret1 = findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 3);

        System.out.print(ret1);
    }

    static int findMax(int A[], int k) {
        int[][] L = new int[k + 1][A.length + 1];
        int[] cum = new int[A.length + 1];

        cum[0] = A[0];
        for (int i = 1; i < cum.length; i++)
            cum[i] = cum[i - 1] + A[i - 1];

        // initial conditions
        for (int i = 0; i < L[0].length; i++)
            L[1][i] = cum[i];
        for (int i = 0; i < L.length; i++)
            L[i][1] = A[0];

        for (int i = 2; i <= A.length; i++)
            for (int j = 2; j <= k; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= i; p++) {
                    best = Math.min(best,
                            Math.max(L[j - 1][p], cum[i] - cum[p]));
                }
                L[j][i] = best;
            }
        return L[k][A.length];

    }

    static int find(int A[], int k) {
        int[][] L = new int[k + 1][A.length + 1];
        int[] cum = new int[A.length + 1];

        cum[0] = A[0];
        for (int i = 1; i < cum.length; i++)
            cum[i] = cum[i - 1] + A[i - 1];

        // initial conditions
        for (int i = 0; i < L[0].length; i++)
            L[1][i] = cum[i];
        for (int i = 0; i < L.length; i++)
            L[i][1] = A[0];

        for (int i = 2; i <= A.length; i++)
            for (int j = 2; j <= k; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= i; p++) {
                    best = Math.min(best,
                            Math.max(L[j - 1][p], cum[i] - cum[p]));
                }
                L[j][i] = best;
            }
        return L[k][A.length];

    }

    int GetMax(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }

        }

        int[] rank = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            rank[arr[i]] = arr[i];
        }

        int maxDiff = 0;
        int first = 0;
        int diff = 0;
        for (int i = 0; i < rank.length; i++) {
            if (rank[i] != 0) {
                diff = rank[i] - first;

                if (diff > maxDiff) {
                    maxDiff = diff;
                }

                first = rank[i];

            }
        }
        return maxDiff;

    }
}
