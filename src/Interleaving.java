
import java.util.ArrayList;
import java.util.List;

public class Interleaving {

	/**
	 * Returns a list containing all possible interleavings of two strings. The
	 * order of the characters within the strings is preserved.
	 */
	public static List<String> interleave(String a, String b) {
		List<String> result = new ArrayList<String>();
		if (a.isEmpty())
			result.add(b);
		else if (b.isEmpty())
			result.add(a);
		else
			for (int i = 0; i <= a.length(); i++) {
				char c = b.charAt(0);
				String ls = a.substring(0, i);
				String rs = a.substring(i);

				for (String s : interleave(rs, b.substring(1)))
					result.add(ls + c + s);
			}
		return result;
	}

	/**
	 * Prints some example interleavings to stdout.
	 */
	public static void main(String[] args) {
		System.out.println(interleave("", ""));
		System.out.println(interleave("a", ""));
		System.out.println(interleave("", "1"));
		System.out.println(interleave("a", "1"));
		System.out.println(interleave("ab", "1"));
		System.out.println(interleave("ab", "12"));
		System.out.println(interleave("abc", "12"));
		System.out.println(interleave("ab", "1234"));
		System.out.println();
		System.out.println(interleave("2", ""));
		System.out.println(interleave("2", "c"));
		System.out.println(interleave("2", "bc"));
		System.out.println(interleave("2", "abc"));
		System.out.println(interleave("ab", "12"));
		
		
		
		
		
	}
}