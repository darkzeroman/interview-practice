package all;

public class CharToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		stringToInt("401");
	}

	public static void stringToInt(String str) {
		int num = 0;
		char[] buff = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			int digit = Character.getNumericValue(buff[buff.length - 1 - i]);
			num += digit * Math.pow(10, i);
			System.out.println(digit);
		}
		System.out.println(num);
	}
}
