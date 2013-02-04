package codekata;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(binSearchIterative(5, new int[] { 5, 6, 7, 8, 9, 10 }));
		System.out.println(binSearchRec(5, new int[] { 1, 2, 3, 4, 5 }, 0, 5));
	}

	public static int binSearchIterative(int num, int[] arr) {
		int lower = 0;
		int higher = arr.length - 1;

		while (lower <= higher) {
			int mid = lower + (higher - lower) / 2;
			if (arr[mid] == num)
				return mid;
			else if (arr[mid] > num)
				higher = mid - 1;
			else
				lower = mid + 1;
		}

		return -1;
	}

	public static int binSearchRec(int num, int[] arr, int lower, int higher) {
		if (lower > higher)
			return -1;
		int mid = lower + (higher - lower) / 2;
		if (arr[mid] == num)
			return mid;
		else if (arr[mid] > num)
			return binSearchRec(num, arr, lower, mid - 1);
		else
			return binSearchRec(num, arr, mid + 1, higher);

	}
}
