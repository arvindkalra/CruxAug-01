package Lecture10;

import Lecture4.BubbleSort;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] abc = BubbleSort.takeInput();
		int[] sort = mergeSort(abc, 0, abc.length - 1);
		BubbleSort.display(sort);
	}

	public static int[] merge(int[] one, int[] two) {
		int[] retval = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		// jab tak dono array mein values hain...
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				retval[k] = one[i];
				k++;
				i++;
			} else {
				retval[k] = two[j];
				k++;
				j++;
			}
		}
		// jab dono mein se ek array khatam ho jaye...

		while (i < one.length) {
			retval[k] = one[i];
			k++;
			i++;
		}
		while (j < two.length) {
			retval[k] = two[j];
			k++;
			j++;
		}
		return retval;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		// base case
		if (hi == lo) {
			int[] base = new int[1];
			base[0] = arr[lo];
			return base;
		}

		// dividing the array
		int mid = (lo + hi) / 2;
		int[] fir = mergeSort(arr, lo, mid);
		int[] sec = mergeSort(arr, mid + 1, hi);
		// sorting the array
		int[] sorted = merge(fir, sec);
		return sorted;
	}
}
