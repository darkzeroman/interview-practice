package smallinterview;

public class AggregateNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean val = ST("122122244112");
		System.out.println(val);
	}

	public static boolean ST(String s) {
		for (int first = 1; first <= s.length() / 2; first++) {
			for (int second = first + 1; second <= (s.length() - first) / 2 + first; second++) {
				if (CK(s.substring(0, first), s.substring(first, second), s.substring(second))) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean CK(String s1, String s2, String rest) {
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		String sum = (i1 + i2) + "";
		if (sum.length() > rest.length()) {
			return false;
		}
		if (sum.equalsIgnoreCase(rest.substring(0, sum.length()))) {
			if (sum.length() == rest.length()) {
				return true;
			}
			return CK(s2, sum, rest.substring(sum.length()));
		}
		return false;
	}
}
