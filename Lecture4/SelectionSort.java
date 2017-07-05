package Lecture4;

import java.util.Scanner;

public class SelectionSort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		System.out.print("The Order in Which You Entered The Nos is ");
		display(arr);
		selectsort(arr);
		System.out.println();
		System.out.print("The Ascending Order is ");
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

	public static void display(int[] xyz) {
		for (int i = 0; i < xyz.length; i++) {
			System.out.print(xyz[i] + ", ");

		}
	}

	public static void selectsort(int[] abc) {
		int counter = 1, j = 0;
		while (counter < abc.length) {
			for (int i = 1; i < abc.length - j; i++) {
				if (abc[j] > abc[j + i]) {
					int t = abc[j];
					abc[j] = abc[j + i];
					abc[j + i] = t;
				}
			}
			j = j + 1;
			counter = counter + 1;
		}
	}
}
