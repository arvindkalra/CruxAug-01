package Lecture26;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie2 {
	private class Node {
		Character data;
		boolean isTerminal;
		HashMap<Character, Node> children;

		Node(Character data, boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}

		public String toString() {
			return "(" + this.data + ", " + this.isTerminal + ")";
		}
	}

	private Node root;
	private int size;

	public Trie2() {
		this.root = new Node('\0', false);
		this.size = 0;
	}

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				// nothing to do - word already exists
			} else {
				this.size++;
				parent.isTerminal = true;
			}

			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(ch);

		if (child == null) {
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}

		this.addWord(child, ros);
	}

	public void removeWord(String word) {
		this.removeWord(this.root, word);
	}

	public void removeWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				this.size--;
				parent.isTerminal = false;
			} else {
				// nothing to do
			}

			return;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(ch);

		if (child == null) {
			return;
		}

		this.removeWord(child, ros);

		// if not a word and not part of a word either we won't keep the node
		if (!child.isTerminal && child.children.size() == 0) {
			parent.children.remove(ch);
		}
	}

	public boolean searchWord(String word) {
		return this.searchWord(this.root, word);
	}

	private boolean searchWord(Node parent, String word) {
		if (word.length() == 0) {
			return parent.isTerminal;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(ch);

		if (child == null) {
			return false;
		}

		return this.searchWord(child, ros);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void display() {
		System.out.println(this);
		System.out.println("****************************************");
	}

	@Override
	public String toString() {
		return this.toString(this.root);
	}

	private String toString(Node node) {
		String rv = "";

		rv += node + " => ";
		Set<Character> childrenPairs = node.children.keySet();
		for (Character ch : childrenPairs) {
			rv += ch + ", ";
		}

		rv += "END\n";

		for (Character ch : childrenPairs) {
			Node next = node.children.get(ch);
			rv += this.toString(next);
		}

		return rv;
	}
}
