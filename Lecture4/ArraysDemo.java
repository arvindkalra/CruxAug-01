package Lecture4;

import java.util.Scanner;

import Lecture3.FunWithArrays;

public class ArraysDemo {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] arr = takeInput();
//		display(arr);
//		
//		System.out.println(largest(arr));
//		
//		System.out.println("Enter the number to find ");
//		int search = scn.nextInt();
//		
//		System.out.println(linearSearch(arr, search));
//		
//		display(arr);
//		reverse(arr);
//		display(arr);
		
//		display(arr);
//		selectionSort(arr);
//		display(arr);
		
		display(arr);
		bubbleSort(arr);
		display(arr);
	}
	
	public static int[] takeInput(){
		int[] retVal;
		
		System.out.println("Enter the number of items ");
		int N = scn.nextInt();
		
		retVal = new int[N];
		
		int counter = 1;
		while(counter <= N){
			System.out.println("Enter " + counter + "th element ");
			retVal[counter - 1] = scn.nextInt();
			
			counter = counter + 1;
		}
		
		return retVal;
	}

	public static void display(int[] xyz){
		for(int i = 0; i < xyz.length; i++){
			System.out.print(xyz[i] + ", ");
		}
		
		System.out.println("END");
	}

	public static int largest(int[] arr){
		int retVal = arr[0];
		
		for(int i = 1; i < arr.length; i++){
			if(arr[i] > retVal){
				retVal = arr[i];
			}
		}
		
		return retVal;
	}
	
	public static int linearSearch(int[] arr, int item){
		int retVal = -1;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == item){
				retVal = i;
				break; 
			}
		}
		
		return retVal;
	}
	
	public static void reverse(int[] arr){
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			FunWithArrays.Swap(arr, left, right);
			
			left++;
			right--;
		}
	}
	
	public static void bubbleSort(int[] arr){
		int counter = 1;
		while(counter <= arr.length - 1){
			for(int i = 0; i < arr.length - counter; i++){
				if(arr[i + 1] < arr[i]){
					FunWithArrays.Swap(arr, i, i + 1);
				}
			}
			
			counter = counter + 1;
		}
	}
	
	public static void selectionSort(int[] arr){
		int counter = 1;
		while(counter <= arr.length - 1){
			for(int i = counter; i < arr.length; i++){
				if(arr[i] < arr[counter - 1]){
					FunWithArrays.Swap(arr, i, counter - 1);
				}
			}
			
			counter = counter + 1;
		}
	}
	
	public static void insertionSort(int[] arr){
		int counter = 1;
		while(counter <= arr.length - 1){
			for(int i = counter; i == 0 && arr[i - 1] > arr[i]; i--){
				FunWithArrays.Swap(arr, i, i - 1);
			}
			
			counter = counter + 1;
		}
	}
}
