package codekata;

public class BuySell {
	public BuySell() {

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 4, 1, 2, 4 };

		int min = 0;
		int maxprofit = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - arr[min] > maxprofit) {
				maxprofit = arr[i] - arr[min];
			}
			if (arr[i] < arr[min])
				min = i;
		}

		System.out.println(maxprofit);
	}
}
