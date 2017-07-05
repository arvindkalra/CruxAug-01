import java.util.Scanner;

public class fibTriangle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The Number Of rows..");
		int N = scn.nextInt();
		int row = 1;
		int fn = 0;
		int sn = 1;
		while (row <= N) {
			int col = 1;
			while (col <= row) {
				System.out.print(fn + "\t");
				int tn = fn + sn;
				fn = sn;
				sn = tn;
				col++;
			}
			System.out.println();
			row++;
		}
	}

}
