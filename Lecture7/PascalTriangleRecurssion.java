package Lecture7;

public class PascalTriangleRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pp(5, 0, 0, 1);
	}

	public static void pp(int N, int row, int col, int val) {

		if (row == N) {
			return;
		}

		if (col > row) {
			System.out.println();
			pp(N, row + 1, 0, 1);
			return;
		}

		System.out.print(val + "\t");
		int value = val * (row - col) / (col + 1);
		pp(N, row, col + 1, value);

	}
}
