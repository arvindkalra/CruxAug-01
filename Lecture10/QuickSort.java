package Lecture10;

import Lecture4.BubbleSort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] abc = { 5, 7, 1, 3, 5 };
		quicksort(abc, 0, abc.length - 1);
		BubbleSort.display(abc);
	}

	public static void quicksort(int[] arr, int lo, int hi) {
		// base case
		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		// seperation of lower and higher values
		int left = lo, right = hi;
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		// sorting smaller
		quicksort(arr, lo, right);

		// sorting larger
		quicksort(arr, left, hi);
	}
}
