package wordsolver.src;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordTrieTest {

	@Test
	public void testSimpleInput() {
		WordTrie wordTrie = new WordTrie();
		wordTrie.addWord("at");
		wordTrie.addWord("attack");
		wordTrie.addWord("racecar");

		assertFalse(wordTrie.hasWord("race"));
		assertTrue(wordTrie.hasWord("racecar"));

		assertFalse(wordTrie.hasWord("att"));
		assertTrue(wordTrie.hasWord("attack"));
		assertTrue(wordTrie.hasWord("at"));
		assertTrue(wordTrie.isValidPrefix("atta"));
		assertFalse(wordTrie.isValidPrefix("abb"));
	}
}
