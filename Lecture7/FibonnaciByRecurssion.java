package Lecture7;

import java.util.Scanner;

public class FibonnaciByRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter A Number..");
		int n = scn.nextInt();
		System.out.println(fib(n));
		scn.close();
	}

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int nm1Fib = fib(n - 1);
		int nm2Fib = fib(n - 2);
		int ans = nm1Fib + nm2Fib;
		return ans;
	}
}
