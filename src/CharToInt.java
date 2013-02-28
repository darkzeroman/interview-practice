

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/** Turns a string into an integer */
public class CharToInt {

	public static int stringToInt(String str) {
		int num = 0;
		char[] buff = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			int digit = Character.getNumericValue(buff[buff.length - 1 - i]);
			num += digit * Math.pow(10, i);
			// System.out.println(digit);
		}
		return num;
	}

	@Test
	public void testCases() {
		assertEquals(401, stringToInt("401"));
		assertEquals(0, stringToInt("0"));
		assertEquals(10, stringToInt("10"));
	}
}
