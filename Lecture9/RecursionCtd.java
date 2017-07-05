package Lecture9;

import java.util.ArrayList;

public class RecursionCtd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int boardSize = 8;
//		boolean[][] board = new boolean[boardSize][boardSize];
//
//		System.out.println(countNQueens(board, 0));
//		System.out.println(returnNQueens(board, 0));
//		printPermutations("abcd", "");
//		printDice(3, 1, "");
		System.out.println(getDice(3, 1));
	}

	public static int countNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				
				int countOnThisPath = countNQueens(board, row + 1);
				count += countOnThisPath;
				
				board[row][col] = false;
			}
		}

		return count;
	}

	public static ArrayList<String> returnNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> baseResult = new ArrayList<>();
			
			String result = "\n";
			for(int r = 0; r < board.length; r++){
				for(int c = 0; c < board[r].length; c++){
					if(board[r][c]){
						result += "[" + r + "-" + c + "], ";
					}
				}
			}
			result += "END\n";
			baseResult.add(result);
			
			return baseResult;
		}

		ArrayList<String> result = new ArrayList<>();
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				
				ArrayList<String> resultOnThisPath = returnNQueens(board, row + 1);
				result.addAll(resultOnThisPath);
				
				board[row][col] = false;
			}
		}

		return result;
	}

	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {
		// test col
		for (int i = row, j = col; i >= 0; i--) {
			if (board[i][j]) {
				return false;
			}
		}

		// test diag1
		for (int i = row, j = col; i >= 0 && j < board[row].length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}

		// test diag2
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		return true;
	}

	public static void printSS(String str, String result){
		if(str.length() == 0){
			System.out.println(result);
			return;
		}
		
		printSS(str.substring(1), result + "");
		printSS(str.substring(1), result + str.charAt(0));
	}
	
	public static void printSSWAscii(String str, String result){
		if(str.length() == 0){
			System.out.println(result);
			return;
		}
		
		printSSWAscii(str.substring(1), result + "");
		printSSWAscii(str.substring(1), result + str.charAt(0));
		printSSWAscii(str.substring(1), result + (int)str.charAt(0));
	}

	public static void printPermutations(String str, String result){
		if(str.length() == 0){
			System.out.println(result);
			return;
		}
		
		for(int i = 0; i < str.length(); i++){
			char cc = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1);
			
			printPermutations(ros, result + cc);
		}
	}

	public static void printDice(int tt, int ct, String result){
		if(ct > tt){
			System.out.println(result);
			return;
		}
		
		if(ct % 3 == 1){
			for(int i = 1; i <= 6; i++){
				printDice(tt, ct + 1, result + i);
			}
		}
		else if(ct % 3 == 2){
			for(int i = 2; i <= 6; i += 2){
				printDice(tt, ct + 1, result + i);
			}
		}
		else {
			for(int i = 3; i <= 6; i += 3){
				printDice(tt, ct + 1, result + i);
			}
		}
	}
	
	public static ArrayList<String> getDice(int tt, int ct) {
		if (ct > tt) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		ArrayList<String> nextThrowsResults = getDice(tt, ct + 1);
		ArrayList<String> myResult = new ArrayList<>();

		for (int i = 0; i < nextThrowsResults.size(); i++) {
			if(ct % 3 == 1){
				myResult.add(1 + nextThrowsResults.get(i));
				myResult.add(2 + nextThrowsResults.get(i));
				myResult.add(3 + nextThrowsResults.get(i));
				myResult.add(4 + nextThrowsResults.get(i));
				myResult.add(5 + nextThrowsResults.get(i));
				myResult.add(6 + nextThrowsResults.get(i));
			}
			else if(ct % 3 == 2){
				myResult.add(2 + nextThrowsResults.get(i));
				myResult.add(4 + nextThrowsResults.get(i));
				myResult.add(6 + nextThrowsResults.get(i));
			}
			else {
				myResult.add(3 + nextThrowsResults.get(i));
				myResult.add(6 + nextThrowsResults.get(i));
			}
		}

		return myResult;
	}
}
