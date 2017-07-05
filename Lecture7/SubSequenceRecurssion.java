package Lecture7;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSequenceRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter A String...");
		String str = scn.nextLine();
		ArrayList<String> arr = rss(str);
		System.out.println(arr);
		scn.close();
	}

	public static ArrayList<String> rss(String str) {
		if (str.length() == 0) {
			ArrayList<String> base = new ArrayList<>();
			base.add("");
			return base;

		}

		ArrayList<String> al = rss(str.substring(1));
		int x = al.size();
		for (int i = 0; i < x; i++) {
			al.add(str.charAt(0) + al.get(i));
		}
		return al;
	}
}