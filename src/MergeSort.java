/**
 * 
 */


import java.util.Arrays;

/**
 * @author 01
 * 
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 3, 4, 2, 6, 7, 1, 10 };
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] sort(int[] arr) {
		int[] helper = new int[arr.length];
		mergeSort(arr, helper, 0, arr.length);
		return arr;
	}

	private static void mergeSort(int[] arr, int[] helper, int left, int right) {
		if (right - left <= 1)
			return;
		int mid = left + (right - left + 1) / 2;

		mergeSort(arr, helper, left, mid);
		mergeSort(arr, helper, mid, right);
		merge(arr, helper, left, right, mid);

	}

	private static void merge(int[] arr, int[] aux, int l, int r, int mid) {
		int a = l, b = mid, arrIndex = l;
		for (int i = l; i < r; i++) {
			aux[i] = arr[i];
		}

		while (a < mid && b < r) {
			if (aux[a] < aux[b]) {
				arr[arrIndex++] = aux[a++];
			} else {
				arr[arrIndex++] = aux[b++];
			}
		}
		while (a < mid)
			arr[arrIndex++] = aux[a++];
		while (b < r)
			arr[arrIndex++] = aux[b++];

	}
}