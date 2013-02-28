
import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import org.junit.Test;

/**
 * This solution is actually O(n log k), but if we were to always request four
 * elements (the k) it is O(n). I do know of QuickSelect, the "better" solution
 * that is O(n) expected, because of the random approach, but I decided to use
 * this solution instead.
 * 
 * There are JUnit tests below. Usually these would be two separate classes but
 * I merged them together here in the interest of readability.
 * 
 * @author Vidhur Vohra
 * 
 */
public class TopKElementsArray {

	public static int[] topElems(int[] arr, int numOfTop) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (pq.size() < numOfTop) {
				// initially add to PQ until it's full
				pq.add(arr[i]);

			} else if (pq.peek() < arr[i]) {
				// adding to PQ only if new num is bigger
				// than the smallest num in the PQ
				pq.poll();
				pq.add(arr[i]);
			}

		}

		// if PQ is smaller than num of elems requested, return whole PQ
		int numToReturn = pq.size() < numOfTop ? pq.size() : numOfTop;

		// Taking nums out of PQ, because JUnit tests are used
		int[] topElems = new int[numToReturn];
		for (int i = 0; i < topElems.length; i++)
			topElems[i] = pq.poll();

		System.out.println(Arrays.toString(topElems));

		return topElems;

	}

	@Test
	public void topFourElements() {

		// Test cases, shuffles array
		int[] ans = new int[] { 97, 98, 99, 100 };
		int[] arr = new int[] { 1, 2, 3, 4, 5, 97, 98, 99, 100 };

		for (int i = 0; i < 5; i++) {
			shuffleArray(arr);
			assertArrayEquals(ans, topElems(arr, 4));
		}

		// With one duplicate
		ans = new int[] { 97, 99, 99, 100 };
		arr = new int[] { 1, 2, 3, 4, 5, 97, 99, 99, 100 };

		for (int i = 0; i < 5; i++) {
			shuffleArray(arr);
			assertArrayEquals(ans, topElems(arr, 4));
		}

		// Less than requested amount of elements
		ans = new int[] { 99, 100 };
		arr = new int[] { 99, 100 };

		for (int i = 0; i < 5; i++) {
			shuffleArray(arr);
			assertArrayEquals(ans, topElems(arr, 4));
		}

	}

	// used for JUnit tests for random input
	static void shuffleArray(int[] arr) {
		Random random = new Random();

		for (int i = 1; i < arr.length; i++) {
			// randomly choosing index to swap to
			int index = random.nextInt(i);

			// swapping
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}

}
