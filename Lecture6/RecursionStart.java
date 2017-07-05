package Lecture6;

public class RecursionStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printIncreasingDecreasing(1, 5);
		
		System.out.println(isSortedSmarter(new int[] { 1, 5, 7, 9, 11}, 0));
	}

	// This function prints all numbers below (including) value
	public static void printDecreasing(int value) {
		if (value == 0) {
			System.out.print(value + ", ");
			return;
		}

		System.out.print(value + ", ");
		printDecreasing(value - 1);
	}

	public static void printIncreasing(int value) {
		if (value == 0) {
			System.out.print(value + ", ");
			return;
		}

		printIncreasing(value - 1);
		System.out.print(value + ", ");
	}

	public static void printDecreasingIncreasing(int value) {
		if (value == 0) {
			System.out.print(value + ", ");
			return;
		}

		System.out.print(value + ", ");
		printDecreasingIncreasing(value - 1);
		System.out.print(value + ", ");
	}

	// 5, 3, 2, 1, 0, 1, 2, 4, 5
	public static void printDecreasingIncreasingSkip(int value) {
		if (value == 0) {
			System.out.print(value + ", ");
			return;
		}

		if (value != 4) {
			System.out.print(value + ", ");
		}

		printDecreasingIncreasingSkip(value - 1);

		if (value != 3) {
			System.out.print(value + ", ");
		}
	}

	public static void printIncreasingDecreasing(int value, int uLimit) {
		if (value > uLimit) {
			return;
		}

		System.out.print(value + ", ");
		printIncreasingDecreasing(value + 1, uLimit);
		System.out.print(value + ", ");
	}

	public static boolean isSorted(int[] arr) {
		if(arr.length == 1){
			return true;
		}
		
		if (arr[0] > arr[1]) {
			return false;
		} else {
			int[] smallerArray = new int[arr.length - 1];
			for(int i = 0; i < smallerArray.length; i++){
				smallerArray[i] = arr[i + 1];
			}
			
			boolean isSmallerSorted = isSorted(smallerArray);
			return isSmallerSorted;
		}
	}
	
	public static boolean isSortedSmarter(int[] arr, int si){
		if(si == arr.length - 1){
			return true;
		}
		
		if(arr[si] > arr[si + 1]){
			return false;
		}
		else{
			return isSortedSmarter(arr, si + 1);
		}
	}
	
	public static boolean contains(int[] arr, int si, int el){
		if(si == arr.length){
			return false;
		}
		
		if(arr[si] == el){
			return true;
		}
		else {
			boolean isContainedInSmallerArray = contains(arr, si + 1, el);
			return isContainedInSmallerArray;
		}
	}
	
	public static int firstIndex(int[] arr, int si, int el){
		if(si == arr.length){
			return -1;
		}
		
		if(arr[si] == el){
			return si;
		}
		else {
			int foundAt = firstIndex(arr, si + 1, el);
			return foundAt;
		}
	}
	
	public static int lastIndex(int[] arr, int si, int el){
		if(si == arr.length){
			return -1;
		}
		
		int foundAt = lastIndex(arr, si + 1, el);
		if(foundAt == -1){
			if(arr[si] == el){
				return si;
			}
			else{
				return -1;
			}
		}
		else{
			return foundAt;
		}
	}
}
