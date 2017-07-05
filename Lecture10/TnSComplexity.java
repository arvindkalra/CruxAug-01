package Lecture10;

public class TnSComplexity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] one = {1, 4, 5, 7, 8, 10, 15, 20};
		// int[] two = {3, 5, 6, 8, 8, 9};
		// int[] result = merge(one, two);
		//
		// for(int val: result){
		// System.out.print(val + ", ");
		// }
		// System.out.println("END");

//		int[] arr = { 5, 9, 1, 6, 3, 1, 8, 6, -1, 14 };
//		quickSort(arr, 0, arr.length - 1);
//		for (int val : arr) {
//			System.out.print(val + ", ");
//		}
//		System.out.println("END");
		
//		int[] arr = new int[1000000];
//		
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = arr.length - i;
//		}
//		
//		testMergeSort(arr);
//		testBubbleSort(arr);
		
//		System.out.println(FibBtr(50)[1]);
		System.out.println(Fib(50));
	}
	
	public static void testBubbleSort(int[] arr){
		long start = System.currentTimeMillis();
		
		Lecture4.ArraysDemo.bubbleSort(arr);
		
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		
		System.out.println("Bubble sort for n = " + arr.length + " took " + duration);
	}
	
	public static void testMergeSort(int[] arr){
		long start = System.currentTimeMillis();
		
		arr = mergeSort(arr, 0, arr.length - 1);
		
		long end = System.currentTimeMillis();
		
		long duration = end - start;
		
		System.out.println("Merge sort for n = " + arr.length + " took " + duration);
	}

	public static int[] merge(int[] one, int[] two) {
		int[] retVal = new int[one.length + two.length];

		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				retVal[k] = one[i];
				i++;
				k++;
			} else {
				retVal[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			retVal[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			retVal[k] = two[j];
			j++;
			k++;
		}

		return retVal;
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] baseResult = new int[1];

			baseResult[0] = arr[lo];

			return baseResult;
		}

		int mid = (lo + hi) / 2;

		int[] fHalf = mergeSort(arr, lo, mid);
		int[] sHalf = mergeSort(arr, mid + 1, hi);

		int[] sorted = merge(fHalf, sHalf);
		return sorted;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo >= hi){
			return;
		}
		
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		// separating smaller and larger
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
		quickSort(arr, lo, right);
		
		// sorting larger
		quickSort(arr, left, hi);
	}

	public static int power(int x, long n){
		if(n == 0){
			return 1;
		}
		
		int xpnm1 = power(x, n - 1);
		int xpn = x * xpnm1;
		
		return xpn;
	}
	
	public static int powerBtr(int x, long n){
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = powerBtr(x, n / 2);
		int xpn = 1;
		
		if(n % 2 == 0){
			xpn = xpnb2 * xpnb2;
		}
		else {
			xpn = xpnb2 * xpnb2 * x;
		}
		
		return xpn;
	}

	public static int Fib(int n){
		if(n == 0 || n == 1){
			return n;
		}
		
		int fibnm1 = Fib(n - 1);
		int fibnm2 = Fib(n - 2);
		
		int fibn = fibnm1 + fibnm2;
		return fibn;
	}
	
	public static int[] FibBtr(int n){
		if(n == 1){
			int[] baseResult = new int[2];
			
			baseResult[0] = 0;
			baseResult[1] = 1;
			
			return baseResult;
		}
		
		int[] recResult = FibBtr(n - 1);
		int[] myResult = new int[2];
		
		myResult[0] = recResult[1];
		myResult[1] = recResult[0] + recResult[1];
		
		return myResult;
	}
}
