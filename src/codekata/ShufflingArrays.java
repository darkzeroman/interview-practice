package codekata;

import java.util.Arrays;
import java.util.Random;

public class ShufflingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };
		for (int i = 0; i < arr.length; i++)
			swap(arr, i, random.nextInt(arr.length));

		System.out.println(Arrays.toString(arr));
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
