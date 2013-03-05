/** Auto adjust the number of elements in a row so only 3 rows are used */
public class PrintThreeRows {

	public static void main(String[] args) {
		printThreeRows("abcdefgh".toCharArray());
		System.out.println("\n");
		printThreeRows("abcdefghis".toCharArray());
	}

	public static void printThreeRows(char[] strArr) {

		int numElems = Math.round((strArr.length + 1) / (float) 3);
		int count = 0;
		while (count < strArr.length) {
			System.out.print(strArr[count]);
			count++;
			if (count % numElems == 0) {
				System.out.println();
			}
		}
	}

}
