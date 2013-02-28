import java.util.HashSet;

public class LongestUniqueSubString {

	public static void main(String[] args) {
		System.out.println(findMaxUniqueSubstr("aabcd"));
		System.out.println(subOptimalSolution("aabcd"));

	}

	/** Linear solution */
	public static int findMaxUniqueSubstr(String str) {
		HashSet<Character> hs = new HashSet<Character>();
		int i = 0, j = 0;
		int max = Integer.MIN_VALUE;

		while (j < str.length() && i <= j) {
			if (hs.contains(str.charAt(j))) {
				max = Math.max(max, hs.size());
				while (str.charAt(i) != str.charAt(j)) {
					hs.remove(str.charAt(i));
					i++;
				}
				i++;
			}
			hs.add(str.charAt(j));
			j++;
		}

		max = Math.max(max, hs.size());
		return max;
	}

	/** Suboptimal O(n^2) solution */
	public static int subOptimalSolution(String str) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++)
				max = Math.max(max, checkUnique(str.substring(i, j)));
		}
		return max;
	}

	public static int checkUnique(String str) {
		if (str.length() == 0)
			return 0;
		HashSet<Character> hs = new HashSet<Character>();

		for (int i = 0; i < str.length(); i++) {
			if (!hs.add(str.charAt(i))) {
				return 0;
			}
		}
		return str.length();
	}
}
