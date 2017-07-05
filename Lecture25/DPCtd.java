package Lecture25;

public class DPCtd {

	public static void main(String[] args) {
		// LCS
		System.out.println(LCS2("abcde", "abbdef").str);
	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int count = 0;
		if (s1.charAt(0) == s2.charAt(0)) {
			count++;
			count += LCS(s1.substring(1), s2.substring(1));
		} else {
			int count1 = LCS(s1, s2.substring(1));
			int count2 = LCS(s1.substring(1), s2);
			count += Integer.max(count1, count2);
		}
		return count;
	}

	public static Pair LCS2(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return new Pair("", 0);
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		Pair retval = new Pair("", 0);
		if (ch1 == ch2) {
			retval = LCS2(ros1, ros2);
			retval.str = ch1 + retval.str;
			retval.count++;
		} else {
			Pair f1 = LCS2(s1, ros2);
			Pair f2 = LCS2(ros1, s2);
			if (f1.count > f2.count) {
				retval.count = f1.count;
				retval.str = f1.str;
			} else {
				retval.count = f2.count;
				retval.str = f2.str;
			}
		}
		return retval;
	}

	public static class Pair {
		String str;
		int count;

		public Pair(String str, int count) {
			this.str = str;
			this.count = count;
		}
	}

}
