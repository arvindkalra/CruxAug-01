package Lecture4;

import java.util.Scanner;

public class ReverseOfArrey {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		System.out.print("The Order in Which you Entered the Nos is ");
		display(arr);
		System.out.println();
		reverse(arr);
		System.out.print("The Reverse Order is ");
		display(arr);
	}

	public static int[] takeInput() {
		int[] retval;
		System.out.println("Please Enter The No. Of Items ");
		int N = scn.nextInt();
		retval = new int[N];
		int i = 1;
		while (i <= N) {
			System.out.println("Please Enter " + i + "th Element");
			retval[i - 1] = scn.nextInt();
			i = i + 1;
		}
		return retval;

	}

	public static void reverse(int[] abc) {
		int first = 0, last = abc.length - 1;
		while (first <= last) {
			int temp = abc[first];
			abc[first] = abc[last];
			abc[last] = temp;

			first++;
			last--;
		}
	}

	public static void display(int[] xyz) {
		for (int i = 0; i < xyz.length; i++) {
			System.out.print(xyz[i] + ", ");

		}
	}
}
