import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter the Number");
		int N = scn.nextInt();
		int row = 1;
		while (row <= N) {
			// for spaces
			int col = 1;
			while (col <= N - row) {
				System.out.print(" ");
				col++;
			}
			int val = row;
			col = 1;
			while (col <= row) {
				System.out.print(val);
				val++;
				col++;
			}
			val -= 2;
			col = 1;
			while (col <= row - 1) {
				System.out.print(val);
				val--;
				col++;
			}
			System.out.println();
			row++;
		}

		row = 1;
		N--;
		while (row <= N) {
			int col = 1;
			// spaces
			while (col <= row) {
				System.out.print(" ");
				col++;
			}
			col = 1;
			int val = N - row + 1;
			while (col <= N - row + 1) {
				System.out.print(val);
				val++;
				col++;
			}
			val -= 2;
			col = 1;
			while (col <= N - row) {
				System.out.print(val);
				col++;
				val--;
			}
			System.out.println();
			row++;
		}
	}

}
