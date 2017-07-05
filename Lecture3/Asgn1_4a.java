package Lecture3;

import java.util.Scanner;

public class Asgn1_4a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		System.out.println("Please enter the number of rows ");
		int N = scn.nextInt();

		int row = 1;
		int numSpaces = N / 2;
		int numStars = 1;
		while (row <= N) {
			// spaces
			int col = 1;
			while (col <= numSpaces) {
				System.out.print(" ");
				col = col + 1;
			}

			// stars
			col = 1;
			while (col <= numStars) {
				System.out.print("*");
				col = col + 1;
			}

			if (row <= N / 2) {
				numSpaces = numSpaces - 1;
				numStars = numStars + 2;
			}
			else {
				numSpaces = numSpaces + 1;
				numStars = numStars - 2;
			}

			System.out.println();
			row = row + 1;
		}
		
		String s = "";
		
	}

}
