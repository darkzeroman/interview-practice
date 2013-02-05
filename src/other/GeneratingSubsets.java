package other;

import java.util.HashSet;

public class GeneratingSubsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3 };
		for (int i = 0; i <= arr.length; i++) {
			// print(arr, i);
		}
		recSubsets(arr, 0, new StringBuffer(), new HashSet<String>());

	}

	public static void print(int[] arr, int mask) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			if ((1 & mask) == 1) {
				sb.append(arr[i]).append(" ");
			}
			mask = mask >> 1;

		}
		System.out.println(sb.toString());
	}

	public static void recSubsets(int[] arr, int index, StringBuffer sb, HashSet<String> set) {

		if (index >= arr.length)
			return;
		StringBuffer addsb = new StringBuffer(sb);
		StringBuffer noaddsb = new StringBuffer(sb);

		addsb.append(arr[index]);
		recSubsets(arr, index + 1, addsb, set);
		recSubsets(arr, index + 1, noaddsb, set);
		System.out.println(addsb);
		System.out.println(noaddsb);

	}
}
