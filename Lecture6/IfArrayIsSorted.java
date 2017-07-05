package Lecture6;

public class IfArrayIsSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 95, 7, 8 };
		boolean x = check(arr, 0);
		System.out.print(x);
	}

	public static boolean check(int[] abc, int si) {
		if (si == abc.length - 1) {
			return true;
		}
		if (abc[si] > abc[si + 1]) {
			return false;
		} else {
			boolean x = check(abc, si + 1);
			return x;
		}
	}
}
