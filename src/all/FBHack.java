package all;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FBHack {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			printAnswer(i, br.readLine());
		}
	}

	public static void printAnswer(int n, String str) {
		long ans = calculate(str);
		System.out.println(String.format("Case #%d: %d", n + 1, ans));
	}

	public static long calculate(String str) {
		str = removeNonLetters(str).toLowerCase();

		if (str.length() == 0)
			return 0;

		int[] bucketCount = bucketCountLetters(str);
		Arrays.sort(bucketCount);
		long sum = 0;
		for (int i = 0; i < bucketCount.length; i++) {
			sum += bucketCount[i] * (i + 1);
		}

		return sum;
	}

	public static String removeNonLetters(String str) {
		return str.replaceAll("[^A-Za-z0-9]", "");
	}

	public static int[] bucketCountLetters(String str) {
		int[] ret = new int[26];
		char[] buff = str.toCharArray();
		for (int i = 0; i < buff.length; i++) {
			ret[charToInt(buff[i])]++;
		}

		return ret;

	}

	public static int charToInt(char ch) {
		return Character.getNumericValue(ch) - 10;
	}
}
