package Lecture6;

public class LastIndexOf7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 7, 2, 7, 4, 2 };
		int x = find(arr, 7, 0);
		System.out.print(x);
	}

	public static int find(int[] abc, int find, int si) {
		if (si == abc.length) {
			return -1;
		}
		int x = find(abc, find, si + 1);
		if (x == -1 && abc[si] == find) {
			x = si;
		}
		return x;

	}
}