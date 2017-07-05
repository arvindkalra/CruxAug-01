import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Please enter the number - ");
		int N = scn.nextInt();

		int row = 1, value = 1;
		while (row <= N) {
			int col = 1;

			while (col <= row) {
				System.out.print(value);
				value = value + 1;
				col = col + 1;
			}

			System.out.println();
			row = row + 1;
		}
	}

}
