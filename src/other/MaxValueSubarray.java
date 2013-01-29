package other;
import java.util.Arrays;

public class MaxValueSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 4, 5, -9, 1, 4, -100, 50, 6 };
		// Ti = max (Ti-1 + Ai, Ai)

		int[] T = new int[arr.length];
		T[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (T[i - 1] + arr[i] > arr[i])
				T[i] = T[i - 1] + arr[i];
			else
				T[i] = arr[i];

		}
		System.out.println(Arrays.toString(T));
	}
}
