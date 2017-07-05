package Lecture5;

import Lecture4.BubbleSort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = BubbleSort.takeInput();
		BubbleSort.display(arr);
		System.out.println();
		Insertionsort(arr);
	}

	public static void Insertionsort(int[] abc) {
		int counter = 1;
		while (counter <= abc.length - 1) {
			for (int i = counter; i > 0 && abc[i - 1] > abc[i]; i--) {
				int temp = abc[i];
				abc[i] = abc[i - 1];
				abc[i - 1] = temp;
			}
			counter = counter + 1;
		}
		BubbleSort.display(abc);
	}
}
