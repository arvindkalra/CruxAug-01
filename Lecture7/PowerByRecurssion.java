package Lecture7;

import java.util.Scanner;

public class PowerByRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please enter the Base...");
		int x = scn.nextInt();
		System.out.println("Please Enter the Power...");
		int n = scn.nextInt();
		System.out.println(pow(x, n));
		scn.close();
	}

	public static int pow(int X, int N) {
		if (N == 0) {
			return 1;
		}
		int N1 = pow(X, N - 1);
		int ans = N1 * X;
		return ans;
	}
}
