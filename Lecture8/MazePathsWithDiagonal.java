package Lecture8;

import java.util.ArrayList;

public class MazePathsWithDiagonal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(CMPs(3, 2, 0, 0));
	}

	public static ArrayList<String> CMPs(int tr, int tc, int cr, int cc) {
		if (cr == tr && cc == tc) {
			ArrayList<String> al = new ArrayList<>();
			al.add("");
			return al;
		}
		ArrayList<String> rowResult = new ArrayList<>();
		ArrayList<String> colResult = new ArrayList<>();
		ArrayList<String> diaResult = new ArrayList<>();
		ArrayList<String> MyResult = new ArrayList<>();
		if (cr < tr) {
			rowResult = CMPs(tr, tc, cr + 1, cc);

		}
		if (cc < tc) {
			colResult = CMPs(tr, tc, cr, cc + 1);
		}
		if (cc < tc && cr < tr) {
			diaResult = CMPs(tr, tc, cr + 1, cc + 1);
		}
		for (int i = 0; i < rowResult.size(); i++) {
			MyResult.add("V" + rowResult.get(i));
		}
		for (int i = 0; i < colResult.size(); i++) {
			MyResult.add("H" + colResult.get(i));
		}
		for (int i = 0; i < diaResult.size(); i++) {
			MyResult.add("D" + diaResult.get(i));
		}

		return MyResult;
	}
}
