

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Reverses the words in order in a sentence. */
public class ReverseSentence {

	public static void main(String[] args) {
		String str = "Hello! Test";

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

	private static StringBuffer reverseSection(StringBuffer sb, int i, int j) {
		while (i < j) {
			char temp = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(j));
			sb.setCharAt(j, temp);
			i++;
			j--;
		}
		return sb;
	}

	private static StringBuffer reverseSection(String str) {
		StringBuffer sb = new StringBuffer(str);
		reverseSection(sb, 0, str.length() - 1);
		return sb;
	}

	@Test
	public void testReverseSectionString() {
		String str = "Test";
		assertEquals(new StringBuffer(str).reverse().toString(), ReverseSentence.reverseSection(str).toString());

		str = "ahahahhaha";
		assertEquals(new StringBuffer(str).reverse().toString(), ReverseSentence.reverseSection(str).toString());

		str = "  Hello  ";
		assertEquals(new StringBuffer(str).reverse().toString(),
				ReverseSentence.reverseSection(new StringBuffer(str), 2, 6).toString());

	}

}
