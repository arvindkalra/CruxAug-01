package Lecture9;

public class NQueensArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean[][] arr = new boolean[10][10];
		System.out.println(NQueensCount(arr, 0));
		PrintNQueens(arr, 0);
	}

	public static int NQueensCount(boolean[][] arr, int row) {

		if (row == arr.length) {
			return 1;
		}

		int count = 0;
		for (int col = 0; col < arr.length; col++) {
			if (isItSafe(arr, row, col)) {
				arr[row][col] = true;
				count += NQueensCount(arr, row + 1);
				arr[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isItSafe(boolean[][] arr, int row, int col) {
		// check for columns
		for (int i = row, j = col; i >= 0; i--) {
			if (arr[i][j]) {
				return false;
			}
		}
		// check for right diagonal
		for (int i = row, j = col; i >= 0 && j < arr.length; i--, j++) {
			if (arr[i][j]) {
				return false;
			}
		}
		// check for left diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j]) {
				return false;
			}
		}
		return true;
	}

	public static void PrintNQueens(boolean[][] arr, int row) {
		if (row == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j]) {
						System.out.print(" # ");
					} else {
						System.out.print(" - ");
					}
				}
				System.out.println();
			}
			System.out.println();
			System.out.println("Next");
			return;
		}

		for (int col = 0; col < arr.length; col++) {
			if (isItSafe(arr, row, col)) {
				arr[row][col] = true;
				PrintNQueens(arr, row + 1);
				arr[row][col] = false;
			}
		}
	}
}