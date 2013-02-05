package all;
public class ReverseSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "Hello!";

		StringBuffer sb = reverseSection(str);
		int last = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == ' ') {
				reverseSection(sb, last, i - 1);
				last = i + 1;
			} else if (i == sb.length() - 1) {
				reverseSection(sb, last, i);

			}
		}
		System.out.println(sb.toString());

	}

	public static StringBuffer reverseSection(StringBuffer sb, int i, int j) {
		while (i < j) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
		return sb;
	}

	public static StringBuffer reverseSection(StringBuffer sb) {
		reverseSection(sb, 0, sb.length() - 1);
		return sb;
	}

	public static StringBuffer reverseSection(String str) {
		StringBuffer sb = new StringBuffer(str);
		reverseSection(sb, 0, str.length() - 1);
		return sb;
	}

}
