package Lecture7;

import Lecture4.BubbleSort;

public class BubbleSortRecurssion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] abc = { 2, 34, -1, 4, 27 };
		BubbleSort.display(abc);
		System.out.println();
		int[] arr = sort(abc, 0, 4);
		BubbleSort.display(arr);
	}

	public static int[] sort(int[] arr, int si, int li) {
		if (li==1){
			return arr;
		}
		if (si == li) {
			sort(arr, 0, li - 1);
			return arr;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si];
			arr[si] = arr[si + 1];
			arr[si + 1] = temp;
		}
		sort(arr, si + 1, li);
		return arr;
	}
}
