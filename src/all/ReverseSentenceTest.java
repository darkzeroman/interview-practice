package all;
import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseSentenceTest {

	@Test
	public void testReverseSectionString() {
		String str = "Test";
		assertEquals(new StringBuffer(str).reverse().toString(),
				ReverseSentence.reverseSection(str).toString());

		str = "ahahahhaha";
		assertEquals(new StringBuffer(str).reverse().toString(),
				ReverseSentence.reverseSection(str).toString());

		str = "  Hello  ";
		assertEquals(new StringBuffer(str).reverse().toString(),
				ReverseSentence.reverseSection(new StringBuffer(str), 2, 6)
						.toString());

	}
}
