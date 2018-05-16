package wordsolver.src;

import java.util.HashSet;

public class JumbleSolver {
	final WordTrie wordTrie;

	public static void main(String[] args) {
		JumbleSolver jumbleSolver = new JumbleSolver();

		HashSet<String> validWords = jumbleSolver.solve("kelsey");
		for (String str : validWords) {
			System.out.println(str);
		}
	}

	public JumbleSolver() {
		wordTrie = WordTrie.buildDictionary();
	}

	public HashSet<String> solve(String inputWord) {
		HashSet<String> validWords = new HashSet<String>();
		boolean[] isIndexUsed = new boolean[inputWord.length()];
		StringBuffer tmpStrBuf = new StringBuffer(inputWord.length());

		helper(inputWord, tmpStrBuf, isIndexUsed, validWords);

		validWords.remove(inputWord);
		return validWords;
	}

	/**
	 * Creates permutations using the letters but stops creating them if they
	 * are invalid prefixes.
	 */
	private void helper(String origWord, StringBuffer tmpStrBuf,
			boolean[] isIndexUsed, HashSet<String> validWords) {

		String currWord = tmpStrBuf.toString();
		if (wordTrie.hasWord(currWord)) {
			validWords.add(currWord);
		} else if (!wordTrie.isValidPrefix(currWord)) {
			return; // if this isn't the start of a valid word, don't continue
		}

		for (int i = 0; i < isIndexUsed.length; i++) {
			if (!isIndexUsed[i]) {
				isIndexUsed[i] = true;
				tmpStrBuf.append(origWord.charAt(i));
				helper(origWord, tmpStrBuf, isIndexUsed, validWords);
				tmpStrBuf.deleteCharAt(tmpStrBuf.length() - 1);
				isIndexUsed[i] = false;
			}
		}

	}

}
