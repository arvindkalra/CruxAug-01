package Lecture26;

public class TP {

	public static void main(String[] args) {
		// String source = "abccbgrbaaefggratklmn";
		// String patern = "gra";
		// System.out.println(bruteForcePatternMatching(source, patern));

		Trie wor = new Trie();
		wor.addWord("artistic");
		wor.addWord("stock");
		wor.addWord("stair");
		wor.addWord("see");
		wor.addWord("as");
		wor.addWord("are");
		wor.addWord("sell");
		wor.addWord("boy");
		wor.addWord("bon");
		wor.addWord("stairs");
		wor.addWord("art");
		wor.addWord("arts");
		wor.addWord("zebra");
		System.out.println(wor);
		System.out.println(wor.size());
	}

	public static int bruteForcePatternMatching(String source, String patern) {
		int rv = -1;
		int i = 0;
		while (i <= source.length() - patern.length()) {
			int j = 0;
			while (j < patern.length()) {
				if (source.charAt(i + j) != patern.charAt(j)) {
					break;
				}
				j++;
			}
			if (j == patern.length()) {
				return i;
			}
			i++;
		}
		return rv;
	}
}
