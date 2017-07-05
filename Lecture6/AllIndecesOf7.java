package Lecture6;

import java.util.Scanner;

import Lecture4.BubbleSort;

public class AllIndecesOf7 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = BubbleSort.takeInput();
		BubbleSort.display(arr);
		System.out.println();
		System.out.println("Please Enter The Number To be Searched..");
		int f = scn.nextInt();
		int[] x = find(arr, f, 0, 0);
		System.out.print("The Number " + f + " Was found at ");
		BubbleSort.display(x);
		System.out.print("places.");
	}

	public static int[] find(int[] abc, int f, int si, int j) {
		if (si == abc.length) {
			return new int[j];
		}
		if (abc[si] == f) {
			j = j + 1;
		}
		int[] arr = find(abc, f, si + 1, j);
		if (abc[si] == f) {
			arr[j - 1] = si;
		}
		return arr;
	}
}
