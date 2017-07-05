package Lecture6;

public class FirstIndexOf7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 7, 6, 7 };
		int x = find(arr, 7, 0);
		System.out.print(x);
	}

	public static int find(int[] abc, int find, int si) {
		if (si == abc.length) {
			return -1;
		}
		if (abc[si] == find) {
			return si;
		} else {
			int x = find(abc, find, si + 1);
			return x;
		}
	}
}
