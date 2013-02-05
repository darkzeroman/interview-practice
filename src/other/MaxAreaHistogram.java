package other;

import java.util.Arrays;

public class MaxAreaHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] histogram = new int[] { 1, 6, 1, 1, 1, 1 };
		System.out.println(divConq(histogram));
	}

	public static int divConq(int[] subhistogram) {
		int div = findLowestValue(subhistogram);
		int max = Integer.MIN_VALUE;

		if (subhistogram.length == 0)
			return max;

		if (subhistogram.length > 1) {
			int[] sub1 = Arrays.copyOfRange(subhistogram, 0, div);
			int[] sub2 = Arrays.copyOfRange(subhistogram, div + 1,
					subhistogram.length);

			max = Math.max(max, divConq(sub1));
			max = Math.max(max, divConq(sub2));
			max = Math.max(subhistogram.length * subhistogram[div], max);
		} else
			max = subhistogram[0];
		return max;
	}

	public static int findLowestValue(int[] subhistogram) {
		int minIndex = 0;
		for (int i = 0; i < subhistogram.length; i++) {
			minIndex = (subhistogram[minIndex] > subhistogram[i]) ? i
					: minIndex;

		}
		return minIndex;
	}
}
