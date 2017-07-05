package Lecture5;

import Lecture4.BubbleSort;

public class FunwithArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = BubbleSort.takeInput();
		BubbleSort.display(arr);
		System.out.println();
		int[] val = new int[4];
		int i = 0;
		while (i < arr.length) {
			int j = arr[i];
			val[j] = val[j] + 1;
			i = i + 1;
		}
		int highfreq = Largest(val);
		System.out.println("The Number That is Entered Max Number Of Times is " + highfreq);
	}

	public static int Largest(int[] l) {
		int retval = 0;
		int i = 1;
		while (i < l.length) {
			if (l[i] > l[i - 1]) {
				retval = i;
			}
			i = i + 1;
		}
		return retval;
	}
}
