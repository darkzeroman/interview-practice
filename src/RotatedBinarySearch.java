public class RotatedBinarySearch {

	public static void main(String[] args) {
		System.out.println(recCall(new int[] { 4, 5, 1, 2, 3 }, 0, 4, 4));
		System.out.println(binSearch(new int[] { 1, 2, 3, 4, 5 }, 0, 4, 5));
	}

	/** Binary search for an element in a rotated array */
	public static int recCall(int[] arr, int left, int right, int target) {
		int mid = left + (right - left) / 2;
		if (arr[mid] == target)
			return mid;

		if (arr[left] <= arr[mid]) {
			if (arr[left] <= target && target <= arr[mid])
				return recCall(arr, left, mid - 1, target);
			else
				return recCall(arr, mid + 1, right, target);
		} else {// (arr[mid] < arr[right]){
			if (arr[mid] <= target && target <= arr[right])
				return recCall(arr, mid + 1, right, target);
			else
				return recCall(arr, left, mid - 1, target);
		}
	}

	public static int binSearch(int[] arr, int left, int right, int target) {
		int mid = left + (right - left) / 2;

		if (arr[mid] == target) {
			return mid;
		} else if (target < arr[mid]) {
			return binSearch(arr, left, mid - 1, target);

		} else { // right half
			return binSearch(arr, mid + 1, right, target);
		}

	}
}
