package Lecture26;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Trie {
	private class Node {
		Character data;
		Boolean isTerminal;
		HashMap<Character, Node> children;

		public Node(Character data, Boolean isTerminal) {
			this.data = data;
			this.isTerminal = isTerminal;
			this.children = new HashMap<>();
		}
	}

	private Node root;
	private int size;

	public Trie() {
		this.root = new Node('\0', false);
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addWord(String word) {
		this.addWord(word, this.root);
	}

	private void addWord(String word, Node pn) {
		if (word.length() == 0) {
			if (pn.isTerminal) {
				// nothing to do...
			} else {
				this.size++;
				pn.isTerminal = true;
			}
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node cn = pn.children.get(ch);
		if (cn == null) {
			cn = new Node(ch, false);
			pn.children.put(ch, cn);
		}
		addWord(ros, cn);
	}

	public void removeWord(String word) {
		this.removeWord(this.root, word);
	}

	private void removeWord(Node parent, String word) {
		if (word.length() == 0) {
			if (parent.isTerminal) {
				parent.isTerminal = false;
				this.size--;
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
		removeWord(child, ros);

		if (!child.isTerminal && child.children.isEmpty()) {
			parent.children.remove(ch);
		}
	}

	public boolean findWord(String word) {
		return findWord(word, this.root);
	}

	private boolean findWord(String word, Node parent) {
		if (word.length() == 0) {
			return parent.isTerminal;
		}

		char ch = word.charAt(0);
		String ros = word.substring(1);

		Node child = parent.children.get(ch);
		if (child == null) {
			return false;
		} else {
			return findWord(ros, child);
		}
	}

	public void display() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		String rv = "********DISPLAY********\n";
		Retval ret = new Retval();
		Collection<Node> list = this.root.children.values();
		for (Node li : list) {
			toString(li, ret, "");
		}
		String ros = ret.str + "************************";
		rv += ros;
		return rv;
	}

	private void toString(Node parent, Retval rv, String str) {
		str += parent.data;

		if (parent.isTerminal) {
			rv.str += str + "\n";
			if (parent.children.isEmpty()) {
				// nothing to Do...
			} else {
				Set<Character> list = parent.children.keySet();
				for (Character ch : list) {
					Node li = parent.children.get(ch);
					toString(li, rv, str);
				}
			}
			return;
		}
		Set<Character> list = parent.children.keySet();
		for (Character ch : list) {
			Node li = parent.children.get(ch);
			toString(li, rv, str);
		}
	}

	private class Retval {
		String str;

		public Retval() {
			this.str = "";
		}
	}
}
