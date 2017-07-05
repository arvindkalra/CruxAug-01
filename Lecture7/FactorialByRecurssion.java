package Lecture7;

import java.util.Scanner;

public class FactorialByRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		System.out.println("Please Enter A Number...");
//		int num = scn.nextInt();
//		System.out.println(factorial(num));
//		scn.close();
//	
		test();
		}

	public static long factorial(long n) {
		if (n == 0) {
			return 1;
		}
		long num = factorial(n - 1);
		long retval = num * n;
		return retval;
	}
	
	public static long sum (long n){
		long retval = 0;
		
		while (n>0){
			long i = n/10;
			retval =retval + n - (10*i);
			n=n/10;
		}
		
		return retval;
	}
	public static void test(){
		Scanner scn = new Scanner(System.in);
		long N = scn.nextInt();
		N++;
		long x = factorial(N);
		System.out.println(sum(x));
		scn.close();
	}
}
