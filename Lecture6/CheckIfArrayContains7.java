package Lecture6;

public class CheckIfArrayContains7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 95, 6, 8 };
		boolean x = check(arr, 7, 0);
		System.out.print(x);
	}

	public static boolean check(int[] arr, int find, int si) {
	if (si==arr.length){
		return false;
	}
		if(arr[si]==7){
			return true;
		}
		else {
			boolean x = check (arr, 7 , si+1);
			return x;
		}
	}
}
