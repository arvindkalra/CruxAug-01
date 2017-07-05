package Lecture5;

import java.util.Scanner;

import Lecture4.BubbleSort;

public class Binary_Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = BubbleSort.takeInput();
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Enter The Number To Search");
		int num2search = scn.nextInt();
		int placeValue = BinarySearch(arr, num2search);
		if (placeValue == -1) {
			System.out.println("You Didn't Enter " + num2search);
		} else {

			System.out.println("You Entered " + num2search + " at " + placeValue + "th Place.");
		}
		scn.close();

	}

	public static int BinarySearch(int[] abc, int num) {
		int first = 0, last = abc.length - 1;
		while (first <= last) {
			int mid = (first + last) / 2;
			if (num == abc[mid]) {
				int val = mid + 1;
				return val;
			} else if (num > abc[mid]) {
				first = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return -1;
	}
}
