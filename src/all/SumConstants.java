package all;
import java.awt.Point;
import java.util.Hashtable;

public class SumConstants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 2, 3, 4, 5, 6, 7, 8, 7 };
		arr = new int[] { -12, -7, -4, 0, 3, 5, 9, 10, 15, 16 };
		sumArrPairsToConstantv1(arr, 15);
	}

	public static void sumArrPairsToConstant(int[] arr, int num) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			ht.put(arr[i], i);
			int complement = num - arr[i];
			if (ht.containsKey(complement)) {
				System.out.println("Indices: " + i + " " + ht.get(complement));
				return;
			}
		}
		System.out.println("No Pairs Sum to Constant");
	}

	public static void sumArrPairsToConstantv1(int[] arr, int num) {
		Hashtable<Integer, Point> ht = new Hashtable<Integer, Point>();

		for (int i = 0; i < arr.length; i++) {
			ht.put(arr[i], new Point(arr[i], i));
			int complement = num - arr[i];

			if (ht.containsKey(complement) && ht.get(complement).y != i) {
				System.out.println(String.format("Indices: %d(=%d) and %d(=%d)", i, arr[i], ht.get(complement).y,
						ht.get(complement).x));
				// return;
			}

		}
		System.out.println("No Pairs Sum To Constant");
	}

}
