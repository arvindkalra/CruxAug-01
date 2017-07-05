package Lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class FunWthRecurssion {

	public static void main(String[] args) {
		 Scanner scn = new Scanner(System.in);
		 System.out.println("Please Enter A String...");
		 String str = scn.nextLine();
		 ArrayList<String> arr = rss(str);
		 System.out.println(arr);
		 scn.close();
//		int[] val = { 2, 15, 16, 7, 9, 3 };
//		int[] wt = { 5, 14, 8, 3, 7, 2 };
//		System.out.println(maxval(val, wt, 0, 25));

	}

	public static ArrayList<String> rss(String str) {

		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;

		}

		ArrayList<String> rosResult = rss(str.substring(1));

		int x = rosResult.size();
		for (int i = 0; i < x; i++) {
			rosResult.add(str.charAt(0) + rosResult.get(i));
		}
		int y = 0;
		char c = str.charAt(0);
		int z = y + c;
		for (int i = 0; i < x; i++) {
			rosResult.add(z + rosResult.get(i));
		}
		return rosResult;
	}

	public static int maxval(int[] val, int[] wt, int si, int pw) {

		if (si == val.length) {
			return 0;
		}

		int valinc = 0;
		int valexc = maxval(val, wt, si + 1, pw);
		if (wt[si] < pw) {
			valinc = maxval(val, wt, si + 1, pw - wt[si]) + val[si];
		}
		return Integer.max(valinc, valexc);
	}

	public static ArrayList<Integer> maxvalList(int[] val, int[] wt, int si, int pw) {
		ArrayList<E>
		
	}
}
