package all;
import static org.junit.Assert.*;

import org.junit.Test;

public class FBHackTest {

	@Test
	public void charTest() {

		assertEquals(FBHack.charToInt('a'), 0);
		assertEquals(FBHack.charToInt('z'), 25);
		assertEquals(FBHack.charToInt('Z'), 25);

	}

	@Test
	public void printAnswerTest() {
		assertEquals(FBHack.calculate("ABbCcc"), 152);

		assertEquals(FBHack.calculate("Good luck in the Facebook Hacker Cup this year!"), 754);

		assertEquals(FBHack.calculate("Ignore punctuation, please :)"), 491);

		assertEquals(FBHack.calculate("Sometimes test cases are hard to make up."), 729);

		assertEquals(FBHack.calculate("So I just go consult Professor Dalves"), 646);

	}

}
