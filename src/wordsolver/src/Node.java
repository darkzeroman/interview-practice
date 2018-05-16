package wordsolver.src;

import java.util.HashMap;
import java.util.HashSet;

public class Node {
	char ch;
	final HashMap<Character, Node> children = new HashMap<Character, Node>();
	final HashSet<String> words = new HashSet<String>();

	public Node(char ch) {
		this.ch = ch;
	}

	public void addChild(char ch) {
		children.put(ch, new Node(ch));
	}

	public Node() {
	}
}