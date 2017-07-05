package Lecture7;

import Lecture4.BubbleSort;

public class SelectionSortRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] abc = { 2, 6, 1, 4, 7 };
		sort(abc, 0, 1);
		BubbleSort.display(abc);
	}

	public static void sort(int[] arr, int fi, int li) {
		if (fi == arr.length - 1) {
			return;
		}
		if (li == arr.length) {
			sort(arr, fi + 1, fi + 2);
			return;
		}
		if (arr[fi] > arr[li]) {
			int temp = arr[fi];
			arr[fi] = arr[li];
			arr[li] = temp;
		}
		sort(arr, fi, li + 1);
	}
}
