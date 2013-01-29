package codekata;

public class ParenthesisValid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// isValid(new StringBuffer("())"));
		validPerms(1);

	}

	public static void isValid(StringBuffer str) {
		int openParenths = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(')
				openParenths++;
			else if (str.charAt(i) == ')')
				openParenths--;
			if (openParenths < 0)
				break;

		}
		if (openParenths == 0)
			System.out.println("true");
		else
			System.out.println("false");
	}

	public static void validPerms(int num) {
		recCall(new StringBuffer(), 0, 0, 6);
	}

	public static void recCall(StringBuffer sb, int index, int open, int maxL) {
		if (open < 0)
			return;
		if (index == maxL) {
			if (open == 0)
				System.out.println(sb.toString());
			return;
		}

		recCall(sb.append('('), index + 1, open + 1, maxL);
		sb.deleteCharAt(sb.length() - 1);
		recCall(sb.append(')'), index + 1, open - 1, maxL);
		sb.deleteCharAt(sb.length() - 1);

	}
}
