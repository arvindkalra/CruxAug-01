package Lecture3;

public class FunWithArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10];
		
//		arr[5] = 100;
//		
//		System.out.println(arr[5]);
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = arr.length - i;
		}
		
//		for(int i = 0; i < arr.length; i++){
//			System.out.println(arr[i]);
//		}
		
		System.out.println(arr[3] + ", " + arr[9]);
		Swap(arr, 3, 9);
		System.out.println(arr[3] + ", " + arr[9]);
	}

	public static void Swap(int[] arr, int i, int j){
		System.out.println(arr[i] + ", " + arr[j]);
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		System.out.println(arr[i] + ", " + arr[j]);
	}
}
