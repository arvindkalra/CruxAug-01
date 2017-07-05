package Lecture5;

import java.util.Scanner;

public class FunWithMultiDimArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[][] arr;

		// rectangular array
		// arr = new int[5][4];
		//
		// arr[4][3] = 20;

		// jagged
		// arr = new int[5][];
		//
		// arr[0] = new int[6];
		// arr[1] = new int[3];
		// arr[2] = new int[4];
		// arr[3] = new int[2];
		// arr[4] = new int[8];
		// arr[5] = new int[3]; // gadbadd

		int[][] arr = {
				{11, 12, 13},
				{21, 22, 23},
				{31, 32, 33},
				{41, 42, 43}
		};
		display(arr);
		spiralDisplay(arr);
	}

	public static int[][] takeInput() {
		int[][] retVal = null;

		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number of rows ");
		int rows = scn.nextInt();

		retVal = new int[rows][];

		int row = 0;
		while (row < rows) {
			System.out.println("Enter the number of cols for " + (row) + "th row ");
			int cols = scn.nextInt();

			retVal[row] = new int[cols];

			int col = 0;
			while (col < cols) {
				System.out.println("Enter the value for cell (" + row + ", " + col + ")");
				int value = scn.nextInt();

				retVal[row][col] = value;
				col++;
			}

			row++;
		}

		return retVal;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}

			System.out.println();
		}
	}

	public static void waveDisplay(int[][] arr) {
		for(int col = 0; col < arr[0].length; col++){
			if(col % 2 == 0){
				for(int row = 0; row < arr.length; row++){
					System.out.println(arr[row][col]);
				}
			}
			else {
				for(int row = arr.length - 1; row >= 0; row--){
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr) {
		int rowMin = 0, rowMax = arr.length - 1;
		int colMin = 0, colMax = arr[0].length - 1;
		int counter = 1, total = arr.length * arr[0].length;
		
		while(counter <= total){
			// min col
			for(int row = rowMin; counter <= total && row <= rowMax; row++){
				System.out.println(arr[row][colMin]);
				counter++;
			}
			colMin++;
			
			// max row
			for(int col = colMin; counter <= total && col <= colMax; col++){
				System.out.println(arr[rowMax][col]);
				counter++;
			}
			rowMax--;
			
			// max col
			for(int row = rowMax; counter <= total && row >= rowMin; row--){
				System.out.println(arr[row][colMax]);
				counter++;
			}
			colMax--;
			
			// min row
			for(int col = colMax; counter <= total && col >= colMin; col--){
				System.out.println(arr[rowMin][col]);
				counter++;
			}
			rowMin++;
		}
	}
}
