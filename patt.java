import java.util.Scanner;

public class patt {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter the Number..");
		int N = scn.nextInt();
		int row = 1;

		while (row <= N) {
			int numspace = N - row;
			int col = 1;
			while (col <= numspace) {
				System.out.print(" ");
				col = col + 1;
			}
			col = 1;
			int nin = row;
			int val = row;
			while (col <= nin) {
				System.out.print(val);
				val++;
				col++;
			}
			col = 1;
			int ndn = row - 1;
			val = val - 2;
			while (col <= ndn) {
				System.out.print(val);
				col++;
				val--;
			}
			System.out.println();
			row++;
		}

	}

}
