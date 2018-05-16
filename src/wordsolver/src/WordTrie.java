package wordsolver.src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordTrie {
	final Node root = new Node();

	public void addWord(String word) {

		Node currNode = root;

		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			
			// add the child node if it doesn't exist
			if (!currNode.children.containsKey(character)) {
				currNode.addChild(character);
			}
			currNode = currNode.children.get(character);
		}

		currNode.words.add(word);
	}

	public boolean hasWord(String word) {
		Node currNode = root;
		
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (!currNode.children.containsKey(character)) {
				return false;
			}

			currNode = currNode.children.get(character);
		}
		return currNode.words.contains(word);
	}

	public boolean isValidPrefix(String prefix) {
		Node currNode = root;
		
		for (int i = 0; i < prefix.length(); i++) {
			char character = prefix.charAt(i);
			if (!currNode.children.containsKey(character)) {
				return false;
			}

			currNode = currNode.children.get(character);
		}
		return true;
	}

	public static WordTrie buildDictionary() {
		String fileName = "./src/filteredWords.txt";
		BufferedReader br;
		WordTrie wordTrie = new WordTrie();

		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine();

			while (line != null) {
				wordTrie.addWord(line.toLowerCase());
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return wordTrie;

	}

}