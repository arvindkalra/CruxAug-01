package Lecture9;

import java.util.ArrayList;

public class NQueensCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int boardsize = 10;
		ArrayList<ArrayList<Boolean>> board = new ArrayList<>();

		for (int i = 0; i < boardsize; i++) {
			ArrayList<Boolean> row = new ArrayList<>();
			for (int col = 0; col < boardsize; col++) {
				row.add(false);
			}
			board.add(row);
		}
		System.out.println(NQueensCount(board, 0));
		printNQueens(board, 0);
		System.out.println(returnNQueens(board, 0));
	}

	public static int NQueensCount(ArrayList<ArrayList<Boolean>> board, int row) {
		if (row == board.size()) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board.get(row).size(); col++) {
			if (isItSafe(board, row, col)) {
				board.get(row).set(col, true);
				count += NQueensCount(board, row + 1);
				board.get(row).set(col, false);
			}
		}
		return count;
	}

	public static boolean isItSafe(ArrayList<ArrayList<Boolean>> board, int row, int col) {
		// check for column
		for (int i = row, j = col; i >= 0; i--) {
			if (board.get(i).get(j)) {
				return false;
			}
		}
		// check for diagonal right
		for (int i = row, j = col; i >= 0 && j < board.get(i).size(); i--, j++) {
			if (board.get(i).get(j)) {
				return false;
			}
		}
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board.get(i).get(j)) {
				return false;
			}
		}
		return true;

	}

	public static void printNQueens(ArrayList<ArrayList<Boolean>> board, int row) {
		if (row == board.size()) {
			for (int i = 0; i < board.size(); i++) {
				System.out.println(board.get(i));
			}
			System.out.println();
			System.out.println();
			return;
		}

		for (int col = 0; col < board.get(row).size(); col++) {
			if (isItSafe(board, row, col)) {
				board.get(row).set(col, true);
				printNQueens(board, row + 1);
				board.get(row).set(col, false);
			}
		}
		return;
	}

	public static ArrayList<String> returnNQueens(ArrayList<ArrayList<Boolean>> board, int row) {
		if (row == board.size()) {
			ArrayList<String> places = new ArrayList<>();
			String result = "\n";
			for (int i = 0; i < board.size(); i++) {
				for (int col = 0; col < board.size(); col++) {
					if (board.get(i).get(col)) {
						result += "[" + i + "-" + col + "], ";
					}
				}
			}
			result += "END";
			places.add(result);
			return places;
		}

		ArrayList<String> myresult = new ArrayList<>();
		for (int col = 0; col < board.get(row).size(); col++) {
			if (isItSafe(board, row, col)) {
				board.get(row).set(col, true);
				myresult.addAll(returnNQueens(board, row + 1));
				board.get(row).set(col, false);
			}
		}
		return myresult;
	}

}
