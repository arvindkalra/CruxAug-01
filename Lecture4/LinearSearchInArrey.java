package Lecture4;

import java.util.Scanner;

public class LinearSearchInArrey {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		System.out.println("Item To Be Searched");
		int item = scn.nextInt();
		int placevalue = linearSearch(arr, item);
		if (placevalue==-1){
			System.out.println("Item Does Not Exist");
		}
		else {
			System.out.println("Item Exists at " +placevalue+ "th place of Array");
		}
	}

	public static int[] takeInput() {
		int[] retval;
		System.out.println("Please Enter The No. Of Items ");
		int N = scn.nextInt();
		retval = new int[N];
		int i = 1;
		while (i <= N) {
			System.out.println("Please Enter " + i + "th Element");
			retval[i - 1] = scn.nextInt();
			i = i + 1;
		}
		return retval;

	}

	public static int linearSearch(int[] xyz, int j) {
		int retval = -1;
		for (int i=0; i<xyz.length; i++){
			if (xyz[i]== j){
				retval = i+1;
			}
		}
		return retval;
	}

	
}