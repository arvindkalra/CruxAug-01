package Lecture9;

public class PermutationRecurssive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPermutations("abc", "");

	}

	public static void printPermutations(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			printPermutations(ros, result + cc);
		}
	}

	public static void printSS(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}

		printSS(str.substring(1), result + str.charAt(0));
		printSS(str.substring(1), result + "");
	}

	public static void printSSWAscii(String str, String result) {
		if (str.length() == 0) {
			System.out.println(result);
			return;
		}
		printSSWAscii(str.substring(1), result + "");
		printSSWAscii(str.substring(1), result + str.charAt(0));
		printSSWAscii(str.substring(1), result + (int) str.charAt(0));
	}

}