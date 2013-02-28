

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	static Random random = new Random();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedArr = new int[] { 3, 5, 1, 9, 4, 8, 6, 10 };
		sort(unsortedArr);
		System.out.println(Arrays.toString(unsortedArr));
	}

	public static void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] input, int low, int high) {
		if (low < high) {
			int pivot = partition(input, low, high);
			quickSort(input, low, pivot);
			quickSort(input, pivot + 1, high);

		}

	}

	public static int partition(int[] arr, int left, int right) {
		int pivot = random.nextInt(right - left) + left;
		swapIndices(arr, pivot, right);

		int sorted = left;
		for (int i = left; i < right; i++) {
			if (arr[i] <= arr[right]) {
				swapIndices(arr, i, sorted);
				sorted++;
			}
		}

		swapIndices(arr, sorted, right);

		return sorted;
	}

	static void swapIndices(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
