package Lecture5;

import java.util.Scanner;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = input();
		substring(s);
		boolean x = polindrome(s);
		System.out.println(x);
		subsequence(s);

	}

	public static boolean polindrome(String str) {
		boolean retVal = true;
		int first = 0, last = str.length() - 1;
		while (first <= last) {
			if (str.charAt(first) != str.charAt(last)) {
				retVal = false;
				return retVal;
			} else {
				first = first + 1;
				last = last - 1;
			}
		}
		return retVal;
	}

	public static String input() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter a String ");
		String s = scn.nextLine();
		scn.close();
		return s;
	}

	public static void substring(String s) {
		int i = 0;
		int j = 1;
		while (i < s.length()) {
			while (j <= s.length()) {
				System.out.println(s.substring(i, j));
				j = j + 1;
			}
			i = i + 1;
			j = i + 1;
		}
		System.out.println(" ");
	}

	public static void subsequence(String s) {
		int counter = 0;
		int limit = 1;
		while (counter < s.length()) {
			limit = limit * 2;
			counter++;
		}
		counter = 0;
		while (counter < limit) {
			String word = " ";
			int decimal = counter, indexOfchar = s.length() - 1;
			while (decimal != 0) {
				int bit = decimal % 2;
				if (bit == 1) {
					word = s.charAt(indexOfchar) + word;

				}
				indexOfchar = indexOfchar - 1;
				decimal = decimal / 2;
			}
			System.out.println(word);
			counter++;
		}
	}

}