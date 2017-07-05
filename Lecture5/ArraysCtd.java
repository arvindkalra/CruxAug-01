package Lecture5;

import java.util.Scanner;

import Lecture4.ArraysDemo;

public class ArraysCtd {

	public static void main(String[] args) {
		int[] arr = ArraysDemo.takeInput();
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter the number to find ");
		int num = scn.nextInt();
		
		int foundAt = binarySearch(arr, num);
		System.out.println("Number found at " + foundAt + " index");
	}

	public static int binarySearch(int[] arr, int num){
		int left = 0, right = arr.length - 1;
		while(left <= right){
			int mid = (left + right) / 2;
			
			if(num == arr[mid]){
				return mid;
			}
			else if(num > arr[mid]){
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
}
