package Lecture8;

import java.util.ArrayList;

public class KeypadProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "59";
		keypad(getCode(str.charAt(0)), getCode(str.charAt(1)));
	System.out.println(getkeypad(getCode(str.charAt(0)), getCode(str.charAt(1))));
	}

	public static void keypad(String str1, String str2) {
		if (str1.length() == 0) {
			return;
		}

		keypad(str1.substring(1), str2);
		ArrayList<String> Res = new ArrayList<>();
		for (int i = 0; i < str2.length(); i++) {
			String result = "" + str1.charAt(0);
			result += str2.charAt(i);
			Res.add(result);
		}
		System.out.println(Res);
	}

	public static String getCode(char c) {
		String result = "";

		switch (c) {
		case '1':
			result = "abc";
			break;
		case '2':
			result = "def";
			break;
		case '3':
			result = "ghi";
			break;
		case '4':
			result = "jkl";
			break;
		case '5':
			result = "mno";
			break;
		case '6':
			result = "pqr";
			break;
		case '7':
			result = "stu";
			break;
		case '8':
			result = "vwx";
			break;
		case '9':
			result = "yz";
			break;

		}
		return result;
	}

	public static ArrayList<String> getkeypad(String str1, String str2) {
		if (str1.length() == 0) {
			ArrayList<String> aa = new ArrayList<>();
			return aa;
		}

		keypad(str1.substring(1), str2);
		ArrayList<String> Res = new ArrayList<>();
		for (int i = 0; i < str2.length(); i++) {
			String result = "" + str1.charAt(0);
			result += str2.charAt(i);
			Res.add(result);
		}
		return Res;
	}

}
