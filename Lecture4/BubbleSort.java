package Lecture4;

import java.util.Scanner;

public class BubbleSort {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		display(arr);
		System.out.println();
		sort(arr);
		display(arr);
	}

	public static int[] takeInput() {
		int[] retval;
		System.out.println("Please Enter The No. Of Items ");
		int N = scn.nextInt();
		retval = new int[N];
		for (int i = 0; i < retval.length; i++) {
			System.out.println("Please Enter " + i + "th Element");
			retval[i] = scn.nextInt();
		}
		return retval;

	}

	public static void display(int[] xyz) {
		for (int i : xyz) {
			System.out.print(i + ", ");

		}
	}

	public static void sort(int[] xyz) {
		int i = 1;
		while (i < xyz.length) {
			for (int j = 0; j < xyz.length - i; j++) {
				if (xyz[j + 1] < xyz[j]) {
					int temp = xyz[j];
					xyz[j] = xyz[j + 1];
					xyz[j + 1] = temp;
				}
			}
			i = i + 1;
		}
	}
}