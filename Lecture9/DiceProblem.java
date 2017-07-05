package Lecture9;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DiceProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printDice(3, 1, "");
		System.out.println(getDice(3, 1));
	}

	public static void printDice(int tt, int ct, String result) {

		if (ct > tt) {
			System.out.println(result);
			return;
		}

		if (ct % 3 == 1) {
			for (int i = 1; i <= 6; i++) {
				printDice(tt, ct + 1, result + i);
			}
		} else if (ct % 3 == 2) {
			for (int i = 2; i <= 6; i += 2) {
				printDice(tt, ct + 1, result + i);
			}
		} else {
			for (int i = 3; i <= 6; i += 3) {
				printDice(tt, ct + 1, result + i);
			}
		}
	}

	public static ArrayList<String> getDice(int tt, int ct) {
		ArrayList<String> first = new ArrayList<>();
		ArrayList<String> second = new ArrayList<>();
		ArrayList<String> third = new ArrayList<>();

		if (ct > tt) {
			ArrayList<String> aa = new ArrayList<>();
			return aa;
		}
		if (ct % 3 == 1) {
			for (int i = 1; i <= 6; i++) {
				first.add(""+i);
				first = getDice(tt, ct + 1);
				
			}
		} else if (ct % 3 == 2) {
			for (int i = 2; i <= 6; i += 2) {
				second.add(""+i);
				second = getDice(tt, ct + 1);
				
			}
		} else {
			for (int i = 3; i <= 6; i += 3) {
				third.add(""+i);
				third = getDice(tt, ct + 1);
				
			}
		}
		ArrayList<String> myresult = new ArrayList<>();
		myresult.addAll(first);
		myresult.addAll(second);
		myresult.addAll(third);

		return myresult;

	}
}