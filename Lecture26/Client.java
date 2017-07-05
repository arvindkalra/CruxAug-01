package Lecture26;

public class Client {

	public static void main(String[] args) {
		// String src = "abbcejaodfghjaodskf";
		// String pat = "jao";
		//
		// System.out.println(bruteForcePatternMatching(src, pat));

		Trie2 trie = new Trie2();

		trie.addWord("stop");
		trie.addWord("sell");
		trie.addWord("sea");
		trie.addWord("see");
		trie.addWord("stock");
		trie.addWord("stock");
		trie.addWord("as");
		trie.addWord("are");
		trie.addWord("art");
		trie.addWord("arts");
		trie.addWord("boy");
		trie.addWord("bon");

		System.out.println(trie.size());
		trie.display();

		System.out.println(trie.searchWord("art"));
		System.out.println(trie.searchWord("arts"));

		trie.removeWord("arts");
		System.out.println(trie.searchWord("art"));
		System.out.println(trie.searchWord("arts"));

		trie.removeWord("art");
		System.out.println(trie.searchWord("art"));
		System.out.println(trie.searchWord("arts"));

		System.out.println(trie.size());
		trie.display();

		// System.out.println(lcs("abbdefffgaas", "agebddsesfgaas"));
		// System.out.println(lcs2("abbdefffgaas", "agebddsesfgaas").length);
		// System.out.println(lcs2("abbdefffgaas", "agebddsesfgaas").str);
	}

	public static int bruteForcePatternMatching(String source, String pattern) {
		int rv = -1;

		int i = 0; // source
		while (i <= source.length() - pattern.length()) {
			int j = 0;

			while (j < pattern.length()) {
				if (source.charAt(i + j) != pattern.charAt(j)) {
					break;
				}

				j++;
			}

			if (j == pattern.length()) {
				rv = i;
				break;
			}

			i++;
		}

		return rv;
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int rv = 0;

		if (ch1 == ch2) {
			rv = 1 + lcs(ros1, ros2);
		} else {
			int f1 = lcs(ros1, s2);
			int f2 = lcs(s1, ros2);

			rv = Math.max(f1, f2);
		}

		return rv;
	}

	public static LCSPair lcs2(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return new LCSPair(0, "");
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		LCSPair myResult = new LCSPair(0, "");

		if (ch1 == ch2) {
			LCSPair recResult = lcs2(ros1, ros2);

			myResult.length = 1 + recResult.length;
			myResult.str = ch1 + recResult.str;

		} else {
			LCSPair recResult1 = lcs2(s1, ros2);
			LCSPair recResult2 = lcs2(ros1, s2);

			if (recResult1.length > recResult2.length) {
				myResult = recResult1;
			} else {
				myResult = recResult2;
			}
		}

		return myResult;
	}

	private static class LCSPair {
		int length;
		String str;

		public LCSPair(int length, String str) {
			this.length = length;
			this.str = str;
		}
	}
}
