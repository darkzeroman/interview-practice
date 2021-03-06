/**
 * 
 */
package algorithms.sorts;

/**
 * @author dkz
 * 
 */
public class CountingSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] unsortedArr = new int[] { 1, 2, 3, 4, 2, 3, 4, 1, 3 };
		sort(unsortedArr, 5);
		Array.printArr(unsortedArr);
	}

	public static int[] sort(int[] arr, int range) {
		countingSort(arr, range);
		return arr;
	}

	private static void countingSort(int[] arr, int range) {
		int[] bucket = new int[range];
		for (int i = 0; i < arr.length; i++)
			bucket[arr[i]]++;

		int index = 0;
		for (int i = 0; i < bucket.length; i++)
			while (bucket[i] > 0) {
				arr[index] = i;
				bucket[i]--;
				index++;
			}

	}
}
