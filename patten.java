import java.util.Scanner;

public class patten {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter the Number Of Rows");
		int N = scn.nextInt();
		int row = 1;
		while (row <= N) {
			// nos
			System.out.print(row + "\t");
			int col = 2;
			while (col < row) {
				System.out.print("0\t");
				col++;
			}
			if (row == col) {
				System.out.print(row);
			}
			System.out.println();
			row++;
		}
	}

}
