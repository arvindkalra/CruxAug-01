package Lecture5;

import java.util.Scanner;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeinput();
		spiralprint(arr);
		// display(arr);
	}

	public static int[][] takeinput() {
		int retval[][];
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The Number Of Rows");
		int rows = scn.nextInt();
		retval = new int[rows][];
		int row = 0;
		while (row < rows) {
			System.out.println("Please Enter the Number Of Columns in " + row + "th row");
			int cols = scn.nextInt();
			retval[row] = new int[cols];
			int col = 0;
			while (col < cols) {
				System.out.println("Please Enter The Value for Cell (" + row + ", " + col + ")");
				retval[row][col] = scn.nextInt();
				col++;
			}
			row++;
		}
		scn.close();
		return retval;
	}

	public static void display(int[][] d) {
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void spiralprint(int[][] arr) {
		int Rmin = 0;
		int Rmax = arr.length - 1;
		int Cmin = 0;
		int Cmax = arr[0].length - 1;
		int limit = arr.length * arr[0].length;
		int counter = 0;
		while (counter <= limit) {
			for (int i = Rmin; i <= Rmax; i++) {
				System.out.print(arr[i][Cmin] + ", ");
				counter++;
			}
			Cmin++;
			for (int i = Cmin; i <= Cmax; i++) {
				System.out.print(arr[Rmax][i] + ", ");
				counter++;
			}
			Rmax--;
			for (int i = Rmax; i >= Rmin; i--) {
				System.out.print(arr[i][Cmax] + ", ");
				counter++;
			}
			Cmax--;
			for (int i = Cmax; i >= Cmin; i--) {
				System.out.print(arr[Rmin][i] + ", ");
				counter++;
			}
			Rmin++;
		}
		System.out.println("End");
	}
}
